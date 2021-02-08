package com.jojoIdu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // (롬복) 클래스 내 모든 필드 Getter 메소드 생성.
@NoArgsConstructor // (롬복) 기본 생성자 자동 추가.
@Entity // 테이블과 링크될 클래스임을 표시. JPA에선 Entity 애노테이션이 붙은 클래스를 수정함.
// Entity 클래스에선 Setter를 만들지 않으며 set 해야 하는 상황엔 그에 맞는 메소드를 직접 만들어서 직접 변경함. 첫 초기화는 생성자로 수행.(여기선 빌더로 수행. 빌더의 장점 때문. 아래 빌더 패턴 참조.)
public class Posts { // 실제 DB 테이블과 매칭될 클래스.
    @Id // Primary Key를 지칭.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규칙을 나타냄. GenerationType.IDENTITY는 스프링부트 2.0에서 auto_increment를 칭함.
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 칼럼을 표시.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // (롬복) 해당 클래스의 빌더 패턴 클래스를 생성. 생성자 상단에 선언 시, 생성자에 포함된 필드만 빌드에 포함.
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    } // 빌더 패턴 : https://readystory.tistory.com/121 , https://jdm.kr/blog/217
}
