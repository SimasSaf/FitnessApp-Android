package fitnessapp.android.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import fitnessapp.android.entities.Food;
import fitnessapp.android.model.FoodCalculations;
import fitnessapp.android.model.IFoodCalculations;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private IFoodCalculations foodCalculations = new FoodCalculations();

    //private final MutableLiveData<List<Food>> allFood;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");

        //LiveData<List<Food>> getListOfFood =
    }

    public void addFood(Food food)
    {
        foodCalculations.addFood(food);
    }

    public MutableLiveData<List<Food>> getFoodByName(String name)
    {
        return foodCalculations.getFoodByName(name);
    }

    public MutableLiveData<List<Food>> getFoodByDay(int day)
    {
        return foodCalculations.getFoodByDay(day);
    }

    public LiveData<String> getText() {
        return mText;
    }
}