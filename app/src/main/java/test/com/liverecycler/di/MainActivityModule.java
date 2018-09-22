package test.com.liverecycler.di;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import test.com.liverecycler.view.MainActivity;

/**
 * Created by william on 22-09-2018.
 */

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector()
    abstract MainActivity contributeMainActivity();
}