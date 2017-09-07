/*
 * The MIT License
 *
 * Copyright 2017 Maikel Chandika <mkdika@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.mkdika.cloudblog.post.controller;

import com.mkdika.cloudblog.post.client.TagServiceClient;
import com.mkdika.cloudblog.post.model.Blogpost;
import com.mkdika.cloudblog.post.repository.BlogPostRepository;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(
            value = "Retrieve all blog post.",
            notes = "Not available.",
            produces = "application/json")
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

    @ApiOperation(
            value = "Retrieve blog post by ID.",
            notes = "Not available.",
            produces = "application/json")
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

    @ApiOperation(
            value = "Create or Update blog post.",
            notes = "Not available.",
            produces = "application/json")
    @RequestMapping(method = {POST, PUT})
    public ResponseEntity addUpdateBlogpost(@Valid @RequestBody Blogpost blogpost) {
        try {
            repository.save(blogpost);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(
            value = "Delete blog post by ID.",
            notes = "Not available.",
            produces = "application/json")
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
