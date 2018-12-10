package pab.par.dom.springbatchsample.studentmanagement.dataaccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Address Entity
 *
 */
@Entity
@Table(name = "address")
public class Address {

  @Id
  private Integer id;

  private String street;

  private String number;

  @Column(name = "postal_code")
  private String postalCode;

  private String city;

  private String country;

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
   * @return street
   */
  public String getStreet() {

    return this.street;
  }

  /**
   * @param street new value of {@link #getStreet}.
   */
  public void setStreet(String street) {

    this.street = street;
  }

  /**
   * @return number
   */
  public String getNumber() {

    return this.number;
  }

  /**
   * @param number new value of {@link #getNumber}.
   */
  public void setNumber(String number) {

    this.number = number;
  }

  /**
   * @return postalCode
   */
  public String getPostalCode() {

    return this.postalCode;
  }

  /**
   * @param postalCode new value of {@link #getPostalCode}.
   */
  public void setPostalCode(String postalCode) {

    this.postalCode = postalCode;
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

  /**
   * @return country
   */
  public String getCountry() {

    return this.country;
  }

  /**
   * @param country new value of {@link #getCountry}.
   */
  public void setCountry(String country) {

    this.country = country;
  }

}
