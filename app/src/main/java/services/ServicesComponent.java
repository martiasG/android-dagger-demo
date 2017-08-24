package services;

import com.example.developmachine.dagger2example.MainActivity;

import dagger.Subcomponent;

/**
 * Created by developmachine on 24/08/17.
 */
@Subcomponent(modules = {ServicesModule.class})
public interface ServicesComponent
{
    void inject(MainActivity target);
}