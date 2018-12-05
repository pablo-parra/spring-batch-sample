package pab.par.dom.springbatchsample.studentmanagement.dataaccess.dto;

/**
 * Data Transfer Object for Student Entity
 *
 */
public class StudentDto {

  private Integer id;

  private String email;

  private String name;

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
