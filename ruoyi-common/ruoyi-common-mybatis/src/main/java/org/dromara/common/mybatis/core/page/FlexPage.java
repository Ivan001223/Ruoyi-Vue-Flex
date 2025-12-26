package org.dromara.common.mybatis.core.page;

import cn.hutool.core.collection.CollUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Flex 分页对象 (支持排序)
 */
public class FlexPage<T> extends Page<T> {

    private List<OrderItem> orders = new ArrayList<>();

    public FlexPage(Number pageNumber, Number pageSize) {
        super(pageNumber, pageSize);
    }

    public FlexPage(Number pageNumber, Number pageSize, Number totalRow) {
        super(pageNumber, pageSize, totalRow);
    }

    public void addOrder(OrderItem item) {
        orders.add(item);
    }

    public void addOrder(List<OrderItem> items) {
        orders.addAll(items);
    }

    public void sort(QueryWrapper queryWrapper) {
        if (CollUtil.isNotEmpty(orders) && queryWrapper != null) {
            for (OrderItem order : orders) {
                if (order.isAsc()) {
                    queryWrapper.orderBy(order.getColumn(), true);
                } else {
                    queryWrapper.orderBy(order.getColumn(), false);
                }
            }
        }
    }
}
