package org.module.file.handler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.module.file.model.DocModel;

public class DocHandler {

	public static void write(String path, List<DocModel> list) {
		FileOutputStream io = null;
		XWPFDocument doc = null;
		try {
			io = new FileOutputStream(path);
			doc = new XWPFDocument();
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (io != null) {
					io.close();
				}
				if (doc != null) {
					doc.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
