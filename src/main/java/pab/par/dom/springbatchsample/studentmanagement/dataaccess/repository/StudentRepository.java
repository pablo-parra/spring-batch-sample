package pab.par.dom.springbatchsample.studentmanagement.dataaccess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity.Student;

/**
 * Student Repository
 *
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

  List<Student> findByEnabled(Boolean enabled);

  List<Student> findAll();

}
