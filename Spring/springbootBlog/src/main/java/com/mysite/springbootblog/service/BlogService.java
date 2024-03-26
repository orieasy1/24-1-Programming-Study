package com.mysite.springbootblog.service;

import com.mysite.springbootblog.domain.Article;
import com.mysite.springbootblog.dto.AddArticleRequest;
import com.mysite.springbootblog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor //final이 붙거나 @NotNull이 붙은 필드의 생성자 추가

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    //블로그 글 추가 메소드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntitly());
    }
}
