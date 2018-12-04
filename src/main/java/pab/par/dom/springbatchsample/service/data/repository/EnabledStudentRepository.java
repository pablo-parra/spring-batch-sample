package pab.par.dom.springbatchsample.service.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pab.par.dom.springbatchsample.service.data.entity.EnabledStudent;

/**
 * Enabled Student Repository
 *
 */
public interface EnabledStudentRepository extends JpaRepository<EnabledStudent, String> {

}
