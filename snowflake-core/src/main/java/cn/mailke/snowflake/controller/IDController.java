package cn.mailke.snowflake.controller;

import cn.mailke.snowflake.core.SnowflakeFactory;
import cn.mailke.snowflake.vo.BaseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @author libing.niu
 * @date 2019/9/2 15:58
 * @copyright ©2019
 */
@RestController
public class IDController {

    @Autowired
    private SnowflakeFactory snowflakeFactory;

    @GetMapping("id")
    @ApiOperation(value = "生成一个ID", notes = "生成一个ID")
    public BaseVO<Long> generateId()     {
        return new BaseVO<Long>("生成成功", generateIds(1).get(0));
    }

    @GetMapping("id/{count}")
    @ApiOperation(value = "生成多个ID", notes = "生成多个ID")
    public BaseVO<List<Long>> generateId(@PathVariable("count") Integer count) {
        long start = System.currentTimeMillis();
        BaseVO<List<Long>> idlist = new BaseVO<>("生成成功", generateIds(count));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return idlist;
    }

    private List<Long> generateIds(Integer count) {
        List<Long> ids = new ArrayList();
        count = count == null ? 1 : count;
        for (int i = 0; i < count; i++) {
            long id = snowflakeFactory.nextId();
            ids.add(id);
        }
        return ids;
    }

    @GetMapping("test")
    @ApiOperation(value = "测试转发", notes = "生成多个ID")
    public String testRedirect() {

        System.out.println("测试转发执行了...");

        return "redirect:http://www.baidu.com";
    }

}