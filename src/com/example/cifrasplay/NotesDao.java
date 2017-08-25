package com.example.cifrasplay;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class NotesDao {
	private SQLiteOpenHelper  sqLiteOpenHelper;
	private SQLiteDatabase database;
	
	public NotesDao(Context context){
		
		sqLiteOpenHelper = new CustomSQLiteOpenHelper(context,1);
		
	}
	
	public void open() throws SQLException{
		database = sqLiteOpenHelper.getWritableDatabase();
	}
	
	public void close(){
		sqLiteOpenHelper.close();
	}
	
	public List<Note> getMusica(){
		List<Note> lista = new ArrayList<Note>();
		String nomeDaMusica = "";
		Cursor 	cursor = database.query("tb_musica", new String[] {"cd_letra",	"nm_letra",	"ds_letra"}, "nm_letra like ? ", new String[] {"%" + nomeDaMusica + "%"}, null, null, null);
		cursor.moveToFirst();
		
		while (!cursor.isAfterLast()){
			Note Note = new Note();
			Note.setId(cursor.getLong(0));
			Note.setNote(cursor.getString(1));
			lista.add(Note);
			cursor.moveToNext();
		}
		cursor.close();	

		return lista;		
		
	}
	
	public List<Note> getArtista(){
		List<Note> lista = new ArrayList<Note>();
		String nomeDoArtista = "";
		Cursor	cursor = database.query("tb_artista", new String[] {"cd_artista", "nm_artista"}, "nm_artista like ? ", new String[] {"%" + nomeDoArtista + "%"}, null, null, null);
		cursor.moveToFirst();
		
		while (!cursor.isAfterLast()){
			Note Note = new Note();
			Note.setId(cursor.getLong(0));
			Note.setNote(cursor.getString(1));
			lista.add(Note);
			cursor.moveToNext();
		}
		cursor.close();	

		return lista;		
		
	}
	
	public String getCifraByID(String id){
		String ret = "";		
		//Cursor	cursor = database.query("tb_musica", new String[] {"cd_letra",	"nm_letra",	"ds_letra"}, " cd_letra =  ", new String[] {id}, null, null, null);
		//Cursor	cursor = database.rawQuery("select * from tb_musica where cd_letra = " + id, new String[] {id} );
	
		Cursor	cursor = database.rawQuery("select * from tb_musica where cd_letra = " + id, null);
		cursor.moveToFirst();
		
		if (!cursor.isAfterLast()){
			ret = cursor.getString(2); // ou o equivalente a cifra ! 
		}
		cursor.close();	

		
		
		return ret;
	}

}

