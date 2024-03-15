package com.beck.javaiii_kirkwood.personal_project.models;

public class Team {
  private Integer Team_ID;
  private Integer League_ID;
  private String Team_Name;
  private String Team_Primary_Color;
  private String Team_City;
  private String Team_State;
  private String Logo;
  private boolean is_active;

  public Team(){}

  public Team(Integer Team_ID, Integer League_ID, String Team_Name, String Team_Primary_Color, String Team_City, String Team_State, String Logo, boolean is_active) {

    this.Team_ID = Team_ID;
    this.League_ID = League_ID;
    this.Team_Name = Team_Name;
    this.Team_Primary_Color = Team_Primary_Color;
    this.Team_City = Team_City;
    this.Team_State = Team_State;
    this.Logo = Logo;
    this.is_active = is_active;
  }
  public Integer getTeam_ID() {
    return Team_ID;
  }
  public void setTeam_ID(Integer Team_ID) {
    this.Team_ID = Team_ID;
  }
  public Integer getLeague_ID() {
    return League_ID;
  }
  public void setLeague_ID(Integer League_ID) {
    this.League_ID = League_ID;
  }
  public String getTeam_Name() {
    return Team_Name;
  }
  public void setTeam_Name(String Team_Name) {
    if(Team_Name.length()<4){
      throw new IllegalArgumentException("Team_Name is too short.");
    }
    if(Team_Name.length()>100){
      throw new IllegalArgumentException("Team_Name is too long.");
    }
    this.Team_Name = Team_Name;
  }
  public String getTeam_Primary_Color() {
    return Team_Primary_Color;
  }
  public void setTeam_Primary_Color(String Team_Primary_Color) {
    if(Team_Primary_Color.length()<4){
      throw new IllegalArgumentException("Team_Primary_Color is too short.");
    }
    if(Team_Primary_Color.length()>6){
      throw new IllegalArgumentException("Team_Primary_Color is too long.");
    }
    this.Team_Primary_Color = Team_Primary_Color;
  }
  public String getTeam_City() {
    return Team_City;
  }
  public void setTeam_City(String Team_City) {
    if(Team_City.length()<4){
      throw new IllegalArgumentException("Team_City is too short.");
    }
    if(Team_City.length()>100){
      throw new IllegalArgumentException("Team_City is too long.");
    }
    this.Team_City = Team_City;
  }
  public String getTeam_State() {
    return Team_State;
  }
  public void setTeam_State(String Team_State) {
    if(Team_State.length()<4){
      throw new IllegalArgumentException("Team_State is too short.");
    }
    if(Team_State.length()>100){
      throw new IllegalArgumentException("Team_State is too long.");
    }
    this.Team_State = Team_State;
  }
  public String getLogo() {
    return Logo;
  }
  public void setLogo(String Logo) {
    if(Logo.length()<4){
      throw new IllegalArgumentException("Logo is too short.");
    }
    if(Logo.length()>100){
      throw new IllegalArgumentException("Logo is too long.");
    }
    this.Logo = Logo;
  }
  public boolean getis_active() {
    return is_active;
  }
  public void setis_active(boolean is_active) {
    this.is_active = is_active;
  }

}

