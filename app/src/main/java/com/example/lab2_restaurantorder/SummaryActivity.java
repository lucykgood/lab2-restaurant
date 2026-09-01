package com.example.lab2_restaurantorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SummaryActivity extends AppCompatActivity {

    private TextView meal, mealSize, cheese, fries, drink, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        meal = findViewById(R.id.meal);
        mealSize = findViewById(R.id.mealSize);
        cheese = findViewById(R.id.cheese);
        fries = findViewById(R.id.fries);
        drink = findViewById(R.id.drink);
        total = findViewById(R.id.total);

        Intent intent = getIntent();
        String mealName = intent.getStringExtra("mealName");
        boolean hasCheese = intent.getBooleanExtra("hasCheese", false);
        boolean hasFries = intent.getBooleanExtra("hasFries", false);
        boolean hasDrink = intent.getBooleanExtra("hasDrink", false);
        String meal_size = intent.getStringExtra("meal_size");
        float price = intent.getFloatExtra("price", 0);

        meal.setText("Meal: " + mealName);
        mealSize.setText("Size: " + meal_size);
        cheese.setText("Cheese: " + (hasCheese ? "Yes" : "No"));
        fries.setText("Fries: " + (hasFries ? "Yes" : "No"));
        drink.setText("Drink: " + (hasDrink ? "Yes" : "No"));
        total.setText("Total: " + price);
    }

    public void confirmOrder(View view) {
        Toast.makeText(getApplicationContext(), "Order Confirmed", Toast.LENGTH_LONG).show();
    }

    public void back(View view) {
        finish();
    }
}