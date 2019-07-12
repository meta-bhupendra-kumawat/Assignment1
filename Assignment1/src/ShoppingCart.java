import java.util.*;
import java.io.*;

/*This is an Component Class. 
 * It consists of methods used for managing Shopping Cart. 
 */
public class ShoppingCart {
	
//	Hash Map used for storing Items in Catalogue and Cart
	HashMap<Integer,Item> catalogue=new HashMap<>();
	HashMap<Integer, Item> cart=new HashMap<>();
	
	
//	Creating Catalogue
	public void addToCatalogue(int itemId,String name,double price)
	{
		if(catalogue.containsKey(itemId))
		{
			System.out.println("Item with item Id already present in Catalogue. Use distinct Item Id.");
		}else{
			Item itm=new Item(itemId,name,price);
			catalogue.put(itemId, itm);
		}
	}
	
	
//	Displaying Catalogue
	public void showCatalogue()
	{
		if(catalogue.isEmpty())
		{
			System.out.println("Catalogue is Empty.\n");
			return;
		}
			
		System.out.println("\n\n<<<<------------------------CATALOGUE------------------------->>>>");
		System.out.println("ITEM_ID\t\t ITEM_NAME\t PRICE ");
		for(Integer i:catalogue.keySet())
		{
			Item i1=catalogue.get(i);
			System.out.println(i1.itemId+" \t\t "+i1.name+" \t\t "+i1.price);
		}
		System.out.println("------------------------------------------------------------------");
	}
	
	
	
//	Adding new items to cart
	public boolean addToCart(int itemId,int qty)//,String name,double price,int qty)
	{
		
//		When item is not present in Catalogue
		if(!catalogue.containsKey(itemId))
		{
			System.out.println("Item not present in Catalogue.");
			return false;
		}
		
		
//		When item is available in catalogue
		Item itm=catalogue.get(itemId);
		if(cart.containsKey(itemId))		//For the items which already exists in cart.
		{
			cart.get(itemId).cartQty+=qty;
		}else
		{
			itm.cartQty=qty;
			cart.put(itemId, itm);				// When item is added to cart 
		}
		
		System.out.println(cart.get(itemId).name+" added to Cart!! Upadated Quantity="+cart.get(itemId).cartQty);
		return true;
	}
	
	
	
//	Update Cart
	public boolean updateCart(int id,int qty)
	{
		//		When no item is available in Cart
		if(!cart.containsKey(id))
		{
			System.out.println("No such item available in cart to update!!\n");
			return false;
		}
		
		//		When item is present in Cart	
		Item itm;
		if(qty==0)
			cart.remove(id);
		else {
				itm=cart.get(id);
				itm.cartQty=qty;
		}		
		return true;
	}
	
	
//	Delete Items from cart
	public boolean deletItem(int itemId)
	{
		if(!cart.containsKey(itemId))
		{
			System.out.println("No such item available in cart to Delete!!\n");
			return false;
		}
		cart.remove(itemId);
		System.out.println("Item Deleted From Cart!!");
		return true;
	}
	
	
	
//	Show Cart items
	public void showCart()
	{
		if(cart.isEmpty())
		{
			System.out.println("Cart is Empty. Add products to cart first.\n");
			return;
		}
		
		System.out.println("\n\n----------------------------------Cart----------------------------------");
		System.out.println("ITEM_ID\t\t ITEM_NAME\t QUANTITY\t PRICE -----------------------------------");
		for(Integer i:cart.keySet())
		{
			Item i1=cart.get(i);
			System.out.println(i1.itemId+" \t\t "+i1.name+" \t\t "+i1.cartQty+" \t\t "+i1.price);
		}
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------------");
	}
	
	
	
	public double generateBill()
	{
		double total=0;
		for(Integer i:cart.keySet())
		{
			Item i1=cart.get(i);
			total+=i1.price*i1.cartQty;
		}
		System.out.println("\nTOTAL Bill = "+total+"\n");
		return total;
	}


}


