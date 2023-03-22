package com.kingsoft.servicea.service;


import com.kinsoft.common.entity.Blog;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;

import java.util.List;

/**
 * @author Sheledon
 * @date 2022/4/13
 */
public interface EsBlogService {

    String indexBlog(Blog blog);

    SearchHits<List<Blog>> searchByContent(String content);

    Blog findById(String id);
}
