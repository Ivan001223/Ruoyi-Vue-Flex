package org.dromara.common.mybatis.config;

import com.mybatisflex.core.FlexGlobalConfig;
import com.mybatisflex.spring.boot.MyBatisFlexCustomizer;
import org.dromara.common.mybatis.handler.FlexDataPermissionHandler;
import org.dromara.common.mybatis.handler.FlexMetaObjectHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan("${mybatis-flex.mapper-package}")
public class MybatisFlexConfig implements MyBatisFlexCustomizer {

    @Override
    public void customize(FlexGlobalConfig globalConfig) {
        // 注册自动填充监听器
        FlexMetaObjectHandler handler = new FlexMetaObjectHandler();
        globalConfig.registerInsertListener(handler, Object.class);
        globalConfig.registerUpdateListener(handler, Object.class);

        // 注册数据权限处理器
        // globalConfig.setDataPermissionHandler(new FlexDataPermissionHandler());

        // 注册逻辑删除配置 (如果需要动态配置)
        // globalConfig.setLogicDeleteColumn("del_flag");
        // globalConfig.setLogicDeleteValue("1"); // assuming string
        // globalConfig.setNormalValueOfLogicDelete("0");
    }

    @Bean
    public FlexMetaObjectHandler flexMetaObjectHandler() {
        return new FlexMetaObjectHandler();
    }
}
