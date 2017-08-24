package services;

import java.util.List;

import javax.inject.Singleton;

import dagger.Component;
import dtos.UserDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by vm on 8/21/17.
 */

public interface UserServiceInterface {
    @GET("/people/{userId}")
    Call<UserDto> getUserAll(@Path(value = "userId", encoded = true) Integer id);

    @GET("/people")
    Call<List<UserDto>> getAllUsers();
}
