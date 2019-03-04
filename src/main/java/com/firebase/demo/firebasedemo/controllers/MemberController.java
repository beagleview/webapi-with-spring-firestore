package com.firebase.demo.firebasedemo.controllers;

import com.firebase.demo.firebasedemo.models.Member;
import com.firebase.demo.firebasedemo.services.FireBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class MemberController {

    @Autowired
    FireBaseService fireBaseService;

    @GetMapping(value = "hello")
    String hello(){
        return "Hello, World";
    }

    @PostMapping(value = "add")
    boolean add(@RequestBody Member member){
        fireBaseService.addMember(member);
        return  true;
    }
}
