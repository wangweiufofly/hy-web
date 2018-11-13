function queryNewses(iDisplayStart){
    $.ajax({
        type: "POST",
        url: getFormatUrl("/queryNewses"),
        data: {
            iDisplayStart:iDisplayStart
        },
        success: function(msg){
            if(msg.result == "1"){
                doSetNewses(msg.aaData);
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
function doSetNewses(newses){
    var html = "";
    for (index in newses)
    {
        html+='<div class="col-md-3 m-b-10 f-s-10">';
        html+='     <div class="card">';
        html+='         <img class="card-img-top" src="'+newses[index].shareImg+'" alt="">';
        html+='         <div class="card-block">';
        html+='             <h4 class="card-title m-t-0 m-b-10">'+newses[index].newsName+'</h4>';
        html+='             <p class="card-text">'+newses[index].newsTitle+'</p>';
        html+='             <a href="#" class="btn btn-sm btn-primary">'+newses[index].createTimeDesc+'</a>';
        html+='          </div>';
        html+='      </div>';
        html+='</div>';
    }
    $("#newsDiv").html(html);
}