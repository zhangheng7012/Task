<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>职业选择</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://at.alicdn.com/t/font_1265859_zipkzty67op.css">
    <link rel="stylesheet" type="text/css" href="css/task8-2.css">
</head>

<body>
<header class=" container  none">
    <div class="d-flex justify-content-between align-items-center">
            <span class="color-main font-size-14">
                客服热线：010-594-78634
            </span>
        <div class="d-flex align-items-center">
            <i class="samll-icon nav-icon-1 cursor"></i>
            <i class="samll-icon nav-icon-2 cursor"></i>
            <i class="samll-icon nav-icon-3 cursor"></i>
        </div>
    </div>
</header>
<nav class="bg-main">
    <div class="container">
        <div class="navbar navbar-expand-md  navbar-dark">
            <a class="navbar-brand" href="/home"><img src="image/home-logo.png" class="nav-logo"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active nav-link-width">
                        <a class="nav-link font-size-18 nav-link-size" href="/home">首页机缘</a>
                    </li>
                    <li class="nav-item nav-link-width qwe">
                        <a class="nav-link active  font-size-18 nav-link-size" href="/job">职业咨询</a>
                    </li>
                    <li class="nav-item nav-link-width ">
                        <a class="nav-link active font-size-18 nav-link-size" href="/partner">合作企业</a>
                    </li>
                    <li class="nav-item nav-link-width nav-link-reight">
                        <a class="nav-link active  font-size-18 nav-link-size " href="#">关于修真</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>
<div class="container">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/home" style="color: #000">首页</a></li>
        <li class="breadcrumb-item active" style="color: #29b078;">职业</li>
    </ol>
    <div class="d-flex noflex-768"><span style="color: #999;line-height: 36px;">方向：</span>
        <ul class="pagination pagination-md" style="flex-wrap: wrap;">
            <li class="page-item"><a class="page-link page-link-noborder active" href="#">全部</a></li>
            <li class="page-item"><a class="page-link page-link-noborder" href="#houduankaifa">后端开发</a></li>
            <li class="page-item"><a class="page-link page-link-noborder" href="#qianduankaifa">前端开发</a></li>
            <li class="page-item"><a class="page-link page-link-noborder" href="#yidongkaifa">移动开发</a></li>
            <li class="page-item"><a class="page-link page-link-noborder" href="#zhengzhankaifa">整站开发</a></li>
            <li class="page-item"><a class="page-link page-link-noborder" href="#yunyingweihu">运营维护</a></li>
        </ul>
    </div>
    <div id="houduankaifa">
        <p>后端开发方向</p>
        <hr>

        <div class="row">

        <c:forEach var="java" items="${javaList}">

            <div class=" col-12 col-md-6 col-lg-4 table-div">
                <div class="shadow-centent-5px po-a-hidden">
                    <div class="table-job-hover">
                        <p>iOS工程师</p>
                        <span> iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开
                                发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内 iOS开发起步相对较晚，人才培养机制
                                更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</span>
                    </div>
                    <table class="font-s12-c999">
                        <tr>
                            <td colspan="5">
                                <img src="image/ren.jpg" class="table-photo">
                            </td>
                            <td style="padding: 10px" colspan="7">
                                <h5 class="color-333">${java.profession}</h5>
                                <span class="font-14">${java.introduction}
                                    </span>
                            </td>
                        </tr>
                        <tr class="table-tr">
                            <td colspan="6"><span class="color-999">门槛</span><i class="iconfont">${java.threshold}&#xe61a;</i></td>
                            <td colspan="6"><span class="color-999">难易程度</span> <i
                                    class="iconfont">${java.difficult}&#xe61a;</i></td>
                        </tr>
                        <tr class="table-tr">
                            <td colspan="6"><span class="color-999">成长周期</span> &emsp;<span
                                    class="c-orangen">${java.period}</span></td>
                            <td colspan="6"><span class="color-999 table-line color-999">稀缺程度</span>&emsp;<div
                                    class="table-xique"><span class="c-orangen">${java.importance}</span>家公司需要</div>
                            </td>
                        </tr>
                        <tr class="table-tr">
                            <td rowspan="3" colspan="4" class="text-align-center">薪资待遇</td>
                            <td class="color-333" colspan="8">0-1年<span class="float-r">${java.salaryOne}/月</span></td>
                        </tr>
                        <tr class="table-tr">
                            <td class="color-333" colspan="8">1-3年<span class="float-r">${java.salaryTwo}/月</span></td>
                        </tr>
                        <tr class="table-tr">
                            <td class="color-333" colspan="8">3-5年<span class="float-r">${java.salaryThree}/月</span></td>
                        </tr>
                        <tr>
                            <th class="table-tr color-333 font-14" colspan="12">有<span
                                    class="c-orangen">${java.studyNum}</span>人在学</th>
                        </tr>
                        <tr>
                            <td class="table-tr" colspan="12">提示:${java.point}</td>
                        </tr>
                    </table>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>

    <div id="qianduankaifa">
        <p>前端开发方向</p>
        <hr>
        <div class="row">
            <c:forEach var="java" items="${webList}">

                <div class=" col-12 col-md-6 col-lg-4 table-div">
                    <div class="shadow-centent-5px po-a-hidden">
                        <div class="table-job-hover">
                            <p>iOS工程师</p>
                            <span> iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开
                                发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内 iOS开发起步相对较晚，人才培养机制
                                更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</span>
                        </div>
                        <table class="font-s12-c999">
                            <tr>
                                <td colspan="5">
                                    <img src="image/ren.jpg" class="table-photo">
                                </td>
                                <td style="padding: 10px" colspan="7">
                                    <h5 class="color-333">${java.profession}</h5>
                                    <span class="font-14">${java.introduction}
                                    </span>
                                </td>
                            </tr>
                            <tr class="table-tr">
                                <td colspan="6"><span class="color-999">门槛</span><i class="iconfont">${java.threshold}&#xe61a;</i></td>
                                <td colspan="6"><span class="color-999">难易程度</span> <i
                                        class="iconfont">${java.difficult}&#xe61a;</i></td>
                            </tr>
                            <tr class="table-tr">
                                <td colspan="6"><span class="color-999">成长周期</span> &emsp;<span
                                        class="c-orangen">${java.period}</span></td>
                                <td colspan="6"><span class="color-999 table-line color-999">稀缺程度</span>&emsp;<div
                                        class="table-xique"><span class="c-orangen">${java.importance}</span>家公司需要</div>
                                </td>
                            </tr>
                            <tr class="table-tr">
                                <td rowspan="3" colspan="4" class="text-align-center">薪资待遇</td>
                                <td class="color-333" colspan="8">0-1年<span class="float-r">${java.salaryOne}/月</span></td>
                            </tr>
                            <tr class="table-tr">
                                <td class="color-333" colspan="8">1-3年<span class="float-r">${java.salaryTwo}/月</span></td>
                            </tr>
                            <tr class="table-tr">
                                <td class="color-333" colspan="8">3-5年<span class="float-r">${java.salaryThree}/月</span></td>
                            </tr>
                            <tr>
                                <th class="table-tr color-333 font-14" colspan="12">有<span
                                        class="c-orangen">${java.studyNum}</span>人在学</th>
                            </tr>
                            <tr>
                                <td class="table-tr" colspan="12">提示:${java.point}</td>
                            </tr>
                        </table>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <div id="yidongkaifa">
        <p>移动开发方向</p>
        <hr>
        <div class="row">
            <c:forEach var="java" items="${iosList}">

                <div class=" col-12 col-md-6 col-lg-4 table-div">
                    <div class="shadow-centent-5px po-a-hidden">
                        <div class="table-job-hover">
                            <p>iOS工程师</p>
                            <span> iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开
                                发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内 iOS开发起步相对较晚，人才培养机制
                                更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</span>
                        </div>
                        <table class="font-s12-c999">
                            <tr>
                                <td colspan="5">
                                    <img src="image/ren.jpg" class="table-photo">
                                </td>
                                <td style="padding: 10px" colspan="7">
                                    <h5 class="color-333">${java.profession}</h5>
                                    <span class="font-14">${java.introduction}
                                    </span>
                                </td>
                            </tr>
                            <tr class="table-tr">
                                <td colspan="6"><span class="color-999">门槛</span><i class="iconfont">${java.threshold}&#xe61a;</i></td>
                                <td colspan="6"><span class="color-999">难易程度</span> <i
                                        class="iconfont">${java.difficult}&#xe61a;</i></td>
                            </tr>
                            <tr class="table-tr">
                                <td colspan="6"><span class="color-999">成长周期</span> &emsp;<span
                                        class="c-orangen">${java.period}</span></td>
                                <td colspan="6"><span class="color-999 table-line color-999">稀缺程度</span>&emsp;<div
                                        class="table-xique"><span class="c-orangen">${java.importance}</span>家公司需要</div>
                                </td>
                            </tr>
                            <tr class="table-tr">
                                <td rowspan="3" colspan="4" class="text-align-center">薪资待遇</td>
                                <td class="color-333" colspan="8">0-1年<span class="float-r">${java.salaryOne}/月</span></td>
                            </tr>
                            <tr class="table-tr">
                                <td class="color-333" colspan="8">1-3年<span class="float-r">${java.salaryTwo}/月</span></td>
                            </tr>
                            <tr class="table-tr">
                                <td class="color-333" colspan="8">3-5年<span class="float-r">${java.salaryThree}/月</span></td>
                            </tr>
                            <tr>
                                <th class="table-tr color-333 font-14" colspan="12">有<span
                                        class="c-orangen">${java.studyNum}</span>人在学</th>
                            </tr>
                            <tr>
                                <td class="table-tr" colspan="12">提示:${java.point}</td>
                            </tr>
                        </table>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <div id="zhengzhankaifa">
        <p>整站开发方向</p>
        <hr>
        <div class="row">
            <c:forEach var="java" items="${allList}">

                <div class=" col-12 col-md-6 col-lg-4 table-div">
                    <div class="shadow-centent-5px po-a-hidden">
                        <div class="table-job-hover">
                            <p>iOS工程师</p>
                            <span> iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开
                                发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内 iOS开发起步相对较晚，人才培养机制
                                更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</span>
                        </div>
                        <table class="font-s12-c999">
                            <tr>
                                <td colspan="5">
                                    <img src="image/ren.jpg" class="table-photo">
                                </td>
                                <td style="padding: 10px" colspan="7">
                                    <h5 class="color-333">${java.profession}</h5>
                                    <span class="font-14">${java.introduction}
                                    </span>
                                </td>
                            </tr>
                            <tr class="table-tr">
                                <td colspan="6"><span class="color-999">门槛</span><i class="iconfont">${java.threshold}&#xe61a;</i></td>
                                <td colspan="6"><span class="color-999">难易程度</span> <i
                                        class="iconfont">${java.difficult}&#xe61a;</i></td>
                            </tr>
                            <tr class="table-tr">
                                <td colspan="6"><span class="color-999">成长周期</span> &emsp;<span
                                        class="c-orangen">${java.period}</span></td>
                                <td colspan="6"><span class="color-999 table-line color-999">稀缺程度</span>&emsp;<div
                                        class="table-xique"><span class="c-orangen">${java.importance}</span>家公司需要</div>
                                </td>
                            </tr>
                            <tr class="table-tr">
                                <td rowspan="3" colspan="4" class="text-align-center">薪资待遇</td>
                                <td class="color-333" colspan="8">0-1年<span class="float-r">${java.salaryOne}/月</span></td>
                            </tr>
                            <tr class="table-tr">
                                <td class="color-333" colspan="8">1-3年<span class="float-r">${java.salaryTwo}/月</span></td>
                            </tr>
                            <tr class="table-tr">
                                <td class="color-333" colspan="8">3-5年<span class="float-r">${java.salaryThree}/月</span></td>
                            </tr>
                            <tr>
                                <th class="table-tr color-333 font-14" colspan="12">有<span
                                        class="c-orangen">${java.studyNum}</span>人在学</th>
                            </tr>
                            <tr>
                                <td class="table-tr" colspan="12">提示:${java.point}</td>
                            </tr>
                        </table>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <div id="yunyingweihu">
        <p>运营维护方向</p>
        <hr>
        <div class="row">
            <c:forEach var="java" items="${opList}">

                <div class=" col-12 col-md-6 col-lg-4 table-div">
                    <div class="shadow-centent-5px po-a-hidden">
                        <div class="table-job-hover">
                            <p>iOS工程师</p>
                            <span> iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开
                                发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内 iOS开发起步相对较晚，人才培养机制
                                更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</span>
                        </div>
                        <table class="font-s12-c999">
                            <tr>
                                <td colspan="5">
                                    <img src="image/ren.jpg" class="table-photo">
                                </td>
                                <td style="padding: 10px" colspan="7">
                                    <h5 class="color-333">${java.profession}</h5>
                                    <span class="font-14">${java.introduction}
                                    </span>
                                </td>
                            </tr>
                            <tr class="table-tr">
                                <td colspan="6"><span class="color-999">门槛</span><i class="iconfont">${java.threshold}&#xe61a;</i></td>
                                <td colspan="6"><span class="color-999">难易程度</span> <i
                                        class="iconfont">${java.difficult}&#xe61a;</i></td>
                            </tr>
                            <tr class="table-tr">
                                <td colspan="6"><span class="color-999">成长周期</span> &emsp;<span
                                        class="c-orangen">${java.period}</span></td>
                                <td colspan="6"><span class="color-999 table-line color-999">稀缺程度</span>&emsp;<div
                                        class="table-xique"><span class="c-orangen">${java.importance}</span>家公司需要</div>
                                </td>
                            </tr>
                            <tr class="table-tr">
                                <td rowspan="3" colspan="4" class="text-align-center">薪资待遇</td>
                                <td class="color-333" colspan="8">0-1年<span class="float-r">${java.salaryOne}/月</span></td>
                            </tr>
                            <tr class="table-tr">
                                <td class="color-333" colspan="8">1-3年<span class="float-r">${java.salaryTwo}/月</span></td>
                            </tr>
                            <tr class="table-tr">
                                <td class="color-333" colspan="8">3-5年<span class="float-r">${java.salaryThree}/月</span></td>
                            </tr>
                            <tr>
                                <th class="table-tr color-333 font-14" colspan="12">有<span
                                        class="c-orangen">${java.studyNum}</span>人在学</th>
                            </tr>
                            <tr>
                                <td class="table-tr" colspan="12">提示:${java.point}</td>
                            </tr>
                        </table>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<div class="bgcolor-main">
    <div class="foot">
        <div class="d-flex between-690">
            <div class="d-flex justify-content-between flex-direction-column">
                <p>技能树-改变你我</p>
                <span class="text-14"><a href="#">关于我们</a>丨<a href="#">联系我们</a>丨<a href="#">合作企业</a></span>
            </div>
            <div class="margin-l50">
                <p>旗下网站</p>
                <ul class="foot-qxwz text-14 ">
                    <li><a href="#">草船云孵化器</a></li>
                    <li><a href="#">最强IT特训营</a></li>
                    <li><a href="#">葡萄藤轻游戏</a></li>
                    <li><a href="#">桌游精灵</a></li>
                </ul>
            </div>
        </div>
        <div class="margin-t20-b10 none-690">
            <h6>扫码了解更多</h6>
            <img src="image/weima.jpg">
        </div>
    </div>
    <hr class="bgcolor-fff">
    <span class="foot-beian width-90">
            Copyright © 2015技能树 www.jnshu.com All Rights Reserved | 京ICP备13005880号
        </span>
</div>
</body>
</html>