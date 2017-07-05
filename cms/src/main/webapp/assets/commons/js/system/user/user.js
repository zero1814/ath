var User = {
	Layer: '',
	data: function() {
		columns = [{
			checkbox: true
		}, {
			field: 'code',
			title: '编码'
		}, {
			field: 'name',
			title: '名称'
		}, {
			field: 'flagAble',
			title: '是否可用',
			formatter: initFlagAble
		}, {
			field: 'createUser',
			title: '创建人'
		}, {
			field: 'createTime',
			title: '创建时间'
		}, {
			field: 'operate',
			title: '操作',
			formatter: initOperate
		}]
		Table.init("table", "data/json/system/user/user.json", columns, User.searchParam());
	},
	searchParam: function() {
		var temp = { name: $("#name").val() };
		return temp;
	},
	search: function() {
		Table.param = User.searchParam();
		$("#table").bootstrapTable('refresh');
	},
	openLayer: function(titleVal, layerDivId) {
		User.Layer = layer.open({
			type: 1,
			title: titleVal,
			skin: 'layui-layer-lan', //加上边框
			area: ['450px', '180px'], //宽高
			content: $("#" + layerDivId)
		});
	},
	closeLayer: function() {
		if(User.Layer) {
			layer.close(User.Layer);
		}
	},
	openEdit: function(val) {
		layer.confirm('您确定要修改此条数据吗？', {
			btn: ['确定', '取消'] //按钮
		}, function(index) {
			layer.close(index);
			User.openLayer('编辑', 'editDiv');
		}, function(index) {
			layer.close(index);
		});
	},
	add: function() {

	},
	edit: function() {

	},
	del: function(val) {
		layer.confirm('您确定要删除此条数据吗？', {
			btn: ['确定', '取消'] //按钮
		}, function(index) {
			layer.close(index);
			layer.alert("删除成功!", function(index) {
				layer.close(index);
			})
		}, function(index) {
			layer.close(index);
		});
	},
	login:function(){
		var param = $("#loginFrm").serializeArray();
		$.ajax({
			url: 'sublogin.htm',
			type: "POST",
			data: param,
			dataType : "json",
			success: function(result) {
				if(result.code == 0) {
					window.location.href="index.htm";
				} else {
					layer.msg("用户不存在",{time:1000},function(){
						window.location.href="jsp/system/user/register.jsp";
					});
				}
			},
			error: function(result) {
				layer.alert("登录失败", function(index) {
					window.location.href="jsp/error/500.jsp";
				});
			}
		});
	},
	register:function(){
		//$("#registerFrm").validate();
		var param = $("#registerFrm").serializeArray();
		$.ajax({
			url: "subregister.htm",
			type: "POST",
			data: param,
			dataType : "json",
			success: function(result) {
				layer.alert("注册成功", function() {
					window.parent.location.href="login.htm";
				});
			},
			error: function(result) {
				layer.alert('注册失败，失败原因:' + JSON.stringify(result),function(index){
					layer.close(index);
					window.parent.location.href="register.htm";
				});
			}
		});
	},
	validate:function(){
		$("#registerFrm").validate({
			rules : {
				userName : {
					required : true,
					minlength : 6
				},
				password : {
					required : true,
					minlength : 6
				},
				r_password : {
					required : true,
					minlength : 6,
					equalTo : "#password"
				},
				realName : {
					required : true
				},
				phone : {
					required : true,
					minlength : 11,
					maxlength : 11
				},
				email : {
					required : true,
					email : true
				}
			},
			messages : {
				username : {
					required : "请输入用户名",
					minlength : "用户名不能小于6个字符"
				},
				password : {
					required : "请输入密码",
					minlength : "密码长度不能小于 6个字符"
				},
				confirm_password : {
					required : "请输入密码",
					minlength : "密码长度不能小于 6个字符",
					equalTo : "两次密码输入不一致"
				},
				realName : "请输入真实姓名",
				phone : {
					required : "请输入手机号",
					minlength : "请输入11位手机号",
					maxlength : "请输入11位手机号"
				},
				email : "请输入一个正确的邮箱"
			}
		});
	}
};

function initOperate(value, row, index) {
	var html = "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='User.openEdit()'>编辑</a>";
	html += "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='User.del(\"" + value + "\")'>删除</a>";
	return html;
}
function initFlagAble(value, row, index) {
	var html = '';
	if(value == 0) {
		html = '可用';
	} else {
		html = '不可用';
	}
	return html;
}