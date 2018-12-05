package pab.par.dom.springbatchsample.jobmanagement.jobconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;

import pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity.Student;

/**
 * Student Enabled Filter Processor
 *
 */
public class EnabledFilterProcessor implements ItemProcessor<Student, Student>, StepExecutionListener {

  private static final Logger log = LoggerFactory.getLogger(EnabledFilterProcessor.class);

  @Override
  public void beforeStep(StepExecution stepExecution) {

    log.debug("EnabledFilterProcessor initialized.");

  }

  @Override
  public Student process(Student item) throws Exception {

    if (item.getEnabled()) {
      return item;
    }
    return null;
    // return item.getEnabled() ? item : null;
  }

  @Override
  public ExitStatus afterStep(StepExecution stepExecution) {

    log.debug("EnabledFilterProcessor ended.");
    return ExitStatus.COMPLETED;
  }

}
