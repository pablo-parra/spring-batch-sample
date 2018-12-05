package pab.par.dom.springbatchsample.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import pab.par.dom.springbatchsample.service.data.repository.EnabledStudentRepository;

/**
 * Step class to clean enabled_student table
 *
 */
public class EnabledStudentCleaner implements Tasklet, StepExecutionListener {

  private static final Logger log = LoggerFactory.getLogger(StudentItemWriter.class);

  @Autowired
  private EnabledStudentRepository enabledStudent;

  @Override
  public void beforeStep(StepExecution stepExecution) {

    log.debug("Starting cleaning of EnabledStudent table...");

  }

  @Override
  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

    log.debug("Executing the cleaning of EnabledStudent table...");
    this.enabledStudent.deleteAll();
    return RepeatStatus.FINISHED;
  }

  @Override
  public ExitStatus afterStep(StepExecution stepExecution) {

    log.debug("Cleaning of EnabledStudent table is done.");
    return ExitStatus.COMPLETED;
  }

}
