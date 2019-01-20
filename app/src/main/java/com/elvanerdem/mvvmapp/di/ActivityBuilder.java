package com.elvanerdem.mvvmapp.di;

import com.elvanerdem.mvvmapp.ui.main.MainActivity;
import com.elvanerdem.mvvmapp.ui.main.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();
}
