package ca.qc.cvm.sqlite.model.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String DATBASE_NAME = "DB_des_scores";
	private static final int DATABASE_VERSION = 2;
	
	public DatabaseHelper(Context context) {
		super(context, DATBASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try {
			//création des tables
			db.execSQL("CREATE TABLE usager ("+
						" id INTEGER PRIMARY KEY AUTOINCREMENT,"+
						" nom  		TEXT," +
						" score INTEGER" +
						")" );
			
			Log.i("database helper", "DB créé");
		}
		catch (SQLException e) {
			Log.i("database helper", "DB crash");
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS usager");
		onCreate(db);
	}
}
