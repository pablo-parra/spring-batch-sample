package pab.par.dom.springbatchsample.jobmanagement.impl;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import pab.par.dom.springbatchsample.jobmanagement.api.Jobmanagement;

/**
 * Implementation of the {@link Jobmanagement} interface
 *
 */
@Component
public class JobmanagementImpl implements Jobmanagement {

  @Autowired
  JobLauncher jobLauncher;

  @Autowired
  @Qualifier("enabledStudentsJob")
  Job job;

  @Autowired
  @Qualifier("enabledStudentsJobAsync")
  Job jobAsync;

  @Override
  public void startJob(String jobProcessId) throws JobExecutionAlreadyRunningException, JobRestartException,
      JobInstanceAlreadyCompleteException, JobParametersInvalidException {

    this.jobLauncher.run(this.job,
        new JobParametersBuilder().addString("jobProcessId", jobProcessId).toJobParameters());

  }

  @Override
  @Async
  public void startJobAsync(String jobProcessId) throws JobExecutionAlreadyRunningException, JobRestartException,
      JobInstanceAlreadyCompleteException, JobParametersInvalidException {

    this.jobLauncher.run(this.jobAsync,
        new JobParametersBuilder().addString("jobProcessId", jobProcessId).toJobParameters());

  }

}
