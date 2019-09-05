package cn.mailke.snowflake;

import cn.mailke.snowflake.feign.SnowflakeFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: snowflake
 * @description: SnowflakeClient
 * @author: Johhny Chin
 * @create: 2019-03-21-12-51
 **/
@Component
public class SnowflakeClient {
    /**
     * snowflakeFeignClient
     */
    @Autowired
    private SnowflakeFeignClient snowflakeFeignClient;

    /**
     * uniqueId
     *
     * @return Long
     */
    public Long uniqueId() {
        return snowflakeFeignClient.uniqueId().getData();
    }

    /**
     * uniqueIds
     *
     * @param count count
     * @return List<Long>
     */
    public List<Long> uniqueIds(Integer count) {
        return snowflakeFeignClient.uniqueIds(count).getData();
    }
}
