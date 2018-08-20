//立即执行函数来实现模块化
var commonUtil=(function ($, document) {
    //设置界面样式风格
    $.jgrid.defaults.styleUI = 'Bootstrap4'
    $.jgrid.defaults.iconSet = 'Octicons'

    //实现页面loading效果
    $(document).ajaxStart(
        function (e) {
            $('#loading').show()
        }).ajaxComplete(function () {
        $('#loading').hide()
    })

    //ajax统一异常处理
    $(document).ajaxError(
        function(){
            alert('服务器开小差了！请稍后重试。')
        }
    )

    var util={};
//后续增加一些通用方法
    return util;
})($,document)


