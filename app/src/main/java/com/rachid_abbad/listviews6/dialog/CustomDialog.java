package com.rachid_abbad.listviews6.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.rachid_abbad.listviews6.R;
import com.rachid_abbad.listviews6.activities.MainActivity;
import com.rachid_abbad.listviews6.classes.Pilote;

import java.util.List;

public class CustomDialog extends Dialog {

    EditText matricule, name;
    Button btn_edit, btn_cancel;
    List<Pilote> list;
    int pos;

    public CustomDialog(@NonNull Context context, int themeResId, int pos, List<Pilote> list) {
        super(context, themeResId);
        this.pos = pos;
        this.list = list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);


        matricule = findViewById(R.id.matriculeDialog);
        name = findViewById(R.id.nameDialog);
        btn_edit = findViewById(R.id.btn_add_dialog);
        btn_cancel = findViewById(R.id.btn_delete_dialog);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(this.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;

        getWindow().setAttributes(lp);

        matricule.setText(list.get(pos).getMatricule());
        name.setText(list.get(pos).getName());

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.get(pos).setName(name.getText().toString());
                list.get(pos).setMatricule(matricule.getText().toString());
                CustomDialog.this.dismiss();
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog.this.dismiss();
            }
        });

    }
}
