package com.apple.dockerizationapple;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
public class RestTemplateDemo {

    @GetMapping("/appleinfo")
    public AppleProduct getAppleInfo(){
        System.out.println("im in server");
        RestTemplate temp=new RestTemplate();
        AppleProduct ap=temp.getForObject("http://localhost:8081/apple/data",AppleProduct.class);
        return ap;
    }


}
