/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pankaj.cloud.eureka;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author BHATTP7
 */
@Service
public class LicenseService {

    @Autowired
    public RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getOldOrgDetails")
    public String getOrgDetails(String orgId) {
        randomRunLong();

        ResponseEntity<String> restExchange = restTemplate.getForEntity("http://ORGANIZATIONSERVICE/org/" + orgId, String.class);
        return restExchange.getBody();
    }

    private void randomRunLong() {
        Random random = new Random();
        int randomNum = random.nextInt((3 - 1) + 1) + 1;

        if (randomNum == 3) {
            sleep();
        }

    }

    public String getOldOrgDetails(String orgId) {
        return "OLD Data : " + orgId;
    }

    private void sleep() {
        try {
            Thread.sleep(11000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
