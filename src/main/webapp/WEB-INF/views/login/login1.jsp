<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    %>
    <c:set var="cp" value="<%=basePath%>" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="../../../static/BootStrap/assets/images/favicon.png">
    <title>登录</title>
    <!-- Custom CSS -->
    <link href="../../../static/BootStrap/dist/css/style.min.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body>
    <div class="main-wrapper">
        <!-- ============================================================== -->
        <!-- Preloader - style you can find in spinners.css -->
        <!-- ============================================================== -->
        <div class="preloader">
            <div class="lds-ripple">
                <div class="lds-pos"></div>
                <div class="lds-pos"></div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- Preloader - style you can find in spinners.css -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Login box.scss -->
        <!-- ============================================================== -->
        <div class="auth-wrapper d-flex no-block justify-content-center align-items-center" style="background:url(../../../static/BootStrap/assets/images/big/auth-bg.jpg) no-repeat center center;">
            <div class="auth-box">
                <div id="loginform">
                    <div class="logo">
                        <span class="db"><img src="../../../static/BootStrap/assets/images/logo-icon.png" alt="logo" /></span>
                        <h5 class="font-medium m-b-20">用户登录</h5>
                    </div>
                    <!-- Form -->
                    <div class="row">
                        <div class="col-12">
                            <form class="form-horizontal m-t-20" id="loginform">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="basic-addon1"><i class="ti-user"></i></span>
                                    </div>
                                    <input type="text" class="form-control form-control-lg" id="username"  placeholder="用户名" aria-label="Username" aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="basic-addon2"><i class="ti-pencil"></i></span>
                                    </div>
                                    <input type="password" class="form-control form-control-lg" id="password" placeholder="密码" aria-label="Password" aria-describedby="basic-addon1">
                                </div>
                                
                                <div class="form-group row">
                                    <div class="col-md-12">
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="customCheck1">
                                            <label class="custom-control-label" for="customCheck1">我已阅读并同意<a href="${cp}/commen/yinsizhengce"  target="_blank">隐私政策</a></label>
                                            <a href="javascript:void(0)" id="to-recover" class="text-dark float-right"><i class="fa fa-lock m-r-5"></i> 忘记密码?</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group text-center">
                                    <div class="col-xs-12 p-b-20">
                                        <button class="btn btn-block btn-lg btn-info" type="button" id="login">登录</button>
                                    </div>
                                </div>
                               <%-- <div class="row">
                                    <div class="col-xs-12 col-sm-12 col-md-12 m-t-10 text-center">
                                        <div class="social">
                                            <a href="javascript:void(0)" class="btn  btn-facebook" data-toggle="tooltip" title="" data-original-title="Login with Facebook"> <i aria-hidden="true" class="fab  fa-facebook"></i> </a>
                                            <a href="javascript:void(0)" class="btn btn-googleplus" data-toggle="tooltip" title="" data-original-title="Login with Google"> <i aria-hidden="true" class="fab  fa-google-plus"></i> </a>
                                        </div>
                                    </div>
                                </div>--%>
                                <div class="form-group m-b-0 m-t-10">
                                    <div class="col-sm-12 text-center">
                                        尚未注册? <a href="${cp}/login/register" class="text-info m-l-5"><b>注册</b></a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div id="recoverform">
                    <div class="logo">
                        <span class="db"><img src="../../../static/BootStrap/assets/images/logo-icon.png" alt="logo" /></span>
                        <h5 class="font-medium m-b-20">重置密码</h5>
                        <span>请输入您的电子邮件，我们将发送链接给您!</span>
                    </div>
                    <div class="row m-t-20">
                        <!-- Form -->
                        <form class="col-12" action="${cp}/user/czmm">
                            <!-- email -->
                            <div class="form-group row">
                                <div class="col-12">
                                    <input class="form-control form-control-lg" type="email" name="email" required="" placeholder="电子邮箱">
                                    <input class="form-control form-control-lg" type="hidden" name="username" id="resusername" >
                                </div>
                            </div>
                            <!-- pwd -->
                            <div class="row m-t-20">
                                <div class="col-12">
                                    <button class="btn btn-block btn-lg btn-danger" type="submit">重置</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- All Required js -->
    <!-- ============================================================== -->
    <script src="../../../static/BootStrap/assets/libs/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="../../../static/BootStrap/assets/libs/popper.js/dist/umd/popper.min.js"></script>
    <script src="../../../static/BootStrap/assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <!-- ============================================================== -->
    <!-- This page plugin js -->
    <!-- ============================================================== -->
    <script>
    $('[data-toggle="tooltip"]').tooltip();
    $(".preloader").fadeOut();
    if('${resemail}'==1000){
        /*swal("密码重置成功");
        window.history.back(-1);*/
        swal({
            title: '密码重置成功',
            type: 'success'
        })
        .then((value) => {
            window.history.back(-1);
        })
    }else if('${resemail}'==1001){
        swal("密码重置失败或用户尚未注册，请联系管理员");
    }
    // ==============================================================
    // Login and Recover Password
    // ==============================================================
    $('#to-recover').on("click", function() {
        var flag;
        if($("#username").val()=='' || $("#username").val()==null){
            swal("请输入用户名");
            flag=false;
        }else{
            flag=true;
        }
        if(flag==true){
            $("#loginform").slideUp();
            $("#recoverform").fadeIn();
            $("#resusername").val($("#username").val());
        }
    });
    $("#login").click(function () {
        var user = {};
        user.username=$("#username").val();
        user.password=$("#password").val();
        var flag;
        var remFlag = $("input[type='checkbox']").is(':checked');
        if($("#username").val()==''){
            swal("用户名为空");
            flag=false;
        }else if($("#password").val()==''){
            swal("密码为空");
            flag=false;
        } else if(remFlag==false){
            swal("请勾选并同意用户隐私政策");
        }else{
            flag=true;
        }
        if(flag==true && remFlag==true){
            var url='${cp}/login/logincheck';
            $.ajax({
                url: url,
                type: "POST",
                data:  user,
                dataType: "json",
                success:function(data){
                    if(data.msg=='zhuce'){
                        swal("尚未注册，请先注册");
                    }else if (data.msg=='passworderr'){
                        swal("用户名或密码错误");
                        $("#password").val('');
                    }else if (data.msg=='success'){
                        window.location.href="index";
                    }
                },
                error:function(er){
                    swal("用户验证异常,请联系维护人员!");
                }
            });
        }
    })
    </script>
</body>

</html>