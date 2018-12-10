package pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * Enabled Student Entity
 *
 */
@Entity
@Table(name = "enabled_student")
public class EnabledStudent {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotNull
  private String name;

  @NotNull
  private String degree;

  @Email
  private String email;

  @NotNull
  private String phone;

  @NotNull
  private String city;

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
   * @return city
   */
  public String getCity() {

    return this.city;
  }

  /**
   * @param city new value of {@link #getCity}.
   */
  public void setCity(String city) {

    this.city = city;
  }

}
