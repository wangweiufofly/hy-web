;
(function (window) {
    window.activeConfig = {
        rootpath: document.location.protocol + "//${web.rootpath}",
        consolepath : document.location.protocol + "//${web.consolepath}",
        root: "${web.root}",
        domain: "${web.domain}",
        cookie: "${web.cookie}"
    };
})(window);

function getFormatUrl(originUrl){
    var index = originUrl.indexOf("/");
    if (index==0){
        return basePath + originUrl.substring(1);
    }else {
        return basePath + originUrl;
    }
}
function doQueryProduct(){
    $.ajax({
        type: "POST",
        url: getFormatUrl("/queryMenuInfo"),
        success: function(msg){
            if(msg.result == "1"){
                doSetMenu(msg.products);
                doSetFooter(msg.company);
            }
        },
        error:function(msg){
        }
    });
}
/**
 * @param products
 */
function doSetMenu(products){
    var html = "";

    for (index in products)
    {
        html+='<li><a href="'+getFormatUrl("/product?productId=")+products[index].productId+'">'+products[index].productName+'</a></li>';
    }
    $("#product-menu").html(html);
}

/**
 * @param company
 */
function doSetFooter(company){
    var html = "<strong>地址:</strong><br />";
    html+=company.address+'<br /><br />';
    html+='<abbr title="Phone">电话:</abbr> '+company.phoneJson+'<br />';
    html+='<abbr title="Email">邮箱:</abbr> <a href="mailto:'+company.email+'">'+company.email+'</a><br />';
    $("#company-address").html(html);
    var logoSrc = getFormatUrl(company.imgSrc);
    $("#company-footer-logo").html('<img class="card-img-top" src="'+logoSrc+'" alt="">');
    $("#company-header-logo").attr("src", logoSrc);
    $("#company-copyright").html(company.companyName+" 版权所有");
}