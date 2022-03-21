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

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

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

    }

    public void homeNavigate(View view)
    {
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

    public void settingsNavigate(View view)
    {
        setContentView(R.layout.options_screen);
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