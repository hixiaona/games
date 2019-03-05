package com.example.games;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static android.os.Process.killProcess;


public class MainActivity extends AppCompatActivity {

    Button btn_play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_play=findViewById(R.id.btn_play);

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Intent mIntent = new Intent(getBaseContext(), playing.class);
                // startActivity(mIntent);
                startActivity(new Intent(getBaseContext(), playing.class));
            }
        });
        findViewById(R.id.btn_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.exit(0);
            }
        });

    }
}
