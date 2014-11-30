import java.util.ArrayList;


public class CreateMealPlan {
	
	public ArrayList<ArrayList<Food>> shoppingList;
	
	public CreateMealPlan(){
		
	}
	
	public MealPlanner create(){
		
		double[] prices1 = {1.92, 3.98};
		double[] prices2 = {1.00, 1.00};
		double[] prices3 = {3.33, 3.93};
		double[] prices4 = {0.49, 0.49};
		double[] prices5 = {1.75, 1.78};
		double[] prices6 = {3.33, 4.80};
		double[] prices7 = {1.5, 1};
		double[] prices8 = {5, 1.5};
		double[] prices9 = {0.77, 1.99};
		double[] prices10 = {1.00, 0.45};
		double[] prices11 = {4.00, 3.80};

		Food ID1 = new Food(1, "Coco Pops", "g", 800, 30, prices1, 175.0, 6.0, 32.0, 17.0, 3.0, 1.5, 0.6, 0.35);
		Food ID2 = new Food(2, "Brand Pure British Semi Skimmed Milk", "l", 1, 0.125, prices2, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
		Food ID3 = new Food(3, "Brand British Chicken Breast", "breasts", 3, 3, prices3, 510, 0.0, 90.0, 0.0, 5.4, 1.5, 0.0, 0.9);
		Food ID4 = new Food(4, "Brand Brocoli", "g", 335, 100, prices4, 38, 2.8, 7, 0, 1.8, 0.5, 2.6, 0.3);
		Food ID5 = new Food(5, "Brown Rice", "g", 1000, 75, prices5, 265, 2.2, 17.25, 1.0, 2.1, 0.6, 1.35, 0);
		Food ID6 = new Food(6, "Brand 2 Boneless Salmon Fillets", "fillets", 2, 2, prices6, 430, 40, 0, 0, 28.8, 2.6, 0, 0.3);
		Food ID7 = new Food(7, "Brand Baby Spinach", "g", 240, 50, prices7, 11.5, 1.45, 1.8, 0.8, 0.4, 0, 1.1, 0.1);
		Food ID8 = new Food(8, "Brand Finest Wood Fired 12\" Ham Mushroom & Mascarpone Pizza", "pizza", 1, 1, prices8, 1012, 49.2, 119, 11.8, 35.4, 16.6, 10, 5.6);
		Food ID9 = new Food(9, "Brand Tomatoes On The Vine Loose", "Tomatoes", 7, 1, prices9, 16, 0.6, 2.5, 2.5, 0.2, 0, 0.8, 0.1);
		Food ID10 = new Food(10, "Bread", "Slices", 20, 2, prices10, 176, 8, 30.2, 3.2, 1.4, 0.4, 5.4, 0.72);
		Food ID11 = new Food(11, "Cathedral City Mature Cheddar", "g", 350, 50, prices11, 208, 12.7, 0.05, 0.05, 17.45, 10.85, 0, 0.35);
		
		ArrayList<Food> ing1B = new ArrayList<Food>();
    	ArrayList<Food> ing1L = new ArrayList<Food>();
    	ArrayList<Food> ing1D = new ArrayList<Food>();
    	ArrayList<Food> ing2D = new ArrayList<Food>();
    	ArrayList<Food> ing3D = new ArrayList<Food>();
    	

    	
    	//Breakfast
    	ing1B.add(ID1);
    	ing1B.add(ID2);
    	//Lunch
    	ing1L.add(ID9);
    	ing1L.add(ID10);
    	ing1L.add(ID11);
    	//Chicken Dinner
    	ing1D.add(ID3);
    	ing1D.add(ID4);
    	ing1D.add(ID5);
    	//Pizza Dinner
    	ing2D.add(ID8);
    	//Salmon Dinner
    	ing3D.add(ID6);
    	ing3D.add(ID7);
    	ing3D.add(ID5);
    	
    	Meal meal1B = new Meal("Coco Pops", ing1B);
       	Meal meal1L = new Meal("Cheese and tomato Sandwich", ing1L);
    	Meal meal1D	= new Meal("Chicken Dinner", ing1D);
    	Meal meal2D = new Meal("Pizza Dinner", ing2D);
    	Meal meal3D = new Meal("Salmon Dinner", ing3D);        	
    	
    	MealPlanner plan = new MealPlanner();
    	
    	plan.add(meal1B, "Mon", "Breakfast");
    	plan.add(meal1B, "Tue", "Breakfast");
    	plan.add(meal1B, "Wed", "Breakfast");
    	plan.add(meal1B, "Thu", "Breakfast");
    	plan.add(meal1B, "Fri", "Breakfast");
    	plan.add(meal1B, "Sat", "Breakfast");
    	plan.add(meal1B, "Sun", "Breakfast");
    	
    	plan.add(meal1L, "Mon", "Lunch");
    	plan.add(meal1L, "Tue", "Lunch");
    	plan.add(meal1L, "Wed", "Lunch");
    	plan.add(meal1L, "Thu", "Lunch");
    	plan.add(meal1L, "Fri", "Lunch");
    	plan.add(meal1L, "Sat", "Lunch");
    	plan.add(meal1L, "Sun", "Lunch");
    	
    	plan.add(meal1D, "Mon", "Dinner");
    	plan.add(meal1D, "Tue", "Dinner");
    	plan.add(meal1D, "Wed", "Dinner");
    	plan.add(meal2D, "Thu", "Dinner");
    	plan.add(meal3D, "Fri", "Dinner");
    	plan.add(meal3D, "Sat", "Dinner");
    	plan.add(meal3D, "Sun", "Dinner");
    	
    	shoppingList = new ArrayList<ArrayList<Food>>();
    	shoppingList.add(ing1B);
    	shoppingList.add(ing1L);
    	shoppingList.add(ing1D);
    	shoppingList.add(ing2D);
    	shoppingList.add(ing3D);
    	
    	double price = totalPrice(shoppingList);
    	plan.setPrice(price);
    	
    	return plan;   	
	}
	public double totalPrice(ArrayList<ArrayList<Food>> list){
		double result = 0;
		for(int i = 0; i < 5; i++){
			for(Food f : list.get(i)){
				result += f.getPrice();
			}
		}
		return result;
	}
	
}
