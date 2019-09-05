# 基于snowflake算法的分布式id生成器

## 当前版本1.0.2

## 调用snowflake-client相关接口

```java
@FeignClient(name = "snowflake", url = "${snowflake.service.url}")
public interface SnowflakeClient {

    @GetMapping("/id")
    Long uniqueId();

    @GetMapping("/id/{count}")
    List<Long> uniqueIds(@PathVariable("count") Integer count);
}
```

## 使用方法

1. 添加私有仓库
在pom.xml中设置
```xml
<repositories>
    <repository>
        <id>nexus</id>
        <name>nexus</name>
        <url>http://maven.cncommdata.cn/nexus/content/groups/public/</url>
        <releases>
            <enabled>true</enabled>
        </releases>
    </repository>
</repositories>
```

2. 添加maven依赖
snowflake-client.version=1.0.2
```xml
<dependency>
    <groupId>cn.cncommdata</groupId>
    <artifactId>snowflake-client</artifactId>
    <version>${snowflake-client.version}</version>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```

3. 配置application.yml

```
snowflake:
  service:
    url: ${snowflake-service-url:http://snowflake.dev.cncommdata.cn}
```

4. 在SpringBoot项目的main方法上添加注解

```java
@SpringBootApplication(scanBasePackages = {"cn.cncommdata"})
@EnableFeignClients(basePackages = {"cn.cncommdata"})
public class ${artifactIdCamelCase}Application {

    public static void main(String[] args) {
        SpringApplication.run(${artifactIdCamelCase}Application.class, args);
    }

}
```

5. 在需要使用的地方注入

```java
@autowired
private SnowflakeClient snowflakeClient;
```
