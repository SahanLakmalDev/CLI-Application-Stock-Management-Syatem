package lk.ijse.dep11.my_app;

import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static String username = "Sahan";
    static String password = "1234";

    static String[][] supplier_array = new String[0][2];

    static String[] category_array = new String[0];

    static String[][] item_array = new String[0][6];  

    final static String COLOR_BLUE_BOLD = "\033[34;1m";
    final static String COLOR_RED_BOLD = "\033[31;1m";
    final static String COLOR_GREEN_BOLD = "\033[33;1m";
    final static String RESET = "\033[0m";
    final static String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
    final static String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);

    public static void main(String[] args) {
        loadLoginPage();

    }

    public static void loadLoginPage(){
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                                LOGIN PAGE                                 |");
        System.out.println("+---------------------------------------------------------------------------+");

        //Username Validation

        boolean valid;
        do{
            valid = true;
            System.out.print("User Name : ");
            String inputted_username = scan.nextLine();

            if(inputted_username.isBlank()){
                System.out.printf(ERROR_MSG, "Username can't be empty");
                valid = false;
                continue;
            }
            if(!inputted_username.equalsIgnoreCase(username)){
                System.out.printf(ERROR_MSG, "Invalid Username");
                valid = false;
                continue;
            }

        }while(!valid);

        //Password Validation
        do{
            valid = true;
            System.out.print("Password : ");
            String inputted_password = scan.nextLine();

            if(inputted_password.isBlank()){
                System.out.printf(ERROR_MSG, "Password can't be empty");
                valid = false;
                continue;
            }
            if(!inputted_password.equals(password)){
                System.out.printf(ERROR_MSG, "Invalid Password");
                valid = false;
                continue;
            }
        }while(!valid);

        
    }




}
