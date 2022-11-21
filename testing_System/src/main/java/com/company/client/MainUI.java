package com.company.client;

import com.company.server.payload.UserDTO;

import java.util.Scanner;
import java.util.UUID;

public class MainUI {
    static Scanner textScanner = new Scanner();
    static Scanner numberScanner = new Scanner();

    public static void main(String[] args) {
    while (true){
        System.out.println("1=>Exit \n 2=>Log in \n 3=>Sing Up");
        switch (numberScanner.nextInt()){
            case 0:
                return;
            case 1:
                logIn();
                break;
            case 2:
                signUp();
                break;
            default:
                System.out.println("Xato buyruq! ");
        }
    }
    }
    public static void signUp(){
        UserDTO userDTO = new UserDTO();
        System.out.print("Ismingizni kiriting: ");
        String name = textScanner.nextLine();
        System.out.print("Loginni kiriting: ");
        String login = textScanner.nextLine();
        System.out.print("Passwordni kirting: +998 ");
        String phoneNumber = textScanner.nextLine();
        if(!name.isBlank()&&!login.isBlank()&&!phoneNumber.isBlank()&&phoneNumber.length()==9){
            userDTO.setId(UUID.randomUUID());
            userDTO.setFullName(name);
            userDTO.setPhoneNumber(phoneNumber);
            cabinetMenu();
        }
        else{
            System.out.println("Fildlar xato toldirilgan! ");
        }
    }
    
    public static void logIn(){
        System.out.print("Loginni kiriting: ");
        String login = textScanner.nextLine();
        System.out.print("Passwordni kiriting: ");
        String password = textScanner.nextLine();
        if(!login.isBlank()&&!password.isBlank()){
            cabinetMenu();
        }
        else {
            System.out.println("Parol yoki ogin xato");
        }
    }

    public static void CabinetMenu(){
        while (true){
            System.out.println("0=>Exit \n 1=>Solve quiz \n 2=>Show test history \n 3=> Change password ");
            System.out.print("Choise one: ");
            switch (numberScanner.nextInt()){
                case  0:
                    return;
                case 1:
                    solveQuiz();
                    break;
                case 2:
                    showHistory();
                    break;
                case 3:
changePassword();
break;
                default:
                    System.out.println("Xato buyruq");
            }
        }
    }

}
