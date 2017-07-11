package org.module.controller.cms;

import java.io.File;
import java.util.UUID;

import org.module.result.UploadResult;
import org.module.util.file.prop.PropConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("upload/")
public class UploadController {

	@RequestMapping("image")
	@ResponseBody
	public UploadResult upload(@RequestParam("upload") MultipartFile file) {
		UploadResult result = new UploadResult();
		if (!file.isEmpty()) {
			try {
				String path = PropConfig.getValue("cms.img_upload_url");
				String fileName = file.getOriginalFilename();
				fileName = fileName.substring(fileName.lastIndexOf("."));
				String realName = UUID.randomUUID().toString().replace("-", "") + fileName;
				path = path + realName;
				File newFile = new File(path);
				// 通过CommonsMultipartFile的方法直接写文件（注意这个时候）
				file.transferTo(newFile);
				result.setPath(path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			result.setCode(-1);
			result.setMessage("文件不存在");
		}
		return result;
	}
}
