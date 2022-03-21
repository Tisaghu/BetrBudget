package com.example.btrbudget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

// JSON stuff
import org.json.*;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        JSONObject settingsJSON = new JSONObject();

        try {
            settingsJSON.put("UserName", "DeezNuts");
            settingsJSON.put("moneySaved", 100);
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get views of other layouts
        View optionsScrn = getLayoutInflater().inflate(R.layout.options_screen, null);

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