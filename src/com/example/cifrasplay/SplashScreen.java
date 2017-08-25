package com.example.cifrasplay;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;

public class SplashScreen extends Activity {
	
	protected boolean _active = true;
	//A animação durará 3 s.
    protected int _splashTime = 3000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
		//Cor da Barra superior
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#218E29")));
        // Criando a thread para iniciar a SplashScreen.
        Thread splashTread = new Thread() {

            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (_active && (waited < _splashTime)) {
                        sleep(100);
                        if (_active) {
                            waited += 100;
                        }
                    }
                } catch (InterruptedException e) {

                } finally {
                    //finish();
                    Intent menu = new Intent (SplashScreen.this, MenuPrincipal.class);
                    startActivity(menu);
                    
                }
            }
        };
        splashTread.start();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            _active = false;
        }
        return true;
    }

}
