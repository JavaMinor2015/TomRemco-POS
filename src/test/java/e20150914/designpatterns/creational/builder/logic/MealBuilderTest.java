package e20150914.designpatterns.creational.builder.logic;

import e20150914.designpatterns.creational.builder.domain.abs.Meal;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/14/15.
 */
public class MealBuilderTest extends TestCase {

    @Test
    public void testBuilder(){
        List<Meal> meals = new ArrayList<>();

        Meal vegiMealPepsi = new MealDirector().createVegiMealPepsi(2);
        meals.add(vegiMealPepsi);

        Meal vegiMealCoke = new MealDirector().createVegiMealCoke(2);
        meals.add(vegiMealCoke);

        Meal mealPepsi = new MealDirector().createMealPepsi(2);
        meals.add(mealPepsi);

        Meal mealCoke = new MealDirector().createMealCoke(2);
        meals.add(mealCoke);

        for (Meal meal : meals) {
            assertNotNull(meal);
            assertEquals(2, meal.getDrinks().size());
            assertEquals(2, meal.getFood().size());
        }

        assertEquals(7.20f,vegiMealPepsi.getCost()); // 2.50 * 2 & 1.10 * 2
        assertEquals(7.00f,vegiMealCoke.getCost()); // 2.50 * 2 & 1.00 * 2
        assertEquals(5.20f,mealPepsi.getCost()); // 1.50 * 2 & 1.10 * 2
        assertEquals(5.00f,mealCoke.getCost()); // 1.50 * 2 & 1.00 * 2

    }

}