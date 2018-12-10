package pab.par.dom.springbatchsample.studentmanagement.logic.api;

import java.util.List;

import pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity.EnabledStudent;
import pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity.Student;

/**
 * Interface for logic related to Student entity
 *
 */
public interface Studentmanagement {

  List<Student> getAll();

  List<EnabledStudent> getAllEnabledStudents();

  void clearEnabledStudents();

  List<Student> getAllStudentsByEnabledStatus();

}
