package com.company.server.service;

import com.company.server.database.Database;
import com.company.server.entity.User;
import com.company.server.util.Result;


import java.util.UUID;

public class UserService {
  public static Result changePassword(UUID id, String password){
      if(password==null||password.isBlank()) return new Result("Password is needed",false);
     for(User user: Database.getUsersInDatabase()){
         if(user.getId().equals(id)){
            user.setPassword(password);
         }
     }
     return new Result("Password has successfully changed",true);
  }
}
