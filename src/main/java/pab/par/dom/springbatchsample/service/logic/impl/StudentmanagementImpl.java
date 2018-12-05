package pab.par.dom.springbatchsample.service.logic.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pab.par.dom.springbatchsample.service.data.entity.Register;
import pab.par.dom.springbatchsample.service.data.entity.Student;
import pab.par.dom.springbatchsample.service.data.repository.RegisterRepository;
import pab.par.dom.springbatchsample.service.data.repository.StudentRepository;
import pab.par.dom.springbatchsample.service.logic.api.Studentmanagement;

/**
 * Implementation class for the {@link Studentmanagement} interface
 *
 */
@Service
// @Transactional
public class StudentmanagementImpl implements Studentmanagement {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private RegisterRepository registerRepository;

  @Override
  public void createRegistration() {

    List<Student> enabledStudents = this.studentRepository.findByEnabled(true);
    Register record = new Register();
    record.setJobDate(new Timestamp(new Date().getTime()));
    record.setEnabledStudents(enabledStudents.toString());
    this.registerRepository.saveAndFlush(record);

  }

  @Override
  public List<Student> getEnabledStudents() {

    return this.studentRepository.findByEnabled(true);
  }

  @Override
  public List<Student> getAll() {

    return this.studentRepository.findAll();
  }

}
