package cc.haoduoyu.blog.controller;

import cc.haoduoyu.blog.exception.CustomException;
import cc.haoduoyu.blog.model.Blog;
import cc.haoduoyu.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/blog")
public class BlogController {
    @Autowired
    private BlogRepository blogRepository;

    @GetMapping(path = "/blogs") // Map ONLY POST Requests
    public @ResponseBody
    Iterable<Blog> getBlogs(
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "5", required = false) Integer limit) {
        Pageable pageable = PageRequest.of(page, limit);
        Iterable<Blog> blogs = blogRepository.findAll(pageable);
        System.out.println(blogs);
        return blogs;
    }

    @GetMapping(path = "/blog/{id}")
    public @ResponseBody
    Blog getBlog(@PathVariable("id") Integer id) {
        return blogRepository.getOne(id);
    }

    @GetMapping(path = "/blog/hottest")
    public @ResponseBody
    Iterable<Blog> getHottestBlog(@RequestParam int page, @RequestParam int limit) {
        return blogRepository.findAll(Sort.by("visits"));
    }

    @PostMapping(path = "/blog/{id}")
    public @ResponseBody
    String updateBlog(@PathVariable("id") Integer id, @RequestParam String title) {
        Blog blog = new Blog();
        blog.setId(id);
        blog.setTitle(title);
        blogRepository.save(blog);
        return "Saved";
    }

    @PostMapping(path = "/blog/{id}/visit")
    public @ResponseBody
    String visit(@PathVariable("id") Integer id) {
        Blog blog = blogRepository.getOne(id);
        blog.setVisits(blog.getVisits() + 1);
        blogRepository.save(blog);
        return "Saved";
    }
}

