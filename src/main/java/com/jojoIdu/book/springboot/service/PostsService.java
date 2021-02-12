package com.jojoIdu.book.springboot.service;

import com.jojoIdu.book.springboot.domain.posts.Posts;
import com.jojoIdu.book.springboot.domain.posts.PostsRepository;
import com.jojoIdu.book.springboot.web.dto.PostsListResponseDto;
import com.jojoIdu.book.springboot.web.dto.PostsResponseDto;
import com.jojoIdu.book.springboot.web.dto.PostsSaveRequestDto;
import com.jojoIdu.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
    // JPA의 영속성 컨텍스트로 update 쿼리를 날리는 구문을 쓰지 않아도 데이터를 가져온 상태에서 값을 변경하면 자동으로 업데이트 한다. (더티 체킹)
    // 더티 체킹: https://jojoIdu.tistory.com/415

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true) // 트랜잭션 범위는 유지하되 조회기능만 남겨 조회속도 향상.
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
        // map(PostsListResponseDto::new) == map(posts -> new PostsListResponseDto(posts)). 람다식임.
        // Posts의 Stream을 map을 통해 PostsListResponseDto로 변환 -> List로 반환함.
    }
}
