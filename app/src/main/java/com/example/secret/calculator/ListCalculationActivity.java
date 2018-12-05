package com.example.secret.calculator;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListCalculationActivity extends AppCompatActivity {

    private static final String TAG = "ListCalculationActivity";

    DatabaseHelper mDatabaseHelper;

    private ListView mListView;
    private Button buttonClearHistory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculation_layout);
        mListView = (ListView) findViewById(R.id.listView);
        buttonClearHistory = (Button) findViewById(R.id.buttonClear);
        mDatabaseHelper = new DatabaseHelper(this);

        createListView();

        buttonClearHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseHelper.deleteAll();
                createListView();
                Log.d(TAG, "buttonClearHistory: Database Emptied");
                Toast.makeText(ListCalculationActivity.this, "Calculations has been Cleared!", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    private void createListView(){
        Log.d(TAG, "createListView: Displaying calculation in ListView");

        //get the data and append to a list
        Cursor data = mDatabaseHelper.getCalc();
        ArrayList<String> listCalc = new ArrayList<>();
        while(data.moveToNext()){
            //get the value from the database in column index 1
            //then add it to the ArrayList
            listCalc.add(data.getString(1));
        }
        //create the list adapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listCalc);
        mListView.setAdapter(adapter);
    }
}
