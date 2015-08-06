package com.marcgrenier.asteroid.sqlite.model;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.marcgrenier.asteroid.sqlite.entity.Usager;
import com.marcgrenier.asteroid.sqlite.model.db.DatabaseHelper;

public class ModelUsager {
	private DatabaseHelper databaseHelper;
	private SQLiteDatabase database;

	public ModelUsager(Context ctx) {
		databaseHelper = new DatabaseHelper(ctx);
	}
	
	public void openDatabase() {
		database = databaseHelper.getWritableDatabase();
	}
	
	public void closeDatabase() {
		database.close();
	}

	public long addUsager(Usager user){
		ContentValues values = new ContentValues();
		values.put("nom", user.getNom());
		values.put("score", user.getScore());

		//passe pas le id pck il est automatiquement g�n�r� � cause du autoincrement		
		return database.insert("usager", null, values);
	}
	
	public List<Usager> fetchUsager(){
		List<Usager> userList = new ArrayList<Usager>();
		
		Cursor cursor = database.query(true, "usager", new String[]{"nom","score","id"}, 
									   null, null, null, null, "score DESC", null);
		
		if (cursor !=null && cursor.moveToFirst()){
			do
			{
				userList.add(new Usager(cursor.getString(0),cursor.getInt(1),cursor.getInt(2)));
			}
			while(cursor.moveToNext()); //aller au prochain si null quitter
		}
		
		
		return userList;		
	}
	
	public void deleteUsager(long line) {
		database.delete("usager", "id = " + line, null);
		}
	
}
