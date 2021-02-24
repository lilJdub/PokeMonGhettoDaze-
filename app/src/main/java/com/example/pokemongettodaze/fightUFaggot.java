package com.example.pokemongettodaze;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class fightUFaggot<pokeMon> extends Activity {
    int dif;
    pokeMon yourPokeMon= (pokeMon) new PokeMon("",dif*100);
    pokeMon enemyPokeMon=(pokeMon) new PokeMon("",dif*100);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_u_faggot);
        configBattle((PokeMon) yourPokeMon,(PokeMon)enemyPokeMon);
        Button startBattle=(Button)findViewById(R.id.battlestart);
        startBattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBattle();
            }
        });
    }
    /*private void setTextArea1(int diffe) {
        TextView textView1=(TextView)findViewById(R.id.textArea1);
        textView1.setText(""+diffe);
    }*/
    public void configBattle(PokeMon pkm,PokeMon ekm){
        Intent intent = getIntent();
        int diffe=intent.getIntExtra("diff",1);
        pkm.setHP(diffe*100);
        pkm.setName("pikapika");
        ekm.setHP(diffe*100);
        ekm.setName("diglett");
        TextView playa=(TextView)findViewById(R.id.playerName);
        playa.setText(pkm.name+"\n"+"HP: "+pkm.healthpoint);
        TextView enemy=(TextView)findViewById(R.id.enemyName);
        enemy.setText(ekm.name+"\n"+"HP: "+ekm.healthpoint);
    }
    public void startBattle(){
        ConstraintLayout battleLayout=(ConstraintLayout)findViewById(R.id.battleLayout);
        ConstraintLayout hubLayout=(ConstraintLayout)findViewById(R.id.hubLayout);
        battleLayout.setVisibility(View.VISIBLE);
        hubLayout.setVisibility(View.GONE);

    }
}
