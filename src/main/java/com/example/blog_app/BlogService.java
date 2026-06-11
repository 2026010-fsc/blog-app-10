package com.example.blog_app;


import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    private final BlogRepository blogRepository;


    public BlogService(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }


    public List<Blog> findAll(){
        return blogRepository.findAll();
    }


    public Blog findById(Long id) {
        return blogRepository.findById(id);
    }


    public void save(String title, String content) {
        Blog blog = new Blog(null, title, content);
        blogRepository.save(blog);
    }
}
