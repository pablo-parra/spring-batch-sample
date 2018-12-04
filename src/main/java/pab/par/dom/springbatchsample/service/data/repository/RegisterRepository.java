package pab.par.dom.springbatchsample.service.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pab.par.dom.springbatchsample.service.data.entity.Register;

/**
 * Register Jpa Repository
 *
 */
public interface RegisterRepository extends JpaRepository<Register, Integer> {

}
