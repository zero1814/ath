package org.module.quartz;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.ClassUtils;
import org.module.base.BaseClass;
import org.module.quartz.job.IBaseJob;
import org.module.quartz.model.JobInfo;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class JobSupport extends BaseClass {

	private static JobSupport jobSupport = null;

	private Scheduler scheduler = null;

	public static JobSupport getInstance() {
		if (jobSupport == null) {
			jobSupport = new JobSupport();
		}
		return jobSupport;
	}

	/**
	 * 
	 * 方法: addJob <br>
	 * 描述: 添加定时任务 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月30日 下午12:03:00
	 * 
	 * @param info
	 */
	@SuppressWarnings("unchecked")
	public synchronized void addJob(JobInfo info) {
		try {
			if (scheduler == null) {
				SchedulerFactory sf = new StdSchedulerFactory();
				scheduler = sf.getScheduler();
				scheduler.start();
			}
			// 设置作业，具体操作在SimpleJob类里
			Class<IBaseJob> jClass = ClassUtils.getClass(info.getJobClass());
			JobDetail job = JobBuilder.newJob(jClass).withIdentity(info.getJobName(), Scheduler.DEFAULT_GROUP).build(); // 设置作业，具体操作在SimpleJob类里
			CronTrigger trigger = (CronTrigger) TriggerBuilder.newTrigger()
					.withIdentity("trigger_" + info.getJobName(), Scheduler.DEFAULT_GROUP)
					.withSchedule(CronScheduleBuilder.cronSchedule(info.getJobTriger())).build(); // 设置触发器
			Set<CronTrigger> sTriggers = new HashSet<CronTrigger>();
			sTriggers.add(trigger);
			job.getJobDataMap().put("status", info);
			scheduler.scheduleJob(job, sTriggers, true); // 设置调度作业
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	/**
	 * 
	 * 方法: deleteJob <br>
	 * 描述: 删除任务 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月30日 下午12:06:26
	 * 
	 * @param name
	 * @return
	 */
	public boolean deleteJob(String name) {
		try {
			scheduler.deleteJob(JobKey.jobKey(name, Scheduler.DEFAULT_GROUP));
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * 
	 * 方法: shutDown <br>
	 * 描述: 关闭所有定时器 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月30日 下午12:05:28
	 * 
	 * @return
	 */
	public boolean shutDown() {
		try {
			if (scheduler != null) {
				scheduler.shutdown();
				// 延迟一秒 静候所有任务停止
				Thread.sleep(1000);

				while (!scheduler.isShutdown()) {
					Thread.sleep(1000);
				}
				scheduler.shutdown(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * 
	 * 方法: start <br>
	 * 描述: 开始定时任务 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月30日 下午12:04:49
	 * 
	 * @return
	 */
	public boolean start() {
		try {
			if (scheduler.isShutdown()) {
				scheduler.start();
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * 
	 * 方法: pauseAll <br>
	 * 描述: 暂停所有定时任务 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月30日 下午12:05:37
	 * 
	 * @return
	 */
	public boolean pauseAll() {
		try {
			scheduler.pauseAll();
		} catch (SchedulerException e) {

			e.printStackTrace();
		}
		return true;
	}

	/**
	 * 
	 * 方法: resumeAll <br>
	 * 描述: 继续所有定时任务 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月30日 下午12:05:02
	 * 
	 * @return
	 */
	public boolean resumeAll() {
		try {
			scheduler.resumeAll();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * 
	 * 方法: restart <br>
	 * 描述: 重启所有定时任务 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月30日 下午12:05:05
	 * 
	 * @return
	 */
	public boolean restart() {
		shutDown();
		return start();
	}

}
