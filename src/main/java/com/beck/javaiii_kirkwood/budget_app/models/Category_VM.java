package com.beck.javaiii_kirkwood.budget_app.models;

public class Category_VM extends Category {
  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  private double amount;
  private int count;
  public void setCount(int count){
    this.count=count;
  }
  public int getCount(){
    return this.count;
  }

  public Category_VM(String category_ID,double amount) {
    this.setCategory_ID(category_ID);
    this.amount = amount;
  }

  public Category_VM(String category_ID,double amount, int count) {
    this.setCategory_ID(category_ID);
    this.amount = amount;
    this.count=count;
  }

}
