package com.company.client;

import com.company.server.payload.UserDTO;
import com.company.server.service.UserService;
import com.company.server.util.Result;

import static com.company.server.util.Scanners.TEXT_SCANNER;

public class AuthUI {
    public static void login() {
        System.out.println("Enter login");
        String login = TEXT_SCANNER.nextLine();

        System.out.println("Enter password");
        String password = TEXT_SCANNER.nextLine();

        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(login);
        userDTO.setPassword(password);
//
//        Result response = UserService.login(userDTO);
//        System.out.println(response);
    }

}
