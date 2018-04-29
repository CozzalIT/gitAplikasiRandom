package com.example.cozzal.aplikasirandom;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RandomTeamActivity extends AppCompatActivity {
    TextView tvList;
    TextView tvLabelList;
    EditText etNumberOfMember;
    EditText etMemberName;

    String list = "", member, tmp, listTeam;
    String[] listMember = new String[50];
    String[] arrayTeamResult = new String[50];
    int i=0, numberOfMember, lngStr1, lngStr2, seconds, sumTeam, teamNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_team);
    }

    public void addMember(View view){
        tvList = findViewById(R.id.tvList);
        etMemberName = findViewById(R.id.etMemberName);
        member = etMemberName.getText().toString();
        list = list + member + "\n- ";

        tvList.setTextColor(Color.rgb(0,0,0));
        tvList.setText("- "+list);
        etMemberName.setText("");

        listMember[i] = member;
        i++;
    }

    private int getTime() {
        DateFormat dateFormat = new SimpleDateFormat("ss");
        Date date = new Date();
        return Integer.parseInt(dateFormat.format(date));
    }

    public void generate(View view){
        etNumberOfMember = findViewById(R.id.etNumberOfMember);
        numberOfMember = Integer.parseInt(etNumberOfMember.getText().toString());
        RandomTeamActivity time = new RandomTeamActivity();

        seconds = (time.getTime()/10) + (time.getTime()%10);

        for (int j=0;j<i;j++){
            for (int x=0;x<i-1;x++){
                lngStr1 = listMember[x].length();
                lngStr2 = listMember[x+1].length();
                if (((lngStr1%seconds)+x) > ((lngStr2%seconds)+j)){
                    tmp = listMember[x];
                    listMember[x] = listMember[x+1];
                    listMember[x+1] = tmp;
                }
            }
        }

        sumTeam = i / numberOfMember;
        if (i%numberOfMember > 0){
            sumTeam += 1;
        }

        int ind = 0;
        listTeam = "";
        teamNumber = 0;
        for (int y=0;y<sumTeam;y++){
            teamNumber += 1;
            arrayTeamResult[y] = "";
            for (int k=1;k<=numberOfMember;k++){
                arrayTeamResult[y] = arrayTeamResult[y]+"- "+listMember[ind]+"\n";
                ind++;
            }
            listTeam = listTeam + "TEAM " + teamNumber + "\n" + arrayTeamResult[y] + "\n\n";
        }

        tvList.setText(listTeam);
    }
}
