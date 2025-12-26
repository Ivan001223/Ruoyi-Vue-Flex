package org.dromara.common.mybatis.core.query;

import com.mybatisflex.core.query.QueryMethods;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.util.LambdaGetter;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.collection.CollUtil;

import java.util.Collection;

/**
 * MyBatis-Plus LambdaQueryWrapper Adapter for MyBatis-Flex
 */
public class LambdaQueryWrapper<E> extends QueryWrapper {

    // Note: Removed static create() to avoid clash with QueryWrapper.create()

    public <T> LambdaQueryWrapper<E> eq(LambdaGetter<T> column, Object val) {
        if (val != null) {
            super.eq(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> eq(boolean condition, LambdaGetter<T> column, Object val) {
        if (condition) {
            super.eq(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> ne(LambdaGetter<T> column, Object val) {
        if (val != null) {
            super.ne(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> ne(boolean condition, LambdaGetter<T> column, Object val) {
        if (condition) {
            super.ne(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> gt(LambdaGetter<T> column, Object val) {
        if (val != null) {
            super.gt(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> gt(boolean condition, LambdaGetter<T> column, Object val) {
        if (condition) {
            super.gt(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> ge(LambdaGetter<T> column, Object val) {
        if (val != null) {
            super.ge(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> ge(boolean condition, LambdaGetter<T> column, Object val) {
        if (condition) {
            super.ge(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> lt(LambdaGetter<T> column, Object val) {
        if (val != null) {
            super.lt(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> lt(boolean condition, LambdaGetter<T> column, Object val) {
        if (condition) {
            super.lt(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> le(LambdaGetter<T> column, Object val) {
        if (val != null) {
            super.le(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> le(boolean condition, LambdaGetter<T> column, Object val) {
        if (condition) {
            super.le(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> like(LambdaGetter<T> column, Object val) {
        if (val != null) {
            super.like(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> like(boolean condition, LambdaGetter<T> column, Object val) {
        if (condition) {
            super.like(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> notLike(LambdaGetter<T> column, Object val) {
        if (val != null) {
            super.notLike(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> notLike(boolean condition, LambdaGetter<T> column, Object val) {
        if (condition) {
            super.notLike(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> likeLeft(LambdaGetter<T> column, Object val) {
        if (val != null) {
            super.likeLeft(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> likeLeft(boolean condition, LambdaGetter<T> column, Object val) {
        if (condition) {
            super.likeLeft(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> likeRight(LambdaGetter<T> column, Object val) {
        if (val != null) {
            super.likeRight(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> likeRight(boolean condition, LambdaGetter<T> column, Object val) {
        if (condition) {
            super.likeRight(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> in(LambdaGetter<T> column, Collection<?> val) {
        if (CollUtil.isNotEmpty(val)) {
            super.in(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> in(boolean condition, LambdaGetter<T> column, Collection<?> val) {
        if (condition) {
            super.in(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> in(LambdaGetter<T> column, Object... val) {
        if (ObjectUtil.isNotNull(val) && val.length > 0) {
            super.in(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> notIn(LambdaGetter<T> column, Collection<?> val) {
        if (CollUtil.isNotEmpty(val)) {
            super.notIn(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> notIn(boolean condition, LambdaGetter<T> column, Collection<?> val) {
        if (condition) {
            super.notIn(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> notIn(LambdaGetter<T> column, Object... val) {
        if (ObjectUtil.isNotNull(val) && val.length > 0) {
            super.notIn(column, val);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> isNull(LambdaGetter<T> column) {
        super.isNull(column);
        return this;
    }

    public <T> LambdaQueryWrapper<E> isNotNull(LambdaGetter<T> column) {
        super.isNotNull(column);
        return this;
    }

    public <T> LambdaQueryWrapper<E> between(LambdaGetter<T> column, Object val1, Object val2) {
        if (val1 != null && val2 != null) {
            super.between(column, val1, val2);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> between(boolean condition, LambdaGetter<T> column, Object val1, Object val2) {
        if (condition) {
            super.between(column, val1, val2);
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> orderByAsc(LambdaGetter<T> column) {
        super.orderBy(QueryMethods.column(column).asc());
        return this;
    }

    public <T> LambdaQueryWrapper<E> orderByAsc(boolean condition, LambdaGetter<T> column) {
        if (condition) {
            super.orderBy(QueryMethods.column(column).asc());
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> orderByDesc(LambdaGetter<T> column) {
        super.orderBy(QueryMethods.column(column).desc());
        return this;
    }

    public <T> LambdaQueryWrapper<E> orderByDesc(boolean condition, LambdaGetter<T> column) {
        if (condition) {
            super.orderBy(QueryMethods.column(column).desc());
        }
        return this;
    }

    public LambdaQueryWrapper<E> last(String sql) {
        return this;
    }

    public LambdaQueryWrapper<E> last(boolean condition, String sql) {
        return this;
    }

    public LambdaQueryWrapper<E> func(java.util.function.Consumer<LambdaQueryWrapper<E>> consumer) {
        consumer.accept(this);
        return this;
    }

    public LambdaQueryWrapper<E> apply(String applySql, Object... value) {
        super.and(applySql, value);
        return this;
    }

    public String getCustomSqlSegment() {
        return this.toSQL();
    }

    @SafeVarargs
    public final <T> LambdaQueryWrapper<E> select(LambdaGetter<T>... columns) {
        if (ObjectUtil.isNotEmpty(columns)) {
            for (LambdaGetter<T> column : columns) {
                super.select(QueryMethods.column(column));
            }
        }
        return this;
    }

    public <T> LambdaQueryWrapper<E> inSql(LambdaGetter<T> column, String sql) {
        String columnName = QueryMethods.column(column).getName();
        super.and(columnName + " IN (" + sql + ")");
        return this;
    }
}
