/**
 * 系统公共函数
 * 
 * @author zhy
 * @date 2016-04-05
 * @version 1.0.0
 * 
 */
var UsePublic = {
	// 检测字符串是否为空 返回值：空=true;非空=false
	isNull: function(val) {
		val = trim(val); // 去掉字符串两边的空白符
		if(val) {
			return false;
		} else {
			return true;
		}
	},
	// 是否为数字
	isNumber: function(val) {
		var patrn = /^-{0,1}[0-9]+\.{0,1}\d{0,}$/;
		if(!patrn.test(val))
			return false;
		return true;
	},
	// 邮箱账号检测
	isMail: function(checkString) {
		// 正则：(以数字或字母开头后可跟下划线_或减号-或小数点.)或者(直接数字或字母)，@，(以数字或字母开头后可跟下划线_或减号-或小数点.)或者(直接数字或字母),.,跟2-3个字母
		var re = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if(checkString) {
			if(re.test(checkString)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	},
	// 手机号码检测
	isPhone: function(checkString) {
		// 正则：以1开头，3|5|8第二位，0-9第三位，后跟8位数字 = 共11位号码
		var re = /^1[3|5|8][0-9]\d{8}$/;
		if(checkString) {
			if(re.test(checkString)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	},
	// 验证短日期(2007-06-05)
	isDate: function(str) {
		var r = str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
		if(r == null) {
			return false;
		}
		var d = new Date(r[1], r[3] - 1, r[4]);
		return(d.getFullYear() == r[1] && (d.getMonth() + 1) == r[3] && d
			.getDate() == r[4]);
	},
	// 验证长日期(2007-06-05 10:57:10)
	isDateTime: function(str) {
		var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
		var r = str.match(reg);
		if(r == null) {
			return false;
		}
		var d = new Date(r[1], r[3] - 1, r[4], r[5], r[6], r[7]);
		return(d.getFullYear() == r[1] && (d.getMonth() + 1) == r[3] &&
			d.getDate() == r[4] && d.getHours() == r[5] &&
			d.getMinutes() == r[6] && d.getSeconds() == r[7]);
	},
	// 验证时间(10:57:10)
	isTime: function(str) {
		var a = str.match(/^(\d{1,2})(:)?(\d{1,2})\2(\d{1,2})$/);
		if(a == null) {
			return false;
		}
		if(a[1] > 24 || a[3] > 60 || a[4] > 60) {
			return false
		}
		return true;
	},
	// 全选
	checkedAll: function(obj, name) {
		var checekd = $(obj).attr("checked");
		if(checked) {
			$('input[name="+name+"').each(function() {
				$(this).attr("checked", "checked");
			});
		} else {
			$('input[name="+name+"').each(function() {
				$(this).attr("checked", false);
			});
		}
	},
	/**
	 * 添加
	 */
	add: function(urlVal, paramVal, type, returnUrlVal) {
		$.ajax({
			url: urlVal,
			type: "POST",
			data: paramVal,
			success: function(result) {
				result = JSON.parse(result);
				if(result.code == 0) {
					layer.alert('添加成功', function(index) {
						layer.close(index);
						if(type == 'div') {
							$("#table").bootstrapTable('refresh');
						} else {
							if(returnUrlVal) {
								window.open("_self", returnUrlVal);
							}
						}
					});
				} else {
					layer.alert(result.message, function(index) {
						layer.close(index);
						if(type == 'div') {
							$("#table").bootstrapTable('refresh');
						} else {
							if(returnUrlVal) {
								window.open("_self", returnUrlVal);
							}
						}
					});
				}
			},
			error: function(result) {
				layer.alert('添加失败，失败原因:' + JSON.stringify(result));
			}
		});
	},
	edit: function(urlVal, paramVal, type, returnUrlVal) {
		$.ajax({
			url: urlVal,
			type: "POST",
			data: paramVal,
			success: function(result) {
				result = JSON.parse(result);
				if(result.code == 0) {
					layer.alert('编辑成功', function(index) {
						layer.close(index);
						if(type == 'div') {
							$("#table").bootstrapTable('refresh');
						} else {
							if(returnUrlVal) {
								window.open("_self", returnUrlVal);
							}
						}
					});
				} else {
					layer.alert(result.message, function(index) {
						layer.close(index);
						if(type == 'div') {
							$("#table").bootstrapTable('refresh');
						} else {
							if(returnUrlVal) {
								window.open("_self", returnUrlVal);
							}
						}
					});
				}
			},
			error: function(result) {
				layer.alert('编辑失败，失败原因:' + JSON.stringify(result));
			}
		});
	},
	/**
	 * 删除
	 */
	del: function(urlVal, paramVal, type, returnUrlVal) {
		layer.confirm('您确认要删除选中的数据吗？', {
			btn: ['确认', '取消']
			// 按钮
		}, function() {
			$.ajax({
				url: urlVal,
				type: "POST",
				data: paramVal,
				success: function(result) {
					result = JSON.parse(result);
					if(result.code == 0) {
						layer.alert('删除成功', function(index) {
							layer.close(index);
							if(type == 'div') {
								$("#table").bootstrapTable('refresh');
							} else {
								if(returnUrlVal) {
									window.open("_self", returnUrlVal);
								}
							}
						});
					} else {
						layer.alert(result.message, function(index) {
							layer.close(index);
							if(type == 'div') {
								$("#table").bootstrapTable('refresh');
							} else {
								if(returnUrlVal) {
									window.open("_self", returnUrlVal);
								}
							}
						});
					}
				},
				error: function(result) {
					layer.alert('删除失败，失败原因:' + JSON.stringify(result));
				}
			});
		});
	},
	formToJSON: function(fromObj) {
		var tmp = {};
		var frm = $(fromObj).serializeArray();
		$.each(frm, function() {
			if(tmp[this.name]) {
				if(!tmp[this.name].push) {
					tmp[this.name] = [o[this.name]];
				}
				tmp[this.name].push(this.value || '');
			} else {
				tmp[this.name] = this.value || '';
			}
		});
		return tmp;
	}
};