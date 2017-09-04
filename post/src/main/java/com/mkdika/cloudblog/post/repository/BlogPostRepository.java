package com.mkdika.cloudblog.post.repository;

import com.mkdika.cloudblog.post.model.Blogpost;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
public interface BlogPostRepository extends CrudRepository<Blogpost, Integer> {   
}
