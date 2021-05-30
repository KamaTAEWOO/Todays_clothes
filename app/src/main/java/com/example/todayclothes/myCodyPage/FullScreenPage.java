package com.example.todayclothes.myCodyPage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.todayclothes.R;

public class FullScreenPage extends AppCompatActivity {

    ImageView imageView;
    Button btn3;
    MyCodyPage ma = new MyCodyPage();
    StoryImagePage si = new StoryImagePage();
    private Image_adapter mGridAdapter;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_page);

        imageView = findViewById(R.id.image_vview);
        btn3 = findViewById(R.id.back);

        mGridAdapter = new Image_adapter(this);

        //getSupportActionBar().hide();
        //getSupportActionBar().setTitle("Full Screen Image");

        Intent i = getIntent();
        position = i.getExtras().getInt("id");
        Log.d("position", String.valueOf(position));
        imageView.setImageBitmap(si.image_adapter.ma.MainImageArray.get(position));

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intent);
                SharedPreferences pref = getApplicationContext().getSharedPreferences("yourPrefsKey", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.remove("StringImage" + position);
                editor.commit();
                //int position = si.gridView.getCheckedItemPosition();
                Log.d("position", String.valueOf(position));
//                if (position == -1) {
//                    //Toast.makeText(PhMainActivity.this, R.string.err_no_selected_item, Toast.LENGTH_SHORT).show();
//                    return;
//                }

                si.image_adapter.ma.MainImageArray.remove(position);

                // 선택한 grid item 삭제
                //ma.MainImageArray.remove(position);

                // 선택 항목 초기화
                si.gridView.setItemChecked(-1, true);

                // Grid list 반영
                mGridAdapter.notifyDataSetChanged();

                //ma.saveArray(ma.MainImageArray); // 마지막 전체 이미지를 저장.

                Intent intent = new Intent(getApplicationContext(), StoryImagePage.class);
                startActivity(intent);
            }
        });
    }
//    @Override public void onBackPressed() {
//        //super.onBackPressed();
//    }
}
