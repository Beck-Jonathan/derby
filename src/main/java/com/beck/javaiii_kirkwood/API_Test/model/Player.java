package com.beck.javaiii_kirkwood.API_Test.model;

public class Player {
  public Player(String firstName, String lastName, Integer currentAge, String height, Integer weight, String position, String batSide, String throwSide) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.currentAge = currentAge;
    this.height = height;
    this.weight = weight;
    this.position = position;
    this.batSide = batSide;
    this.throwSide = throwSide;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  private String firstName;
  private  String lastName;
  private Integer currentAge;
  private String height;
  private Integer weight;
  private String position;
  private String batSide;
  private String throwSide;

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Integer getCurrentAge() {
    return currentAge;
  }

  public void setCurrentAge(Integer currentAge) {
    this.currentAge = currentAge;
  }

  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getBatSide() {
    return batSide;
  }

  public void setBatSide(String batSide) {
    this.batSide = batSide;
  }

  public String getThrowSide() {
    return throwSide;
  }

  public void setThrowSide(String throwSide) {
    this.throwSide = throwSide;
  }
}
