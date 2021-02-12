package com.jojoIdu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // 테스트 시 JUnit 내장 실행자 외 다른 실행자를 실행시킴. 여기선 SpringRunner 스프링 실행자 사용.
@WebMvcTest(controllers = HelloController.class) // Web 에 집중할 수 있는 애노테이션. @Controller, @ControllerAdvice 등을 사용 가능.
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈(Bean)을 주입.
    private MockMvc mvc; // 웹 API 테스트 시 사용. 스프링 MVC 테스트 시작점. HTTP GET, POST 등에 대한 API 테스트를 할 수 있다.

    @Test // 테스트 메소드 지정. https://galid1.tistory.com/476
    public void hello_return() throws Exception { // 이 코드 실행이 곧 테스트를 하는 것이다.
        String hello = "hello";

        mvc.perform(get("/hello")) // HTTP GET 요청
                .andExpect(status().isOk()) // mvc.perform 결과 검증. HTTP Header의 Status(200,404,500 등) 검증. OK는 200을 뜻함. 즉, 200인지 검증.
                .andExpect(content().string(hello)); // mvc.perform 결과 검증. 응답 본문의 내용을 검증. Controller 리턴값이 hello 인지 검증.
    }

    @Test
    public void helloDto_return() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                .param("name", name) // API 테스트 시 사용될 요청 파라미터를 설정. 단, 값은 String 만 허용.
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //jsonPath는 JSON 응답값을 필드별로 검증할 수 있다. $를 기준으로 필드명을 명시한다.
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}
