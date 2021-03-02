package com.example.pokemongettodaze;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

import androidx.constraintlayout.widget.ConstraintLayout;

public class fightUFaggot<pokeMon> extends Activity {
    int dif;
    private PokeMon yourPokeMon= new PokeMon("",dif*100);;
    private PokeMon enemyPokeMon= new PokeMon("",dif*100);;
    String bt="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_u_faggot);
        configBattle(yourPokeMon,enemyPokeMon);
        Button startBattle=(Button)findViewById(R.id.battlestart);
        startBattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBattle();
            }
        });
    }

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
        bt="Start Battle!"+"\n";
        TextView tv=(TextView) findViewById(R.id.battleText);
        tv.setText(bt);
        Button atk=(Button)findViewById(R.id.attack);
        atk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attack();
            }
        });

    }
    private void attack()  {
        int pkmHp=enemyPokeMon.getHP();
        int enemyNewHp=pkmHp-10;
        TextView tv=(TextView) findViewById(R.id.battleText);
        if (enemyNewHp>0){
            enemyPokeMon.setHP(enemyNewHp);
            bt="你打出10點傷害"+"\n"+"對手剩下"+enemyNewHp+"點體力";
            tv.setText(bt);
            opponentAttack();
        }
        else{
            bt="對手體力不支!"+"\n"+"勝利";
            tv.setText(bt);
        }

    }
    private void opponentAttack()  {
        Random rand = new Random();
        TextView tv=(TextView) findViewById(R.id.battleText);
        int pkmHp=yourPokeMon.getHP();
        int enemyattack=rand.nextInt(16);
        int yourNewHp=pkmHp-enemyattack;
        if (yourNewHp>0){
            yourPokeMon.setHP(yourNewHp);
            bt+="\n"+"對手造成"+enemyattack+"點傷害,"+"\n"+"你剩下"+yourNewHp+"點體力";
            tv.setText(bt);
        }
        else{
            bt="你體力不支!"+"\n"+"敗北";
            tv.setText(bt);
        }
    }
    private void finishGame(){

    }

}
