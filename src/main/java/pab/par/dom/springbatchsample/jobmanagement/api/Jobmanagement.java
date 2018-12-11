package pab.par.dom.springbatchsample.jobmanagement.api;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

/**
 * Interface for logic related to Job management.
 *
 */
public interface Jobmanagement {

  void startJob(String jobProcessId) throws JobExecutionAlreadyRunningException, JobRestartException,
      JobInstanceAlreadyCompleteException, JobParametersInvalidException;

  void startJobAsync(String jobProcessId) throws JobExecutionAlreadyRunningException, JobRestartException,
      JobInstanceAlreadyCompleteException, JobParametersInvalidException;

}
