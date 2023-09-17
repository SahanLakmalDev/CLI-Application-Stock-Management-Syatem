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
    
    static int index;

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
                stockManage();
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
                searchSupplier();
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

        String supplier_id = idValdationExists();
        System.out.println("Supplier Name : " + supplier_array[index][1]);

        boolean valid;
        String newsupplier_name;
        do{
            valid = true;
            System.out.print("Enter New Supiler Name : ");
            newsupplier_name= scan.nextLine().strip();

            if(newsupplier_name.isBlank()){
                System.out.printf(ERROR_MSG, "Supplier Name can't be empty");
                valid = false;
                continue;
            }

        }while(!valid);

        supplier_array[index][1] = newsupplier_name;
        System.out.print("Updated successfully! Do you want to update another supplier (Y/N) : ");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("Y")) {
            updateSupplier();
        }else{
            supplierManage();
        }


    }
    public static void viewSuppliers(){

        clearConsole();
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                              VIEW SUPPLIERS                               |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        final String LINE = "+".concat("-".repeat(15).concat("+").concat("-".repeat(20)).concat("+"));
        System.out.println(LINE);
        System.out.printf("|%-15s|%-20s| \n", "SUPPLIER_ID", "SUPPLIER_NAME");
        System.out.println(LINE);

        for (int i = 0; i < supplier_array.length; i++) {
            System.out.printf("|%-15s|%-20s| \n", supplier_array[i][0], supplier_array[i][1]);
        }
        System.out.println(LINE);
        System.out.print("\nDo you want to go supplier manage page (Y/N) : ");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("Y")) {
            supplierManage();
        }



    }
    public static void deleteSupplier(){

        clearConsole();

        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                              DELETE SUPPLIER                              |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        String supplier_id = idValdationExists();
        supplier_array = shrinkSupplierArray(supplier_array, index);

        System.out.print("Deleted successfully! Do you want to delete another supplier (Y/N) : ");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("Y")) {
            deleteSupplier();
        }else{
            supplierManage();
        }
    }
    public static void searchSupplier(){
        clearConsole();
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                               SEARCH SUPPLIER                              |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        String supplier_id = idValdationExists();

        System.out.println("Supplier ID : " + supplier_array[index][0]);
        System.out.println("Supplier Name : " + supplier_array[index][1]);

        System.out.print("Do you want to search another supplier (Y/N) : ");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("Y")) {
            searchSupplier();
        }else{
            supplierManage();
        }
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

    public static String idValdationExists(){
        boolean valid;
        String value;

        boolean isExisted;

        do{
            valid = true;
            isExisted = false;
            System.out.print("Enter Supplier Id : ");
            value = scan.nextLine().strip();

            if(value.isBlank()){
                System.out.printf(ERROR_MSG, "ID can't be empty");
                valid = false;
                continue;
            }
            for (int i = 0; i < supplier_array.length; i++) {
                if(supplier_array[i][0].equals(value)){
                    isExisted = true;
                    index = i;
                    break;
                }
            }
            if(!isExisted){
                System.out.printf(ERROR_MSG,"ID doesn't exists");
                valid = false;
                continue;
                
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

    public static String[][] shrinkSupplierArray(String[][] input, int index){
        String[][] temp = new String[input.length -1][2];

        for (int i = 0; i < input.length; i++) {
            if(i < index){
                temp[i] = input[i];
            }else if(i == index){
                continue;
            }else{
                temp[i-1] = input[i];
            }
        }
        input = temp;
        return input;
    }


    //-------------------------- stock manage --------------------------------

    public static void stockManage(){

        clearConsole();


        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                              STOCK MANAGE                                 |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        System.out.printf("%-48s%-48s\n", "[1] Manage Item Categories", "[2] Add Item");
        System.out.printf("%-48s%-48s\n", "[3] Get Items Supplier wise", "[4] View Items");
        System.out.printf("%-48s%-48s\n", "[5] Rank Items Per Unit Price", "[6] Home Page");

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
                manageItemCategories();
            case 2:
                addItem();
            case 3:
                getItemSupplierWise();
            case 4:
                viewItems();
            case 5:
                rankItemsPerUnitPrice();
            case 6:
                homepage();
        }
    }
   
    public static void manageItemCategories(){

        clearConsole();
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                          MANAGE ITEM CATEGORY                             |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        System.out.printf("%-48s%-48s\n", "[1] Add New Item Category", "[2] Delete Item Category");
        System.out.printf("%-48s%-48s\n", "[3] Update Item Category", "[4] Stock Management");

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
                addNewItemCategory();
            case 2:
                deleteItemCategory();
            case 3:
                updateItemCategory();
            case 4:
                stockManagement();
        }

    }
    public static void stockManagement(){
        clearConsole();
        stockManage();
    }
    public static void updateItemCategory(){
        clearConsole();

        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                           UPDATE ITEM CATEGORY                            |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        String category_name = catValidationexists();
        boolean valid;
        String newCatagoryName;
        do{
            valid = true;
            System.out.print("Enter new Category name : ");
            newCatagoryName = scan.nextLine().strip();

            if(newCatagoryName.isBlank()){
                System.out.printf(ERROR_MSG, "Category can't be empty");
                valid = false;
                continue; 
            }
        }while(!valid);

        category_array[index] = newCatagoryName;

        //Update the item array
        for (int i = 0; i < item_array.length; i++) {
            if(item_array[i][4] == null){
                continue;   
            }else{
                if(item_array[i][4].equals(category_name)){
                    item_array[i][4] = newCatagoryName;
                }
            }
        }

    }

    public static void addNewItemCategory(){

        clearConsole();
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                             ADD ITEM CATEGORY                             |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        String category_name = categoryValidAdd();
        category_array = extendCategoryArray(category_array, category_name);

        System.out.print("Added successfully! Do you want to add another category (Y/N) : ");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("Y")) {
           addNewItemCategory();
        }else{
            manageItemCategories();
        }


    }

    public static String categoryValidAdd(){
        boolean valid;
        String value;

        do{
            valid = true;
            System.out.print("Enter the new Item Category : ");
            value = scan.nextLine().strip();

            if(value.isBlank()){
                System.out.printf(ERROR_MSG, "category can't be empty");
                valid = false;
                continue;
            }
            for (int i = 0; i < category_array.length; i++) {
                if(category_array[i].equals(value)){
                    System.out.printf(ERROR_MSG, "category already exists");
                    valid = false;
                    break;
                }
            }
        }while(!valid);
        return value;
    }

    public static String[] extendCategoryArray(String[] input, String value){
        String[] temp = new String[input.length + 1];
        for (int i = 0; i < input.length; i++) {
            temp[i] = input[i];
        }
        temp[temp.length -1] = value;
        input = temp;
        return input;
    }
    public static void deleteItemCategory(){

        clearConsole();

        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                           DELETE ITEM CATEGORY                            |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        String category_name = catValidationexists();
        category_array = shrinkCatArray(category_array, index);

        //Update item array
        for (int i = 0; i < item_array.length; i++) {
            if(item_array[i][4].equals(category_name)){
                item_array[i][4] = null;
            }
        }

        System.out.print("Deleted successfully! Do you want to delete another category (Y/N) : ");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("Y")) {
           deleteItemCategory();
        }else{
            supplierManage();
        }

    }

    public static String catValidationexists(){
        boolean valid;
        String value;
        boolean isExisted;

        do{
            valid = true;
            isExisted = false;
            System.out.print("Enter Item Category : ");
            value = scan.nextLine().strip();

            if(value.isBlank()){
                System.out.printf(ERROR_MSG, "category can't be empty");
                valid = false;
                continue;
            }
            for (int i = 0; i < category_array.length; i++) {
                if(category_array[i].equals(value)){
                    index = i;
                    isExisted = true;
                    valid = true;
                    break;
                }
            }
            if(!isExisted){
                System.out.printf(ERROR_MSG, "category doesn't exist");
                valid = false;
                continue;
            }

        }while(!valid);
        return value;

    }

    public static String[] shrinkCatArray(String[] input, int index){
        String[] temp = new String[input.length -1];
        for (int i = 0; i < input.length; i++) {
            if(i < index){
                temp[i] = input[i];
            }else if(i == index){
                continue;
            }else{
                temp[i-1] = input[i];
            }
        }
        input = temp;
        return input;
    }

    public static void addItem(){

        clearConsole();
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                                ADD ITEM                                   |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        //Check category list is empty or not

        boolean valid;

        do{
            valid = true;
            if(category_array.length == 0){
                System.out.println("OOPS! It seems that you don't have any item categories in the system.");
                System.out.print("Do you want to add a new item category (Y/N) : ");
                String answer = scan.nextLine().strip();
                if(answer.equalsIgnoreCase("Y")){
                    addNewItemCategory();
                }else{
                    stockManage();
                }
                
            }
        }while(!valid);

        //Check Supplier List
        do{
            valid = true;
            if(supplier_array.length == 0){
                System.out.println("OOPS! It seems that you don't have any suppliers in the system.");
                System.out.print("Do you want to add a new supplier (Y/N) : ");
                String answer = scan.nextLine().strip();
                if(answer.equalsIgnoreCase("Y")){
                    addSupplier();
                }else{
                    stockManage();
                }
            }

        }while(!valid);

        System.out.print("Item Code : ");
        String inputted_item_code = scan.nextLine().strip();

        showSupplierList();

        System.out.print("Enter the supplier number : ");
        String inputted_supplier_number = scan.nextLine().strip();

        showItemCategories();

        System.out.print("Enter the category number : ");
        String inputted_category_number = scan.nextLine().strip();

        System.out.print("\nDescription : ");
        String inputted_description = scan.nextLine().strip();

        System.out.print("Unit Price : ");
        String inputted_unit_price = scan.nextLine().strip();

        System.out.print("Qty On Hand : ");
        String inputted_qty_on_hand = scan.nextLine().strip();

        //get category name
        String item_category_name = category_array[Integer.parseInt(inputted_category_number) - 1];

        //get supplier name
        String item_supplier_id = supplier_array[Integer.parseInt(inputted_supplier_number.substring(2)) - 1][0];

        item_array = extendItemArray(item_array, inputted_item_code, inputted_description, inputted_unit_price, inputted_qty_on_hand, item_category_name, item_supplier_id);

        System.out.print("Added Item successfully! Do you want to add another item (Y/N) : ");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("Y")) {
           addItem();
        }else{
            stockManage();
        }





    }
    public static void showSupplierList(){
        System.out.println("Supplier List");
        System.out.println();
        final String LINE = "+".concat("-".repeat(15).concat("+").concat("-".repeat(20)).concat("+"));
        System.out.println(LINE);
        System.out.printf("|%-15s|%-20s| \n", "SUPPLIER_ID", "SUPPLIER_NAME");
        System.out.println(LINE);

        for (int i = 0; i < supplier_array.length; i++) {
            System.out.printf("|%-15s|%-20s| \n", supplier_array[i][0], supplier_array[i][1]);
        }
        System.out.println(LINE);
        System.out.println();
    }

    public static void showItemCategories(){
        System.out.println("Item Categories");
        System.out.println();
        final String LINE = "+".concat("-".repeat(15).concat("+").concat("-".repeat(20)).concat("+"));
        System.out.println(LINE);
        System.out.printf("|%-15s|%-20s| \n", "#", "CATEGORY_NAME");
        System.out.println(LINE);

        for (int i = 0; i < category_array.length; i++) {
            System.out.printf("|%-15s|%-20s| \n", i+1, category_array[i]);
        }
        System.out.println(LINE);
        System.out.println();
    }

    public static String[][] extendItemArray(String[][] input, String code, String des, String unit_price, String qty,
    String cat_name, String supp_id){
        String[][] temp = new String[input.length + 1][6];
        for (int i = 0; i < input.length; i++) {
            temp[i] = input[i];
        }
        temp[temp.length -1][0] = code;
        temp[temp.length -1][1] = des;
        temp[temp.length -1][2] = unit_price;
        temp[temp.length -1][3] = qty;
        temp[temp.length -1][4] = cat_name;
        temp[temp.length -1][5] = supp_id;

        input = temp;
        return input;

    }
    public static void getItemSupplierWise(){

        clearConsole();

        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                            SEARCH SUPPLIER                                |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        String supplier_id = idValdationExists();
        System.out.println(supplier_id);
        System.out.println(supplier_array[index][1]);

        final String LINE = "+".concat("-".repeat(15).concat("+").concat("-".repeat(20)).concat("+").concat("-".repeat(20).concat("+").concat("-".repeat(20).concat("+").concat("-".repeat(20).concat("+")))));
        System.out.println(LINE);
        System.out.printf("|%-15s|%-20s|%-20s|%-20s|%-20s| \n", "ITEM CODE", "DESC", "UNIT PRICE", "QTY", "CATEGORY");
        System.out.println(LINE);

        for (int i = 0; i < item_array.length; i++) {
            if(item_array[i][5].equals(supplier_id)){
                System.out.printf("|%-15s|%-20s|%-20s|%-20s|%-20s| \n", item_array[i][0], item_array[i][1],
                item_array[i][2], item_array[i][3],item_array[i][4]);
            }
        }
        System.out.println(LINE);

        System.out.print("Do you want to search another supplier (Y/N) : ");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("Y")) {
           getItemSupplierWise();
        }else{
            stockManage();
        }




    }
    public static void viewItems(){

        clearConsole();
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                               VIEW ITEMS                                  |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        for (int i = 0; i < category_array.length; i++) {
            System.out.println(category_array[i] + " : ");

            System.out.println();

            final String LINE = "+".concat("-".repeat(15).concat("+").concat("-".repeat(20)).concat("+").concat("-".repeat(20).concat("+").concat("-".repeat(20).concat("+").concat("-".repeat(20).concat("+")))));
            System.out.println(LINE);
            System.out.printf("|%-15s|%-20s|%-20s|%-20s|%-20s| \n", "SID", "CODE", "DESC", "PRICE", "QTY");
            System.out.println(LINE);

            for (int j = 0; j < item_array.length; j++) {
                if(category_array[i].equals(item_array[j][4])){
                    System.out.printf("|%-15s|%-20s|%-20s|%-20s|%-20s| \n", item_array[j][5], item_array[j][1],
                    item_array[j][2], item_array[j][2], item_array[j][3]);
                }
            }
            System.out.println(LINE);
        }
        System.out.print("Do you want to go stock manage page (Y/N) : ");
        String option = scan.nextLine();

        if (option.equals("y") || option.equals("Y")) {
            stockManagement();
        }

        


    }
    public static void rankItemsPerUnitPrice(){
        clearConsole();
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                            RANKED UNIT PRICE                              |");
        System.out.println("+---------------------------------------------------------------------------+\n");


        //Sort the item array - Bubble sort
        for (int i = item_array.length - 1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if((Double.parseDouble(item_array[j][2]) > (Double.parseDouble(item_array[j+1][2])))){
                    String[] temp = item_array[j];
                    item_array[j] = item_array[j+1];
                    item_array[j+1]=temp;
                }
            }
        }
        
        final String LINE = "+".concat("-".repeat(15).concat("+").concat("-".repeat(20)).concat("+").concat("-".repeat(20).concat("+").concat("-".repeat(20).concat("+").concat("-".repeat(20).concat("+").concat("-".repeat(20).concat("+"))))));
        System.out.println(LINE);
        System.out.printf("|%-15s|%-20s|%-20s|%-20s|%-20s|%-20s| \n", "SID", "CODE", "DESC", "PRICE", "QTY", "CAT");
        System.out.println(LINE);

        for (int i = 0; i < item_array.length; i++) {
            System.out.printf("|%-15s|%-20s|%-20s|%-20s|%-20s|%-20s| \n", item_array[i][5], item_array[i][0],
            item_array[i][1], item_array[i][2], item_array[i][3], item_array[i][4]);
        }
        System.out.println(LINE);

        System.out.print("Do you want to go stock manage page (Y/N) : ");
        String option = scan.nextLine();

        if (option.equals("y") || option.equals("Y")) {
            stockManagement();
        }


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
