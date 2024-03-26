package com.mysite.springbootblog.dto;

import com.mysite.springbootblog.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntitly() {
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
