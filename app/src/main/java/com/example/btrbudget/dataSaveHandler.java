package com.example.btrbudget;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class dataSaveHandler extends AppCompatActivity {
    // define relevant class variables
    ArrayList<String> numberList = new ArrayList<>();

    // method that gets json file
    public void get_json()
    {
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
                    numberList.add(obj.getString("moneySaved"));
                }
            }

            Toast.makeText(getApplicationContext(), numberList.toString(), Toast.LENGTH_LONG).show();
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

    }
}
