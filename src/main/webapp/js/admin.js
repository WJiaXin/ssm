var flag=0;
$(function () {

    $('#WOdate').datetimepicker({
        format: 'YYYY-MM-DD',

        locale: moment.locale('zh-cn')
    });
    $('#Sdate').datetimepicker({
        format: 'YYYY-MM-DD',

        locale: moment.locale('zh-cn')
    });

        $(".dropdown-toggle").dropdown('toggle');


});
function change(index) {
    var sel=$("select:eq("+index+")").val();
    if (sel==0) {
        $('#confirm').hide();
        $('#WOfood').css('cssText', 'display:none !important');
        $('#WOmoney').css('cssText', 'display:none !important');
    }
    if(sel==1){
        $('#WOmoney').css('cssText', 'height:40px; border:#DDD solid 1px;display:flex');
        $('#WOfood').css('cssText', 'height:40px; border:#DDD solid 1px;display:none !important');
        $('#confirm').show();
        flag=1;
    }
    if(sel==2){
        $('#WOfood').css('cssText', 'height:40px; border:#DDD solid 1px;display:flex');
        $('#WOmoney').css('cssText', 'height:40px; border:#DDD solid 1px;display:none !important');
        $('#confirm').show();
        flag=2;
    }
}
function searchWO() {
    var date=$('#WOdate').val();
    $.ajax({
        url:"/workOvertime/"+date,
        type:"get",
        success: function (data) {
            var WO=data;
            if(WO!=""&&WO!=null){
               $('select:eq(0)').val(WO.type);
                var date1 = new Date(WO.data);
                var date2 = new Date();
                var days=Math.floor((date1.getTime()-date2.getTime())/(24*3600*1000));
                console.log("days:"+days);
               if(WO.type==1){
                   $('#WOmoney').css('cssText', 'height:40px; border:#DDD solid 1px;display:flex');
                   $('#money').val(WO.award);
                   $('#WOfood').css('cssText', 'height:40px; border:#DDD solid 1px;display:none !important');
                   if(days<=0){
                       $('select:eq(0)').attr("disabled","disabled");
                       $('#money').attr("readonly","readonly")
                   }else {
                       $('#confirm').show();
                   }
               }else{
                   $('#WOfood').css('cssText', 'height:40px; border:#DDD solid 1px;display:flex');
                   $('#WOfood').val(WO.award);
                   $('#WOmoney').css('cssText', 'height:40px; border:#DDD solid 1px;display:none !important');
                   if(days<=0){
                       $('select:eq(0)').attr("disabled","disabled")
                       $('select:eq(1)').attr("disabled","disabled");
                   }else {
                       $('#confirm').show();
                   }
               }
            }else{
                $('select:eq(0)').removeAttr("disabled");
                $('select:eq(1)').removeAttr("disabled");
                $('select:eq(0)').val(0)
                $('#money').removeAttr("readonly");
                $('#confirm').hide();
                $('#WOfood').css('cssText', 'display:none !important');
                $('#WOmoney').css('cssText', 'display:none !important');
            }
        },
        error: function () {
            alert("查询失败!!!");
        }
    })
}
function confirmWO() {
    var award;
    if(flag==1){
        award=$('#money').val();
    }
    if(flag==2){
        award= $('select:eq(1)').val();
    }
    $.ajax({
        url:"/workOvertime",
        type:"post",
        data:JSON.stringify({
            "award": award,
            "data": $('#WOdate').val(),
            "type":$('select:eq(0)').val()
        }),
        contentType:"application/json",
        success: function (data) {
        },
        error: function () {
            alert("查询失败!!!");
        }

    })
}