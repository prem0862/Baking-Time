package fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prem.android.bakingtime.R;
import com.prem.android.bakingtime.activities.MainActivity;

import java.util.ArrayList;

import adapters.RecipeAdapter;
import interfaces.TaskCompleted;
import models.Recipe;
import utils.AsyncTaskRecipe;
import utils.Constants;

/**
 * A simple fragment which will contain the MainRecipe cards.
 */
public class SelectRecipe extends Fragment implements TaskCompleted, RecipeAdapter.RecyclerViewClickListener{


    ArrayList<models.Recipe> recipeList;
    private RecipeAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    Context mContext;


    // required Constructor
    public SelectRecipe ( ){}

    public SelectRecipe(MainActivity mainActivity) {
        this.mContext = mainActivity;
    }
    RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select_recipe, container, false);

        //Initialisation of AsyncTask to get raw data
        AsyncTaskRecipe asyncTaskRecipe = new AsyncTaskRecipe(this);
        asyncTaskRecipe.execute();

        mRecyclerView = (RecyclerView)view.findViewById(R.id.recipe_recyclerview);

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecipeAdapter(getContext());
        mRecyclerView.setAdapter(adapter);
        return view;
    }

    //Called when the Fragment is visible to the user
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onTaskCompleted(ArrayList<models.Recipe> mRecipe) {
        this.recipeList = mRecipe;
        // now recipeList has data
        adapter.setDataset(recipeList);
    }

    @Override
    public void onRecipeClick(Recipe position) {
        Intent toIngredientAndSteps = new Intent(mContext, IngreAndSteps.class);
        toIngredientAndSteps.putExtra(Constants.SELECTED_RECIPE, (Parcelable) recipeList.get(position));
        startActivity(toIngredientAndSteps);
    }
}
