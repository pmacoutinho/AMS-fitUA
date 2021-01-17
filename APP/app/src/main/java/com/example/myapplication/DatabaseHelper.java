package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "fitua_db.db";
    private static final int DATABASE_VERSION = 1;
    private final Context context;
    SQLiteDatabase db;

    private static final String DATABASE_PATH = "/data/data/com.example.myapplication/databases/";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        createDb();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public void createDb() {
        boolean dbExist = checkDbExist();

        if (!dbExist) {
            this.getReadableDatabase();
            copyDatabase();
        }
    }

    private boolean checkDbExist(){
        SQLiteDatabase sqLiteDatabase = null;

        try{
            String path = DATABASE_PATH + DATABASE_NAME;
            sqLiteDatabase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        } catch (Exception ex){}

        if(sqLiteDatabase != null){
            sqLiteDatabase.close();
            return true;
        }

        return false;
    }

    private void copyDatabase(){
        try {
            InputStream inputStream = context.getAssets().open(DATABASE_NAME);

            String outFileName = DATABASE_PATH + DATABASE_NAME;

            OutputStream outputStream = new FileOutputStream(outFileName);

            byte[] b = new byte[1024];
            int length;

            while ((length = inputStream.read(b)) > 0){
                outputStream.write(b, 0, length);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private SQLiteDatabase openDatabase() {
        String path = DATABASE_PATH + DATABASE_NAME;
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        return db;
    }

    public void close() {
        if (db != null) {
            db.close();
        }
    }

    public int checkUserExist(String username, String password) {
        db = openDatabase();
        int userType = -1;

        Cursor cursor = db.query("user", new String[]{"username"}, "pt = ? AND username = ? AND password = ?",
                new String[] {"1", username, password}, null, null, null);
        int count = cursor.getCount();

        if (count <= 0) {
            cursor = db.query("user", new String[]{"username"}, "username = ? AND password = ?",
                    new String[] {username, password}, null, null, null);
            count = cursor.getCount();

            if (count > 0)
                userType = 0;
        } else
            userType = 1;

        cursor.close();
        close();

        return userType;
    }

    public boolean insertTreinos(int tipoTreino, int id, int casa, int dificuldade, String area, String exercicios) {
        /* --- VARIAVEIS DE ENTRADA ----|
        | tipoTreino:                   |
        |       if = 0 -> GINASIO       |
        |       if = 1 -> CASA          |
        |------------------------------*/
        db = openDatabase();
        ContentValues contentValues = new ContentValues();
        String table_name;

        if (tipoTreino == 0)
            table_name = "treinos_ginasio";
        else
            table_name = "treinos_casa";

        contentValues.put("id", id);
        contentValues.put("casa", casa);
        contentValues.put("dificuldade", dificuldade);
        contentValues.put("area", area);
        contentValues.put("exercicios", exercicios);

        long result = db.insert(table_name, null, contentValues);

        return result != -1;
    }

    public int deleteTreinos(int tipoTreino, String id){
        // Ver a funcao insertTreinos para descricao das VARIAVEIS DE ENTRADA
        db = this.getReadableDatabase();
        String table_name;

        if (tipoTreino == 0)
            table_name = "treinos_ginasio";
        else
            table_name = "treinos_casa";

        return db.delete(table_name, "id = ?", new String[] {id});
    }

    public boolean insertEstatistica(int tipoExercicio, String s1, String s2, String s3) {
        /* --- VARIAVEIS DE ENTRADA ----|
        | tipoExercicio:                |
        |       if = 0 -> CARDIO        |
        |       if = 1 -> PESOS         |
        |...............................|
        | s1 = titulo                   |
        | s2 = calorias/peso            |
        | s3 = tempo                    |
        |------------------------------*/
        db = openDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("tipoExercicio", tipoExercicio);
        contentValues.put("titulo", s1);
        contentValues.put("calorias_peso", s2);
        contentValues.put("tempo", s3);

        long result = db.insert("estatisticas", null, contentValues);
        return result != -1;
    }

    public int updateEstatisticas(String id, String s1, String s2, String s3){
        // Ver a funcao insertEstatistica para descricao das VARIAVEIS DE ENTRADA
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("titulo", s1);
        contentValues.put("calorias_peso", s2);
        contentValues.put("tempo", s3);

        return db.update("estatisticas", contentValues, "id = ?", new String[] {id});
    }

    public int deleteEstatisticas(String id){
        // Ver a funcao insertEstatistica para descricao das VARIAVEIS DE ENTRADA
        db = this.getReadableDatabase();
        return db.delete("estatisticas", "id = ?", new String[] {id});
    }

    public Cursor readAllData(String tableName){
        String query = "SELECT * FROM " + tableName;
        db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null)
            cursor = db.rawQuery(query, null);

        return cursor;
    }
}
