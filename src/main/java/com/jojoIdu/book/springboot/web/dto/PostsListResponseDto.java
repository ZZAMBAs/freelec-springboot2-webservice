package com.jojoIdu.book.springboot.web.dto;

import com.jojoIdu.book.springboot.domain.posts.Posts;
import lombok.Getter;
import java.time.LocalDateTime; // 기존 Date 클래스를 보완한 클래스.

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
