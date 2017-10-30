package org.module.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

/**
 * 
 * 类: IBaseJob <br>
 * 描述: 统一定时调用接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月30日 下午12:02:24
 */
public interface IBaseJob extends Job {
	/**
	 * 
	 * 调用执行定时任务
	 * 
	 * @param context
	 */
	public void doExecute(JobExecutionContext context);
}
