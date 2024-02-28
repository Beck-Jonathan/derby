package com.beck.javaiii_kirkwood.personal_project.models;

public class User {
  private Integer User_ID;
  private String User_Name;
  private String User_PW;
  private String Status;
  private String Email;
  private String privileges;

  public User(){}

  public User(Integer User_ID, String User_Name, String User_PW, String Status, String Email, String privileges) {

    this.User_ID = User_ID;
    this.User_Name = User_Name;
    this.User_PW = User_PW;
    this.Status = Status;
    this.Email = Email;
    this.privileges = privileges;
  }
  public Integer getUser_ID() {
    return User_ID;
  }
  public void setUser_ID(Integer User_ID) {
    this.User_ID = User_ID;
  }
  public String getUser_Name() {
    return User_Name;
  }
  public void setUser_Name(String User_Name) {
    if(User_Name.length()<4){
      throw new IllegalArgumentException("User_Name is too short.");
    }
    if(User_Name.length()>100){
      throw new IllegalArgumentException("User_Name is too long.");
    }
    this.User_Name = User_Name;
  }
  public String getUser_PW() {
    return User_PW;
  }
  public void setUser_PW(String User_PW) {
    if(User_PW.length()<4){
      throw new IllegalArgumentException("User_PW is too short.");
    }
    if(User_PW.length()>100){
      throw new IllegalArgumentException("User_PW is too long.");
    }
    this.User_PW = User_PW;
  }
  public String getStatus() {
    return Status;
  }
  public void setStatus(String Status) {
    if(Status.length()<4){
      throw new IllegalArgumentException("Status is too short.");
    }
    if(Status.length()>100){
      throw new IllegalArgumentException("Status is too long.");
    }
    this.Status = Status;
  }
  public String getEmail() {
    return Email;
  }
  public void setEmail(String Email) {
    if(Email.length()<4){
      throw new IllegalArgumentException("Email is too short.");
    }
    if(Email.length()>100){
      throw new IllegalArgumentException("Email is too long.");
    }
    this.Email = Email;
  }
  public String getprivileges() {
    return privileges;
  }
  public void setprivileges(String privileges) {
    if(privileges.length()<4){
      throw new IllegalArgumentException("privileges is too short.");
    }
    if(privileges.length()>100){
      throw new IllegalArgumentException("privileges is too long.");
    }
    this.privileges = privileges;
  }

}
