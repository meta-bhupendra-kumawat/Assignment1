
/*This is an Component Class. 
 * It consists the attributes of Items used in Shopping Cart. * 
 */

public class Item {
	int itemId;
	String name;
	double price;
	int cartQty;
	

	public Item(int itemId,String name,double price) {
		// TODO Auto-generated constructor stub
		this.itemId=itemId;
		this.name=name;
		this.price=price;
	}

}
