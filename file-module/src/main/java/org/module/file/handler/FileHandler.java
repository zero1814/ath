package org.module.file.handler;

import org.module.commons.base.BaseClass;

/**
 * 
 * 类: FileHandler <br>
 * 描述: TODO <br>
 * 作者: zhy<br>
 * 时间: 2016年9月17日 下午5:02:17
 */
enum FileType {
	XLS, XLSX, DOC, DOCX, JPG, JPEG
}

public class FileHandler extends BaseClass {

	public FileHandler(String type) {
		if (type.equals(FileType.DOC)) {

		}else if(type.equals(FileType.DOCX)){
			
		}
	}
}