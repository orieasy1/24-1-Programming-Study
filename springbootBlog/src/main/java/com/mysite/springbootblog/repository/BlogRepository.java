package com.mysite.springbootblog.repository;

import com.mysite.springbootblog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long>{
}
