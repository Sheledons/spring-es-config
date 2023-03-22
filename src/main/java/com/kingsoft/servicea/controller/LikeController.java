package com.kingsoft.servicea.controller;

import com.kingsoft.servicea.config.api.Api;
import com.kingsoft.servicea.controller.entity.CustomResponse;
import com.kingsoft.servicea.service.feign.FeignLikeService;
import com.kinsoft.common.entity.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sheledon
 * @date 2022/4/13
 */
@RestController
@RequestMapping(Api.LikeApi.BASE_URL)
public class LikeController {
    @Autowired
    private FeignLikeService likeService;

    @PutMapping(Api.LikeApi.INCREMENT)
    public CustomResponse increment(@RequestBody Like like){
        long l = likeService.incrementAndGetLike(like);
        return CustomResponse.builder().code(200).data(l).build();
    }

    @PutMapping(Api.LikeApi.DECREMENT)
    public CustomResponse decrement(@RequestBody Like like){
        long l = likeService.decrementAndGetLike(like);
        return CustomResponse.builder().code(200).data(l).build();
    }

    @GetMapping(Api.LikeApi.COUNT)
    public CustomResponse getCount(@PathVariable("blogId") String blogId){
        int count = likeService.getLikeCount(blogId);
        return CustomResponse.builder().data(count).code(200).build();
    }
}
