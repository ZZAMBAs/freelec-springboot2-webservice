package com.jojoIdu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 클래스 내 선언된 모든 필드의 get 메소드 추가
@RequiredArgsConstructor // 필드 중 final 필드 전부를 포함하는 생성자를 생성해줌.
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
