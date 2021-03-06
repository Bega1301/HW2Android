package com.geektech.taskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    private EditText editTitle;
    private EditText editDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        editTitle = findViewById(R.id.editTitle);
        editDesc = findViewById(R.id.editDesc);
    }

    public void onClick(View view) {
        String title = editTitle.getText().toString().trim();
        String desc = editDesc.getText().toString().trim();

        if (editTitle.getText().toString().equals(" ") && editDesc.getText().toString().equals(" ")){
            Toast.makeText(getApplicationContext(), " Вы не ввели данные!",
                    Toast.LENGTH_SHORT).show();
        }else {
        Intent intent = new Intent();
        Task task = new Task(title, desc);
        App.getDatabase().taskDao().insert(task);
        intent.putExtra("task", task);
        setResult(RESULT_OK, intent);
        finish();}
    }
}
