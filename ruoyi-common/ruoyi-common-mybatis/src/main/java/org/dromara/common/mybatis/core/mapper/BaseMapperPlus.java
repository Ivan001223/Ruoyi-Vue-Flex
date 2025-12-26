package org.dromara.common.mybatis.core.mapper;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.TypeUtil;
import com.mybatisflex.core.BaseMapper;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.row.Db;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.dromara.common.core.utils.MapstructUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 自定义 Mapper 接口, 实现 自定义扩展
 *
 * @param <T> table 泛型
 * @param <V> vo 泛型
 * @author Lion Li
 * @since 2021-05-13
 */
@SuppressWarnings("unchecked")
public interface BaseMapperPlus<T, V> extends BaseMapper<T> {

    Log log = LogFactory.getLog(BaseMapperPlus.class);

    default Class<V> currentVoClass() {
        return (Class<V>) TypeUtil.getTypeArgument(this.getClass(), 1);
    }

    default Class<T> currentModelClass() {
        return (Class<T>) TypeUtil.getTypeArgument(this.getClass(), 0);
    }

    /**
     * 列表查询
     */
    default List<T> selectList() {
        return this.selectListByQuery(new QueryWrapper());
    }

    default List<T> selectList(QueryWrapper wrapper) {
        return this.selectListByQuery(wrapper);
    }

    /**
     * 数量查询
     */
    default long selectCount(QueryWrapper wrapper) {
        return this.selectCountByQuery(wrapper);
    }

    /**
     * 批量查询
     */
    default List<T> selectByIds(Collection<? extends Serializable> idList) {
        return this.selectListByIds(idList);
    }

    /**
     * 单条查询
     */
    default T selectOne(QueryWrapper wrapper) {
        return this.selectOneByQuery(wrapper);
    }

    /**
     * 删除
     */
    default int delete(QueryWrapper wrapper) {
        return this.deleteByQuery(wrapper);
    }

    /**
     * 批量插入
     *
     * @param entityList 实体列表
     * @return 影响行数
     */
    default int insertBatch(Collection<T> entityList) {
        if (entityList instanceof List) {
            return this.insertBatch((List<T>) entityList);
        }
        return this.insertBatch(CollUtil.newArrayList(entityList));
    }

    /**
     * 批量插入或更新
     *
     * @param entityList 实体列表
     * @return 结果
     */
    default boolean insertOrUpdateBatch(Collection<T> entityList) {
        // Flex does not support insertOrUpdateBatch directly in Mapper without ID check
        // logic usually found in Service.
        // We simulate it by iterating. Ideally, use Service layer.
        for (T entity : entityList) {
            if (updateById(entity) == 0) {
                insert(entity);
            }
        }
        return true;
    }

    default V selectVoById(Serializable id) {
        return selectVoById(id, this.currentVoClass());
    }

    default V selectVoById(Serializable id, Class<V> voClass) {
        T t = this.selectOneById(id);
        if (ObjectUtil.isNull(t)) {
            return null;
        }
        return MapstructUtils.convert(t, voClass);
    }

    default List<V> selectVoBatchIds(Collection<? extends Serializable> idList) {
        return selectVoBatchIds(idList, this.currentVoClass());
    }

    default List<V> selectVoBatchIds(Collection<? extends Serializable> idList, Class<V> voClass) {
        List<T> list = this.selectListByIds(idList);
        if (CollUtil.isEmpty(list)) {
            return CollUtil.newArrayList();
        }
        return MapstructUtils.convert(list, voClass);
    }

    default List<V> selectVoList() {
        return selectVoList(new QueryWrapper(), this.currentVoClass());
    }

    default List<V> selectVoList(QueryWrapper wrapper) {
        return selectVoList(wrapper, this.currentVoClass());
    }

    default List<V> selectVoList(QueryWrapper wrapper, Class<V> voClass) {
        List<T> list = this.selectListByQuery(wrapper);
        if (CollUtil.isEmpty(list)) {
            return CollUtil.newArrayList();
        }
        return MapstructUtils.convert(list, voClass);
    }

    default V selectVoOne(QueryWrapper wrapper) {
        return selectVoOne(wrapper, this.currentVoClass());
    }

    default V selectVoOne(QueryWrapper wrapper, Class<V> voClass) {
        T t = this.selectOneByQuery(wrapper);
        if (ObjectUtil.isNull(t)) {
            return null;
        }
        return MapstructUtils.convert(t, voClass);
    }

    /**
     * 根据ID更新
     *
     * @param entity 实体对象
     * @return 影响行数
     */
    default int updateById(T entity) {
        return this.update(entity);
    }

    default int updateBatchById(Collection<T> entities) {
        int rows = 0;
        for (T entity : entities) {
            rows += this.update(entity);
        }
        return rows;
    }

    default T selectById(Serializable id) {
        return this.selectOneById(id);
    }

    default boolean exists(QueryWrapper queryWrapper) {
        return this.selectCountByQuery(queryWrapper) > 0;
    }

    default int deleteBatchIds(Collection<? extends Serializable> ids) {
        return this.deleteBatchByIds(ids);
    }

    default <P extends Page<V>> P selectVoPage(Page<T> page, QueryWrapper wrapper) {
        return selectVoPage(page, wrapper, this.currentVoClass());
    }

    default <C, P extends Page<C>> P selectVoPage(Page<T> page, QueryWrapper wrapper, Class<C> voClass) {
        if (page instanceof org.dromara.common.mybatis.core.page.FlexPage) {
            ((org.dromara.common.mybatis.core.page.FlexPage<T>) page).sort(wrapper);
        }
        Page<T> resultPage = this.paginate(page, wrapper);
        Page<C> voPage = new Page<>(resultPage.getPageNumber(), resultPage.getPageSize(), resultPage.getTotalRow());
        if (CollUtil.isEmpty(resultPage.getRecords())) {
            return (P) voPage;
        }
        voPage.setRecords(MapstructUtils.convert(resultPage.getRecords(), voClass));
        return (P) voPage;
    }
}
