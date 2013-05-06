$(".ui-state-error").hide();
$("button").button();

function login(){
	var username = $("#username").val();
	var password = $("#password").val();
    $.ajax({
        type:"post",
        data:{username:username,password:password},
        dataType:"json",
        url:"ServletLogin",
        success:function(data){
        	if(data!=null){
        		document.location = 'mainMenu.html';
        	}else{
        		$(".ui-state-error").show();
				$("#login section").effect("shake", 150 );
        	}
		}
    });
}