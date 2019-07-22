package com.person.liwei.dagger.test;

import java.util.Map;

import javax.inject.Inject;

public class Chef implements Cooking {

    private Menu mMenu;

    @Inject
    public Chef(Menu menu) {
        mMenu = menu;
    }

    @Override
    public String cook() {

        //key菜名 value是
        Map<String, Boolean> menuMap = mMenu.getMap();
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Boolean> booleanEntry : menuMap.entrySet()) {
            if(booleanEntry.getValue()) {
                stringBuilder.append(booleanEntry.getKey()).append(",");
            }
        }
        return stringBuilder.toString();
    }
}
