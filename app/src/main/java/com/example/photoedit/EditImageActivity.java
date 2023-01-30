package com.example.photoedit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class EditImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_image);
        Init();
    }

    private void Init() {
        ImageView photo = findViewById(R.id.imageView);
        photo.setImageBitmap(MainActivity.selectedImage);
    }
}