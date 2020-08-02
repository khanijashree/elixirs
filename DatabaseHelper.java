package com.project.sandesh.encrypteraes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

public DatabaseHelper(Context context ) {
// TODO Auto-generated constructor stub
super(context,  DATABASE_NAME, null, DATABASE_VERSION);
}

String password;
private static final int DATABASE_VERSION = 1;
private static final String DATABASE_NAME = "Mydatabase.db";
private static final String TABLE_REGISTER= "user";
public static final String KEY_ID = "id";
public static final String KEY_MOB = "mob";
public static final String USER_NAME = "name";
public static final String KEY_CIP = "sec";
public static final String KEY_PASSWORD = "password";




    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_REGISTER + "("
                   + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                   + USER_NAME + " TEXT,"
                   + KEY_PASSWORD + " TEXT,"
                   + KEY_MOB + " TEXT,"
                   + KEY_CIP + " TEXT"
                   + ")" ;


    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTER);

        onCreate(db);
        }

    String addregister(RegisterData registerdata)
        {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(USER_NAME, registerdata.getname() );
            values.put(KEY_PASSWORD, registerdata.getPassword() );
            values.put(KEY_MOB, registerdata.getmob()  );
            values.put(KEY_CIP, registerdata.getsec()  );

            db.insert(TABLE_REGISTER, null, values);
            db.close();
            return "success";
        }

    public int getRowCount() {
        Log.d("check", " inside rowcount");
        String countQuery = " SELECT * FROM " + TABLE_REGISTER ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery(countQuery,null);
        int count  = cur.getCount();
        cur.close();
        return count;
    }

    public String[] validate(String str){
        String[] arr = new String[10];

        SQLiteDatabase db = getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_REGISTER + " WHERE name = '" +str+ "'";
        Cursor cursor = db.rawQuery(selectQuery, null);

        int n = cursor.getCount();

        if ( cursor.moveToFirst()  && n != 0  ) {

                arr[0] = cursor.getString(1);
                arr[1] = cursor.getString(2);

        }
        else
            arr[0] = "false";
        cursor.close();
        db.close();
        return arr;
    }


    String getregister(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_REGISTER,null,  "email_id=?",new String[]{username},null, null, null, null);

        if(cursor.getCount()<1){
                       cursor.close();
                       return "Not Exist";
        }
        else if(cursor.getCount()>=1 && cursor.moveToFirst()){

                        password = cursor.getString(cursor.getColumnIndex(KEY_PASSWORD));
                       cursor.close();

        }
        return password;
    }

    public String getDatabaseName() {
    return DATABASE_NAME;
    }

    public static String getKeyId() {
    return KEY_ID;
    }

    public static String getTableContacts() {
    return TABLE_REGISTER;
    }

    public static int getDatabaseVersion() {
    return DATABASE_VERSION;
    }

}