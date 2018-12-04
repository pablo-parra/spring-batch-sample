package pab.par.dom.springbatchsample.service.logic.api;

import java.util.List;

import pab.par.dom.springbatchsample.service.data.entity.Student;

/**
 * Interface for logic related to Student entity
 *
 */
public interface Studentmanagement {

  void createRegistration();

  List<Student> getEnabledStudents();

  List<Student> getAll();

}
