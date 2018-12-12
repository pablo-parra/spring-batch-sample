package pab.par.dom.springbatchsample.jobmanagement.logic.api;

import java.util.Optional;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

import pab.par.dom.springbatchsample.jobmanagement.dataaccess.entity.BatchJobExecution;

/**
 * Interface for logic related to Job management.
 *
 */
public interface Jobmanagement {

  void startJob(String jobProcessId) throws JobExecutionAlreadyRunningException, JobRestartException,
      JobInstanceAlreadyCompleteException, JobParametersInvalidException;

  void startJobAsync(String jobProcessId) throws JobExecutionAlreadyRunningException, JobRestartException,
      JobInstanceAlreadyCompleteException, JobParametersInvalidException;

  Optional<BatchJobExecution> getJobStatus(String jobId);

}
