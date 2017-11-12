package com.prem.android.bakingtime.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.prem.android.bakingtime.R;

import java.util.ArrayList;

import adapters.IngredientsAdapter;
import models.Ingredient;

public class IngredientActivity extends AppCompatActivity {

    private ArrayList<Ingredient> mIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient);

        if(getIntent().getParcelableArrayListExtra("RECIPE_INGREDIENTS") != null){
            mIngredients = getIntent().getParcelableArrayListExtra("RECIPE_INGREDIENTS");
        }

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.ingredients_recyclerView);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        IngredientsAdapter mAdapter = new IngredientsAdapter(this);
        mAdapter.setIngredientsData(mIngredients);

        mRecyclerView.setAdapter(mAdapter);

    }
}
