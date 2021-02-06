package com.jojoIdu.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombok_test(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); // assertj라는 테스트 검증 라이브러리의 검증 메소드. 파라미터로 검증 대상을 받음.
        // isEqualTo는 동등 비교 메소드.
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
