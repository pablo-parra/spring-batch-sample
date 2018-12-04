package pab.par.dom.springbatchsample.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
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

import pab.par.dom.springbatchsample.service.data.dto.DownloadInfoDto;

/**
 * REST controller to start the batch job
 *
 */
@Controller
public class JobLauncherController {

  private static final Logger log = LoggerFactory.getLogger(JobLauncherController.class);

  @Autowired
  JobLauncher jobLauncher;

  @Autowired
  Job job;

  /**
   * End point to start a batch job
   *
   * @return the URL and Estimated Time of Arrival to get the result of the job
   * @throws JobParametersInvalidException
   * @throws JobInstanceAlreadyCompleteException
   * @throws JobRestartException
   * @throws JobExecutionAlreadyRunningException
   */
  @RequestMapping(value = "/startjob/{name}", method = RequestMethod.GET)
  public ResponseEntity<DownloadInfoDto> startJob(@PathVariable("name") String name)
      throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException,
      JobParametersInvalidException {

    log.info("Name: " + name);
    // Job job = ctx.getBean("addNewPodcastJob", Job.class);

    this.jobLauncher.run(this.job, new JobParameters());
    return new ResponseEntity<>(new DownloadInfoDto("http://asdfasdf", "300s"), HttpStatus.ACCEPTED);
  }

}
