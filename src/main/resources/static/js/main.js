function showTips(_text) {
    var panelHtml = '<div class="panel-tips" id="panel-tips"></div>'
    $("#panel-tips-parent").append(panelHtml);
    $("#panel-tips").text(_text);
    $("#panel-tips").fadeIn(1000);
    $("#panel-tips").fadeOut(2000);
}