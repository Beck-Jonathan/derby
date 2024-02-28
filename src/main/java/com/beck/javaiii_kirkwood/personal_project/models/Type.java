package com.beck.javaiii_kirkwood.personal_project.models;

public class Type {
  private Integer Type_ID;
  private String Name;

  public Type(){}

  public Type(Integer Type_ID, String Name) {

    this.Type_ID = Type_ID;
    this.Name = Name;
  }
  public Integer getType_ID() {
    return Type_ID;
  }
  public void setType_ID(Integer Type_ID) {
    this.Type_ID = Type_ID;
  }
  public String getName() {
    return Name;
  }
  public void setName(String Name) {
    if(Name.length()<4){
      throw new IllegalArgumentException("Name is too short.");
    }
    if(Name.length()>100){
      throw new IllegalArgumentException("Name is too long.");
    }
    this.Name = Name;
  }

}

