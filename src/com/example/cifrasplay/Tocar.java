package com.example.cifrasplay;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
 
public class Tocar extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tocar);
		//Cor da Barra superior
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#218E29")));
        
        String[] musicas = new String[]{"Ainda é Cedo"};
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, musicas);
        
        ListView lvMusicas = (ListView) findViewById(R.id.lvMusicas);
        lvMusicas.setAdapter(adapter);
        lvMusicas.setOnItemClickListener (carregarMusicas(this));   
        
    }
    
	public OnItemClickListener carregarMusicas(final Context context){
		return (new OnItemClickListener() {
			
			public void onItemClick(AdapterView<?> av, View v, int position, long id) {
				Intent intent;
				
				switch(position){
				case 0:
					intent = new Intent(context, MusicaTeste.class);
					Bundle params = new Bundle();
					params.putString("id", String.valueOf(id));
					intent.putExtras(params);
					startActivity(intent);
					break;
				}
			}
		});
    	
    }

}
