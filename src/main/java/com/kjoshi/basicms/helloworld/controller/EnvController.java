package com.kjoshi.basicms.helloworld.controller;

import com.kjoshi.basicms.helloworld.bean.KeyValueBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/env")
public class EnvController {

    private static final Logger logger = LoggerFactory.getLogger(EnvController.class);

    @RequestMapping("/")
    public List<KeyValueBean> getAllEnvVariables(){
        logger.info("Env Called");
        List<KeyValueBean> retList = new ArrayList<>();
        if(System.getenv()!=null){
            Map<String,String> envMap = System.getenv();
            envMap.keySet().stream().filter(x->x.startsWith("APP_")||x.toUpperCase(Locale.ROOT).startsWith("SPRING")).forEach(x->retList.add(new KeyValueBean(x,envMap.get(x))));
        }
        return retList;
    }
}