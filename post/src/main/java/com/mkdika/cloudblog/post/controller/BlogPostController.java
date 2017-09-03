package com.mkdika.cloudblog.post.controller;

import com.mkdika.cloudblog.post.client.TagServiceClient;
import com.mkdika.cloudblog.post.model.Blogpost;
import com.mkdika.cloudblog.post.repository.BlogPostRepository;
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
    
    @Autowired
    private TagServiceClient tagService;

    @RequestMapping(method = GET)
    public List<Blogpost> getCustomers() {
       List<Blogpost> list = (List<Blogpost>) repository.findAll();
       if (list.size() > 0) {
           list.forEach((b) -> {
               b.setTags(tagService.getTagsByPost(b.getId()));
           });
       }
       return list;
    }
}
