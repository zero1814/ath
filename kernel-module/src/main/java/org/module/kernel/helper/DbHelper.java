package org.module.kernel.helper;

import org.module.commons.base.BaseClass;
import org.module.result.RootResult;
import org.module.service.kernel.db.ICmDatabaseService;
import org.springframework.stereotype.Component;

import com.google.inject.Inject;

@Component
public class DbHelper extends BaseClass{

	@Inject
	private ICmDatabaseService service;
	
	
	/**
	 * 
	 * 方法: createTable <br>
	 * 描述: 创建表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月2日 下午10:59:56
	 * @return
	 */
	public RootResult createTable(){
		RootResult result = new RootResult();
		return result;
	}
	
	/**
	 * 
	 * 方法: addColumn <br>
	 * 描述: 表添加字段 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月2日 下午11:00:41
	 * @return
	 */
	public RootResult addColumn(){
		RootResult result = new RootResult();
		return result;		
	}
	public RootResult editColumn(){
		RootResult result = new RootResult();
		return result;		
	}
	public RootResult delColumn(){
		RootResult result = new RootResult();
		return result;
	}
	/**
	 * 
	 * 方法: addConstraint <br>
	 * 描述: 表字段添加约束 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月2日 下午11:02:26
	 * @return
	 */
	public RootResult addConstraint(){
		RootResult result = new RootResult();
		return result;
	}
	public RootResult editConstraint(){
		RootResult result = new RootResult();
		return result;
	}
	public RootResult delConstraint(){
		RootResult result = new RootResult();
		return result;
	}
}
