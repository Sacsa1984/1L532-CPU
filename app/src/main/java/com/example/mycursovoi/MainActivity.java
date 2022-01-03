package com.example.mycursovoi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        public void onClik_Torec(View view)
        {   Intent intent =new Intent(this, MainTorec.class);
        startActivity(intent);    }

        public void onClik_Vnutren(View view)
        { Intent intent =new Intent(this, MainVnutren.class);
            startActivity(intent);

        }
        public  void onClik_Narug(View view )
    {
        Intent intent =new Intent(this, MainNarug.class);
        startActivity(intent);
    }


}