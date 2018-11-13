/**
 * @param iDisplayStart 当前查询页码
 * @param iTotalPages 总页数
 */
function pageUIChange(iDisplayStart,iTotalPages){
    var html="";
    if(iDisplayStart==1){
        html+='<li class="disabled"><a href="javascript:;">首页</a></li>';
    }else{
        html+='<li><a href="javascript:;" onclick="'+pageClick+'(1)">首页</a></li>';
    }

    var start = iDisplayStart-2;
    if(iDisplayStart-2<=0){
        start = iDisplayStart-1;
    }

    for (var i=0;i<5;i++){
        if (start>0){
            if(start==iDisplayStart){
                html+='<li class="active"><a href="javascript:;">'+start+'</a></li>';
            }else{
                html+='<li><a href="javascript:;" onclick="'+pageClick+'('+start+')">'+start+'</a></li>';
            }
        }
        if (start==iTotalPages){
            break;
        }
        start++;
    }
    if(iDisplayStart==iTotalPages){
        html+='<li class="disabled"><a href="javascript:;">尾页</a></li>';
    }else{
        html+='<li><a href="javascript:;" onclick="'+pageClick+'('+iTotalPages+')">尾页</a></li>';
    }
    $("#pageUL").html(html);
}