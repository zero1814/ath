package org.module.file.model;

import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;

public class DocModel {

	/**
	 * 段落
	 */
	private XWPFParagraph paragraph;

	/**
	 * run对象
	 */
	private List<XWPFRun> runs;

	/**
	 * 表格
	 */
	private XWPFTable table;

	public XWPFTable getTable() {
		return table;
	}

	public void setTable(XWPFTable table) {
		this.table = table;
	}

	public XWPFParagraph getParagraph() {
		return paragraph;
	}

	public void setParagraph(XWPFParagraph paragraph) {
		this.paragraph = paragraph;
	}

	public List<XWPFRun> getRuns() {
		return runs;
	}

	public void setRuns(List<XWPFRun> runs) {
		this.runs = runs;
	}

}
