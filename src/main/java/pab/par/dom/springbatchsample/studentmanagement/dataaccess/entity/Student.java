package pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entity to map 'student' table
 *
 */
@Entity
@Table(name = "student")
public class Student {

  @Id
  private Integer id;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "person_id")
  private PersonalInfo person;

  @NotNull
  private String degree;

  private Boolean enabled;

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
   * @return person
   */
  public PersonalInfo getPerson() {

    return this.person;
  }

  /**
   * @param person new value of {@link #getPerson}.
   */
  public void setPerson(PersonalInfo person) {

    this.person = person;
  }

  /**
   * @return degree
   */
  public String getDegree() {

    return this.degree;
  }

  /**
   * @param degree new value of {@link #getDegree}.
   */
  public void setDegree(String degree) {

    this.degree = degree;
  }

  /**
   * @return enabled
   */
  public Boolean getEnabled() {

    return this.enabled;
  }

  /**
   * @param enabled new value of {@link #getEnabled}.
   */
  public void setEnabled(Boolean enabled) {

    this.enabled = enabled;
  }

}
