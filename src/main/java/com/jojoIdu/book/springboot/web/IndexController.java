package com.jojoIdu.book.springboot.web;

import com.jojoIdu.book.springboot.config.auth.LoginUser;
import com.jojoIdu.book.springboot.config.auth.dto.SessionUser;
import com.jojoIdu.book.springboot.service.PostsService;
import com.jojoIdu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){ // Model은 서버 템플릿 엔진(JSP 등)에서 사용할 수 있는 객체를 저장할 수 있다.
        // 세션을 계속 가져오도록 코드를 짜는게 아닌, LoginUser 어노테이션으로 한방에 처리
        model.addAttribute("posts", postsService.findAllDesc());
        // posts에 postService.findAllDesc로 가져온 결과를 넣고 index.mustache에 전달.

        if (user != null){ // 세션에 값이 있을 때만 model에 userName으로 등록함.
            model.addAttribute("userName", user.getName());
        }

        return "index"; // 이 때 리턴 값.mustache 를 리턴하도록 하며 이를 호출함.
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save"; // 이 때 리턴 값.mustache 를 리턴하도록 하며 이를 호출함.
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
