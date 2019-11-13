package com.jnshu.tag;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleTagDate extends SimpleTagSupport {
    /**
     * @Description: long 时间
     */
    private long dateLong;

    /**
     * @Description: String类型的格式
     */
    private String dateType;

    @Override
    public void doTag() {
        try {
            JspWriter out = getJspContext().getOut();
            SimpleDateFormat sdf = new SimpleDateFormat(dateType);
            Date date = new Date(dateLong);
            String dateString = sdf.format(date);
            out.write(dateString);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
