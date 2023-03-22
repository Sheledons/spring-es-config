package com.kingsoft.servicea.manager;

import com.kingsoft.servicea.mapper.EsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author baisongyuan
 * @className EsManager
 * @description
 * @date 2022/4/26 17:29
 */
@Component
public class EsManager {
    @Autowired
    private EsMapper esMapper;
}
