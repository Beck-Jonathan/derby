package com.beck.javaiii_kirkwood.crrg.models;

/**
 * @ author Jonathan Beck
 * @ version 1.0
 * @ since 1.0
 */

public class User {
  private String User_ID;
  private String first_name;
  private String last_name;
  private String email;
  private String phone;
  private String password;

  public User(){}

  public User(String User_ID, String first_name, String last_name, String email, String phone, String password) {

    this.User_ID = User_ID;
    this.first_name = first_name;
    this.last_name = last_name;
    this.email = email;
    this.phone = phone;
    this.password = password;
  }
  public String getUser_ID() {
    return User_ID;
  }
  public void setUser_ID(String User_ID) {
    User_ID = User_ID.replaceAll("[^A-Za-z0-9 - ]","");
    if(User_ID.length()<4){
      throw new IllegalArgumentException("User_ID is too short.");
    }
    if(User_ID.length()>100){
      throw new IllegalArgumentException("User_ID is too long.");
    }
    this.User_ID = User_ID;
  }
  public String getfirst_name() {
    return first_name;
  }
  public void setfirst_name(String first_name) {
    first_name = first_name.replaceAll("[^A-Za-z0-9 - ]","");
    if(first_name.length()<4){
      throw new IllegalArgumentException("first_name is too short.");
    }
    if(first_name.length()>100){
      throw new IllegalArgumentException("first_name is too long.");
    }
    this.first_name = first_name;
  }
  public String getlast_name() {
    return last_name;
  }
  public void setlast_name(String last_name) {
    last_name = last_name.replaceAll("[^A-Za-z0-9 - ]","");
    if(last_name.length()<4){
      throw new IllegalArgumentException("last_name is too short.");
    }
    if(last_name.length()>100){
      throw new IllegalArgumentException("last_name is too long.");
    }
    this.last_name = last_name;
  }
  public String getemail() {
    return email;
  }
  public void setemail(String email) {
    email = email.replaceAll("[^A-Za-z0-9 - ]","");
    if(email.length()<4){
      throw new IllegalArgumentException("email is too short.");
    }
    if(email.length()>100){
      throw new IllegalArgumentException("email is too long.");
    }
    this.email = email;
  }
  public String getphone() {
    return phone;
  }
  public void setphone(String phone) {
    phone = phone.replaceAll("[^A-Za-z0-9 - ]","");
    if(phone.length()<4){
      throw new IllegalArgumentException("phone is too short.");
    }
    if(phone.length()>13){
      throw new IllegalArgumentException("phone is too long.");
    }
    this.phone = phone;
  }
  public String getpassword() {
    return password;
  }
  public void setpassword(String password) {
    password = password.replaceAll("[^A-Za-z0-9 - ]","");
    if(password.length()<4){
      throw new IllegalArgumentException("password is too short.");
    }
    if(password.length()>255){
      throw new IllegalArgumentException("password is too long.");
    }
    this.password = password;
  }

}

