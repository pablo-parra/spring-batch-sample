package pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * Contact Entity
 *
 */
@Entity
@Table(name = "contact")
public class Contact {

  @Id
  private Integer id;

  @NotNull
  private String phone;

  @Email
  @NotNull
  private String email;

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
   * @return phone
   */
  public String getPhone() {

    return this.phone;
  }

  /**
   * @param phone new value of {@link #getPhone}.
   */
  public void setPhone(String phone) {

    this.phone = phone;
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

}
