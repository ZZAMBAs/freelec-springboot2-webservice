package com.jojoIdu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> { // DB Layer 접근자
    // Entity 클래스와 기본 Entity Repository는 함께 위치해야 함.
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC") // SpringDataJpa 에서 제공하지 않는 메소드는 쿼리로 써도 된다.
    List<Posts> findAllDesc();
}
