package com.kingsoft.servicea.config.api;

/**
 * @author Sheledon
 * @date 2022/4/11
 */
public class Api {
    public static class UserApi{
        public static final String BASE_URL = "/user";
        public static final String LOGIN = "/login";
    }
    public static class BlogApi{
        public static final String BASE_URL = "/blog";
        public static final String LIST = "/list";
    }
    public static class LikeApi{
        public static final String BASE_URL = "/like";
        public static final String INCREMENT = "/increment";
        public static final String DECREMENT = "/decrement";
        public static final String COUNT = "/count/{blogId}";
    }
}
