package pab.par.dom.springbatchsample.jobmanagement.jobconfig;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity.Student;
import pab.par.dom.springbatchsample.studentmanagement.logic.api.Studentmanagement;

/**
 * Student Reader
 *
 */
public class StudentItemReader implements ItemReader<Student>, StepExecutionListener {

  private static final Logger log = LoggerFactory.getLogger(StudentItemReader.class);

  @Autowired
  private Studentmanagement studentmanagement;

  private ItemReader<Student> delegate;

  @Override
  public void beforeStep(final StepExecution stepExecution) {

    log.debug("StudentItemReader initialized.");

  }

  @Override
  public Student read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

    if (this.delegate == null) {
      this.delegate = new IteratorItemReader<>(students());
    }
    return this.delegate.read();
  }

  private List<Student> students() {

    List<Student> students = this.studentmanagement.getAll();
    return students;
  }

  @Override
  public ExitStatus afterStep(StepExecution stepExecution) {

    log.debug("StudentItemReader ended.");
    return ExitStatus.COMPLETED;
  }

}
