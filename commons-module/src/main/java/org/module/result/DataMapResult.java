package org.module.result;

import java.util.List;

import org.module.commons.map.MDataMap;

public class DataMapResult extends RootResult{

	private List<MDataMap> data;

	public List<MDataMap> getData() {
		return data;
	}

	public void setData(List<MDataMap> data) {
		this.data = data;
	}

}
