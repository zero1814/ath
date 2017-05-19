package org.module.result;

import java.util.List;
import java.util.Map;

public class DataMapResult extends RootResult {

	private List<Map<String, Object>> data;

	public List<Map<String, Object>> getData() {
		return data;
	}

	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}

}
