package cn.mailke.snowflake.config;


import cn.mailke.snowflake.core.SnowflakeFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author libing.niu
 * @date 2019/9/2 15:57
 * @copyright ©2019
 */

@Configuration
public class SnowflakeBean {

    @Value("${system.workerid}")
    private int workerid;

    @Value("${system.datacenterid}")
    private int datacenterid;

    @Bean
    public SnowflakeFactory snowflakeFactory() {
        SnowflakeFactory idFactory = new SnowflakeFactory(workerid, datacenterid);
        return idFactory;
    }
}