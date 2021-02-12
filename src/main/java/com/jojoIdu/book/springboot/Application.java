package com.jojoIdu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화. JPA Auditing: https://webcoding-start.tistory.com/53
@SpringBootApplication // 스프링 부트 자동 설정, 스프링 Bean 읽기와 생성이 모두 자동.
// 이 애노테이션이 있는 위치부터 설정을 읽어나가므로 이 클래스는 항시 프로젝트 최상단에 위치해야만 한다.
public class Application { // 프로젝트의 메인 클래스.
    public static void main(String[] args){
        SpringApplication.run(Application.class, args); // 내장 WAS(Web Application Server) 실행.
    }
}
