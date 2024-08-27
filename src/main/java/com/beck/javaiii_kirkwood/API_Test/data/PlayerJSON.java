package com.beck.javaiii_kirkwood.API_Test.data;

import com.beck.javaiii_kirkwood.API_Test.model.Player;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


import org.json.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

public class PlayerJSON {
  public static List<Player> getAll(){
    UriBuilder uriBuilder = UriComponentsBuilder.fromUriString("https://apicalls.io/api/v1/mlb/players");
    //uriBuilder.queryParam("personIds","676265");
    URI uri = uriBuilder.build();
    List<Player> players = new ArrayList<>();

    HttpRequest request = HttpRequest.newBuilder()
        .uri(uri)
        .header("Authorization", "Bearer 690|09QdrZWy7UZTqTPPduRlLUAU8BrhPlXEDQ4u4upd")

        .method("GET", HttpRequest.BodyPublishers.noBody())
        .build();
    HttpResponse<String> response = null;
    try {
      response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    String jsonString = response.body().toString() ; //assign your JSON String here
    JSONObject obj = new JSONObject(jsonString);
   // String pageName = obj.getJSONObject("pageInfo").getString("pageName");

    JSONArray arr = obj.getJSONArray("body"); // notice that `"posts": [...]`
    try {
      for (int i = 0; i < arr.length(); i++) {
        String firstName = arr.getJSONObject(i).getString("firstName");

        String lastName = arr.getJSONObject(i).getString("lastName");
        Integer currentAge = arr.getJSONObject(i).getInt("currentAge");
        String height = arr.getJSONObject(i).getString("height");
        Integer weight = arr.getJSONObject(i).getInt("weight");

        JSONObject positionOBJ = arr.getJSONObject(i).getJSONObject("primaryPosition");
        String position = positionOBJ.getString("name");
        JSONObject batSideObj = arr.getJSONObject(i).getJSONObject("batSide");
        String batSide = batSideObj.getString("description");
        JSONObject throwObj = arr.getJSONObject(i).getJSONObject("pitchHand");
        String throwSide = throwObj.getString("description");
        Player player = new Player(firstName, lastName, currentAge, height, weight, position, batSide, throwSide);
        players.add(player);
      }
    } catch (Exception e){
      System.out.println(e.getMessage());
    }


    return players;
  }
  public static List<Player> getPlayerByID(int id){
    UriBuilder uriBuilder = UriComponentsBuilder.fromUriString("https://apicalls.io/api/v1/mlb/players");
    uriBuilder.queryParam("personIds",id);
    URI uri = uriBuilder.build();
    List<Player> players = new ArrayList<>();

    HttpRequest request = HttpRequest.newBuilder()
        .uri(uri)
        .header("Authorization", "Bearer 690|09QdrZWy7UZTqTPPduRlLUAU8BrhPlXEDQ4u4upd")

        .method("GET", HttpRequest.BodyPublishers.noBody())
        .build();
    HttpResponse<String> response = null;
    try {
      response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    } catch (InterruptedException e) {
      throw new RuntimeException(e.getMessage());
    }
    String jsonString = response.body().toString() ; //assign your JSON String here
    JSONObject obj = new JSONObject(jsonString);
    // String pageName = obj.getJSONObject("pageInfo").getString("pageName");

    JSONArray arr = obj.getJSONArray("body"); // notice that `"posts": [...]`
    try {
      for (int i = 0; i < arr.length(); i++) {
        String firstName = arr.getJSONObject(i).getString("firstName");

        String lastName = arr.getJSONObject(i).getString("lastName");
        Integer currentAge = arr.getJSONObject(i).getInt("currentAge");
        String height = arr.getJSONObject(i).getString("height");
        Integer weight = arr.getJSONObject(i).getInt("weight");

        JSONObject positionOBJ = arr.getJSONObject(i).getJSONObject("primaryPosition");
        String position = positionOBJ.getString("name");
        JSONObject batSideObj = arr.getJSONObject(i).getJSONObject("batSide");
        String batSide = batSideObj.getString("description");
        JSONObject throwObj = arr.getJSONObject(i).getJSONObject("pitchHand");
        String throwSide = throwObj.getString("description");
        Player player = new Player(firstName, lastName, currentAge, height, weight, position, batSide, throwSide);
        players.add(player);
      }
    } catch (Exception e){
      throw new RuntimeException("Player not found");
    }


    return players;
  }


}
