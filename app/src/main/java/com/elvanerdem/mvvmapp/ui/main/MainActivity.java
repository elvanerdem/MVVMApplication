package com.elvanerdem.mvvmapp.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.elvanerdem.mvvmapp.BR;
import com.elvanerdem.mvvmapp.R;
import com.elvanerdem.mvvmapp.data.model.Project;
import com.elvanerdem.mvvmapp.databinding.ActivityMainBinding;
import com.elvanerdem.mvvmapp.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;


public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator {

    @Inject
    MainViewModel mMainViewModel;

    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        return mMainViewModel;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainViewModel.setNavigator(this);

        observeViewModel(mMainViewModel);
    }

    private void observeViewModel(MainViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getProjectListObservable().observe(this, new Observer<List<Project>>() {
            @Override
            public void onChanged(@Nullable List<Project> projects) {
                if (projects != null) {
                    Log.d("test", String.valueOf(projects.size()));
                    //binding.setIsLoading(false);
                    //projectAdapter.setProjectList(projects);
                }
            }
        });
    }

    @Override
    public void handleError() {

    }
}
