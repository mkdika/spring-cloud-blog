package com.mkdika.cloudblog.post.repository;

import com.mkdika.cloudblog.post.model.Blogpost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
@Repository
public interface BlogPostRepository extends CrudRepository<Blogpost, Integer> {            
}
