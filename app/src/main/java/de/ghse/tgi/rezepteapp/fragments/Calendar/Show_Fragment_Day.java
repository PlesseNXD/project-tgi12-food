package de.ghse.tgi.rezepteapp.fragments.Calendar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;


import de.ghse.tgi.rezepteapp.R;


public class Show_Fragment_Day extends Fragment {
    private final CalendarFragment main;
    private int day,month,year;

    public Show_Fragment_Day(CalendarFragment main) {
        this.main = main;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_day, container, false);
        FloatingActionButton floatingActionButton = view.findViewById(R.id.floatingActionButton2);
        floatingActionButton.setOnClickListener(view1 -> main.replaceFragment(CalendarFragment.ADD_EVENT_FRAGMENT));
        ListView listView = view.findViewById(R.id.LVShowEvents);
        CalendarShowDayAdapter adapter = new CalendarShowDayAdapter(getContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i%2 !=0){
                    main.setRecipe(adapter.getRecipeID(i/2));
                    main.replaceFragment(CalendarFragment.VIEW_RECIPE);
                }
            }
        });
        adapter.setDay(day,month,year);
        return view;
    }

    public void setDay(int day, int month, int year){
        this.day=day;
        this.month = month;
        this.year=year;
    }

}