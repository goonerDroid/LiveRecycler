package test.com.liverecycler.di;

import dagger.Subcomponent;
import test.com.liverecycler.viewmodel.UserViewModel;


@Subcomponent
public interface ViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    UserViewModel userViewModel();
}