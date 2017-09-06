package com.mkdika.cloudblog.tag.controller;

import com.mkdika.cloudblog.tag.model.BlogpostTag;
import com.mkdika.cloudblog.tag.repository.BlogpostTagRepository;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
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
@RequestMapping("/api/tag")
public class BlogpostTagController {

    @Autowired
    private BlogpostTagRepository repository;

    @ApiOperation(
            value = "Get blog post tag by post ID.",
            notes = "Not available.",
            produces = "application/json")
    @RequestMapping(method = GET, value = "/post/{postid}")
    public ResponseEntity getTagsByPost(@PathVariable Integer postid) {
        List<String> list = (repository.findByPostId(postid))
                .stream()
                .map(b -> b.getTag())
                .collect(Collectors.toList());
        if (list != null && list.size() > 0) {
            return new ResponseEntity(list, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
    @ApiOperation(
            value = "Retrieve all post tag.",
            notes = "Not available.",
            produces = "application/json")
    @RequestMapping(method = GET)
    public ResponseEntity getBlogposts() {
        List<BlogpostTag> list = (List<BlogpostTag>) repository.findAll();
        if (list.size() > 0) {
            return new ResponseEntity(list, HttpStatus.OK);            
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(
            value = "Retrieve blog post by ID.",
            notes = "Not available.",
            produces = "application/json")
    @RequestMapping(method = GET, value = "/{id}")
    public ResponseEntity getBlogpostById(@PathVariable Integer id) {
        BlogpostTag tag = repository.findOne(id);
        if (tag != null) {            
            return new ResponseEntity(tag, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(
            value = "Create or Update blog Tag.",
            notes = "Not available.",
            produces = "application/json")
    @RequestMapping(method = {POST, PUT})
    public ResponseEntity addUpdateTag(@Valid @RequestBody BlogpostTag tag) {
        try {
            repository.save(tag);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation(
            value = "Delete blog Tag by ID.",
            notes = "Not available.",
            produces = "application/json")
    @RequestMapping(method = DELETE, value = "/{id}")
    public ResponseEntity deleteBlogpost(@PathVariable Integer id) {
        BlogpostTag tag = repository.findOne(id);
        if (tag != null) {            
            repository.delete(tag);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
