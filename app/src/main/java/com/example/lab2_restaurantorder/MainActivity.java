package com.example.lab2_restaurantorder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioGroup meal;
    private CheckBox cheese, fries, drink;
    private Spinner mealSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meal = findViewById(R.id.meal);
        cheese = findViewById(R.id.cheese);
        fries = findViewById(R.id.fries);
        drink = findViewById(R.id.drink);
        mealSize = findViewById(R.id.mealSize);
    }

    public void placeOrder(View view) {
        int checkedRadioButtonId = meal.getCheckedRadioButtonId();
        RadioButton checkedButton = findViewById(checkedRadioButtonId);
        String mealName = checkedButton.getText().toString();
        Log.d("placeOrder", "Meal: " + mealName);

        boolean hasCheese = cheese.isChecked();
        boolean hasFries = fries.isChecked();
        boolean hasDrink = drink.isChecked();
        Log.d("placeOrder", "Cheese: " + hasCheese);
        Log.d("placeOrder", "Fries: " + hasFries);
        Log.d("placeOrder", "Drink: " + hasDrink);

        String meal_size = mealSize.getSelectedItem().toString();
        Log.d("placeOrder", "Size: " + meal_size);

        float price = 10;
        if (meal_size.equals("Medium")) {
            price += 5;
        } else if (meal_size.equals("Large")) {
            price += 10;
        }
        if (hasCheese) {
            price += 1;
        }
        if (hasFries) {
            price += 1;
        }
        if (hasDrink) {
            price += 1;
        }
        Log.d("placeOrder", "Price: " + price);

        Intent intent = new Intent(this, SummaryActivity.class);
        intent.putExtra("mealName", mealName);
        intent.putExtra("hasCheese", hasCheese);
        intent.putExtra("hasFries", hasFries);
        intent.putExtra("hasDrink", hasDrink);
        intent.putExtra("meal_size", meal_size);
        intent.putExtra("price", price);
        startActivity(intent);
    }
}