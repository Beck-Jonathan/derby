package com.beck.javaiii_kirkwood.crrg.models;

/**
 * @ author Jonathan Beck
 * @ version 1.0
 * @ since 1.0
 */

public class Picture {
  private Integer Picture_ID;
  private Integer Album_ID;
  private Integer Contributor_ID;
  private String description;

  public Picture(){}

  public Picture(Integer Picture_ID, Integer Album_ID, Integer Contributor_ID, String description) {

    this.Picture_ID = Picture_ID;
    this.Album_ID = Album_ID;
    this.Contributor_ID = Contributor_ID;
    this.description = description;
  }
  public Integer getPicture_ID() {
    return Picture_ID;
  }
  public void setPicture_ID(Integer Picture_ID) {
    this.Picture_ID = Picture_ID;
  }
  public Integer getAlbum_ID() {
    return Album_ID;
  }
  public void setAlbum_ID(Integer Album_ID) {
    this.Album_ID = Album_ID;
  }
  public Integer getContributor_ID() {
    return Contributor_ID;
  }
  public void setContributor_ID(Integer Contributor_ID) {
    this.Contributor_ID = Contributor_ID;
  }
  public String getdescription() {
    return description;
  }
  public void setdescription(String description) {
    description = description.replaceAll("[^A-Za-z0-9 - ]","");
    if(description.length()<4){
      throw new IllegalArgumentException("description is too short.");
    }
    if(description.length()>100){
      throw new IllegalArgumentException("description is too long.");
    }
    this.description = description;
  }

}

