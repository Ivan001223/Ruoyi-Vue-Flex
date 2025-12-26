package org.dromara.workflow.domain;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.tenant.core.TenantEntity;

import java.io.Serial;

/**
 * 流程实例业务扩展对象 flow_instance_biz_ext
 *
 * @author may
 * @date 2025-08-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table("flow_instance_biz_ext")
public class FlowInstanceBizExt extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id(value = "id")
    private Long id;

    /**
     * 流程实例ID
     */
    private Long instanceId;

    /**
     * 业务ID
     */
    private String businessId;

    /**
     * 业务编码
     */
    private String businessCode;

    /**
     * 业务标题
     */
    private String businessTitle;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @Column(isLogicDelete = true)
    private String delFlag;

}
