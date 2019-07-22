package com.person.liwei.dagger.really;

import javax.inject.Inject;

public class Inner {

    @Inject
    public Inner() {
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
