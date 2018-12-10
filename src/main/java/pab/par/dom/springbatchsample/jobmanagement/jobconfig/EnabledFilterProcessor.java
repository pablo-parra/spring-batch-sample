package pab.par.dom.springbatchsample.jobmanagement.jobconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;

import pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity.EnabledStudent;
import pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity.Student;

/**
 * Student Enabled Filter Processor
 *
 */
public class EnabledFilterProcessor implements ItemProcessor<Student, EnabledStudent>, StepExecutionListener {

  private static final Logger log = LoggerFactory.getLogger(EnabledFilterProcessor.class);

  @Override
  public void beforeStep(StepExecution stepExecution) {

    log.debug("EnabledFilterProcessor initialized.");

  }

  // @Override
  // public Student process(Student item) throws Exception {
  //
  // if (item.getEnabled()) {
  // return item;
  // }
  // return null;
  // // return item.getEnabled() ? item : null;
  // }

  @Override
  public EnabledStudent process(Student item) throws Exception {

    if (item.getEnabled()) {
      EnabledStudent enabledStudent = new EnabledStudent();
      enabledStudent.setName(item.getPerson().getFirstName().concat(" ").concat(item.getPerson().getLastName()));
      enabledStudent.setDegree(item.getDegree());
      enabledStudent.setEmail(item.getPerson().getContact().getEmail());
      enabledStudent.setPhone(item.getPerson().getContact().getPhone());
      enabledStudent.setCity(item.getPerson().getAddress().getCity());
      return enabledStudent;
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
