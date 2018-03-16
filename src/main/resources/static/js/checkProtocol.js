$(function () {
    var serverUrl = $("#serverUrl").val();
    //  接受
    $("#register-protocol-agree").click(function () {
        window.location.href = serverUrl + "user/register/?accept=1";
    });
    //  取消
    $("#register-protocol-cancel").click(function () {
        window.location.href = serverUrl + "user/login/";
    });
});