package pab.par.dom.springbatchsample.studentmanagement.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity.Register;

/**
 * Register Jpa Repository
 *
 */
public interface RegisterRepository extends JpaRepository<Register, Integer> {

}
