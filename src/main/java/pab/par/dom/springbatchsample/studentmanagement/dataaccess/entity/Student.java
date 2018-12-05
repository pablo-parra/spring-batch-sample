package pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
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

  @NotNull
  private String email;

  @NotNull
  private String name;

  @NotNull
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
   * @return email
   */
  public String getEmail() {

    return this.email;
  }

  /**
   * @param email new value of {@link #getEmail}.
   */
  public void setEmail(String email) {

    this.email = email;
  }

  /**
   * @return name
   */
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getName}.
   */
  public void setName(String name) {

    this.name = name;
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
