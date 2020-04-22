package com.elasticsearch.restclient.utils;

import org.springframework.lang.Nullable;

/**
 * @Description
 * @ClassName StringUtils
 * @Author xuliang
 * @date 2020.04.17 10:05
 */
public class StringUtils {

    public static boolean isNotEmpty(@Nullable Object str) {
        return str != null && !("".equals(str));
    }
}
