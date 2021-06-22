package com.example.todayclothes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class FullScreenPage extends AppCompatActivity {

    ImageView imageView;
    ImageButton IBremove;
    MyCodyPage ma = new MyCodyPage();
    StoryImagePage si = new StoryImagePage();
    public Image_adapter mGridAdapter;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_page);

        imageView = findViewById(R.id.image_vview);
        IBremove = findViewById(R.id.IB_set_remove);

        mGridAdapter = new Image_adapter(this);

        Intent i = getIntent();
        position = i.getExtras().getInt("id");
        Log.d("position", String.valueOf(position));
        imageView.setImageBitmap(MyCodyPage.MainImageArray.get(position));

        // 환경 설정 버튼
        registerForContextMenu(IBremove);

    }
//    @Override public void onBackPressed() {
//        //super.onBackPressed();
//    }

    // 환경설정 메뉴바 이용
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();

        if (v == IBremove) {
            menuInflater.inflate(R.menu.mycody_picture_remove, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.set_remove:
                pictureRemove();
                return true;
        }
        return false;
    }


    public void pictureRemove(){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("yourPrefsKey", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove("StringImage" + position);
        editor.commit();

        MyCodyPage.MainImageArray.remove(position);

        // 선택 항목 초기화
        StoryImagePage.gridView.setItemChecked(-1, true);

        // Grid list 반영
        mGridAdapter.notifyDataSetChanged();

        Intent intent = new Intent(getApplicationContext(), StoryImagePage.class);
        startActivity(intent);
    }
}
