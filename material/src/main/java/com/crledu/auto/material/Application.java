package com.crledu.auto.material;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 ************************************************************
 * @Description: spring boot启动类
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/19 14:26
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@SpringBootApplication/*(exclude = {SecurityAutoConfiguration.class, org.activiti.spring.boot.SecurityAutoConfiguration.class})*/
@MapperScan("com.crledu.auto.**.repository.dao")
@EnableSwaggerBootstrapUI
@EnableCaching
public class Application {

    public static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args)  throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(Application.class,args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        if(path == null){
            path = "";
        }
        log.info("\n----------------------------------------------------------\n\t" +
                "Application crledu-web-material is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
                "Swagger-UI: \t\thttp://" + ip + ":" + port + path + "/doc.html\n" +
                "----------------------------------------------------------");
    }
}
