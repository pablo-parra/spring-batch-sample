package pab.par.dom.springbatchsample.studentmanagement.dataaccess.dto;

import java.sql.Timestamp;

/**
 * Class to wrap the response info
 *
 */
public class JobInfo {

  private String jobId;

  private String status;

  private Timestamp startTime;

  private Timestamp endTime;

  /**
   *
   * The constructor.
   */
  public JobInfo() {

  }

  /**
   * The constructor.
   *
   * @param jobId the downloadURL value
   * @param status the status
   * @param startTime the startTime value
   * @param endTime the endTime
   */
  public JobInfo(String jobId, String status, Timestamp startTime, Timestamp endTime) {

    this.jobId = jobId;
    this.status = status;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  /**
   * @return jobId
   */
  public String getJobId() {

    return this.jobId;
  }

  /**
   * @param jobId new value of {@link #getJobId}.
   */
  public void setJobId(String jobId) {

    this.jobId = jobId;
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

}
