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

        ImageButton settingsBtn = (ImageButton) optionsScrn.findViewById(R.id.settingsBtn);
        ImageButton homeBtn = (ImageButton) findViewById(R.id.homeBtn);
    }

    public void homeNavigate(View view)
    {
        setContentView(R.layout.activity_main);
    }

    public void settingsNavigate(View view)
    {
        setContentView(R.layout.options_screen);
    }
}