package pab.par.dom.springbatchsample.service.data.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Register Entity
 *
 */
@Entity
@Table(name = "register")
public class Register {

  @Id
  private Integer id;

  @NotNull
  @Column(name = "job_date")
  private Timestamp jobDate;

  @Column(name = "enabled_students")
  private String enabledStudents;

  /**
   * @return id
   */
  public Integer getId() {

    return this.id;
  }

  /**
   * @param id new value of {@link #getId}.
   */
  public void setId(Integer id) {

    this.id = id;
  }

  /**
   * @return jobDate
   */
  public Timestamp getJobDate() {

    return this.jobDate;
  }

  /**
   * @param jobDate new value of {@link #getJobDate}.
   */
  public void setJobDate(Timestamp jobDate) {

    this.jobDate = jobDate;
  }

  /**
   * @return enabledStudents
   */
  public String getEnabledStudents() {

    return this.enabledStudents;
  }

  /**
   * @param enabledStudents new value of {@link #getEnabledStudents}.
   */
  public void setEnabledStudents(String enabledStudents) {

    this.enabledStudents = enabledStudents;
  }

}
