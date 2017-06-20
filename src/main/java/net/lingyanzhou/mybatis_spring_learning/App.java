package net.lingyanzhou.mybatis_spring_learning;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
  public static void main(String[] args) {

	String jobName="job";
	if (args.length>0) {
		jobName = args[0];
	}
	assert jobName.equals("job") || jobName.equals("job-mybatis-paged") || jobName.equals("job-mybatis-cursor");
	  
	String[] springConfig  = 
		{	
			"spring/batch/jobs/job.xml" 
		};
		
	ApplicationContext context = 
		new ClassPathXmlApplicationContext(springConfig);
		
	JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
	Job job = (Job) context.getBean(jobName);

	try {

		JobExecution execution = jobLauncher.run(job, new JobParameters());
		System.out.println("Exit Status : " + execution.getStatus());

	} catch (Exception e) {
		e.printStackTrace();
	}

	System.out.println("Done");

  }
}
