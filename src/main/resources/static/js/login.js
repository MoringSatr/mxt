$(function () {
    var serverUrl = $("#serverUrl").val();
    //  登陆
    $("#login-login").click(function () {
        var username = $("#login_input_name").val();
        var password = $("#login_input_passwd").val();
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
                var gameUrl = result.data.gameUrl;
                //  进入游戏
                location.href = gameUrl;
            }
        });
    });
    //  注册
    $("#login-openRegister").click(function () {
        window.location.href = serverUrl + "user/checkProtocol/";
    });
});