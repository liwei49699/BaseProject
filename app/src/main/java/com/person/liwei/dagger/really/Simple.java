package com.person.liwei.dagger.really;

import javax.inject.Inject;

public class Simple {

    @Inject
    public Simple() {
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
