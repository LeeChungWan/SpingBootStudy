package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

/*
 class에 대한 RequestMapping은 주소가 같아도 가능하지만 메소드는 불가능하다.

 POST 사용하는 곳
 HTML <Form>
 ajax
 http post body -> data
 json, xml, multipart-form / text-plain

 REST의 개념
 GET / 조회
 POST / 생성
 PUT, PATCH / 수정
 DELETE / 삭제

 */
@RestController
@RequestMapping("/api")
public class PostController {

    // 두가지 mapping은 같은 의미
//    @RequestMapping(method = RequestMethod.POST, path = "/postMethod")
    @PostMapping(value = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
        return searchParam;
    }

    @PutMapping("/putMethod")
    public void put() {

    }

    @PatchMapping("/patchMethod")
    public void patch(){

    }

}
