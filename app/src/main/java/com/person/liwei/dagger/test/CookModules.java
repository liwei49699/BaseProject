package com.person.liwei.dagger.test;

import java.util.HashMap;
import java.util.Map;


import dagger.Module;
import dagger.Provides;

@Module
public class CookModules {

//    @Singleton
    @Provides
    public Map<String,Boolean> providerMenusMap(){

        Map<String,Boolean> booleanMap = new HashMap<>();
        booleanMap.put("青椒肉丝",true);
        booleanMap.put("鸡蛋炒蛋",false);
        booleanMap.put("黄瓜炒火腿",true);
        return booleanMap;
    }

    @Provides
    public Menu providerMenus(Map<String,Boolean> booleanMap){

        return new Menu(booleanMap);
    }

    @Provides
    public Chef provideChef(Menu menu){

        return new Chef(menu);
    }
}
