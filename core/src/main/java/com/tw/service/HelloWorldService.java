package com.tw.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by hgwang on 7/9/15.
 */
@Service
public class HelloWorldService {


    public String getDesc() {

        return "Gradle + Spring MVC Hello World Example";
    }

    public String getTitle(String name) {

        if(StringUtils.isEmpty(name)){
            return "Hello World";
        }else{
            return "Hello " + name;
        }
    }
}
