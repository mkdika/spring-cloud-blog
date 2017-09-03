package com.mkdika.cloudblog.tag.controller;

import com.mkdika.cloudblog.tag.repository.BlogpostTagRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
@RestController
@RequestMapping("/api/tag")
public class BlogpostTagController {
    
    @Autowired
    private BlogpostTagRepository repository;
    
    @RequestMapping(method = GET, value = "/post/{postid}")
    public List<String> getTagsByPost(@PathVariable Integer postid) {
        return (repository.findByPostId(postid))
                .stream()
                .map(b -> b.getTag())
                .collect(Collectors.toList());
    }    
}
