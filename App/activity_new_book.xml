package com.readabook.app;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LibraryActivity extends AppCompatActivity {

    private ReadaBookDB db;
    private ShelfAdapter adapter;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_library);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        db = new ReadaBookDB(this);

        RecyclerView list = findViewById(R.id.shelfList);
        list.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ShelfAdapter(this, db.getShelf());
        list.setAdapter(adapter);

        EditText search = findViewById(R.id.searchBox);
        search.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int a, int b, int c) { }
            public void onTextChanged(CharSequence s, int a, int b, int c) {
                String q = s.toString().trim();
                adapter.refresh(q.isEmpty() ? db.getShelf() : db.searchShelf(q));
            }
            public void afterTextChanged(Editable s) { }
        });

        FloatingActionButton add = findViewById(R.id.addButton);
        add.setOnClickListener(v -> startActivity(new Intent(this, NewBookActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        // reload the shelf so added / updated / removed books show correctly
        adapter.refresh(db.getShelf());
    }
}
