package com.jojoIdu.book.springboot.web;

import com.jojoIdu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러로 반환
public class HelloController {

    @GetMapping("/hello") // ()내 주소로부터 GET 요청을 받을 수 있는 API를 만듦.
    public String hello(){
        return "hello"; // /hello 로 요청이 오면 hello 를 반환함.
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name1,
                                     @RequestParam("amount") int amount1){ // @RequestParam은 외부에서 API로 넘긴 파라미터를 가져오는 애노테이션이다.
        // 외부에서 @RequestParam의 () 내 이름으로 넘긴 파라미터를 이 메소드 파라미터 이름(여기서의 name1, amount1)에 저장함.
        return new HelloResponseDto(name1, amount1);
    }
}
