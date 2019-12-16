package client;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import service.IPerson;
import java.util.Random;

/**
 * 随机选择service
 */
@Component
public class RandomService {

    private static final Logger logger = Logger.getLogger("RandomService");

    @Qualifier("person1")
    @Autowired
    IPerson service1;

    @Qualifier("person2")
    @Autowired
    IPerson service2;

    public IPerson chooseService(){
        IPerson service = (IPerson)choose(service1,service2);
        return service;
    }

    private Object choose(Object m,Object n){
        int choose = new Random().nextInt(2);
        if(0 == choose){
            try{
                logger.info("服务一。。。");
                return m;
            }catch (Exception e1){
                try{
                    logger.info("服务二。。。");
                    return n;
                }catch (Exception e2){
                    logger.error("服务选择出现异常1。。。");
                    throw new RuntimeException("服务选择异常1");
                }
            }
        }
        if(1 == choose){
            try{
                logger.info("服务二。。。");
                return n;
            }catch (Exception e1){
                try{
                    logger.info("服务一。。。");
                    return m;
                }catch (Exception e2){
                    logger.error("服务选择出现异常2。。。");
                    throw new RuntimeException("服务选择异常2");
                }
            }
        }
        logger.error("未知异常。。。");
        throw new RuntimeException("未知异常");
    }
}
