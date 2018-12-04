package pab.par.dom.springbatchsample.config;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import pab.par.dom.springbatchsample.service.data.entity.EnabledStudent;
import pab.par.dom.springbatchsample.service.data.entity.Student;
import pab.par.dom.springbatchsample.service.data.repository.EnabledStudentRepository;

/**
 * Student Item Writer
 *
 */
public class StudentItemWriter implements ItemWriter<Student> {

  @Autowired
  private EnabledStudentRepository enabledStudent;

  private ModelMapper mapper;

  @Override
  public void write(List<? extends Student> items) throws Exception {

    this.mapper = new ModelMapper();

    cleanTable();

    for (Student item : items) {
      this.enabledStudent.save(this.mapper.map(item, EnabledStudent.class));
    }

  }

  private void cleanTable() {

    this.enabledStudent.deleteAll();
  }

}
