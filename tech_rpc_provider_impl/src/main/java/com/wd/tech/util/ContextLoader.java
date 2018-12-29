package com.wd.tech.util;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration("techConfig")
@EnableTransactionManagement
@ComponentScan("com.wd")
@ImportResource("classpath:/spring/*.xml")
@PropertySource("classpath:/properties/log4j.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ContextLoader {
}
