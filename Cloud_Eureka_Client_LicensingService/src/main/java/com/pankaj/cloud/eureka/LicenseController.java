/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pankaj.cloud.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author bhattp7
 */
@RestController
@RequestMapping(path = "/license")
public class LicenseController {

    @Autowired
    public RestTemplate restTemplate;
    
    @Autowired
    public LicenseService licenseService; 

    @GetMapping(path = "/{orgId}")
    public String getLicenseOfOrg(@PathVariable String orgId) {

        System.out.println("ORG ID = " + orgId);
        return "Organization : " + orgId + "  info from ORGANIZATION service  : " + getOrgDetails(orgId); 
    }
    
    
    
     @GetMapping(path = "/{orgId}/hysterix")
    public String getLicenseOfOrgWithHysterix(@PathVariable String orgId) {

        System.out.println("ORG ID = " + orgId);
        return "Organization : " + orgId + "  info from ORGANIZATION service  : " + licenseService.getOrgDetails(orgId); 

    }

    public String getOrgDetails(String orgId) {

        ResponseEntity<String> restExchange = restTemplate.getForEntity("http://ORGANIZATIONSERVICE/org/" + orgId, String.class);
        return restExchange.getBody();

    }

}
