package com.person.liwei.dagger.simple;

import dagger.Module;
import dagger.Provides;

@Module
public class DaggerModule {


    private IDaggerView mDaggerView;

    public DaggerModule(IDaggerView daggerView) {
        mDaggerView = daggerView;
    }

    @Provides
    @ActivityScope
    public IDaggerView provideIDaggerView(){

        return mDaggerView;
    }
}
