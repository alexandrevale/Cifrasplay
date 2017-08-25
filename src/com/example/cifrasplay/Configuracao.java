package com.example.cifrasplay;



//import com.example.sared.R;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;


public class Configuracao extends Activity {
	public static final String PREF_NOME = "MainActivityPreferences";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_configuracao);
		//Cor da Barra superior
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#218E29")));
        getActionBar().setTitle("Sobre o Cifras Play");
	}
	
	/**Chamado quando a Activity é encerrada.*/
    @Override
    protected void onStop(){
              
    }





}
