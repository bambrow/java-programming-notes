package design.builder.meal;

import design.builder.item.ChickenBurger;
import design.builder.item.Coke;
import design.builder.item.Sprite;
import design.builder.item.VegBurger;

public class MealBuilder {

	public Meal prepareVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}
	
	public Meal prepareRegularMeal() {
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Sprite());
		return meal;
	}
	
}
