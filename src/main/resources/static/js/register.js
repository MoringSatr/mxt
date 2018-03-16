$(function () {
    var serverUrl = $("#serverUrl").val();
    var accept = $("#accept").val();
    //  注册
    $("#btn-register").click(function () {
        var username = $("#account").val();
        var password = $("#passwd").val();
        var realname = $("#realname").val();
        var idcard = $("#ids").val();
        if (accept == "" || !accept || accept == "false") {
            showTips("请先同意注册协议");
            return;
        }
        if (username == "" || username == "undefined") {
            showTips("请输入帐号");
            return;
        }
        if (password == "" || password == "undefined") {
            showTips("请输入密码");
            return;
        }
        if (realname == "" || realname == "undefined") {
            showTips("请输入姓名");
            return;
        }
        if (idcard == "" || idcard == "undefined") {
            showTips("请输入身份证");
            return;
        }
        $.ajax({
            type: "POST",
            url: serverUrl + "user/register/",
            data: {
                username: username,
                password: password,
                realname: realname,
                idcard: idcard,
                accept: accept
            },
            dataType: "json",
            success: function (result) {
                console.log(JSON.stringify(result));
                if (result.code !== 1) {
                    showTips(result.msg);
                    return;
                }
                window.location.href = serverUrl + "user/login/";
            }
        });
    });
    //  取消
    $("#btn-register-cancel").click(function () {
        window.location.href = serverUrl + "user/login/";
    });
});