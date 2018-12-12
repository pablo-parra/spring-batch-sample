package pab.par.dom.springbatchsample.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pab.par.dom.springbatchsample.jobmanagement.dataaccess.entity.BatchJobExecution;
import pab.par.dom.springbatchsample.jobmanagement.logic.api.Jobmanagement;
import pab.par.dom.springbatchsample.studentmanagement.dataaccess.dto.JobInfo;
import pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity.EnabledStudent;
import pab.par.dom.springbatchsample.studentmanagement.logic.api.Studentmanagement;

/**
 * REST controller to start the batch job
 *
 */
@Controller
public class JobLauncherController {

  private static final Logger log = LoggerFactory.getLogger(JobLauncherController.class);

  @Autowired
  private Jobmanagement jobmanagement;

  @Autowired
  private Studentmanagement studentmanagement;

  /**
   * Starts the job synchronously
   *
   * @return the {@link JobInfo} object with the started job info
   * @throws JobExecutionAlreadyRunningException if the job is already running
   * @throws JobRestartException if the job could not restart
   * @throws JobInstanceAlreadyCompleteException if the instance is already completed
   * @throws JobParametersInvalidException if the parameter is not valid
   */
  @RequestMapping(value = "/startjob", method = RequestMethod.GET)
  public ResponseEntity<JobInfo> startJob() throws JobExecutionAlreadyRunningException, JobRestartException,
      JobInstanceAlreadyCompleteException, JobParametersInvalidException {

    log.info("Starting job synchronously...");
    UUID jobUUID = UUID.randomUUID();
    this.jobmanagement.startJob(jobUUID.toString());
    return new ResponseEntity<>(new JobInfo(jobUUID.toString(), BatchStatus.STARTING.toString(),
        new Timestamp(System.currentTimeMillis()), null), HttpStatus.ACCEPTED);
  }

  /**
   * Starts the job asynchronously
   *
   * @return the {@link JobInfo} object with the started job info
   * @throws JobExecutionAlreadyRunningException if the job is already running
   * @throws JobRestartException if the job could not restart
   * @throws JobInstanceAlreadyCompleteException if the instance is already completed
   * @throws JobParametersInvalidException if the parameter is not valid
   */
  @RequestMapping(value = "/startjobasync", method = RequestMethod.GET)
  public ResponseEntity<JobInfo> startJobAsync() throws JobExecutionAlreadyRunningException, JobRestartException,
      JobInstanceAlreadyCompleteException, JobParametersInvalidException {

    log.info("Starting job asynchronously...");
    UUID jobUUID = UUID.randomUUID();
    this.jobmanagement.startJobAsync(jobUUID.toString());
    return new ResponseEntity<>(new JobInfo(jobUUID.toString(), BatchStatus.STARTING.toString(),
        new Timestamp(System.currentTimeMillis()), null), HttpStatus.ACCEPTED);
  }

  /**
   * Returns the list of the enabled students
   *
   * @return the List with the enabled students
   */
  @RequestMapping(value = "/enabledstudents", method = RequestMethod.GET)
  public ResponseEntity<List<EnabledStudent>> getEnabledStudents() {

    return new ResponseEntity<>(this.studentmanagement.getAllEnabledStudents(), HttpStatus.OK);

  }

  /**
   * Returns the info about the status of a Job based on a jobId
   *
   * @param jobId the id of the job
   * @return the job info found related to that given jobId
   */
  @RequestMapping(value = "/status/{jobId}", method = RequestMethod.GET)
  public ResponseEntity<JobInfo> getJobStatus(@PathVariable String jobId) {

    Optional<BatchJobExecution> result = this.jobmanagement.getJobStatus(jobId);

    if (result.isPresent()) {
      BatchJobExecution jobExec = result.get();
      return new ResponseEntity<>(new JobInfo(jobId, jobExec.getStatus(), jobExec.getStartTime(), jobExec.getEndTime()),
          HttpStatus.OK);
    }

    return new ResponseEntity<>(new JobInfo(), HttpStatus.NOT_FOUND);
  }

}
