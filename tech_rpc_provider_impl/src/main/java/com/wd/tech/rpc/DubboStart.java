package com.wd.tech.rpc;

import com.wd.tech.util.PropertiesUtil;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Properties;

/**
 * 用Dubbo容器的方式启动提供者；
 *
 */
public class DubboStart {

    private static final Logger logger = LoggerFactory.getLogger(DubboStart.class);

    public static void main(String[] args) throws IOException {
        Properties log = null;
        try {
            log = PropertiesUtil.getProperties("properties/log4j.properties","utf-8");
            if (null == log) {
                System.out.println("没有找到日志文件");
            }
            PropertyConfigurator.configure(log);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        final String[] strings = {"classpath:spring/spring-context.xml","classpath:spring/spring-dubbo.xml","classpath:spring/spring-dao.xml"};
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(strings);
        context.start();
        logger.info("dubbo server start up successfully!");
        synchronized (DubboStart.class) {
            while (true) {
                try {
                    DubboStart.class.wait();
                } catch (Throwable e) {
                }
            }
        }
    }

}
