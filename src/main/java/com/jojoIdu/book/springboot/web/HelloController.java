package com.jojoIdu.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러로 반환
public class HelloController {

    @GetMapping("/hello") // ()내 주소로부터 GET 요청을 받을 수 있는 API를 만듦.
    public String hello(){
        return "hello"; // /hello 로 요청이 오면 hello 를 반환함.
    }
}
