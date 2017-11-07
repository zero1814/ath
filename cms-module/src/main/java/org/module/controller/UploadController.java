package org.module.controller;

import org.module.base.result.BaseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 类: UploadController <br>
 * 描述: 文件上传 <br>
 * 作者: zhy<br>
 * 时间: 2017年11月7日 下午2:07:41
 */
@Controller
@RequestMapping("upload")
public class UploadController {

	public BaseResult uploadUserHeadPic() {
		BaseResult result = new BaseResult();
		return result;
	}
}
