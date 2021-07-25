package com.example.study.controller;

import com.example.study.model.SearchParam;
import com.example.study.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") // localhost:8080/api/getMethod
    public String getRequest() {
        return "Hi getMethod";
    }

    /*
    method 지역변수에 get으로 받아오는 인자와 같은 변수를 써야하는 경우 @RequestParam의 name을 이용한다.
    하지만, 이 방법은 비추천이므로 반드시 필요한 경우가 아니라면 사용하지 않는다.
     */
    @GetMapping("/getParameter") // localhost:8080/getParameter?id=1234&password=abcd
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd) {
        String password = "default";
        System.out.println("id: " + id + " password: " + pwd);
        return id + pwd;
    }

    /*
    Parameter가 많은 경우 처리방법
    localhost:8080/api/multiParameter?account=abc&email=lee@kt.com&page=10
    스프링 부트에서 http 통신은 json형식으로 규격이 되어 있기때문에 객체를 반환하면 자동으로 json으로 반환한다.
     */
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam) {
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        // Json 형태로 데이터를 주고 받음
        // { "account" : "", "email" : "", "page" : 0 }
        return searchParam;
    }

    @GetMapping("/header")
    public Header getHeader() {

        // {"resultCode : "OK", "description : "OK" }
        return Header.builder().resultCode("OK").description("OK").build();
    }
}
