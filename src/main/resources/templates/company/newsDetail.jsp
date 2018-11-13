<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" uri="http://www.hy.com/tag" %>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>公司新闻</title>

    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <l:companyResource/>
    <style type="text/css">
        /*.search-container .search-sidebar{*/
        /*width:20%;*/
        /*}*/
        /*.search-container .search-content{*/
        /*width:80%;*/
        /*}*/
        .item.item-thumbnail{
            height: 240px;
            padding: 2px;
        }
        .item.item-thumbnail .item-image{
            height: 230px;
            padding: 2px;
        }
        .item.item-thumbnail .item-image img {
            height: 100%;
            border-radius: 5px 5px 0 0;
            box-shadow: 0 6px 15px -6px #000;
        }
    </style>
</head>
<l:companyBody>
    <!-- BEGIN #page-header -->
    <div id="page-header" class="section-container page-header-container bg-black">
        <!-- BEGIN page-header-cover -->
        <div class="page-header-cover">
            <img src="${context}/commerce/assets/img/apple-cover.jpg" alt="" />
        </div>
        <!-- END page-header-cover -->
        <!-- BEGIN container -->
        <div class="container">
            <h1 class="page-header" id="product-header"><b>中意广告</b>:${productName}</h1>
        </div>
        <!-- END container -->
    </div>
    <!-- BEGIN #page-header -->

    <!-- BEGIN search-results -->
    <div id="search-results" class="section-container bg-silver">
        <!-- BEGIN container -->
        <div class="container">
            <!-- BEGIN search-container -->
            <div class="search-container">
                <!-- BEGIN search-content -->
                <div class="search-content">
                    <!-- BEGIN search-toolbar -->
                    <div class="search-toolbar">
                        <!-- BEGIN row -->
                        <div class="row">
                            <ol class="breadcrumb pull-right">
                                <li><a href="${context}/index.do">首页</a></li>
                                <li class="active">产品</li>
                            </ol>
                        </div>
                        <!-- END row -->
                    </div>
                    <!-- END search-toolbar -->
                    <!-- BEGIN search-item-container -->
                    <div class="search-item-container">
                        <!-- BEGIN item-row -->
                        <div class="item-row image gallery-group" id="imageDiv">

                            <c:forEach var="data" items="${productImgs}">

                                <!-- BEGIN item -->
                                <div class="item item-thumbnail image-inner">

                                    <a href="${context}${data.imgSrc}" class="item-image" data-lightbox="gallery-group">

                                        <img src="${context}${data.imgSrc}" alt="" />
                                        <!-- <div class="discount">15% OFF</div> -->
                                    </a>
                                        <%--<div class="item-info">--%>
                                        <%--</div>--%>
                                </div>
                                <!-- END item -->
                            </c:forEach>
                        </div>
                        <!-- END item-row -->
                    </div>
                    <!-- END search-item-container -->
                    <!-- BEGIN pagination -->
                    <div class="text-center">
                        <ul class="pagination m-t-0" id="pageUL">
                                <%--<li class="disabled"><a href="javascript:;">首页</a></li>--%>
                                <%--<li class="disabled"><a href="javascript:;">上一页</a></li>--%>
                                <%--<li class="active"><a href="javascript:;">1</a></li>--%>
                                <%--<li><a href="javascript:;">2</a></li>--%>
                                <%--<li><a href="javascript:;">3</a></li>--%>
                                <%--<li><a href="javascript:;">4</a></li>--%>
                                <%--<li><a href="javascript:;">5</a></li>--%>
                                <%--<li><a href="javascript:;">下一页</a></li>--%>
                                <%--<li><a href="javascript:;">尾页</a></li>--%>
                        </ul>
                    </div>
                    <!-- END pagination -->
                </div>
                <!-- END search-content -->
                <!-- BEGIN search-sidebar -->
                <div class="search-sidebar">
                    <h4 class="title">产品列表</h4>
                    <ul class="search-category-list">
                        <c:forEach var="data" items="${products}">
                            <li><a href="#" onclick="doProductQuery(${data.productId},'${data.productName}')">${data.productName} <span class="pull-right">(${data.imgNum})</span></a></li>
                        </c:forEach>
                    </ul>
                </div>
                <!-- END search-sidebar -->
            </div>
            <!-- END search-container -->
        </div>
        <!-- END container -->
    </div>
    <!-- END search-results -->

</l:companyBody>
<script>
    var productId=${productId};
    this.doSetPages(1,${iTotalPages});


    function doProductQuery(productIdDMP,productNameDMP){
        productId = productIdDMP;
        $("#product-header").html("<b>中意广告</b>:"+productNameDMP);
        doQuery(1);
    }

    function doQuery(iDisplayStart){
        $.ajax({
            type: "POST",
            url: "<c:url value="/queryProductImgs.do"/>",
            data: {
                productId:productId,
                iDisplayStart:iDisplayStart
            },
            success: function(msg){
                if(msg.result == "1"){
                    doSetImgs(msg.aaData);
                    doSetPages(iDisplayStart,msg.iTotalPages);
                }
            },
            error:function(msg){
            }
        });
    }

    /**
     * @param iDisplayStart 当前查询页码
     * @param iTotalPages 总页数
     */
    function doSetImgs(imgs){
        var html = "";
        for (index in imgs)
        {
            html+='<div class="item item-thumbnail image-inner">';
            html+='<a href="${context}'+imgs[index].imgSrc+'" class="item-image" data-lightbox="gallery-group">';
            html+='<img src="${context}'+imgs[index].imgSrc+'" alt="" />';
            html+='</a> </div>';
        }
        $("#imageDiv").html(html);
    }
</script>
</html>

