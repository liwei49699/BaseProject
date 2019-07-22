package com.person.liwei.dagger.test;

import java.util.Map;

import javax.inject.Inject;

public class Menu {

    private Map<String,Boolean> mMap;

    @Inject
    public Menu(Map<String, Boolean> map) {
        mMap = map;
    }

    public Map<String, Boolean> getMap() {
        return mMap;
    }
}
