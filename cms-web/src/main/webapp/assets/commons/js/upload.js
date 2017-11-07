/**
 * 文件上传处理
 */
document.write("<link href=\"assets/plugins/bootstrap/plugins/fileinput/css/fileinput.min.css\" rel=\"stylesheet\"/>");
document.write("<script src=\"assets/plugins/bootstrap/plugins/fileinput/js/fileinput.min.js\"></script>");
document.write("<script src=\"assets/plugins/bootstrap/plugins/fileinput/js/fileinput_locale_zh.js\"></script>")
var Upload = {
	id:'upload',
	backfillId:'',
	url:'',
	fileSize:20*1024,
	fileCount:1,
	type:0,
	init:function(obj){
		Upload.id=obj.id;
		Upload.url=obj.url;
		Upload.fileSize=obj.fileSize;
		Upload.fileCount=obj.fileCount;
		Upload.backfillId=obj.backfillId;
		Upload.fileInput();
	},
	fileInput: function() {
		$("#" + Upload.id).fileinput({
			language: 'zh', //设置语言
			uploadUrl: Upload.url, //上传的地址(访问接口地址)
			allowedFileExtensions: ['jpg', 'jpeg', 'png'], //接收的文件后缀
			uploadAsync: true, //默认异步上传
			showUpload: true, //是否显示上传按钮
			showRemove: true, //显示移除按钮
			showPreview: true, //是否显示预览
			showCaption: false, //是否显示标题
			browseClass: "btn btn-primary", //按钮样式 
			dropZoneEnabled: false, //是否显示拖拽区域
			//minImageWidth: 50, //图片的最小宽度
			//minImageHeight: 50,//图片的最小高度
			//maxImageWidth: 1000,//图片的最大宽度
			//maxImageHeight: 1000,//图片的最大高度
			maxFileSize: Upload.fileSize*1024,//单位为kb，如果为0表示不限制文件大小
			maxFileCount: Upload.fileCount, //表示允许同时上传的最大文件个数
			enctype: 'multipart/form-data',
			validateInitialCount: true,
			previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
			msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
		});
		//异步上传返回错误结果处理
		$('#' + Upload.id).on('fileerror', function(event, data, msg) {
			
		});
		//异步上传返回结果处理
		$("#" + Upload.id).on("fileuploaded", function(event, data, previewId, index) {
			$("#"+Upload.backfillId).val(JSON.stringify(data.response.list));
		});
		//批量同步上传错误处理
		$('#' + Upload.id).on('filebatchuploaderror', function(event, data, msg) {
		});
		//批量同步上传成功结果处理
		$("#" + Upload.id).on("filebatchuploadsuccess", function(event, data, previewId, index) {
		});
		//上传前
		$('#'+Upload.id).on('filepreupload', function(event, data, previewId, index) {
			varform = data.form, files = data.files, extra = data.extra,
				response = data.response, reader = data.reader;
		});
	}
}