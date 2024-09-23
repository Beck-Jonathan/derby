package com.beck.javaiii_kirkwood.budget_app.iData;

import com.beck.javaiii_kirkwood.budget_app.models.Mortgage;

import java.util.List;

public interface iMortgageDAO {
   List<Mortgage> getMortgagebyUser(Integer User_ID, int limit, int offset);
}
