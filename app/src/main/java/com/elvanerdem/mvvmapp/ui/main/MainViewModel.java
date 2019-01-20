package com.elvanerdem.mvvmapp.ui.main;

import android.app.Application;

import com.elvanerdem.mvvmapp.data.remote.ProjectRepository;
import com.elvanerdem.mvvmapp.data.model.Project;
import com.elvanerdem.mvvmapp.ui.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

public class MainViewModel extends BaseViewModel<MainNavigator> {

    private final LiveData<List<Project>> projectListObservable;

    @Inject
    public MainViewModel(@NonNull ProjectRepository projectRepository, @NonNull Application application) {
        super();
        projectListObservable = projectRepository.getProjectList("Google");
    }

    public LiveData<List<Project>> getProjectListObservable() {
        return projectListObservable;
    }

}
