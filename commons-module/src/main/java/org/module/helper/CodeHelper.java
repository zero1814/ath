package org.module.helper;

import org.module.annotation.Inject;
import org.module.base.BaseClass;
import org.module.mapper.CodeMapper;
import org.module.util.UniqueIdUtil;

public class CodeHelper extends BaseClass {

	@Inject
	private CodeMapper codeMapper;

	public static String getCode(String prefix) {
		String code = new CodeHelper().findCode(prefix);
		return code;
	}

	public String findCode(String prefix) {
		return codeMapper.getCode(prefix);
	}

	/**
	 * 
	 * 方法: getUniqueCode <br>
	 * 描述: 获取唯一编码 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月29日 上午7:11:12
	 * 
	 * @param workerId
	 * @param datacenterId
	 * @param prefix
	 * @return
	 */
	public static String getUniqueCode(long workerId, long datacenterId, String prefix) {
		long workid = 1;
		return prefix + UniqueIdUtil.getInstance(workid, workid).nextId();
	}

	/**
	 * 
	 * 方法: getUniqueCode <br>
	 * 描述: 获取唯一编码 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月29日 上午7:17:48
	 * 
	 * @param prefix
	 * @return
	 */
	public static String getUniqueCode(String prefix) {
		return prefix + UniqueIdUtil.getInstance().nextId();
	}
}
