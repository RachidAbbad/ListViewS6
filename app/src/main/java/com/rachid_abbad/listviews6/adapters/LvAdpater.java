package com.rachid_abbad.listviews6.adapters;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.rachid_abbad.listviews6.R;
import com.rachid_abbad.listviews6.classes.Pilote;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class LvAdpater extends ArrayAdapter<Pilote> {


    public List<Pilote> list;
    public Context context;
    public int res;

    public LvAdpater(@NonNull Context context, int resource,@NonNull List<Pilote> objects) {
        super(context, resource, objects);
        this.context = context;
        this.res = resource;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(res, parent, false);

        TextView matr = v.findViewById(R.id.matriculeTextView);
        TextView name = v.findViewById(R.id.nameTextView);

        matr.setText(list.get(position).getMatricule());
        name.setText(list.get(position).getName());

        return v;
    }
}
