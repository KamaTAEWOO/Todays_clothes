package com.example.todayclothes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;

public class StoryImagePage extends AppCompatActivity {

    static public GridView gridView;
    static public Image_adapter image_adapter;
    ImageButton IB_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_image_page);

        IB_back = findViewById(R.id.IB_back);

        gridView= findViewById(R.id.grid_view);

        gridView.setAdapter(new Image_adapter(this));

        image_adapter = new Image_adapter(this);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 이미지 클릭시
                Intent intent=new Intent(getApplicationContext(), FullScreenPage.class);
                intent.putExtra("id",position);
                startActivity(intent);
            }
        });

        IB_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 이미지 클릭시
                Intent intent = new Intent(getApplicationContext(), MyCodyPage.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}