package com.example.cozzal.aplikasirandom;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RandomDadu extends AppCompatActivity {
    EditText etDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_dadu);
    }

    public void generateDice(View view){

        int dice = (int)(Math.random()*6) + 1;
        String hasil = Integer.toString(dice);
        etDice.setText(hasil);
    }

}
