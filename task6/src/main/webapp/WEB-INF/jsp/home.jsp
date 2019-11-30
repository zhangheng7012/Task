<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>修真院首页</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
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
                    <li class="nav-item nav-link-width">
                        <a class="nav-link active  font-size-18 nav-link-size" href="/job">职业咨询</a>
                    </li>
                    <li class="nav-item nav-link-width ">
                        <a class="nav-link active  font-size-18 nav-link-size" href="/partner">合作企业</a>
                    </li>
                    <li class="nav-item nav-link-width nav-link-reight">
                        <a class="nav-link active  font-size-18 nav-link-size " href="#">关于修真</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>
<!--轮播图-->
<div id="carouselExampleIndicators" class="carousel slide " data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active border-radius-10px"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1" class="border-radius-10px"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2" class="border-radius-10px"></li>
    </ol>
    <div class="carousel-inner carousel-fade">
        <div class="carousel-item active">
            <img class="d-block w-100" src="image/banner.png" alt="First slide">
        </div>
        <div class="carousel-item">
            <img class="d-block w-100" src="image/banner2.jpg" alt="Second slide">
        </div>
        <div class="carousel-item">
            <img class="d-block w-100" src="image/banner3.png" alt="Third slide">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<!--优势-->
<div class="container" style="padding-top: 6vw;">
    <div class="row">
        <div class="col-6 col-sm-6 col-lg-3 text-align-center sm-flex">
            <div class="height-130 sm-nowrap">
                <i class="centent-icon centent-icon-1 "></i>
                <h5>高效</h5>
            </div>
            <div class="height-100">
                <p class="color-999">将五到七年的成长时间，缩短到一年到三年。</p>
            </div>
        </div>
        <div class="col-6 col-sm-6 col-lg-3 text-align-center sm-flex">
            <div class="height-130 sm-nowrap">
                <i class="centent-icon centent-icon-2 "></i>
                <h5>规范</h5>
            </div>
            <div class="height-100 ">
                <p class="color-999">标准的实战教程，不会走弯路</p>
            </div>
        </div>
        <div class="col-6 col-sm-6 col-lg-3 text-align-center sm-flex">
            <div class="height-130 sm-nowrap">
                <i class="centent-icon centent-icon-3"></i>
                <h5>人脉</h5>
            </div>
            <div class="height-100">
                <p class="color-999">同班好友，同院学长，技术大师，入学就混入职脉圈，为以后铺平道路。</p>
            </div>
        </div>
        <div class="col-6 col-sm-6 col-lg-3 sm-flex">
            <div class="height-130 ">
                <span> <i class="samll-icon centent-icon-4 align-middle"> </i> 12400</span>
                <p class="color-999">累计在线学习人数</p>
            </div>
            <div class="height-100" style="margin-top: -20px;">
                <span> <i class="samll-icon centent-icon-4 align-middle"> </i> 12400</span>
                <p class="color-999">累计在线学习人数</p>

            </div>
        </div>
    </div>
</div>
<!--如何学习-->
<div class="container" style="padding-top: 6vw;">
    <h4>如何学习</h4>
    <div class="row padding-t10-b10">
        <div class="col-6 col-sm-6 col-lg-3 rhxx-flex-cencerxy">
            <div class="rhxx-circle">
                <span class="rhxx-cgreen-22">1</span>
            </div>
            <p class="rhxx-font">匹配你现在的个人情况寻找适合自己的岗位</p>
            <i class="samll-icon rhxx-icon1 "></i>
        </div>
        <div class="col-6 col-sm-6 col-lg-3 rhxx-flex-cencerxy">
            <div class="rhxx-circle">
                <span class="rhxx-cgreen-22">2</span>
            </div>
            <p class="rhxx-font">了解职业前景薪金待遇、竞争压力等</p>
            <i class="samll-icon rhxx-icon1 md-none"></i>
        </div>
        <div class="col-6 col-sm-6 col-lg-3 rhxx-flex-cencerxy">
            <div class="rhxx-circle">
                <span class="rhxx-cgreen-22">3</span>
            </div>
            <p class="rhxx-font">掌握行业内顶级技能</p>
            <i class="samll-icon rhxx-icon1 "></i>
        </div>
        <div class="col-6 col-sm-6 col-lg-3 rhxx-flex-cencerxy">
            <div class="rhxx-circle">
                <span class="rhxx-cgreen-22">4</span>
            </div>
            <p class="rhxx-font">查看职业目标任务</p>
        </div>
        <div class="col-6 col-sm-6 col-lg-3 rhxx-flex-cencerxy">
            <div class="rhxx-circle">
                <span class="rhxx-cgreen-22">5</span>
            </div>
            <p class="rhxx-font">参考学习资源，掌握技能点，逐个完成任务</p>
            <i class="samll-icon rhxx-icon1 "></i>
        </div>
        <div class="col-6 col-sm-6 col-lg-3 rhxx-flex-cencerxy">
            <div class="rhxx-circle">
                <span class="rhxx-cgreen-22">6</span>
            </div>
            <p class="rhxx-font">加入班级，和小伙伴们互帮互助，一块学习</p>
            <i class="samll-icon rhxx-icon1 md-none"></i>
        </div>
        <div class="col-6 col-sm-6 col-lg-3 rhxx-flex-cencerxy">
            <div class="rhxx-circle">
                <span class="rhxx-cgreen-22">7</span>
            </div>
            <p class="rhxx-font">选择导师，一路引导，加速自己成长</p>
            <i class="samll-icon rhxx-icon1 "></i>
        </div>
        <div class="col-6 col-sm-6 col-lg-3 rhxx-flex-cencerxy">
            <div class="rhxx-circle">
                <span class="rhxx-cgreen-22">8</span>
            </div>
            <p class="rhxx-font">完成职业技能，升级业界大牛</p>
        </div>
    </div>
</div>
<!---->
<div class="container" style="padding-top: 6vw;">
    <h4 class="text-center" style="padding-bottom: 20px">优秀学员展示</h4>
    <div id="carouselExampleIndicatorss" class="carousel slide " data-ride="carousel">
        <ol class="carousel-indicators margin-top-50 ">
            <li data-target="#carouselExampleIndicatorss" data-slide-to="0" class="active border-radius-10px cursor"></li>
            <li data-target="#carouselExampleIndicatorss" data-slide-to="1" class="border-radius-10px cursor"></li>

        </ol>
        <div class="carousel-inner carousel-fade">
            <div class="carousel-item active">
                <div class="row">
                    <div class=" col-sm-6 col-lg-3  text-align-center yxxx-mtb3-plf30" style="padding: 0px 20px;">
                        <div class="yxxy-container shadow-centent-5px cursor">
                            <div class="sm-nowrap">
                                <i class="yxxy-icon yxxy-icon-${students.get(0).image}"></i>
<%--                                <img src="image/${expert.image}">--%>
                                <div class="yyxy-name">  <h5>${students.get(0).profession}：</h5><h5>${students.get(0).name}</h5></div>
                            </div>
                            <span
                                    class="padding-t10-b10 color-999">${students.get(0).introduction}</span>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-3  text-align-center yxxx-mtb3-plf30" style="padding: 0px 20px;">
                        <div class="yxxy-container shadow-centent-5px cursor">
                            <div class="sm-nowrap">
                                <i class="yxxy-icon yxxy-icon-${students.get(1).image}"></i>
                                <%--                                <img src="image/${expert.image}">--%>
                                <div class="yyxy-name">  <h5>${students.get(1).profession}：</h5><h5>${students.get(1).name}</h5></div>
                            </div>
                            <span
                                    class="padding-t10-b10 color-999">${students.get(1).introduction}</span>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-3  text-align-center yxxx-mtb3-plf30" style="padding: 0px 20px; ">
                        <div class="yxxy-container shadow-centent-5px cursor">
                            <div class="sm-nowrap">
                                <i class="yxxy-icon yxxy-icon-${students.get(2).image}"></i>
                                <%--                                <img src="image/${expert.image}">--%>
                                <div class="yyxy-name">  <h5>${students.get(2).profession}：</h5><h5>${students.get(2).name}</h5></div>
                            </div>
                            <span
                                    class="padding-t10-b10 color-999">${students.get(2).introduction}</span>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-3 text-align-center yxxx-mtb3-plf30 " style="padding: 0px 20px;">
                        <div class="yxxy-container shadow-centent-5px cursor">
                            <div class="sm-nowrap">
                                <i class="yxxy-icon yxxy-icon-${students.get(3).image}"></i>
<%--                                <img src="image/${expert.image}">--%>
                                <div class="yyxy-name">  <h5>${students.get(3).profession}：</h5><h5>${students.get(3).name}</h5></div>
                            </div>
                            <span
                                    class="padding-t10-b10 color-999">${students.get(3).introduction}</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="row">
                    <div class=" col-sm-6 col-lg-3  text-align-center yxxx-mtb3-plf30" style="padding: 0px 20px;">
                        <div class="yxxy-container shadow-centent-5px cursor">
                            <div class="sm-nowrap">
                                <i class="yxxy-icon yxxy-icon-${students.get(4).image}"></i>
                                <%--                                <img src="image/${expert.image}">--%>
                                <div class="yyxy-name">  <h5>${students.get(4).profession}：</h5><h5>${students.get(4).name}</h5></div>
                            </div>
                            <span
                                    class="padding-t10-b10 color-999">${students.get(4).introduction}</span>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-3  text-align-center yxxx-mtb3-plf30" style="padding: 0px 20px;">
                        <div class="yxxy-container shadow-centent-5px cursor">
                            <div class="sm-nowrap">
                                <i class="yxxy-icon yxxy-icon-${students.get(5).image}"></i>
                                <%--                                <img src="image/${expert.image}">--%>
                                <div class="yyxy-name">  <h5>${students.get(5).profession}：</h5><h5>${students.get(5).name}</h5></div>
                            </div>
                            <span
                                    class="padding-t10-b10 color-999">${students.get(5).introduction}</span>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-3  text-align-center yxxx-mtb3-plf30" style="padding: 0px 20px; ">
                        <div class="yxxy-container shadow-centent-5px cursor">
                            <div class="sm-nowrap">
                                <i class="yxxy-icon yxxy-icon-${students.get(6).image}"></i>
                                <%--                                <img src="image/${expert.image}">--%>
                                <div class="yyxy-name">  <h5>${students.get(6).profession}：</h5><h5>${students.get(6).name}</h5></div>
                            </div>
                            <span
                                    class="padding-t10-b10 color-999">${students.get(6).introduction}</span>
                        </div>
                    </div>
                    <div class="col-sm-6 col-lg-3 text-align-center yxxx-mtb3-plf30 " style="padding: 0px 20px;">
                        <div class="yxxy-container shadow-centent-5px cursor">
                            <div class="sm-nowrap">
                                <i class="yxxy-icon yxxy-icon-${students.get(7).image}"></i>
                                <%--                                <img src="image/${expert.image}">--%>
                                <div class="yyxy-name">  <h5>${students.get(7).profession}：</h5><h5>${students.get(7).name}</h5></div>
                            </div>
                            <span
                                    class="padding-t10-b10 color-999">${students.get(7).introduction}</span>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicatorss" role="button" data-slide="prev">
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicatorss" role="button" data-slide="next">
        </a>
    </div>

    <!--第三部分开始-->
<%--    <div class="container" style="padding-top: 6vw;">
        <h4 class="text-center" style="padding-bottom: 20px">优秀学员展示</h4>
        <ul class="list-unstyled text-center">
            <c:forEach var="expert" items="${students}">
                <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
&lt;%&ndash;                    <i class="yxxy-icon yxxy-icon-1"></i>&ndash;%&gt;
                    <div>
                        <img src="image/students108px.png">
                        <span>${expert.profession}:${expert.name}</span>
                        <p class="text-left">${expert.introduction}</p>
&lt;%&ndash;                        <p><ms:Date value="${expert.createAt}"/></p>&ndash;%&gt;
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>--%>

    <!--合作企业-->
    <div style="padding-top: 6vw;margin-top:50px;">
        <h4 class="text-center">战略合作企业</h4>
        <div class="hzqy shadow-centent-2px">
            <div class="partner-xy-cercen">
                <i class="partner partner-1 "></i>
            </div>
            <div class="partner-xy-cercen">
                <i class="partner partner-2 "></i>
            </div>
            <div class="partner-xy-cercen">
                <i class="partner partner-3 "></i>
            </div>
            <div class="partner-xy-cercen">
                <i class="partner partner-4 "></i>
            </div>
            <div class="partner-xy-cercen">
                <i class="partner partner-5 "></i>
            </div>
        </div>
    </div>
</div>
<!--友情链接-->
<div class="yqlj none-690" style="margin-top: 6vw;">
    <h4 class="text-center" style="padding-bottom: 20px ">友情链接</h4>

    <div>
        <ul>
            <li>手机软件</li>
            <li>教师招聘</li>
            <li>手机软件</li>
            <li>教师招聘</li>
            <li>手机软件</li>
            <li>教师招聘</li>
            <li>手机软件</li>
            <li>教师招聘</li>
            <li>手机软件</li>
            <li>教师招聘</li>
            <li>手机软件</li>
            <li>教师招聘</li>
            <li>手机软件</li>
            <li>教师招聘</li>
            <li>手机软件</li>
            <li>教师招聘</li>
            <li>手机软件</li>
            <li>教师招聘</li>
            <li>手机软件</li>
            <li>教师招聘</li>
        </ul>
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