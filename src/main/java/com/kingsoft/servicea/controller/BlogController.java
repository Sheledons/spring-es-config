package com.kingsoft.servicea.controller;

import com.kingsoft.servicea.config.api.Api;
import com.kingsoft.servicea.controller.entity.CustomResponse;
import com.kingsoft.servicea.service.EsBlogService;
import com.kingsoft.servicea.service.feign.FeignBlogService;
import com.kinsoft.common.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author Sheledon
 * @date 2022/4/13
 */
@RestController
@RequestMapping(Api.BlogApi.BASE_URL)
public class BlogController {
    @Autowired
    private FeignBlogService feignBlogService;
    @Autowired
    private EsBlogService esBlogService;

    @PostMapping
    public CustomResponse saveBlog(@RequestBody Blog blog){
        String id = esBlogService.indexBlog(blog);
        blog.setId(id);
//        feignBlogService.saveBlog(blog);
        return CustomResponse.builder().code(200).build();
    }

    @GetMapping(Api.BlogApi.LIST)
    public CustomResponse getBlogList(){
        List<Blog> blogList = feignBlogService.getBlogList();
        return CustomResponse.builder()
                .code(200)
                .data(blogList)
                .build();
    }

    @GetMapping("/search/{keyword}")
    public CustomResponse searchByContent(@PathVariable("keyword") String keyword){
        SearchHits<List<Blog>> result = esBlogService.searchByContent(keyword);
        return CustomResponse.builder()
                .code(200)
                .data(result)
                .build();
    }

    @GetMapping("/elasticsearch/{id}")
    public CustomResponse findByIdFromEs(@PathVariable("id") String id){
        return CustomResponse.builder()
                .code(200)
                .data(esBlogService.findById(id))
                .build();
    }

    @GetMapping("/{id}")
    public CustomResponse getBlogById(@PathVariable("id") String id){
        Blog blog = feignBlogService.getBlogById(id);
        return CustomResponse.builder()
                .code(200)
                .data(blog)
                .build();
    }
}
