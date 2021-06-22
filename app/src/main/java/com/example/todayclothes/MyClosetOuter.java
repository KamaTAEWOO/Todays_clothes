package com.example.todayclothes;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.todayclothes.clothesPage.WeatherClothesPage_man;
import com.example.todayclothes.clothesPage.WeatherClothesPage_woman;
import com.example.todayclothes.myCloset.GridArrayAdapter1;
import com.example.todayclothes.myCloset.GridItem1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyClosetOuter extends MainWeatherPage {
    ImageButton IB_weatherPage;
    ImageButton IB_clothesPage;
    ImageButton IB_myCodyPage;

    ImageButton CataBtn;

    final int MAX_IMAGE_COUNT = 100;


    // List item
    private List<GridItem1> mItemList;

    // Grid view
    private GridView mGridView;

    // GridView adapter
    private GridArrayAdapter1 mGridAdapter;

    //Bitmap to String
    private ArrayList<String> BitmapToStringArray = new ArrayList<String>(); // 앱을 종료하기 전에 앨범에 있던 사진들을 담는 곳

    //삭제후 String 담기.
    private ArrayList<String> RemoveToStringArray = new ArrayList<String>(); // 앱을 종료하기 전에 앨범에 있던 사진들을 담는 곳

    private ArrayList<Bitmap> StringToBitmapImageArray = new ArrayList<Bitmap>(); // 최종만 넣어서 돌리기. 앱을 종료하기 전에 앨범 + 스크린샷

    SharedPreferences prefs;

    int size= 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_closet_outer);

        CataBtn = (ImageButton) findViewById(R.id.categori);
        IB_weatherPage = (ImageButton) findViewById(R.id.btn_ToWeatherClothesPage);
        IB_clothesPage = (ImageButton) findViewById(R.id.btn_ToClothsPage);
        IB_myCodyPage = (ImageButton) findViewById(R.id.btn_ToMyCodyPage);

        // 환경 설정 버튼
        registerForContextMenu(CataBtn);

        // Grid 설정
        bindGrid();

        // 삽입 설정
        bindInsert();


        // 삭제 설정
        bindDelete();

        try {
            BitmapToStringArray = loadArray();
            Log.d("BitmapToStringArray", String.valueOf(BitmapToStringArray.size()));
            for(int i = 0; i < BitmapToStringArray.size(); i++){
                // Item 추가
                mItemList.add(new GridItem1(StringToBitmapImageArray.get(i))); //비트맵 리스트를 만들어주는곳.

                // Grid list 반영
                mGridAdapter.notifyDataSetChanged();
            }
        } catch (Exception e) { }

        // navigation bar
        IB_clothesPage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("gender", m_gender);
                Log.d("gender", "응답하였음.");
                if((surveyCheck == true) && (m_gender.equals("남자"))){
                    Intent intent = new Intent(getApplicationContext(), WeatherClothesPage_man.class);
                    intent.putExtra("cTemp",m_cTemperlist.get(0).toString()); // 현재기온
                    intent.putExtra("CHighTemp",m_CHighTemp); // 금일 최고기온
                    intent.putExtra("CLowTemp",m_CLowTemp); // 금일 최저기온
                    intent.putExtra("Crain", m_rainNumList.get(0).toString()); // 금일 강수량
                    intent.putExtra("Cwind", m_cWindlist.get(0).toString()); // 금일 바람세기
                    startActivity(intent);
                    finish();
                }else if((surveyCheck == true) && (m_gender.equals("여자"))){
                    Intent intent = new Intent(getApplicationContext(), WeatherClothesPage_woman.class);
                    intent.putExtra("cTemp",m_cTemperlist.get(0).toString()); // 현재기온
                    intent.putExtra("CHighTemp",m_CHighTemp); // 금일 최고기온
                    intent.putExtra("CLowTemp",m_CLowTemp); // 금일 최저기온
                    intent.putExtra("Crain", m_rainNumList.get(0).toString()); // 금일 강수량
                    intent.putExtra("Cwind", m_cWindlist.get(0).toString()); // 금일 바람세기
                    startActivity(intent);
                    finish();
                }
            }
        });

        //날씨 메인 이동
        IB_weatherPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainWeatherPage.class);
                startActivity(intent);
                finish();
            }
        });

        //나의 코디로 이동
        IB_myCodyPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyCodyPage.class);
                startActivity(intent);
                finish();
            }
        });

    }


    // 환경설정 메뉴바 이용
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();

        if (v == CataBtn) {

            menuInflater.inflate(R.menu.menu_option, menu);
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.closet_top:
                Intent intent=new Intent(getApplicationContext(), MyClosetTop.class);
                startActivity(intent);
                break;
            case R.id.closet_bottom:
                Intent intent1=new Intent(getApplicationContext(), MyClosetBottom.class);
                startActivity(intent1);
                break;
            case R.id.closet_outer:
                Intent intent2=new Intent(getApplicationContext(), MyClosetOuter.class);
                startActivity(intent2);
                break;
        }
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { // 갤러리
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            if (resultCode == RESULT_OK) {
                Uri fileUri = data.getData();
                ContentResolver resolver = getContentResolver();
                try {
                    InputStream instream = resolver.openInputStream(fileUri);
                    Bitmap imgBitmap = BitmapFactory.decodeStream(instream);
                    instream.close();   // 스트림 닫아주기
                    //saveBitmapToJpeg(imgBitmap);    // 내부 저장소에 저장
                    Bitmap a = rotateImage(fileUri,imgBitmap);
                    BitmapToStringArray.add(BitMapToString(a));
                    for(int k = 0; k < BitmapToStringArray.size(); k++){
                        Log.d("BitmapToStringArray", BitmapToStringArray.get(k));
                    }
                    saveArray(BitmapToStringArray);

                    // Item 추가
                    mItemList.add(new GridItem1(a));

                    // Grid list 반영
                    mGridAdapter.notifyDataSetChanged();
                } catch (Exception e) {}
            }
        }
    }

    // Bitmap to String
    public String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        String temp= Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }

    //String to Bitmap
    public Bitmap StringToBitMap(String encodedString){
        try {
            byte [] encodeByte=Base64.decode(encodedString,Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch(Exception e) {
            Log.d("죄송", "합니다.");
            e.getMessage();
            return null;
        }
    }

    // 마지막 앨범에 들어간 이미지들을 전부 받아와서 LastStringArray 리스트로 저장하기.
    public void saveArray(ArrayList<String> LastStringArray)
    {
        prefs=this.getSharedPreferences("ClothesOuter", Context.MODE_PRIVATE);
        SharedPreferences.Editor mEdit1 = prefs.edit();
        /* sKey is an array */
        mEdit1.putInt("StringImage_size", LastStringArray.size());

        for(int i=0;i<LastStringArray.size();i++)
        {
            try{
                mEdit1.remove("StringImage" + i);
                mEdit1.putString("StringImage" + i, LastStringArray.get(i));
            }catch (Exception e){
                continue;
            }
        }
        mEdit1.commit();
    }

    // 마지막에 저장한 사진을 처음 버튼을 누를때만 실행되게 만들었음.
    public ArrayList loadArray()
    {
        prefs=this.getSharedPreferences("ClothesOuter",Context.MODE_PRIVATE);
        //BitmapToStringArray.clear();
        size = prefs.getInt("StringImage_size", 0);

        for(int i=0;i<size;i++)
        {
            try {
                String key = prefs.getString("StringImage" + i, null);
                if(key.equals(null)){
                    continue;
                }else{
                    BitmapToStringArray.add(key);
                }
            }catch (Exception e){
                continue;
            }
        }
        Log.d("STR", String.valueOf(BitmapToStringArray.size()));
        for(int k = 0; k < BitmapToStringArray.size(); k++){
            Bitmap a = StringToBitMap(BitmapToStringArray.get(k));
            StringToBitmapImageArray.add(a);
            Log.d("STR", String.valueOf(a));
        }
        return BitmapToStringArray;
    }

    /**
     * Grid 설정
     */
    private void bindGrid() {
        // Grid item 생성
        mItemList = new ArrayList<>();

        // Grid adapter
        mGridAdapter = new GridArrayAdapter1(this, mItemList);

        mGridView = (GridView) findViewById(R.id.gridview);
        mGridView.setAdapter(mGridAdapter);
    }

    /**
     * 삽입 설정
     */
    //삽입 설정
    private void bindInsert() {
        findViewById(R.id.btn_insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 101);
            }
        });
    }



    /**
     * 삭제 설정
     */
    private void bindDelete() {
        findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    final int position = mGridView.getCheckedItemPosition();

                    SharedPreferences pref = getApplicationContext().getSharedPreferences("ClothesOuter", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.remove("StringImage" + position);
                    //BitmapToStringArray[posiont] remove
                    BitmapToStringArray.remove(position); //지우고 다시 shared preferences에 저장해준다.
                    editor.putInt("StringImage_size", BitmapToStringArray.size());

                    for (int k = 0; k < BitmapToStringArray.size(); k++) {
                        RemoveToStringArray.add(BitmapToStringArray.get(k));
                        Log.d("≈", String.valueOf(RemoveToStringArray.size()));
                        Log.d("Array2", String.valueOf(BitmapToStringArray.size()));
                    }

                    // 삭제후 preferense 에 있는 값들 전부 지우고
                    for (int j = 0; j < MAX_IMAGE_COUNT; j++) {
                        editor.remove("StringImage" + j);
                        Log.d("remove1", String.valueOf(j));
                    }

                    // 다시 shared prefernecs에 저장해준다.
                    for (int i = 0; i < RemoveToStringArray.size(); i++) {
                        try {
                            //editor.remove("StringImage" + i);
                            editor.putString("StringImage" + i, RemoveToStringArray.get(i));
                        } catch (Exception e) {
                            continue;
                        }
                    }
                    editor.apply();

                    //내가 포지션을 클릭해서 삭제 할때 이름이
                    if (position == -1) {
                        Toast.makeText(MyClosetOuter.this, R.string.err_no_selected_item, Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // 선택한 grid item 삭제
                    mItemList.remove(position);

                    // 선택 항목 초기화
                    mGridView.setItemChecked(1, true);

                    // Grid list 반영
                    mGridAdapter.notifyDataSetChanged();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "선택을 해주세요~", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    // 사진 회전 조절
    @RequiresApi(api = Build.VERSION_CODES.N)
    private Bitmap rotateImage(Uri uri, Bitmap bitmap) throws IOException {
        InputStream in = getContentResolver().openInputStream(uri);
        ExifInterface exif = new ExifInterface(in);
        in.close();

        int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
        Matrix matrix = new Matrix();

        if (orientation == ExifInterface.ORIENTATION_ROTATE_90){
            matrix.postRotate(90);
        }
        if (orientation == ExifInterface.ORIENTATION_ROTATE_180){
            matrix.postRotate(180);
        }
        if (orientation == ExifInterface.ORIENTATION_ROTATE_270){
            matrix.postRotate(270);
        }
        return Bitmap.createBitmap(bitmap, 0,0, bitmap.getWidth(),bitmap.getHeight(), matrix,true);
    }
}
