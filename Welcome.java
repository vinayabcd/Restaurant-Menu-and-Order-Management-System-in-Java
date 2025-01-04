package pack1;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Welcome {

    // menu itemname and price
    private static final LinkedHashMap<String, Integer> menu = new LinkedHashMap<>();
    // taking the input from user itemnames and quantity
    private static final LinkedHashMap<String, Integer> orders = new LinkedHashMap<>();
    // input from the user 
    private static final Scanner sc = new Scanner(System.in);

    static {
        initializeMenu();
    }

    //items and prices
    private static void initializeMenu() {
        addMenuItems("Chicken_Biryani", 300, "Mutton_Biryani", 700, "Beef_Biryani", 600,
                "Vegetable_Biryani", 200, "Fish_Biryani", 600, "Egg_Biryani", 300, 
                "Prawn/Seafood_Biryani", 700, "Kashmiri_Biryani", 500, "Hyderabadi_Biryani", 500,
                "Lucknowi_Biryani", 700, "Chicken_Mandi", 400, "Mutton_Mandi", 700, "Beef_Mandi", 500,
                "Fish_Mandi", 200, "Vegetable_Mandi", 400, "Shrimp_Mandi", 300, "Spicy_Mandi", 700,
                "Mixed_Mandi", 1000, "Margherita_Pizza", 300, "Pepperoni_Pizza", 400, "Veggie_Pizza", 300,
                "BBQ_Chicken_Pizza", 400, "Paneer_Tikka_Pizza", 350, "Hawaiian_Pizza(Ham_and_Pineapple)", 450,
                "MeatLovers_Pizza", 600, "FourCheese_Pizza", 500, "Seafood_Pizza", 600, "StuffedCrust_Pizza", 500,
                "Chicken_Shawarma", 150, "Beef_Shawarma", 200, "Mutton_Shawarma", 250, "Falafel_Shawarma(Veg)", 200,
                "Mixed_Shawarma", 250, "Shawarma_Platter", 300, "Shawarma_Roll", 200, "SpicyChicken_Shawarma", 200,
                "Chocolate_Cake", 400, "Vanilla_Cake", 350, "RedVelvet_Cake", 500, "Fruit_Cake", 400,
                "BlackForest_Cake", 450, "Cheese_cake", 600, "Carrot_Cake", 400, "Pineapple_Cake", 350,
                "Lemon_Cake", 400, "Eggless_Cake", 400, "Vanilla_IceCream", 50, "Chocolate_IceCream", 60,
                "Strawberry_IceCream", 50, "Butterscotch_IceCream", 60, "MintChocolate_Chip", 60,
                "Mango_Ice_Cream", 70, "CookieDough_IceCream", 100, "Pistachio_IceCream", 70,
                "FruitSalad_IceCream", 80, "SoftServe_IceCream", 50, "Idli", 50, "Dosa", 80, "Vada", 50,
                "Sambar Rice", 100, "Pongal", 80, "Rasam Rice", 100, "Upma", 60, "Puttu", 70, "Kari Dosa", 120,
                "Veg_Roll", 100, "Chicken_Roll", 150, "Mutton_Roll", 200, "Egg_Roll", 120, "Paneer_Roll", 150,
                "Spicy_Roll", 150, "Chicken_Kabab", 200, "Mutton_Kabab", 250, "Beef_Kabab", 300, "Seekh_Kabab", 250,
                "Paneer_Kabab", 200, "Fish_Kabab", 300, "Chocolate_Pastry", 150, "Strawberry_Pastry", 150,
                "Vanilla_Pastry", 120, "BlackForest_Pastry", 180, "Fruit_Pastry", 150, "Greek_Salad", 100,
                "Caesar_Salad", 120, "Fruit_Salad", 80, "Pasta_Salad", 120, "Coleslaw_Salad", 70);
    }

    private static void addMenuItems(Object... itemsAndPrices) {
        for (int i = 0; i < itemsAndPrices.length; i += 2) {
            menu.put((String) itemsAndPrices[i], (Integer) itemsAndPrices[i + 1]);
        }
    }

    public void login(String name) {
        System.out.println("\n\n********Dear " + name + ", Welcome to our Hotel**********");
    }

    public void printMenu() {
        System.out.println("\nAvailable Menu:");
        for (Map.Entry<String, Integer> entry : menu.entrySet()) {
            System.out.println("Item: " + entry.getKey() + ", Price: ₹" + entry.getValue());
        }
    }

    public static void printDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Date and Time: " + now.format(formatter));
         
    }

    public static void displayBillHeader() {
    	 System.out.println("\nItems Ordered:");
        System.out.println("-------------------------------------------------------------------");
        System.out.print("\nS.NO \tItem Name\t\t Quantity \t\t  TotalPrice\n");
        System.out.println("-------------------------------------------------------------------");
    }

    public void checkout() {
        int totalAmount = 0;
        int Sn=1;
       
        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();
            
            // Ensure item exists in the menu
            if (menu.containsKey(itemName)) {
                int pricePerItem = menu.get(itemName);
                int totalPrice = pricePerItem * quantity;
                totalAmount += totalPrice;

                
				// Print the item details
                System.out.println(Sn+"     " + itemName + "                  " + quantity +
                        "                      ₹" + (pricePerItem*quantity) );
                
            } 
            else {
                System.out.println("Error: Item '" + itemName + "' is not on the menu.");
            }
            Sn++;
        }
        System.out.println("\nTotal Amount +" + " gst: ₹" + totalAmount+" + "+(totalAmount*0.2) +"                     ");
        double totalAmount1 = totalAmount+(totalAmount*0.02);
        System.out.println("Total Amount:"+totalAmount1);
        System.out.println("-------------------------------------------------------------------");
        System.out.print("       ************THANK YOU FOR VISITING********************** \n");
        System.out.println("-------------------------------------------------------------------");
    
        welcomebanner();
       
    }

    public void welcomebanner() {
    	System.out.println("\\        //    [][][][]   [][][][]      //\\      ||\\    ||  [][][])))"); 
        System.out.println(" \\      //     []         []    []     //  \\     || \\   ||  []       ))");
        System.out.println("  \\    //      >>>>>>> NOT JUST AN ANOTHER HOTEL<<<<  \\  ||  []        ))");
        System.out.println("   \\  //       []    []   []   \\    //      \\   ||   \\ ||  []       ))");
        System.out.println("    \\//        [][][][]   []    \\  //        \\  ||    \\||  [][][])))"); 
    }
    public void printBill() {
        printDateTime();
        displayBillHeader();
        checkout();
    }

    public void order() {
        System.out.println("Please enter your order:");
        String itemName = sc.nextLine();
        System.out.println("Please mention quantity:");
        int quantity = sc.nextInt();
        sc.nextLine(); // Consume newline character

        // check the item and add to orders(name,quantity)
        if (menu.containsKey(itemName)) {
            orders.put(itemName, quantity);
            System.out.println("Item added to your order.");
        } else {
            System.out.println("Error: Item not found in the menu. Please try again.");
            order();
            return; 
        }

        System.out.println("Want more of these items? Press 1 / Want more other items? Press 2 / Press 0 to quit");
        int choice = sc.nextInt();
        sc.nextLine(); 

        switch (choice) {
            case 1:
                order();
                break;
            case 2:
                choose();
                break;
            case 0:
                System.out.println("Thank you for your order!\n\n");
                printBill();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                order();
                break;
        }
    }

    public void choose() {
        System.out.println("\nAvailable categories:");
        System.out.println("1. Biryanies\n2. Mandi\n3. Pizza\n4. Cakes\n5. Ice Cream\n6. Rolls\n7. Kababs\n8. Pastries\n9. Salads\n10.tifins");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); 

        switch (choice) {
            case 1:
                displayItems("Biryanies", "Chicken_Biryani", "Mutton_Biryani", "Beef_Biryani", 
                        "Vegetable_Biryani", "Fish_Biryani", "Egg_Biryani", "Prawn/Seafood_Biryani",
                        "Kashmiri_Biryani", "Hyderabadi_Biryani", "Lucknowi_Biryani");
                break;
            case 2:
                displayItems("Mandies", "Chicken_Mandi", "Mutton_Mandi", "Beef_Mandi",
                        "Fish_Mandi", "Vegetable_Mandi", "Shrimp_Mandi", "Spicy_Mandi", "Mixed_Mandi");
                break;
            case 3:
                displayItems("Pizzas", "Margherita_Pizza", "Pepperoni_Pizza", "Veggie_Pizza",
                        "BBQ_Chicken_Pizza", "Paneer_Tikka_Pizza", "Hawaiian_Pizza(Ham_and_Pineapple)",
                        "MeatLovers_Pizza", "FourCheese_Pizza", "Seafood_Pizza", "StuffedCrust_Pizza");
                break;
            case 4:
                displayItems("Cakes", "Chocolate_Cake", "Vanilla_Cake", "RedVelvet_Cake", 
                        "Fruit_Cake", "BlackForest_Cake", "Cheese_cake", "Carrot_Cake", "Pineapple_Cake", 
                        "Lemon_Cake", "Eggless_Cake");
                break;
            case 5:
                displayItems("Ice Creams", "Vanilla_IceCream", "Chocolate_IceCream", "Strawberry_IceCream",
                        "Butterscotch_IceCream", "MintChocolate_Chip", "Mango_Ice_Cream", "CookieDough_IceCream",
                        "Pistachio_IceCream", "FruitSalad_IceCream", "SoftServe_IceCream");
                break;
            case 6:
                displayItems("Rolls", "Veg_Roll", "Chicken_Roll", "Mutton_Roll",
                        "Egg_Roll", "Paneer_Roll", "Spicy_Roll");
                break;
            case 7:
                displayItems("Kababs", "Chicken_Kabab", "Mutton_Kabab", "Beef_Kabab", "Seekh_Kabab",
                        "Paneer_Kabab", "Fish_Kabab");
                break;
            case 8:
                displayItems("Pastries", "Chocolate_Pastry", "Strawberry_Pastry", "Vanilla_Pastry",
                        "BlackForest_Pastry", "Fruit_Pastry");
                break;
            case 9:
                displayItems("Salads", "Greek_Salad", "Caesar_Salad", "Fruit_Salad", "Pasta_Salad", "Coleslaw_Salad");
                break;
            case 10:
            	displayItems("Idli", "Dosa", "Vada", "Sambar Rice", "Pongal", "Rasam Rice",
                        "Upma", "Puttu", "Kari Dosa");
            	break;
            default:
                System.out.println("Invalid choice. Please try again.");
                choose();
                break;
        }
        order();
    }

    private void displayItems(String category, String... items) {
        System.out.println("\n" + category + ":");
        for (String item : items) {
            System.out.println(item + ": ₹" + menu.get(item));
        }
    }
    public static void main(String[] args) {
        Welcome p = new Welcome();
//        p.printMenu();
        p.welcomebanner();
        p.choose();
    }
}




	
