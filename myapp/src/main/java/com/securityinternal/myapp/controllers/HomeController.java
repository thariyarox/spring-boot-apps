package com.securityinternal.myapp.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Value("${app.version}")
    private String appversion;

    @GetMapping
    @RequestMapping("/")
    public Map get(){
        Map mymap = new HashMap<String, String>();
        mymap.put("version", appversion);
        return mymap;
    }

}
