package test.com.liverecycler.di;

import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import test.com.liverecycler.viewmodel.ProjectViewModelFactory;
import test.com.liverecycler.service.repository.UserService;

@Module(subcomponents = ViewModelSubComponent.class)
class AppModule {
    @Singleton
    @Provides
    UserService provideGithubService() {
        return new Retrofit.Builder()
                .baseUrl(UserService.HTTPS_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UserService.class);
    }


    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(ViewModelSubComponent.Builder viewModelSubComponent) {
        return new ProjectViewModelFactory(viewModelSubComponent.build());
    }
}