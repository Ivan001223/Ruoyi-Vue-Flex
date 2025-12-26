package org.dromara.common.mybatis.core.query;

/**
 * Wrappers Adapter
 */
public class Wrappers {

    public static <T> LambdaQueryWrapper<T> lambdaQuery() {
        return new LambdaQueryWrapper<>();
    }

    public static <T> LambdaQueryWrapper<T> lambdaQuery(T entity) {
        return new LambdaQueryWrapper<>();
    }

    public static <T> LambdaQueryWrapper<T> lambdaQuery(Class<T> entityClass) {
        return new LambdaQueryWrapper<>();
    }

    public static <T> LambdaQueryWrapper<T> query() {
        return new LambdaQueryWrapper<>();
    }
}
