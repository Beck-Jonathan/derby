package com.beck.javaiii_kirkwood.budget_app.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;

@RestController
public class Error_Controller implements ErrorController {

  private static final String PATH = "/error";

  @RequestMapping(value = PATH)
  public String error() {
    return "Error handling";
  }


  public String getErrorPath() {
    return PATH;
  }
}