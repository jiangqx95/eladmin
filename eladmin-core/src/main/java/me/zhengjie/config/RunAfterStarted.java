package me.zhengjie.config;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName: RunAfterStarted
 * @Description: 项目启动后运行
 * @Author: jiangqx
 * @Date: 2022/11/8 10:14
 * @Version 1.0
 */
@Slf4j
@Component
public class RunAfterStarted implements CommandLineRunner {

    @Resource
    Environment environment;

    private RestTemplate restTemplate = new RestTemplateBuilder().build();


    /**
     * @description: 启动后请求一次接口，解决启动后首次访问慢的问题
     * @author jiangqx
     * @date: 2022/11/8 10:44
     */
    @Override
    public void run(String... args) {
        //设置Http Header
        HttpHeaders headers = new HttpHeaders();
        //设置请求媒体数据类型
        headers.setContentType(MediaType.APPLICATION_JSON);
        //设置返回媒体数据类型
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        log.info(">>>>>>>>>>>>>>> 加载 yauaa-useragent >>>>>>>>>>>>>>>");
        try {
            // 验证码接口
            restTemplate.execute("http://127.0.0.1:" + environment.getProperty("local.server.port") + "/auth/code", HttpMethod.GET, null, null);
            // 登录接口
            restTemplate.postForObject("http://127.0.0.1:" + environment.getProperty("local.server.port") + "/auth/login", new HttpEntity<>(new JSONObject().toString(), headers), String.class);
        } catch (Exception e) {

        } finally {
            log.info(">>>>>>>>>>>>>>> 项目启动完成 >>>>>>>>>>>>>>>");
        }
    }
}
