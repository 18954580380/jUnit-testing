<%@ taglib prefix="aa" uri="http://com.nerderg/ajaxanywhere" %>
 <%--
  Created by IntelliJ IDEA.
  User: huhongchun
  Date: 2018/8/11
  Time: 下午12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<aa:zone id="main">
    <section class="operation-area">
        <a class="btn btn-outline-primary btn-sm mr-1" href="/order/input" aa-refresh-zones="main"  role="button">新建</a>
        <button type="button" class="btn btn-outline-primary btn-sm mr-1" >删除</button>
    </section>
    <section class="main-content">
        <table id="grid"></table>
        <div id="jqGridPager"></div>
    </section>
    <script>
        var dataArray = [
            {name: 'Bob', phone: '232-532-6268'},
            {name: 'Jeff', phone: '365-267-8325'},
            {name: 'Bob', phone: '232-532-6268'},
            {name: 'Jeff', phone: '365-267-8325'},
            {name: 'Bob', phone: '232-532-6268'},
            {name: 'Jeff', phone: '365-267-8325'}
        ];

        $("#grid").jqGrid({
            caption: '订单列表',
            datatype: 'local',
            data: dataArray,
            autowidth: true,
            height: '100%',
            responsive:true,
            pager : '#jqGridPager',
            colModel: [
                {name: 'name', label : 'Name'},
                {name: 'phone', label : 'Phone Number'}
            ],
            gridComplete: function () {
                $(this).jqGrid('setGridHeight',
                    $('.main-content').height()-$('.ui-jqgrid-caption').height()-$('.ui-jqgrid-hdiv').height()-$('.ui-jqgrid-pager').height()-16
                )
            }
        });
    </script>
</aa:zone>
</body>
</html>
