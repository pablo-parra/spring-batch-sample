package pab.par.dom.springbatchsample.jobmanagement.logic.impl;

import java.util.Optional;

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

import pab.par.dom.springbatchsample.jobmanagement.dataaccess.entity.BatchJobExecution;
import pab.par.dom.springbatchsample.jobmanagement.dataaccess.entity.BatchJobExecutionParams;
import pab.par.dom.springbatchsample.jobmanagement.dataaccess.repository.BatchJobExecutionParamsRepository;
import pab.par.dom.springbatchsample.jobmanagement.dataaccess.repository.BatchJobExecutionRepository;
import pab.par.dom.springbatchsample.jobmanagement.logic.api.Jobmanagement;

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

  @Autowired
  private BatchJobExecutionRepository batchJobExecutionRepository;

  @Autowired
  private BatchJobExecutionParamsRepository batchJobExecutionParamsRepository;

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

  @Override
  public Optional<BatchJobExecution> getJobStatus(String jobId) {

    BatchJobExecutionParams execParams = this.batchJobExecutionParamsRepository.findBystringVal(jobId);

    return this.batchJobExecutionRepository.findById(execParams.getJobExecutionId());

  }

}
