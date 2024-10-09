package com.beck.javaiii_kirkwood.crrg.models;

/**
 * @ author Jonathan Beck
 * @ version 1.0
 * @ since 1.0
 */

public class Album {
  private Integer Album_ID;
  private String Album_Name;

  public Album(){}

  public Album(Integer Album_ID, String Album_Name) {

    this.Album_ID = Album_ID;
    this.Album_Name = Album_Name;
  }
  public Integer getAlbum_ID() {
    return Album_ID;
  }
  public void setAlbum_ID(Integer Album_ID) {
    this.Album_ID = Album_ID;
  }
  public String getAlbum_Name() {
    return Album_Name;
  }
  public void setAlbum_Name(String Album_Name) {
    Album_Name = Album_Name.replaceAll("[^A-Za-z0-9 - ]","");
    if(Album_Name.length()<4){
      throw new IllegalArgumentException("Album_Name is too short.");
    }
    if(Album_Name.length()>100){
      throw new IllegalArgumentException("Album_Name is too long.");
    }
    this.Album_Name = Album_Name;
  }

}

