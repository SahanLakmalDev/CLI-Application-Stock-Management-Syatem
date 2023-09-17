package lk.ijse.dep11.my_app;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        int choice = 0;
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
                choice = Integer.parseInt(option);
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

        switch (choice) {
            case 1:
                changeTheCredentials();
            case 2:
                supplierManage();
            case 3:
                //stockManage();
            case 4:
                logout();
            case 5:
                exitTheSystem();
        }
    }
   
    public static void exitTheSystem(){
        clearConsole();
        System.exit(0);
    }
    public static void logout(){
        clearConsole();
        loadLoginPage();
    }
    public static void changeTheCredentials(){
        clearConsole();
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                            CREDENTIAL MANAGE                              |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        //Verifying the user

        boolean valid;
        do{
            valid = true;
            System.out.print("Please enter the username to verify it's you : ");
            String inputted_username = scan.nextLine().strip();
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

        System.out.println("Hey " + username);

        do{
            valid = true;
            System.out.print("Enter your current password : ");
            String inputted_password = scan.nextLine().strip();
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
        String new_password;
        do{
            valid = true;
            System.out.print("Enter your new password : ");
            new_password = scan.nextLine().strip();

            if(new_password.isBlank()){
                System.out.printf(ERROR_MSG, "Password can't be empty");
                valid = false;
                continue; 
            }
            if(new_password.length() < 4){
                System.out.printf(ERROR_MSG, "Invalid Password format");
                valid = false;
                continue;
            }
        }while(!valid);

        password = new_password;

        System.out.println("Password changed successfully! Do you want to go home page (Y/N) : ");
        String answer = scan.nextLine();

        if (answer.equals("y") || answer.equals("Y")) {
            dashboard();
        }
    
    }
    public static void supplierManage(){
        clearConsole();

        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                             SUPPLIER MANAGE                               |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        System.out.printf("%-48s%-48s\n", "[1] Add supplier", "[2] Update supplier");
        System.out.printf("%-48s%-48s\n", "[3] Delete supplier", "[4] View suppliers");
        System.out.printf("%-48s%-48s\n", "[5] Search supplier", "[6] Home Page");

        String option;
        int choice = 0;
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
                choice = Integer.parseInt(option);
                if(choice < 0 || choice > 6){
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

        switch (choice) {
            case 1:
                addSupplier();
            case 2:
                updateSupplier();
            case 3:
                deleteSupplier();
            case 4:
                viewSuppliers();
            case 5:
                //searchSupplier();
            case 6:
                homepage();
        }

        

    }
    public static void homepage(){
        clearConsole();
        dashboard();
    }

    public static void addSupplier(){

        clearConsole();
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                                ADD SUPPLIER                               |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        String supplier_id = idValidationAdding();
        boolean valid;
        String supplier_name;
        do{
            valid = true;
            System.out.print("Enter Supiler name : ");
            supplier_name= scan.nextLine().strip();

            if(supplier_name.isBlank()){
                System.out.printf(ERROR_MSG, "Supplier Name can't be empty");
                valid = false;
                continue;
            }

        }while(!valid);

        supplier_array = extendSupplierArray(supplier_array, supplier_id, supplier_name);

        System.out.print("Added successfully! Do you want to add another supplier (Y/N) : ");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("Y")) {
            addSupplier();
        }else{
            supplierManage();
        }




    }
    public static void updateSupplier(){

        clearConsole();

        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                              UPDATE SUPPLIER                              |");
        System.out.println("+---------------------------------------------------------------------------+\n");


    }
    public static void viewSuppliers(){

    }
    public static void deleteSupplier(){

    }

    public static String idValidationAdding(){
        boolean valid;
        String value;

        do{

            valid = true;
            System.out.print("Enter supplier ID : ");
            value = scan.nextLine().strip();

            if(value.isBlank()){
                System.out.printf(ERROR_MSG, "ID can't be empty");
                valid = false;
                continue;
            }
            Pattern pattern = Pattern.compile("S-\\d{3}");
            Matcher matcher = pattern.matcher(value);
            if(!matcher.matches()){
                System.out.printf(ERROR_MSG,"Invalid Supplier ID format");
                valid = false;
                continue;
            }
            for(int i = 0; i< supplier_array.length; i++){
                if(supplier_array[i][0].equals(value)){
                    System.out.printf(ERROR_MSG,"ID already exists");
                    valid = false;
                    break;
                }
            }
        }while(!valid);
        return value;

    }

    public static String[][] extendSupplierArray(String[][] input, String id, String name){
        String[][] temp = new String[input.length + 1][2];

        for (int i = 0; i < input.length; i++) {
            temp[i] = input[i];
        }
        temp[temp.length -1][0] = id;
        temp[temp.length -1][1] = name;
        input = temp;
        return input;
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
