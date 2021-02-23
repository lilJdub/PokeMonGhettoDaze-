package com.example.pokemongettodaze;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends Activity implements PopupMenu.OnMenuItemClickListener{
    int difficultyGate=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                chooseDifficulty(v);
            }
        });
    }
    private void goFight(){
        Intent intent=new Intent(this, fightUFaggot.class);
        intent.putExtra("diff",difficultyGate);
        startActivity(intent);
    }
    private void chooseDifficulty(View v) {
        PopupMenu pp = new PopupMenu(MainActivity.this,v);
        pp.setOnMenuItemClickListener(MainActivity.this);
        pp.inflate(R.menu.popup);
        pp.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.easyDifficulty:
                // do your code
                difficultyGate=0;
                return true;
            case R.id.normalDifficulty:
                // do your code
                difficultyGate=1;
                return true;
            case R.id.hardDifficulty:
                // do your code
                difficultyGate=2;
                return true;
            default:
                return false;
        }
    }
}
