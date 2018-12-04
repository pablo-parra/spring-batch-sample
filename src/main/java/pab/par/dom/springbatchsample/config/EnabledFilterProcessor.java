package pab.par.dom.springbatchsample.config;

import org.springframework.batch.item.ItemProcessor;

import pab.par.dom.springbatchsample.service.data.entity.Student;

/**
 * Student Enabled Filter Processor
 *
 */
public class EnabledFilterProcessor implements ItemProcessor<Student, Student> {

  @Override
  public Student process(Student item) throws Exception {

    return item.getEnabled() ? item : null;
  }

}
