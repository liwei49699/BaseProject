package com.person.liwei.dagger.simple;


import dagger.Component;

@ActivityScope
@Component(modules = DaggerModule.class)
public interface DaggerComponent {

   void inject(DaggerUseActivity daggerUseActivity);
}
