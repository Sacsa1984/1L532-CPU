package com.example.mycursovoi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainTorec extends AppCompatActivity {
    ProgramHPU programa_CHPU=null;
    public static String DanHPU=null;
    Model_Vhod_Dan dan=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_torec);
    }
    public void clik_Glavnay(View view)
    {
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void clik_CPU(View view){
      dan=new Model_Vhod_Dan();


      TextView []dan1=new TextView[5];
       dan1[0]=findViewById(R.id.editTextNumber_D);
        dan1[1]=findViewById(R.id.editTextNumber_Pripusk);
        dan1[2]=findViewById(R.id.editTextNumber_L_OB);
        dan1[3]=findViewById(R.id.editTextNumber_T);
        dan1[4]=findViewById(R.id.editTextNumber_T_Korek);

            if (dan1[0].getText().toString().matches("") || dan1[1].getText().toString().matches("") || dan1[2].getText().toString().matches("") || dan1[3].getText().toString().matches("")|| dan1[4].getText().toString().matches(""))
            {
                TextView text=findViewById(R.id.textView3);

                text.setText("Все поля обезательны для заполнения !!!!!!!!!");

            }
            else
            {

                dan.setD_Det(Float.parseFloat(dan1[0].getText().toString()));
                dan.setPripusk(Float.parseFloat(dan1[1].getText().toString()));
                dan.setL_Obrabotka(Float.parseFloat(dan1[2].getText().toString()));
                dan.setT_Instrument(dan1[3].getText().toString());
                dan.setH_Instrument(dan1[4].getText().toString());
                RadioButton radioButton_Lewo = findViewById(R.id.radioButton_Levo);
                RadioButton radioButton_Pravo = findViewById(R.id.radioButton_Pravo);

                if (radioButton_Lewo.isChecked() == true) {
                    dan.setNapravlenie(0);
                }
                if (radioButton_Pravo.isChecked() == true) {
                    dan.setNapravlenie(1);
                }
                TorecFunkhin(dan.getD_Det());

                Intent intent =new Intent(this, MainVivodCHPU.class);
                startActivity(intent);

            }

//      System.out.println(dan.getD_Det());
//        System.out.println(dan.getPripusk());
//        System.out.println(dan.getL_Obrabotka());
//        System.out.println(dan.getT_Instrument());
//        System.out.println(dan.getH_Instrument());
//        System.out.println(dan.getNapravlenie()+ "\n");

    }
    public void TorecFunkhin(float D)
    {
        programa_CHPU=new ProgramHPU();
        if(D>1400)
        {
            DanHPU= programa_CHPU.Torec(dan,12,2);
            programa_CHPU.setStrokHPU(DanHPU);
        }
        else
        {
            DanHPU= programa_CHPU.Torec(dan,16,3);
        }




    }

}