package com.jojoIdu.book.springboot.domain.posts;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // jUnit에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정. 보통 전체 테스트 수행 시 테스트간 데이터 침범을 막기 위함.
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void postSave_road(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder().title(title).content(content).author("jojoIdu@gmail.com").build());
        // 테이블 posts에 insert/update 쿼리를 실행. id 값이 있으면 update, 없으면 insert 쿼리가 실행됨.

        //when
        List<Posts> postsList = postsRepository.findAll(); // 테이블 posts에 있는 모든 데이터를 조회해오는 메소드.

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
