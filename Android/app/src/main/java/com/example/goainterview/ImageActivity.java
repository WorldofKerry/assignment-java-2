package com.example.goainterview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {
    int mImagePosition;
    int mImageNumber;
    int[] mImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Intent intent = getIntent();

        // Prevents errors in setting image
        if (intent.hasExtra("IMAGE_NUMBER")) {
            mImageNumber = intent.getIntExtra("IMAGE_NUMBER", -1);
        } else {
            System.out.println("Missing extra");
        }
        if (intent.hasExtra("IMAGE_POSITION")) {
            mImagePosition = intent.getIntExtra("IMAGE_POSITION", -1);
        } else {
            System.out.println("Missing extra");
        }
        if (intent.hasExtra("IMAGES")) {
            mImages = intent.getIntArrayExtra("IMAGES");
        } else {
            System.out.println("Missing extra");
        }

        // Sets image depending on image position (item position in recyclerView) and image number (left or right)
        ImageView imageView = findViewById(R.id.image_activity_image);
        imageView.setImageResource(mImages[mImagePosition*2+mImageNumber]);

    }
}
