package com.example.cv;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    //private ImageView profile;
    //private static final int REQUEST_IMAGE_CAPTURE=101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView name2= findViewById(R.id.name2);
        TextView age2= findViewById(R.id.age2);
        TextView job2= findViewById(R.id.job2);
        TextView phone2= findViewById(R.id.phone2);
        TextView email2= findViewById(R.id.email2);
        
        Button takePic= findViewById(R.id.takePic);
        ImageView profile=findViewById(R.id.profilePic);
        


        Bundle b = getIntent().getExtras();

        name2.setText(b.getString("nameI"));
        age2.setText(b.getString("ageI"));
        job2.setText(b.getString("jobI"));
        phone2.setText("00"+b.getString("phoneI"));
        email2.setText(b.getString("emailI"));


        Toast.makeText(MainActivity2.this, "Done..", Toast.LENGTH_SHORT).show();

        takePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(i,123);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 123) {
            Bitmap img = (Bitmap) data.getExtras().get("data");
            ImageView myphoto = findViewById(R.id.profilePic);
            myphoto.setImageBitmap(img);
        }
        
    }

    /*public void takePicture(View view)
    {
        Intent imageTakeIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (imageTakeIntent.resolveActivity(getPackageManager())!=null)
        {
           startActivityForResult(imageTakeIntent,REQUEST_IMAGE_CAPTURE); 
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            profile.setImageBitmap(imageBitmap);
        }

    }*/


}