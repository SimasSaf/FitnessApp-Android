package fitnessapp.android.DAO;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fitnessapp.android.entities.Food;

public class FoodDAO implements IFoodDAO {
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://fitnessapp-6b54d-default-rtdb.europe-west1.firebasedatabase.app/");
    DatabaseReference myRef = database.getReference();

    MutableLiveData<List<Food>> foodModel = new MutableLiveData<>();
    Food foodFromDB = new Food("fake", 1, 1, 1, 1);

    @Override
    public void addFood(Food food) {
        myRef.child("Food").child(food.getName()).setValue(food);
    }

    @Override
    public void deleteFood(Food food) {

    }

    @Override
    public void updateFood(Food food) {

    }


    @Override
    public MutableLiveData<List<Food>> getFoodByDay(int day) {
        database.getReference("Food").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.i("SIMAS", "New data posted");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return null;
    }

    @Override
    public MutableLiveData<List<Food>> getFoodByName(String name) {

        ArrayList<Food> foodByName = new ArrayList<>();
        database.getReference("Food").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.i("SIMAS", "New data posted");
                foodByName.add(snapshot.getValue(Food.class));
                foodModel.postValue(foodByName);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        return foodModel;
    }
}
