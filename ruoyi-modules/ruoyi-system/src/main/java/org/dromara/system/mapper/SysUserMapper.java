package org.dromara.system.mapper;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.apache.ibatis.annotations.Param;
import org.dromara.common.mybatis.annotation.DataColumn;
import org.dromara.common.mybatis.annotation.DataPermission;
import org.dromara.common.mybatis.core.mapper.BaseMapperFlex;
import org.dromara.common.mybatis.core.query.LambdaQueryWrapper;
import org.dromara.system.domain.SysUser;
import org.dromara.system.domain.vo.SysUserExportVo;
import org.dromara.system.domain.vo.SysUserVo;

import java.util.List;

/**
 * 用户表 数据层
 *
 * @author Lion Li
 */
public interface SysUserMapper extends BaseMapperFlex<SysUser, SysUserVo> {

    /**
     * 分页查询用户列表，并进行数据权限控制
     *
     * @param page         分页参数
     * @param queryWrapper 查询条件
     * @return 分页的用户信息
     */
    @DataPermission({
            @DataColumn(key = "deptName", value = "dept_id"),
            @DataColumn(key = "userName", value = "create_by")
    })
    default Page<SysUserVo> selectPageUserList(Page<SysUser> page, QueryWrapper queryWrapper) {
        return this.selectVoPage(page, queryWrapper);
    }

    /**
     * 查询用户列表，并进行数据权限控制
     *
     * @param queryWrapper 查询条件
     * @return 用户信息集合
     */
    @DataPermission({
            @DataColumn(key = "deptName", value = "dept_id"),
            @DataColumn(key = "userName", value = "create_by")
    })
    default List<SysUserVo> selectUserList(QueryWrapper queryWrapper) {
        return this.selectVoList(queryWrapper);
    }

    /**
     * 根据条件分页查询用户列表
     *
     * @param queryWrapper 查询条件
     * @return 用户信息集合信息
     */
    @DataPermission({
            @DataColumn(key = "deptName", value = "d.dept_id"),
            @DataColumn(key = "userName", value = "u.create_by")
    })
    List<SysUserExportVo> selectUserExportList(@Param("ew") QueryWrapper queryWrapper);

    /**
     * 根据条件分页查询已配用户角色列表
     *
     * @param page         分页信息
     * @param queryWrapper 查询条件
     * @return 用户信息集合信息
     */
    @DataPermission({
            @DataColumn(key = "deptName", value = "d.dept_id"),
            @DataColumn(key = "userName", value = "u.create_by")
    })
    Page<SysUserVo> selectAllocatedList(@Param("page") Page<SysUser> page, @Param("ew") QueryWrapper queryWrapper);

    /**
     * 根据条件分页查询未分配用户角色列表
     *
     * @param queryWrapper 查询条件
     * @return 用户信息集合信息
     */
    @DataPermission({
            @DataColumn(key = "deptName", value = "d.dept_id"),
            @DataColumn(key = "userName", value = "u.create_by")
    })
    Page<SysUserVo> selectUnallocatedList(@Param("page") Page<SysUser> page, @Param("ew") QueryWrapper queryWrapper);

    /**
     * 根据用户ID统计用户数量
     *
     * @param userId 用户ID
     * @return 用户数量
     */
    @DataPermission({
            @DataColumn(key = "deptName", value = "dept_id"),
            @DataColumn(key = "userName", value = "create_by")
    })
    default long countUserById(Long userId) {
        return this.selectCount(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUserId, userId));
    }

    /**
     * 根据条件更新用户数据
     *
     * @param user          要更新的用户实体
     * @param updateWrapper 更新条件封装器
     * @return 更新操作影响的行数
     */
    @Override
    @DataPermission({
            @DataColumn(key = "deptName", value = "dept_id"),
            @DataColumn(key = "userName", value = "create_by")
    })
    default int updateByQuery(SysUser user, QueryWrapper updateWrapper) {
        return BaseMapperFlex.super.updateByQuery(user, updateWrapper);
    }

    /**
     * 根据用户ID更新用户数据
     *
     * @param user 要更新的用户实体
     * @return 更新操作影响的行数
     */
    @Override
    @DataPermission({
            @DataColumn(key = "deptName", value = "dept_id"),
            @DataColumn(key = "userName", value = "create_by")
    })
    default int updateById(SysUser user) {
        return BaseMapperFlex.super.updateById(user);
    }

}
