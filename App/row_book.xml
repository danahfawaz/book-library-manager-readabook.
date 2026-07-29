package com.readabook.app;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewBookActivity extends AppCompatActivity {

    static final String[] STATUSES = {"To Read", "Reading", "Finished"};

    private EditText title, author, category, rating;
    private Spinner status;
    private ReadaBookDB db;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_new_book);

        db = new ReadaBookDB(this);
        title = findViewById(R.id.newTitle);
        author = findViewById(R.id.newAuthor);
        category = findViewById(R.id.newCategory);
        rating = findViewById(R.id.newRating);
        status = findViewById(R.id.newStatus);
        status.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, STATUSES));

        Button save = findViewById(R.id.saveButton);
        save.setOnClickListener(v -> {
            String t = title.getText().toString().trim();
            String a = author.getText().toString().trim();
            if (t.isEmpty() || a.isEmpty()) {
                Toast.makeText(this, "Title and Author are required", Toast.LENGTH_SHORT).show();
                return;
            }
            db.addBook(t, a, category.getText().toString().trim(),
                    status.getSelectedItem().toString(),
                    parseRating(rating.getText().toString().trim()));
            Toast.makeText(this, "Added to shelf", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    static int parseRating(String s) {
        try {
            return Math.max(0, Math.min(5, Integer.parseInt(s)));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
