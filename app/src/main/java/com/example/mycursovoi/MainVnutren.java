package com.example.mycursovoi;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.mycursovoi.MainTorec.DanHPU;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainVnutren extends AppCompatActivity {
    ProgramHPU programa_CHPU=null;
    Model_Vhod_Dan dan=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_vnutren);
    }
    public void clik_Glavnay(View view)
    {
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void clik_CPU(View view){
        dan=new Model_Vhod_Dan();


        TextView[]dan1=new TextView[6];
        dan1[0]=findViewById(R.id.editTextNumber_D);
        dan1[1]=findViewById(R.id.editTextNumber_Pripusk);
        dan1[2]=findViewById(R.id.editTextNumber_L_OB);
        dan1[3]=findViewById(R.id.editTextNumber_T);
        dan1[4]=findViewById(R.id.editTextNumber_T_Korek);
        dan1[5]=findViewById(R.id.editTextNumber_ANG);
        dan.setANG(0);
        if (dan1[0].getText().toString().matches("") || dan1[1].getText().toString().matches("") || dan1[2].getText().toString().matches("") || dan1[3].getText().toString().matches("")|| dan1[4].getText().toString().matches(""))
        {
            TextView text=findViewById(R.id.textView3);

            text.setText("Все поля кроме ANG обезательны для заполнения !!!!!!!!!");

        }
        else
        {

            dan.setD_Det(Float.parseFloat(dan1[0].getText().toString()));
            dan.setPripusk(Float.parseFloat(dan1[1].getText().toString()));
            dan.setL_Obrabotka(Float.parseFloat(dan1[2].getText().toString()));
            dan.setT_Instrument(dan1[3].getText().toString());
            dan.setH_Instrument(dan1[4].getText().toString());
            if(dan1[5].getText().toString().matches(""))
            {
                dan.setANG(0);
            }
            else {
                dan.setANG(Float.parseFloat(dan1[5].getText().toString()));
            }
            TorecFunkhin(dan.getD_Det());

            Intent intent =new Intent(this, MainVivodCHPU.class);
            startActivity(intent);

        }

    }
    public void TorecFunkhin(float D)
    {
        programa_CHPU=new ProgramHPU();
        if(D>1400)
        {
            DanHPU= programa_CHPU.VN_D_Obra(dan,12,2);
            programa_CHPU.setStrokHPU(DanHPU);
        }
        else
        {
            DanHPU= programa_CHPU.VN_D_Obra(dan,16,3);
        }




    }
}