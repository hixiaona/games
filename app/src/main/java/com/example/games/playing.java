package com.example.games;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class playing extends AppCompatActivity {
    ImageView iv1,iv2,iv3,iv4;
    TextView  tv1,tv2,tv3;
    private int[] images = {R.drawable.bear, R.drawable.cat,  R.drawable.elephant,R.drawable.fish,R.drawable.giraffe,R.drawable.honey,R.drawable.hypo,R.drawable.kangaroo,R.drawable.leo,R.drawable.lion,R.drawable.pig,R.drawable.tiger,R.drawable.wolf};
    private String[] names = {"bear", "cat",  "elephant","fish","giraffe","honey","hypo","kangaroo","leo","lion","pig","tiger","wolf"};

    private int Goal=20;
    private int Score=0;
    private int Key=0;
    private int [] num = new int[4];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playing);
        tv3=findViewById(R.id.questions);
        tv1=findViewById(R.id.aiming);
        tv2=findViewById(R.id.goaling);
        iv1=findViewById(R.id.imageButton1);
        iv2=findViewById(R.id.imageButton2);
        iv3=findViewById(R.id.imageButton3);
        iv4=findViewById(R.id.imageButton4);
        play();

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(Key==num[0]){
                        Score++;
                        if(Score>=20){
                            startActivity(new Intent(getBaseContext(), pass.class));
                        }
                        play();
                    }
                    else{

                        startActivity(new Intent(getBaseContext(), failed.class));
                    }
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Key==num[1]){
                    Score++;
                    if(Score>=20){
                        startActivity(new Intent(getBaseContext(), pass.class));
                    }
                    play();
                }
                else{
                    startActivity(new Intent(getBaseContext(), failed.class));
                }
            }
        });
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Key==num[2]){
                    Score++;
                    if(Score>=20){
                        startActivity(new Intent(getBaseContext(), pass.class));
                    }
                    play();
                }
                else{
                    startActivity(new Intent(getBaseContext(), failed.class));
                }
            }
        });
        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Key==num[3]){
                    Score++;
                    if(Score>=20){
                        startActivity(new Intent(getBaseContext(), pass.class));
                    }
                    play();
                }
                else{
                    startActivity(new Intent(getBaseContext(), failed.class));
                }
            }
        });

    }
    public void loadImagesNum() {

        for(int i=0;i<4;i++){
            num[i]= (int) (Math.random() * 13 );
        }
        check();
    }
    public void check() {

        if(num[0]==num[1]||num[0]==num[2]||num[0]==num[3]||num[1]==num[2]||num[1]==num[3]||num[2]==num[3]){
            loadImagesNum();
        }
    }
    public int loadImage(int k) {

        int m=k;

        return images[m];
    }

    public void play(){
        (tv1).setText(Goal+"");
        (tv2).setText(Integer.toString((Score)));
        num[0]=num[1];
        check();
        int []Picture = new int[4];


        for (int i = 0; i < 4; i++) {

            Picture[i] = loadImage(num[i]);
        }
        (iv1).setImageResource(Picture[0]);
        (iv2).setImageResource(Picture[1]);
        (iv3).setImageResource(Picture[2]);
        (iv4).setImageResource(Picture[3]);
        int key=(int) (Math.random() * 4);
        Key=num[key];
        tv3.setText("Click on the "+names[Key]);
    }
}
