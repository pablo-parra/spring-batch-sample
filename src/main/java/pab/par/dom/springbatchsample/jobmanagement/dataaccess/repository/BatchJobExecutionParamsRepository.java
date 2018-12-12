package pab.par.dom.springbatchsample.jobmanagement.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pab.par.dom.springbatchsample.jobmanagement.dataaccess.entity.BatchJobExecutionParams;

/**
 * Batch Job Execution Params Repository
 *
 */
public interface BatchJobExecutionParamsRepository extends JpaRepository<BatchJobExecutionParams, Long> {

  /**
   * Finds the BatchJobExecutionParams based on the string_value
   * 
   * @param value desired string_value
   * @return the BatchJobExecutionParams that fit the filter
   */
  BatchJobExecutionParams findBystringVal(String value);
}
