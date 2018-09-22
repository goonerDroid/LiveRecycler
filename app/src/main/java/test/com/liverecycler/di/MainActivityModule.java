package test.com.liverecycler.di;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import test.com.liverecycler.view.MainActivity;

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector()
    abstract MainActivity contributeMainActivity();
}