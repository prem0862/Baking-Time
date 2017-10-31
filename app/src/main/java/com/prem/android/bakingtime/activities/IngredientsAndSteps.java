package com.prem.android.bakingtime.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.prem.android.bakingtime.R;

import fragment.IngreAndSteps;

public class IngredientsAndSteps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients_and);

        //create SelectRecipe fragment
        IngreAndSteps fragmentRecipe = new IngreAndSteps();

        //add the fragment to its container using fragmentmanager and transaction
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.view_holder_for_ingredients_steps, fragmentRecipe)
                .commit();
    }

}