package com.kingsoft.servicea.mapper;

import com.kingsoft.servicea.service.es.EsBlogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author baisongyuan
 * @className EsMapper
 * @description
 * @date 2022/4/26 17:30
 */
@Slf4j
@Component
public class EsMapper {

    private final ElasticsearchRestTemplate esRestTemplate;

    public EsMapper(ElasticsearchRestTemplate esRestTemplate) {
        this.esRestTemplate = esRestTemplate;
    }

    /**
     *
     * @param entity
     * @param index
     * @param <T>
     * @return  id
     */
    public <T> String index(T entity,String index){
        IndexQuery query = new IndexQueryBuilder().withObject(entity).build();
        return esRestTemplate.index(query, IndexCoordinates.of(index));
    }

    public <T> void index(T entity,String index,String id){
        IndexQuery query = new IndexQueryBuilder().withObject(entity).withId(id).build();
        esRestTemplate.index(query,IndexCoordinates.of(index));
    }

    public <T> T queryById(String id,String index,Class<T> clazz){
        return esRestTemplate.get(id,clazz,IndexCoordinates.of(index));
    }

    public <T> List<T> search(String query,String index,Class<T> clazz){
        StringQuery stringQuery = new StringQuery(query);
        SearchHits<T> result = esRestTemplate.search(stringQuery, clazz, IndexCoordinates.of(index));
        return result.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }

}
