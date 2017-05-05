/**
 * 意见反馈
 */
$(function(){
	
	
});

function open1(){
	var diag = new Dialog();
	diag.Width = 800;
	diag.Height = 580;
	diag.Title = "提交留言";
	diag.URL = "/feedbackDialog.html";
	diag.show();
}