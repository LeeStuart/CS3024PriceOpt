import java.util.ArrayList;

/**
 * 
 * @author ruaraidh
 * 
 */
/**
 * 
 * Creates an empty 2D grid to allow a weekly meal plan to be created.
 *
 */
public class MealPlanner {
	/**
	 * Meals can be added to a day and a meal time. This can work out what calories the Person plans
	 * to eat during a week or per day.
	 */
	private Meal[][] plan;
	private double price;
	/**
	 * Constructs a default empty planner.
	 */
	public MealPlanner(){
		plan = new Meal[7][3];

	}
	/**
	 * Allows a Meal to be added. 
	 * @param name The Meal name.
	 * @param day The day of the week it will be added to.
	 * @param time The time of the day to add the meal to.
	 */
	public void add(Meal name, String day, String time){
		plan[writeToDay(day)][writeToTime(time)] = name;
	}
	/**
	 * Represents the Meal plan as a string.
	 */
	
	public String toString(){
		
		StringBuffer result = new StringBuffer();
		
		for(int i = 0 ; i < 7; i++){
			for(int j = 0; j < 3; j++){
				if(plan[i][j] == null)
					result.append("Meal: NO MEAL" + "\n Day: " + getDay(i) + "\nTime: " + getTime(j) + "\n\n");
				else
					result.append("Meal: " + plan[i][j].getName() + "\n Day: " + getDay(i) + "\nTime: " + getTime(j) + "\n\n");
			}
		}
		String s = "" + result;
		return s;
	}

	
	/**
	 * The day will be passed in as a String but in order to write it to the grid it needs to
	 * be an integer. This function will convert the string to the correct number.		
	 * @param day
	 * @return The index of the grid to add.
	 */
	public int writeToDay(String day){
		int dayNo = -1;
		if(day == "Mon")
			dayNo = 0;
		if(day == "Tue")
			dayNo = 1;
		if(day == "Wed")
			dayNo = 2;
		if(day == "Thu")
			dayNo = 3;
		if(day == "Fri")
			dayNo = 4;
		if(day == "Sat")
			dayNo = 5;
		if(day == "Sun")
			dayNo = 6;
		return dayNo;
	}
	/**
	 * The time will be passed in as a String but in order to write it to the grid it needs to
	 * be an integer. This function will convert the string to the correct number.		
	 * @param time
	 * @return The index of the grid to add.
	 */
	public int writeToTime(String time){
		int timeNo = -1;
		if(time.equals("Breakfast"))
			timeNo = 0;
		if(time.equals("Lunch"))
			timeNo = 1;
		if(time.equals("Dinner"))
			timeNo = 2;
		return timeNo;
	}
	
	
	/** 
	 * Since the grid will have it's indexes as integers there needs to be a function so that
	 * when the grid is printed as a string it can convert the integer back to a string.
	 * @param i
	 * @return The time of day the meal is located on the planner.
	 */
	public String getTime(int i ){
		if(i == 0)
			return "Breakfast";
		if(i == 1)
			return "Lunch";
		if(i == 2)
			return "Dinner";
		else
			return null;
	}
	/** 
	 * Since the grid will have it's indexes as integers there needs to be a function so that
	 * when the grid is printed as a string it can convert the integer back to a string.
	 * @param i
	 * @return The day of the week the meal is located on the planner.
	 */
	public String getDay(int i){
		if(i == 0)
			return "Mon";
		if(i == 1)
			return "Tue";
		if(i == 2)
			return "Wed";
		if(i == 3)
			return "Thur";
		if(i == 4)
			return "Fri";
		if(i == 5)
			return "Sat";
		if(i == 6)
			return "Sun";
		else
			return null;
	}
	
	
	
	public double totalCal(int i){
		double result = 0;
		for(int j = 0; j < 3; j ++){
			result += plan[i][j].mealCal();
		}
		return result;
	}
	
	public double totalProtein(int i){
		double result = 0;
		for(int j = 0; j < 3; j ++){
			result += plan[i][j].mealProt();
		}
		return result;
	}
	
	public double totalCarbs(int i){
		double result = 0;
		for(int j = 0; j < 3; j ++){
			result += plan[i][j].mealCarb();
		}
		return result;
	}
	public double totalSugars(int i){
		double result = 0;
		for(int j = 0; j < 3; j ++){
			result += plan[i][j].mealSugar();
		}
		return result;
	}
	public double totalFats(int i){
		double result = 0;
		for(int j = 0; j < 3; j ++){
			result += plan[i][j].mealFat();
		}
		return result;
	}
	public double totalSats(int i){
		double result = 0;
		for(int j = 0; j < 3; j ++){
			result += plan[i][j].mealSat();
		}
		return result;
	}
	public double totalFibre(int i){
		double result = 0;
		for(int j = 0; j < 3; j ++){
			result += plan[i][j].mealFibr();
		}
		return result;
	}
	public double totalSalt(int i){
		double result = 0;
		for(int j = 0; j < 3; j ++){
			result += plan[i][j].mealSalt();
		}
		return result;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
