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
        dashboard();

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
        dashboard();

    }

    public static void dashboard(){
        clearConsole();
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                 WELCOME TO IJSE STOCK MANAGEMENT SYSTEM                   |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        System.out.printf("%-48s%-48s\n", "[1] Change the credentials", "[2] Supplier Manage");
        System.out.printf("%-48s%-48s\n", "[3] Stock Manage", "[4] Logout");
        System.out.println("[5] Exit the system ");

        String option;
        boolean valid;
        do{
            valid = true;
            System.out.print("\nEnter an Option to continue : ");
            option = scan.nextLine().strip();

            try{
                if(option.isBlank()){
                    System.out.printf(ERROR_MSG, "Option can't be empty");
                    valid = false;
                    continue; 
                }
                int choice = Integer.parseInt(option);
                if(choice < 0 || choice > 5){
                    System.out.printf(ERROR_MSG, "Invalid Option, Try again");
                    valid = false;
                    continue;
                }

            }catch (NumberFormatException nfe){
                System.out.printf(ERROR_MSG, "Please enter a number");
                valid = false;
                continue;
            }
        }while(!valid);
    }

     private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
        //handle the exception
            System.err.println(e.getMessage());
        }
    }





}
