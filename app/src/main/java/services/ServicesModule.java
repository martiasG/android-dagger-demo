package services;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vm on 8/21/17.
 */

@Module
public class ServicesModule {

    @Provides
    static UserServiceInterface buildUserServices(){
        return new Retrofit
                .Builder()
                .baseUrl("http://192.168.0.5:12345")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UserServiceInterface.class);
    }
}
