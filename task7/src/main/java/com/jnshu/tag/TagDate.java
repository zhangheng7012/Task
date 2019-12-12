package com.jnshu.tag;

import javax.servlet.jsp.tagext.TagSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TagDate extends TagSupport {

// 根据类名、接口名、成员方法及属性等生成的一个64位的哈希字段，serialVersionUID
//    private static final long serialVersionUID = 6464168398214506236L;

    // 时间戳
    private long dateLong;
    // 日期格式
    private String dateType;
    /**
     * 时间戳转换成日期时间
     */
    public int doStartTag() {
        try {
            Date timeDate = new Date(dateLong);
            SimpleDateFormat sdf = new SimpleDateFormat(dateType);
            String dateString = sdf.format(timeDate);
            pageContext.getOut().println(dateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

    public long getDateLong() {
        return dateLong;
    }

    public void setDateLong(long dateLong) {
        this.dateLong = dateLong;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }
}
