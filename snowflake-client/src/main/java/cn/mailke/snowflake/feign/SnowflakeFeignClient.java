package cn.mailke.snowflake.feign;

import cn.mailke.snowflake.vo.BaseVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * author: libing.niu
 * date: 2021/03/27
 */
@FeignClient(name = "snowflake", url = "${snowflake.service.url}")
public interface SnowflakeFeignClient {

    /**
     * 生成单个id
     * @return BaseVO<List<Long>>
     */
    @GetMapping("/id")
    BaseVO<Long> uniqueId();

    /**
     * 生成批量id
     * @param count 需要生成的个数量
     * @return BaseVO<List<Long>>
     */
    @GetMapping("/id/{count}")
    BaseVO<List<Long>> uniqueIds(@PathVariable("count") Integer count);
}
