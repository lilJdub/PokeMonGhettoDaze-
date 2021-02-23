package com.example.pokemongettodaze;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class fightUFaggot extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_u_faggot);
        Intent intent = getIntent();
        int diffe=intent.getIntExtra("diff",1);
        setTextArea1(diffe);
    }
    private void setTextArea1(int diffe) {
        TextView textView1=(TextView)findViewById(R.id.textArea1);
        textView1.setText(""+diffe);
    }

}
