package com.mkdika.cloudblog.post.controller;

import com.mkdika.cloudblog.post.client.TagServiceClient;
import com.mkdika.cloudblog.post.model.Blogpost;
import com.mkdika.cloudblog.post.repository.BlogPostRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
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
    public ResponseEntity getBlogposts() {
        List<Blogpost> list = (List<Blogpost>) repository.findAll();
        if (list.size() > 0) {
            list.forEach((b) -> {
                b.setTags(tagService.getTagsByPost(b.getId()));
            });
            return new ResponseEntity(list, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = GET, value = "/{id}")
    public ResponseEntity getBlogpostById(@PathVariable Integer id) {
        Blogpost blogpost = repository.findOne(id);        
        if (blogpost != null) {
            blogpost.setTags(tagService.getTagsByPost(id));
            return new ResponseEntity(blogpost, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = {POST, PUT})
    public ResponseEntity addUpdateBlogpost(@Valid @RequestBody Blogpost blogpost) {
        try {
            repository.save(blogpost);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = DELETE, value = "/{id}")
    public ResponseEntity deleteBlogpost(@PathVariable Integer id) {
        Blogpost blogpost = repository.findOne(id);
        if (blogpost != null) {
            repository.delete(blogpost);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
