package com.beck.javaiii_kirkwood.shared;

import com.beck.javaiii_kirkwood.learnx.Models.User;
import jakarta.servlet.http.HttpSession;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Helpers {
  public static long ageInYears(String birthDay) {
    DateTimeFormatter formatter = null;
    LocalDate birthDate = null;
    try {
      formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.US);
      birthDate = LocalDate.parse(birthDay, formatter);
    } catch(DateTimeParseException e) {
      try {
        formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.US);
        birthDate = LocalDate.parse(birthDay, formatter);
      } catch(DateTimeParseException e2) {
        return 0;
      }
    }
    return Period.between(birthDate, LocalDate.now()).getYears();
  }

  public static User getUserFromSession(HttpSession session){
    User user = (User)session.getAttribute("activeUser");
    return user;

  }

  public static Boolean isActive(User user){
    return user.getStatus().equals("active");
  }

  public static Boolean isStudent(User user){
    return user.getPrivileges().equals("student");
  }

  public static Boolean isTeacher(User user){
    return user.getPrivileges().equals("teach");
  }

  public static Boolean isAdmin(User user){
    return user.getPrivileges().equals("admin");
  }

  public static Boolean noErrors(HashMap results, List<String> potentialErrors){
    Boolean result = true;
    for (String errorMessage : potentialErrors){
      if(results.containsKey(errorMessage)){
        result=false;
        break;
      }

    }
    return result;
  }
}