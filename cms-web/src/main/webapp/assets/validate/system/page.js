var validate = {
	rules : {
		name : "required",
		url : {
			required : true,
			url : true
		}
	},
	messages : {
		name : "请输入页面名称",
		url:{
			required:"url地址不能为空",
			url:"请输入正确url地址"
		}
	}
};