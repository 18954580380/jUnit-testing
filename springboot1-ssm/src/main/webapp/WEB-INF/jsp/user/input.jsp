<%@ taglib prefix="aa" uri="http://com.nerderg/ajaxanywhere" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: huhongchun
  Date: 2018/8/9
  Time: 下午3:38
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
            <button type="button" class="btn btn-outline-primary btn-sm mr-1" id="btnSave">保存</button>
            <button type="button" class="btn btn-outline-primary btn-sm mr-1" id="btnReset">重置</button>
        </section>
        <section class="main-content">
            <form id="form">
                <div class="form-group row no-gutters">
                    <label for="name" class="col-sm-2 col-form-label">姓名</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="name" name="name">
                    </div>
                    <label class="col-sm-2 col-form-label">性别</label>
                    <div class="col-sm-4">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" value="1">
                            <label class="form-check-label">男</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" value="0">
                            <label class="form-check-label">女</label>
                        </div>
                    </div>
                </div>
                <div class="form-group row no-gutters">
                    <label for="birthday" class="col-sm-2 col-form-label">出生日期</label>
                    <div class="col-sm-4">
                        <input class="form-control" id="birthday" name="birthday">
                    </div>
                    <label for="height" class="col-sm-2 col-form-label">身高</label>
                    <div class="col-sm-4">
                        <input class="form-control" id="height" name="height">
                    </div>
                </div>
                <div class="form-group row no-gutters">
                    <label class="col-sm-2 col-form-label">兴趣</label>
                    <div class="col-sm-10">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="乒乓球" name="hobbies">
                            <label class="form-check-label" for="inlineCheckbox1">乒乓球</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="游泳" name="hobbies">
                            <label class="form-check-label" for="inlineCheckbox2">游泳</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="电子游戏" name="hobbies" disabled>
                            <label class="form-check-label" for="inlineCheckbox3">电子游戏 (disabled)</label>
                        </div>
                    </div>
                </div>
                <div class="form-group row no-gutters">
                    <label class="col-sm-2 col-form-label" for="product">手机型号</label>
                    <div class="col-sm-9">
                        <input class="form-control" id="product" name="product">
                    </div>
                    <div class="col-sm-1">
                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                            选择
                        </button>

                        <!-- Modal -->
                        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <iframe src="/user/select-product"></iframe>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary">Save changes</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group row no-gutters">
                    <label class="col-sm-2 col-form-label" for="education">学历</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="education" name="education">
                            <option value="1">大专</option>
                            <option value="2" selected>本科</option>
                            <option value="3">硕士</option>
                            <option value="4">博士</option>
                        </select>
                    </div>
                </div>
            </form>
        </section>
        <script>
            initUserInfo();
            function initUserInfo(){
                $('#birthday').datepicker()
                $('#btnSave').click(function () {
                    var result='表单值：\n'
                    result=result +"name: " + $('#name').val()
                        + ' gender: ' + $(':radio[name="gender"]:checked').val()
                        + ' birthday: ' + $('#birthday').val()
                        + ' height: ' + $('#height').val()
                        + ' hobbies: '
                    var hobbies='';
                    $(':checkbox[name="hobbies"]:checked').each(function(){
                        hobbies+=' ' + $(this).val()
                    })
                    result = result + hobbies
                        + ' product: ' + $('#product').val()
                        + ' education: ' + $('#education').val()
                    alert(result);
                });

                $('#btnReset').click(function () {
                    //$('#form').get(0).reset();
                    //主要是演示如何修改各个文本框的值
                    $('#name').val('')
                    $(':radio[name="gender"]').prop('checked',false)
                    $('#birthday').val('')
                    $('#height').val('')
                    //checked,selected这些属性使用prop，他们不需要设置value，只要出现就表示生效，不能再用attr了(可以设置不同的value)
                    $(':checkbox[name="hobbies"][value="乒乓球"]').prop('checked',false)
                    $('#product').val('')
                    //$('#education').val('2')
                    // $('#education').val('')
                    //$('#education').find('option:selected').prop('selected',false)
                    $('#education').children('option[value="1"]').prop('selected', true)
                })
            }
        </script>
    </aa:zone>
</body>
</html>
