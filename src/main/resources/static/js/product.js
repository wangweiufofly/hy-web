function doProductQuery(productIdDMP,productNameDMP){
    productId = productIdDMP;
    $("#product-header").html("<b>中意广告</b>:"+productNameDMP);
    queryProductImgs(1);
}

function queryProductImgs(iDisplayStart){
    $.ajax({
        type: "POST",
        url: getFormatUrl("/queryProductImgs"),
        data: {
            productId:productId,
            iDisplayStart:iDisplayStart
        },
        success: function(msg){
            if(msg.result == "1"){
                doSetImgs(msg.aaData);
                pageUIChange(iDisplayStart,msg.itotalPages);
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
        html+='<a href="'+imgs[index].imgSrc+'" class="item-image" data-lightbox="gallery-group">';
        html+='<img src="'+imgs[index].imgSrc+'" alt="" />';
        html+='</a> </div>';
    }
    $("#imageDiv").html(html);
}