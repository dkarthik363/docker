package com.apple.dockerizationapple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/apple")
public class CartController {

    HashMap <Integer,String>hm=new HashMap();

    @Autowired(required = true)
    AppleProduct ap;

    @GetMapping("/data/{id}")
    public String  getData(@PathVariable("id") int id){
        System.out.println("Fetching prod details with ID : "+id);
        if(!hm.containsKey(id))
            return "given order id not present";
        return hm.get(id);
    }

    @PostMapping("/addprod")
    public HashMap <Integer,String> postData(@RequestBody AppleProduct ap){
        hm.put(ap.getId(),ap.getName());
        System.out.println("Inserted");
        return hm;
    }

    @PutMapping("/update")
    public HashMap <Integer,String> updateData(@RequestBody AppleProduct ap){
        hm.put(ap.getId(),ap.getName());
        return hm;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteData(@PathVariable("id") int id){
        hm.remove(id);
        return "deleted  the product with id "+id;
    }

}
