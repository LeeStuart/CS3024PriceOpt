import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author ruaraidh
 *
 */
/**
 * 
 * Main class that brings all the other classes together.
 *
 */
public class Main{
	/**
	 * Will create a Person object, Food and the create a MealPlanner and add the Food.
	 * TODO: add a MealPlanner to the Person that will associate with. 
	 * @param args
	 */
	/********************************************************************************************************************************
	 * 																																*
	 * 														FOOD DATA																*
	 *																																* 
	 ********************************************************************************************************************************/
//	ID, String name, String unts, int amnt, int serving, double pric, double cal, double prot, double crbs, double sgrs, double ft, double sats, double fbr, double slt
	
	public static void main(String[] args) {
		
		/********************************************************************************************************************************
		 * 																																*
		 * 														USER SET UP																*
		 *																																* 
		 ********************************************************************************************************************************/
		Scanner sc = new Scanner(System.in);
		
		int ID = 1;
//		System.out.println("Please enter your name:");
		String userName = "Ruaraidh";
//		System.out.println("Please enter your email:");
		String email = "ruaraidh2@gmail.com";
//		System.out.println("Please enter your age:");
    	int age = 19;
//    	System.out.println("Please enter your height:");
    	double height = 182.88;
//    	System.out.println("Please enter your weight:");
    	double weight = 74;
//    	System.out.println("Please enter your gender:");
    	char gender = 'M';
//    	System.out.println("Please enter your exercise:");
    	int exercise = 2;
    	
    	Person user = new Person(ID, userName, email, age, height, weight, gender, exercise, null);
    	
    	
		/********************************************************************************************************************************
		 * 																																*
		 * 													  		MEALS																*
		 *																																* 
		 ********************************************************************************************************************************/
    	
    	CreateMealPlan ct = new CreateMealPlan();
    	MealPlanner plan = ct.create();
    	
		user.setPlan(plan);
		
		NutritionOptimisation result = new NutritionOptimisation();
		String dayResult = result.compareCalories(user, plan);
    	String weekResult = result.compareToGDAWeek(user, plan);
    	
    	System.out.println(dayResult);
    	System.out.println(weekResult);
    	
    	double priceD = plan.getPrice();
    	String price = String.format("%.2f", priceD);
    	System.out.println("Price: £" + price);
    	
    	ArrayList<Food> food = new ArrayList<Food>();
		for (int i = 0; i < ct.shoppingList.size(); i++) {
			for (Food f: ct.shoppingList.get(i)) {
				food.add(f);
			}
		}
		Food[] foodarray = food.toArray(new Food[food.size()]);
    	
    	String[] shops = {"Tesco", "Asda"};
    	System.out.println("###################\nPrice Optimisation");
    	System.out.println("Cheapest Shop: " + shops[PriceOptimisation.cheapestShop(foodarray)]);
    	System.out.println("\nShopping lists such that you spend the minimum");
    	String[] temp = PriceOptimisation.minimumBudget(shops, foodarray);
    	for (String s : temp) {
    		System.out.println(s);
    	};
    	System.out.println("Price: " + PriceOptimisation.minimumBudget(foodarray));
    }
}