<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--<script src="/webjars/jquery/3.3.1-2/jquery.min.js"></script>--%>

<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>

<!--第一步：借助于JQuery将超链接请求的方式从get改为post方式，引入jquery-->
<!-- <script type="text/javascript" src="js/jquery.min.js"></script> -->
<script type="text/javascript">
    // 为所有的class为delete的按钮点击动作添加行为函数
    $(function(){
        $(".delete").click(function(){
            // 获取class为delete的超链接的地址
            var href=$(this).attr("href");
            // 为隐藏域的action赋值并提交
            $("#formdelete").attr("action",href).submit();
            return false;
        })
    })
</script>
<!--第二步：创建含有隐藏域的表单请求-->
<form id="formdelete" action="" method="POST" >
    <!--这里的name必须是 _method ，value的值就是要转成的新的请求方式，如果
    没有SpringMVC的delete方式，可以忽略这一行，直接写一个空表单即可-->
    <input type="hidden" name="_method" value="DELETE">
</form>

<div style="margin-top:20px;text-align:center">
    <h2>学员名单表</h2>
</div>

<div style="text-align:center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <th>序号</th>
            <th>创建时间</th>
            <th>更新时间</th>
            <th>姓名</th>
            <th>QQ</th>
            <th>工作类型</th>
            <th>入学日期</th>
            <th>毕业院校</th>
            <th>线上学号</th>
            <th>日报链接</th>
            <th>入学誓言</th>
            <th>辅导师兄</th>
            <th>从哪得知修真院</th>
            <th colspan="2">操作</th>
        </tr>
        <c:forEach items="${pageInfo.list}" var="student" varStatus="st">
            <tr>
                <td>${student.id}</td>
                <td>${student.createAt}</td>
                <td>${student.updateAt}</td>
                <td>${student.name}</td>
                <td>${student.qq}</td>
                <td>${student.job}</td>
                <td>${student.date}</td>
                <td>${student.school}</td>
                <td>${student.onlineNum}</td>
                <td>${student.daily}</td>
                <td>${student.dream}</td>
                <td>${student.brother}</td>
                <td>${student.knowHow}</td>

                <td><a href="/students/${student.id}">编辑</a></td>

                <!--第三步：为超链接添加class属性，根据class改变其请求方式-->
                <td><a class="delete" href="/students/${student.id}">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="15">
                <a href="/students/student">添加</a>
            </td>
        </tr>
    </table>
    <br/>

    <%--
        <div style="text-align:center">
            <a href="?start=0">首  页</a>
            <c:if test="${page.start-page.count>=0}">
                <a href="?start=${page.start-page.count}">上一页</a>
            </c:if>
            <c:if test="${page.start-page.count<0}">
                <a>上一页</a>
            </c:if>
            <a href="?start=${page.start+page.count}">下一页</a>
            <a href="?start=${page.last}">末  页</a>
        </div>--%>

    <!--显示分页信息-->
    <div class="row">
        <!--文字信息-->
        <div class="col-md-6">
            当前第 ${pageInfo.pageNum} 页.总共 ${pageInfo.pages} 页.一共 ${pageInfo.total} 条记录
        </div>

        <!--点击分页-->
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">

                    <a href="${pageContext.request.contextPath}/students?pn=1">首页</a>

                    <!--上一页-->
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <a href="${pageContext.request.contextPath}/students?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                            <span aria-hidden="true">上一页</span>
                        </a>
                    </c:if>

                    <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
                    <%--                    <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
                                            <c:if test="${page_num == pageInfo.pageNum}">
                                                <li class="active"><a href="#">${page_num}</a></li>
                                            </c:if>
                                            <c:if test="${page_num != pageInfo.pageNum}">
                                                <li><a href="${pageContext.request.contextPath}/listStudent?pn=${page_num}">${page_num}</a></li>
                                            </c:if>
                                        </c:forEach>--%>

                    <!--下一页-->
                    <c:if test="${pageInfo.hasNextPage}">
                        <a href="${pageContext.request.contextPath}/students?pn=${pageInfo.pageNum+1}"
                           aria-label="Next">
                            <span aria-hidden="true">下一页</span>
                        </a>
                    </c:if>

                    <a href="${pageContext.request.contextPath}/students?pn=${pageInfo.pages}">尾页</a>
                </ul>
            </nav>
        </div>

    </div>

</div>


