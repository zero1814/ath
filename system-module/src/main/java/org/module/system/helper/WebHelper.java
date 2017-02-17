package org.module.system.helper;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.module.model.system.SmDefineChild;
import org.module.model.system.page.SmPageButton;
import org.module.system.util.Constant;

/**
 * 
 * 类: UrlHelper <br>
 * 描述: 访问地址帮助类 <br>
 * 作者: zhy<br>
 * 时间: 2017年2月15日 下午6:04:39
 */
public class WebHelper {

	/**
	 * 
	 * 方法: formatButtonHtml <br>
	 * 描述: 格式化按钮 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月16日 下午3:30:41
	 * 
	 * @param entity
	 * @return
	 */
	public static String formatButtonHtml(SmPageButton entity, Map<String, String> map) {
		StringBuffer button = new StringBuffer("<a ");
		button.append(" class='").append(entity.getStyle().getStyle()).append("' ");
		if (StringUtils.equals(entity.getOperationType(), "BOT831786739122040832")) {
			// 新窗口打开
			button.append(" target='_blank' href='").append(entity.getOperation()).append("' ");
		} else if (StringUtils.equals(entity.getOperationType(), "BOT831786741064003584")) {
			// 本窗口打开
			button.append(" target='_self' href='").append(entity.getOperation()).append("' ");
		} else if (StringUtils.equals(entity.getOperationType(), "BOT831786741185638400")) {
			// js脚本
			button.append(" href='javascript:void(0)' onclick='").append(entity.getOperation()).append("' ");
		}
		button.append(">").append(entity.getName()).append("</a>");
		return button.toString();
	}

	public static String formatButtonOperation(String operation) {
		if (StringUtils.contains(operation, Constant.WEB_SET_REPLACE)) {
			Pattern p = Pattern.compile("\\[@(.+?)\\$(.*?)\\]");
			Matcher m = p.matcher(operation);
			String replace = "";
			while (m.find()) {
				String full = m.group(0);
				String key = m.group(1);
				String attr = m.group(2);
				System.out.println(full + ":" + key + ":" + attr);
				operation = operation.replace(full, replace);
				System.out.println("operation:" + operation);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		SmDefineChild model = new SmDefineChild();
		model.setCode("1111");
		model.setUid("ddfdsfsfd");
		System.out.println(model.getFiledsInfo());
	}
}
