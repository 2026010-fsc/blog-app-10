package com.example.blog_app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }


    @GetMapping("/blogs")
    public String blogs(Model model) {
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs", blogs);
        return "blogs"; 
    }

    @GetMapping("/Pos")
    public String Pos() {
        return "Pos"; 
    }

    @PostMapping("/blogs")
    public String createBlog(@RequestParam("title") String title, @RequestParam("content") String content) {
        blogService.save(title, content);
        return "redirect:/blogs";
    }

    @GetMapping("/blogs/{id}")
    public String record(@PathVariable("id") Long id, Model model) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return "redirect:/blogs";
        }
        
        model.addAttribute("blog", blog);
        return "record"; 
    }
}