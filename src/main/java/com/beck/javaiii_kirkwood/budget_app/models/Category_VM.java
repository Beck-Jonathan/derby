package com.beck.javaiii_kirkwood.budget_app.models;

public class Category_VM extends Category {
  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public double amount;

  public Category_VM(String category_ID,double amount) {
    this.setCategory_ID(category_ID);
    this.amount = amount;
  }

}
