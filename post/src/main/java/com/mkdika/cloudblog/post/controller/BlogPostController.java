package com.mkdika.cloudblog.post.controller;

import com.mkdika.cloudblog.post.model.Blogpost;
import com.mkdika.cloudblog.post.repository.BlogPostRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
@RestController
@RequestMapping("/api/post")
public class BlogPostController {
    
    @Autowired
    private BlogPostRepository repository;
    
    @RequestMapping(method = GET, value = "/test")
    public List<Blogpost> getTest() {
        Blogpost b = new Blogpost(1, "Spring 5", "bla..bla..", new Date(), new Date());
        List<Blogpost> list = new ArrayList<>();
        list.add(b);
        return list;
    }    
    
    @RequestMapping(method = GET)
    public List<Blogpost> getCustomers() {
       return (List<Blogpost>) repository.findAll();
    }      
}
