package com.gx.util1;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.gx.serviceImpl.TsValue;
/**
 * 调度工具
 * @author win10
 *
 */
public class CallQuartz implements Job{
	private static SchedulerFactory schedulerFactory;
	
	@Override
	public void execute(JobExecutionContext JobContext) throws JobExecutionException {
		 System.err.println("\n任务调用成功!");
		    //获取用户信息
			JobDataMap dataMap = JobContext.getJobDetail().getJobDataMap();
			String userName = (String)dataMap.get("user");
			
			TsValue tv = new TsValue();
			TsValue.Info(userName);
	}
	
	/**
	 * 任务调用
	 * @throws SchedulerException 
	 * @throws InterruptedException 
	 */
	public static void Quartz(String time,String value){
		schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler;
		try {
			scheduler = schedulerFactory.getScheduler();
			JobDetail job = JobBuilder.newJob(CallQuartz.class).withIdentity("JobName", "JobGroupName").build(); 
			JobDataMap dataMap = job.getJobDataMap();
			dataMap.put("user",value);
			 
			Trigger trigger=TriggerBuilder.newTrigger().withIdentity("CronTrigger1", "CronTriggerGroup")    
		              .withSchedule(CronScheduleBuilder.cronSchedule(time))    
		              .startNow().build();
			 scheduler.scheduleJob(job, trigger);
			 scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	/** 
     * 关闭所有定时任务 
     */  
    public static void shutdownJobs() {  
        try {  
            Scheduler sched = schedulerFactory.getScheduler();  
            if (!sched.isShutdown()) {  
                sched.shutdown();  
            }  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
	
}
