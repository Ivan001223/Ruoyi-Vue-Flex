package org.dromara.common.mybatis.core.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 排序元素
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private String column;
    private boolean asc = true;

    public static OrderItem asc(String column) {
        return new OrderItem(column, true);
    }

    public static OrderItem desc(String column) {
        return new OrderItem(column, false);
    }
}
