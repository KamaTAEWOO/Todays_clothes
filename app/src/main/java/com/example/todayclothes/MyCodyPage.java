package com.example.todayclothes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todayclothes.clothesPage.WeatherClothesPage_man;
import com.example.todayclothes.clothesPage.WeatherClothesPage_woman;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class MyCodyPage extends MainWeatherPage implements AdapterView.OnItemSelectedListener{

    // 스피너 사용
    String[] m_S_temp = {"온도 지정", "4°C ~ 10°C", "11°C ~ 15°C", "16°C ~ 20°C", "21°C ~ 26°C", "27°C ~ 30°C"};
    // 스피너 선택한 것 보여주기
    TextView V_view;

    // 갤러리 사용
    // constant to compare
    // the activity result code
    int SELECT_PICTURE = 200; // 하의
    int SELECT_PICTURE1 = 201; // 신발
    int SELECT_PICTURE2 = 202; // 모자
    int SELECT_PICTURE3 = 203; // 악세1
    int SELECT_PICTURE4 = 204; // 악세2
    int SELECT_PICTURE5 = 205; // 상의
    int SELECT_PICTURE6 = 206; // 아우터

    //Navigation Bar
    ImageButton btn_ToMainWeatherPage;
    ImageButton btn_ToWeatherClothesPage;
    ImageButton btn_ToClothesPage;

    // 이미지 버튼
    ImageButton IB_m_pants;
    ImageButton IB_m_shoes;
    ImageButton IB_m_hat;
    ImageButton IB_m_accessories1;
    ImageButton IB_m_accessories2;
    ImageButton IB_m_top;
    ImageButton IB_m_outer;

    ImageButton btn_m_save; // 캡처 버튼
    ImageButton btn_m_codyClothes;
    ConstraintLayout container;

    // 해당 인덱스 저장
    int m_num = 0;

    public Uri mImageUri;

    String img_pants = "pants.png";
    String img_shoes = "shoes.png";
    String img_hat = "hat.png";
    String img_accessories1 = "accessories1.png";
    String img_accessories2 = "accessories2.png";
    String img_top = "top.png";
    String img_outer = "outer.png";


    // 캡처부분 및 옷장
    private final AppCompatActivity activity = MyCodyPage.this;
    private Bitmap bitmap;
    public ArrayList<String> StringArray = new ArrayList<String>(); // 앱을 종료하기 전에 앨범에 있던 사진들을 담는 곳
    static public ArrayList<Bitmap> MainImageArray = new ArrayList<Bitmap>(); // 최종만 넣어서 돌리기. 앱을 종료하기 전에 앨범 + 스크린샷
    SharedPreferences prefs;
    static boolean Check = false;
    MainWeatherPage mw = new MainWeatherPage();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cody_page);

        btn_ToMainWeatherPage = findViewById(R.id.btn_ToMainWeatherPage);
        btn_ToWeatherClothesPage = findViewById(R.id.btn_ToWeatherClothesPage);
        btn_ToClothesPage = findViewById(R.id.btn_ToClothesPage);

        // 이미지 버튼 사용
        IB_m_pants = findViewById(R.id.imgB_pants);
        IB_m_shoes= findViewById(R.id.imgB_shoes);
        IB_m_hat= findViewById(R.id.imgB_hat);
        IB_m_accessories1= findViewById(R.id.imgB_Accessories1);
        IB_m_accessories2= findViewById(R.id.imgB_Accessories2);
        IB_m_top= findViewById(R.id.imgB_top);
        IB_m_outer= findViewById(R.id.imgB_outer);
        //V_view = (TextView) findViewById(R.id.txt_view);
        Spinner spin = findViewById(R.id.spinner);
        // 캡처버튼
        btn_m_save = findViewById(R.id.btn_save);
        btn_m_codyClothes = findViewById(R.id.btn_cody_clothes);
        container = findViewById(R.id.linear);

        FileLoad(); // 재실행시 파일 로드

        // handle the Choose Image button to trigger
        // the image chooser function
        IB_m_pants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_num = 0;
                imageChooser();
            }
        });
        IB_m_shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_num = 1;
                imageChooser();
            }
        });
        IB_m_hat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_num = 2;
                imageChooser();
            }
        });
        IB_m_accessories1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_num = 3;
                imageChooser();
            }
        });
        IB_m_accessories2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_num = 4;
                imageChooser();
            }
        });
        IB_m_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_num = 5;
                imageChooser();
            }
        });
        IB_m_outer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_num = 6;
                imageChooser();
            }
        });

        // 스피너 사용
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,m_S_temp);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        //*****************************************************************************
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},00);
        // 캡처버튼 만들기.
        btn_m_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "캡처를 완료하였습니다.",Toast.LENGTH_SHORT).show();
                bitmap = ScreenshotUtil.getInstance().takeScreenshotForScreen(activity); // 스크린샷 이미지
                MainImageArray.add(bitmap); // 앱실행시 바로 스샷찍었을때  넣은 값
            }
        });

        // 나의 코디 옷장 가기.
        btn_m_codyClothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> a = new ArrayList<String>();
                //BitmapArray.clear();
                if(Check == false){
                    a = loadArray();// 앱실행시 처음 한번만 실행.
                    Check = true;
                }
                //***
                //앱을 종료하기 전에 앨범 + 스크린샷
                for(int i = 0; i< a.size(); i++){
                    MainImageArray.add(StringToBitMap(StringArray.get(i))); // 앱 종료전까지 저장한 앨범 사진들.
                }
                //***
                saveArray(MainImageArray); // 마지막 전체 이미지를 저장.

                Intent intent1 = new Intent(getApplicationContext(), StoryImagePage.class);
                startActivity(intent1);
            }
        });

        // Navagation Bar
        // 메인 날씨 화면
        btn_ToMainWeatherPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MainWeatherPage.class);
                startActivity(intent1);
            }
        });

        // 추천 옷차림화면.
        btn_ToWeatherClothesPage.setOnClickListener(new View.OnClickListener() {
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
                }else if((surveyCheck == true) && (m_gender.equals("여자"))){
                    Intent intent = new Intent(getApplicationContext(), WeatherClothesPage_woman.class);
                    intent.putExtra("cTemp",m_cTemperlist.get(0).toString()); // 현재기온
                    intent.putExtra("CHighTemp",m_CHighTemp); // 금일 최고기온
                    intent.putExtra("CLowTemp",m_CLowTemp); // 금일 최저기온
                    intent.putExtra("Crain", m_rainNumList.get(0).toString()); // 금일 강수량
                    intent.putExtra("Cwind", m_cWindlist.get(0).toString()); // 금일 바람세기
                    startActivity(intent);
                }
            }
        });
        // 옷장 화면
        btn_ToClothesPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MyClosetTop.class);
                startActivity(intent1);
            }
        });

    }

    // 캡처하기.
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
            e.getMessage();
            return null;
        }
    }

    // 마지막 앨범에 들어간 이미지들을 전부 받아와서 LastStringArray 리스트로 저장하기.
    public void saveArray(ArrayList<Bitmap> LastBitmapArray)
    {
        ArrayList<String> LastStringArray = new ArrayList<String>();
        for(int i = 0; i < LastBitmapArray.size(); i++){
            try{
                LastStringArray.add(BitMapToString(LastBitmapArray.get(i)));
            }catch (Exception e){
                continue;
            }
        }
        prefs=this.getSharedPreferences("yourPrefsKey",Context.MODE_PRIVATE);
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
        prefs=this.getSharedPreferences("yourPrefsKey",Context.MODE_PRIVATE);
        StringArray.clear();
        int size = prefs.getInt("StringImage_size", 0);

        for(int i=0;i<size;i++)
        {
            try {
                String key = prefs.getString("StringImage" + i, null);
                if(key.equals(null)){
                    continue;
                }else{
                    StringArray.add(key);
                }
            }catch (Exception e){
                continue;
            }
        }
        return StringArray;
    }

    void imageChooser() {
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_OPEN_DOCUMENT);

        if(m_num == 0){
            startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
        }else if(m_num == 1){
            startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE1);
        }else if(m_num == 2){
            startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE2);
        }else if(m_num == 3){
            startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE3);
        }else if(m_num == 4){
            startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE4);
        }else if(m_num == 5){
            startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE5);
        }else {
            startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE6);
        }
    }

    // this function is triggered when user
    // selects the image from the imageChooser
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    mImageUri = data.getData();
                    ImgInsert(mImageUri, SELECT_PICTURE);
                }
            }else if (requestCode == SELECT_PICTURE1) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    mImageUri = data.getData();
                    ImgInsert(mImageUri, SELECT_PICTURE1);
                }
            }else if (requestCode == SELECT_PICTURE2) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    mImageUri = data.getData();
                    ImgInsert(mImageUri, SELECT_PICTURE2);
                }
            }else if (requestCode == SELECT_PICTURE3) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    IB_m_accessories1.setImageURI(selectedImageUri);
                    mImageUri = data.getData();
                    ImgInsert(mImageUri, SELECT_PICTURE3);
                }
            }else if (requestCode == SELECT_PICTURE4) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    mImageUri = data.getData();
                    ImgInsert(mImageUri, SELECT_PICTURE4);
                }
            }else if (requestCode == SELECT_PICTURE5) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    mImageUri = data.getData();
                    ImgInsert(mImageUri, SELECT_PICTURE5);
                }
            }else {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    mImageUri = data.getData();
                    ImgInsert(mImageUri, SELECT_PICTURE6);
                }
            }
        }
    }

    //*****************************************************************************
    // 스피너 함수
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK); /* if you want your item to be white */
        ((TextView) parent.getChildAt(0)).setTextSize(21);

        //Toast.makeText(getApplicationContext(),m_S_temp[position] , Toast.LENGTH_LONG).show();
        //V_view.setText(m_S_temp[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }
    //*****************************************************************************
    // 이미지 -> path
    public void saveBitmapToJpeg(Bitmap bitmap, int selectCode) {   // 선택한 이미지 내부 저장소에 저장
        File tempFile;

        if(selectCode == SELECT_PICTURE){
            tempFile = new File(getCacheDir(), img_pants);
        }else if(selectCode == SELECT_PICTURE1){
            tempFile = new File(getCacheDir(), img_shoes);
        }else if(selectCode == SELECT_PICTURE2){
            tempFile = new File(getCacheDir(), img_hat);
        }else if(selectCode == SELECT_PICTURE3){
            tempFile = new File(getCacheDir(), img_accessories1);
        }else if(selectCode == SELECT_PICTURE4){
            tempFile = new File(getCacheDir(), img_accessories2);
        }else if(selectCode == SELECT_PICTURE5){
            tempFile = new File(getCacheDir(), img_top);
        }else {
            tempFile = new File(getCacheDir(), img_outer);
        }

        try {
            tempFile.createNewFile();   // 자동으로 빈 파일을 생성하기
            FileOutputStream out = new FileOutputStream(tempFile);  // 파일을 쓸 수 있는 스트림을 준비하기
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);   // compress 함수를 사용해 스트림에 비트맵을 저장하기
            out.close();    // 스트림 닫아주기
            //Toast.makeText(getApplicationContext(), "파일 저장 성공", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            //Toast.makeText(getApplicationContext(), "파일 저장 실패", Toast.LENGTH_SHORT).show();
        }

    }

    // 이미지를 넣어주는 부분
    public void ImgInsert(Uri imgUri, int selectCode){
        ContentResolver resolver = getContentResolver();
        try {
            InputStream instream = resolver.openInputStream(imgUri);
            Bitmap imgBitmap = BitmapFactory.decodeStream(instream);

            if(selectCode == SELECT_PICTURE){
                IB_m_pants.setImageBitmap(imgBitmap);
            }else if(selectCode == SELECT_PICTURE1){
                IB_m_shoes.setImageBitmap(imgBitmap);
            }else if(selectCode == SELECT_PICTURE2){
                IB_m_hat.setImageBitmap(imgBitmap);
            }else if(selectCode == SELECT_PICTURE3){
                IB_m_accessories1.setImageBitmap(imgBitmap);
            }else if(selectCode == SELECT_PICTURE4){
                IB_m_accessories2.setImageBitmap(imgBitmap);
            }else if(selectCode == SELECT_PICTURE5){
                IB_m_top.setImageBitmap(imgBitmap);
            }else {
                IB_m_outer.setImageBitmap(imgBitmap);
            }
            Log.d("selectCode", String.valueOf(selectCode));
            instream.close();   // 스트림 닫아주기
            saveBitmapToJpeg(imgBitmap ,selectCode);    // 내부 저장소에 저장
            //Toast.makeText(getApplicationContext(), "파일 불러오기 성공", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            //Toast.makeText(getApplicationContext(), "파일 불러오기 실패", Toast.LENGTH_SHORT).show();
        }
    }

    // file load
    public void FileLoad(){
        // 재실행시 저장한 파일을 불러온다.
        // 하의
        if(img_pants != null){
            Log.d("checkpants","check");
            String imgpath = getCacheDir() + "/" + img_pants;  // 내부 저장소에 저장되어 있는 이미지 경로
            Log.d("imgpath",imgpath);
            Bitmap bm = BitmapFactory.decodeFile(imgpath);
            IB_m_pants.setImageBitmap(bm);
        }
        // 신발
        if(img_shoes.equals("shoes.png")){
            String imgpath = getCacheDir() + "/" + img_shoes;
            Log.d("imgpath1",imgpath);
            Bitmap bm = BitmapFactory.decodeFile(imgpath);
            IB_m_shoes.setImageBitmap(bm);
        }
        // 모자
        if(img_hat.equals("hat.png")){
            String imgpath = getCacheDir() + "/" + img_hat;
            Bitmap bm = BitmapFactory.decodeFile(imgpath);
            IB_m_hat.setImageBitmap(bm);
        }
        // 악세사리1
        if(img_accessories1.equals("accessories1.png")){
            String imgpath = getCacheDir() + "/" + img_accessories1;
            Bitmap bm = BitmapFactory.decodeFile(imgpath);
            IB_m_accessories1.setImageBitmap(bm);
        }
        // 악세사리2
        if(img_accessories2.equals("accessories2.png")){
            String imgpath = getCacheDir() + "/" + img_accessories2;
            Bitmap bm = BitmapFactory.decodeFile(imgpath);
            IB_m_accessories2.setImageBitmap(bm);
        }
        // 상의
        if(img_top.equals("top.png")){
            String imgpath = getCacheDir() + "/" + img_top;
            Bitmap bm = BitmapFactory.decodeFile(imgpath);
            IB_m_top.setImageBitmap(bm);
        }
        // 아우터
        if(img_outer.equals("outer.png")){
            String imgpath = getCacheDir() + "/" + img_outer;
            Bitmap bm = BitmapFactory.decodeFile(imgpath);
            IB_m_outer.setImageBitmap(bm);
        }
    }



}






























