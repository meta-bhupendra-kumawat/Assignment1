import java.util.Scanner;

/*This is an Application Class. 
 * The Execution starts from here. * 
 */
public class UseShoppingCart 
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		ShoppingCart object to use its instance methods
		ShoppingCart sc=new ShoppingCart();
		
//		Some pre-defined Items available in catalogue
		sc.addToCatalogue(1, "Shoes", 2000);
		sc.addToCatalogue(2, "Jeans", 3499);
		sc.addToCatalogue(3, "Shirt", 1599);
		
		
//		Variables for user input
		int option;							// User option for selecting the operation
		int itemId;							//Variable to store item id from user
		String itemName;					//Variable to store item Name from user
		double itemPrice;					//Variable to store item Price from user
		int cartQuantity;					//Variable to store item Quantity from user

//		Scanner object for user input at runtime
		Scanner scn=new Scanner(System.in);
		
		while(true)
		{
			sc.showCatalogue();
			System.out.println("MENU\n1:Add Item to Catalogue.");
			System.out.println("2:Add Item to Cart.");
            System.out.println("3:Update Cart");    		
 	       	System.out.println("4:Generate Bill For Cart.");
 	        System.out.println("5:Show Catalogue.");
 	        System.out.println("6:Show Cart.");
 	        System.out.println("7:Delete item from Cart.");
 	       	System.out.println("8:Exit.");
 	      	System.out.println("Enter Your Choice: ");
 	       	option=scn.nextInt();							//Taking user input 
 	       	
 	       switch (option) {
 	       
// 	    Adding items to Catalogue 
 	       case 1:
 	    	  System.out.println("Enter Item ID, Item Name & Item Price of Product to Add into catalogue:"); 
 	    	  itemId=scn.nextInt();
 	    	  itemName=scn.next();
 	    	  itemPrice=scn.nextDouble();
 	    	  sc.addToCatalogue(itemId, itemName, itemPrice);
 	    	  break;
 	    	
// 	    	  Adding items in cart
 	       case 2:
 	    	   System.out.println("Enter Item Id and Quantity to add it to cart");  
 	    	   itemId=scn.nextInt();
 	    	   cartQuantity=scn.nextInt();
 	    	   sc.addToCart(itemId, cartQuantity);
 	    	   break; 	   
 	    	   
// 	    	   Updating cart
 	      case 3:
	    	   System.out.println("Enter Item ID and Quantity to UPDATE cart");  
	    	   itemId=scn.nextInt();
	    	   cartQuantity=scn.nextInt();
	    	   sc.updateCart(itemId, cartQuantity);
	    	   break;
 	   
//	    	   Generating bill for cart
 	       case 4:
 	    	   sc.showCart();
 	    	   sc.generateBill();
 	    	   break;
 	    	   
// 	    	   Display items of catalogue
 	       case 5:
 	    	   sc.showCatalogue();
 	    	   break;
 	    	   
// 	    	   Display items of cart
 	       case 6:
	    	   sc.showCart();	
	    	   break;
	    	   
//	    	   Delete item from Cart
 	       case 7:
 	    	   System.out.println("Enter Item ID to DELETE from cart");
 	    	   itemId=scn.nextInt();
 	    	   sc.deletItem(itemId);
 	    	   break;
 	    	   
//	    	   To terminate the program
 	       case 8:
 	    	   System.exit(0);
 	    	    	   
// 	    	   For invalid input
 	       default:
 	    	   System.out.println("Invalid Input");     
 	       }

		}
		
		

	}
	

}
