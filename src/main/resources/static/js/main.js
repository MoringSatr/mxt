function showTips(_text) {
    var panelHtml = '<div class="panel-tips" id="panel-tips"></div>'
    $("#panel-tips-parent").append(panelHtml);
    $("#panel-tips").text(_text);
    $("#panel-tips").fadeIn(1000);
    $("#panel-tips").fadeOut(2000);
}

$(function () {
    var gameIconUrl = $("#game_icon_url").val();
    $("#start-icon").attr("style", "background: url(" + gameIconUrl + ") left top no-repeat; background-size: 100% 100%;")
});