package service;

import org.apache.log4j.Logger;

/**
 * 人实现类
 */
public class Person implements IPerson {

    private static final Logger logger = Logger.getLogger("Person");

    @Override
    public String eat(String fruitName){
        logger.info("服务开始------");
        logger.info("我要吃："+ fruitName );
        logger.info("服务结束------");
        return fruitName;
    }

    @Override
    public String eat(Fruit fruit){
        logger.info("服务开始------");
        logger.info("我想想："+fruit);
        logger.info("服务结束------");
        return "" + fruit;
    }
}
