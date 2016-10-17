package org.module.commons.util.map;

import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class MDataMap extends MObjMap<String, String> implements Map<String, String> {

	private static final long serialVersionUID = 5665659711983494008L;

	/**
	 * 转换主键到数组
	 * 
	 * @return
	 */
	public String[] convertKeysToStrings() {
		return this.upKeys().toArray(new String[] {});
	}

	/**
	 * 获取子数据 根据传入参数取得以该参数开头的集合
	 * 
	 * @param sStartString
	 * @return
	 */
	public MDataMap upSubMap(String sStartString) {
		MDataMap mReturn = new MDataMap();

		for (String sKey : this.upKeys()) {
			if (StringUtils.startsWith(sKey, sStartString)) {
				mReturn.put(StringUtils.substringAfter(sKey, sStartString), this.get(sKey));
			}
		}
		return mReturn;
	}

	public String[] upStrings() {
		ArrayList<String> aList = new ArrayList<String>();
		for (String sKey : this.upKeys()) {
			aList.add(sKey);
			aList.add(this.get(sKey));
		}

		return aList.toArray(new String[] {});

	}

	public MDataMap() {

	}

	public MDataMap(String... sInputs) {
		inAllValues(sInputs);
	}

	public MDataMap(Map<String, Object> mInput) {

		for (String s : mInput.keySet()) {

			if (mInput.get(s) != null) {

				put(s, mInput.get(s).toString());
			} else {
				put(s, "");
			}
		}
	}

	public String upValue(String sKey) {
		return upValue(sKey, "");
	}

	public String upValue(String sKey, String sDefault) {
		String sReturn = sDefault;
		if (this.containsKey(sKey)) {
			sReturn = this.get(sKey);
		}
		return sReturn;
	}

}
