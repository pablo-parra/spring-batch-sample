package pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * PersonalInfo Entity
 *
 */
@Entity
@Table(name = "personal_info")
public class PersonalInfo {

  @Id
  private Integer id;

  private String firstName;

  private String lastName;

  @Column(name = "birth_date")
  private Date birthDate;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "address_id")
  private Address address;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "contact_id")
  private Contact contact;

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
   * @return firstName
   */
  public String getFirstName() {

    return this.firstName;
  }

  /**
   * @param firstName new value of {@link #getFirstName}.
   */
  public void setFirstName(String firstName) {

    this.firstName = firstName;
  }

  /**
   * @return lastName
   */
  public String getLastName() {

    return this.lastName;
  }

  /**
   * @param lastName new value of {@link #getLastName}.
   */
  public void setLastName(String lastName) {

    this.lastName = lastName;
  }

  /**
   * @return birthDate
   */
  public Date getBirthDate() {

    return this.birthDate;
  }

  /**
   * @param birthDate new value of {@link #getBirthDate}.
   */
  public void setBirthDate(Date birthDate) {

    this.birthDate = birthDate;
  }

  /**
   * @return address
   */
  public Address getAddress() {

    return this.address;
  }

  /**
   * @param address new value of {@link #getAddress}.
   */
  public void setAddress(Address address) {

    this.address = address;
  }

  /**
   * @return contact
   */
  public Contact getContact() {

    return this.contact;
  }

  /**
   * @param contact new value of {@link #getContact}.
   */
  public void setContact(Contact contact) {

    this.contact = contact;
  }

}
