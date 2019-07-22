package com.person.liwei.dagger.really;

import dagger.Component;

@Component(modules = ProvideModel.class)
//@Component
public interface ReallyComponent {

    void injectR(DaggerReallyActivity activity);
//    Really getReally();
    Outer getOuter();
    ComeOn getComeOn();
}
