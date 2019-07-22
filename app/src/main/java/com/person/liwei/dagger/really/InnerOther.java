package com.person.liwei.dagger.really;

import javax.inject.Inject;

public class InnerOther {

    @Inject
    public InnerOther() {
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
