<%@ taglib prefix="aa" uri="http://com.nerderg/ajaxanywhere" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Demo</title>

</head>
<body>
        <aa:zone id="main">
            <section class="operation-area">
                <a class="btn btn-outline-primary btn-sm mr-1" href="/user/input" aa-refresh-zones="main"  role="button">新建</a>
                <button type="button" class="btn btn-outline-primary btn-sm mr-1" >删除</button>
            </section>
            <section class="main-content">
                <p>
                    <input type="text" name="date" id="date">
                </p>
                <ul id="treeDemo" class="ztree"></ul>
            </section>
            <script>
                var zTreeObj;
                // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
                var setting = {};
                // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
                var zNodes = [
                    {name:"test1", open:true, children:[
                            {name:"test1_1"}, {name:"test1_2"}]},
                    {name:"test2", open:true, children:[
                            {name:"test2_1"}, {name:"test2_2"}]}
                ];

                $("#date").datepicker();
                zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
            </script>
        </aa:zone>
</body>
</html>
