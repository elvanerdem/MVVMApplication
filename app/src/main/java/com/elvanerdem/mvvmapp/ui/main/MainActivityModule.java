package com.elvanerdem.mvvmapp.ui.main;

import android.app.Application;

import com.elvanerdem.mvvmapp.data.remote.ProjectRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    MainViewModel provideMainViewModel(ProjectRepository projectRepository, Application application) {
        return new MainViewModel(projectRepository, application);
    }

}
