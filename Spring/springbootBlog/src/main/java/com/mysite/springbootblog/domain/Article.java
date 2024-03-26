package com.mysite.springbootblog.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {
    @Id //해당 필드가 엔티티의 primary key임을 나타냄, db에서 식별하는데 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY) //primary key값을 어떻게 생성할지 지정, 자동증가 기능 사용하여 값 생성
    @Column(name = "id", updatable = false) //db 테이블을 열과 매핑 됨, id열이 생성된 후에는 업데이트 할 수 없도록 설정
    private Long id;

    @Column(name = "title" , nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder //빌더 패턴으로 객체 생성
    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
