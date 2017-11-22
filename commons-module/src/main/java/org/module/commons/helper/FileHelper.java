package org.module.commons.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.module.commons.model.FileModel;
import org.module.commons.result.FileResult;
import org.module.commons.util.Constant;
import org.springframework.util.FileCopyUtils;

public class FileHelper {

	private static FileHelper self;

	public static FileHelper instance() {
		if (self == null) {
			self = new FileHelper();
		}
		return self;
	}

	/**
	 * 
	 * 方法: upload <br>
	 * 描述: 文件上传 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月7日 下午3:20:19
	 * 
	 * @param request
	 * @param path
	 * @param visitPath
	 * @return
	 */
	public FileResult upload(HttpServletRequest request, String path, String url, Integer type) {
		FileResult result = new FileResult();
		List<FileModel> list = new ArrayList<FileModel>();
		List<FileItem> fileItems = getFileFromRequest(request);
		if (fileItems != null && fileItems.size() != 0) {
			if (type == 0) {
				FileItem item = fileItems.get(0);
				FileModel model = saveFile(item.getName(), item.get(), path, url);
				list.add(model);
			} else {
				for (int i = 0; i < fileItems.size(); i++) {
					FileItem item = fileItems.get(i);
					if (StringUtils.isNotBlank(item.getName())) {
						FileModel model = saveFile(item.getName(), item.get(), path, url);
						list.add(model);
					}
				}
			}
			result.setList(list);
			result.setCode(Constant.RESULT_SUCCESS);
			result.setMessage("上传文件成功");
		} else {
			result.setCode(Constant.RESULT_ERROR);
			result.setMessage("未发现要上传的文件，请核实");
		}
		return result;
	}

	/**
	 * 
	 * 方法: getFileFromRequest <br>
	 * 描述: 获取request的上传文件 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月7日 下午3:16:44
	 * 
	 * @param request
	 * @return
	 */
	private List<FileItem> getFileFromRequest(HttpServletRequest request) {
		List<FileItem> items = null; // 得到所有的文件
		String contentType = request.getContentType();
		if (StringUtils.contains(contentType, "multipart/form-data")) { // 如果文件是以二进制方式上传的
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
		return items;
	}

	/**
	 * 
	 * 方法: saveFile <br>
	 * 描述: 持久化一个文件到硬盘 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月7日 下午3:16:51
	 * 
	 * @param fileName
	 *            要保存文件的名称
	 * @param file
	 *            该文件的二进制流
	 * @param path
	 *            文件路径
	 * @return
	 */
	private FileModel saveFile(String fileName, byte[] file, String path, String url) {
		FileModel model = new FileModel();
		if (StringUtils.isBlank(fileName)) {
			model.setCode(Constant.RESULT_ERROR);
			model.setText("文件名称不得为空");
			return model;
		}
		if (fileName.split("\\.").length < 2) {
			model.setCode(-1);
			model.setText("文件名称错误，缺少后缀");
			return model;
		}
		String postfix = StringUtils.substringAfterLast(fileName, ".").toLowerCase(); // 取得文件后缀名
		try {
			String name = WebHelper.genUuid();
			FileUtils.forceMkdir(new File(path));
			File out = new File(path + name + "." + postfix);
			FileCopyUtils.copy(file, out); // 复制文件到服务器
			model.setTitle(name);
			model.setPath(path);
			model.setOriginal(fileName);
			model.setType(postfix);
			model.setPath(path);
			url = url + name + "." + postfix;
			model.setUrl(url);
			model.setCode(Constant.RESULT_SUCCESS);
			model.setText("文件上传完成");
		} catch (IOException e) {
			e.printStackTrace();
			model.setCode(Constant.RESULT_ERROR);
			model.setText("文件持久化异常");
			return model;
		}
		return model;
	}
}
