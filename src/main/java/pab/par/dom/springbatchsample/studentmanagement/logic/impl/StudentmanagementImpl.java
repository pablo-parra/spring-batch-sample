package pab.par.dom.springbatchsample.studentmanagement.logic.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity.EnabledStudent;
import pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity.Register;
import pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity.Student;
import pab.par.dom.springbatchsample.studentmanagement.dataaccess.repository.EnabledStudentRepository;
import pab.par.dom.springbatchsample.studentmanagement.dataaccess.repository.RegisterRepository;
import pab.par.dom.springbatchsample.studentmanagement.dataaccess.repository.StudentRepository;
import pab.par.dom.springbatchsample.studentmanagement.logic.api.Studentmanagement;

/**
 * Implementation class for the {@link Studentmanagement} interface
 *
 */
@Component
public class StudentmanagementImpl implements Studentmanagement {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private EnabledStudentRepository enabledStudentRepository;

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
  public List<Student> getAll() {

    return this.studentRepository.findAll();
  }

  @Override
  public List<EnabledStudent> getAllEnabledStudents() {

    return this.enabledStudentRepository.findAll();
  }

  @Override
  public void clearEnabledStudents() {

    this.enabledStudentRepository.deleteAll();

  }

  @Override
  public List<Student> getAllStudentsByEnabledStatus() {

    return this.studentRepository.findByEnabled(true);
  }

}
