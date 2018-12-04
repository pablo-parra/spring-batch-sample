package pab.par.dom.springbatchsample.service.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pab.par.dom.springbatchsample.service.data.entity.Student;

/**
 * Student Jpa Repository
 *
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

  List<Student> findByEnabled(Boolean enabled);

  List<Student> findAll();

}
