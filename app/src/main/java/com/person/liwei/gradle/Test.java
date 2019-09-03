package com.person.liwei.gradle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019-08-16 12:40
 * Description:gradle测试文件 不参与编译
 *
 * @author LiGuangwei
 */
public class Test {


    private void test(List<?> list){
        List<String> objectList = new ArrayList<>();
        objectList.add("");

        test(objectList);
    }
}
