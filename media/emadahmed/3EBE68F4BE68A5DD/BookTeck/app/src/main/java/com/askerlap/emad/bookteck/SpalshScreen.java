package com.askerlap.emad.bookteck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SpalshScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);
        assert getSupportActionBar() !=null;
        getSupportActionBar().hide();
        Thread timer= new Thread(){
            public void run(){
                try{
                    sleep(3000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(SpalshScreen.this,MainActivity.class));
                }
            }
        };
        timer.start();
    }
}
