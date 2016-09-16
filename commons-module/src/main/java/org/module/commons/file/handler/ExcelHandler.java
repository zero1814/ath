package org.module.commons.file.handler;

import org.module.commons.base.BaseClass;
import org.module.commons.file.FileRequest;
import org.module.commons.file.FileResponse;

/**
 * 
 * 类: ExcelHandler <br>
 * 描述: excel表处理类 <br>
 * 作者: zhy<br>
 * 时间: 2016年9月15日 下午7:28:01
 */
public class ExcelHandler extends BaseClass {

	/**
	 * 
	 * 方法: read <br>
	 * 描述: 读取文件 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年9月15日 下午7:51:39
	 * 
	 * @param request
	 * @return
	 */
	public FileResponse read(FileRequest request) {
		FileResponse response = null;
		String filePath = request.getPath() + "/" + request.getName() + "." + request.getType();
		try {

		} catch (Exception e) {
			e.printStackTrace();
			getLogger().logError("读取文件" + filePath + "失败；error：" + e.getMessage());
		}
		return response;

	}

	/**
	 * 
	 * 方法: write <br>
	 * 描述: 写入文件 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年9月15日 下午7:51:59
	 * 
	 * @param request
	 * @return
	 */
	public FileResponse write(FileRequest request) {
		FileResponse response = null;
		String filePath = request.getPath() + "/" + request.getName() + "." + request.getType();
		try {

		} catch (Exception e) {
			e.printStackTrace();
			getLogger().logError("读取文件" + filePath + "失败；error：" + e.getMessage());
		}
		return response;
	}
}
