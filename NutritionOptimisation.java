/**
 * @author Lee
 */

/**
 * A class which tells you if you're higher or lower than the GDA values
 */
public class NutritionOptimisation {
	
	/**
	 * Returns the total nutritional values.
	 * @param nutritionalValues An array of the nutritional values for each of the food item.
	 * @return The total nutritional values.
	 */
	
	//NOT USED
	public static double[] totalNutrition(double[][] nutritionalValues) {
		double[] totalValues = new double[nutritionalValues[0].length];
		for (int i = 0; i < nutritionalValues.length; i++) {
			for (int j = 0; j < nutritionalValues[i].length; j++) {
				totalValues[j] += nutritionalValues[i][j];
			}
		}
		
		return totalValues;
	}
	
	/**
	 * Returns a string detailing which nutritional values are higher or lower, within 10% either way lower or higher
	 * @param values The total nutritional values of the foods
	 * @param gdaValues The recommended daily values of the person
	 * @param descriptions The names of the GDA values, eg. Calories
	 * @return A string detailing which nutritional values are higher or lower
	 */
	public static String compareCalories(Person p, MealPlanner m) {
		String result = "";
		GDA userGDA = new GDA(p);
		double max = userGDA.getCalories() + 0.1 * userGDA.getCalories();
		double min = userGDA.getCalories() - 0.1 * userGDA.getCalories();
		for (int i = 0; i < 7; i++) {
			if (m.totalCal(i) < min)
				result += "You are eating to little on " + m.getDay(i) + ".\n";
			else if (m.totalCal(i) > max) 
				result += "You are eating too much on " + m.getDay(i) + ".\n";
			else
				result += "You are eating the right amount of calories on " + m.getDay(i) + ".\n";
//			System.out.println("MAX: " + userGDA.toKcal(max) + " MIN: " + userGDA.toKcal(min) + " TOTAL: " + userGDA.toKcal(m.totalCal(i)));
		}
		
		
		return result;
	}
	
	/**
	 * Returns a string detailing which nutritional values are higher or lower for a week, within 10% either way lower or higher
	 * @param values The total nutritional values of the foods
	 * @param gdaValues The recommended daily values of the person
	 * @param descriptions The names of the GDA values, eg. Calories
	 * @return A string detailing which nutritional values are higher or lower for a week
	 */
	public static String compareToGDAWeek(Person p, MealPlanner m) {

		String result = "";
		GDA userGDA = new GDA(p);
		int total = 0;
		double max = 7 * (userGDA.getCalories() + 0.1 * userGDA.getCalories());
		double min = 7 * (userGDA.getCalories() - 0.1 * userGDA.getCalories());
		for (int i = 0; i < 7; i++) {
			total += m.totalCal(i);
		}
		System.out.println("MAX: " + userGDA.toKcal(max) + " MIN: " + userGDA.toKcal(min) + " TOTAL: " + userGDA.toKcal(total));
		if (total < min) 
			result = "You are not eating enough in a week. You might have to spend more money.";
		else if (total > max) 
			result = "You are eating too much in a week. You could save money.";
		else
			result = "Your calorie intake is good.";
		return result;
	}

}
