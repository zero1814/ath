var validate = {
	rules : {
		username : "required",
		password : {
			required : true,
			rangelength : [ 6, 12 ]
		},
		phone : {
			required : true,
			minlength : 11,
			maxlength : 11
		},
		email : {
			required : true,
			email : true
		},
		confirm_password : {
			required : true,
			rangelength : [ 6, 12 ],
			equalTo : "#password"
		}
	},
	messages : {
		username : "请输入用户名",
		password : {
			required : "请输入密码",
			rangelength : jQuery.format("密码长度 {0} ~ {1}由字母和数字组成的字符")
		},
		confirm_password : {
			required : "请输入确认密码",
			rangelength : jQuery.format("密码长度 {0} ~ {1}由字母和数字组成的字符"),
			equalTo : "两次输入密码不一致不一致"
		},
		email : {
			required : "请输入Email地址",
			email : "请输入正确的email地址"
		},
		phone : {
			required : "请输入手机号",
			minlength : "请输入{0}位手机号",
			maxlength : "请输入{0}位手机号"
		}
	}
};