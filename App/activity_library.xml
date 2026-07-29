package com.readabook.app;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BookInfoActivity extends AppCompatActivity {

    private int id;
    private ReadaBookDB db;
    private Spinner status;
    private EditText rating;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_book_info);

        db = new ReadaBookDB(this);
        id = getIntent().getIntExtra("id", -1);

        ((TextView) findViewById(R.id.infoTitle)).setText(getIntent().getStringExtra("title"));
        ((TextView) findViewById(R.id.infoAuthor)).setText("by " + getIntent().getStringExtra("author"));
        ((TextView) findViewById(R.id.infoCategory)).setText("Category: " + getIntent().getStringExtra("category"));

        status = findViewById(R.id.infoStatus);
        status.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, NewBookActivity.STATUSES));
        status.setSelection(indexOf(getIntent().getStringExtra("status")));

        rating = findViewById(R.id.infoRating);
        rating.setText(String.valueOf(getIntent().getIntExtra("rating", 0)));

        Button update = findViewById(R.id.updateButton);
        update.setOnClickListener(v -> {
            db.updateBook(id, status.getSelectedItem().toString(),
                    NewBookActivity.parseRating(rating.getText().toString().trim()));
            Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
            finish();
        });

        Button delete = findViewById(R.id.deleteButton);
        delete.setOnClickListener(v ->
                new RemoveDialog(() -> { db.deleteBook(id); finish(); })
                        .show(getSupportFragmentManager(), "remove"));
    }

    static int indexOf(String status) {
        for (int i = 0; i < NewBookActivity.STATUSES.length; i++)
            if (NewBookActivity.STATUSES[i].equals(status)) return i;
        return 0;
    }
}
