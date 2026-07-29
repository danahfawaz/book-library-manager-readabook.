package com.readabook.app;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class RemoveDialog extends DialogFragment {

    public interface Action { void run(); }

    private final Action onRemove;

    public RemoveDialog(Action onRemove) { this.onRemove = onRemove; }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle state) {
        return new AlertDialog.Builder(requireActivity())
                .setTitle("Remove book")
                .setMessage("Remove this book from your shelf?")
                .setPositiveButton("Remove", (d, w) -> onRemove.run())
                .setNegativeButton("Cancel", null)
                .create();
    }
}
