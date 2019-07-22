package com.person.liwei.dagger.test;


import dagger.Component;

@Component(modules = CookModules.class)
public interface CookComponent {

    void injectA(DaggerTestActivity activity);
}
