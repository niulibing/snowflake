package cn.mailke.snowflake.feign;

import cn.mailke.snowflake.vo.BaseVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * author: johnny
 * date: 2019/1/21 13:57
 */
@FeignClient(name = "snowflake", url = "${snowflake.service.url}")
public interface SnowflakeFeignClient {

    @GetMapping("/id")
    BaseVO<Long> uniqueId();

    @GetMapping("/id/{count}")
    BaseVO<List<Long>> uniqueIds(@PathVariable("count") Integer count);
}
