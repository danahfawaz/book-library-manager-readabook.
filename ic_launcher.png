package com.readabook.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ReadaBookDB extends SQLiteOpenHelper {

    private static final String DB = "readabook.db";
    private static final int VERSION = 1;
    public static final String T = "shelf";

    public ReadaBookDB(Context c) { super(c, DB, null, VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + T + " (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT, author TEXT, category TEXT, " +
                "status TEXT, rating INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int o, int n) {
        db.execSQL("DROP TABLE IF EXISTS " + T);
        onCreate(db);
    }

    // INSERT
    public long addBook(String title, String author, String category, String status, int rating) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put("title", title); v.put("author", author); v.put("category", category);
        v.put("status", status); v.put("rating", rating);
        long id = db.insert(T, null, v);
        db.close();
        return id;
    }

    // UPDATE (reading status + rating)
    public void updateBook(int id, String status, int rating) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put("status", status); v.put("rating", rating);
        db.update(T, v, "_id = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    // DELETE
    public void deleteBook(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(T, "_id = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    // SELECT ALL
    public List<BookEntry> getShelf() {
        return run("SELECT * FROM " + T + " ORDER BY _id DESC", null);
    }

    // SEARCH
    public List<BookEntry> searchShelf(String keyword) {
        String like = "%" + keyword + "%";
        return run("SELECT * FROM " + T + " WHERE title LIKE ? OR author LIKE ? ORDER BY _id DESC",
                new String[]{like, like});
    }

    private List<BookEntry> run(String sql, String[] args) {
        List<BookEntry> out = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, args);
        while (c.moveToNext()) {
            out.add(new BookEntry(
                    c.getInt(c.getColumnIndexOrThrow("_id")),
                    c.getString(c.getColumnIndexOrThrow("title")),
                    c.getString(c.getColumnIndexOrThrow("author")),
                    c.getString(c.getColumnIndexOrThrow("category")),
                    c.getString(c.getColumnIndexOrThrow("status")),
                    c.getInt(c.getColumnIndexOrThrow("rating"))));
        }
        c.close();
        db.close();
        return out;
    }
}
