package com.beck.javaiii_kirkwood.personal_project.models;

/// <summary>
///AUTHOR: Jonathan Beck
///<br />
///CREATED: 3/3/2024
///< br />
///An example class to show how code is expected to be written and documented.
///This is where a description of what your file is supposed to contain goes.
///e.g., "Class with helper methods for input validation.",
///Class that defines Status Objects.
///</summary>
///< remarks>
///UPDATER: updater_name
///< br />
/// UPDATED: yyyy-MM-dd
/// < br />
/// Update comments go here, include method or methods were changed or added
/// A new remark should be added for each update.
///</remarks>

public class Status {
  private Integer Status_ID;
  private String Name;

  public Status(){}

  public Status(Integer Status_ID, String Name) {

    this.Status_ID = Status_ID;
    this.Name = Name;
  }
  public Integer getStatus_ID() {
    return Status_ID;
  }
  public void setStatus_ID(Integer Status_ID) {
    this.Status_ID = Status_ID;
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

