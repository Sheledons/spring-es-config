package com.kingsoft.servicea.service.feign;

import com.kinsoft.common.entity.Blog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Sheledon
 * @date 2022/4/13
 */
@Service
@FeignClient(name = "BLOG-SERVICE")
public interface FeignBlogService {
    @PostMapping("/blog")
    void saveBlog(@RequestBody Blog blog);

    @GetMapping("/blog/list")
    List<Blog> getBlogList();

    @GetMapping("/blog/{id}")
    Blog getBlogById(@PathVariable("id") String id);
}
