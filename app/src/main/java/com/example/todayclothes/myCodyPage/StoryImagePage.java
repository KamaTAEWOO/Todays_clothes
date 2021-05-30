package com.example.todayclothes.myCodyPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.todayclothes.R;

public class StoryImagePage extends AppCompatActivity {

    static public GridView gridView;
    static public com.example.todayclothes.myCodyPage.Image_adapter image_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_image_page);

        gridView=(GridView)findViewById(R.id.grid_view);

        gridView.setAdapter(new com.example.todayclothes.myCodyPage.Image_adapter(this));

        image_adapter = new com.example.todayclothes.myCodyPage.Image_adapter(this);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 이미지 클릭시
                Intent intent=new Intent(getApplicationContext(), FullScreenPage.class);
                intent.putExtra("id",position);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}