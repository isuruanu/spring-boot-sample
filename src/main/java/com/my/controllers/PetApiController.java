package com.my.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by isuru on 6/29/2016.
 */
@Controller
@Component
public class PetApiController {

    @RequestMapping(method = RequestMethod.GET, path = "/")
    @ResponseBody
    public String hello() {
        return "Hello World !!!";
    }
}
