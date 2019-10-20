package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest() {
        return "Hello getMethod";
    }

    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd) {

        String password = "bbb";
        System.out.println("id: " + id);
        System.out.println("pwd: " + pwd);

        return id+pwd;
    }

    @GetMapping("/getMultiParameter")   // localhost:8080/api/getMultiParameter?account=study&email=study@studyhard.com&page=3
    public SearchParam multiParameter(SearchParam searchParam){
//        System.out.println(searchParam.getAccount());
//        System.out.println(searchParam.getEmail());
//        System.out.println(searchParam.getPage());

        return searchParam;
    }
}
