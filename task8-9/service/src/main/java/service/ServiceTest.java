package service;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试服务端
 */
public class ServiceTest {

    private static final Logger logger = Logger.getLogger("ServiceTest");

    public static void main(String[] args) {

        new ClassPathXmlApplicationContext("remote-service.xml");
        logger.info("服务连接成功------");

    }

}
