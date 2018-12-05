package pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Enabled Student Entity
 *
 */
@Entity
@Table(name = "enabled_student")
public class EnabledStudent {

  @Id
  private String email;

  @NotNull
  private String name;

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

}
