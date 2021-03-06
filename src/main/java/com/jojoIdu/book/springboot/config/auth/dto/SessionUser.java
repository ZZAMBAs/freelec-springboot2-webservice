package com.jojoIdu.book.springboot.config.auth.dto;

import com.jojoIdu.book.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable { // 직렬화: https://woowabros.github.io/experience/2017/10/17/java-serialize.html
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
