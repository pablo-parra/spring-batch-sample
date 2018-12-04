package pab.par.dom.springbatchsample.config;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import pab.par.dom.springbatchsample.service.data.entity.Student;
import pab.par.dom.springbatchsample.service.logic.api.Studentmanagement;

/**
 * Student Reader
 *
 */
public class StudentItemReader implements ItemReader<Student> {

  @Autowired
  private Studentmanagement studentmanagement;

  private ItemReader<Student> delegate;

  @Override
  public Student read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

    if (this.delegate == null) {
      this.delegate = new IteratorItemReader<>(students());
    }
    return this.delegate.read();
  }

  private List<Student> students() {

    // return this.studentmanagement.getEnabledStudents();
    return this.studentmanagement.getAll();
  }

}
