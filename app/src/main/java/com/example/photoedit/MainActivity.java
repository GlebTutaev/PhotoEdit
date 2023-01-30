package com.example.photoedit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    public static Bitmap selectedImage;
    private static final int PICK_IMAGE = 01;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void PickPhoto(View view) {

        Intent photoPickerIntene = new Intent(Intent.ACTION_PICK);
        photoPickerIntene.setType("image/*");
        startActivityForResult(photoPickerIntene, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE){
            try{
                Uri imageUri = data.getData();
                InputStream imageStream = getContentResolver().openInputStream(imageUri);
                selectedImage = BitmapFactory.decodeStream(imageStream);

                Intent intent = new Intent(MainActivity.this, EditImageActivity.class);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}