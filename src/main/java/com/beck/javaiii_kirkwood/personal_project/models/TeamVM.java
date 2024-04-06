package com.beck.javaiii_kirkwood.personal_project.models;

public class TeamVM extends Team{
  String League_name;
  String level;

  public TeamVM(Integer Team_ID, Integer League_ID, String Name, String Team_Primary_Color, String Team_Secondary_Color, String Team_Tertiary_Color, String Team_City, String Team_State, String Logo, boolean is_active, String league_name, String level) {
    super(Team_ID, League_ID, Name, Team_Primary_Color, Team_Secondary_Color, Team_Tertiary_Color, Team_City, Team_State, Logo, is_active);
    League_name = league_name;
    this.level = level;
  }

  public String getLeague_name() {

    return League_name;
  }

  public void setLeague_name(String league_name) {
    league_name = league_name.replaceAll("[^A-Za-z0-9 - ]","");
    if(league_name.length()<4){
      throw new IllegalArgumentException("Name is too short.");
    }
    if(league_name.length()>100){
      throw new IllegalArgumentException("Name is too long.");
    }
    this.League_name = league_name;

  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    level = level.replaceAll("[^A-Za-z0-9 - ]","");
    if(level.length()<4){
      throw new IllegalArgumentException("Name is too short.");
    }
    if(level.length()>100){
      throw new IllegalArgumentException("Name is too long.");
    }
    this.level = level;
  }
}
