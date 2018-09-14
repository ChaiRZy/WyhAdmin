function sub(fid,furl) {
    $.ajax({
        url:$("#"+fid)[0].action,
        mathod:$("#"+fid)[0].mathod,
        data:$("#"+fid).serialize(),
        success:function (obj) {
            if(obj.code==1){
                location.href=furl;
            }else {
                layer.msg("账号或密码错误");
            }
        }
    });
}