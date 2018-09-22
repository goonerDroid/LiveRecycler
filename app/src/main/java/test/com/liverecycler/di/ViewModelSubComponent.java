package test.com.liverecycler.di;

import dagger.Subcomponent;
import test.com.liverecycler.viewmodel.UserViewModel;

/**
 * Created by william on 22-09-2018.
 */


@Subcomponent
public interface ViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    UserViewModel userViewModel();
}