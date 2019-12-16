package client;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.Fruit;
import service.IPerson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 客户端调用类
 */

@Controller
public class Client {

    private static final Logger logger = Logger.getLogger("Client");

    @Autowired
    RandomService randomService;


    @RequestMapping(value = "/client",method = RequestMethod.GET )
    @ResponseBody
    public Map eatFruit1()  {

        String ii = randomService.chooseService().eat("苹果");
        Map<String,String> map = new HashMap<>();
        map.put("水果",ii);
        logger.info("水果"+ii);
        return map;
    }

    @RequestMapping(value = "/client2",method = RequestMethod.GET )
    @ResponseBody
    public Map eatFruit2()  {

        Fruit fruit = new Fruit(1,"西瓜",2.2d,"green",new Date());
        String i = randomService.chooseService().eat(fruit);
        Map<String,String> map = new HashMap<>();
        map.put("水果品种",i);
        logger.info("水果品种"+i);
        return map;
    }

}
