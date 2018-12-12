package pab.par.dom.springbatchsample.jobmanagement.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pab.par.dom.springbatchsample.jobmanagement.dataaccess.entity.BatchJobExecution;

/**
 * Batch Job Execution Repository
 *
 */
public interface BatchJobExecutionRepository extends JpaRepository<BatchJobExecution, Long> {

}
