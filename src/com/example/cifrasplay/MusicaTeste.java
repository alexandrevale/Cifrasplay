package com.example.cifrasplay;


import android.R.string;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.FrameLayout.LayoutParams;

public class MusicaTeste extends Activity{
		public boolean active = true;
	    public int time = 600000;
	    public int rolagem = 1;
	    public int guarda_velocidade = 1;
	    public int fonte = 14;
	    public int waited = 0;
	    public String cifra = "";
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_musica_teste);
			Intent intent = getIntent();
			Bundle params = intent.getExtras();
			if (params!=null) { 

			String id = params.getString("id") ;
			 
			
			NotesDao dao = new NotesDao(MusicaTeste.this);
			dao.open();
			cifra = dao.getCifraByID(id);
			
			}


			
			
			//Cor da Barra superior
	        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#218E29")));
	        getActionBar().setTitle("Cifra");
			
			final ScrollView sv = new ScrollView(this);
			FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			sv.setLayoutParams(lp);
						
			LinearLayout ll = new LinearLayout(this);
			ll.setOrientation(LinearLayout.VERTICAL);
			LinearLayout.LayoutParams lpll = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			ll.setLayoutParams(lpll);
			sv.addView(ll);
					//
			final TextView txtCifra = new TextView(this);
			//Inicio da cor do bg da textview
			Resources res = getResources();
			int color = res.getColor(R.color.Gray89);
			txtCifra.setBackgroundColor(color);
			//Fim da cor do bg
			//txtCifra.setText("Tom: <b>C\n<\b>Intro 2x: <b>Dm  C  Am7<\b>\n        Dm  C\nUma menina me ensinou\n      Am7\nQuase\ntudo que eu sei\n                  Dm\nEra quase escravidão\n    C                       Am7\nMas ela me tratava como um rei\n                   Dm   C\nEla fazia muitos planos\n                     Am7\nEu só queria estar ali\n                  Dm\nSempre ao lado dela\n        C         Am7\nEu não tinha onde ir\n                     Dm   C\nMas, egoísta que eu sou,\n                  Am7\nMe esqueci de ajudar\n                      Dm  C\nA ela como ela me ajudou\n                    Am7\nE não quis me separar\n                      Dm\nEla também estava perdida\n      C                          Am7\nE por isso se agarrava a mim também\n                   Dm  C\nE eu me agarrava a ela\n                              Am7\nPorque eu não tinha mais ninguém\n                     Dm          C           Am7\nE eu dizia: Ainda é cedo, cedo, cedo, cedo, cedo                      Dm          C           Am7\nAh eu dizia: Ainda é cedo, cedo, cedo, cedo, cedo\n( Dm  C  Am7 )\n                  Dm  C\nSei que ela\n terminou\n                  Am7\nO que eu não comecei\n                   Dm  C\nE o que ela descobriu");
			txtCifra.setText(Html.fromHtml(cifra));
			
			txtCifra.setPadding(10,10, 10, 10);
			//txtCifra.setBackgroundColor(0xFF909090);
			ll.addView(txtCifra);
			
			/*final TextView txtCifra0 = new TextView(this);
			final TextView txtCifra1 = new TextView(this);
			final TextView txtCifra2 = new TextView(this);
			final TextView txtCifra3 = new TextView(this);
			final TextView txtCifra4 = new TextView(this);
			final TextView txtCifra5 = new TextView(this);
			final TextView txtCifra6 = new TextView(this);
			final TextView txtCifra7 = new TextView(this);
			final TextView txtCifra8 = new TextView(this);
			final TextView txtCifra9 = new TextView(this);
			final TextView txtCifra10 = new TextView(this);
			final TextView txtCifra11 = new TextView(this);
			final TextView txtCifra12 = new TextView(this);
			final TextView txtCifra13 = new TextView(this);
			final TextView txtCifra14 = new TextView(this);
			final TextView txtCifra15 = new TextView(this);
			final TextView txtCifra16 = new TextView(this);
			final TextView txtCifra17 = new TextView(this);
			final TextView txtCifra18 = new TextView(this);
			final TextView txtCifra19 = new TextView(this);
			final TextView txtCifra20 = new TextView(this);
			final TextView txtCifra21 = new TextView(this);
			final TextView txtCifra22 = new TextView(this);
			final TextView txtCifra23 = new TextView(this);
			final TextView txtCifra24 = new TextView(this);
			final TextView txtCifra25 = new TextView(this);
			final TextView txtCifra26 = new TextView(this);
			final TextView txtCifra27 = new TextView(this);
			final TextView txtCifra28 = new TextView(this);
			final TextView txtCifra29 = new TextView(this);
			final TextView txtCifra30 = new TextView(this);
			
			
			//txtCifra1.setText("Intro 2x: Dm  C  Am7\n                    Dm  C\nUma menina me ensinou\n               Am7\nQuase\ntudo que eu sei\n                  Dm\nEra quase escravidão\n    C                       Am7\nMas ela me tratava como um rei\n                   Dm   C\nEla fazia muitos planos\n                     Am7\nEu só queria estar ali\n                  Dm\nSempre ao lado dela\n        C         Am7\nEu não tinha onde ir\n                     Dm   C\nMas, egoísta que eu sou,\n                  Am7\nMe esqueci de ajudar\n                      Dm  C\nA ela como ela me ajudou\n                    Am7\nE não quis me separar\n                      Dm\nEla também estava perdida\n      C                          Am7\nE por isso se agarrava a mim também\n                   Dm  C\nE eu me agarrava a ela\n                              Am7\nPorque eu não tinha mais ninguém\n                     Dm          C           Am7\nE eu dizia: Ainda é cedo, cedo, cedo, cedo, cedo                      Dm          C           Am7\nAh eu dizia: Ainda é cedo, cedo, cedo, cedo, cedo\n( Dm  C  Am7 )\n                  Dm  C\nSei que ela\n terminou\n                  Am7\nO que eu não comecei\n                   Dm  C\nE o que ela descobriu");
			
			txtCifra0.setText("Tom: C");
			txtCifra0.setTextColor(Color.BLUE);
			
			txtCifra1.setText("Intro 2x: Dm  C  Am7");
			txtCifra1.setTextColor(Color.BLUE);
			
			txtCifra2.setText("                    Dm  C");
			txtCifra2.setTextColor(Color.BLUE);
			
			txtCifra3.setText("Uma menina me ensinou");
			
			txtCifra4.setText("               Am7");			
			txtCifra4.setTextColor(Color.BLUE);
			
			txtCifra5.setText("Quase tudo que eu sei");
			
			txtCifra6.setText("                  Dm");			
			txtCifra6.setTextColor(Color.BLUE);
			
			txtCifra7.setText("Era quase escravidão");			
			
			txtCifra8.setText("    C                       Am7");			
			txtCifra8.setTextColor(Color.BLUE);
			
			txtCifra9.setText("Mas ela me tratava como um rei");			
			
			txtCifra10.setText("                   Dm   C");
			txtCifra10.setTextColor(Color.BLUE);
			
			txtCifra11.setText("Ela fazia muitos plano");
			
			txtCifra12.setText("                     Am7");
			txtCifra12.setTextColor(Color.BLUE);
			
			txtCifra13.setText("Eu só queria estar ali");
			
			txtCifra14.setText("                  Dm");
			txtCifra14.setTextColor(Color.BLUE);
			
			txtCifra15.setText("Sempre ao lado dela");
			
			txtCifra16.setText("        C         Am7");
			txtCifra16.setTextColor(Color.BLUE);
			
			txtCifra17.setText("Eu não tinha onde ir");			
			
			txtCifra18.setText("                     Dm   C");			
			txtCifra18.setTextColor(Color.BLUE);
			
			txtCifra19.setText("Mas, egoísta que eu sou,");			
			
			txtCifra20.setText("                  Am7");			
			txtCifra20.setTextColor(Color.BLUE);
			
			txtCifra21.setText("Me esqueci de ajudar");
			
			txtCifra22.setText("                      Dm  C");			
			txtCifra22.setTextColor(Color.BLUE);
			
			txtCifra23.setText("A ela como ela me ajudou");
			
			txtCifra24.setText("                    Am7");
			txtCifra24.setTextColor(Color.BLUE);
			
			txtCifra25.setText("E não quis me separar");
			
			txtCifra26.setText("                      Dm");			
			txtCifra26.setTextColor(Color.BLUE);
			
			txtCifra27.setText("Ela também estava perdida");			
			
			txtCifra28.setText("      C                          Am7");			
			txtCifra28.setTextColor(Color.BLUE);
			
			txtCifra29.setText("E por isso se agarrava a mim também");
			
			txtCifra30.setText("                   Dm  C");			
			txtCifra30.setTextColor(Color.BLUE);
			
			ll.addView(txtCifra0);
			ll.addView(txtCifra1);
			ll.addView(txtCifra2);
			ll.addView(txtCifra3);
			ll.addView(txtCifra4);
			ll.addView(txtCifra5);
			ll.addView(txtCifra6);
			ll.addView(txtCifra7);
			ll.addView(txtCifra8);
			ll.addView(txtCifra9);
			ll.addView(txtCifra10);
			ll.addView(txtCifra11);
			ll.addView(txtCifra12);
			ll.addView(txtCifra13);
			ll.addView(txtCifra14);
			ll.addView(txtCifra15);
			ll.addView(txtCifra16);
			ll.addView(txtCifra17);
			ll.addView(txtCifra18);
			ll.addView(txtCifra19);
			ll.addView(txtCifra20);
			ll.addView(txtCifra21);
			ll.addView(txtCifra22);
			ll.addView(txtCifra23);
			ll.addView(txtCifra24);
			ll.addView(txtCifra25);
			ll.addView(txtCifra26);
			ll.addView(txtCifra27);
			ll.addView(txtCifra28);
			ll.addView(txtCifra29);
			ll.addView(txtCifra30);*/
			
			 Thread splashTread = new Thread() {

		            @Override
		            public void run() {
		                try {
		                    while (active && (waited < time)) {
		                        sleep(100);
		                        if (active) {
		                            waited += 100;
		                            sv.post(new Runnable() { 			
		                    	        public void run() { 
		                    	        	sv.scrollBy(0, 0+rolagem);
		                    	        	txtCifra.setTextSize(fonte);
		                    	        	/*txtCifra1.setTextSize(fonte);
		                    	        	txtCifra3.setTextSize(fonte);
		                    	        	txtCifra4.setTextSize(fonte);
		                    	        	txtCifra5.setTextSize(fonte);
		                    	        	txtCifra6.setTextSize(fonte);
		                    	        	txtCifra7.setTextSize(fonte);
		                    	        	txtCifra8.setTextSize(fonte);
		                    	        	txtCifra9.setTextSize(fonte);*/	
		                    	        } 
		                    		});
		                        }
		                    }
		                } catch (InterruptedException e) {

		                } finally {
		                    //finish();
		                }
		            }
		        };
		        setContentView(sv);
		        splashTread.start();
		
		        
		//A rolagem pausa e reinicia apenas com um click na tela
		
		/*public boolean onTouch(View v, MotionEvent event) {
		              	if(rolagem>0){
							rolagem=0;
				        	waited=0;
						}else{
							rolagem=guarda_velocidade;
				        	waited=0;
						}
		            
		            return true;
		        }*/				
		        
		txtCifra.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				if(rolagem>0){
					rolagem=0;
		        	waited=0;
				}else{
					rolagem=guarda_velocidade;
		        	waited=0;
				}
			}
		});
}
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        getMenuInflater().inflate(R.menu.activity_musica_teste, menu);
	        return true;
	    }
	        
	        public boolean onOptionsItemSelected(MenuItem item) {
	            
	        switch (item.getItemId()) {
	        case R.id.maior_velocidade:
	        	if(rolagem <=5){
	        		rolagem++;
	        		guarda_velocidade=rolagem;
	        	}	            
	            return true;
	        case R.id.menor_velocidade:
	        	if(rolagem >1){
	        		rolagem--;
	        		guarda_velocidade=rolagem;
	        	}
	            return true;
	        case R.id.maior_fonte:
	        	if(fonte <=24){
	        		fonte= fonte + 2;
	        	}	        	
	            return true;
	        case R.id.menor_fonte:
	        	if(fonte >10){
	        		fonte= fonte - 2;
	        	}
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	        }
	    }
}
