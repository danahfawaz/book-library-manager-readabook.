package com.readabook.app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShelfAdapter extends RecyclerView.Adapter<ShelfAdapter.Holder> {

    private final Context ctx;
    private List<BookEntry> data;

    public ShelfAdapter(Context ctx, List<BookEntry> data) {
        this.ctx = ctx;
        this.data = data;
    }

    public void refresh(List<BookEntry> newData) {
        this.data = newData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int type) {
        View row = LayoutInflater.from(ctx).inflate(R.layout.row_book, parent, false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder h, int pos) {
        BookEntry b = data.get(pos);
        h.title.setText(b.title);
        h.meta.setText(b.author + "  \u00B7  " + b.category);
        h.status.setText(b.status);
        h.stars.setText(starText(b.rating));

        h.itemView.setOnClickListener(v -> {
            Intent i = new Intent(ctx, BookInfoActivity.class);
            i.putExtra("id", b.id);
            i.putExtra("title", b.title);
            i.putExtra("author", b.author);
            i.putExtra("category", b.category);
            i.putExtra("status", b.status);
            i.putExtra("rating", b.rating);
            ctx.startActivity(i);
        });
    }

    static String starText(int rating) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) sb.append(i < rating ? '\u2605' : '\u2606');
        return sb.toString();
    }

    @Override
    public int getItemCount() { return data.size(); }

    static class Holder extends RecyclerView.ViewHolder {
        TextView title, meta, status, stars;
        Holder(@NonNull View v) {
            super(v);
            title = v.findViewById(R.id.rowTitle);
            meta = v.findViewById(R.id.rowMeta);
            status = v.findViewById(R.id.rowStatus);
            stars = v.findViewById(R.id.rowStars);
        }
    }
}
