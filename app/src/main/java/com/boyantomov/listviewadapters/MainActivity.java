package com.boyantomov.listviewadapters;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    ListView lvDetail;
    Context context = MainActivity.this;
    ArrayList<ListData> myList = new ArrayList<ListData>();
    String multiplication;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDetail = (ListView) findViewById(R.id.lvCustomList);

        //populate list with data

        getDataInList();
        lvDetail.setAdapter(new MyBaseAdapter(context, myList));
    }


    private void getDataInList() {
        int counter = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                multiplication = Integer.toString(i) + " x " + Integer.toString(j) + " = ";
                result = String.valueOf(i * j);

                //Create object
                ListData ld = new ListData();
                ld.setMultiplication(multiplication);
                ld.setResult(result);

                //Add object into the ArrayList
                myList.add(ld);

                counter++;
            }
        }
    }
}
