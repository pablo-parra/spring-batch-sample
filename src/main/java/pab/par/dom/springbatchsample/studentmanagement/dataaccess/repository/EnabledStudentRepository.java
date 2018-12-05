package pab.par.dom.springbatchsample.studentmanagement.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity.EnabledStudent;

/**
 * Enabled Student Repository
 *
 */
public interface EnabledStudentRepository extends JpaRepository<EnabledStudent, String> {

}
