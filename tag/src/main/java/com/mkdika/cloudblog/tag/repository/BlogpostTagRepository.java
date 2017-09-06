package com.mkdika.cloudblog.tag.repository;

import com.mkdika.cloudblog.tag.model.BlogpostTag;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
public interface BlogpostTagRepository extends CrudRepository<BlogpostTag, Integer>{    
    
    public List<BlogpostTag> findByPostId(Integer postid);    
}
