package pab.par.dom.springbatchsample.service.data.dto;

/**
 * Class to wrap the response info
 *
 */
public class DownloadInfoDto {

  private String downloadURL;

  private String ETA;

  /**
   *
   * The constructor.
   */
  public DownloadInfoDto() {

  }

  /**
   * The constructor.
   *
   * @param downloadURL the downloadURL value
   * @param ETA the ETA value
   */
  public DownloadInfoDto(String downloadURL, String ETA) {

    this.downloadURL = downloadURL;
    this.ETA = ETA;
  }

  /**
   * @return downloadURL
   */
  public String getDownloadURL() {

    return this.downloadURL;
  }

  /**
   * @param downloadURL new value of {@link #getDownloadURL}.
   */
  public void setDownloadURL(String downloadURL) {

    this.downloadURL = downloadURL;
  }

  /**
   * @return eTA
   */
  public String getETA() {

    return this.ETA;
  }

  /**
   * @param eTA new value of {@link #getETA}.
   */
  public void setETA(String eTA) {

    this.ETA = eTA;
  }

}
