package com.yusuf.filmbilgileri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread mSplashThread;
        mSplashThread = new Thread(){
            @Override public void run()
            {
                try {

                    synchronized(this){
                        wait(2000);//2 saniye sonra geçiş yapılacak
                    }
                }catch(InterruptedException ex){

                }
                finally{

                    Intent i=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        };

        mSplashThread.start();
    }
}
