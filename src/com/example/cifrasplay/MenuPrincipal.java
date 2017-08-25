package com.example.cifrasplay;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MenuPrincipal extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
		//Cor da Barra superior
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#218E29")));
        ImageButton btnTocar = (ImageButton) findViewById(R.id.btnTocar);
        ImageButton btnPesquisar = (ImageButton) findViewById(R.id.btnPesquisar);
        ImageButton btnAfinador = (ImageButton) findViewById(R.id.btnAfinador);
        ImageButton btnConfiguracao = (ImageButton) findViewById(R.id.btnConfiguracao);
                
        btnTocar.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent Tocar = new Intent(MenuPrincipal.this, Tocar.class);
				startActivity(Tocar);
				
			}
		});
        btnPesquisar.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent Pesquisar = new Intent(MenuPrincipal.this, Pesquisar.class);
				startActivity(Pesquisar);
			}
		});
        btnAfinador.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Toast.makeText(MenuPrincipal.this, "Esta função esta em desenvolvimento. Aguarde as próximas atualizações.", Toast.LENGTH_LONG).show();
			}
		});
        btnConfiguracao.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent Configuracao = new Intent(MenuPrincipal.this, Configuracao.class);
				startActivity(Configuracao);
			}
		});
        
    }

}