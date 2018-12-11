package pab.par.dom.springbatchsample.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pab.par.dom.springbatchsample.jobmanagement.api.Jobmanagement;
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

  @Autowired
  private JobRepository jobRepository;

  /**
   * @return
   * @throws JobExecutionAlreadyRunningException
   * @throws JobRestartException
   * @throws JobInstanceAlreadyCompleteException
   * @throws JobParametersInvalidException
   */
  @RequestMapping(value = "/startjob", method = RequestMethod.GET)
  public ResponseEntity<JobInfo> startJob() throws JobExecutionAlreadyRunningException, JobRestartException,
      JobInstanceAlreadyCompleteException, JobParametersInvalidException {

    // Long jobProcessId = System.nanoTime();
    UUID jobUUID = UUID.randomUUID();
    this.jobmanagement.startJob(jobUUID.toString());
    return new ResponseEntity<>(new JobInfo(jobUUID.toString(), BatchStatus.STARTING, new Date()), HttpStatus.ACCEPTED);
  }

  /**
   * @return
   * @throws JobExecutionAlreadyRunningException
   * @throws JobRestartException
   * @throws JobInstanceAlreadyCompleteException
   * @throws JobParametersInvalidException
   */
  @RequestMapping(value = "/startjobasync", method = RequestMethod.GET)
  public ResponseEntity<JobInfo> startJobAsync() throws JobExecutionAlreadyRunningException, JobRestartException,
      JobInstanceAlreadyCompleteException, JobParametersInvalidException {

    // Long jobProcessId = System.nanoTime();
    UUID jobUUID = UUID.randomUUID();
    this.jobmanagement.startJobAsync(jobUUID.toString());
    return new ResponseEntity<>(new JobInfo(jobUUID.toString(), BatchStatus.STARTING, new Date()), HttpStatus.ACCEPTED);
  }

  /**
   * @return
   */
  @RequestMapping(value = "/enabledstudents", method = RequestMethod.GET)
  public ResponseEntity<List<EnabledStudent>> getEnabledStudents() {

    return new ResponseEntity<>(this.studentmanagement.getAllEnabledStudents(), HttpStatus.OK);

  }

  // @RequestMapping(value = "/status/{jobId}", method = RequestMethod.GET)
  // public ResponseEntity<List<EnabledStudent>> getJobStatus(@PathVariable String jobId) {
  //
  // this.jobRepository.
  // return new ResponseEntity<>(this.studentmanagement.getAllEnabledStudents(), HttpStatus.OK);
  //
  // }

}
