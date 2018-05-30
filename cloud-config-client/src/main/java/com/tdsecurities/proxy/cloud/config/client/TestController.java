/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdsecurities.proxy.cloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bhattp7
 */
@RestController
@RequestMapping(value = "/name")
public class TestController {

    @Value("${spring.datasource.firstName}")
    private String firstName;

    @Value("${spring.datasource.lastName}")
    private String lastName;

    @GetMapping
    public Object getData() {
        System.out.println("COMING HERE " + firstName);
        return firstName + lastName;
    }
}
