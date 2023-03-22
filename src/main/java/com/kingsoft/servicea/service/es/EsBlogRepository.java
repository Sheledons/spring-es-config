package com.kingsoft.servicea.service.es;

import com.kinsoft.common.entity.Blog;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Blog : 文档对应类
 * String: ID类型
 * @date 2022/4/13
 */
@Component
public interface EsBlogRepository extends ElasticsearchRepository<Blog,String> {
    SearchHits<List<Blog>> findByContent(String content);
}
