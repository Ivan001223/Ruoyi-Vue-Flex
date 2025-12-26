package org.dromara.demo.mapper;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.apache.ibatis.annotations.Param;
import org.dromara.common.mybatis.annotation.DataColumn;
import org.dromara.common.mybatis.annotation.DataPermission;
import org.dromara.common.mybatis.core.mapper.BaseMapperFlex;
import org.dromara.demo.domain.TestDemo;
import org.dromara.demo.domain.vo.TestDemoVo;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 测试单表Mapper接口
 *
 * @author Lion Li
 * @date 2021-07-26
 */
public interface TestDemoMapper extends BaseMapperFlex<TestDemo, TestDemoVo> {

    @DataPermission({
            @DataColumn(key = "deptName", value = "dept_id"),
            @DataColumn(key = "userName", value = "user_id")
    })
    Page<TestDemoVo> customPageList(@Param("page") Page<TestDemo> page, @Param("ew") QueryWrapper wrapper);

    @Override
    @DataPermission({
            @DataColumn(key = "deptName", value = "dept_id"),
            @DataColumn(key = "userName", value = "user_id")
    })
    default <P extends Page<TestDemoVo>> P selectVoPage(Page<TestDemo> page, QueryWrapper wrapper) {
        return selectVoPage(page, wrapper, this.currentVoClass());
    }

    @Override
    @DataPermission({
            @DataColumn(key = "deptName", value = "dept_id"),
            @DataColumn(key = "userName", value = "user_id")
    })
    default List<TestDemoVo> selectVoList(QueryWrapper wrapper) {
        return selectVoList(wrapper, this.currentVoClass());
    }

    @Override
    @DataPermission(value = {
            @DataColumn(key = "deptName", value = "dept_id"),
            @DataColumn(key = "userName", value = "user_id")
    }, joinStr = "AND")
    List<TestDemo> selectListByIds(@Param("coll") Collection<? extends Serializable> idList);

    @Override
    @DataPermission({
            @DataColumn(key = "deptName", value = "dept_id"),
            @DataColumn(key = "userName", value = "user_id")
    })
    int updateByQuery(@Param("et") TestDemo entity, @Param("ew") QueryWrapper queryWrapper);
    // Note: MP had updateById(entity). Flex has update(entity).
    // If we want to override update by ID specifically? Flex BaseMapper has
    // update(entity).
    // It updates by ID.
    // So update(entity, null) check?
    // Wait, MP's updateById(entity) does not take wrapper.
    // Override signature needs to match Flex.
    // Flex BaseMapper: update(T entity) -> int.
    // So:
    // int update(T entity);
}
