package pab.par.dom.springbatchsample.studentmanagement.dataaccess.dto;

import java.util.Date;

/**
 * Class to wrap the response info
 *
 */
public class JobInfo {

  private String jobId;

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
  public JobInfo(String jobId, Date launched) {

    this.jobId = jobId;
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
