/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pankaj.cloud.eureka;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bhattp7
 */
@RestController
@RequestMapping(path ="/org")
public class OrganziationController {
    
    @GetMapping(path = "/{orgId}")
    public String getLicenseOfOrg(@PathVariable String orgId) {
        
        System.out.println("Organization Controller ORG ID = " + orgId); 
        return "Pankaj -  " + orgId; 
        
        
    }
    
    
}
