package com.example.pokemongettodaze;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View difficultyLayout=(View)findViewById(R.id.difficultyPopUp);
        difficultyLayout.setVisibility(View.GONE);
        Button gofight=(Button)findViewById(R.id.startgame);
        gofight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goFight();
            }
        });
        Button difficulty=(Button)findViewById(R.id.setdifficulty);
        difficulty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseDifficulty();
            }
        });
    }
    private void goFight(){
        Intent intent=new Intent(this, fightUFaggot.class);
        startActivity(intent);
    }
    private void chooseDifficulty(){
        // create an alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Name");
        // set the custom layout
        final View customLayout = getLayoutInflater().inflate(R.layout.popup, null);
        builder.setView(customLayout);
    }


}
