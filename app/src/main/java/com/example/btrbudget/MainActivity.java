/*
All Code pertaining to MPAndroidChart is subject to the following:

Copyright [2020] [Philipp Jahoda]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

 */

package com.example.btrbudget;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    //create PieChart instance/object
    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //load default class values
        pieChart = findViewById(R.id.activity_main_piechart);

        setupPieChart();
        loadPieChartData();

        get_json();
    }

    public void homeNavigate(View view)
    {
        this.findViewById(android.R.id.content).getRootView();

        setContentView(R.layout.activity_main);

        //Set default class values for pie chart
        pieChart = findViewById(R.id.activity_main_piechart);

        //update data values
        setupPieChart();
        loadPieChartData();
    }

    //Set up the piechart ui
    private void setupPieChart()
    {
        //ui elements of chart
        pieChart.setDrawHoleEnabled(true);
        pieChart.setUsePercentValues(true);
        pieChart.setEntryLabelTextSize(12);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setCenterText("March Expenses");
        pieChart.setCenterTextSize(18);
        pieChart.getDescription().setEnabled(false);

        //set legend position
        Legend legend = pieChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(false);
        legend.setEnabled(true);
    }

    //Load the data pertaining to the pieChart
    private void loadPieChartData()
    {
        //create arraylist for data entries
        ArrayList<PieEntry> entries = new ArrayList<>();

        //add entries
        entries.add(new PieEntry(10f, "Netflix"));
        entries.add(new PieEntry(8f, "Hulu"));
        entries.add(new PieEntry(26f, "Xbox"));
        entries.add(new PieEntry(87.5f, "Food"));
        entries.add(new PieEntry(300.3f, "Rent"));

        //Create arraylist for colors to be used by chart
        ArrayList<Integer> colors = new ArrayList<>();

        //populate list
        for(int color: ColorTemplate.MATERIAL_COLORS)
        {
            colors.add(color);
        }

        for(int color: ColorTemplate.VORDIPLOM_COLORS)
        {
            colors.add(color);
        }

        //Instantiate data set object -> set colors of data set
        PieDataSet dataSet = new PieDataSet(entries, "Monthly Expenses");
        dataSet.setColors(colors);

        //Instantiate data object -> populate attributes of chart
        PieData data = new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(pieChart));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);

        //pass data to chart
        pieChart.setData(data);

        //refresh piechart for screen
        pieChart.invalidate();

        pieChart.animateY(1300, Easing.EaseInOutQuad);
    }

    // accesses settings data and sets the settings accordingly.
    public String get_json()
    {
        String notificationPeriod = "daily";

        // define variables
        String json;
        int index;

        // try to open and read the file
        try
        {
            // access input stream
            InputStream is = getAssets().open("settings.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            // make a jsonArray
            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            // loop through length of jsonArray
            for(index = 0; index < jsonArray.length(); index++)
            {
                JSONObject obj = jsonArray.getJSONObject(index);
                if(obj.getString("name").equals("Deezer Nouts"))
                {
                    notificationPeriod = obj.getString("expenseReportPeriod");
                }
            }
        }
        // print error message if failed
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return notificationPeriod;
    }


    public void settingsNavigate(View view)
    {
        // set the screen to the settings window
        setContentView(R.layout.options_screen);

        // get the user saved settings
            // method: getJson()
        String setting = get_json();

        // set all buttons to false
        R.id.daily.isChecked() = false;
    }
    public void groupNavigate(View view)
    {
        setContentView(R.layout.group_screen);
    }
    public void expenseNavigate(View view)
    {
        setContentView(R.layout.expense_page);
    }
    public void reportNavigate(View view)
    {
        setContentView(R.layout.report_screen);
    }

}