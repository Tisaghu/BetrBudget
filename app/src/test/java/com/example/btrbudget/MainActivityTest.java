package com.example.btrbudget;

import static org.junit.jupiter.api.Assertions.*;

import android.view.View;


import org.junit.jupiter.api.Test;

class MainActivityTest {
    @Test
    void homeNavigate(View view){
        // check if current view is not null
        View v = this.findViewById(android.R.id.content).getRootView();
        assertNotNull(v);
    }

    void settingsNavigate(View view){
        // check if current view is not null
        View v = this.findViewById(android.R.id.content).getRootView();
        assertNotNull(v);
    }

    void groupNavigate(View view){
        // check if current view is not null
        View v = this.findViewById(android.R.id.content).getRootView();
        assertNotNull(v);
    }

    void expenseNavigate(View view){
        // check if current view is not null
        View v = this.findViewById(android.R.id.content).getRootView();
        assertNotNull(v);
    }

    void reportNavigate(View view){
        // check if current view is not null
        View v = this.findViewById(android.R.id.content).getRootView();
        assertNotNull(v);
    }
}