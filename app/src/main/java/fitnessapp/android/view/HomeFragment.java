package fitnessapp.android.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fitnessapp.android.R;
import fitnessapp.android.databinding.FragmentHomeBinding;
import fitnessapp.android.entities.Food;
import fitnessapp.android.viewModel.HomeViewModel;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

//        homeViewModel.getFoodByDay(1).observeForever(foodList -> {
//            Log.i("SIMAS", "new added today");
//            ArrayList<Food> listOfFood = new ArrayList<>();
//            ArrayAdapter adapter = new ArrayAdapter<Food>(this.getContext(), R.layout.home_list_items, listOfFood);
//            binding.listHome.setAdapter(adapter);
//        });

        homeViewModel.getFoodByName("sof").observe(getViewLifecycleOwner(), new Observer<List<Food>>() {
            @Override
            public void onChanged(List<Food> foods) {
                Log.i("SIMAS", "Changed" + foods.toString());
            }
        });

        homeViewModel.getFoodByDay(1).observe(getViewLifecycleOwner(), new Observer<List<Food>>() {
            @Override
            public void onChanged(List<Food> foods) {
                Log.i("SIMAS", "Changed" + foods.toString());
            }
        });

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Food newFood = new Food(binding.foodInput.getText().toString(),
                        Integer.parseInt(binding.kcalInput.getText().toString()),
                        20, 5, 5 );
                homeViewModel = new HomeViewModel();
                homeViewModel.addFood(newFood);
            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}