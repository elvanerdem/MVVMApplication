package com.elvanerdem.mvvmapp.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.elvanerdem.mvvmapp.BR;
import com.elvanerdem.mvvmapp.R;
import com.elvanerdem.mvvmapp.ui.base.BaseActivity;
import com.elvanerdem.mvvmapp.databinding.ActivityMainBinding;

import javax.inject.Inject;


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
    }

    @Override
    public void handleError() {

    }
}
