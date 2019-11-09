package com.chuilun.util;

import com.chuilun.pojo.Message;
import com.chuilun.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 将该类实例化到spring容器
@Component
public class MessageUtil {

    @Autowired
    private MessageService messageService;

    public static MessageUtil messageUtil;

    // 该注解是servlet中的一个生命周期环节，被修饰的方法会在构造函数之后被执行
    @PostConstruct
    public void init(){
        messageUtil = this;
    }

    // 根据传入的service、父留言、装载回复的集合，递归查询所有回复
    public static void findReplyByMessageId(Message message,
                                            List<Message> replies) {
        // 根据父留言id,查询所有回复
        List<Message> replyList = messageUtil.messageService.selectReplyByParentId(message.getId());
        // 遍历所有回复
        for (Message reply : replyList) {
            // 将回复依次加入父留言的回复集合
            replies.add(reply);
            // 创建回复的装载下级回复的集合
            List<Message> list = new ArrayList<>();
            // 设置回复装载下级回复的集合
            reply.setReplies(list);
            // 递归查询，根据回复id，查询下一级回复，再依次装入集合
            findReplyByMessageId(reply,list);
        }
    }

    private static String[] xing = {
                "赵","钱","孙","李","周","吴","郑","王","冯","陈","楮","卫","蒋","沈","韩","杨",
                "朱","秦","尤","许","何","吕","施","张","孔","曹","严","华","金","魏","陶","姜",
                "戚","谢","邹","喻","柏","水","窦","章","云","苏","潘","葛","奚","范","彭","郎",
                "鲁","韦","昌","马","苗","凤","花","方","俞","任","袁","柳","酆","鲍","史","唐",
                "费","廉","岑","薛","雷","贺","倪","汤","滕","殷","罗","毕","郝","邬","安","常",
                "乐","于","时","傅","皮","卞","齐","康","伍","余","元","卜","顾","孟","平","黄",
                "和","穆","萧","尹","姚","邵","湛","汪","万俟","司马","上官","欧阳","夏侯","诸葛",
                "闻人","东方","赫连","皇甫","尉迟","公羊","澹台","公冶","宗政","濮阳","淳于","单于",
                "太叔","申屠","公孙","仲孙","轩辕","令狐","锺离","宇文"};
    private static String[] word = {
            "一","乙","二","十","丁","厂","七","卜","人","入","八","九","几","儿","了","力","乃","刀","又",
            "三","于","干","亏","士","工","土","才","寸","下","大","丈","与","万","上","小","口","巾","山",
            "千","乞","川","亿","个","勺","久","凡","及","夕","丸","么","广","亡","门","义","之","尸","弓",
            "己","已","子","卫","也","女","飞","刃","习","叉","马","乡","丰","王","井","开","夫","天","无",
            "元","专","云","扎","艺","木","五","支","厅","不","太","犬","区","历","尤","友","匹","车","巨",
            "牙","屯","比","互","切","瓦","止","少","日","中","冈","贝","内","水","见","午","牛","手","毛",
            "气","升","长","仁","什","片","仆","化","仇","币","仍","仅","斤","爪","反","介","父","从","今",
            "凶","分","乏","公","仓","月","氏","勿","欠","风","丹","匀","乌","凤","勾","文","六","方","火",
            "为","斗","忆","订","计","户","认","心","尺","引","丑","巴","孔","队","办","以","允","予","劝",
            "双","书","幻","玉","刊","示","末","未","击","打","巧","正","扑","扒","功","扔","去","甘","世",
            "古","节","本","术","可","丙","左","厉","右","石","布","龙","平","灭","轧","东","卡","北","占",
            "业","旧","帅","归","且","旦","目","叶","甲","申","叮","电","号","田","由","史","只","央","兄",
            "叼","叫","另","叨","叹","四","生","失","禾","丘","付","仗","代","仙","们","仪","白","仔","他",
            "斥","瓜","乎","丛","令","用","甩","印","乐","句","匆","册","犯","外","处","冬","鸟","务","包",
            "饥","主","市","立","闪","兰","半","汁","汇","头","汉"};

        public static String buildName() {
            int adjLen= xing.length;
            int nLen= word.length;
            StringBuffer sb = new StringBuffer();
            Random random = new Random();
            sb.append(xing[random.nextInt(adjLen)]);
            sb.append(word[random.nextInt(nLen)]);
            sb.append(word[random.nextInt(nLen)]);
            return sb.toString();
        }

}
