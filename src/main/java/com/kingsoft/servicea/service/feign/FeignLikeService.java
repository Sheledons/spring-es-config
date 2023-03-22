package com.kingsoft.servicea.service.feign;

import com.kinsoft.common.entity.Like;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sheledon
 * @date 2022/4/13
 */
@Service
@FeignClient(name = "LIKE-SERVICE")
public interface FeignLikeService {

    @PutMapping("/like/increment")
    long incrementAndGetLike(@RequestBody Like like);

    @PutMapping("/like/decrement")
    long decrementAndGetLike(@RequestBody Like like);

    @GetMapping("/like/{blogId}")
    int getLikeCount(@PathVariable("blogId") String blogId);
}
