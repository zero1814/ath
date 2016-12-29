package org.commons.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.commons.base.BaseClass;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 
 * 类: XmlHelper <br>
 * 描述: xml文件相关操作 <br>
 * 作者: zhy<br>
 * 时间: 2016年9月19日 下午10:13:59
 */
public class XmlHelper extends BaseClass {

	private String path;

	private static XmlHelper self;

	public XmlHelper(String path) {
		this.path = path;
	}

	public static XmlHelper getInstance(String path) {
		if (self == null) {
			self = new XmlHelper(path);
		}
		return self;
	}

	/**
	 * 
	 * 方法: getValue <br>
	 * 描述: 读取配置文件根据nodename的名称获取node的值 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年9月20日 下午8:50:57
	 * 
	 * @param nodeName
	 * @return
	 */
	public String getValue(String nodeName) {
		String value = null;
		InputStream is = null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File file = new File(path);
			if (file.exists()) {
				is = new FileInputStream(file);
				Document doc = builder.parse(is);
				if (doc != null) {
					Element root = doc.getDocumentElement();
					NodeList nodeList = root.getChildNodes();
					if (nodeList != null && nodeList.getLength() > 0) {
						for (int i = 0; i < nodeList.getLength(); i++) {
							Node db = nodeList.item(i);
							for (Node node = db.getFirstChild(); node != null; node = node.getNextSibling()) {
								if (node.getNodeType() == Node.ELEMENT_NODE) {
									if (nodeName.equals(node.getNodeName())) {
										value = node.getNodeValue();
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			getLogger().logError("读取文件失败，失败原因：" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					getLogger().logError("读取文件失败，失败原因：" + e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return value;
	}
}