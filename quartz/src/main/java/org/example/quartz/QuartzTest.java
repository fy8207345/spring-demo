package org.example.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class QuartzTest {
    private static final Logger logger = LoggerFactory.getLogger(QuartzTest.class);
    public static void main(String[] args) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            scheduler.start();

            JobDetail jobDetail = newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .build();

            Trigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                    .withIntervalInSeconds(4)
                    .repeatForever())
                    .build();

            scheduler.scheduleJob(jobDetail, trigger);

            Thread.sleep(10000);
            scheduler.shutdown();
        }catch (SchedulerException | InterruptedException e){
            e.printStackTrace();
        }
    }

    public static class HelloJob implements Job {
        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            logger.info("job execution : {}", context);
        }
    }
}
