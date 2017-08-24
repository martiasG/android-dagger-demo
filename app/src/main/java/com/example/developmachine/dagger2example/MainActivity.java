package com.example.developmachine.dagger2example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import ApplicationCustom.BaseApplication;
import dtos.UserDto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.UserServiceInterface;

public class MainActivity extends AppCompatActivity {
    private TextView mid;
    private TextView mName;

    @Inject
    protected UserServiceInterface mUserService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((BaseApplication) getApplication()).createServicesComponent().inject(this);

        mid = (TextView)findViewById(R.id.userId);
        mName = (TextView)findViewById(R.id.userName);

        mUserService.getUserAll(2).enqueue(new Callback<UserDto>() {
            @Override
            public void onResponse(Call<UserDto> call, Response<UserDto> response) {
                mid.setText(response.body().getId());
                mName.setText(response.body().getFirstname()+" "+response.body().getLastname());
                Log.d("retrofit", response.toString());
            }

            @Override
            public void onFailure(Call<UserDto> call, Throwable t) {
                Log.d("retrofit", t.getLocalizedMessage());
            }
        });

        mUserService.getAllUsers().enqueue(new Callback<List<UserDto>>() {
            @Override
            public void onResponse(Call<List<UserDto>> call, Response<List<UserDto>> response) {
                Log.d("retrofit", response.toString());
            }

            @Override
            public void onFailure(Call<List<UserDto>> call, Throwable t) {
                Log.d("retrofit", t.getLocalizedMessage());
            }
        });
    }
}
