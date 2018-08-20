<%@ taglib prefix="aa" uri="http://com.nerderg/ajaxanywhere" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Demo</title>

    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
    <link rel="stylesheet" href="/libs/jquery-ui/jquery-ui.min.css">
    <link rel="stylesheet" href="/libs/zTree/zTreeStyle.css" type="text/css">
    <link rel="stylesheet" href="/libs/jqGrid/css/ui.jqgrid-bootstrap4.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/octicons/4.4.0/font/octicons.css">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>
<header class="navbar bg-primary text-white app-header">首页</header>
<div class="row">
    <aside class="col left-menu">

        <nav class="nav flex-column">
            <a href="/category/list?pageNum=1" class="nav-link text-primary active font-weight-bold" id="menuCategory">类别管理</a>
            <a href="/product/list?pageNum=1" class="nav-link text-dark" id="menuProduct">产品管理</a>
            <a href="/order/list?pageNum=1" class="nav-link text-dark" id="menuOrder">订单管理</a>
            <a href="/user/list?pageNum=1" class="nav-link text-dark" id="menuUser">用户管理</a>
        </nav>
    </aside>

    <main class="col main">
        <aa:zone id="main" href="/category/list">

        </aa:zone>
    </main>
</div>
<div id="loading"><i class="fas fa-spinner fa-spin fa-3x"></i></div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="<c:url value="/webjars/ajaxanywhere/2.1/aa.js"/>"></script>
<script src="/libs/jquery-ui/jquery-ui.min.js"></script>
<script src="/libs/zTree/jquery.ztree.all.min.js"></script>
<script src="/libs/jqGrid/js/jquery.jqGrid.min.js"></script>
<script src="/libs/jqGrid/js/i18n/grid.locale-cn.js"></script>
<script src="/js/common.js"></script>
<script>
    $(function () {
        //给左侧菜单项（一般是叶子节点）添加ajaxanywhere相关属性来实现局部刷新
        $('.left-menu .nav-link').each(function(){
            $(this).attr('aa-js-after','selectMenu("'+$(this).attr('id')+'")')
            $(this).attr('aa-refresh-zones','main')
        })

    })
    //选中的菜单项使用单独的样式(一般需要加粗变色表示区别）
    function selectMenu(menu){
        $('.nav-link.active').removeClass('active').removeClass('font-weight-bold').removeClass('text-primary').addClass('text-dark')
        $('#'+menu).addClass('active').addClass('font-weight-bold').removeClass('text-dark').addClass('text-primary')
    }
</script>
</body>
</html>
