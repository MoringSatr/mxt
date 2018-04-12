$(function () {
    var serverUrl = $("#serverUrl").val();

    //  登陆
    $("#login-login").click(function () {
        var username = $("#login_input_name").val();
        var password = $("#login_input_passwd").val();
        if (username == "" || username == "undefined") {
            showTips("请输入帐号");
            return;
        }
        if (password == "" || password == "undefined") {
            showTips("请输入密码");
            return;
        }
        password = md5(password).toUpperCase();
        $.ajax({
            type: "POST",
            url: serverUrl + "user/login/",
            data: {
                username: username,
                password: password
            },
            dataType: "json",
            success: function (result) {
                console.log(JSON.stringify(result));
                if (result.code !== 1) {
                    showTips(result.msg);
                    $("#login_input_passwd").val("");
                    return;
                }
                window.location.href = serverUrl + "user/advice/";
            }
        });
    });
    //  注册
    $("#login-openRegister").click(function () {
        window.location.href = serverUrl + "user/checkProtocol/";
    });
});