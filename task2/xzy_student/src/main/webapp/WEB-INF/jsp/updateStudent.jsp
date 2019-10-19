<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div style="width:500px;margin:0px auto;text-align:center">

    <div style="text-align:center;margin-top:40px">
        <form method="POST" action="/students/${student.id}">
            <h3>编辑</h3>
            创建时间：<input name="createAt" value="${student.createAt}" type="text"><br/>
            更新时间：<input name="updateAt" value="${student.updateAt}"  type="text"><br/>
            姓名：   <input name="name" value="${student.name}"  type="text"><br/>
            QQ：     <input name="qq"  value="${student.qq}" type="text"><br/>
            工作类型：<input name="job"  value="${student.job}" type="text"><br/>
            入学日期：<input name="date"  value="${student.date}" type="text"><br/>
            毕业院校：<input name="school"  value="${student.school}" type="text"><br/>
            线上学号：<input name="onlineNum"  value="${student.onlineNum}" type="text"><br/>
            日报链接：<input name="daily"  value="${student.daily}" type="text"><br/>
            入学誓言：<input name="dream"  value="${student.dream}" type="text"><br/>
            辅导师兄：<input name="brother"  value="${student.brother}" type="text"><br/>
            从哪得知修真院：<input name="knowHow"  value="${student.knowHow}" type="text"><br/>
            <br><br>
            <input type="hidden" value="PUT" name="_method">
            <input type="submit" value="确认">
        </form>
    </div>
</div>
