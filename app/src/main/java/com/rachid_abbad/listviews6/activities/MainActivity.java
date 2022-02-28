package com.rachid_abbad.listviews6.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.rachid_abbad.listviews6.R;
import com.rachid_abbad.listviews6.adapters.LvAdpater;
import com.rachid_abbad.listviews6.classes.Pilote;
import com.rachid_abbad.listviews6.dialog.CustomDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText matricule,name;
    Button btn_add,btn_delete;
    ListView lv;
    List<Pilote> list;
    LvAdpater adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matricule = findViewById(R.id.matricule);
        name = findViewById(R.id.name);
        btn_add = findViewById(R.id.btn_add);
        btn_delete = findViewById(R.id.btn_delete);
        lv = findViewById(R.id.lv);

        list = new ArrayList<Pilote>();
        adapter = new LvAdpater(this, R.layout.custom_layout,list);
        lv.setAdapter(adapter);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.add(new Pilote(matricule.getText().toString(),name.getText().toString()));
                adapter.notifyDataSetChanged();
                matricule.setText("");
                name.setText("");
                Toast.makeText(MainActivity.this,"Pilote Ajouté",Toast.LENGTH_LONG).show();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.clear();
                adapter.notifyDataSetChanged();
                matricule.setText("");
                name.setText("");
                Toast.makeText(MainActivity.this,"All deleted",Toast.LENGTH_LONG).show();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CustomDialog dialog = new CustomDialog(MainActivity.this,R.layout.custom_dialog,i,list);
                dialog.show();
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });




    }
}