package com.mkdika.cloudblog.post.client;

import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
@FeignClient(name = "tag-service")
public interface TagServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/tag/post/{postid}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<String> getTagsByPost(@PathVariable("postid") Integer postId);
}
