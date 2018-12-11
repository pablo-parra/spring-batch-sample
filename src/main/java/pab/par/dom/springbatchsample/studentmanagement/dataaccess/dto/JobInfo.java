package pab.par.dom.springbatchsample.studentmanagement.dataaccess.dto;

import java.util.Date;

import org.springframework.batch.core.BatchStatus;

/**
 * Class to wrap the response info
 *
 */
public class JobInfo {

  private String jobId;

  private BatchStatus status;

  private Date launched;

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
   * @param launched the ETA value
   */
  public JobInfo(String jobId, BatchStatus status, Date launched) {

    this.jobId = jobId;
    this.status = status;
    this.launched = launched;
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
  public BatchStatus getStatus() {

    return this.status;
  }

  /**
   * @param status new value of {@link #getStatus}.
   */
  public void setStatus(BatchStatus status) {

    this.status = status;
  }

  /**
   * @return launched
   */
  public Date getLaunched() {

    return this.launched;
  }

  /**
   * @param launched new value of {@link #getLaunched}.
   */
  public void setLaunched(Date launched) {

    this.launched = launched;
  }

}
