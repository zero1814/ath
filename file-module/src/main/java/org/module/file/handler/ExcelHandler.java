package org.module.file.handler;

import org.module.commons.base.BaseClass;
import org.module.file.File;

/**
 * 
 * 类: ExcelHandler <br>
 * 描述: excel相关操作类 <br>
 * 作者: zhy<br>
 * 时间: 2016年9月17日 下午4:32:31
 */
public class ExcelHandler extends BaseClass {

	public File read(File file) {
		try {
			if (file != null) {
				
			} else {
				getLogger().logInfo("文件配置为空");
				file = new File();
				file.setCode(1);
				file.setMessage("文件配置为空");
			}
		} catch (Exception e) {
			getLogger().logError("读取文件" + file.getPath() + "/" + file.getName() + "失败,失败原因:" + e.getMessage());
			e.printStackTrace();
		}
		return file;
	}

	public File write(File file) {
		try {

		} catch (Exception e) {
			getLogger().logError("写入文件" + file.getPath() + "/" + file.getName() + "失败,失败原因:" + e.getMessage());
			e.printStackTrace();
		}
		return file;
	}
}
