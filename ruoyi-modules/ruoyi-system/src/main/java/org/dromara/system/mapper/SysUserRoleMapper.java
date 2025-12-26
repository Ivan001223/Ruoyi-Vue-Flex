package org.dromara.system.mapper;

import org.dromara.common.mybatis.core.query.LambdaQueryWrapper;
import org.dromara.common.mybatis.core.mapper.BaseMapperFlex;
import org.dromara.system.domain.SysUserRole;

import java.util.List;

/**
 * 用户与角色关联表 数据层
 *
 * @author Lion Li
 */
public interface SysUserRoleMapper extends BaseMapperFlex<SysUserRole, SysUserRole> {

    /**
     * 根据角色ID查询关联的用户ID列表
     *
     * @param roleId 角色ID
     * @return 关联到指定角色的用户ID列表
     */
    default List<Long> selectUserIdsByRoleId(Long roleId) {
        return this.selectObjs(new LambdaQueryWrapper<SysUserRole>()
            .select(SysUserRole::getUserId).eq(SysUserRole::getRoleId, roleId)
        ).stream().map(o -> (Long)o).toList();
    }

}
