package com.example.btrbudget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get views of other layouts
        View optionsScrn = getLayoutInflater().inflate(R.layout.options_screen, null);
        View groupScrn = getLayoutInflater().inflate(R.layout.group_screen, null);
        View expenseScrn = getLayoutInflater().inflate(R.layout.expense_page, null);
        View reportScrn = getLayoutInflater().inflate(R.layout.report_screen, null);

    }

    public void homeNavigate(View view)
    {
        setContentView(R.layout.activity_main);
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