package com.example.goainterview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{
    RecyclerView mRecyclerView;
    // List of images
    int mImages[] = {R.drawable.ic_ring_volume_black_24dp, R.drawable.ic_collections_black_24dp, R.drawable.ic_wallpaper_black_24dp,
            R.drawable.ic_ring_volume_black_24dp, R.drawable.ic_collections_black_24dp, R.drawable.ic_wallpaper_black_24dp,
            R.drawable.ic_ring_volume_black_24dp, R.drawable.ic_collections_black_24dp, R.drawable.ic_wallpaper_black_24dp,
            R.drawable.ic_ring_volume_black_24dp, R.drawable.ic_collections_black_24dp, R.drawable.ic_wallpaper_black_24dp,
            R.drawable.ic_ring_volume_black_24dp, R.drawable.ic_collections_black_24dp, R.drawable.ic_wallpaper_black_24dp,
            R.drawable.ic_ring_volume_black_24dp, R.drawable.ic_collections_black_24dp, R.drawable.ic_wallpaper_black_24dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Images");

        // RecyclerView setup
        mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mImages);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // On click for when image selected
        adapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {

            @Override
            public void onImageViewLeftClick(int position) {
                Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                // Left or right image selected
                intent.putExtra("IMAGE_NUMBER", 0);
                // Item position in recyclerView
                intent.putExtra("IMAGE_POSITION", position);
                intent.putExtra("IMAGES", mImages);
                startActivity(intent);
            }

            @Override
            public void onImageViewRightClick(int position) {
                Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                intent.putExtra("IMAGE_NUMBER", 1);
                intent.putExtra("IMAGE_POSITION", position);
                intent.putExtra("IMAGES", mImages);
                startActivity(intent);
            }
        });



    }

}
