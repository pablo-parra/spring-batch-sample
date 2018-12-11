package pab.par.dom.springbatchsample.jobmanagement.jobconfig;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity.EnabledStudent;
import pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity.Student;
import pab.par.dom.springbatchsample.studentmanagement.dataaccess.repository.EnabledStudentRepository;

/**
 * Student Item Writer
 *
 */
public class StudentItemWriter
    implements ItemWriter<EnabledStudent>, StepExecutionListener, ItemWriteListener<Student> {

  private static final Logger log = LoggerFactory.getLogger(StudentItemWriter.class);

  @Autowired
  private EnabledStudentRepository enabledStudent;

  @Override
  public void beforeStep(final StepExecution stepExecution) {

    log.debug("StudentItemWriter initialized.");

  }

  @Override
  public void write(List<? extends EnabledStudent> items) throws Exception {

    items.forEach(it -> this.enabledStudent.save(it));
  }

  @Override
  public ExitStatus afterStep(StepExecution stepExecution) {

    log.debug("StudentItemWriter ended.");
    return ExitStatus.COMPLETED;
  }

  @Override
  public void beforeWrite(List<? extends Student> items) {

    log.debug("StudentItemWriter initialized.");

  }

  @Override
  public void afterWrite(List<? extends Student> items) {

    log.debug("StudentItemWriter ended.");

  }

  @Override
  public void onWriteError(Exception exception, List<? extends Student> items) {

    log.error("Error writing item: " + exception.getMessage());

  }

}
