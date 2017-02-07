/**
 * 文件上传函数
 */

var fileUpload = {
	/**
	 * 上传单个图片
	 * @param {Object} obj
	 */
	uploadImg: function(obj) {
		$(obj).fileinput({
			//设置语言
			language: 'zh',
			//是否显示上传按钮
			showUpload: false,
			//是否显示标题
			showCaption: false,
			//接收的文件后缀
			allowedFileExtensions: ['jpg', 'png', 'gif'],
			browseClass: "btn btn-primary btn-lg",
			fileType: "any",
			previewFileIcon: "<i class='glyphicon glyphicon-king'></i>"
		});
	},
	/**
	 * 批量上传图片
	 * @param {Object} obj
	 */
	batchUploadImg: function(obj) {
		$(obj).fileinput({
			language: 'zh',
			//上传的地址
			uploadUrl: '#',
			//接收的文件后缀
			allowedFileExtensions: ['jpg', 'png', 'gif'],
			overwriteInitial: false,
			maxFileSize: 1000,
			maxFilesNum: 10,
			//最大上传文件数限制
			maxFileCount: 10,
			slugCallback: function(filename) {
				return filename.replace('(', '_').replace(']', '_');
			}
		});
	},
	/**
	 * 上传头像
	 */
	uploadAvatar: function(obj) {
		$(obj).fileinput({
			overwriteInitial: true,
			//文件大小最大值
			maxFileSize: 1500,
			//是否展示关闭按钮
			showClose: false,
			//是否显示标题
			showCaption: false,
			//选择文件按钮标签
			browseLabel: '',
			//选择文件按钮icon
			browseIcon: '<i class="glyphicon glyphicon-folder-open"></i>',
			//移除按钮标签
			removeLabel: '',
			//移除按钮
			removeIcon: '<i class="glyphicon glyphicon-remove"></i>',
			//移除标题
			removeTitle: 'Cancel or reset changes',
			//错误日志显示div
			elErrorContainer: '#kv-avatar-errors-1',
			//
			msgErrorClass: 'alert alert-block alert-danger',
			//默认图片
			defaultPreviewContent: '<img src="/uploads/default_avatar_male.jpg"style="width:160px">',
			layoutTemplates: {
				main2: '{preview} ' + btnCust + ' {remove} {browse}'
			},
			//接收的文件后缀
			allowedFileExtensions: ["jpg", "png", "gif"]
		});
	},
	loaderInit: function(imgUrlArray, imgJsonArray) {
		$("#input-24").fileinput({
			//显示的初始化预览内容
			initialPreview: imgs,
			initialPreviewAsData: true,
			initialPreviewConfig: imgJsonArray,
			//删除图片访问地址
			deleteUrl: "/site/file-delete",
			overwriteInitial: false,
			maxFileSize: 10
		});
	}
};