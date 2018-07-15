package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.data.PetContract.PetEntry;

public class PetCursorAdapter extends CursorAdapter {


    public PetCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView name = view.findViewById(R.id.name);
        TextView summary = view.findViewById(R.id.summary);

        String nameString = cursor.getString(cursor.getColumnIndex(PetEntry.COLUMN_PET_NAME));
        String summaryString = cursor.getString(cursor.getColumnIndex(PetEntry.COLUMN_PET_BREED));

        if(TextUtils.isEmpty(summaryString)){
            summaryString = context.getString(R.string.unknown_breed);
        }

        name.setText(nameString);
        summary.setText(summaryString);
    }
}
