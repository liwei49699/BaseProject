package com.person.liwei.dagger.really;

import dagger.Module;
import dagger.Provides;

@Module
public class ProvideModel {

    @Provides
    public ComeOn getString(){

        return new ComeOn("提供一个构造器");
    }
}
