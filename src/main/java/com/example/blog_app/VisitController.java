package com.example.blog_app;

import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class VisitController {
    @GetMapping("/visit")
    public String visit(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 0;
        }

        count++;
        session.setAttribute("count", count);
        return "訪問回数" + count;
    }
    
}

// 1.ブログ記事を一覧で閲覧できる
// 2.記事を一件ずつ個別に閲覧できる
// 3.新しい記事を投稿できる
// 4.すべてのページに共通のナビゲーションがある
