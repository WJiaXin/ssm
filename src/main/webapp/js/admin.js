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
    }
    if(sel==2){
        $('#WOfood').css('cssText', 'height:40px; border:#DDD solid 1px;display:flex');
        $('#WOmoney').css('cssText', 'height:40px; border:#DDD solid 1px;display:none !important');
        $('#confirm').show();
    }
}