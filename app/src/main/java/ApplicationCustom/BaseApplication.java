package ApplicationCustom;

import android.app.Application;
import android.os.StrictMode;

import services.ServicesComponent;
import services.ServicesModule;

/**
 * Created by developmachine on 24/08/17.
 */

public class BaseApplication  extends Application {
    private AppComponent appComponent;
    private ServicesComponent servicesComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();
        StrictMode.enableDefaults();
        appComponent = createAppComponent();
    }

    private AppComponent createAppComponent()
    {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public ServicesComponent createServicesComponent()
    {
        servicesComponent = appComponent.plus(new ServicesModule());
        return servicesComponent;
    }

    public void releaseDetailsComponent()
    {
        servicesComponent = null;
    }
}
