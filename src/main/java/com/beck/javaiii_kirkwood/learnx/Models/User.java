package com.beck.javaiii_kirkwood.learnx.Models;

import java.time.Instant;
import java.util.Arrays;

public class User {
  int ID;
  String first_name;
  String last_name;
  String email;
  String phone;
  byte[] password;
  String status;
  String privileges;
  Instant created_at;
  Instant last_logged_in;
  Instant updated_at;
  String language;

  public User(int ID, String first_name, String last_name, String email, String phone, byte[] password, String status, String privileges, Instant created_at, Instant last_logged_in, Instant updated_at, String language) {
    this.ID = ID;
    this.first_name = first_name;
    this.last_name = last_name;
    this.email = email;
    this.phone = phone;
    this.password = password;
    this.status = status;
    this.privileges = privileges;
    this.created_at = created_at;
    this.last_logged_in = last_logged_in;
    this.updated_at = updated_at;
    this.language = language;
  }

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public byte[] getPassword() {
    return password;
  }

  public void setPassword(byte[] password) {
    this.password = password;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getPrivileges() {
    return privileges;
  }

  public void setPrivileges(String privileges) {
    this.privileges = privileges;
  }

  public Instant getCreated_at() {
    return created_at;
  }

  public void setCreated_at(Instant created_at) {
    this.created_at = created_at;
  }

  public Instant getLast_logged_in() {
    return last_logged_in;
  }

  public void setLast_logged_in(Instant last_logged_in) {
    this.last_logged_in = last_logged_in;
  }

  public Instant getUpdated_at() {
    return updated_at;
  }

  public void setUpdated_at(Instant updated_at) {
    this.updated_at = updated_at;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  @Override
  public String toString() {
    return "User{" +
        "ID=" + ID +
        ", first_name='" + first_name + '\'' +
        ", last_name='" + last_name + '\'' +
        ", email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        ", password=" + Arrays.toString(password) +
        ", status='" + status + '\'' +
        ", privileges='" + privileges + '\'' +
        ", created_at=" + created_at +
        ", last_logged_in=" + last_logged_in +
        ", updated_at=" + updated_at +
        ", language='" + language + '\'' +
        '}';
  }
}
