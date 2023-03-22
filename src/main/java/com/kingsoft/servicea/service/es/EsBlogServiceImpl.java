package com.kingsoft.servicea.service.es;

import com.kingsoft.servicea.service.EsBlogService;
import com.kinsoft.common.entity.Blog;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sheledon
 * @date 2022/4/13
 */
@Service
public class EsBlogServiceImpl implements EsBlogService {
    public static final String BLOG_INDEX = "blog-index";
//    ElasticsearchRestTemplate 继承于 ElasticsearchOperations impl (DocumentOperations , SearchOperations)

    private final ElasticsearchRestTemplate esRestTemplate;
    private final EsBlogRepository esBlogRepository;
    private final IndexCoordinates indexCoordinates;

    public EsBlogServiceImpl(@Autowired @Qualifier("esRestTemplate") ElasticsearchRestTemplate esRestTemplate, EsBlogRepository esBlogRepository) {
        this.esRestTemplate = esRestTemplate;
        this.esBlogRepository = esBlogRepository;
        this.indexCoordinates = IndexCoordinates.of(BLOG_INDEX);
    }

    @Override
    public String indexBlog(Blog blog){
        IndexQuery query = new IndexQueryBuilder().withObject(blog).build();
        System.out.println(esRestTemplate);
        return esRestTemplate.index(query, indexCoordinates);
    }

    @Override
    public Blog findById(String id){
        return esRestTemplate.get(id,Blog.class,indexCoordinates);
    }

    @Override
    public SearchHits<List<Blog>> searchByContent(String content){
        return esBlogRepository.findByContent(content);
    }


}
