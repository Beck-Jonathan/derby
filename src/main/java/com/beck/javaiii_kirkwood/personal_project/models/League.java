package com.beck.javaiii_kirkwood.personal_project.models;

public class League {
  private Integer League_ID;
  private String League_Name;
  private String League_Level;
  private boolean is_active;

  public League(){}

  public League(Integer League_ID, String League_Name, String League_Level, boolean is_active) {

    this.League_ID = League_ID;
    this.League_Name = League_Name;
    this.League_Level = League_Level;
    this.is_active = is_active;
  }
  public Integer getLeague_ID() {
    return League_ID;
  }
  public void setLeague_ID(Integer League_ID) {
    this.League_ID = League_ID;
  }
  public String getLeague_Name() {
    return League_Name;
  }
  public void setLeague_Name(String League_Name) {
    if(League_Name.length()<4){
      throw new IllegalArgumentException("League_Name is too short.");
    }
    if(League_Name.length()>100){
      throw new IllegalArgumentException("League_Name is too long.");
    }
    this.League_Name = League_Name;
  }
  public String getLeague_Level() {
    return League_Level;
  }
  public void setLeague_Level(String League_Level) {
    if(League_Level.length()<4){
      throw new IllegalArgumentException("League_Level is too short.");
    }
    if(League_Level.length()>100){
      throw new IllegalArgumentException("League_Level is too long.");
    }
    this.League_Level = League_Level;
  }
  public boolean getis_active() {
    return is_active;
  }
  public void setis_active(boolean is_active) {
    this.is_active = is_active;
  }

}

