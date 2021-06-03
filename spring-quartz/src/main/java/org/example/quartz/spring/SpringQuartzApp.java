package org.example.quartz.spring;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

@Slf4j
@SpringBootApplication
public class SpringQuartzApp {

    public static void main(String[] args) throws SchedulerException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringQuartzApp.class, args);
        SchedulerFactoryBean schedulerFactoryBean = applicationContext.getBean(SchedulerFactoryBean.class);
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        log.info("scheduler : {} - {}", scheduler, schedulerFactoryBean);
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("job1", "group1")
                .build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                .repeatForever().withIntervalInMilliseconds(500))
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    @Bean
    public String string(){
        return "A String";
    }

    @Component
    public static class MyJob implements Job{
        @Autowired
        private String string;
        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            log.info("!!!!!job executing : {} - {}", context, string);
        }
    }
}
