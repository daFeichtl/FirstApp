package net.htlgkr.sfeichtlbauer.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText zaehl = findViewById(R.id.zaehler);
        EditText nenn = findViewById(R.id.nenner);
        int zaehler = Integer.parseInt(zaehl.getText().toString());
        int nenner = Integer.parseInt(nenn.getText().toString());
        int ggt = getGGT(zaehler,nenner);
        int num1 = zaehler/ggt;
        int num2 = nenner/ggt;
        zaehl.setText(num1+"");
        nenn.setText(num2+"");
    }
    public int getGGT(int a, int b){
        int tmp;
        do {
            if (a<b){
                tmp=a;
                a=b;
                b=tmp;
            }
            tmp = a%b;
            if(tmp != 0){
                a=b;
                b=tmp;
            }
        }while(tmp != 0);
        return b;
    }
}