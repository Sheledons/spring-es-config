package com.kingsoft.servicea.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kingsoft.servicea.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Sheledon
 * @date 2022/4/11
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
