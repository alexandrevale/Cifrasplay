package com.example.cifrasplay;


import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Pesquisar extends Activity {
	ImageButton btnPesquisar;
	EditText txtPesquisa;
	ListView lstResultado;
	Spinner spPesquisar;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar);
		//Cor da Barra superior
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#218E29")));
        iniciar();
    }
    
	public void iniciar (){
    	txtPesquisa = (EditText) findViewById(R.id.txtPesquisa);
    	btnPesquisar = (ImageButton) findViewById(R.id.btnPesquisar);
    	lstResultado = (ListView) findViewById(R.id.lstResultado);
    	spPesquisar = (Spinner) findViewById(R.id.spPesquisar);

    	btnPesquisar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				btnPesquisarClick(v);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_pesquisar, menu);
        return true;
    }
    
    
    public void btnPesquisarClick(View v){
    	if(spPesquisar.getSelectedItemPosition() == 0){
    	NotesDao dao = new NotesDao(Pesquisar.this);
    	
    	dao.open();
    	
    	List<Note> notes = dao.getMusica(); 
    	ArrayAdapter <Note> adapter = new ArrayAdapter <Note>( this,android.R.layout.simple_list_item_1, notes);
    	lstResultado.setAdapter (adapter) ;
    	lstResultado.setOnItemClickListener(tocar(this));   
	
    	dao.close();
    	
    	lstResultado.setOnItemClickListener(tocar(this));   
    	}else{
    	NotesDao dao = new NotesDao(Pesquisar.this);
        	
    	dao.open();
    	
    	List<Note> notes = dao.getArtista(); 
    	ArrayAdapter <Note> adapter = new ArrayAdapter <Note>( this,android.R.layout.simple_list_item_1, notes);
    	lstResultado.setAdapter (adapter) ;
    	lstResultado.setOnItemClickListener(tocar(this));   
	
    	dao.close();
    	
    	lstResultado.setOnItemClickListener(tocar(this)); 	
    		
    	}

    }  
    
	public OnItemClickListener tocar(final Context context){
		return (new OnItemClickListener() {
			
			public void onItemClick(AdapterView<?> av, View v, int position, long id) {
				Intent intent;
				
				switch(position){
				case 0:
					intent = new Intent(context, MusicaTeste.class);
//Enviando parametros ! 
					Bundle params = new Bundle();
					params.putString("id", String.valueOf(id));
					intent.putExtras(params);
//////////////////////////////////////////////////					
					startActivity(intent);
					break;
				case 1:
					Toast.makeText(Pesquisar.this, "Esta música não esta liberada, aguarde as próximas atualizações.", Toast.LENGTH_SHORT).show();
					break;
				case 2:
					Toast.makeText(Pesquisar.this, "Esta música não esta liberada, aguarde as próximas atualizações.", Toast.LENGTH_LONG).show();
					break;
				case 3:
					Toast.makeText(Pesquisar.this, "Esta música não esta liberada, aguarde as próximas atualizações.", Toast.LENGTH_LONG).show();
					break;
				case 4:
					Toast.makeText(Pesquisar.this, "Esta música não esta liberada, aguarde as próximas atualizações.", Toast.LENGTH_LONG).show();					
					break;
				case 5:
					Toast.makeText(Pesquisar.this, "Esta música não esta liberada, aguarde as próximas atualizações.", Toast.LENGTH_LONG).show();
					break;
				case 6:
					Toast.makeText(Pesquisar.this, "Esta música não esta liberada, aguarde as próximas atualizações.", Toast.LENGTH_LONG).show();					
					break;
				case 7:
					Toast.makeText(Pesquisar.this, "Esta música não esta liberada, aguarde as próximas atualizações.", Toast.LENGTH_LONG).show();					
					break;
				case 8:
					Toast.makeText(Pesquisar.this, "Esta música não esta liberada, aguarde as próximas atualizações.", Toast.LENGTH_LONG).show();
					break;
				case 9:
					Toast.makeText(Pesquisar.this, "Esta música não esta liberada, aguarde as próximas atualizações.", Toast.LENGTH_LONG).show();
					break;
				case 10:
					Toast.makeText(Pesquisar.this, "Esta música não esta liberada, aguarde as próximas atualizações.", Toast.LENGTH_LONG).show();
					break;
				case 11:
					Toast.makeText(Pesquisar.this, "Esta música não esta liberada, aguarde as próximas atualizações.", Toast.LENGTH_LONG).show();
					break;
				case 12:
					Toast.makeText(Pesquisar.this, "Esta música não esta liberada, aguarde as próximas atualizações.", Toast.LENGTH_LONG).show();
					break;
				case 13:
					Toast.makeText(Pesquisar.this, "Esta música não esta liberada, aguarde as próximas atualizações.", Toast.LENGTH_LONG).show();
					break;
				}
			}
		});
    	
    }
}
