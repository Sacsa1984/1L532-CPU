package com.example.mycursovoi;

import static com.example.mycursovoi.MainTorec.DanHPU;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class MainVivodCHPU extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_vivod_chpu);

        TextView textView=findViewById(R.id.textView5);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(DanHPU);
    }
    public void clik_Glavnay(View view)
    {
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}