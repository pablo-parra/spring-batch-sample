package pab.par.dom.springbatchsample.jobmanagement.dataaccess.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Batch Job Execution Params Entity
 *
 */
@Entity
@Table(name = "BATCH_JOB_EXECUTION_PARAMS")
public class BatchJobExecutionParams {

  @Id
  @Column(name = "JOB_EXECUTION_ID")
  private Long jobExecutionId;

  @Column(name = "TYPE_CD")
  @NotNull
  private String typeCD;

  @Column(name = "KEY_NAME")
  @NotNull
  private String keyName;

  @Column(name = "STRING_VAL")
  @NotNull
  private String stringVal;

  @Column(name = "DATE_VAL")
  private Timestamp dateVal;

  @Column(name = "LONG_VAL")
  private Long longVal;

  @Column(name = "DOUBLE_VAL")
  private Float doubleVal;

  @NotNull
  private char identifying;

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
   * @return typeCD
   */
  public String getTypeCD() {

    return this.typeCD;
  }

  /**
   * @param typeCD new value of {@link #getTypeCD}.
   */
  public void setTypeCD(String typeCD) {

    this.typeCD = typeCD;
  }

  /**
   * @return keyName
   */
  public String getKeyName() {

    return this.keyName;
  }

  /**
   * @param keyName new value of {@link #getKeyName}.
   */
  public void setKeyName(String keyName) {

    this.keyName = keyName;
  }

  /**
   * @return stringVal
   */
  public String getStringVal() {

    return this.stringVal;
  }

  /**
   * @param stringVal new value of {@link #getStringVal}.
   */
  public void setStringVal(String stringVal) {

    this.stringVal = stringVal;
  }

  /**
   * @return dateVal
   */
  public Timestamp getDateVal() {

    return this.dateVal;
  }

  /**
   * @param dateVal new value of {@link #getDateVal}.
   */
  public void setDateVal(Timestamp dateVal) {

    this.dateVal = dateVal;
  }

  /**
   * @return longVal
   */
  public Long getLongVal() {

    return this.longVal;
  }

  /**
   * @param longVal new value of {@link #getLongVal}.
   */
  public void setLongVal(Long longVal) {

    this.longVal = longVal;
  }

  /**
   * @return doubleVal
   */
  public Float getDoubleVal() {

    return this.doubleVal;
  }

  /**
   * @param doubleVal new value of {@link #getDoubleVal}.
   */
  public void setDoubleVal(Float doubleVal) {

    this.doubleVal = doubleVal;
  }

  /**
   * @return identifying
   */
  public char getIdentifying() {

    return this.identifying;
  }

  /**
   * @param identifying new value of {@link #getIdentifying}.
   */
  public void setIdentifying(char identifying) {

    this.identifying = identifying;
  }

}
