package com.example.cv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name= findViewById(R.id.name);
        final EditText age= findViewById(R.id.age);
        final EditText job= findViewById(R.id.job);
        final EditText phone= findViewById(R.id.phone);
        final EditText email= findViewById(R.id.email);

        RadioButton enterS= findViewById(R.id.enterS);
        RadioButton resetS= findViewById(R.id.resetS);

        enterS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("nameI", name.getText().toString());
                i.putExtra("ageI", age.getText().toString());
                i.putExtra("jobI", job.getText().toString());
                i.putExtra("phoneI", phone.getText().toString());
                i.putExtra("emailI", email.getText().toString());
                startActivity(i);
            }
        });

        resetS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                age.setText("");
                job.setText("");
                phone.setText("");
                email.setText("");
            }
        });
    }
}