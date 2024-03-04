package com.beck.javaiii_kirkwood.personal_project.models;

/// <summary>
///AUTHOR: Jonathan Beck
///<br />
///CREATED: 3/3/2024
///< br />
///An example class to show how code is expected to be written and documented.
///This is where a description of what your file is supposed to contain goes.
///e.g., "Class with helper methods for input validation.",
///Class that defines Language Objects.
///</summary>
///< remarks>
///UPDATER: updater_name
///< br />
/// UPDATED: yyyy-MM-dd
/// < br />
/// Update comments go here, include method or methods were changed or added
/// A new remark should be added for each update.
///</remarks>

public class Language {
  private Integer Language_ID;
  private String Name;

  public Language(){}

  public Language(Integer Language_ID, String Name) {

    this.Language_ID = Language_ID;
    this.Name = Name;
  }
  public Integer getLanguage_ID() {
    return Language_ID;
  }
  public void setLanguage_ID(Integer Language_ID) {
    this.Language_ID = Language_ID;
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

