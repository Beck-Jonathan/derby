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
  private String sign;
  public void setCount(int count){
    this.count=count;
  }
  public int getCount(){
    return this.count;
  }
  public void setSign (String sign) {this.sign = sign;}
  public String getSign (){return this.sign;}

  public Category_VM(String category_ID,double amount) {
    this.setCategory_ID(category_ID);
    this.amount = amount;
    this.sign="";
  }
  public Category_VM(String category_ID,double amount, String sign) {
    this.setCategory_ID(category_ID);
    this.amount = amount;
    this.sign=sign;
  }

  public Category_VM(String category_ID,double amount, int count) {
    this.setCategory_ID(category_ID);
    this.amount = amount;
    this.count=count;
  }

}
