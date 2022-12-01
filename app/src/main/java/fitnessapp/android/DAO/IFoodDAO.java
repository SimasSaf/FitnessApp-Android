package fitnessapp.android.DAO;

import androidx.lifecycle.MutableLiveData;

import java.time.LocalDate;
import java.util.List;

import fitnessapp.android.entities.Food;

public interface IFoodDAO {
    void addFood(Food food);
    void deleteFood(Food food);
    void updateFood(Food food);
    MutableLiveData<List<Food>> getFoodByDay(int day);
    MutableLiveData<List<Food>> getFoodByName(String name);
}
