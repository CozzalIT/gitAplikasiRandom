package com.example.cozzal.aplikasirandom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rTeam(View view){
        Intent intent = new Intent(MainActivity.this, RandomTeamActivity.class);
        startActivity(intent);
    }

    public void rDice(View viem){
        Intent intent = new Intent(MainActivity.this, RandomDadu.class);
        startActivity(intent);
    }

}
