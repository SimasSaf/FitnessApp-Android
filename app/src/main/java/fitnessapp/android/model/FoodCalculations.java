package fitnessapp.android.model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.time.LocalDate;
import java.util.List;

import fitnessapp.android.DAO.FoodDAO;
import fitnessapp.android.DAO.IFoodDAO;
import fitnessapp.android.entities.Food;

public class FoodCalculations implements IFoodCalculations {

    IFoodDAO foodDAO = new FoodDAO();
    LocalDate localDate = LocalDate.now();

    @Override
    public void addFood(Food food) {
        Log.i("SIMAS", "Local date: " + localDate.toString());
        food.setDay(localDate.getDayOfMonth());
        food.setMonth(localDate.getMonthValue());
        food.setYear(localDate.getYear());
        foodDAO.addFood(food);
    }

    @Override
    public MutableLiveData<List<Food>> getFoodByDay(int day) {

        return foodDAO.getFoodByDay(day);
    }

    @Override
    public MutableLiveData<List<Food>> getFoodByName(String name) {
        return foodDAO.getFoodByName(name);
    }
}
