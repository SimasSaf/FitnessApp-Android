package fitnessapp.android.model;

import androidx.lifecycle.MutableLiveData;

import java.time.LocalDate;
import java.util.List;

import fitnessapp.android.entities.Food;

public interface IFoodCalculations {
    public void addFood(Food food);
    public MutableLiveData<List<Food>> getFoodByDay(int day);
    public MutableLiveData<List<Food>> getFoodByName(String name);
}
