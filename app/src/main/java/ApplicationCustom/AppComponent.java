package ApplicationCustom;

import javax.inject.Singleton;

import dagger.Component;
import services.ServicesComponent;
import services.ServicesModule;

/**
 * Created by developmachine on 24/08/17.
 */

@Singleton
@Component(modules = {
        AppModule.class})
public interface AppComponent
{
    ServicesComponent plus(ServicesModule servicesModule);
}