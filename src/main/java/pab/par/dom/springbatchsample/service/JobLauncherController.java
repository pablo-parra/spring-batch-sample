package pab.par.dom.springbatchsample.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pab.par.dom.springbatchsample.jobmanagement.api.Jobmanagement;
import pab.par.dom.springbatchsample.studentmanagement.dataaccess.dto.JobInfo;

/**
 * REST controller to start the batch job
 *
 */
@Controller
public class JobLauncherController {

  private static final Logger log = LoggerFactory.getLogger(JobLauncherController.class);

  @Autowired
  private Jobmanagement jobmanagement;

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

    this.jobmanagement.startJob();
    return new ResponseEntity<>(new JobInfo("foo", new Date()), HttpStatus.ACCEPTED);
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

    this.jobmanagement.startJobAsync();
    return new ResponseEntity<>(new JobInfo("1234", new Date()), HttpStatus.ACCEPTED);
  }

  // TODO job to return the values inserted in the enabled_student table
  // @RequestMapping(value = "/enabledstudents", method = RequestMethod.GET)
  // public ResponseEntity<DownloadInfoDto> startJobByName() throws JobExecutionAlreadyRunningException,
  // JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
  //
  // this.jobLauncher.run(this.job, new JobParametersBuilder().addLong("unique", System.nanoTime()).toJobParameters());
  // return new ResponseEntity<>(new DownloadInfoDto("http://asdfasdf", "300s"), HttpStatus.ACCEPTED);
  // }

  // TODO launch a job by its name
  // /**
  // * End point to start a batch job
  // *
  // * @return the URL and Estimated Time of Arrival to get the result of the job
  // * @throws JobParametersInvalidException
  // * @throws JobInstanceAlreadyCompleteException
  // * @throws JobRestartException
  // * @throws JobExecutionAlreadyRunningException
  // */
  // @RequestMapping(value = "/startjob/{name}", method = RequestMethod.GET)
  // public ResponseEntity<DownloadInfoDto> startJobByName(@PathVariable("name") String name)
  // throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException,
  // JobParametersInvalidException {
  //
  // log.info("Name: " + name);
  //
  // // this.jobLauncher.run(this.job, new JobParameters());
  // this.jobLauncher.run(this.job, new JobParametersBuilder().addLong("unique", System.nanoTime()).toJobParameters());
  // return new ResponseEntity<>(new DownloadInfoDto("http://asdfasdf", "300s"), HttpStatus.ACCEPTED);
  // }

}
