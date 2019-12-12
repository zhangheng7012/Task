<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                                    <img src="/image/ren.jpg" class="table-photo">
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
                                    <img src="/image/ren.jpg" class="table-photo">
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
                                    <img src="/image/ren.jpg" class="table-photo">
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
                                    <img src="/image/ren.jpg" class="table-photo">
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
                                    <img src="/image/ren.jpg" class="table-photo">
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
