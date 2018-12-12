package pab.par.dom.springbatchsample.jobmanagement.dataaccess.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Batch Job Execution Entity
 *
 */
@Entity
@Table(name = "BATCH_JOB_EXECUTION")
public class BatchJobExecution {

  @Id
  @Column(name = "JOB_EXECUTION_ID")
  private Long jobExecutionId;

  private Long version;

  @Column(name = "JOB_INSTANCE_ID")
  private Long jobInstanceId;

  @Column(name = "CREATE_TIME")
  private Timestamp createTime;

  @Column(name = "START_TIME")
  private Timestamp startTime;

  @Column(name = "END_TIME")
  private Timestamp endTime;

  private String status;

  @Column(name = "EXIT_CODE")
  private String exitCode;

  @Column(name = "EXIT_MESSAGE")
  private String exitMessage;

  @Column(name = "LAST_UPDATED")
  private Timestamp lastUpdated;

  @Column(name = "JOB_CONFIGURATION_LOCATION")
  private String jobConfigurationLocation;

  /**
   * @return jobExecutionId
   */
  public Long getJobExecutionId() {

    return this.jobExecutionId;
  }

  /**
   * @param jobExecutionId new value of {@link #getJobExecutionId}.
   */
  public void setJobExecutionId(Long jobExecutionId) {

    this.jobExecutionId = jobExecutionId;
  }

  /**
   * @return version
   */
  public Long getVersion() {

    return this.version;
  }

  /**
   * @param version new value of {@link #getVersion}.
   */
  public void setVersion(Long version) {

    this.version = version;
  }

  /**
   * @return jobInstanceId
   */
  public Long getJobInstanceId() {

    return this.jobInstanceId;
  }

  /**
   * @param jobInstanceId new value of {@link #getJobInstanceId}.
   */
  public void setJobInstanceId(Long jobInstanceId) {

    this.jobInstanceId = jobInstanceId;
  }

  /**
   * @return createTime
   */
  public Timestamp getCreateTime() {

    return this.createTime;
  }

  /**
   * @param createTime new value of {@link #getCreateTime}.
   */
  public void setCreateTime(Timestamp createTime) {

    this.createTime = createTime;
  }

  /**
   * @return startTime
   */
  public Timestamp getStartTime() {

    return this.startTime;
  }

  /**
   * @param startTime new value of {@link #getStartTime}.
   */
  public void setStartTime(Timestamp startTime) {

    this.startTime = startTime;
  }

  /**
   * @return endTime
   */
  public Timestamp getEndTime() {

    return this.endTime;
  }

  /**
   * @param endTime new value of {@link #getEndTime}.
   */
  public void setEndTime(Timestamp endTime) {

    this.endTime = endTime;
  }

  /**
   * @return status
   */
  public String getStatus() {

    return this.status;
  }

  /**
   * @param status new value of {@link #getStatus}.
   */
  public void setStatus(String status) {

    this.status = status;
  }

  /**
   * @return exitCode
   */
  public String getExitCode() {

    return this.exitCode;
  }

  /**
   * @param exitCode new value of {@link #getExitCode}.
   */
  public void setExitCode(String exitCode) {

    this.exitCode = exitCode;
  }

  /**
   * @return exitMessage
   */
  public String getExitMessage() {

    return this.exitMessage;
  }

  /**
   * @param exitMessage new value of {@link #getExitMessage}.
   */
  public void setExitMessage(String exitMessage) {

    this.exitMessage = exitMessage;
  }

  /**
   * @return lastUpdated
   */
  public Timestamp getLastUpdated() {

    return this.lastUpdated;
  }

  /**
   * @param lastUpdated new value of {@link #getLastUpdated}.
   */
  public void setLastUpdated(Timestamp lastUpdated) {

    this.lastUpdated = lastUpdated;
  }

  /**
   * @return jobConfigurationLocation
   */
  public String getJobConfigurationLocation() {

    return this.jobConfigurationLocation;
  }

  /**
   * @param jobConfigurationLocation new value of {@link #getJobConfigurationLocation}.
   */
  public void setJobConfigurationLocation(String jobConfigurationLocation) {

    this.jobConfigurationLocation = jobConfigurationLocation;
  }

}
