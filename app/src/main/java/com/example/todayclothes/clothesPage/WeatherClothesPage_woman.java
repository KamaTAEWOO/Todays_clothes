package com.example.todayclothes.clothesPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.todayclothes.MainWeatherPage;
import com.example.todayclothes.R;
import com.example.todayclothes.MyCodyPage;

public class WeatherClothesPage_woman extends AppCompatActivity {
    TextView V_CTemp;
    TextView V_CHTemp;
    TextView V_CLTemp;

    ImageButton V_IweatherPage;
    ImageButton V_IClothesPage;
    ImageButton V_IMyCodyPage;

    ImageView V_ITopclothes1;
    ImageView V_ITopclothes2;
    ImageView V_ITopclothes3;
    ImageView V_ITopclothes4;
    ImageView V_ITopclothes5;
    ImageView V_ITopclothes6;

    ImageView V_IOuterclothes1;
    ImageView V_IOuterclothes2;
    ImageView V_IOuterclothes3;
    ImageView V_IOuterclothes4;
    ImageView V_IOuterclothes5;
    ImageView V_IOuterclothes6;

    ImageView V_IBottomclothes1;
    ImageView V_IBottomclothes2;
    ImageView V_IBottomclothes3;
    ImageView V_IBottomclothes4;
    ImageView V_IBottomclothes5;
    ImageView V_IBottomclothes6;

    TextView V_txtTop1;
    TextView V_txtTop2;
    TextView V_txtTop3;
    TextView V_txtTop4;
    TextView V_txtTop5;
    TextView V_txtTop6;

    TextView V_txtOuter1;
    TextView V_txtOuter2;
    TextView V_txtOuter3;
    TextView V_txtOuter4;
    TextView V_txtOuter5;
    TextView V_txtOuter6;

    TextView V_txtBottom1;
    TextView V_txtBottom2;
    TextView V_txtBottom3;
    TextView V_txtBottom4;
    TextView V_txtBottom5;
    TextView V_txtBottom6;

    // 조언문구
    TextView V_advice;

    int m_Maximum_temperature = 0; // 최대 온도
    int m_Lowest_temperature = 0; // 최저 온도
    String high = "";
    String Low = "";
    int m_crain = 0; // 강수량
    double m_cwind = 0.0; // 비림세기

    // 다이얼로그 설문조사 답을 담는 변수
    String m_gender = ""; // 성별
    String m_heat = ""; // 더위
    String m_style = ""; // 스타일

    // 옷 스타일 변수
    String m_MATCHING_style = ""; // 설문지 답.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_clothes_page_woman);

        V_CTemp = (TextView) findViewById(R.id.CTemp);
        V_CHTemp = (TextView) findViewById(R.id.CHTemp);
        V_CLTemp = (TextView) findViewById(R.id.CLTemp);

        V_IweatherPage = (ImageButton) findViewById(R.id.btn_weatherMainPage);
        V_IClothesPage = (ImageButton) findViewById(R.id.btn_ToClothsPage);
        V_IMyCodyPage = (ImageButton) findViewById(R.id.btn_ToMyCodyPage);

        V_ITopclothes1 = (ImageView) findViewById(R.id.img_Topclothes1);
        V_ITopclothes2 = (ImageView) findViewById(R.id.img_Topclothes2);
        V_ITopclothes3 = (ImageView) findViewById(R.id.img_Topclothes3);
        V_ITopclothes4 = (ImageView) findViewById(R.id.img_Topclothes4);
        V_ITopclothes5 = (ImageView) findViewById(R.id.img_Topclothes5);
        V_ITopclothes6 = (ImageView) findViewById(R.id.img_Topclothes6);

        V_IOuterclothes1 = (ImageView) findViewById(R.id.img_Outerclothes1);
        V_IOuterclothes2 = (ImageView) findViewById(R.id.img_Outerclothes2);
        V_IOuterclothes3 = (ImageView) findViewById(R.id.img_Outerclothes3);
        V_IOuterclothes4 = (ImageView) findViewById(R.id.img_Outerclothes4);
        V_IOuterclothes5 = (ImageView) findViewById(R.id.img_Outerclothes5);
        V_IOuterclothes6 = (ImageView) findViewById(R.id.img_Outerclothes6);

        V_IBottomclothes1 = (ImageView) findViewById(R.id.img_Bottomclothes1);
        V_IBottomclothes2 = (ImageView) findViewById(R.id.img_Bottomclothes2);
        V_IBottomclothes3 = (ImageView) findViewById(R.id.img_Bottomclothes3);
        V_IBottomclothes4 = (ImageView) findViewById(R.id.img_Bottomclothes4);
        V_IBottomclothes5 = (ImageView) findViewById(R.id.img_Bottomclothes5);
        V_IBottomclothes6 = (ImageView) findViewById(R.id.img_Bottomclothes6);

        V_txtTop1  = (TextView) findViewById(R.id.txt_top1);
        V_txtTop2 = (TextView) findViewById(R.id.txt_top2);
        V_txtTop3  = (TextView) findViewById(R.id.txt_top3);
        V_txtTop4 = (TextView) findViewById(R.id.txt_top4);
        V_txtTop5  = (TextView) findViewById(R.id.txt_top5);
        V_txtTop6 = (TextView) findViewById(R.id.txt_top6);

        V_txtOuter1  = (TextView) findViewById(R.id.txt_outer1);
        V_txtOuter2 = (TextView) findViewById(R.id.txt_outer2);
        V_txtOuter3  = (TextView) findViewById(R.id.txt_outer3);
        V_txtOuter4 = (TextView) findViewById(R.id.txt_outer4);
        V_txtOuter5  = (TextView) findViewById(R.id.txt_outer5);
        V_txtOuter6 = (TextView) findViewById(R.id.txt_outer6);

        V_txtBottom1  = (TextView) findViewById(R.id.txt_bottom1);
        V_txtBottom2 = (TextView) findViewById(R.id.txt_bottom2);
        V_txtBottom3  = (TextView) findViewById(R.id.txt_bottom3);
        V_txtBottom4 = (TextView) findViewById(R.id.txt_bottom4);
        V_txtBottom5  = (TextView) findViewById(R.id.txt_bottom5);
        V_txtBottom6 = (TextView) findViewById(R.id.txt_bottom6);

        V_advice = (TextView) findViewById(R.id.txt_advice); // 조언 문구

        Intent intent = getIntent(); /*데이터 수신*/

        String woman_cTemp = intent.getExtras().getString("cTemp"); // 현재온도
        // 현재 기온
        V_CTemp.setText(woman_cTemp + "°C");

        // 최고 기온
        if(intent.getExtras().getString("CHighTemp").substring(1,2).equals(".")){
            high = intent.getExtras().getString("CHighTemp").substring(0,1);
            V_CHTemp.setText(high + "°C");
        }else{
            high = intent.getExtras().getString("CHighTemp").substring(0,2) ;
            V_CHTemp.setText(high + "°C");
        }
        // 최저 기온
        if(intent.getExtras().getString("CLowTemp").substring(1,2).equals(".")){
            Low = intent.getExtras().getString("CLowTemp").substring(0,1);
            V_CLTemp.setText(Low + "°C");
        }else{
            Low = intent.getExtras().getString("CLowTemp").substring(0,2);
            V_CLTemp.setText(Low + "°C");
        }

        // 설문조사 내용을 로그로 출력
        // shared preferences로 프로그래스바 한번 돌렸으면 안돌려도됨
        SharedPreferences sh1 = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        m_gender = sh1.getString("gender", "없음"); // 성별 저장
        m_heat = sh1.getString("heat", "없음"); // 더위 저장
        m_style = sh1.getString("style", "없음"); // 스타일 저장
        Log.d("값은?", m_gender + " " + m_heat + " " + m_style);


        // Temp String to int
        m_Maximum_temperature = Integer.parseInt(high);
        m_Lowest_temperature = Integer.parseInt(Low);
        Log.d("m_Maximum_temperature", String.valueOf(m_Maximum_temperature));
        Log.d("m_Lowest_temperature", String.valueOf(m_Lowest_temperature));

        String rain = intent.getExtras().getString("Crain");
        String wind = intent.getExtras().getString("Cwind");
        // 현재 강수량
        m_crain = Integer.parseInt(rain);
        Log.d("m_crain", String.valueOf(m_crain));
        // 현재 바람세기
        m_cwind = Double.parseDouble(wind);
        Log.d("m_cwind", String.valueOf(m_cwind));

        // 설문지에 대한 답
        MatchingStyle();

        // 테스트
        MainTempClothesShow();

        //Navigation Bar
        // 버튼
        V_IweatherPage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), MainWeatherPage.class);
                startActivity(intent);
            }
        });

        //나의 옷장로 이동
        V_IClothesPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), MyCodyPage.class);
//                startActivity(intent);
            }
        });

        //나의 코디로 이동
        V_IMyCodyPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyCodyPage.class);
                startActivity(intent);
            }
        });


    }
    // 여러가지옷 보여주는 추천 옷차림 함수
    public void MainTempClothesShow(){
        // 최고기온
        if(m_Maximum_temperature <= 4) {
            Log.d("TempClothesShow", "4");
            clothesShowMax(4, m_MATCHING_style);
        }else if (m_Maximum_temperature >= 5 && m_Maximum_temperature <= 8){
            Log.d("TempClothesShow", "5");
            clothesShowMax(5, m_MATCHING_style);
        }else if (m_Maximum_temperature >= 9 && m_Maximum_temperature <= 11){
            Log.d("TempClothesShow", "9");
            clothesShowMax(9, m_MATCHING_style);
        }else if (m_Maximum_temperature >= 12 && m_Maximum_temperature <= 16){
            Log.d("TempClothesShow", "12");
            clothesShowMax(12, m_MATCHING_style);
        }else if (m_Maximum_temperature >= 17 && m_Maximum_temperature <= 19){
            Log.d("TempClothesShow", "17");
            clothesShowMax(17, m_MATCHING_style);
        }else if (m_Maximum_temperature >= 20 && m_Maximum_temperature <= 22){
            Log.d("TempClothesShow", "20");
            clothesShowMax(20, m_MATCHING_style);
        }else if (m_Maximum_temperature >= 23 && m_Maximum_temperature <= 27){
            Log.d("TempClothesShow", "23");
            clothesShowMax(23, m_MATCHING_style);
        }else {
            Log.d("TempClothesShow", "28");
            clothesShowMax(28, m_MATCHING_style);
        }

        // 최저기온
        if(m_Lowest_temperature <= 4) {
            Log.d("TempClothesShow", "4");
            clothesShowLow(4, m_MATCHING_style);
        }else if (m_Lowest_temperature >= 5 && m_Lowest_temperature <= 8){
            Log.d("TempClothesShow", "5");
            clothesShowLow(5, m_MATCHING_style);
        }else if (m_Lowest_temperature >= 9 && m_Lowest_temperature <= 11){
            Log.d("TempClothesShow", "9");
            clothesShowLow(9, m_MATCHING_style);
        }else if (m_Lowest_temperature >= 12 && m_Lowest_temperature <= 16){
            Log.d("TempClothesShow", "12");
            clothesShowLow(12, m_MATCHING_style);
        }else if (m_Lowest_temperature >= 17 && m_Lowest_temperature <= 19){
            Log.d("TempClothesShow", "17");
            clothesShowLow(17, m_MATCHING_style);
        }else if (m_Lowest_temperature >= 20 && m_Lowest_temperature <= 22){
            Log.d("TempClothesShow", "20");
            clothesShowLow(20, m_MATCHING_style);
        }else if (m_Lowest_temperature >= 23 && m_Lowest_temperature <= 27){
            Log.d("TempClothesShow", "23");
            clothesShowLow(23, m_MATCHING_style);
        }else {
            Log.d("TempClothesShow", "28");
            clothesShowLow(28, m_MATCHING_style);
        }
        // 조언문구
        AdviceBox();
    }
    //*****************************************************************************************

    // 옷을 보여주는 함수.(최고온도)
    public void clothesShowMax(int max_temp, String result){
        ClothesArray_woman woman = new ClothesArray_woman();

        // temp => 현재 온도값의 범위, result => 사용자가 설문지 조사한 결과
        // 최고기온과 결과값
        if(max_temp == 4){
            if(result.equals("BAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes1.setImageResource(woman.BAA4[0]);
                V_ITopclothes2.setImageResource(woman.BAA4[1]);
                V_ITopclothes3.setImageResource(woman.BAA4[2]);
                V_IOuterclothes1.setImageResource(woman.BAA4[3]);
                V_IOuterclothes2.setImageResource(woman.BAA4[4]);
                V_IOuterclothes3.setImageResource(woman.BAA4[5]);
                V_IBottomclothes1.setImageResource(woman.BAA4[6]);
                V_IBottomclothes2.setImageResource(woman.BAA4[7]);
                V_IBottomclothes3.setImageResource(woman.BAA4[8]);
                V_txtTop1.setText(woman.txt_BAA4[0]);
                V_txtTop2.setText(woman.txt_BAA4[1]);
                V_txtTop3.setText(woman.txt_BAA4[2]);
                V_txtOuter1.setText(woman.txt_BAA4[3]);
                V_txtOuter2.setText(woman.txt_BAA4[4]);
                V_txtOuter3.setText(woman.txt_BAA4[5]);
                V_txtBottom1.setText(woman.txt_BAA4[6]);
                V_txtBottom2.setText(woman.txt_BAA4[7]);
                V_txtBottom3.setText(woman.txt_BAA4[8]);

            }else if(result.equals("BAB")){
                // 더위많이탐 빈티지
                V_ITopclothes1.setImageResource(woman.BAB4[0]);
                V_ITopclothes2.setImageResource(woman.BAB4[1]);
                V_ITopclothes3.setImageResource(woman.BAB4[2]);
                V_IOuterclothes1.setImageResource(woman.BAB4[3]);
                V_IOuterclothes2.setImageResource(woman.BAB4[4]);
                V_IOuterclothes3.setImageResource(woman.BAB4[5]);
                V_IBottomclothes1.setImageResource(woman.BAB4[6]);
                V_IBottomclothes2.setImageResource(woman.BAB4[7]);
                V_IBottomclothes3.setImageResource(woman.BAB4[8]);
                V_txtTop1.setText(woman.txt_BAB4[0]);
                V_txtTop2.setText(woman.txt_BAB4[1]);
                V_txtTop3.setText(woman.txt_BAB4[2]);
                V_txtOuter1.setText(woman.txt_BAB4[3]);
                V_txtOuter2.setText(woman.txt_BAB4[4]);
                V_txtOuter3.setText(woman.txt_BAB4[5]);
                V_txtBottom1.setText(woman.txt_BAB4[6]);
                V_txtBottom2.setText(woman.txt_BAB4[7]);
                V_txtBottom3.setText(woman.txt_BAB4[8]);
            }else if(result.equals("BAC")){
                // 더위많이탐 스트릿
                V_ITopclothes1.setImageResource(woman.BAC4[0]);
                V_ITopclothes2.setImageResource(woman.BAC4[1]);
                V_ITopclothes3.setImageResource(woman.BAC4[2]);
                V_IOuterclothes1.setImageResource(woman.BAC4[3]);
                V_IOuterclothes2.setImageResource(woman.BAC4[4]);
                V_IOuterclothes3.setImageResource(woman.BAC4[5]);
                V_IBottomclothes1.setImageResource(woman.BAC4[6]);
                V_IBottomclothes2.setImageResource(woman.BAC4[7]);
                V_IBottomclothes3.setImageResource(woman.BAC4[8]);
                V_txtTop1.setText(woman.txt_BAC4[0]);
                V_txtTop2.setText(woman.txt_BAC4[1]);
                V_txtTop3.setText(woman.txt_BAC4[2]);
                V_txtOuter1.setText(woman.txt_BAC4[3]);
                V_txtOuter2.setText(woman.txt_BAC4[4]);
                V_txtOuter3.setText(woman.txt_BAC4[5]);
                V_txtBottom1.setText(woman.txt_BAC4[6]);
                V_txtBottom2.setText(woman.txt_BAC4[7]);
                V_txtBottom3.setText(woman.txt_BAC4[8]);
            }else if(result.equals("BAD")){
                // 더위많이탐 댄디
                V_ITopclothes1.setImageResource(woman.BAD4[0]);
                V_ITopclothes2.setImageResource(woman.BAD4[1]);
                V_ITopclothes3.setImageResource(woman.BAD4[2]);
                V_IOuterclothes1.setImageResource(woman.BAD4[3]);
                V_IOuterclothes2.setImageResource(woman.BAD4[4]);
                V_IOuterclothes3.setImageResource(woman.BAD4[5]);
                V_IBottomclothes1.setImageResource(woman.BAD4[6]);
                V_IBottomclothes2.setImageResource(woman.BAD4[7]);
                V_IBottomclothes3.setImageResource(woman.BAD4[8]);
                V_txtTop1.setText(woman.txt_BAD4[0]);
                V_txtTop2.setText(woman.txt_BAD4[1]);
                V_txtTop3.setText(woman.txt_BAD4[2]);
                V_txtOuter1.setText(woman.txt_BAD4[3]);
                V_txtOuter2.setText(woman.txt_BAD4[4]);
                V_txtOuter3.setText(woman.txt_BAD4[5]);
                V_txtBottom1.setText(woman.txt_BAD4[6]);
                V_txtBottom2.setText(woman.txt_BAD4[7]);
                V_txtBottom3.setText(woman.txt_BAD4[8]);

            }else if(result.equals("BAE")){
                // 더위많이탐 스포티
                V_ITopclothes1.setImageResource(woman.BAE4[0]);
                V_ITopclothes2.setImageResource(woman.BAE4[1]);
                V_ITopclothes3.setImageResource(woman.BAE4[2]);
                V_IOuterclothes1.setImageResource(woman.BAE4[3]);
                V_IOuterclothes2.setImageResource(woman.BAE4[4]);
                V_IOuterclothes3.setImageResource(woman.BAE4[5]);
                V_IBottomclothes1.setImageResource(woman.BAE4[6]);
                V_IBottomclothes2.setImageResource(woman.BAE4[7]);
                V_IBottomclothes3.setImageResource(woman.BAE4[8]);
                V_txtTop1.setText(woman.txt_BAE4[0]);
                V_txtTop2.setText(woman.txt_BAE4[1]);
                V_txtTop3.setText(woman.txt_BAE4[2]);
                V_txtOuter1.setText(woman.txt_BAE4[3]);
                V_txtOuter2.setText(woman.txt_BAE4[4]);
                V_txtOuter3.setText(woman.txt_BAE4[5]);
                V_txtBottom1.setText(woman.txt_BAE4[6]);
                V_txtBottom2.setText(woman.txt_BAE4[7]);
                V_txtBottom3.setText(woman.txt_BAE4[8]);

            }else if(result.equals("BBA")){
                // 더위적게탐 캐주얼
                V_ITopclothes1.setImageResource(woman.BBA4[0]);
                V_ITopclothes2.setImageResource(woman.BBA4[1]);
                V_ITopclothes3.setImageResource(woman.BBA4[2]);
                V_IOuterclothes1.setImageResource(woman.BBA4[3]);
                V_IOuterclothes2.setImageResource(woman.BBA4[4]);
                V_IOuterclothes3.setImageResource(woman.BBA4[5]);
                V_IBottomclothes1.setImageResource(woman.BBA4[6]);
                V_IBottomclothes2.setImageResource(woman.BBA4[7]);
                V_IBottomclothes3.setImageResource(woman.BBA4[8]);
                V_txtTop1.setText(woman.txt_BBA4[0]);
                V_txtTop2.setText(woman.txt_BBA4[1]);
                V_txtTop3.setText(woman.txt_BBA4[2]);
                V_txtOuter1.setText(woman.txt_BBA4[3]);
                V_txtOuter2.setText(woman.txt_BBA4[4]);
                V_txtOuter3.setText(woman.txt_BBA4[5]);
                V_txtBottom1.setText(woman.txt_BBA4[6]);
                V_txtBottom2.setText(woman.txt_BBA4[7]);
                V_txtBottom3.setText(woman.txt_BBA4[8]);

            }else if(result.equals("BBB")){
                // 더위적게탐 빈티지
                V_ITopclothes1.setImageResource(woman.BBB4[0]);
                V_ITopclothes2.setImageResource(woman.BBB4[1]);
                V_ITopclothes3.setImageResource(woman.BBB4[2]);
                V_IOuterclothes1.setImageResource(woman.BBB4[3]);
                V_IOuterclothes2.setImageResource(woman.BBB4[4]);
                V_IOuterclothes3.setImageResource(woman.BBB4[5]);
                V_IBottomclothes1.setImageResource(woman.BBB4[6]);
                V_IBottomclothes2.setImageResource(woman.BBB4[7]);
                V_IBottomclothes3.setImageResource(woman.BBB4[8]);
                V_txtTop1.setText(woman.txt_BBB4[0]);
                V_txtTop2.setText(woman.txt_BBB4[1]);
                V_txtTop3.setText(woman.txt_BBB4[2]);
                V_txtOuter1.setText(woman.txt_BBB4[3]);
                V_txtOuter2.setText(woman.txt_BBB4[4]);
                V_txtOuter3.setText(woman.txt_BBB4[5]);
                V_txtBottom1.setText(woman.txt_BBB4[6]);
                V_txtBottom2.setText(woman.txt_BBB4[7]);
                V_txtBottom3.setText(woman.txt_BBB4[8]);
            }else if(result.equals("BBC")){
                // 더위적게탐 스트릿
                V_ITopclothes1.setImageResource(woman.BBC4[0]);
                V_ITopclothes2.setImageResource(woman.BBC4[1]);
                V_ITopclothes3.setImageResource(woman.BBC4[2]);
                V_IOuterclothes1.setImageResource(woman.BBC4[3]);
                V_IOuterclothes2.setImageResource(woman.BBC4[4]);
                V_IOuterclothes3.setImageResource(woman.BBC4[5]);
                V_IBottomclothes1.setImageResource(woman.BBC4[6]);
                V_IBottomclothes2.setImageResource(woman.BBC4[7]);
                V_IBottomclothes3.setImageResource(woman.BBC4[8]);
                V_txtTop1.setText(woman.txt_BBC4[0]);
                V_txtTop2.setText(woman.txt_BBC4[1]);
                V_txtTop3.setText(woman.txt_BBC4[2]);
                V_txtOuter1.setText(woman.txt_BBC4[3]);
                V_txtOuter2.setText(woman.txt_BBC4[4]);
                V_txtOuter3.setText(woman.txt_BBC4[5]);
                V_txtBottom1.setText(woman.txt_BBC4[6]);
                V_txtBottom2.setText(woman.txt_BBC4[7]);
                V_txtBottom3.setText(woman.txt_BBC4[8]);
            }else if(result.equals("BBD")){
                // 더위적게탐 댄디
                V_ITopclothes1.setImageResource(woman.BBD4[0]);
                V_ITopclothes2.setImageResource(woman.BBD4[1]);
                V_ITopclothes3.setImageResource(woman.BBD4[2]);
                V_IOuterclothes1.setImageResource(woman.BBD4[3]);
                V_IOuterclothes2.setImageResource(woman.BBD4[4]);
                V_IOuterclothes3.setImageResource(woman.BBD4[5]);
                V_IBottomclothes1.setImageResource(woman.BBD4[6]);
                V_IBottomclothes2.setImageResource(woman.BBD4[7]);
                V_IBottomclothes3.setImageResource(woman.BBD4[8]);
                V_txtTop1.setText(woman.txt_BBD4[0]);
                V_txtTop2.setText(woman.txt_BBD4[1]);
                V_txtTop3.setText(woman.txt_BBD4[2]);
                V_txtOuter1.setText(woman.txt_BBD4[3]);
                V_txtOuter2.setText(woman.txt_BBD4[4]);
                V_txtOuter3.setText(woman.txt_BBD4[5]);
                V_txtBottom1.setText(woman.txt_BBD4[6]);
                V_txtBottom2.setText(woman.txt_BBD4[7]);
                V_txtBottom3.setText(woman.txt_BBD4[8]);

            }else{
                // BBE 더위적게탐 스포티
                V_ITopclothes1.setImageResource(woman.BBE4[0]);
                V_ITopclothes2.setImageResource(woman.BBE4[1]);
                V_ITopclothes3.setImageResource(woman.BBE4[2]);
                V_IOuterclothes1.setImageResource(woman.BBE4[3]);
                V_IOuterclothes2.setImageResource(woman.BBE4[4]);
                V_IOuterclothes3.setImageResource(woman.BBE4[5]);
                V_IBottomclothes1.setImageResource(woman.BBE4[6]);
                V_IBottomclothes2.setImageResource(woman.BBE4[7]);
                V_IBottomclothes3.setImageResource(woman.BBE4[8]);
                V_txtTop1.setText(woman.txt_BBE4[0]);
                V_txtTop2.setText(woman.txt_BBE4[1]);
                V_txtTop3.setText(woman.txt_BBE4[2]);
                V_txtOuter1.setText(woman.txt_BBE4[3]);
                V_txtOuter2.setText(woman.txt_BBE4[4]);
                V_txtOuter3.setText(woman.txt_BBE4[5]);
                V_txtBottom1.setText(woman.txt_BBE4[6]);
                V_txtBottom2.setText(woman.txt_BBE4[7]);
                V_txtBottom3.setText(woman.txt_BBE4[8]);
            }
        }else if(max_temp == 5){
            if(result.equals("BAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes1.setImageResource(woman.BAA5[0]);
                V_ITopclothes2.setImageResource(woman.BAA5[1]);
                V_ITopclothes3.setImageResource(woman.BAA5[2]);
                V_IOuterclothes1.setImageResource(woman.BAA5[3]);
                V_IOuterclothes2.setImageResource(woman.BAA5[4]);
                V_IOuterclothes3.setImageResource(woman.BAA5[5]);
                V_IBottomclothes1.setImageResource(woman.BAA5[6]);
                V_IBottomclothes2.setImageResource(woman.BAA5[7]);
                V_IBottomclothes3.setImageResource(woman.BAA5[8]);
                V_txtTop1.setText(woman.txt_BAA5[0]);
                V_txtTop2.setText(woman.txt_BAA5[1]);
                V_txtTop3.setText(woman.txt_BAA5[2]);
                V_txtOuter1.setText(woman.txt_BAA5[3]);
                V_txtOuter2.setText(woman.txt_BAA5[4]);
                V_txtOuter3.setText(woman.txt_BAA5[5]);
                V_txtBottom1.setText(woman.txt_BAA5[6]);
                V_txtBottom2.setText(woman.txt_BAA5[7]);
                V_txtBottom3.setText(woman.txt_BAA5[8]);

            }else if(result.equals("BAB")){
                // 더위많이탐 빈티지
                V_ITopclothes1.setImageResource(woman.BAB5[0]);
                V_ITopclothes2.setImageResource(woman.BAB5[1]);
                V_ITopclothes3.setImageResource(woman.BAB5[2]);
                V_IOuterclothes1.setImageResource(woman.BAB5[3]);
                V_IOuterclothes2.setImageResource(woman.BAB5[4]);
                V_IOuterclothes3.setImageResource(woman.BAB5[5]);
                V_IBottomclothes1.setImageResource(woman.BAB5[6]);
                V_IBottomclothes2.setImageResource(woman.BAB5[7]);
                V_IBottomclothes3.setImageResource(woman.BAB5[8]);
                V_txtTop1.setText(woman.txt_BAB5[0]);
                V_txtTop2.setText(woman.txt_BAB5[1]);
                V_txtTop3.setText(woman.txt_BAB5[2]);
                V_txtOuter1.setText(woman.txt_BAB5[3]);
                V_txtOuter2.setText(woman.txt_BAB5[4]);
                V_txtOuter3.setText(woman.txt_BAB5[5]);
                V_txtBottom1.setText(woman.txt_BAB5[6]);
                V_txtBottom2.setText(woman.txt_BAB5[7]);
                V_txtBottom3.setText(woman.txt_BAB5[8]);
            }else if(result.equals("BAC")){
                // 더위많이탐 스트릿
                V_ITopclothes1.setImageResource(woman.BAC5[0]);
                V_ITopclothes2.setImageResource(woman.BAC5[1]);
                V_ITopclothes3.setImageResource(woman.BAC5[2]);
                V_IOuterclothes1.setImageResource(woman.BAC5[3]);
                V_IOuterclothes2.setImageResource(woman.BAC5[4]);
                V_IOuterclothes3.setImageResource(woman.BAC5[5]);
                V_IBottomclothes1.setImageResource(woman.BAC5[6]);
                V_IBottomclothes2.setImageResource(woman.BAC5[7]);
                V_IBottomclothes3.setImageResource(woman.BAC5[8]);
                V_txtTop1.setText(woman.txt_BAC5[0]);
                V_txtTop2.setText(woman.txt_BAC5[1]);
                V_txtTop3.setText(woman.txt_BAC5[2]);
                V_txtOuter1.setText(woman.txt_BAC5[3]);
                V_txtOuter2.setText(woman.txt_BAC5[4]);
                V_txtOuter3.setText(woman.txt_BAC5[5]);
                V_txtBottom1.setText(woman.txt_BAC5[6]);
                V_txtBottom2.setText(woman.txt_BAC5[7]);
                V_txtBottom3.setText(woman.txt_BAC5[8]);
            }else if(result.equals("BAD")){
                // 더위많이탐 댄디
                V_ITopclothes1.setImageResource(woman.BAD5[0]);
                V_ITopclothes2.setImageResource(woman.BAD5[1]);
                V_ITopclothes3.setImageResource(woman.BAD5[2]);
                V_IOuterclothes1.setImageResource(woman.BAD5[3]);
                V_IOuterclothes2.setImageResource(woman.BAD5[4]);
                V_IOuterclothes3.setImageResource(woman.BAD5[5]);
                V_IBottomclothes1.setImageResource(woman.BAD5[6]);
                V_IBottomclothes2.setImageResource(woman.BAD5[7]);
                V_IBottomclothes3.setImageResource(woman.BAD5[8]);
                V_txtTop1.setText(woman.txt_BAD5[0]);
                V_txtTop2.setText(woman.txt_BAD5[1]);
                V_txtTop3.setText(woman.txt_BAD5[2]);
                V_txtOuter1.setText(woman.txt_BAD5[3]);
                V_txtOuter2.setText(woman.txt_BAD5[4]);
                V_txtOuter3.setText(woman.txt_BAD5[5]);
                V_txtBottom1.setText(woman.txt_BAD5[6]);
                V_txtBottom2.setText(woman.txt_BAD5[7]);
                V_txtBottom3.setText(woman.txt_BAD5[8]);

            }else if(result.equals("BAE")){
                // 더위많이탐 스포티
                V_ITopclothes1.setImageResource(woman.BAE5[0]);
                V_ITopclothes2.setImageResource(woman.BAE5[1]);
                V_ITopclothes3.setImageResource(woman.BAE5[2]);
                V_IOuterclothes1.setImageResource(woman.BAE5[3]);
                V_IOuterclothes2.setImageResource(woman.BAE5[4]);
                V_IOuterclothes3.setImageResource(woman.BAE5[5]);
                V_IBottomclothes1.setImageResource(woman.BAE5[6]);
                V_IBottomclothes2.setImageResource(woman.BAE5[7]);
                V_IBottomclothes3.setImageResource(woman.BAE5[8]);
                V_txtTop1.setText(woman.txt_BAE5[0]);
                V_txtTop2.setText(woman.txt_BAE5[1]);
                V_txtTop3.setText(woman.txt_BAE5[2]);
                V_txtOuter1.setText(woman.txt_BAE5[3]);
                V_txtOuter2.setText(woman.txt_BAE5[4]);
                V_txtOuter3.setText(woman.txt_BAE5[5]);
                V_txtBottom1.setText(woman.txt_BAE5[6]);
                V_txtBottom2.setText(woman.txt_BAE5[7]);
                V_txtBottom3.setText(woman.txt_BAE5[8]);

            }else if(result.equals("BBA")){
                // 더위적게탐 캐주얼
                V_ITopclothes1.setImageResource(woman.BBA5[0]);
                V_ITopclothes2.setImageResource(woman.BBA5[1]);
                V_ITopclothes3.setImageResource(woman.BBA5[2]);
                V_IOuterclothes1.setImageResource(woman.BBA5[3]);
                V_IOuterclothes2.setImageResource(woman.BBA5[4]);
                V_IOuterclothes3.setImageResource(woman.BBA5[5]);
                V_IBottomclothes1.setImageResource(woman.BBA5[6]);
                V_IBottomclothes2.setImageResource(woman.BBA5[7]);
                V_IBottomclothes3.setImageResource(woman.BBA5[8]);
                V_txtTop1.setText(woman.txt_BBA5[0]);
                V_txtTop2.setText(woman.txt_BBA5[1]);
                V_txtTop3.setText(woman.txt_BBA5[2]);
                V_txtOuter1.setText(woman.txt_BBA5[3]);
                V_txtOuter2.setText(woman.txt_BBA5[4]);
                V_txtOuter3.setText(woman.txt_BBA5[5]);
                V_txtBottom1.setText(woman.txt_BBA5[6]);
                V_txtBottom2.setText(woman.txt_BBA5[7]);
                V_txtBottom3.setText(woman.txt_BBA5[8]);

            }else if(result.equals("BBB")){
                // 더위적게탐 빈티지
                V_ITopclothes1.setImageResource(woman.BBB5[0]);
                V_ITopclothes2.setImageResource(woman.BBB5[1]);
                V_ITopclothes3.setImageResource(woman.BBB5[2]);
                V_IOuterclothes1.setImageResource(woman.BBB5[3]);
                V_IOuterclothes2.setImageResource(woman.BBB5[4]);
                V_IOuterclothes3.setImageResource(woman.BBB5[5]);
                V_IBottomclothes1.setImageResource(woman.BBB5[6]);
                V_IBottomclothes2.setImageResource(woman.BBB5[7]);
                V_IBottomclothes3.setImageResource(woman.BBB5[8]);
                V_txtTop1.setText(woman.txt_BBB5[0]);
                V_txtTop2.setText(woman.txt_BBB5[1]);
                V_txtTop3.setText(woman.txt_BBB5[2]);
                V_txtOuter1.setText(woman.txt_BBB5[3]);
                V_txtOuter2.setText(woman.txt_BBB5[4]);
                V_txtOuter3.setText(woman.txt_BBB5[5]);
                V_txtBottom1.setText(woman.txt_BBB5[6]);
                V_txtBottom2.setText(woman.txt_BBB5[7]);
                V_txtBottom3.setText(woman.txt_BBB5[8]);
            }else if(result.equals("BBC")){
                // 더위적게탐 스트릿
                V_ITopclothes1.setImageResource(woman.BBC5[0]);
                V_ITopclothes2.setImageResource(woman.BBC5[1]);
                V_ITopclothes3.setImageResource(woman.BBC5[2]);
                V_IOuterclothes1.setImageResource(woman.BBC5[3]);
                V_IOuterclothes2.setImageResource(woman.BBC5[4]);
                V_IOuterclothes3.setImageResource(woman.BBC5[5]);
                V_IBottomclothes1.setImageResource(woman.BBC5[6]);
                V_IBottomclothes2.setImageResource(woman.BBC5[7]);
                V_IBottomclothes3.setImageResource(woman.BBC5[8]);
                V_txtTop1.setText(woman.txt_BBC5[0]);
                V_txtTop2.setText(woman.txt_BBC5[1]);
                V_txtTop3.setText(woman.txt_BBC5[2]);
                V_txtOuter1.setText(woman.txt_BBC5[3]);
                V_txtOuter2.setText(woman.txt_BBC5[4]);
                V_txtOuter3.setText(woman.txt_BBC5[5]);
                V_txtBottom1.setText(woman.txt_BBC5[6]);
                V_txtBottom2.setText(woman.txt_BBC5[7]);
                V_txtBottom3.setText(woman.txt_BBC5[8]);
            }else if(result.equals("BBD")){
                // 더위적게탐 댄디
                V_ITopclothes1.setImageResource(woman.BBD5[0]);
                V_ITopclothes2.setImageResource(woman.BBD5[1]);
                V_ITopclothes3.setImageResource(woman.BBD5[2]);
                V_IOuterclothes1.setImageResource(woman.BBD5[3]);
                V_IOuterclothes2.setImageResource(woman.BBD5[4]);
                V_IOuterclothes3.setImageResource(woman.BBD5[5]);
                V_IBottomclothes1.setImageResource(woman.BBD5[6]);
                V_IBottomclothes2.setImageResource(woman.BBD5[7]);
                V_IBottomclothes3.setImageResource(woman.BBD5[8]);
                V_txtTop1.setText(woman.txt_BBD5[0]);
                V_txtTop2.setText(woman.txt_BBD5[1]);
                V_txtTop3.setText(woman.txt_BBD5[2]);
                V_txtOuter1.setText(woman.txt_BBD5[3]);
                V_txtOuter2.setText(woman.txt_BBD5[4]);
                V_txtOuter3.setText(woman.txt_BBD5[5]);
                V_txtBottom1.setText(woman.txt_BBD5[6]);
                V_txtBottom2.setText(woman.txt_BBD5[7]);
                V_txtBottom3.setText(woman.txt_BBD5[8]);

            }else{
                // BBE 더위적게탐 스포티
                V_ITopclothes1.setImageResource(woman.BBE5[0]);
                V_ITopclothes2.setImageResource(woman.BBE5[1]);
                V_ITopclothes3.setImageResource(woman.BBE5[2]);
                V_IOuterclothes1.setImageResource(woman.BBE5[3]);
                V_IOuterclothes2.setImageResource(woman.BBE5[4]);
                V_IOuterclothes3.setImageResource(woman.BBE5[5]);
                V_IBottomclothes1.setImageResource(woman.BBE5[6]);
                V_IBottomclothes2.setImageResource(woman.BBE5[7]);
                V_IBottomclothes3.setImageResource(woman.BBE5[8]);
                V_txtTop1.setText(woman.txt_BBE5[0]);
                V_txtTop2.setText(woman.txt_BBE5[1]);
                V_txtTop3.setText(woman.txt_BBE5[2]);
                V_txtOuter1.setText(woman.txt_BBE5[3]);
                V_txtOuter2.setText(woman.txt_BBE5[4]);
                V_txtOuter3.setText(woman.txt_BBE5[5]);
                V_txtBottom1.setText(woman.txt_BBE5[6]);
                V_txtBottom2.setText(woman.txt_BBE5[7]);
                V_txtBottom3.setText(woman.txt_BBE5[8]);
            }
        }else if(max_temp == 9){
            if(result.equals("BAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes1.setImageResource(woman.BAA9[0]);
                V_ITopclothes2.setImageResource(woman.BAA9[1]);
                V_ITopclothes3.setImageResource(woman.BAA9[2]);
                V_IOuterclothes1.setImageResource(woman.BAA9[3]);
                V_IOuterclothes2.setImageResource(woman.BAA9[4]);
                V_IOuterclothes3.setImageResource(woman.BAA9[5]);
                V_IBottomclothes1.setImageResource(woman.BAA9[6]);
                V_IBottomclothes2.setImageResource(woman.BAA9[7]);
                V_IBottomclothes3.setImageResource(woman.BAA9[8]);
                V_txtTop1.setText(woman.txt_BAA9[0]);
                V_txtTop2.setText(woman.txt_BAA9[1]);
                V_txtTop3.setText(woman.txt_BAA9[2]);
                V_txtOuter1.setText(woman.txt_BAA9[3]);
                V_txtOuter2.setText(woman.txt_BAA9[4]);
                V_txtOuter3.setText(woman.txt_BAA9[5]);
                V_txtBottom1.setText(woman.txt_BAA9[6]);
                V_txtBottom2.setText(woman.txt_BAA9[7]);
                V_txtBottom3.setText(woman.txt_BAA9[8]);

            }else if(result.equals("BAB")){
                // 더위많이탐 빈티지
                V_ITopclothes1.setImageResource(woman.BAB9[0]);
                V_ITopclothes2.setImageResource(woman.BAB9[1]);
                V_ITopclothes3.setImageResource(woman.BAB9[2]);
                V_IOuterclothes1.setImageResource(woman.BAB9[3]);
                V_IOuterclothes2.setImageResource(woman.BAB9[4]);
                V_IOuterclothes3.setImageResource(woman.BAB9[5]);
                V_IBottomclothes1.setImageResource(woman.BAB9[6]);
                V_IBottomclothes2.setImageResource(woman.BAB9[7]);
                V_IBottomclothes3.setImageResource(woman.BAB9[8]);
                V_txtTop1.setText(woman.txt_BAB9[0]);
                V_txtTop2.setText(woman.txt_BAB9[1]);
                V_txtTop3.setText(woman.txt_BAB9[2]);
                V_txtOuter1.setText(woman.txt_BAB9[3]);
                V_txtOuter2.setText(woman.txt_BAB9[4]);
                V_txtOuter3.setText(woman.txt_BAB9[5]);
                V_txtBottom1.setText(woman.txt_BAB9[6]);
                V_txtBottom2.setText(woman.txt_BAB9[7]);
                V_txtBottom3.setText(woman.txt_BAB9[8]);
            }else if(result.equals("BAC")){
                // 더위많이탐 스트릿
                V_ITopclothes1.setImageResource(woman.BAC9[0]);
                V_ITopclothes2.setImageResource(woman.BAC9[1]);
                V_ITopclothes3.setImageResource(woman.BAC9[2]);
                V_IOuterclothes1.setImageResource(woman.BAC9[3]);
                V_IOuterclothes2.setImageResource(woman.BAC9[4]);
                V_IOuterclothes3.setImageResource(woman.BAC9[5]);
                V_IBottomclothes1.setImageResource(woman.BAC9[6]);
                V_IBottomclothes2.setImageResource(woman.BAC9[7]);
                V_IBottomclothes3.setImageResource(woman.BAC9[8]);
                V_txtTop1.setText(woman.txt_BAC9[0]);
                V_txtTop2.setText(woman.txt_BAC9[1]);
                V_txtTop3.setText(woman.txt_BAC9[2]);
                V_txtOuter1.setText(woman.txt_BAC9[3]);
                V_txtOuter2.setText(woman.txt_BAC9[4]);
                V_txtOuter3.setText(woman.txt_BAC9[5]);
                V_txtBottom1.setText(woman.txt_BAC9[6]);
                V_txtBottom2.setText(woman.txt_BAC9[7]);
                V_txtBottom3.setText(woman.txt_BAC9[8]);
            }else if(result.equals("BAD")){
                // 더위많이탐 댄디
                V_ITopclothes1.setImageResource(woman.BAD9[0]);
                V_ITopclothes2.setImageResource(woman.BAD9[1]);
                V_ITopclothes3.setImageResource(woman.BAD9[2]);
                V_IOuterclothes1.setImageResource(woman.BAD9[3]);
                V_IOuterclothes2.setImageResource(woman.BAD9[4]);
                V_IOuterclothes3.setImageResource(woman.BAD9[5]);
                V_IBottomclothes1.setImageResource(woman.BAD9[6]);
                V_IBottomclothes2.setImageResource(woman.BAD9[7]);
                V_IBottomclothes3.setImageResource(woman.BAD9[8]);
                V_txtTop1.setText(woman.txt_BAD9[0]);
                V_txtTop2.setText(woman.txt_BAD9[1]);
                V_txtTop3.setText(woman.txt_BAD9[2]);
                V_txtOuter1.setText(woman.txt_BAD9[3]);
                V_txtOuter2.setText(woman.txt_BAD9[4]);
                V_txtOuter3.setText(woman.txt_BAD9[5]);
                V_txtBottom1.setText(woman.txt_BAD9[6]);
                V_txtBottom2.setText(woman.txt_BAD9[7]);
                V_txtBottom3.setText(woman.txt_BAD9[8]);

            }else if(result.equals("BAE")){
                // 더위많이탐 스포티
                V_ITopclothes1.setImageResource(woman.BAE9[0]);
                V_ITopclothes2.setImageResource(woman.BAE9[1]);
                V_ITopclothes3.setImageResource(woman.BAE9[2]);
                V_IOuterclothes1.setImageResource(woman.BAE9[3]);
                V_IOuterclothes2.setImageResource(woman.BAE9[4]);
                V_IOuterclothes3.setImageResource(woman.BAE9[5]);
                V_IBottomclothes1.setImageResource(woman.BAE9[6]);
                V_IBottomclothes2.setImageResource(woman.BAE9[7]);
                V_IBottomclothes3.setImageResource(woman.BAE9[8]);
                V_txtTop1.setText(woman.txt_BAE9[0]);
                V_txtTop2.setText(woman.txt_BAE9[1]);
                V_txtTop3.setText(woman.txt_BAE9[2]);
                V_txtOuter1.setText(woman.txt_BAE9[3]);
                V_txtOuter2.setText(woman.txt_BAE9[4]);
                V_txtOuter3.setText(woman.txt_BAE9[5]);
                V_txtBottom1.setText(woman.txt_BAE9[6]);
                V_txtBottom2.setText(woman.txt_BAE9[7]);
                V_txtBottom3.setText(woman.txt_BAE9[8]);

            }else if(result.equals("BBA")){
                // 더위적게탐 캐주얼
                V_ITopclothes1.setImageResource(woman.BBA9[0]);
                V_ITopclothes2.setImageResource(woman.BBA9[1]);
                V_ITopclothes3.setImageResource(woman.BBA9[2]);
                V_IOuterclothes1.setImageResource(woman.BBA9[3]);
                V_IOuterclothes2.setImageResource(woman.BBA9[4]);
                V_IOuterclothes3.setImageResource(woman.BBA9[5]);
                V_IBottomclothes1.setImageResource(woman.BBA9[6]);
                V_IBottomclothes2.setImageResource(woman.BBA9[7]);
                V_IBottomclothes3.setImageResource(woman.BBA9[8]);
                V_txtTop1.setText(woman.txt_BBA9[0]);
                V_txtTop2.setText(woman.txt_BBA9[1]);
                V_txtTop3.setText(woman.txt_BBA9[2]);
                V_txtOuter1.setText(woman.txt_BBA9[3]);
                V_txtOuter2.setText(woman.txt_BBA9[4]);
                V_txtOuter3.setText(woman.txt_BBA9[5]);
                V_txtBottom1.setText(woman.txt_BBA9[6]);
                V_txtBottom2.setText(woman.txt_BBA9[7]);
                V_txtBottom3.setText(woman.txt_BBA9[8]);

            }else if(result.equals("BBB")){
                // 더위적게탐 빈티지
                V_ITopclothes1.setImageResource(woman.BBB9[0]);
                V_ITopclothes2.setImageResource(woman.BBB9[1]);
                V_ITopclothes3.setImageResource(woman.BBB9[2]);
                V_IOuterclothes1.setImageResource(woman.BBB9[3]);
                V_IOuterclothes2.setImageResource(woman.BBB9[4]);
                V_IOuterclothes3.setImageResource(woman.BBB9[5]);
                V_IBottomclothes1.setImageResource(woman.BBB9[6]);
                V_IBottomclothes2.setImageResource(woman.BBB9[7]);
                V_IBottomclothes3.setImageResource(woman.BBB9[8]);
                V_txtTop1.setText(woman.txt_BBB9[0]);
                V_txtTop2.setText(woman.txt_BBB9[1]);
                V_txtTop3.setText(woman.txt_BBB9[2]);
                V_txtOuter1.setText(woman.txt_BBB9[3]);
                V_txtOuter2.setText(woman.txt_BBB9[4]);
                V_txtOuter3.setText(woman.txt_BBB9[5]);
                V_txtBottom1.setText(woman.txt_BBB9[6]);
                V_txtBottom2.setText(woman.txt_BBB9[7]);
                V_txtBottom3.setText(woman.txt_BBB9[8]);
            }else if(result.equals("BBC")){
                // 더위적게탐 스트릿
                V_ITopclothes1.setImageResource(woman.BBC9[0]);
                V_ITopclothes2.setImageResource(woman.BBC9[1]);
                V_ITopclothes3.setImageResource(woman.BBC9[2]);
                V_IOuterclothes1.setImageResource(woman.BBC9[3]);
                V_IOuterclothes2.setImageResource(woman.BBC9[4]);
                V_IOuterclothes3.setImageResource(woman.BBC9[5]);
                V_IBottomclothes1.setImageResource(woman.BBC9[6]);
                V_IBottomclothes2.setImageResource(woman.BBC9[7]);
                V_IBottomclothes3.setImageResource(woman.BBC9[8]);
                V_txtTop1.setText(woman.txt_BBC9[0]);
                V_txtTop2.setText(woman.txt_BBC9[1]);
                V_txtTop3.setText(woman.txt_BBC9[2]);
                V_txtOuter1.setText(woman.txt_BBC9[3]);
                V_txtOuter2.setText(woman.txt_BBC9[4]);
                V_txtOuter3.setText(woman.txt_BBC9[5]);
                V_txtBottom1.setText(woman.txt_BBC9[6]);
                V_txtBottom2.setText(woman.txt_BBC9[7]);
                V_txtBottom3.setText(woman.txt_BBC9[8]);
            }else if(result.equals("BBD")){
                // 더위적게탐 댄디
                V_ITopclothes1.setImageResource(woman.BBD9[0]);
                V_ITopclothes2.setImageResource(woman.BBD9[1]);
                V_ITopclothes3.setImageResource(woman.BBD9[2]);
                V_IOuterclothes1.setImageResource(woman.BBD9[3]);
                V_IOuterclothes2.setImageResource(woman.BBD9[4]);
                V_IOuterclothes3.setImageResource(woman.BBD9[5]);
                V_IBottomclothes1.setImageResource(woman.BBD9[6]);
                V_IBottomclothes2.setImageResource(woman.BBD9[7]);
                V_IBottomclothes3.setImageResource(woman.BBD9[8]);
                V_txtTop1.setText(woman.txt_BBD9[0]);
                V_txtTop2.setText(woman.txt_BBD9[1]);
                V_txtTop3.setText(woman.txt_BBD9[2]);
                V_txtOuter1.setText(woman.txt_BBD9[3]);
                V_txtOuter2.setText(woman.txt_BBD9[4]);
                V_txtOuter3.setText(woman.txt_BBD9[5]);
                V_txtBottom1.setText(woman.txt_BBD9[6]);
                V_txtBottom2.setText(woman.txt_BBD9[7]);
                V_txtBottom3.setText(woman.txt_BBD9[8]);

            }else{
                // BBE 더위적게탐 스포티
                V_ITopclothes1.setImageResource(woman.BBE9[0]);
                V_ITopclothes2.setImageResource(woman.BBE9[1]);
                V_ITopclothes3.setImageResource(woman.BBE9[2]);
                V_IOuterclothes1.setImageResource(woman.BBE9[3]);
                V_IOuterclothes2.setImageResource(woman.BBE9[4]);
                V_IOuterclothes3.setImageResource(woman.BBE9[5]);
                V_IBottomclothes1.setImageResource(woman.BBE9[6]);
                V_IBottomclothes2.setImageResource(woman.BBE9[7]);
                V_IBottomclothes3.setImageResource(woman.BBE9[8]);
                V_txtTop1.setText(woman.txt_BBE9[0]);
                V_txtTop2.setText(woman.txt_BBE9[1]);
                V_txtTop3.setText(woman.txt_BBE9[2]);
                V_txtOuter1.setText(woman.txt_BBE9[3]);
                V_txtOuter2.setText(woman.txt_BBE9[4]);
                V_txtOuter3.setText(woman.txt_BBE9[5]);
                V_txtBottom1.setText(woman.txt_BBE9[6]);
                V_txtBottom2.setText(woman.txt_BBE9[7]);
                V_txtBottom3.setText(woman.txt_BBE9[8]);
            }

        }else if(max_temp == 12){
            if(result.equals("BAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes1.setImageResource(woman.BAA4[0]);
                V_ITopclothes2.setImageResource(woman.BAA4[1]);
                V_ITopclothes3.setImageResource(woman.BAA4[2]);
                V_IOuterclothes1.setImageResource(woman.BAA4[3]);
                V_IOuterclothes2.setImageResource(woman.BAA4[4]);
                V_IOuterclothes3.setImageResource(woman.BAA4[5]);
                V_IBottomclothes1.setImageResource(woman.BAA4[6]);
                V_IBottomclothes2.setImageResource(woman.BAA4[7]);
                V_IBottomclothes3.setImageResource(woman.BAA4[8]);
                V_txtTop1.setText(woman.txt_BAA4[0]);
                V_txtTop2.setText(woman.txt_BAA4[1]);
                V_txtTop3.setText(woman.txt_BAA4[2]);
                V_txtOuter1.setText(woman.txt_BAA4[3]);
                V_txtOuter2.setText(woman.txt_BAA4[4]);
                V_txtOuter3.setText(woman.txt_BAA4[5]);
                V_txtBottom1.setText(woman.txt_BAA4[6]);
                V_txtBottom2.setText(woman.txt_BAA4[7]);
                V_txtBottom3.setText(woman.txt_BAA4[8]);

            }else if(result.equals("BAB")){
                // 더위많이탐 빈티지
                V_ITopclothes1.setImageResource(woman.BAB12[0]);
                V_ITopclothes2.setImageResource(woman.BAB12[1]);
                V_ITopclothes3.setImageResource(woman.BAB12[2]);
                V_IOuterclothes1.setImageResource(woman.BAB12[3]);
                V_IOuterclothes2.setImageResource(woman.BAB12[4]);
                V_IOuterclothes3.setImageResource(woman.BAB12[5]);
                V_IBottomclothes1.setImageResource(woman.BAB12[6]);
                V_IBottomclothes2.setImageResource(woman.BAB12[7]);
                V_IBottomclothes3.setImageResource(woman.BAB12[8]);
                V_txtTop1.setText(woman.txt_BAB12[0]);
                V_txtTop2.setText(woman.txt_BAB12[1]);
                V_txtTop3.setText(woman.txt_BAB12[2]);
                V_txtOuter1.setText(woman.txt_BAB12[3]);
                V_txtOuter2.setText(woman.txt_BAB12[4]);
                V_txtOuter3.setText(woman.txt_BAB12[5]);
                V_txtBottom1.setText(woman.txt_BAB12[6]);
                V_txtBottom2.setText(woman.txt_BAB12[7]);
                V_txtBottom3.setText(woman.txt_BAB12[8]);
            }else if(result.equals("BAC")){
                // 더위많이탐 스트릿
                V_ITopclothes1.setImageResource(woman.BAC12[0]);
                V_ITopclothes2.setImageResource(woman.BAC12[1]);
                V_ITopclothes3.setImageResource(woman.BAC12[2]);
                V_IOuterclothes1.setImageResource(woman.BAC12[3]);
                V_IOuterclothes2.setImageResource(woman.BAC12[4]);
                V_IOuterclothes3.setImageResource(woman.BAC12[5]);
                V_IBottomclothes1.setImageResource(woman.BAC12[6]);
                V_IBottomclothes2.setImageResource(woman.BAC12[7]);
                V_IBottomclothes3.setImageResource(woman.BAC12[8]);
                V_txtTop1.setText(woman.txt_BAC12[0]);
                V_txtTop2.setText(woman.txt_BAC12[1]);
                V_txtTop3.setText(woman.txt_BAC12[2]);
                V_txtOuter1.setText(woman.txt_BAC12[3]);
                V_txtOuter2.setText(woman.txt_BAC12[4]);
                V_txtOuter3.setText(woman.txt_BAC12[5]);
                V_txtBottom1.setText(woman.txt_BAC12[6]);
                V_txtBottom2.setText(woman.txt_BAC12[7]);
                V_txtBottom3.setText(woman.txt_BAC12[8]);
            }else if(result.equals("BAD")){
                // 더위많이탐 댄디
                V_ITopclothes1.setImageResource(woman.BAD12[0]);
                V_ITopclothes2.setImageResource(woman.BAD12[1]);
                V_ITopclothes3.setImageResource(woman.BAD12[2]);
                V_IOuterclothes1.setImageResource(woman.BAD12[3]);
                V_IOuterclothes2.setImageResource(woman.BAD12[4]);
                V_IOuterclothes3.setImageResource(woman.BAD12[5]);
                V_IBottomclothes1.setImageResource(woman.BAD12[6]);
                V_IBottomclothes2.setImageResource(woman.BAD12[7]);
                V_IBottomclothes3.setImageResource(woman.BAD12[8]);
                V_txtTop1.setText(woman.txt_BAD12[0]);
                V_txtTop2.setText(woman.txt_BAD12[1]);
                V_txtTop3.setText(woman.txt_BAD12[2]);
                V_txtOuter1.setText(woman.txt_BAD12[3]);
                V_txtOuter2.setText(woman.txt_BAD12[4]);
                V_txtOuter3.setText(woman.txt_BAD12[5]);
                V_txtBottom1.setText(woman.txt_BAD12[6]);
                V_txtBottom2.setText(woman.txt_BAD12[7]);
                V_txtBottom3.setText(woman.txt_BAD12[8]);

            }else if(result.equals("BAE")){
                // 더위많이탐 스포티
                V_ITopclothes1.setImageResource(woman.BAE12[0]);
                V_ITopclothes2.setImageResource(woman.BAE12[1]);
                V_ITopclothes3.setImageResource(woman.BAE12[2]);
                V_IOuterclothes1.setImageResource(woman.BAE12[3]);
                V_IOuterclothes2.setImageResource(woman.BAE12[4]);
                V_IOuterclothes3.setImageResource(woman.BAE12[5]);
                V_IBottomclothes1.setImageResource(woman.BAE12[6]);
                V_IBottomclothes2.setImageResource(woman.BAE12[7]);
                V_IBottomclothes3.setImageResource(woman.BAE12[8]);
                V_txtTop1.setText(woman.txt_BAE12[0]);
                V_txtTop2.setText(woman.txt_BAE12[1]);
                V_txtTop3.setText(woman.txt_BAE12[2]);
                V_txtOuter1.setText(woman.txt_BAE12[3]);
                V_txtOuter2.setText(woman.txt_BAE12[4]);
                V_txtOuter3.setText(woman.txt_BAE12[5]);
                V_txtBottom1.setText(woman.txt_BAE12[6]);
                V_txtBottom2.setText(woman.txt_BAE12[7]);
                V_txtBottom3.setText(woman.txt_BAE12[8]);

            }else if(result.equals("BBA")){
                // 더위적게탐 캐주얼
                V_ITopclothes1.setImageResource(woman.BBA12[0]);
                V_ITopclothes2.setImageResource(woman.BBA12[1]);
                V_ITopclothes3.setImageResource(woman.BBA12[2]);
                V_IOuterclothes1.setImageResource(woman.BBA12[3]);
                V_IOuterclothes2.setImageResource(woman.BBA12[4]);
                V_IOuterclothes3.setImageResource(woman.BBA12[5]);
                V_IBottomclothes1.setImageResource(woman.BBA12[6]);
                V_IBottomclothes2.setImageResource(woman.BBA12[7]);
                V_IBottomclothes3.setImageResource(woman.BBA12[8]);
                V_txtTop1.setText(woman.txt_BBA12[0]);
                V_txtTop2.setText(woman.txt_BBA12[1]);
                V_txtTop3.setText(woman.txt_BBA12[2]);
                V_txtOuter1.setText(woman.txt_BBA12[3]);
                V_txtOuter2.setText(woman.txt_BBA12[4]);
                V_txtOuter3.setText(woman.txt_BBA12[5]);
                V_txtBottom1.setText(woman.txt_BBA12[6]);
                V_txtBottom2.setText(woman.txt_BBA12[7]);
                V_txtBottom3.setText(woman.txt_BBA12[8]);

            }else if(result.equals("BBB")){
                // 더위적게탐 빈티지
                V_ITopclothes1.setImageResource(woman.BBB12[0]);
                V_ITopclothes2.setImageResource(woman.BBB12[1]);
                V_ITopclothes3.setImageResource(woman.BBB12[2]);
                V_IOuterclothes1.setImageResource(woman.BBB12[3]);
                V_IOuterclothes2.setImageResource(woman.BBB12[4]);
                V_IOuterclothes3.setImageResource(woman.BBB12[5]);
                V_IBottomclothes1.setImageResource(woman.BBB12[6]);
                V_IBottomclothes2.setImageResource(woman.BBB12[7]);
                V_IBottomclothes3.setImageResource(woman.BBB12[8]);
                V_txtTop1.setText(woman.txt_BBB12[0]);
                V_txtTop2.setText(woman.txt_BBB12[1]);
                V_txtTop3.setText(woman.txt_BBB12[2]);
                V_txtOuter1.setText(woman.txt_BBB12[3]);
                V_txtOuter2.setText(woman.txt_BBB12[4]);
                V_txtOuter3.setText(woman.txt_BBB12[5]);
                V_txtBottom1.setText(woman.txt_BBB12[6]);
                V_txtBottom2.setText(woman.txt_BBB12[7]);
                V_txtBottom3.setText(woman.txt_BBB12[8]);
            }else if(result.equals("BBC")){
                // 더위적게탐 스트릿
                V_ITopclothes1.setImageResource(woman.BBC12[0]);
                V_ITopclothes2.setImageResource(woman.BBC12[1]);
                V_ITopclothes3.setImageResource(woman.BBC12[2]);
                V_IOuterclothes1.setImageResource(woman.BBC12[3]);
                V_IOuterclothes2.setImageResource(woman.BBC12[4]);
                V_IOuterclothes3.setImageResource(woman.BBC12[5]);
                V_IBottomclothes1.setImageResource(woman.BBC12[6]);
                V_IBottomclothes2.setImageResource(woman.BBC12[7]);
                V_IBottomclothes3.setImageResource(woman.BBC12[8]);
                V_txtTop1.setText(woman.txt_BBC12[0]);
                V_txtTop2.setText(woman.txt_BBC12[1]);
                V_txtTop3.setText(woman.txt_BBC12[2]);
                V_txtOuter1.setText(woman.txt_BBC12[3]);
                V_txtOuter2.setText(woman.txt_BBC12[4]);
                V_txtOuter3.setText(woman.txt_BBC12[5]);
                V_txtBottom1.setText(woman.txt_BBC12[6]);
                V_txtBottom2.setText(woman.txt_BBC12[7]);
                V_txtBottom3.setText(woman.txt_BBC12[8]);
            }else if(result.equals("BBD")){
                // 더위적게탐 댄디
                V_ITopclothes1.setImageResource(woman.BBD12[0]);
                V_ITopclothes2.setImageResource(woman.BBD12[1]);
                V_ITopclothes3.setImageResource(woman.BBD12[2]);
                V_IOuterclothes1.setImageResource(woman.BBD12[3]);
                V_IOuterclothes2.setImageResource(woman.BBD12[4]);
                V_IOuterclothes3.setImageResource(woman.BBD12[5]);
                V_IBottomclothes1.setImageResource(woman.BBD12[6]);
                V_IBottomclothes2.setImageResource(woman.BBD12[7]);
                V_IBottomclothes3.setImageResource(woman.BBD12[8]);
                V_txtTop1.setText(woman.txt_BBD12[0]);
                V_txtTop2.setText(woman.txt_BBD12[1]);
                V_txtTop3.setText(woman.txt_BBD12[2]);
                V_txtOuter1.setText(woman.txt_BBD12[3]);
                V_txtOuter2.setText(woman.txt_BBD12[4]);
                V_txtOuter3.setText(woman.txt_BBD12[5]);
                V_txtBottom1.setText(woman.txt_BBD12[6]);
                V_txtBottom2.setText(woman.txt_BBD12[7]);
                V_txtBottom3.setText(woman.txt_BBD12[8]);

            }else{
                // BBE 더위적게탐 스포티
                V_ITopclothes1.setImageResource(woman.BBE12[0]);
                V_ITopclothes2.setImageResource(woman.BBE12[1]);
                V_ITopclothes3.setImageResource(woman.BBE12[2]);
                V_IOuterclothes1.setImageResource(woman.BBE12[3]);
                V_IOuterclothes2.setImageResource(woman.BBE12[4]);
                V_IOuterclothes3.setImageResource(woman.BBE12[5]);
                V_IBottomclothes1.setImageResource(woman.BBE12[6]);
                V_IBottomclothes2.setImageResource(woman.BBE12[7]);
                V_IBottomclothes3.setImageResource(woman.BBE12[8]);
                V_txtTop1.setText(woman.txt_BBE12[0]);
                V_txtTop2.setText(woman.txt_BBE12[1]);
                V_txtTop3.setText(woman.txt_BBE12[2]);
                V_txtOuter1.setText(woman.txt_BBE12[3]);
                V_txtOuter2.setText(woman.txt_BBE12[4]);
                V_txtOuter3.setText(woman.txt_BBE12[5]);
                V_txtBottom1.setText(woman.txt_BBE12[6]);
                V_txtBottom2.setText(woman.txt_BBE12[7]);
                V_txtBottom3.setText(woman.txt_BBE12[8]);
            }

        }else if(max_temp == 17){
            if(result.equals("BAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes1.setImageResource(woman.BAA17[0]);
                V_ITopclothes2.setImageResource(woman.BAA17[1]);
                V_ITopclothes3.setImageResource(woman.BAA17[2]);
                V_IOuterclothes1.setImageResource(woman.BAA17[3]);
                V_IOuterclothes2.setImageResource(woman.BAA17[4]);
                V_IOuterclothes3.setImageResource(woman.BAA17[5]);
                V_IBottomclothes1.setImageResource(woman.BAA17[6]);
                V_IBottomclothes2.setImageResource(woman.BAA17[7]);
                V_IBottomclothes3.setImageResource(woman.BAA17[8]);
                V_txtTop1.setText(woman.txt_BAA17[0]);
                V_txtTop2.setText(woman.txt_BAA17[1]);
                V_txtTop3.setText(woman.txt_BAA17[2]);
                V_txtOuter1.setText(woman.txt_BAA17[3]);
                V_txtOuter2.setText(woman.txt_BAA17[4]);
                V_txtOuter3.setText(woman.txt_BAA17[5]);
                V_txtBottom1.setText(woman.txt_BAA17[6]);
                V_txtBottom2.setText(woman.txt_BAA17[7]);
                V_txtBottom3.setText(woman.txt_BAA17[8]);

            }else if(result.equals("BAB")){
                // 더위많이탐 빈티지
                V_ITopclothes1.setImageResource(woman.BAB17[0]);
                V_ITopclothes2.setImageResource(woman.BAB17[1]);
                V_ITopclothes3.setImageResource(woman.BAB17[2]);
                V_IOuterclothes1.setImageResource(woman.BAB17[3]);
                V_IOuterclothes2.setImageResource(woman.BAB17[4]);
                V_IOuterclothes3.setImageResource(woman.BAB17[5]);
                V_IBottomclothes1.setImageResource(woman.BAB17[6]);
                V_IBottomclothes2.setImageResource(woman.BAB17[7]);
                V_IBottomclothes3.setImageResource(woman.BAB17[8]);
                V_txtTop1.setText(woman.txt_BAB17[0]);
                V_txtTop2.setText(woman.txt_BAB17[1]);
                V_txtTop3.setText(woman.txt_BAB17[2]);
                V_txtOuter1.setText(woman.txt_BAB17[3]);
                V_txtOuter2.setText(woman.txt_BAB17[4]);
                V_txtOuter3.setText(woman.txt_BAB17[5]);
                V_txtBottom1.setText(woman.txt_BAB17[6]);
                V_txtBottom2.setText(woman.txt_BAB17[7]);
                V_txtBottom3.setText(woman.txt_BAB17[8]);
            }else if(result.equals("BAC")){
                // 더위많이탐 스트릿
                V_ITopclothes1.setImageResource(woman.BAC17[0]);
                V_ITopclothes2.setImageResource(woman.BAC17[1]);
                V_ITopclothes3.setImageResource(woman.BAC17[2]);
                V_IOuterclothes1.setImageResource(woman.BAC17[3]);
                V_IOuterclothes2.setImageResource(woman.BAC17[4]);
                V_IOuterclothes3.setImageResource(woman.BAC17[5]);
                V_IBottomclothes1.setImageResource(woman.BAC17[6]);
                V_IBottomclothes2.setImageResource(woman.BAC17[7]);
                V_IBottomclothes3.setImageResource(woman.BAC17[8]);
                V_txtTop1.setText(woman.txt_BAC17[0]);
                V_txtTop2.setText(woman.txt_BAC17[1]);
                V_txtTop3.setText(woman.txt_BAC17[2]);
                V_txtOuter1.setText(woman.txt_BAC17[3]);
                V_txtOuter2.setText(woman.txt_BAC17[4]);
                V_txtOuter3.setText(woman.txt_BAC17[5]);
                V_txtBottom1.setText(woman.txt_BAC17[6]);
                V_txtBottom2.setText(woman.txt_BAC17[7]);
                V_txtBottom3.setText(woman.txt_BAC17[8]);
            }else if(result.equals("BAD")){
                // 더위많이탐 댄디
                V_ITopclothes1.setImageResource(woman.BAD17[0]);
                V_ITopclothes2.setImageResource(woman.BAD17[1]);
                V_ITopclothes3.setImageResource(woman.BAD17[2]);
                V_IOuterclothes1.setImageResource(woman.BAD17[3]);
                V_IOuterclothes2.setImageResource(woman.BAD17[4]);
                V_IOuterclothes3.setImageResource(woman.BAD17[5]);
                V_IBottomclothes1.setImageResource(woman.BAD17[6]);
                V_IBottomclothes2.setImageResource(woman.BAD17[7]);
                V_IBottomclothes3.setImageResource(woman.BAD17[8]);
                V_txtTop1.setText(woman.txt_BAD17[0]);
                V_txtTop2.setText(woman.txt_BAD17[1]);
                V_txtTop3.setText(woman.txt_BAD17[2]);
                V_txtOuter1.setText(woman.txt_BAD17[3]);
                V_txtOuter2.setText(woman.txt_BAD17[4]);
                V_txtOuter3.setText(woman.txt_BAD17[5]);
                V_txtBottom1.setText(woman.txt_BAD17[6]);
                V_txtBottom2.setText(woman.txt_BAD17[7]);
                V_txtBottom3.setText(woman.txt_BAD17[8]);

            }else if(result.equals("BAE")){
                // 더위많이탐 스포티
                V_ITopclothes1.setImageResource(woman.BAE17[0]);
                V_ITopclothes2.setImageResource(woman.BAE17[1]);
                V_ITopclothes3.setImageResource(woman.BAE17[2]);
                V_IOuterclothes1.setImageResource(woman.BAE17[3]);
                V_IOuterclothes2.setImageResource(woman.BAE17[4]);
                V_IOuterclothes3.setImageResource(woman.BAE17[5]);
                V_IBottomclothes1.setImageResource(woman.BAE17[6]);
                V_IBottomclothes2.setImageResource(woman.BAE17[7]);
                V_IBottomclothes3.setImageResource(woman.BAE17[8]);
                V_txtTop1.setText(woman.txt_BAE17[0]);
                V_txtTop2.setText(woman.txt_BAE17[1]);
                V_txtTop3.setText(woman.txt_BAE17[2]);
                V_txtOuter1.setText(woman.txt_BAE17[3]);
                V_txtOuter2.setText(woman.txt_BAE17[4]);
                V_txtOuter3.setText(woman.txt_BAE17[5]);
                V_txtBottom1.setText(woman.txt_BAE17[6]);
                V_txtBottom2.setText(woman.txt_BAE17[7]);
                V_txtBottom3.setText(woman.txt_BAE17[8]);

            }else if(result.equals("BBA")){
                // 더위적게탐 캐주얼
                V_ITopclothes1.setImageResource(woman.BBA17[0]);
                V_ITopclothes2.setImageResource(woman.BBA17[1]);
                V_ITopclothes3.setImageResource(woman.BBA17[2]);
                V_IOuterclothes1.setImageResource(woman.BBA17[3]);
                V_IOuterclothes2.setImageResource(woman.BBA17[4]);
                V_IOuterclothes3.setImageResource(woman.BBA17[5]);
                V_IBottomclothes1.setImageResource(woman.BBA17[6]);
                V_IBottomclothes2.setImageResource(woman.BBA17[7]);
                V_IBottomclothes3.setImageResource(woman.BBA17[8]);
                V_txtTop1.setText(woman.txt_BBA17[0]);
                V_txtTop2.setText(woman.txt_BBA17[1]);
                V_txtTop3.setText(woman.txt_BBA17[2]);
                V_txtOuter1.setText(woman.txt_BBA17[3]);
                V_txtOuter2.setText(woman.txt_BBA17[4]);
                V_txtOuter3.setText(woman.txt_BBA17[5]);
                V_txtBottom1.setText(woman.txt_BBA17[6]);
                V_txtBottom2.setText(woman.txt_BBA17[7]);
                V_txtBottom3.setText(woman.txt_BBA17[8]);

            }else if(result.equals("BBB")){
                // 더위적게탐 빈티지
                V_ITopclothes1.setImageResource(woman.BBB17[0]);
                V_ITopclothes2.setImageResource(woman.BBB17[1]);
                V_ITopclothes3.setImageResource(woman.BBB17[2]);
                V_IOuterclothes1.setImageResource(woman.BBB17[3]);
                V_IOuterclothes2.setImageResource(woman.BBB17[4]);
                V_IOuterclothes3.setImageResource(woman.BBB17[5]);
                V_IBottomclothes1.setImageResource(woman.BBB17[6]);
                V_IBottomclothes2.setImageResource(woman.BBB17[7]);
                V_IBottomclothes3.setImageResource(woman.BBB17[8]);
                V_txtTop1.setText(woman.txt_BBB17[0]);
                V_txtTop2.setText(woman.txt_BBB17[1]);
                V_txtTop3.setText(woman.txt_BBB17[2]);
                V_txtOuter1.setText(woman.txt_BBB17[3]);
                V_txtOuter2.setText(woman.txt_BBB17[4]);
                V_txtOuter3.setText(woman.txt_BBB17[5]);
                V_txtBottom1.setText(woman.txt_BBB17[6]);
                V_txtBottom2.setText(woman.txt_BBB17[7]);
                V_txtBottom3.setText(woman.txt_BBB17[8]);
            }else if(result.equals("BBC")){
                // 더위적게탐 스트릿
                V_ITopclothes1.setImageResource(woman.BBC17[0]);
                V_ITopclothes2.setImageResource(woman.BBC17[1]);
                V_ITopclothes3.setImageResource(woman.BBC17[2]);
                V_IOuterclothes1.setImageResource(woman.BBC17[3]);
                V_IOuterclothes2.setImageResource(woman.BBC17[4]);
                V_IOuterclothes3.setImageResource(woman.BBC17[5]);
                V_IBottomclothes1.setImageResource(woman.BBC17[6]);
                V_IBottomclothes2.setImageResource(woman.BBC17[7]);
                V_IBottomclothes3.setImageResource(woman.BBC17[8]);
                V_txtTop1.setText(woman.txt_BBC17[0]);
                V_txtTop2.setText(woman.txt_BBC17[1]);
                V_txtTop3.setText(woman.txt_BBC17[2]);
                V_txtOuter1.setText(woman.txt_BBC17[3]);
                V_txtOuter2.setText(woman.txt_BBC17[4]);
                V_txtOuter3.setText(woman.txt_BBC17[5]);
                V_txtBottom1.setText(woman.txt_BBC17[6]);
                V_txtBottom2.setText(woman.txt_BBC17[7]);
                V_txtBottom3.setText(woman.txt_BBC17[8]);
            }else if(result.equals("BBD")){
                // 더위적게탐 댄디
                V_ITopclothes1.setImageResource(woman.BBD17[0]);
                V_ITopclothes2.setImageResource(woman.BBD17[1]);
                V_ITopclothes3.setImageResource(woman.BBD17[2]);
                V_IOuterclothes1.setImageResource(woman.BBD17[3]);
                V_IOuterclothes2.setImageResource(woman.BBD17[4]);
                V_IOuterclothes3.setImageResource(woman.BBD17[5]);
                V_IBottomclothes1.setImageResource(woman.BBD17[6]);
                V_IBottomclothes2.setImageResource(woman.BBD17[7]);
                V_IBottomclothes3.setImageResource(woman.BBD17[8]);
                V_txtTop1.setText(woman.txt_BBD17[0]);
                V_txtTop2.setText(woman.txt_BBD17[1]);
                V_txtTop3.setText(woman.txt_BBD17[2]);
                V_txtOuter1.setText(woman.txt_BBD17[3]);
                V_txtOuter2.setText(woman.txt_BBD17[4]);
                V_txtOuter3.setText(woman.txt_BBD17[5]);
                V_txtBottom1.setText(woman.txt_BBD17[6]);
                V_txtBottom2.setText(woman.txt_BBD17[7]);
                V_txtBottom3.setText(woman.txt_BBD17[8]);

            }else{
                // BBE 더위적게탐 스포티
                V_ITopclothes1.setImageResource(woman.BBE17[0]);
                V_ITopclothes2.setImageResource(woman.BBE17[1]);
                V_ITopclothes3.setImageResource(woman.BBE17[2]);
                V_IOuterclothes1.setImageResource(woman.BBE17[3]);
                V_IOuterclothes2.setImageResource(woman.BBE17[4]);
                V_IOuterclothes3.setImageResource(woman.BBE17[5]);
                V_IBottomclothes1.setImageResource(woman.BBE17[6]);
                V_IBottomclothes2.setImageResource(woman.BBE17[7]);
                V_IBottomclothes3.setImageResource(woman.BBE17[8]);
                V_txtTop1.setText(woman.txt_BBE17[0]);
                V_txtTop2.setText(woman.txt_BBE17[1]);
                V_txtTop3.setText(woman.txt_BBE17[2]);
                V_txtOuter1.setText(woman.txt_BBE17[3]);
                V_txtOuter2.setText(woman.txt_BBE17[4]);
                V_txtOuter3.setText(woman.txt_BBE17[5]);
                V_txtBottom1.setText(woman.txt_BBE17[6]);
                V_txtBottom2.setText(woman.txt_BBE17[7]);
                V_txtBottom3.setText(woman.txt_BBE17[8]);
            }

        }else if(max_temp == 20){
            if(result.equals("BAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes1.setImageResource(woman.BAA20[0]);
                V_ITopclothes2.setImageResource(woman.BAA20[1]);
                V_ITopclothes3.setImageResource(woman.BAA20[2]);
                V_IOuterclothes1.setImageResource(woman.BAA20[3]);
                V_IOuterclothes2.setImageResource(woman.BAA20[4]);
                V_IOuterclothes3.setImageResource(woman.BAA20[5]);
                V_IBottomclothes1.setImageResource(woman.BAA20[6]);
                V_IBottomclothes2.setImageResource(woman.BAA20[7]);
                V_IBottomclothes3.setImageResource(woman.BAA20[8]);
                V_txtTop1.setText(woman.txt_BAA20[0]);
                V_txtTop2.setText(woman.txt_BAA20[1]);
                V_txtTop3.setText(woman.txt_BAA20[2]);
                V_txtOuter1.setText(woman.txt_BAA20[3]);
                V_txtOuter2.setText(woman.txt_BAA20[4]);
                V_txtOuter3.setText(woman.txt_BAA20[5]);
                V_txtBottom1.setText(woman.txt_BAA20[6]);
                V_txtBottom2.setText(woman.txt_BAA20[7]);
                V_txtBottom3.setText(woman.txt_BAA20[8]);

            }else if(result.equals("BAB")){
                // 더위많이탐 빈티지
                V_ITopclothes1.setImageResource(woman.BAB20[0]);
                V_ITopclothes2.setImageResource(woman.BAB20[1]);
                V_ITopclothes3.setImageResource(woman.BAB20[2]);
                V_IOuterclothes1.setImageResource(woman.BAB20[3]);
                V_IOuterclothes2.setImageResource(woman.BAB20[4]);
                V_IOuterclothes3.setImageResource(woman.BAB20[5]);
                V_IBottomclothes1.setImageResource(woman.BAB20[6]);
                V_IBottomclothes2.setImageResource(woman.BAB20[7]);
                V_IBottomclothes3.setImageResource(woman.BAB20[8]);
                V_txtTop1.setText(woman.txt_BAB20[0]);
                V_txtTop2.setText(woman.txt_BAB20[1]);
                V_txtTop3.setText(woman.txt_BAB20[2]);
                V_txtOuter1.setText(woman.txt_BAB20[3]);
                V_txtOuter2.setText(woman.txt_BAB20[4]);
                V_txtOuter3.setText(woman.txt_BAB20[5]);
                V_txtBottom1.setText(woman.txt_BAB20[6]);
                V_txtBottom2.setText(woman.txt_BAB20[7]);
                V_txtBottom3.setText(woman.txt_BAB20[8]);
            }else if(result.equals("BAC")){
                // 더위많이탐 스트릿
                V_ITopclothes1.setImageResource(woman.BAC20[0]);
                V_ITopclothes2.setImageResource(woman.BAC20[1]);
                V_ITopclothes3.setImageResource(woman.BAC20[2]);
                V_IOuterclothes1.setImageResource(woman.BAC20[3]);
                V_IOuterclothes2.setImageResource(woman.BAC20[4]);
                V_IOuterclothes3.setImageResource(woman.BAC20[5]);
                V_IBottomclothes1.setImageResource(woman.BAC20[6]);
                V_IBottomclothes2.setImageResource(woman.BAC20[7]);
                V_IBottomclothes3.setImageResource(woman.BAC20[8]);
                V_txtTop1.setText(woman.txt_BAC20[0]);
                V_txtTop2.setText(woman.txt_BAC20[1]);
                V_txtTop3.setText(woman.txt_BAC20[2]);
                V_txtOuter1.setText(woman.txt_BAC20[3]);
                V_txtOuter2.setText(woman.txt_BAC20[4]);
                V_txtOuter3.setText(woman.txt_BAC20[5]);
                V_txtBottom1.setText(woman.txt_BAC20[6]);
                V_txtBottom2.setText(woman.txt_BAC20[7]);
                V_txtBottom3.setText(woman.txt_BAC20[8]);
            }else if(result.equals("BAD")){
                // 더위많이탐 댄디
                V_ITopclothes1.setImageResource(woman.BAD20[0]);
                V_ITopclothes2.setImageResource(woman.BAD20[1]);
                V_ITopclothes3.setImageResource(woman.BAD20[2]);
                V_IOuterclothes1.setImageResource(woman.BAD20[3]);
                V_IOuterclothes2.setImageResource(woman.BAD20[4]);
                V_IOuterclothes3.setImageResource(woman.BAD20[5]);
                V_IBottomclothes1.setImageResource(woman.BAD20[6]);
                V_IBottomclothes2.setImageResource(woman.BAD20[7]);
                V_IBottomclothes3.setImageResource(woman.BAD20[8]);
                V_txtTop1.setText(woman.txt_BAD20[0]);
                V_txtTop2.setText(woman.txt_BAD20[1]);
                V_txtTop3.setText(woman.txt_BAD20[2]);
                V_txtOuter1.setText(woman.txt_BAD20[3]);
                V_txtOuter2.setText(woman.txt_BAD20[4]);
                V_txtOuter3.setText(woman.txt_BAD20[5]);
                V_txtBottom1.setText(woman.txt_BAD20[6]);
                V_txtBottom2.setText(woman.txt_BAD20[7]);
                V_txtBottom3.setText(woman.txt_BAD20[8]);

            }else if(result.equals("BAE")){
                // 더위많이탐 스포티
                V_ITopclothes1.setImageResource(woman.BAE20[0]);
                V_ITopclothes2.setImageResource(woman.BAE20[1]);
                V_ITopclothes3.setImageResource(woman.BAE20[2]);
                V_IOuterclothes1.setImageResource(woman.BAE20[3]);
                V_IOuterclothes2.setImageResource(woman.BAE20[4]);
                V_IOuterclothes3.setImageResource(woman.BAE20[5]);
                V_IBottomclothes1.setImageResource(woman.BAE20[6]);
                V_IBottomclothes2.setImageResource(woman.BAE20[7]);
                V_IBottomclothes3.setImageResource(woman.BAE20[8]);
                V_txtTop1.setText(woman.txt_BAE20[0]);
                V_txtTop2.setText(woman.txt_BAE20[1]);
                V_txtTop3.setText(woman.txt_BAE20[2]);
                V_txtOuter1.setText(woman.txt_BAE20[3]);
                V_txtOuter2.setText(woman.txt_BAE20[4]);
                V_txtOuter3.setText(woman.txt_BAE20[5]);
                V_txtBottom1.setText(woman.txt_BAE20[6]);
                V_txtBottom2.setText(woman.txt_BAE20[7]);
                V_txtBottom3.setText(woman.txt_BAE20[8]);

            }else if(result.equals("BBA")){
                // 더위적게탐 캐주얼
                V_ITopclothes1.setImageResource(woman.BBA20[0]);
                V_ITopclothes2.setImageResource(woman.BBA20[1]);
                V_ITopclothes3.setImageResource(woman.BBA20[2]);
                V_IOuterclothes1.setImageResource(woman.BBA20[3]);
                V_IOuterclothes2.setImageResource(woman.BBA20[4]);
                V_IOuterclothes3.setImageResource(woman.BBA20[5]);
                V_IBottomclothes1.setImageResource(woman.BBA20[6]);
                V_IBottomclothes2.setImageResource(woman.BBA20[7]);
                V_IBottomclothes3.setImageResource(woman.BBA20[8]);
                V_txtTop1.setText(woman.txt_BBA20[0]);
                V_txtTop2.setText(woman.txt_BBA20[1]);
                V_txtTop3.setText(woman.txt_BBA20[2]);
                V_txtOuter1.setText(woman.txt_BBA20[3]);
                V_txtOuter2.setText(woman.txt_BBA20[4]);
                V_txtOuter3.setText(woman.txt_BBA20[5]);
                V_txtBottom1.setText(woman.txt_BBA20[6]);
                V_txtBottom2.setText(woman.txt_BBA20[7]);
                V_txtBottom3.setText(woman.txt_BBA20[8]);

            }else if(result.equals("BBB")){
                // 더위적게탐 빈티지
                V_ITopclothes1.setImageResource(woman.BBB20[0]);
                V_ITopclothes2.setImageResource(woman.BBB20[1]);
                V_ITopclothes3.setImageResource(woman.BBB20[2]);
                V_IOuterclothes1.setImageResource(woman.BBB20[3]);
                V_IOuterclothes2.setImageResource(woman.BBB20[4]);
                V_IOuterclothes3.setImageResource(woman.BBB20[5]);
                V_IBottomclothes1.setImageResource(woman.BBB20[6]);
                V_IBottomclothes2.setImageResource(woman.BBB20[7]);
                V_IBottomclothes3.setImageResource(woman.BBB20[8]);
                V_txtTop1.setText(woman.txt_BBB20[0]);
                V_txtTop2.setText(woman.txt_BBB20[1]);
                V_txtTop3.setText(woman.txt_BBB20[2]);
                V_txtOuter1.setText(woman.txt_BBB20[3]);
                V_txtOuter2.setText(woman.txt_BBB20[4]);
                V_txtOuter3.setText(woman.txt_BBB20[5]);
                V_txtBottom1.setText(woman.txt_BBB20[6]);
                V_txtBottom2.setText(woman.txt_BBB20[7]);
                V_txtBottom3.setText(woman.txt_BBB20[8]);
            }else if(result.equals("BBC")){
                // 더위적게탐 스트릿
                V_ITopclothes1.setImageResource(woman.BBC20[0]);
                V_ITopclothes2.setImageResource(woman.BBC20[1]);
                V_ITopclothes3.setImageResource(woman.BBC20[2]);
                V_IOuterclothes1.setImageResource(woman.BBC20[3]);
                V_IOuterclothes2.setImageResource(woman.BBC20[4]);
                V_IOuterclothes3.setImageResource(woman.BBC20[5]);
                V_IBottomclothes1.setImageResource(woman.BBC20[6]);
                V_IBottomclothes2.setImageResource(woman.BBC20[7]);
                V_IBottomclothes3.setImageResource(woman.BBC20[8]);
                V_txtTop1.setText(woman.txt_BBC20[0]);
                V_txtTop2.setText(woman.txt_BBC20[1]);
                V_txtTop3.setText(woman.txt_BBC20[2]);
                V_txtOuter1.setText(woman.txt_BBC20[3]);
                V_txtOuter2.setText(woman.txt_BBC20[4]);
                V_txtOuter3.setText(woman.txt_BBC20[5]);
                V_txtBottom1.setText(woman.txt_BBC20[6]);
                V_txtBottom2.setText(woman.txt_BBC20[7]);
                V_txtBottom3.setText(woman.txt_BBC20[8]);
            }else if(result.equals("BBD")){
                // 더위적게탐 댄디
                V_ITopclothes1.setImageResource(woman.BBD20[0]);
                V_ITopclothes2.setImageResource(woman.BBD20[1]);
                V_ITopclothes3.setImageResource(woman.BBD20[2]);
                V_IOuterclothes1.setImageResource(woman.BBD20[3]);
                V_IOuterclothes2.setImageResource(woman.BBD20[4]);
                V_IOuterclothes3.setImageResource(woman.BBD20[5]);
                V_IBottomclothes1.setImageResource(woman.BBD20[6]);
                V_IBottomclothes2.setImageResource(woman.BBD20[7]);
                V_IBottomclothes3.setImageResource(woman.BBD20[8]);
                V_txtTop1.setText(woman.txt_BBD20[0]);
                V_txtTop2.setText(woman.txt_BBD20[1]);
                V_txtTop3.setText(woman.txt_BBD20[2]);
                V_txtOuter1.setText(woman.txt_BBD20[3]);
                V_txtOuter2.setText(woman.txt_BBD20[4]);
                V_txtOuter3.setText(woman.txt_BBD20[5]);
                V_txtBottom1.setText(woman.txt_BBD20[6]);
                V_txtBottom2.setText(woman.txt_BBD20[7]);
                V_txtBottom3.setText(woman.txt_BBD20[8]);

            }else{
                // BBE 더위적게탐 스포티
                V_ITopclothes1.setImageResource(woman.BBE20[0]);
                V_ITopclothes2.setImageResource(woman.BBE20[1]);
                V_ITopclothes3.setImageResource(woman.BBE20[2]);
                V_IOuterclothes1.setImageResource(woman.BBE20[3]);
                V_IOuterclothes2.setImageResource(woman.BBE20[4]);
                V_IOuterclothes3.setImageResource(woman.BBE20[5]);
                V_IBottomclothes1.setImageResource(woman.BBE20[6]);
                V_IBottomclothes2.setImageResource(woman.BBE20[7]);
                V_IBottomclothes3.setImageResource(woman.BBE20[8]);
                V_txtTop1.setText(woman.txt_BBE20[0]);
                V_txtTop2.setText(woman.txt_BBE20[1]);
                V_txtTop3.setText(woman.txt_BBE20[2]);
                V_txtOuter1.setText(woman.txt_BBE20[3]);
                V_txtOuter2.setText(woman.txt_BBE20[4]);
                V_txtOuter3.setText(woman.txt_BBE20[5]);
                V_txtBottom1.setText(woman.txt_BBE20[6]);
                V_txtBottom2.setText(woman.txt_BBE20[7]);
                V_txtBottom3.setText(woman.txt_BBE20[8]);
            }

        }else if(max_temp == 23){
            if(result.equals("BAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes1.setImageResource(woman.BAA23[0]);
                V_ITopclothes2.setImageResource(woman.BAA23[1]);
                V_ITopclothes3.setImageResource(woman.BAA23[2]);
                V_IOuterclothes1.setImageResource(woman.BAA23[3]);
                V_IOuterclothes2.setImageResource(woman.BAA23[4]);
                V_IOuterclothes3.setImageResource(woman.BAA23[5]);
                V_IBottomclothes1.setImageResource(woman.BAA23[6]);
                V_IBottomclothes2.setImageResource(woman.BAA23[7]);
                V_IBottomclothes3.setImageResource(woman.BAA23[8]);
                V_txtTop1.setText(woman.txt_BAA23[0]);
                V_txtTop2.setText(woman.txt_BAA23[1]);
                V_txtTop3.setText(woman.txt_BAA23[2]);
                V_txtOuter1.setText(woman.txt_BAA23[3]);
                V_txtOuter2.setText(woman.txt_BAA23[4]);
                V_txtOuter3.setText(woman.txt_BAA23[5]);
                V_txtBottom1.setText(woman.txt_BAA23[6]);
                V_txtBottom2.setText(woman.txt_BAA23[7]);
                V_txtBottom3.setText(woman.txt_BAA23[8]);

            }else if(result.equals("BAB")){
                // 더위많이탐 빈티지
                V_ITopclothes1.setImageResource(woman.BAB23[0]);
                V_ITopclothes2.setImageResource(woman.BAB23[1]);
                V_ITopclothes3.setImageResource(woman.BAB23[2]);
                V_IOuterclothes1.setImageResource(woman.BAB23[3]);
                V_IOuterclothes2.setImageResource(woman.BAB23[4]);
                V_IOuterclothes3.setImageResource(woman.BAB23[5]);
                V_IBottomclothes1.setImageResource(woman.BAB23[6]);
                V_IBottomclothes2.setImageResource(woman.BAB23[7]);
                V_IBottomclothes3.setImageResource(woman.BAB23[8]);
                V_txtTop1.setText(woman.txt_BAB23[0]);
                V_txtTop2.setText(woman.txt_BAB23[1]);
                V_txtTop3.setText(woman.txt_BAB23[2]);
                V_txtOuter1.setText(woman.txt_BAB23[3]);
                V_txtOuter2.setText(woman.txt_BAB23[4]);
                V_txtOuter3.setText(woman.txt_BAB23[5]);
                V_txtBottom1.setText(woman.txt_BAB23[6]);
                V_txtBottom2.setText(woman.txt_BAB23[7]);
                V_txtBottom3.setText(woman.txt_BAB23[8]);
            }else if(result.equals("BAC")){
                // 더위많이탐 스트릿
                V_ITopclothes1.setImageResource(woman.BAC23[0]);
                V_ITopclothes2.setImageResource(woman.BAC23[1]);
                V_ITopclothes3.setImageResource(woman.BAC23[2]);
                V_IOuterclothes1.setImageResource(woman.BAC23[3]);
                V_IOuterclothes2.setImageResource(woman.BAC23[4]);
                V_IOuterclothes3.setImageResource(woman.BAC23[5]);
                V_IBottomclothes1.setImageResource(woman.BAC23[6]);
                V_IBottomclothes2.setImageResource(woman.BAC23[7]);
                V_IBottomclothes3.setImageResource(woman.BAC23[8]);
                V_txtTop1.setText(woman.txt_BAC23[0]);
                V_txtTop2.setText(woman.txt_BAC23[1]);
                V_txtTop3.setText(woman.txt_BAC23[2]);
                V_txtOuter1.setText(woman.txt_BAC23[3]);
                V_txtOuter2.setText(woman.txt_BAC23[4]);
                V_txtOuter3.setText(woman.txt_BAC23[5]);
                V_txtBottom1.setText(woman.txt_BAC23[6]);
                V_txtBottom2.setText(woman.txt_BAC23[7]);
                V_txtBottom3.setText(woman.txt_BAC23[8]);
            }else if(result.equals("BAD")){
                // 더위많이탐 댄디
                V_ITopclothes1.setImageResource(woman.BAD23[0]);
                V_ITopclothes2.setImageResource(woman.BAD23[1]);
                V_ITopclothes3.setImageResource(woman.BAD23[2]);
                V_IOuterclothes1.setImageResource(woman.BAD23[3]);
                V_IOuterclothes2.setImageResource(woman.BAD23[4]);
                V_IOuterclothes3.setImageResource(woman.BAD23[5]);
                V_IBottomclothes1.setImageResource(woman.BAD23[6]);
                V_IBottomclothes2.setImageResource(woman.BAD23[7]);
                V_IBottomclothes3.setImageResource(woman.BAD23[8]);
                V_txtTop1.setText(woman.txt_BAD23[0]);
                V_txtTop2.setText(woman.txt_BAD23[1]);
                V_txtTop3.setText(woman.txt_BAD23[2]);
                V_txtOuter1.setText(woman.txt_BAD23[3]);
                V_txtOuter2.setText(woman.txt_BAD23[4]);
                V_txtOuter3.setText(woman.txt_BAD23[5]);
                V_txtBottom1.setText(woman.txt_BAD23[6]);
                V_txtBottom2.setText(woman.txt_BAD23[7]);
                V_txtBottom3.setText(woman.txt_BAD23[8]);

            }else if(result.equals("BAE")){
                // 더위많이탐 스포티
                V_ITopclothes1.setImageResource(woman.BAE23[0]);
                V_ITopclothes2.setImageResource(woman.BAE23[1]);
                V_ITopclothes3.setImageResource(woman.BAE23[2]);
                V_IOuterclothes1.setImageResource(woman.BAE23[3]);
                V_IOuterclothes2.setImageResource(woman.BAE23[4]);
                V_IOuterclothes3.setImageResource(woman.BAE23[5]);
                V_IBottomclothes1.setImageResource(woman.BAE23[6]);
                V_IBottomclothes2.setImageResource(woman.BAE23[7]);
                V_IBottomclothes3.setImageResource(woman.BAE23[8]);
                V_txtTop1.setText(woman.txt_BAE23[0]);
                V_txtTop2.setText(woman.txt_BAE23[1]);
                V_txtTop3.setText(woman.txt_BAE23[2]);
                V_txtOuter1.setText(woman.txt_BAE23[3]);
                V_txtOuter2.setText(woman.txt_BAE23[4]);
                V_txtOuter3.setText(woman.txt_BAE23[5]);
                V_txtBottom1.setText(woman.txt_BAE23[6]);
                V_txtBottom2.setText(woman.txt_BAE23[7]);
                V_txtBottom3.setText(woman.txt_BAE23[8]);

            }else if(result.equals("BBA")){
                // 더위적게탐 캐주얼
                V_ITopclothes1.setImageResource(woman.BBA23[0]);
                V_ITopclothes2.setImageResource(woman.BBA23[1]);
                V_ITopclothes3.setImageResource(woman.BBA23[2]);
                V_IOuterclothes1.setImageResource(woman.BBA23[3]);
                V_IOuterclothes2.setImageResource(woman.BBA23[4]);
                V_IOuterclothes3.setImageResource(woman.BBA23[5]);
                V_IBottomclothes1.setImageResource(woman.BBA23[6]);
                V_IBottomclothes2.setImageResource(woman.BBA23[7]);
                V_IBottomclothes3.setImageResource(woman.BBA23[8]);
                V_txtTop1.setText(woman.txt_BBA23[0]);
                V_txtTop2.setText(woman.txt_BBA23[1]);
                V_txtTop3.setText(woman.txt_BBA23[2]);
                V_txtOuter1.setText(woman.txt_BBA23[3]);
                V_txtOuter2.setText(woman.txt_BBA23[4]);
                V_txtOuter3.setText(woman.txt_BBA23[5]);
                V_txtBottom1.setText(woman.txt_BBA23[6]);
                V_txtBottom2.setText(woman.txt_BBA23[7]);
                V_txtBottom3.setText(woman.txt_BBA23[8]);

            }else if(result.equals("BBB")){
                // 더위적게탐 빈티지
                V_ITopclothes1.setImageResource(woman.BBB23[0]);
                V_ITopclothes2.setImageResource(woman.BBB23[1]);
                V_ITopclothes3.setImageResource(woman.BBB23[2]);
                V_IOuterclothes1.setImageResource(woman.BBB23[3]);
                V_IOuterclothes2.setImageResource(woman.BBB23[4]);
                V_IOuterclothes3.setImageResource(woman.BBB23[5]);
                V_IBottomclothes1.setImageResource(woman.BBB23[6]);
                V_IBottomclothes2.setImageResource(woman.BBB23[7]);
                V_IBottomclothes3.setImageResource(woman.BBB23[8]);
                V_txtTop1.setText(woman.txt_BBB23[0]);
                V_txtTop2.setText(woman.txt_BBB23[1]);
                V_txtTop3.setText(woman.txt_BBB23[2]);
                V_txtOuter1.setText(woman.txt_BBB23[3]);
                V_txtOuter2.setText(woman.txt_BBB23[4]);
                V_txtOuter3.setText(woman.txt_BBB23[5]);
                V_txtBottom1.setText(woman.txt_BBB23[6]);
                V_txtBottom2.setText(woman.txt_BBB23[7]);
                V_txtBottom3.setText(woman.txt_BBB23[8]);
            }else if(result.equals("BBC")){
                // 더위적게탐 스트릿
                V_ITopclothes1.setImageResource(woman.BBC23[0]);
                V_ITopclothes2.setImageResource(woman.BBC23[1]);
                V_ITopclothes3.setImageResource(woman.BBC23[2]);
                V_IOuterclothes1.setImageResource(woman.BBC23[3]);
                V_IOuterclothes2.setImageResource(woman.BBC23[4]);
                V_IOuterclothes3.setImageResource(woman.BBC23[5]);
                V_IBottomclothes1.setImageResource(woman.BBC23[6]);
                V_IBottomclothes2.setImageResource(woman.BBC23[7]);
                V_IBottomclothes3.setImageResource(woman.BBC23[8]);
                V_txtTop1.setText(woman.txt_BBC23[0]);
                V_txtTop2.setText(woman.txt_BBC23[1]);
                V_txtTop3.setText(woman.txt_BBC23[2]);
                V_txtOuter1.setText(woman.txt_BBC23[3]);
                V_txtOuter2.setText(woman.txt_BBC23[4]);
                V_txtOuter3.setText(woman.txt_BBC23[5]);
                V_txtBottom1.setText(woman.txt_BBC23[6]);
                V_txtBottom2.setText(woman.txt_BBC23[7]);
                V_txtBottom3.setText(woman.txt_BBC23[8]);
            }else if(result.equals("BBD")){
                // 더위적게탐 댄디
                V_ITopclothes1.setImageResource(woman.BBD23[0]);
                V_ITopclothes2.setImageResource(woman.BBD23[1]);
                V_ITopclothes3.setImageResource(woman.BBD23[2]);
                V_IOuterclothes1.setImageResource(woman.BBD23[3]);
                V_IOuterclothes2.setImageResource(woman.BBD23[4]);
                V_IOuterclothes3.setImageResource(woman.BBD23[5]);
                V_IBottomclothes1.setImageResource(woman.BBD23[6]);
                V_IBottomclothes2.setImageResource(woman.BBD23[7]);
                V_IBottomclothes3.setImageResource(woman.BBD23[8]);
                V_txtTop1.setText(woman.txt_BBD23[0]);
                V_txtTop2.setText(woman.txt_BBD23[1]);
                V_txtTop3.setText(woman.txt_BBD23[2]);
                V_txtOuter1.setText(woman.txt_BBD23[3]);
                V_txtOuter2.setText(woman.txt_BBD23[4]);
                V_txtOuter3.setText(woman.txt_BBD23[5]);
                V_txtBottom1.setText(woman.txt_BBD23[6]);
                V_txtBottom2.setText(woman.txt_BBD23[7]);
                V_txtBottom3.setText(woman.txt_BBD23[8]);

            }else{
                // BBE 더위적게탐 스포티
                V_ITopclothes1.setImageResource(woman.BBE23[0]);
                V_ITopclothes2.setImageResource(woman.BBE23[1]);
                V_ITopclothes3.setImageResource(woman.BBE23[2]);
                V_IOuterclothes1.setImageResource(woman.BBE23[3]);
                V_IOuterclothes2.setImageResource(woman.BBE23[4]);
                V_IOuterclothes3.setImageResource(woman.BBE23[5]);
                V_IBottomclothes1.setImageResource(woman.BBE23[6]);
                V_IBottomclothes2.setImageResource(woman.BBE23[7]);
                V_IBottomclothes3.setImageResource(woman.BBE23[8]);
                V_txtTop1.setText(woman.txt_BBE23[0]);
                V_txtTop2.setText(woman.txt_BBE23[1]);
                V_txtTop3.setText(woman.txt_BBE23[2]);
                V_txtOuter1.setText(woman.txt_BBE23[3]);
                V_txtOuter2.setText(woman.txt_BBE23[4]);
                V_txtOuter3.setText(woman.txt_BBE23[5]);
                V_txtBottom1.setText(woman.txt_BBE23[6]);
                V_txtBottom2.setText(woman.txt_BBE23[7]);
                V_txtBottom3.setText(woman.txt_BBE23[8]);
            }

        }else if(max_temp == 28){
            if(result.equals("BAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes1.setImageResource(woman.BAA28[0]);
                V_ITopclothes2.setImageResource(woman.BAA28[1]);
                V_ITopclothes3.setImageResource(woman.BAA28[2]);
                V_IOuterclothes1.setImageResource(woman.BAA28[3]);
                V_IOuterclothes2.setImageResource(woman.BAA28[4]);
                V_IOuterclothes3.setImageResource(woman.BAA28[5]);
                V_IBottomclothes1.setImageResource(woman.BAA28[6]);
                V_IBottomclothes2.setImageResource(woman.BAA28[7]);
                V_IBottomclothes3.setImageResource(woman.BAA28[8]);
                V_txtTop1.setText(woman.txt_BAA28[0]);
                V_txtTop2.setText(woman.txt_BAA28[1]);
                V_txtTop3.setText(woman.txt_BAA28[2]);
                V_txtOuter1.setText(woman.txt_BAA28[3]);
                V_txtOuter2.setText(woman.txt_BAA28[4]);
                V_txtOuter3.setText(woman.txt_BAA28[5]);
                V_txtBottom1.setText(woman.txt_BAA28[6]);
                V_txtBottom2.setText(woman.txt_BAA28[7]);
                V_txtBottom3.setText(woman.txt_BAA28[8]);

            }else if(result.equals("BAB")){
                // 더위많이탐 빈티지
                V_ITopclothes1.setImageResource(woman.BAB28[0]);
                V_ITopclothes2.setImageResource(woman.BAB28[1]);
                V_ITopclothes3.setImageResource(woman.BAB28[2]);
                V_IOuterclothes1.setImageResource(woman.BAB28[3]);
                V_IOuterclothes2.setImageResource(woman.BAB28[4]);
                V_IOuterclothes3.setImageResource(woman.BAB28[5]);
                V_IBottomclothes1.setImageResource(woman.BAB28[6]);
                V_IBottomclothes2.setImageResource(woman.BAB28[7]);
                V_IBottomclothes3.setImageResource(woman.BAB28[8]);
                V_txtTop1.setText(woman.txt_BAB28[0]);
                V_txtTop2.setText(woman.txt_BAB28[1]);
                V_txtTop3.setText(woman.txt_BAB28[2]);
                V_txtOuter1.setText(woman.txt_BAB28[3]);
                V_txtOuter2.setText(woman.txt_BAB28[4]);
                V_txtOuter3.setText(woman.txt_BAB28[5]);
                V_txtBottom1.setText(woman.txt_BAB28[6]);
                V_txtBottom2.setText(woman.txt_BAB28[7]);
                V_txtBottom3.setText(woman.txt_BAB28[8]);
            }else if(result.equals("BAC")){
                // 더위많이탐 스트릿
                V_ITopclothes1.setImageResource(woman.BAC28[0]);
                V_ITopclothes2.setImageResource(woman.BAC28[1]);
                V_ITopclothes3.setImageResource(woman.BAC28[2]);
                V_IOuterclothes1.setImageResource(woman.BAC28[3]);
                V_IOuterclothes2.setImageResource(woman.BAC28[4]);
                V_IOuterclothes3.setImageResource(woman.BAC28[5]);
                V_IBottomclothes1.setImageResource(woman.BAC28[6]);
                V_IBottomclothes2.setImageResource(woman.BAC28[7]);
                V_IBottomclothes3.setImageResource(woman.BAC28[8]);
                V_txtTop1.setText(woman.txt_BAC28[0]);
                V_txtTop2.setText(woman.txt_BAC28[1]);
                V_txtTop3.setText(woman.txt_BAC28[2]);
                V_txtOuter1.setText(woman.txt_BAC28[3]);
                V_txtOuter2.setText(woman.txt_BAC28[4]);
                V_txtOuter3.setText(woman.txt_BAC28[5]);
                V_txtBottom1.setText(woman.txt_BAC28[6]);
                V_txtBottom2.setText(woman.txt_BAC28[7]);
                V_txtBottom3.setText(woman.txt_BAC28[8]);
            }else if(result.equals("BAD")){
                // 더위많이탐 댄디
                V_ITopclothes1.setImageResource(woman.BAD28[0]);
                V_ITopclothes2.setImageResource(woman.BAD28[1]);
                V_ITopclothes3.setImageResource(woman.BAD28[2]);
                V_IOuterclothes1.setImageResource(woman.BAD28[3]);
                V_IOuterclothes2.setImageResource(woman.BAD28[4]);
                V_IOuterclothes3.setImageResource(woman.BAD28[5]);
                V_IBottomclothes1.setImageResource(woman.BAD28[6]);
                V_IBottomclothes2.setImageResource(woman.BAD28[7]);
                V_IBottomclothes3.setImageResource(woman.BAD28[8]);
                V_txtTop1.setText(woman.txt_BAD28[0]);
                V_txtTop2.setText(woman.txt_BAD28[1]);
                V_txtTop3.setText(woman.txt_BAD28[2]);
                V_txtOuter1.setText(woman.txt_BAD28[3]);
                V_txtOuter2.setText(woman.txt_BAD28[4]);
                V_txtOuter3.setText(woman.txt_BAD28[5]);
                V_txtBottom1.setText(woman.txt_BAD28[6]);
                V_txtBottom2.setText(woman.txt_BAD28[7]);
                V_txtBottom3.setText(woman.txt_BAD28[8]);

            }else if(result.equals("BAE")){
                // 더위많이탐 스포티
                V_ITopclothes1.setImageResource(woman.BAE28[0]);
                V_ITopclothes2.setImageResource(woman.BAE28[1]);
                V_ITopclothes3.setImageResource(woman.BAE28[2]);
                V_IOuterclothes1.setImageResource(woman.BAE28[3]);
                V_IOuterclothes2.setImageResource(woman.BAE28[4]);
                V_IOuterclothes3.setImageResource(woman.BAE28[5]);
                V_IBottomclothes1.setImageResource(woman.BAE28[6]);
                V_IBottomclothes2.setImageResource(woman.BAE28[7]);
                V_IBottomclothes3.setImageResource(woman.BAE28[8]);
                V_txtTop1.setText(woman.txt_BAE28[0]);
                V_txtTop2.setText(woman.txt_BAE28[1]);
                V_txtTop3.setText(woman.txt_BAE28[2]);
                V_txtOuter1.setText(woman.txt_BAE28[3]);
                V_txtOuter2.setText(woman.txt_BAE28[4]);
                V_txtOuter3.setText(woman.txt_BAE28[5]);
                V_txtBottom1.setText(woman.txt_BAE28[6]);
                V_txtBottom2.setText(woman.txt_BAE28[7]);
                V_txtBottom3.setText(woman.txt_BAE28[8]);

            }else if(result.equals("BBA")){
                // 더위적게탐 캐주얼
                V_ITopclothes1.setImageResource(woman.BBA28[0]);
                V_ITopclothes2.setImageResource(woman.BBA28[1]);
                V_ITopclothes3.setImageResource(woman.BBA28[2]);
                V_IOuterclothes1.setImageResource(woman.BBA28[3]);
                V_IOuterclothes2.setImageResource(woman.BBA28[4]);
                V_IOuterclothes3.setImageResource(woman.BBA28[5]);
                V_IBottomclothes1.setImageResource(woman.BBA28[6]);
                V_IBottomclothes2.setImageResource(woman.BBA28[7]);
                V_IBottomclothes3.setImageResource(woman.BBA28[8]);
                V_txtTop1.setText(woman.txt_BBA28[0]);
                V_txtTop2.setText(woman.txt_BBA28[1]);
                V_txtTop3.setText(woman.txt_BBA28[2]);
                V_txtOuter1.setText(woman.txt_BBA28[3]);
                V_txtOuter2.setText(woman.txt_BBA28[4]);
                V_txtOuter3.setText(woman.txt_BBA28[5]);
                V_txtBottom1.setText(woman.txt_BBA28[6]);
                V_txtBottom2.setText(woman.txt_BBA28[7]);
                V_txtBottom3.setText(woman.txt_BBA28[8]);

            }else if(result.equals("BBB")){
                // 더위적게탐 빈티지
                V_ITopclothes1.setImageResource(woman.BBB28[0]);
                V_ITopclothes2.setImageResource(woman.BBB28[1]);
                V_ITopclothes3.setImageResource(woman.BBB28[2]);
                V_IOuterclothes1.setImageResource(woman.BBB28[3]);
                V_IOuterclothes2.setImageResource(woman.BBB28[4]);
                V_IOuterclothes3.setImageResource(woman.BBB28[5]);
                V_IBottomclothes1.setImageResource(woman.BBB28[6]);
                V_IBottomclothes2.setImageResource(woman.BBB28[7]);
                V_IBottomclothes3.setImageResource(woman.BBB28[8]);
                V_txtTop1.setText(woman.txt_BBB28[0]);
                V_txtTop2.setText(woman.txt_BBB28[1]);
                V_txtTop3.setText(woman.txt_BBB28[2]);
                V_txtOuter1.setText(woman.txt_BBB28[3]);
                V_txtOuter2.setText(woman.txt_BBB28[4]);
                V_txtOuter3.setText(woman.txt_BBB28[5]);
                V_txtBottom1.setText(woman.txt_BBB28[6]);
                V_txtBottom2.setText(woman.txt_BBB28[7]);
                V_txtBottom3.setText(woman.txt_BBB28[8]);
            }else if(result.equals("BBC")){
                // 더위적게탐 스트릿
                V_ITopclothes1.setImageResource(woman.BBC28[0]);
                V_ITopclothes2.setImageResource(woman.BBC28[1]);
                V_ITopclothes3.setImageResource(woman.BBC28[2]);
                V_IOuterclothes1.setImageResource(woman.BBC28[3]);
                V_IOuterclothes2.setImageResource(woman.BBC28[4]);
                V_IOuterclothes3.setImageResource(woman.BBC28[5]);
                V_IBottomclothes1.setImageResource(woman.BBC28[6]);
                V_IBottomclothes2.setImageResource(woman.BBC28[7]);
                V_IBottomclothes3.setImageResource(woman.BBC28[8]);
                V_txtTop1.setText(woman.txt_BBC28[0]);
                V_txtTop2.setText(woman.txt_BBC28[1]);
                V_txtTop3.setText(woman.txt_BBC28[2]);
                V_txtOuter1.setText(woman.txt_BBC28[3]);
                V_txtOuter2.setText(woman.txt_BBC28[4]);
                V_txtOuter3.setText(woman.txt_BBC28[5]);
                V_txtBottom1.setText(woman.txt_BBC28[6]);
                V_txtBottom2.setText(woman.txt_BBC28[7]);
                V_txtBottom3.setText(woman.txt_BBC28[8]);
            }else if(result.equals("BBD")){
                // 더위적게탐 댄디
                V_ITopclothes1.setImageResource(woman.BBD28[0]);
                V_ITopclothes2.setImageResource(woman.BBD28[1]);
                V_ITopclothes3.setImageResource(woman.BBD28[2]);
                V_IOuterclothes1.setImageResource(woman.BBD28[3]);
                V_IOuterclothes2.setImageResource(woman.BBD28[4]);
                V_IOuterclothes3.setImageResource(woman.BBD28[5]);
                V_IBottomclothes1.setImageResource(woman.BBD28[6]);
                V_IBottomclothes2.setImageResource(woman.BBD28[7]);
                V_IBottomclothes3.setImageResource(woman.BBD28[8]);
                V_txtTop1.setText(woman.txt_BBD28[0]);
                V_txtTop2.setText(woman.txt_BBD28[1]);
                V_txtTop3.setText(woman.txt_BBD28[2]);
                V_txtOuter1.setText(woman.txt_BBD28[3]);
                V_txtOuter2.setText(woman.txt_BBD28[4]);
                V_txtOuter3.setText(woman.txt_BBD28[5]);
                V_txtBottom1.setText(woman.txt_BBD28[6]);
                V_txtBottom2.setText(woman.txt_BBD28[7]);
                V_txtBottom3.setText(woman.txt_BBD28[8]);

            }else{
                // BBE 더위적게탐 스포티
                V_ITopclothes1.setImageResource(woman.BBE28[0]);
                V_ITopclothes2.setImageResource(woman.BBE28[1]);
                V_ITopclothes3.setImageResource(woman.BBE28[2]);
                V_IOuterclothes1.setImageResource(woman.BBE28[3]);
                V_IOuterclothes2.setImageResource(woman.BBE28[4]);
                V_IOuterclothes3.setImageResource(woman.BBE28[5]);
                V_IBottomclothes1.setImageResource(woman.BBE28[6]);
                V_IBottomclothes2.setImageResource(woman.BBE28[7]);
                V_IBottomclothes3.setImageResource(woman.BBE28[8]);
                V_txtTop1.setText(woman.txt_BBE28[0]);
                V_txtTop2.setText(woman.txt_BBE28[1]);
                V_txtTop3.setText(woman.txt_BBE28[2]);
                V_txtOuter1.setText(woman.txt_BBE28[3]);
                V_txtOuter2.setText(woman.txt_BBE28[4]);
                V_txtOuter3.setText(woman.txt_BBE28[5]);
                V_txtBottom1.setText(woman.txt_BBE28[6]);
                V_txtBottom2.setText(woman.txt_BBE28[7]);
                V_txtBottom3.setText(woman.txt_BBE28[8]);
            }

        }
    }

    // 옷을 보여주는 함수.(최저온도)
    public void clothesShowLow(int low_temp, String result){
        ClothesArray_woman woman = new ClothesArray_woman();

        // temp => 현재 온도값의 범위, result => 사용자가 설문지 조사한 결과
        // 최저기온과 결과값
        if(low_temp == 4){
            if(result.equals("BAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes4.setImageResource(woman.BAA4[0]);
                V_ITopclothes5.setImageResource(woman.BAA4[1]);
                V_ITopclothes6.setImageResource(woman.BAA4[2]);
                V_IOuterclothes4.setImageResource(woman.BAA4[3]);
                V_IOuterclothes5.setImageResource(woman.BAA4[4]);
                V_IOuterclothes6.setImageResource(woman.BAA4[5]);
                V_IBottomclothes4.setImageResource(woman.BAA4[6]);
                V_IBottomclothes5.setImageResource(woman.BAA4[7]);
                V_IBottomclothes6.setImageResource(woman.BAA4[8]);
                V_txtTop4.setText(woman.txt_BAA4[0]);
                V_txtTop5.setText(woman.txt_BAA4[1]);
                V_txtTop6.setText(woman.txt_BAA4[2]);
                V_txtOuter4.setText(woman.txt_BAA4[3]);
                V_txtOuter5.setText(woman.txt_BAA4[4]);
                V_txtOuter6.setText(woman.txt_BAA4[5]);
                V_txtBottom4.setText(woman.txt_BAA4[6]);
                V_txtBottom5.setText(woman.txt_BAA4[7]);
                V_txtBottom6.setText(woman.txt_BAA4[8]);

            }else if(result.equals("BAB")){
                // 더위많이탐 빈티지
                V_ITopclothes4.setImageResource(woman.BAB4[0]);
                V_ITopclothes5.setImageResource(woman.BAB4[1]);
                V_ITopclothes6.setImageResource(woman.BAB4[2]);
                V_IOuterclothes4.setImageResource(woman.BAB4[3]);
                V_IOuterclothes5.setImageResource(woman.BAB4[4]);
                V_IOuterclothes6.setImageResource(woman.BAB4[5]);
                V_IBottomclothes4.setImageResource(woman.BAB4[6]);
                V_IBottomclothes5.setImageResource(woman.BAB4[7]);
                V_IBottomclothes6.setImageResource(woman.BAB4[8]);
                V_txtTop4.setText(woman.txt_BAB4[0]);
                V_txtTop5.setText(woman.txt_BAB4[1]);
                V_txtTop6.setText(woman.txt_BAB4[2]);
                V_txtOuter4.setText(woman.txt_BAB4[3]);
                V_txtOuter5.setText(woman.txt_BAB4[4]);
                V_txtOuter6.setText(woman.txt_BAB4[5]);
                V_txtBottom4.setText(woman.txt_BAB4[6]);
                V_txtBottom5.setText(woman.txt_BAB4[7]);
                V_txtBottom6.setText(woman.txt_BAB4[8]);
            }else if(result.equals("BAC")){
                // 더위많이탐 스트릿
                V_ITopclothes4.setImageResource(woman.BAC4[0]);
                V_ITopclothes5.setImageResource(woman.BAC4[1]);
                V_ITopclothes6.setImageResource(woman.BAC4[2]);
                V_IOuterclothes4.setImageResource(woman.BAC4[3]);
                V_IOuterclothes5.setImageResource(woman.BAC4[4]);
                V_IOuterclothes6.setImageResource(woman.BAC4[5]);
                V_IBottomclothes4.setImageResource(woman.BAC4[6]);
                V_IBottomclothes5.setImageResource(woman.BAC4[7]);
                V_IBottomclothes6.setImageResource(woman.BAC4[8]);
                V_txtTop4.setText(woman.txt_BAC4[0]);
                V_txtTop5.setText(woman.txt_BAC4[1]);
                V_txtTop6.setText(woman.txt_BAC4[2]);
                V_txtOuter4.setText(woman.txt_BAC4[3]);
                V_txtOuter5.setText(woman.txt_BAC4[4]);
                V_txtOuter6.setText(woman.txt_BAC4[5]);
                V_txtBottom4.setText(woman.txt_BAC4[6]);
                V_txtBottom5.setText(woman.txt_BAC4[7]);
                V_txtBottom6.setText(woman.txt_BAC4[8]);
            }else if(result.equals("BAD")){
                // 더위많이탐 댄디
                V_ITopclothes4.setImageResource(woman.BAD4[0]);
                V_ITopclothes5.setImageResource(woman.BAD4[1]);
                V_ITopclothes6.setImageResource(woman.BAD4[2]);
                V_IOuterclothes4.setImageResource(woman.BAD4[3]);
                V_IOuterclothes5.setImageResource(woman.BAD4[4]);
                V_IOuterclothes6.setImageResource(woman.BAD4[5]);
                V_IBottomclothes4.setImageResource(woman.BAD4[6]);
                V_IBottomclothes5.setImageResource(woman.BAD4[7]);
                V_IBottomclothes6.setImageResource(woman.BAD4[8]);
                V_txtTop4.setText(woman.txt_BAD4[0]);
                V_txtTop5.setText(woman.txt_BAD4[1]);
                V_txtTop6.setText(woman.txt_BAD4[2]);
                V_txtOuter4.setText(woman.txt_BAD4[3]);
                V_txtOuter5.setText(woman.txt_BAD4[4]);
                V_txtOuter6.setText(woman.txt_BAD4[5]);
                V_txtBottom4.setText(woman.txt_BAD4[6]);
                V_txtBottom5.setText(woman.txt_BAD4[7]);
                V_txtBottom6.setText(woman.txt_BAD4[8]);

            }else if(result.equals("BAE")){
                // 더위많이탐 스포티
                V_ITopclothes4.setImageResource(woman.BAE4[0]);
                V_ITopclothes5.setImageResource(woman.BAE4[1]);
                V_ITopclothes6.setImageResource(woman.BAE4[2]);
                V_IOuterclothes4.setImageResource(woman.BAE4[3]);
                V_IOuterclothes5.setImageResource(woman.BAE4[4]);
                V_IOuterclothes6.setImageResource(woman.BAE4[5]);
                V_IBottomclothes4.setImageResource(woman.BAE4[6]);
                V_IBottomclothes5.setImageResource(woman.BAE4[7]);
                V_IBottomclothes6.setImageResource(woman.BAE4[8]);
                V_txtTop4.setText(woman.txt_BAE4[0]);
                V_txtTop5.setText(woman.txt_BAE4[1]);
                V_txtTop6.setText(woman.txt_BAE4[2]);
                V_txtOuter4.setText(woman.txt_BAE4[3]);
                V_txtOuter5.setText(woman.txt_BAE4[4]);
                V_txtOuter6.setText(woman.txt_BAE4[5]);
                V_txtBottom4.setText(woman.txt_BAE4[6]);
                V_txtBottom5.setText(woman.txt_BAE4[7]);
                V_txtBottom6.setText(woman.txt_BAE4[8]);

            }else if(result.equals("BBA")){
                // 더위적게탐 캐주얼
                V_ITopclothes4.setImageResource(woman.BBA4[0]);
                V_ITopclothes5.setImageResource(woman.BBA4[1]);
                V_ITopclothes6.setImageResource(woman.BBA4[2]);
                V_IOuterclothes4.setImageResource(woman.BBA4[3]);
                V_IOuterclothes5.setImageResource(woman.BBA4[4]);
                V_IOuterclothes6.setImageResource(woman.BBA4[5]);
                V_IBottomclothes4.setImageResource(woman.BBA4[6]);
                V_IBottomclothes5.setImageResource(woman.BBA4[7]);
                V_IBottomclothes6.setImageResource(woman.BBA4[8]);
                V_txtTop4.setText(woman.txt_BBA4[0]);
                V_txtTop5.setText(woman.txt_BBA4[1]);
                V_txtTop6.setText(woman.txt_BBA4[2]);
                V_txtOuter4.setText(woman.txt_BBA4[3]);
                V_txtOuter5.setText(woman.txt_BBA4[4]);
                V_txtOuter6.setText(woman.txt_BBA4[5]);
                V_txtBottom4.setText(woman.txt_BBA4[6]);
                V_txtBottom5.setText(woman.txt_BBA4[7]);
                V_txtBottom6.setText(woman.txt_BBA4[8]);

            }else if(result.equals("BBB")){
                // 더위적게탐 빈티지
                V_ITopclothes4.setImageResource(woman.BBB4[0]);
                V_ITopclothes5.setImageResource(woman.BBB4[1]);
                V_ITopclothes6.setImageResource(woman.BBB4[2]);
                V_IOuterclothes4.setImageResource(woman.BBB4[3]);
                V_IOuterclothes5.setImageResource(woman.BBB4[4]);
                V_IOuterclothes6.setImageResource(woman.BBB4[5]);
                V_IBottomclothes4.setImageResource(woman.BBB4[6]);
                V_IBottomclothes5.setImageResource(woman.BBB4[7]);
                V_IBottomclothes6.setImageResource(woman.BBB4[8]);
                V_txtTop4.setText(woman.txt_BBB4[0]);
                V_txtTop5.setText(woman.txt_BBB4[1]);
                V_txtTop6.setText(woman.txt_BBB4[2]);
                V_txtOuter4.setText(woman.txt_BBB4[3]);
                V_txtOuter5.setText(woman.txt_BBB4[4]);
                V_txtOuter6.setText(woman.txt_BBB4[5]);
                V_txtBottom4.setText(woman.txt_BBB4[6]);
                V_txtBottom5.setText(woman.txt_BBB4[7]);
                V_txtBottom6.setText(woman.txt_BBB4[8]);
            }else if(result.equals("BBC")){
                // 더위적게탐 스트릿
                V_ITopclothes4.setImageResource(woman.BBC4[0]);
                V_ITopclothes5.setImageResource(woman.BBC4[1]);
                V_ITopclothes6.setImageResource(woman.BBC4[2]);
                V_IOuterclothes4.setImageResource(woman.BBC4[3]);
                V_IOuterclothes5.setImageResource(woman.BBC4[4]);
                V_IOuterclothes6.setImageResource(woman.BBC4[5]);
                V_IBottomclothes4.setImageResource(woman.BBC4[6]);
                V_IBottomclothes5.setImageResource(woman.BBC4[7]);
                V_IBottomclothes6.setImageResource(woman.BBC4[8]);
                V_txtTop4.setText(woman.txt_BBC4[0]);
                V_txtTop5.setText(woman.txt_BBC4[1]);
                V_txtTop6.setText(woman.txt_BBC4[2]);
                V_txtOuter4.setText(woman.txt_BBC4[3]);
                V_txtOuter5.setText(woman.txt_BBC4[4]);
                V_txtOuter6.setText(woman.txt_BBC4[5]);
                V_txtBottom4.setText(woman.txt_BBC4[6]);
                V_txtBottom5.setText(woman.txt_BBC4[7]);
                V_txtBottom6.setText(woman.txt_BBC4[8]);
            }else if(result.equals("BBD")){
                // 더위적게탐 댄디
                V_ITopclothes4.setImageResource(woman.BBD4[0]);
                V_ITopclothes5.setImageResource(woman.BBD4[1]);
                V_ITopclothes6.setImageResource(woman.BBD4[2]);
                V_IOuterclothes4.setImageResource(woman.BBD4[3]);
                V_IOuterclothes5.setImageResource(woman.BBD4[4]);
                V_IOuterclothes6.setImageResource(woman.BBD4[5]);
                V_IBottomclothes4.setImageResource(woman.BBD4[6]);
                V_IBottomclothes5.setImageResource(woman.BBD4[7]);
                V_IBottomclothes6.setImageResource(woman.BBD4[8]);
                V_txtTop4.setText(woman.txt_BBD4[0]);
                V_txtTop5.setText(woman.txt_BBD4[1]);
                V_txtTop6.setText(woman.txt_BBD4[2]);
                V_txtOuter4.setText(woman.txt_BBD4[3]);
                V_txtOuter5.setText(woman.txt_BBD4[4]);
                V_txtOuter6.setText(woman.txt_BBD4[5]);
                V_txtBottom4.setText(woman.txt_BBD4[6]);
                V_txtBottom5.setText(woman.txt_BBD4[7]);
                V_txtBottom6.setText(woman.txt_BBD4[8]);

            }else{
                // BBE 더위적게탐 스포티
                V_ITopclothes4.setImageResource(woman.BBE4[0]);
                V_ITopclothes5.setImageResource(woman.BBE4[1]);
                V_ITopclothes6.setImageResource(woman.BBE4[2]);
                V_IOuterclothes4.setImageResource(woman.BBE4[3]);
                V_IOuterclothes5.setImageResource(woman.BBE4[4]);
                V_IOuterclothes6.setImageResource(woman.BBE4[5]);
                V_IBottomclothes4.setImageResource(woman.BBE4[6]);
                V_IBottomclothes5.setImageResource(woman.BBE4[7]);
                V_IBottomclothes6.setImageResource(woman.BBE4[8]);
                V_txtTop4.setText(woman.txt_BBE4[0]);
                V_txtTop5.setText(woman.txt_BBE4[1]);
                V_txtTop6.setText(woman.txt_BBE4[2]);
                V_txtOuter4.setText(woman.txt_BBE4[3]);
                V_txtOuter5.setText(woman.txt_BBE4[4]);
                V_txtOuter6.setText(woman.txt_BBE4[5]);
                V_txtBottom4.setText(woman.txt_BBE4[6]);
                V_txtBottom5.setText(woman.txt_BBE4[7]);
                V_txtBottom6.setText(woman.txt_BBE4[8]);
            }
        }else if(low_temp == 5){
            if(result.equals("BAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes4.setImageResource(woman.BAA5[0]);
                V_ITopclothes5.setImageResource(woman.BAA5[1]);
                V_ITopclothes6.setImageResource(woman.BAA5[2]);
                V_IOuterclothes4.setImageResource(woman.BAA5[3]);
                V_IOuterclothes5.setImageResource(woman.BAA5[4]);
                V_IOuterclothes6.setImageResource(woman.BAA5[5]);
                V_IBottomclothes4.setImageResource(woman.BAA5[6]);
                V_IBottomclothes5.setImageResource(woman.BAA5[7]);
                V_IBottomclothes6.setImageResource(woman.BAA5[8]);
                V_txtTop4.setText(woman.txt_BAA5[0]);
                V_txtTop5.setText(woman.txt_BAA5[1]);
                V_txtTop6.setText(woman.txt_BAA5[2]);
                V_txtOuter4.setText(woman.txt_BAA5[3]);
                V_txtOuter5.setText(woman.txt_BAA5[4]);
                V_txtOuter6.setText(woman.txt_BAA5[5]);
                V_txtBottom4.setText(woman.txt_BAA5[6]);
                V_txtBottom5.setText(woman.txt_BAA5[7]);
                V_txtBottom6.setText(woman.txt_BAA5[8]);

            }else if(result.equals("BAB")){
                // 더위많이탐 빈티지
                V_ITopclothes4.setImageResource(woman.BAB5[0]);
                V_ITopclothes5.setImageResource(woman.BAB5[1]);
                V_ITopclothes6.setImageResource(woman.BAB5[2]);
                V_IOuterclothes4.setImageResource(woman.BAB5[3]);
                V_IOuterclothes5.setImageResource(woman.BAB5[4]);
                V_IOuterclothes6.setImageResource(woman.BAB5[5]);
                V_IBottomclothes4.setImageResource(woman.BAB5[6]);
                V_IBottomclothes5.setImageResource(woman.BAB5[7]);
                V_IBottomclothes6.setImageResource(woman.BAB5[8]);
                V_txtTop4.setText(woman.txt_BAB5[0]);
                V_txtTop5.setText(woman.txt_BAB5[1]);
                V_txtTop6.setText(woman.txt_BAB5[2]);
                V_txtOuter4.setText(woman.txt_BAB5[3]);
                V_txtOuter5.setText(woman.txt_BAB5[4]);
                V_txtOuter6.setText(woman.txt_BAB5[5]);
                V_txtBottom4.setText(woman.txt_BAB5[6]);
                V_txtBottom5.setText(woman.txt_BAB5[7]);
                V_txtBottom6.setText(woman.txt_BAB5[8]);
            }else if(result.equals("BAC")){
                // 더위많이탐 스트릿
                V_ITopclothes4.setImageResource(woman.BAC5[0]);
                V_ITopclothes5.setImageResource(woman.BAC5[1]);
                V_ITopclothes6.setImageResource(woman.BAC5[2]);
                V_IOuterclothes4.setImageResource(woman.BAC5[3]);
                V_IOuterclothes5.setImageResource(woman.BAC5[4]);
                V_IOuterclothes6.setImageResource(woman.BAC5[5]);
                V_IBottomclothes4.setImageResource(woman.BAC5[6]);
                V_IBottomclothes5.setImageResource(woman.BAC5[7]);
                V_IBottomclothes6.setImageResource(woman.BAC5[8]);
                V_txtTop4.setText(woman.txt_BAC5[0]);
                V_txtTop5.setText(woman.txt_BAC5[1]);
                V_txtTop6.setText(woman.txt_BAC5[2]);
                V_txtOuter4.setText(woman.txt_BAC5[3]);
                V_txtOuter5.setText(woman.txt_BAC5[4]);
                V_txtOuter6.setText(woman.txt_BAC5[5]);
                V_txtBottom4.setText(woman.txt_BAC5[6]);
                V_txtBottom5.setText(woman.txt_BAC5[7]);
                V_txtBottom6.setText(woman.txt_BAC5[8]);
            }else if(result.equals("BAD")){
                // 더위많이탐 댄디
                V_ITopclothes4.setImageResource(woman.BAD5[0]);
                V_ITopclothes5.setImageResource(woman.BAD5[1]);
                V_ITopclothes6.setImageResource(woman.BAD5[2]);
                V_IOuterclothes4.setImageResource(woman.BAD5[3]);
                V_IOuterclothes5.setImageResource(woman.BAD5[4]);
                V_IOuterclothes6.setImageResource(woman.BAD5[5]);
                V_IBottomclothes4.setImageResource(woman.BAD5[6]);
                V_IBottomclothes5.setImageResource(woman.BAD5[7]);
                V_IBottomclothes6.setImageResource(woman.BAD5[8]);
                V_txtTop4.setText(woman.txt_BAD5[0]);
                V_txtTop5.setText(woman.txt_BAD5[1]);
                V_txtTop6.setText(woman.txt_BAD5[2]);
                V_txtOuter4.setText(woman.txt_BAD5[3]);
                V_txtOuter5.setText(woman.txt_BAD5[4]);
                V_txtOuter6.setText(woman.txt_BAD5[5]);
                V_txtBottom4.setText(woman.txt_BAD5[6]);
                V_txtBottom5.setText(woman.txt_BAD5[7]);
                V_txtBottom6.setText(woman.txt_BAD5[8]);

            }else if(result.equals("BAE")){
                // 더위많이탐 스포티
                V_ITopclothes4.setImageResource(woman.BAE5[0]);
                V_ITopclothes5.setImageResource(woman.BAE5[1]);
                V_ITopclothes6.setImageResource(woman.BAE5[2]);
                V_IOuterclothes4.setImageResource(woman.BAE5[3]);
                V_IOuterclothes5.setImageResource(woman.BAE5[4]);
                V_IOuterclothes6.setImageResource(woman.BAE5[5]);
                V_IBottomclothes4.setImageResource(woman.BAE5[6]);
                V_IBottomclothes5.setImageResource(woman.BAE5[7]);
                V_IBottomclothes6.setImageResource(woman.BAE5[8]);
                V_txtTop4.setText(woman.txt_BAE5[0]);
                V_txtTop5.setText(woman.txt_BAE5[1]);
                V_txtTop6.setText(woman.txt_BAE5[2]);
                V_txtOuter4.setText(woman.txt_BAE5[3]);
                V_txtOuter5.setText(woman.txt_BAE5[4]);
                V_txtOuter6.setText(woman.txt_BAE5[5]);
                V_txtBottom4.setText(woman.txt_BAE5[6]);
                V_txtBottom5.setText(woman.txt_BAE5[7]);
                V_txtBottom6.setText(woman.txt_BAE5[8]);

            }else if(result.equals("BBA")){
                // 더위적게탐 캐주얼
                V_ITopclothes4.setImageResource(woman.BBA5[0]);
                V_ITopclothes5.setImageResource(woman.BBA5[1]);
                V_ITopclothes6.setImageResource(woman.BBA5[2]);
                V_IOuterclothes4.setImageResource(woman.BBA5[3]);
                V_IOuterclothes5.setImageResource(woman.BBA5[4]);
                V_IOuterclothes6.setImageResource(woman.BBA5[5]);
                V_IBottomclothes4.setImageResource(woman.BBA5[6]);
                V_IBottomclothes5.setImageResource(woman.BBA5[7]);
                V_IBottomclothes6.setImageResource(woman.BBA5[8]);
                V_txtTop4.setText(woman.txt_BBA5[0]);
                V_txtTop5.setText(woman.txt_BBA5[1]);
                V_txtTop6.setText(woman.txt_BBA5[2]);
                V_txtOuter4.setText(woman.txt_BBA5[3]);
                V_txtOuter5.setText(woman.txt_BBA5[4]);
                V_txtOuter6.setText(woman.txt_BBA5[5]);
                V_txtBottom4.setText(woman.txt_BBA5[6]);
                V_txtBottom5.setText(woman.txt_BBA5[7]);
                V_txtBottom6.setText(woman.txt_BBA5[8]);

            }else if(result.equals("BBB")){
                // 더위적게탐 빈티지
                V_ITopclothes4.setImageResource(woman.BBB5[0]);
                V_ITopclothes5.setImageResource(woman.BBB5[1]);
                V_ITopclothes6.setImageResource(woman.BBB5[2]);
                V_IOuterclothes4.setImageResource(woman.BBB5[3]);
                V_IOuterclothes5.setImageResource(woman.BBB5[4]);
                V_IOuterclothes6.setImageResource(woman.BBB5[5]);
                V_IBottomclothes4.setImageResource(woman.BBB5[6]);
                V_IBottomclothes5.setImageResource(woman.BBB5[7]);
                V_IBottomclothes6.setImageResource(woman.BBB5[8]);
                V_txtTop4.setText(woman.txt_BBB5[0]);
                V_txtTop5.setText(woman.txt_BBB5[1]);
                V_txtTop6.setText(woman.txt_BBB5[2]);
                V_txtOuter4.setText(woman.txt_BBB5[3]);
                V_txtOuter5.setText(woman.txt_BBB5[4]);
                V_txtOuter6.setText(woman.txt_BBB5[5]);
                V_txtBottom4.setText(woman.txt_BBB5[6]);
                V_txtBottom5.setText(woman.txt_BBB5[7]);
                V_txtBottom6.setText(woman.txt_BBB5[8]);
            }else if(result.equals("BBC")){
                // 더위적게탐 스트릿
                V_ITopclothes4.setImageResource(woman.BBC5[0]);
                V_ITopclothes5.setImageResource(woman.BBC5[1]);
                V_ITopclothes6.setImageResource(woman.BBC5[2]);
                V_IOuterclothes4.setImageResource(woman.BBC5[3]);
                V_IOuterclothes5.setImageResource(woman.BBC5[4]);
                V_IOuterclothes6.setImageResource(woman.BBC5[5]);
                V_IBottomclothes4.setImageResource(woman.BBC5[6]);
                V_IBottomclothes5.setImageResource(woman.BBC5[7]);
                V_IBottomclothes6.setImageResource(woman.BBC5[8]);
                V_txtTop4.setText(woman.txt_BBC5[0]);
                V_txtTop5.setText(woman.txt_BBC5[1]);
                V_txtTop6.setText(woman.txt_BBC5[2]);
                V_txtOuter4.setText(woman.txt_BBC5[3]);
                V_txtOuter5.setText(woman.txt_BBC5[4]);
                V_txtOuter6.setText(woman.txt_BBC5[5]);
                V_txtBottom4.setText(woman.txt_BBC5[6]);
                V_txtBottom5.setText(woman.txt_BBC5[7]);
                V_txtBottom6.setText(woman.txt_BBC5[8]);
            }else if(result.equals("BBD")){
                // 더위적게탐 댄디
                V_ITopclothes4.setImageResource(woman.BBD5[0]);
                V_ITopclothes5.setImageResource(woman.BBD5[1]);
                V_ITopclothes6.setImageResource(woman.BBD5[2]);
                V_IOuterclothes4.setImageResource(woman.BBD5[3]);
                V_IOuterclothes5.setImageResource(woman.BBD5[4]);
                V_IOuterclothes6.setImageResource(woman.BBD5[5]);
                V_IBottomclothes4.setImageResource(woman.BBD5[6]);
                V_IBottomclothes5.setImageResource(woman.BBD5[7]);
                V_IBottomclothes6.setImageResource(woman.BBD5[8]);
                V_txtTop4.setText(woman.txt_BBD5[0]);
                V_txtTop5.setText(woman.txt_BBD5[1]);
                V_txtTop6.setText(woman.txt_BBD5[2]);
                V_txtOuter4.setText(woman.txt_BBD5[3]);
                V_txtOuter5.setText(woman.txt_BBD5[4]);
                V_txtOuter6.setText(woman.txt_BBD5[5]);
                V_txtBottom4.setText(woman.txt_BBD5[6]);
                V_txtBottom5.setText(woman.txt_BBD5[7]);
                V_txtBottom6.setText(woman.txt_BBD5[8]);

            }else{
                // BBE 더위적게탐 스포티
                V_ITopclothes4.setImageResource(woman.BBE5[0]);
                V_ITopclothes5.setImageResource(woman.BBE5[1]);
                V_ITopclothes6.setImageResource(woman.BBE5[2]);
                V_IOuterclothes4.setImageResource(woman.BBE5[3]);
                V_IOuterclothes5.setImageResource(woman.BBE5[4]);
                V_IOuterclothes6.setImageResource(woman.BBE5[5]);
                V_IBottomclothes4.setImageResource(woman.BBE5[6]);
                V_IBottomclothes5.setImageResource(woman.BBE5[7]);
                V_IBottomclothes6.setImageResource(woman.BBE5[8]);
                V_txtTop4.setText(woman.txt_BBE5[0]);
                V_txtTop5.setText(woman.txt_BBE5[1]);
                V_txtTop6.setText(woman.txt_BBE5[2]);
                V_txtOuter4.setText(woman.txt_BBE5[3]);
                V_txtOuter5.setText(woman.txt_BBE5[4]);
                V_txtOuter6.setText(woman.txt_BBE5[5]);
                V_txtBottom4.setText(woman.txt_BBE5[6]);
                V_txtBottom5.setText(woman.txt_BBE5[7]);
                V_txtBottom6.setText(woman.txt_BBE5[8]);
            }
        }else if(low_temp == 9){
            if(result.equals("BAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes4.setImageResource(woman.BAA9[0]);
                V_ITopclothes5.setImageResource(woman.BAA9[1]);
                V_ITopclothes6.setImageResource(woman.BAA9[2]);
                V_IOuterclothes4.setImageResource(woman.BAA9[3]);
                V_IOuterclothes5.setImageResource(woman.BAA9[4]);
                V_IOuterclothes6.setImageResource(woman.BAA9[5]);
                V_IBottomclothes4.setImageResource(woman.BAA9[6]);
                V_IBottomclothes5.setImageResource(woman.BAA9[7]);
                V_IBottomclothes6.setImageResource(woman.BAA9[8]);
                V_txtTop4.setText(woman.txt_BAA9[0]);
                V_txtTop5.setText(woman.txt_BAA9[1]);
                V_txtTop6.setText(woman.txt_BAA9[2]);
                V_txtOuter4.setText(woman.txt_BAA9[3]);
                V_txtOuter5.setText(woman.txt_BAA9[4]);
                V_txtOuter6.setText(woman.txt_BAA9[5]);
                V_txtBottom4.setText(woman.txt_BAA9[6]);
                V_txtBottom5.setText(woman.txt_BAA9[7]);
                V_txtBottom6.setText(woman.txt_BAA9[8]);

            }else if(result.equals("BAB")){
                // 더위많이탐 빈티지
                V_ITopclothes4.setImageResource(woman.BAB9[0]);
                V_ITopclothes5.setImageResource(woman.BAB9[1]);
                V_ITopclothes6.setImageResource(woman.BAB9[2]);
                V_IOuterclothes4.setImageResource(woman.BAB9[3]);
                V_IOuterclothes5.setImageResource(woman.BAB9[4]);
                V_IOuterclothes6.setImageResource(woman.BAB9[5]);
                V_IBottomclothes4.setImageResource(woman.BAB9[6]);
                V_IBottomclothes5.setImageResource(woman.BAB9[7]);
                V_IBottomclothes6.setImageResource(woman.BAB9[8]);
                V_txtTop4.setText(woman.txt_BAB9[0]);
                V_txtTop5.setText(woman.txt_BAB9[1]);
                V_txtTop6.setText(woman.txt_BAB9[2]);
                V_txtOuter4.setText(woman.txt_BAB9[3]);
                V_txtOuter5.setText(woman.txt_BAB9[4]);
                V_txtOuter6.setText(woman.txt_BAB9[5]);
                V_txtBottom4.setText(woman.txt_BAB9[6]);
                V_txtBottom5.setText(woman.txt_BAB9[7]);
                V_txtBottom6.setText(woman.txt_BAB9[8]);
            }else if(result.equals("BAC")){
                // 더위많이탐 스트릿
                V_ITopclothes4.setImageResource(woman.BAC9[0]);
                V_ITopclothes5.setImageResource(woman.BAC9[1]);
                V_ITopclothes6.setImageResource(woman.BAC9[2]);
                V_IOuterclothes4.setImageResource(woman.BAC9[3]);
                V_IOuterclothes5.setImageResource(woman.BAC9[4]);
                V_IOuterclothes6.setImageResource(woman.BAC9[5]);
                V_IBottomclothes4.setImageResource(woman.BAC9[6]);
                V_IBottomclothes5.setImageResource(woman.BAC9[7]);
                V_IBottomclothes6.setImageResource(woman.BAC9[8]);
                V_txtTop4.setText(woman.txt_BAC9[0]);
                V_txtTop5.setText(woman.txt_BAC9[1]);
                V_txtTop6.setText(woman.txt_BAC9[2]);
                V_txtOuter4.setText(woman.txt_BAC9[3]);
                V_txtOuter5.setText(woman.txt_BAC9[4]);
                V_txtOuter6.setText(woman.txt_BAC9[5]);
                V_txtBottom4.setText(woman.txt_BAC9[6]);
                V_txtBottom5.setText(woman.txt_BAC9[7]);
                V_txtBottom6.setText(woman.txt_BAC9[8]);
            }else if(result.equals("BAD")){
                // 더위많이탐 댄디
                V_ITopclothes4.setImageResource(woman.BAD9[0]);
                V_ITopclothes5.setImageResource(woman.BAD9[1]);
                V_ITopclothes6.setImageResource(woman.BAD9[2]);
                V_IOuterclothes4.setImageResource(woman.BAD9[3]);
                V_IOuterclothes5.setImageResource(woman.BAD9[4]);
                V_IOuterclothes6.setImageResource(woman.BAD9[5]);
                V_IBottomclothes4.setImageResource(woman.BAD9[6]);
                V_IBottomclothes5.setImageResource(woman.BAD9[7]);
                V_IBottomclothes6.setImageResource(woman.BAD9[8]);
                V_txtTop4.setText(woman.txt_BAD9[0]);
                V_txtTop5.setText(woman.txt_BAD9[1]);
                V_txtTop6.setText(woman.txt_BAD9[2]);
                V_txtOuter4.setText(woman.txt_BAD9[3]);
                V_txtOuter5.setText(woman.txt_BAD9[4]);
                V_txtOuter6.setText(woman.txt_BAD9[5]);
                V_txtBottom4.setText(woman.txt_BAD9[6]);
                V_txtBottom5.setText(woman.txt_BAD9[7]);
                V_txtBottom6.setText(woman.txt_BAD9[8]);

            }else if(result.equals("BAE")){
                // 더위많이탐 스포티
                V_ITopclothes4.setImageResource(woman.BAE9[0]);
                V_ITopclothes5.setImageResource(woman.BAE9[1]);
                V_ITopclothes6.setImageResource(woman.BAE9[2]);
                V_IOuterclothes4.setImageResource(woman.BAE9[3]);
                V_IOuterclothes5.setImageResource(woman.BAE9[4]);
                V_IOuterclothes6.setImageResource(woman.BAE9[5]);
                V_IBottomclothes4.setImageResource(woman.BAE9[6]);
                V_IBottomclothes5.setImageResource(woman.BAE9[7]);
                V_IBottomclothes6.setImageResource(woman.BAE9[8]);
                V_txtTop4.setText(woman.txt_BAE9[0]);
                V_txtTop5.setText(woman.txt_BAE9[1]);
                V_txtTop6.setText(woman.txt_BAE9[2]);
                V_txtOuter4.setText(woman.txt_BAE9[3]);
                V_txtOuter5.setText(woman.txt_BAE9[4]);
                V_txtOuter6.setText(woman.txt_BAE9[5]);
                V_txtBottom4.setText(woman.txt_BAE9[6]);
                V_txtBottom5.setText(woman.txt_BAE9[7]);
                V_txtBottom6.setText(woman.txt_BAE9[8]);

            }else if(result.equals("BBA")){
                // 더위적게탐 캐주얼
                V_ITopclothes4.setImageResource(woman.BBA9[0]);
                V_ITopclothes5.setImageResource(woman.BBA9[1]);
                V_ITopclothes6.setImageResource(woman.BBA9[2]);
                V_IOuterclothes4.setImageResource(woman.BBA9[3]);
                V_IOuterclothes5.setImageResource(woman.BBA9[4]);
                V_IOuterclothes6.setImageResource(woman.BBA9[5]);
                V_IBottomclothes4.setImageResource(woman.BBA9[6]);
                V_IBottomclothes5.setImageResource(woman.BBA9[7]);
                V_IBottomclothes6.setImageResource(woman.BBA9[8]);
                V_txtTop4.setText(woman.txt_BBA9[0]);
                V_txtTop5.setText(woman.txt_BBA9[1]);
                V_txtTop6.setText(woman.txt_BBA9[2]);
                V_txtOuter4.setText(woman.txt_BBA9[3]);
                V_txtOuter5.setText(woman.txt_BBA9[4]);
                V_txtOuter6.setText(woman.txt_BBA9[5]);
                V_txtBottom4.setText(woman.txt_BBA9[6]);
                V_txtBottom5.setText(woman.txt_BBA9[7]);
                V_txtBottom6.setText(woman.txt_BBA9[8]);

            }else if(result.equals("BBB")){
                // 더위적게탐 빈티지
                V_ITopclothes4.setImageResource(woman.BBB9[0]);
                V_ITopclothes5.setImageResource(woman.BBB9[1]);
                V_ITopclothes6.setImageResource(woman.BBB9[2]);
                V_IOuterclothes4.setImageResource(woman.BBB9[3]);
                V_IOuterclothes5.setImageResource(woman.BBB9[4]);
                V_IOuterclothes6.setImageResource(woman.BBB9[5]);
                V_IBottomclothes4.setImageResource(woman.BBB9[6]);
                V_IBottomclothes5.setImageResource(woman.BBB9[7]);
                V_IBottomclothes6.setImageResource(woman.BBB9[8]);
                V_txtTop4.setText(woman.txt_BBB9[0]);
                V_txtTop5.setText(woman.txt_BBB9[1]);
                V_txtTop6.setText(woman.txt_BBB9[2]);
                V_txtOuter4.setText(woman.txt_BBB9[3]);
                V_txtOuter5.setText(woman.txt_BBB9[4]);
                V_txtOuter6.setText(woman.txt_BBB9[5]);
                V_txtBottom4.setText(woman.txt_BBB9[6]);
                V_txtBottom5.setText(woman.txt_BBB9[7]);
                V_txtBottom6.setText(woman.txt_BBB9[8]);
            }else if(result.equals("BBC")){
                // 더위적게탐 스트릿
                V_ITopclothes4.setImageResource(woman.BBC9[0]);
                V_ITopclothes5.setImageResource(woman.BBC9[1]);
                V_ITopclothes6.setImageResource(woman.BBC9[2]);
                V_IOuterclothes4.setImageResource(woman.BBC9[3]);
                V_IOuterclothes5.setImageResource(woman.BBC9[4]);
                V_IOuterclothes6.setImageResource(woman.BBC9[5]);
                V_IBottomclothes4.setImageResource(woman.BBC9[6]);
                V_IBottomclothes5.setImageResource(woman.BBC9[7]);
                V_IBottomclothes6.setImageResource(woman.BBC9[8]);
                V_txtTop4.setText(woman.txt_BBC9[0]);
                V_txtTop5.setText(woman.txt_BBC9[1]);
                V_txtTop6.setText(woman.txt_BBC9[2]);
                V_txtOuter4.setText(woman.txt_BBC9[3]);
                V_txtOuter5.setText(woman.txt_BBC9[4]);
                V_txtOuter6.setText(woman.txt_BBC9[5]);
                V_txtBottom4.setText(woman.txt_BBC9[6]);
                V_txtBottom5.setText(woman.txt_BBC9[7]);
                V_txtBottom6.setText(woman.txt_BBC9[8]);
            }else if(result.equals("BBD")){
                // 더위적게탐 댄디
                V_ITopclothes4.setImageResource(woman.BBD9[0]);
                V_ITopclothes5.setImageResource(woman.BBD9[1]);
                V_ITopclothes6.setImageResource(woman.BBD9[2]);
                V_IOuterclothes4.setImageResource(woman.BBD9[3]);
                V_IOuterclothes5.setImageResource(woman.BBD9[4]);
                V_IOuterclothes6.setImageResource(woman.BBD9[5]);
                V_IBottomclothes4.setImageResource(woman.BBD9[6]);
                V_IBottomclothes5.setImageResource(woman.BBD9[7]);
                V_IBottomclothes6.setImageResource(woman.BBD9[8]);
                V_txtTop4.setText(woman.txt_BBD9[0]);
                V_txtTop5.setText(woman.txt_BBD9[1]);
                V_txtTop6.setText(woman.txt_BBD9[2]);
                V_txtOuter4.setText(woman.txt_BBD9[3]);
                V_txtOuter5.setText(woman.txt_BBD9[4]);
                V_txtOuter6.setText(woman.txt_BBD9[5]);
                V_txtBottom4.setText(woman.txt_BBD9[6]);
                V_txtBottom5.setText(woman.txt_BBD9[7]);
                V_txtBottom6.setText(woman.txt_BBD9[8]);

            }else{
                // BBE 더위적게탐 스포티
                V_ITopclothes4.setImageResource(woman.BBE9[0]);
                V_ITopclothes5.setImageResource(woman.BBE9[1]);
                V_ITopclothes6.setImageResource(woman.BBE9[2]);
                V_IOuterclothes4.setImageResource(woman.BBE9[3]);
                V_IOuterclothes5.setImageResource(woman.BBE9[4]);
                V_IOuterclothes6.setImageResource(woman.BBE9[5]);
                V_IBottomclothes4.setImageResource(woman.BBE9[6]);
                V_IBottomclothes5.setImageResource(woman.BBE9[7]);
                V_IBottomclothes6.setImageResource(woman.BBE9[8]);
                V_txtTop4.setText(woman.txt_BBE9[0]);
                V_txtTop5.setText(woman.txt_BBE9[1]);
                V_txtTop6.setText(woman.txt_BBE9[2]);
                V_txtOuter4.setText(woman.txt_BBE9[3]);
                V_txtOuter5.setText(woman.txt_BBE9[4]);
                V_txtOuter6.setText(woman.txt_BBE9[5]);
                V_txtBottom4.setText(woman.txt_BBE9[6]);
                V_txtBottom5.setText(woman.txt_BBE9[7]);
                V_txtBottom6.setText(woman.txt_BBE9[8]);
            }
        }else if(low_temp == 12){
            if(result.equals("BAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes4.setImageResource(woman.BAA12[0]);
                V_ITopclothes5.setImageResource(woman.BAA12[1]);
                V_ITopclothes6.setImageResource(woman.BAA12[2]);
                V_IOuterclothes4.setImageResource(woman.BAA12[3]);
                V_IOuterclothes5.setImageResource(woman.BAA12[4]);
                V_IOuterclothes6.setImageResource(woman.BAA12[5]);
                V_IBottomclothes4.setImageResource(woman.BAA12[6]);
                V_IBottomclothes5.setImageResource(woman.BAA12[7]);
                V_IBottomclothes6.setImageResource(woman.BAA12[8]);
                V_txtTop4.setText(woman.txt_BAA12[0]);
                V_txtTop5.setText(woman.txt_BAA12[1]);
                V_txtTop6.setText(woman.txt_BAA12[2]);
                V_txtOuter4.setText(woman.txt_BAA12[3]);
                V_txtOuter5.setText(woman.txt_BAA12[4]);
                V_txtOuter6.setText(woman.txt_BAA12[5]);
                V_txtBottom4.setText(woman.txt_BAA12[6]);
                V_txtBottom5.setText(woman.txt_BAA12[7]);
                V_txtBottom6.setText(woman.txt_BAA12[8]);

            }else if(result.equals("BAB")){
                // 더위많이탐 빈티지
                V_ITopclothes4.setImageResource(woman.BAB12[0]);
                V_ITopclothes5.setImageResource(woman.BAB12[1]);
                V_ITopclothes6.setImageResource(woman.BAB12[2]);
                V_IOuterclothes4.setImageResource(woman.BAB12[3]);
                V_IOuterclothes5.setImageResource(woman.BAB12[4]);
                V_IOuterclothes6.setImageResource(woman.BAB12[5]);
                V_IBottomclothes4.setImageResource(woman.BAB12[6]);
                V_IBottomclothes5.setImageResource(woman.BAB12[7]);
                V_IBottomclothes6.setImageResource(woman.BAB12[8]);
                V_txtTop4.setText(woman.txt_BAB12[0]);
                V_txtTop5.setText(woman.txt_BAB12[1]);
                V_txtTop6.setText(woman.txt_BAB12[2]);
                V_txtOuter4.setText(woman.txt_BAB12[3]);
                V_txtOuter5.setText(woman.txt_BAB12[4]);
                V_txtOuter6.setText(woman.txt_BAB12[5]);
                V_txtBottom4.setText(woman.txt_BAB12[6]);
                V_txtBottom5.setText(woman.txt_BAB12[7]);
                V_txtBottom6.setText(woman.txt_BAB12[8]);
            }else if(result.equals("BAC")){
                // 더위많이탐 스트릿
                V_ITopclothes4.setImageResource(woman.BAC12[0]);
                V_ITopclothes5.setImageResource(woman.BAC12[1]);
                V_ITopclothes6.setImageResource(woman.BAC12[2]);
                V_IOuterclothes4.setImageResource(woman.BAC12[3]);
                V_IOuterclothes5.setImageResource(woman.BAC12[4]);
                V_IOuterclothes6.setImageResource(woman.BAC12[5]);
                V_IBottomclothes4.setImageResource(woman.BAC12[6]);
                V_IBottomclothes5.setImageResource(woman.BAC12[7]);
                V_IBottomclothes6.setImageResource(woman.BAC12[8]);
                V_txtTop4.setText(woman.txt_BAC12[0]);
                V_txtTop5.setText(woman.txt_BAC12[1]);
                V_txtTop6.setText(woman.txt_BAC12[2]);
                V_txtOuter4.setText(woman.txt_BAC12[3]);
                V_txtOuter5.setText(woman.txt_BAC12[4]);
                V_txtOuter6.setText(woman.txt_BAC12[5]);
                V_txtBottom4.setText(woman.txt_BAC12[6]);
                V_txtBottom5.setText(woman.txt_BAC12[7]);
                V_txtBottom6.setText(woman.txt_BAC12[8]);
            }else if(result.equals("BAD")){
                // 더위많이탐 댄디
                V_ITopclothes4.setImageResource(woman.BAD12[0]);
                V_ITopclothes5.setImageResource(woman.BAD12[1]);
                V_ITopclothes6.setImageResource(woman.BAD12[2]);
                V_IOuterclothes4.setImageResource(woman.BAD12[3]);
                V_IOuterclothes5.setImageResource(woman.BAD12[4]);
                V_IOuterclothes6.setImageResource(woman.BAD12[5]);
                V_IBottomclothes4.setImageResource(woman.BAD12[6]);
                V_IBottomclothes5.setImageResource(woman.BAD12[7]);
                V_IBottomclothes6.setImageResource(woman.BAD12[8]);
                V_txtTop4.setText(woman.txt_BAD12[0]);
                V_txtTop5.setText(woman.txt_BAD12[1]);
                V_txtTop6.setText(woman.txt_BAD12[2]);
                V_txtOuter4.setText(woman.txt_BAD12[3]);
                V_txtOuter5.setText(woman.txt_BAD12[4]);
                V_txtOuter6.setText(woman.txt_BAD12[5]);
                V_txtBottom4.setText(woman.txt_BAD12[6]);
                V_txtBottom5.setText(woman.txt_BAD12[7]);
                V_txtBottom6.setText(woman.txt_BAD12[8]);

            }else if(result.equals("BAE")){
                // 더위많이탐 스포티
                V_ITopclothes4.setImageResource(woman.BAE12[0]);
                V_ITopclothes5.setImageResource(woman.BAE12[1]);
                V_ITopclothes6.setImageResource(woman.BAE12[2]);
                V_IOuterclothes4.setImageResource(woman.BAE12[3]);
                V_IOuterclothes5.setImageResource(woman.BAE12[4]);
                V_IOuterclothes6.setImageResource(woman.BAE12[5]);
                V_IBottomclothes4.setImageResource(woman.BAE12[6]);
                V_IBottomclothes5.setImageResource(woman.BAE12[7]);
                V_IBottomclothes6.setImageResource(woman.BAE12[8]);
                V_txtTop4.setText(woman.txt_BAE12[0]);
                V_txtTop5.setText(woman.txt_BAE12[1]);
                V_txtTop6.setText(woman.txt_BAE12[2]);
                V_txtOuter4.setText(woman.txt_BAE12[3]);
                V_txtOuter5.setText(woman.txt_BAE12[4]);
                V_txtOuter6.setText(woman.txt_BAE12[5]);
                V_txtBottom4.setText(woman.txt_BAE12[6]);
                V_txtBottom5.setText(woman.txt_BAE12[7]);
                V_txtBottom6.setText(woman.txt_BAE12[8]);

            }else if(result.equals("BBA")){
                // 더위적게탐 캐주얼
                V_ITopclothes4.setImageResource(woman.BBA12[0]);
                V_ITopclothes5.setImageResource(woman.BBA12[1]);
                V_ITopclothes6.setImageResource(woman.BBA12[2]);
                V_IOuterclothes4.setImageResource(woman.BBA12[3]);
                V_IOuterclothes5.setImageResource(woman.BBA12[4]);
                V_IOuterclothes6.setImageResource(woman.BBA12[5]);
                V_IBottomclothes4.setImageResource(woman.BBA12[6]);
                V_IBottomclothes5.setImageResource(woman.BBA12[7]);
                V_IBottomclothes6.setImageResource(woman.BBA12[8]);
                V_txtTop4.setText(woman.txt_BBA12[0]);
                V_txtTop5.setText(woman.txt_BBA12[1]);
                V_txtTop6.setText(woman.txt_BBA12[2]);
                V_txtOuter4.setText(woman.txt_BBA12[3]);
                V_txtOuter5.setText(woman.txt_BBA12[4]);
                V_txtOuter6.setText(woman.txt_BBA12[5]);
                V_txtBottom4.setText(woman.txt_BBA12[6]);
                V_txtBottom5.setText(woman.txt_BBA12[7]);
                V_txtBottom6.setText(woman.txt_BBA12[8]);

            }else if(result.equals("BBB")){
                // 더위적게탐 빈티지
                V_ITopclothes4.setImageResource(woman.BBB12[0]);
                V_ITopclothes5.setImageResource(woman.BBB12[1]);
                V_ITopclothes6.setImageResource(woman.BBB12[2]);
                V_IOuterclothes4.setImageResource(woman.BBB12[3]);
                V_IOuterclothes5.setImageResource(woman.BBB12[4]);
                V_IOuterclothes6.setImageResource(woman.BBB12[5]);
                V_IBottomclothes4.setImageResource(woman.BBB12[6]);
                V_IBottomclothes5.setImageResource(woman.BBB12[7]);
                V_IBottomclothes6.setImageResource(woman.BBB12[8]);
                V_txtTop4.setText(woman.txt_BBB12[0]);
                V_txtTop5.setText(woman.txt_BBB12[1]);
                V_txtTop6.setText(woman.txt_BBB12[2]);
                V_txtOuter4.setText(woman.txt_BBB12[3]);
                V_txtOuter5.setText(woman.txt_BBB12[4]);
                V_txtOuter6.setText(woman.txt_BBB12[5]);
                V_txtBottom4.setText(woman.txt_BBB12[6]);
                V_txtBottom5.setText(woman.txt_BBB12[7]);
                V_txtBottom6.setText(woman.txt_BBB12[8]);
            }else if(result.equals("BBC")){
                // 더위적게탐 스트릿
                V_ITopclothes4.setImageResource(woman.BBC12[0]);
                V_ITopclothes5.setImageResource(woman.BBC12[1]);
                V_ITopclothes6.setImageResource(woman.BBC12[2]);
                V_IOuterclothes4.setImageResource(woman.BBC12[3]);
                V_IOuterclothes5.setImageResource(woman.BBC12[4]);
                V_IOuterclothes6.setImageResource(woman.BBC12[5]);
                V_IBottomclothes4.setImageResource(woman.BBC12[6]);
                V_IBottomclothes5.setImageResource(woman.BBC12[7]);
                V_IBottomclothes6.setImageResource(woman.BBC12[8]);
                V_txtTop4.setText(woman.txt_BBC12[0]);
                V_txtTop5.setText(woman.txt_BBC12[1]);
                V_txtTop6.setText(woman.txt_BBC12[2]);
                V_txtOuter4.setText(woman.txt_BBC12[3]);
                V_txtOuter5.setText(woman.txt_BBC12[4]);
                V_txtOuter6.setText(woman.txt_BBC12[5]);
                V_txtBottom4.setText(woman.txt_BBC12[6]);
                V_txtBottom5.setText(woman.txt_BBC12[7]);
                V_txtBottom6.setText(woman.txt_BBC12[8]);
            }else if(result.equals("BBD")){
                // 더위적게탐 댄디
                V_ITopclothes4.setImageResource(woman.BBD12[0]);
                V_ITopclothes5.setImageResource(woman.BBD12[1]);
                V_ITopclothes6.setImageResource(woman.BBD12[2]);
                V_IOuterclothes4.setImageResource(woman.BBD12[3]);
                V_IOuterclothes5.setImageResource(woman.BBD12[4]);
                V_IOuterclothes6.setImageResource(woman.BBD12[5]);
                V_IBottomclothes4.setImageResource(woman.BBD12[6]);
                V_IBottomclothes5.setImageResource(woman.BBD12[7]);
                V_IBottomclothes6.setImageResource(woman.BBD12[8]);
                V_txtTop4.setText(woman.txt_BBD12[0]);
                V_txtTop5.setText(woman.txt_BBD12[1]);
                V_txtTop6.setText(woman.txt_BBD12[2]);
                V_txtOuter4.setText(woman.txt_BBD12[3]);
                V_txtOuter5.setText(woman.txt_BBD12[4]);
                V_txtOuter6.setText(woman.txt_BBD12[5]);
                V_txtBottom4.setText(woman.txt_BBD12[6]);
                V_txtBottom5.setText(woman.txt_BBD12[7]);
                V_txtBottom6.setText(woman.txt_BBD12[8]);

            }else{
                // BBE 더위적게탐 스포티
                V_ITopclothes4.setImageResource(woman.BBE12[0]);
                V_ITopclothes5.setImageResource(woman.BBE12[1]);
                V_ITopclothes6.setImageResource(woman.BBE12[2]);
                V_IOuterclothes4.setImageResource(woman.BBE12[3]);
                V_IOuterclothes5.setImageResource(woman.BBE12[4]);
                V_IOuterclothes6.setImageResource(woman.BBE12[5]);
                V_IBottomclothes4.setImageResource(woman.BBE12[6]);
                V_IBottomclothes5.setImageResource(woman.BBE12[7]);
                V_IBottomclothes6.setImageResource(woman.BBE12[8]);
                V_txtTop4.setText(woman.txt_BBE12[0]);
                V_txtTop5.setText(woman.txt_BBE12[1]);
                V_txtTop6.setText(woman.txt_BBE12[2]);
                V_txtOuter4.setText(woman.txt_BBE12[3]);
                V_txtOuter5.setText(woman.txt_BBE12[4]);
                V_txtOuter6.setText(woman.txt_BBE12[5]);
                V_txtBottom4.setText(woman.txt_BBE12[6]);
                V_txtBottom5.setText(woman.txt_BBE12[7]);
                V_txtBottom6.setText(woman.txt_BBE12[8]);
            }
        }else if(low_temp == 17){
            if(result.equals("BAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes4.setImageResource(woman.BAA17[0]);
                V_ITopclothes5.setImageResource(woman.BAA17[1]);
                V_ITopclothes6.setImageResource(woman.BAA17[2]);
                V_IOuterclothes4.setImageResource(woman.BAA17[3]);
                V_IOuterclothes5.setImageResource(woman.BAA17[4]);
                V_IOuterclothes6.setImageResource(woman.BAA17[5]);
                V_IBottomclothes4.setImageResource(woman.BAA17[6]);
                V_IBottomclothes5.setImageResource(woman.BAA17[7]);
                V_IBottomclothes6.setImageResource(woman.BAA17[8]);
                V_txtTop4.setText(woman.txt_BAA17[0]);
                V_txtTop5.setText(woman.txt_BAA17[1]);
                V_txtTop6.setText(woman.txt_BAA17[2]);
                V_txtOuter4.setText(woman.txt_BAA17[3]);
                V_txtOuter5.setText(woman.txt_BAA17[4]);
                V_txtOuter6.setText(woman.txt_BAA17[5]);
                V_txtBottom4.setText(woman.txt_BAA17[6]);
                V_txtBottom5.setText(woman.txt_BAA17[7]);
                V_txtBottom6.setText(woman.txt_BAA17[8]);

            }else if(result.equals("BAB")){
                // 더위많이탐 빈티지
                V_ITopclothes4.setImageResource(woman.BAB17[0]);
                V_ITopclothes5.setImageResource(woman.BAB17[1]);
                V_ITopclothes6.setImageResource(woman.BAB17[2]);
                V_IOuterclothes4.setImageResource(woman.BAB17[3]);
                V_IOuterclothes5.setImageResource(woman.BAB17[4]);
                V_IOuterclothes6.setImageResource(woman.BAB17[5]);
                V_IBottomclothes4.setImageResource(woman.BAB17[6]);
                V_IBottomclothes5.setImageResource(woman.BAB17[7]);
                V_IBottomclothes6.setImageResource(woman.BAB17[8]);
                V_txtTop4.setText(woman.txt_BAB17[0]);
                V_txtTop5.setText(woman.txt_BAB17[1]);
                V_txtTop6.setText(woman.txt_BAB17[2]);
                V_txtOuter4.setText(woman.txt_BAB17[3]);
                V_txtOuter5.setText(woman.txt_BAB17[4]);
                V_txtOuter6.setText(woman.txt_BAB17[5]);
                V_txtBottom4.setText(woman.txt_BAB17[6]);
                V_txtBottom5.setText(woman.txt_BAB17[7]);
                V_txtBottom6.setText(woman.txt_BAB17[8]);
            }else if(result.equals("BAC")){
                // 더위많이탐 스트릿
                V_ITopclothes4.setImageResource(woman.BAC17[0]);
                V_ITopclothes5.setImageResource(woman.BAC17[1]);
                V_ITopclothes6.setImageResource(woman.BAC17[2]);
                V_IOuterclothes4.setImageResource(woman.BAC17[3]);
                V_IOuterclothes5.setImageResource(woman.BAC17[4]);
                V_IOuterclothes6.setImageResource(woman.BAC17[5]);
                V_IBottomclothes4.setImageResource(woman.BAC17[6]);
                V_IBottomclothes5.setImageResource(woman.BAC17[7]);
                V_IBottomclothes6.setImageResource(woman.BAC17[8]);
                V_txtTop4.setText(woman.txt_BAC17[0]);
                V_txtTop5.setText(woman.txt_BAC17[1]);
                V_txtTop6.setText(woman.txt_BAC17[2]);
                V_txtOuter4.setText(woman.txt_BAC17[3]);
                V_txtOuter5.setText(woman.txt_BAC17[4]);
                V_txtOuter6.setText(woman.txt_BAC17[5]);
                V_txtBottom4.setText(woman.txt_BAC17[6]);
                V_txtBottom5.setText(woman.txt_BAC17[7]);
                V_txtBottom6.setText(woman.txt_BAC17[8]);
            }else if(result.equals("BAD")){
                // 더위많이탐 댄디
                V_ITopclothes4.setImageResource(woman.BAD17[0]);
                V_ITopclothes5.setImageResource(woman.BAD17[1]);
                V_ITopclothes6.setImageResource(woman.BAD17[2]);
                V_IOuterclothes4.setImageResource(woman.BAD17[3]);
                V_IOuterclothes5.setImageResource(woman.BAD17[4]);
                V_IOuterclothes6.setImageResource(woman.BAD17[5]);
                V_IBottomclothes4.setImageResource(woman.BAD17[6]);
                V_IBottomclothes5.setImageResource(woman.BAD17[7]);
                V_IBottomclothes6.setImageResource(woman.BAD17[8]);
                V_txtTop4.setText(woman.txt_BAD17[0]);
                V_txtTop5.setText(woman.txt_BAD17[1]);
                V_txtTop6.setText(woman.txt_BAD17[2]);
                V_txtOuter4.setText(woman.txt_BAD17[3]);
                V_txtOuter5.setText(woman.txt_BAD17[4]);
                V_txtOuter6.setText(woman.txt_BAD17[5]);
                V_txtBottom4.setText(woman.txt_BAD17[6]);
                V_txtBottom5.setText(woman.txt_BAD17[7]);
                V_txtBottom6.setText(woman.txt_BAD17[8]);

            }else if(result.equals("BAE")){
                // 더위많이탐 스포티
                V_ITopclothes4.setImageResource(woman.BAE17[0]);
                V_ITopclothes5.setImageResource(woman.BAE17[1]);
                V_ITopclothes6.setImageResource(woman.BAE17[2]);
                V_IOuterclothes4.setImageResource(woman.BAE17[3]);
                V_IOuterclothes5.setImageResource(woman.BAE17[4]);
                V_IOuterclothes6.setImageResource(woman.BAE17[5]);
                V_IBottomclothes4.setImageResource(woman.BAE17[6]);
                V_IBottomclothes5.setImageResource(woman.BAE17[7]);
                V_IBottomclothes6.setImageResource(woman.BAE17[8]);
                V_txtTop4.setText(woman.txt_BAE17[0]);
                V_txtTop5.setText(woman.txt_BAE17[1]);
                V_txtTop6.setText(woman.txt_BAE17[2]);
                V_txtOuter4.setText(woman.txt_BAE17[3]);
                V_txtOuter5.setText(woman.txt_BAE17[4]);
                V_txtOuter6.setText(woman.txt_BAE17[5]);
                V_txtBottom4.setText(woman.txt_BAE17[6]);
                V_txtBottom5.setText(woman.txt_BAE17[7]);
                V_txtBottom6.setText(woman.txt_BAE17[8]);

            }else if(result.equals("BBA")){
                // 더위적게탐 캐주얼
                V_ITopclothes4.setImageResource(woman.BBA17[0]);
                V_ITopclothes5.setImageResource(woman.BBA17[1]);
                V_ITopclothes6.setImageResource(woman.BBA17[2]);
                V_IOuterclothes4.setImageResource(woman.BBA17[3]);
                V_IOuterclothes5.setImageResource(woman.BBA17[4]);
                V_IOuterclothes6.setImageResource(woman.BBA17[5]);
                V_IBottomclothes4.setImageResource(woman.BBA17[6]);
                V_IBottomclothes5.setImageResource(woman.BBA17[7]);
                V_IBottomclothes6.setImageResource(woman.BBA17[8]);
                V_txtTop4.setText(woman.txt_BBA17[0]);
                V_txtTop5.setText(woman.txt_BBA17[1]);
                V_txtTop6.setText(woman.txt_BBA17[2]);
                V_txtOuter4.setText(woman.txt_BBA17[3]);
                V_txtOuter5.setText(woman.txt_BBA17[4]);
                V_txtOuter6.setText(woman.txt_BBA17[5]);
                V_txtBottom4.setText(woman.txt_BBA17[6]);
                V_txtBottom5.setText(woman.txt_BBA17[7]);
                V_txtBottom6.setText(woman.txt_BBA17[8]);

            }else if(result.equals("BBB")){
                // 더위적게탐 빈티지
                V_ITopclothes4.setImageResource(woman.BBB17[0]);
                V_ITopclothes5.setImageResource(woman.BBB17[1]);
                V_ITopclothes6.setImageResource(woman.BBB17[2]);
                V_IOuterclothes4.setImageResource(woman.BBB17[3]);
                V_IOuterclothes5.setImageResource(woman.BBB17[4]);
                V_IOuterclothes6.setImageResource(woman.BBB17[5]);
                V_IBottomclothes4.setImageResource(woman.BBB17[6]);
                V_IBottomclothes5.setImageResource(woman.BBB17[7]);
                V_IBottomclothes6.setImageResource(woman.BBB17[8]);
                V_txtTop4.setText(woman.txt_BBB17[0]);
                V_txtTop5.setText(woman.txt_BBB17[1]);
                V_txtTop6.setText(woman.txt_BBB17[2]);
                V_txtOuter4.setText(woman.txt_BBB17[3]);
                V_txtOuter5.setText(woman.txt_BBB17[4]);
                V_txtOuter6.setText(woman.txt_BBB17[5]);
                V_txtBottom4.setText(woman.txt_BBB17[6]);
                V_txtBottom5.setText(woman.txt_BBB17[7]);
                V_txtBottom6.setText(woman.txt_BBB17[8]);
            }else if(result.equals("BBC")){
                // 더위적게탐 스트릿
                V_ITopclothes4.setImageResource(woman.BBC17[0]);
                V_ITopclothes5.setImageResource(woman.BBC17[1]);
                V_ITopclothes6.setImageResource(woman.BBC17[2]);
                V_IOuterclothes4.setImageResource(woman.BBC17[3]);
                V_IOuterclothes5.setImageResource(woman.BBC17[4]);
                V_IOuterclothes6.setImageResource(woman.BBC17[5]);
                V_IBottomclothes4.setImageResource(woman.BBC17[6]);
                V_IBottomclothes5.setImageResource(woman.BBC17[7]);
                V_IBottomclothes6.setImageResource(woman.BBC17[8]);
                V_txtTop4.setText(woman.txt_BBC17[0]);
                V_txtTop5.setText(woman.txt_BBC17[1]);
                V_txtTop6.setText(woman.txt_BBC17[2]);
                V_txtOuter4.setText(woman.txt_BBC17[3]);
                V_txtOuter5.setText(woman.txt_BBC17[4]);
                V_txtOuter6.setText(woman.txt_BBC17[5]);
                V_txtBottom4.setText(woman.txt_BBC17[6]);
                V_txtBottom5.setText(woman.txt_BBC17[7]);
                V_txtBottom6.setText(woman.txt_BBC17[8]);
            }else if(result.equals("BBD")){
                // 더위적게탐 댄디
                V_ITopclothes4.setImageResource(woman.BBD17[0]);
                V_ITopclothes5.setImageResource(woman.BBD17[1]);
                V_ITopclothes6.setImageResource(woman.BBD17[2]);
                V_IOuterclothes4.setImageResource(woman.BBD17[3]);
                V_IOuterclothes5.setImageResource(woman.BBD17[4]);
                V_IOuterclothes6.setImageResource(woman.BBD17[5]);
                V_IBottomclothes4.setImageResource(woman.BBD17[6]);
                V_IBottomclothes5.setImageResource(woman.BBD17[7]);
                V_IBottomclothes6.setImageResource(woman.BBD17[8]);
                V_txtTop4.setText(woman.txt_BBD17[0]);
                V_txtTop5.setText(woman.txt_BBD17[1]);
                V_txtTop6.setText(woman.txt_BBD17[2]);
                V_txtOuter4.setText(woman.txt_BBD17[3]);
                V_txtOuter5.setText(woman.txt_BBD17[4]);
                V_txtOuter6.setText(woman.txt_BBD17[5]);
                V_txtBottom4.setText(woman.txt_BBD17[6]);
                V_txtBottom5.setText(woman.txt_BBD17[7]);
                V_txtBottom6.setText(woman.txt_BBD17[8]);

            }else{
                // BBE 더위적게탐 스포티
                V_ITopclothes4.setImageResource(woman.BBE17[0]);
                V_ITopclothes5.setImageResource(woman.BBE17[1]);
                V_ITopclothes6.setImageResource(woman.BBE17[2]);
                V_IOuterclothes4.setImageResource(woman.BBE17[3]);
                V_IOuterclothes5.setImageResource(woman.BBE17[4]);
                V_IOuterclothes6.setImageResource(woman.BBE17[5]);
                V_IBottomclothes4.setImageResource(woman.BBE17[6]);
                V_IBottomclothes5.setImageResource(woman.BBE17[7]);
                V_IBottomclothes6.setImageResource(woman.BBE17[8]);
                V_txtTop4.setText(woman.txt_BBE17[0]);
                V_txtTop5.setText(woman.txt_BBE17[1]);
                V_txtTop6.setText(woman.txt_BBE17[2]);
                V_txtOuter4.setText(woman.txt_BBE17[3]);
                V_txtOuter5.setText(woman.txt_BBE17[4]);
                V_txtOuter6.setText(woman.txt_BBE17[5]);
                V_txtBottom4.setText(woman.txt_BBE17[6]);
                V_txtBottom5.setText(woman.txt_BBE17[7]);
                V_txtBottom6.setText(woman.txt_BBE17[8]);
            }
        }else if(low_temp == 20){
            if(result.equals("BAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes4.setImageResource(woman.BAA20[0]);
                V_ITopclothes5.setImageResource(woman.BAA20[1]);
                V_ITopclothes6.setImageResource(woman.BAA20[2]);
                V_IOuterclothes4.setImageResource(woman.BAA20[3]);
                V_IOuterclothes5.setImageResource(woman.BAA20[4]);
                V_IOuterclothes6.setImageResource(woman.BAA20[5]);
                V_IBottomclothes4.setImageResource(woman.BAA20[6]);
                V_IBottomclothes5.setImageResource(woman.BAA20[7]);
                V_IBottomclothes6.setImageResource(woman.BAA20[8]);
                V_txtTop4.setText(woman.txt_BAA20[0]);
                V_txtTop5.setText(woman.txt_BAA20[1]);
                V_txtTop6.setText(woman.txt_BAA20[2]);
                V_txtOuter4.setText(woman.txt_BAA20[3]);
                V_txtOuter5.setText(woman.txt_BAA20[4]);
                V_txtOuter6.setText(woman.txt_BAA20[5]);
                V_txtBottom4.setText(woman.txt_BAA20[6]);
                V_txtBottom5.setText(woman.txt_BAA20[7]);
                V_txtBottom6.setText(woman.txt_BAA20[8]);

            }else if(result.equals("BAB")){
                // 더위많이탐 빈티지
                V_ITopclothes4.setImageResource(woman.BAB20[0]);
                V_ITopclothes5.setImageResource(woman.BAB20[1]);
                V_ITopclothes6.setImageResource(woman.BAB20[2]);
                V_IOuterclothes4.setImageResource(woman.BAB20[3]);
                V_IOuterclothes5.setImageResource(woman.BAB20[4]);
                V_IOuterclothes6.setImageResource(woman.BAB20[5]);
                V_IBottomclothes4.setImageResource(woman.BAB20[6]);
                V_IBottomclothes5.setImageResource(woman.BAB20[7]);
                V_IBottomclothes6.setImageResource(woman.BAB20[8]);
                V_txtTop4.setText(woman.txt_BAB20[0]);
                V_txtTop5.setText(woman.txt_BAB20[1]);
                V_txtTop6.setText(woman.txt_BAB20[2]);
                V_txtOuter4.setText(woman.txt_BAB20[3]);
                V_txtOuter5.setText(woman.txt_BAB20[4]);
                V_txtOuter6.setText(woman.txt_BAB20[5]);
                V_txtBottom4.setText(woman.txt_BAB20[6]);
                V_txtBottom5.setText(woman.txt_BAB20[7]);
                V_txtBottom6.setText(woman.txt_BAB20[8]);
            }else if(result.equals("BAC")){
                // 더위많이탐 스트릿
                V_ITopclothes4.setImageResource(woman.BAC20[0]);
                V_ITopclothes5.setImageResource(woman.BAC20[1]);
                V_ITopclothes6.setImageResource(woman.BAC20[2]);
                V_IOuterclothes4.setImageResource(woman.BAC20[3]);
                V_IOuterclothes5.setImageResource(woman.BAC20[4]);
                V_IOuterclothes6.setImageResource(woman.BAC20[5]);
                V_IBottomclothes4.setImageResource(woman.BAC20[6]);
                V_IBottomclothes5.setImageResource(woman.BAC20[7]);
                V_IBottomclothes6.setImageResource(woman.BAC20[8]);
                V_txtTop4.setText(woman.txt_BAC20[0]);
                V_txtTop5.setText(woman.txt_BAC20[1]);
                V_txtTop6.setText(woman.txt_BAC20[2]);
                V_txtOuter4.setText(woman.txt_BAC20[3]);
                V_txtOuter5.setText(woman.txt_BAC20[4]);
                V_txtOuter6.setText(woman.txt_BAC20[5]);
                V_txtBottom4.setText(woman.txt_BAC20[6]);
                V_txtBottom5.setText(woman.txt_BAC20[7]);
                V_txtBottom6.setText(woman.txt_BAC20[8]);
            }else if(result.equals("BAD")){
                // 더위많이탐 댄디
                V_ITopclothes4.setImageResource(woman.BAD20[0]);
                V_ITopclothes5.setImageResource(woman.BAD20[1]);
                V_ITopclothes6.setImageResource(woman.BAD20[2]);
                V_IOuterclothes4.setImageResource(woman.BAD20[3]);
                V_IOuterclothes5.setImageResource(woman.BAD20[4]);
                V_IOuterclothes6.setImageResource(woman.BAD20[5]);
                V_IBottomclothes4.setImageResource(woman.BAD20[6]);
                V_IBottomclothes5.setImageResource(woman.BAD20[7]);
                V_IBottomclothes6.setImageResource(woman.BAD20[8]);
                V_txtTop4.setText(woman.txt_BAD20[0]);
                V_txtTop5.setText(woman.txt_BAD20[1]);
                V_txtTop6.setText(woman.txt_BAD20[2]);
                V_txtOuter4.setText(woman.txt_BAD20[3]);
                V_txtOuter5.setText(woman.txt_BAD20[4]);
                V_txtOuter6.setText(woman.txt_BAD20[5]);
                V_txtBottom4.setText(woman.txt_BAD20[6]);
                V_txtBottom5.setText(woman.txt_BAD20[7]);
                V_txtBottom6.setText(woman.txt_BAD20[8]);

            }else if(result.equals("BAE")){
                // 더위많이탐 스포티
                V_ITopclothes4.setImageResource(woman.BAE20[0]);
                V_ITopclothes5.setImageResource(woman.BAE20[1]);
                V_ITopclothes6.setImageResource(woman.BAE20[2]);
                V_IOuterclothes4.setImageResource(woman.BAE20[3]);
                V_IOuterclothes5.setImageResource(woman.BAE20[4]);
                V_IOuterclothes6.setImageResource(woman.BAE20[5]);
                V_IBottomclothes4.setImageResource(woman.BAE20[6]);
                V_IBottomclothes5.setImageResource(woman.BAE20[7]);
                V_IBottomclothes6.setImageResource(woman.BAE20[8]);
                V_txtTop4.setText(woman.txt_BAE20[0]);
                V_txtTop5.setText(woman.txt_BAE20[1]);
                V_txtTop6.setText(woman.txt_BAE20[2]);
                V_txtOuter4.setText(woman.txt_BAE20[3]);
                V_txtOuter5.setText(woman.txt_BAE20[4]);
                V_txtOuter6.setText(woman.txt_BAE20[5]);
                V_txtBottom4.setText(woman.txt_BAE20[6]);
                V_txtBottom5.setText(woman.txt_BAE20[7]);
                V_txtBottom6.setText(woman.txt_BAE20[8]);

            }else if(result.equals("BBA")){
                // 더위적게탐 캐주얼
                V_ITopclothes4.setImageResource(woman.BBA20[0]);
                V_ITopclothes5.setImageResource(woman.BBA20[1]);
                V_ITopclothes6.setImageResource(woman.BBA20[2]);
                V_IOuterclothes4.setImageResource(woman.BBA20[3]);
                V_IOuterclothes5.setImageResource(woman.BBA20[4]);
                V_IOuterclothes6.setImageResource(woman.BBA20[5]);
                V_IBottomclothes4.setImageResource(woman.BBA20[6]);
                V_IBottomclothes5.setImageResource(woman.BBA20[7]);
                V_IBottomclothes6.setImageResource(woman.BBA20[8]);
                V_txtTop4.setText(woman.txt_BBA20[0]);
                V_txtTop5.setText(woman.txt_BBA20[1]);
                V_txtTop6.setText(woman.txt_BBA20[2]);
                V_txtOuter4.setText(woman.txt_BBA20[3]);
                V_txtOuter5.setText(woman.txt_BBA20[4]);
                V_txtOuter6.setText(woman.txt_BBA20[5]);
                V_txtBottom4.setText(woman.txt_BBA20[6]);
                V_txtBottom5.setText(woman.txt_BBA20[7]);
                V_txtBottom6.setText(woman.txt_BBA20[8]);

            }else if(result.equals("BBB")){
                // 더위적게탐 빈티지
                V_ITopclothes4.setImageResource(woman.BBB20[0]);
                V_ITopclothes5.setImageResource(woman.BBB20[1]);
                V_ITopclothes6.setImageResource(woman.BBB20[2]);
                V_IOuterclothes4.setImageResource(woman.BBB20[3]);
                V_IOuterclothes5.setImageResource(woman.BBB20[4]);
                V_IOuterclothes6.setImageResource(woman.BBB20[5]);
                V_IBottomclothes4.setImageResource(woman.BBB20[6]);
                V_IBottomclothes5.setImageResource(woman.BBB20[7]);
                V_IBottomclothes6.setImageResource(woman.BBB20[8]);
                V_txtTop4.setText(woman.txt_BBB20[0]);
                V_txtTop5.setText(woman.txt_BBB20[1]);
                V_txtTop6.setText(woman.txt_BBB20[2]);
                V_txtOuter4.setText(woman.txt_BBB20[3]);
                V_txtOuter5.setText(woman.txt_BBB20[4]);
                V_txtOuter6.setText(woman.txt_BBB20[5]);
                V_txtBottom4.setText(woman.txt_BBB20[6]);
                V_txtBottom5.setText(woman.txt_BBB20[7]);
                V_txtBottom6.setText(woman.txt_BBB20[8]);
            }else if(result.equals("BBC")){
                // 더위적게탐 스트릿
                V_ITopclothes4.setImageResource(woman.BBC20[0]);
                V_ITopclothes5.setImageResource(woman.BBC20[1]);
                V_ITopclothes6.setImageResource(woman.BBC20[2]);
                V_IOuterclothes4.setImageResource(woman.BBC20[3]);
                V_IOuterclothes5.setImageResource(woman.BBC20[4]);
                V_IOuterclothes6.setImageResource(woman.BBC20[5]);
                V_IBottomclothes4.setImageResource(woman.BBC20[6]);
                V_IBottomclothes5.setImageResource(woman.BBC20[7]);
                V_IBottomclothes6.setImageResource(woman.BBC20[8]);
                V_txtTop4.setText(woman.txt_BBC20[0]);
                V_txtTop5.setText(woman.txt_BBC20[1]);
                V_txtTop6.setText(woman.txt_BBC20[2]);
                V_txtOuter4.setText(woman.txt_BBC20[3]);
                V_txtOuter5.setText(woman.txt_BBC20[4]);
                V_txtOuter6.setText(woman.txt_BBC20[5]);
                V_txtBottom4.setText(woman.txt_BBC20[6]);
                V_txtBottom5.setText(woman.txt_BBC20[7]);
                V_txtBottom6.setText(woman.txt_BBC20[8]);
            }else if(result.equals("BBD")){
                // 더위적게탐 댄디
                V_ITopclothes4.setImageResource(woman.BBD20[0]);
                V_ITopclothes5.setImageResource(woman.BBD20[1]);
                V_ITopclothes6.setImageResource(woman.BBD20[2]);
                V_IOuterclothes4.setImageResource(woman.BBD20[3]);
                V_IOuterclothes5.setImageResource(woman.BBD20[4]);
                V_IOuterclothes6.setImageResource(woman.BBD20[5]);
                V_IBottomclothes4.setImageResource(woman.BBD20[6]);
                V_IBottomclothes5.setImageResource(woman.BBD20[7]);
                V_IBottomclothes6.setImageResource(woman.BBD20[8]);
                V_txtTop4.setText(woman.txt_BBD20[0]);
                V_txtTop5.setText(woman.txt_BBD20[1]);
                V_txtTop6.setText(woman.txt_BBD20[2]);
                V_txtOuter4.setText(woman.txt_BBD20[3]);
                V_txtOuter5.setText(woman.txt_BBD20[4]);
                V_txtOuter6.setText(woman.txt_BBD20[5]);
                V_txtBottom4.setText(woman.txt_BBD20[6]);
                V_txtBottom5.setText(woman.txt_BBD20[7]);
                V_txtBottom6.setText(woman.txt_BBD20[8]);

            }else{
                // BBE 더위적게탐 스포티
                V_ITopclothes4.setImageResource(woman.BBE20[0]);
                V_ITopclothes5.setImageResource(woman.BBE20[1]);
                V_ITopclothes6.setImageResource(woman.BBE20[2]);
                V_IOuterclothes4.setImageResource(woman.BBE20[3]);
                V_IOuterclothes5.setImageResource(woman.BBE20[4]);
                V_IOuterclothes6.setImageResource(woman.BBE20[5]);
                V_IBottomclothes4.setImageResource(woman.BBE20[6]);
                V_IBottomclothes5.setImageResource(woman.BBE20[7]);
                V_IBottomclothes6.setImageResource(woman.BBE20[8]);
                V_txtTop4.setText(woman.txt_BBE20[0]);
                V_txtTop5.setText(woman.txt_BBE20[1]);
                V_txtTop6.setText(woman.txt_BBE20[2]);
                V_txtOuter4.setText(woman.txt_BBE20[3]);
                V_txtOuter5.setText(woman.txt_BBE20[4]);
                V_txtOuter6.setText(woman.txt_BBE20[5]);
                V_txtBottom4.setText(woman.txt_BBE20[6]);
                V_txtBottom5.setText(woman.txt_BBE20[7]);
                V_txtBottom6.setText(woman.txt_BBE20[8]);
            }
        }else if(low_temp == 23){
            if(result.equals("BAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes4.setImageResource(woman.BAA23[0]);
                V_ITopclothes5.setImageResource(woman.BAA23[1]);
                V_ITopclothes6.setImageResource(woman.BAA23[2]);
                V_IOuterclothes4.setImageResource(woman.BAA23[3]);
                V_IOuterclothes5.setImageResource(woman.BAA23[4]);
                V_IOuterclothes6.setImageResource(woman.BAA23[5]);
                V_IBottomclothes4.setImageResource(woman.BAA23[6]);
                V_IBottomclothes5.setImageResource(woman.BAA23[7]);
                V_IBottomclothes6.setImageResource(woman.BAA23[8]);
                V_txtTop4.setText(woman.txt_BAA23[0]);
                V_txtTop5.setText(woman.txt_BAA23[1]);
                V_txtTop6.setText(woman.txt_BAA23[2]);
                V_txtOuter4.setText(woman.txt_BAA23[3]);
                V_txtOuter5.setText(woman.txt_BAA23[4]);
                V_txtOuter6.setText(woman.txt_BAA23[5]);
                V_txtBottom4.setText(woman.txt_BAA23[6]);
                V_txtBottom5.setText(woman.txt_BAA23[7]);
                V_txtBottom6.setText(woman.txt_BAA23[8]);

            }else if(result.equals("BAB")){
                // 더위많이탐 빈티지
                V_ITopclothes4.setImageResource(woman.BAB23[0]);
                V_ITopclothes5.setImageResource(woman.BAB23[1]);
                V_ITopclothes6.setImageResource(woman.BAB23[2]);
                V_IOuterclothes4.setImageResource(woman.BAB23[3]);
                V_IOuterclothes5.setImageResource(woman.BAB23[4]);
                V_IOuterclothes6.setImageResource(woman.BAB23[5]);
                V_IBottomclothes4.setImageResource(woman.BAB23[6]);
                V_IBottomclothes5.setImageResource(woman.BAB23[7]);
                V_IBottomclothes6.setImageResource(woman.BAB23[8]);
                V_txtTop4.setText(woman.txt_BAB23[0]);
                V_txtTop5.setText(woman.txt_BAB23[1]);
                V_txtTop6.setText(woman.txt_BAB23[2]);
                V_txtOuter4.setText(woman.txt_BAB23[3]);
                V_txtOuter5.setText(woman.txt_BAB23[4]);
                V_txtOuter6.setText(woman.txt_BAB23[5]);
                V_txtBottom4.setText(woman.txt_BAB23[6]);
                V_txtBottom5.setText(woman.txt_BAB23[7]);
                V_txtBottom6.setText(woman.txt_BAB23[8]);
            }else if(result.equals("BAC")){
                // 더위많이탐 스트릿
                V_ITopclothes4.setImageResource(woman.BAC23[0]);
                V_ITopclothes5.setImageResource(woman.BAC23[1]);
                V_ITopclothes6.setImageResource(woman.BAC23[2]);
                V_IOuterclothes4.setImageResource(woman.BAC23[3]);
                V_IOuterclothes5.setImageResource(woman.BAC23[4]);
                V_IOuterclothes6.setImageResource(woman.BAC23[5]);
                V_IBottomclothes4.setImageResource(woman.BAC23[6]);
                V_IBottomclothes5.setImageResource(woman.BAC23[7]);
                V_IBottomclothes6.setImageResource(woman.BAC23[8]);
                V_txtTop4.setText(woman.txt_BAC23[0]);
                V_txtTop5.setText(woman.txt_BAC23[1]);
                V_txtTop6.setText(woman.txt_BAC23[2]);
                V_txtOuter4.setText(woman.txt_BAC23[3]);
                V_txtOuter5.setText(woman.txt_BAC23[4]);
                V_txtOuter6.setText(woman.txt_BAC23[5]);
                V_txtBottom4.setText(woman.txt_BAC23[6]);
                V_txtBottom5.setText(woman.txt_BAC23[7]);
                V_txtBottom6.setText(woman.txt_BAC23[8]);
            }else if(result.equals("BAD")){
                // 더위많이탐 댄디
                V_ITopclothes4.setImageResource(woman.BAD23[0]);
                V_ITopclothes5.setImageResource(woman.BAD23[1]);
                V_ITopclothes6.setImageResource(woman.BAD23[2]);
                V_IOuterclothes4.setImageResource(woman.BAD23[3]);
                V_IOuterclothes5.setImageResource(woman.BAD23[4]);
                V_IOuterclothes6.setImageResource(woman.BAD23[5]);
                V_IBottomclothes4.setImageResource(woman.BAD23[6]);
                V_IBottomclothes5.setImageResource(woman.BAD23[7]);
                V_IBottomclothes6.setImageResource(woman.BAD23[8]);
                V_txtTop4.setText(woman.txt_BAD23[0]);
                V_txtTop5.setText(woman.txt_BAD23[1]);
                V_txtTop6.setText(woman.txt_BAD23[2]);
                V_txtOuter4.setText(woman.txt_BAD23[3]);
                V_txtOuter5.setText(woman.txt_BAD23[4]);
                V_txtOuter6.setText(woman.txt_BAD23[5]);
                V_txtBottom4.setText(woman.txt_BAD23[6]);
                V_txtBottom5.setText(woman.txt_BAD23[7]);
                V_txtBottom6.setText(woman.txt_BAD23[8]);

            }else if(result.equals("BAE")){
                // 더위많이탐 스포티
                V_ITopclothes4.setImageResource(woman.BAE23[0]);
                V_ITopclothes5.setImageResource(woman.BAE23[1]);
                V_ITopclothes6.setImageResource(woman.BAE23[2]);
                V_IOuterclothes4.setImageResource(woman.BAE23[3]);
                V_IOuterclothes5.setImageResource(woman.BAE23[4]);
                V_IOuterclothes6.setImageResource(woman.BAE23[5]);
                V_IBottomclothes4.setImageResource(woman.BAE23[6]);
                V_IBottomclothes5.setImageResource(woman.BAE23[7]);
                V_IBottomclothes6.setImageResource(woman.BAE23[8]);
                V_txtTop4.setText(woman.txt_BAE23[0]);
                V_txtTop5.setText(woman.txt_BAE23[1]);
                V_txtTop6.setText(woman.txt_BAE23[2]);
                V_txtOuter4.setText(woman.txt_BAE23[3]);
                V_txtOuter5.setText(woman.txt_BAE23[4]);
                V_txtOuter6.setText(woman.txt_BAE23[5]);
                V_txtBottom4.setText(woman.txt_BAE23[6]);
                V_txtBottom5.setText(woman.txt_BAE23[7]);
                V_txtBottom6.setText(woman.txt_BAE23[8]);

            }else if(result.equals("BBA")){
                // 더위적게탐 캐주얼
                V_ITopclothes4.setImageResource(woman.BBA23[0]);
                V_ITopclothes5.setImageResource(woman.BBA23[1]);
                V_ITopclothes6.setImageResource(woman.BBA23[2]);
                V_IOuterclothes4.setImageResource(woman.BBA23[3]);
                V_IOuterclothes5.setImageResource(woman.BBA23[4]);
                V_IOuterclothes6.setImageResource(woman.BBA23[5]);
                V_IBottomclothes4.setImageResource(woman.BBA23[6]);
                V_IBottomclothes5.setImageResource(woman.BBA23[7]);
                V_IBottomclothes6.setImageResource(woman.BBA23[8]);
                V_txtTop4.setText(woman.txt_BBA23[0]);
                V_txtTop5.setText(woman.txt_BBA23[1]);
                V_txtTop6.setText(woman.txt_BBA23[2]);
                V_txtOuter4.setText(woman.txt_BBA23[3]);
                V_txtOuter5.setText(woman.txt_BBA23[4]);
                V_txtOuter6.setText(woman.txt_BBA23[5]);
                V_txtBottom4.setText(woman.txt_BBA23[6]);
                V_txtBottom5.setText(woman.txt_BBA23[7]);
                V_txtBottom6.setText(woman.txt_BBA23[8]);

            }else if(result.equals("BBB")){
                // 더위적게탐 빈티지
                V_ITopclothes4.setImageResource(woman.BBB23[0]);
                V_ITopclothes5.setImageResource(woman.BBB23[1]);
                V_ITopclothes6.setImageResource(woman.BBB23[2]);
                V_IOuterclothes4.setImageResource(woman.BBB23[3]);
                V_IOuterclothes5.setImageResource(woman.BBB23[4]);
                V_IOuterclothes6.setImageResource(woman.BBB23[5]);
                V_IBottomclothes4.setImageResource(woman.BBB23[6]);
                V_IBottomclothes5.setImageResource(woman.BBB23[7]);
                V_IBottomclothes6.setImageResource(woman.BBB23[8]);
                V_txtTop4.setText(woman.txt_BBB23[0]);
                V_txtTop5.setText(woman.txt_BBB23[1]);
                V_txtTop6.setText(woman.txt_BBB23[2]);
                V_txtOuter4.setText(woman.txt_BBB23[3]);
                V_txtOuter5.setText(woman.txt_BBB23[4]);
                V_txtOuter6.setText(woman.txt_BBB23[5]);
                V_txtBottom4.setText(woman.txt_BBB23[6]);
                V_txtBottom5.setText(woman.txt_BBB23[7]);
                V_txtBottom6.setText(woman.txt_BBB23[8]);
            }else if(result.equals("BBC")){
                // 더위적게탐 스트릿
                V_ITopclothes4.setImageResource(woman.BBC23[0]);
                V_ITopclothes5.setImageResource(woman.BBC23[1]);
                V_ITopclothes6.setImageResource(woman.BBC23[2]);
                V_IOuterclothes4.setImageResource(woman.BBC23[3]);
                V_IOuterclothes5.setImageResource(woman.BBC23[4]);
                V_IOuterclothes6.setImageResource(woman.BBC23[5]);
                V_IBottomclothes4.setImageResource(woman.BBC23[6]);
                V_IBottomclothes5.setImageResource(woman.BBC23[7]);
                V_IBottomclothes6.setImageResource(woman.BBC23[8]);
                V_txtTop4.setText(woman.txt_BBC23[0]);
                V_txtTop5.setText(woman.txt_BBC23[1]);
                V_txtTop6.setText(woman.txt_BBC23[2]);
                V_txtOuter4.setText(woman.txt_BBC23[3]);
                V_txtOuter5.setText(woman.txt_BBC23[4]);
                V_txtOuter6.setText(woman.txt_BBC23[5]);
                V_txtBottom4.setText(woman.txt_BBC23[6]);
                V_txtBottom5.setText(woman.txt_BBC23[7]);
                V_txtBottom6.setText(woman.txt_BBC23[8]);
            }else if(result.equals("BBD")){
                // 더위적게탐 댄디
                V_ITopclothes4.setImageResource(woman.BBD23[0]);
                V_ITopclothes5.setImageResource(woman.BBD23[1]);
                V_ITopclothes6.setImageResource(woman.BBD23[2]);
                V_IOuterclothes4.setImageResource(woman.BBD23[3]);
                V_IOuterclothes5.setImageResource(woman.BBD23[4]);
                V_IOuterclothes6.setImageResource(woman.BBD23[5]);
                V_IBottomclothes4.setImageResource(woman.BBD23[6]);
                V_IBottomclothes5.setImageResource(woman.BBD23[7]);
                V_IBottomclothes6.setImageResource(woman.BBD23[8]);
                V_txtTop4.setText(woman.txt_BBD23[0]);
                V_txtTop5.setText(woman.txt_BBD23[1]);
                V_txtTop6.setText(woman.txt_BBD23[2]);
                V_txtOuter4.setText(woman.txt_BBD23[3]);
                V_txtOuter5.setText(woman.txt_BBD23[4]);
                V_txtOuter6.setText(woman.txt_BBD23[5]);
                V_txtBottom4.setText(woman.txt_BBD23[6]);
                V_txtBottom5.setText(woman.txt_BBD23[7]);
                V_txtBottom6.setText(woman.txt_BBD23[8]);

            }else{
                // BBE 더위적게탐 스포티
                V_ITopclothes4.setImageResource(woman.BBE23[0]);
                V_ITopclothes5.setImageResource(woman.BBE23[1]);
                V_ITopclothes6.setImageResource(woman.BBE23[2]);
                V_IOuterclothes4.setImageResource(woman.BBE23[3]);
                V_IOuterclothes5.setImageResource(woman.BBE23[4]);
                V_IOuterclothes6.setImageResource(woman.BBE23[5]);
                V_IBottomclothes4.setImageResource(woman.BBE23[6]);
                V_IBottomclothes5.setImageResource(woman.BBE23[7]);
                V_IBottomclothes6.setImageResource(woman.BBE23[8]);
                V_txtTop4.setText(woman.txt_BBE23[0]);
                V_txtTop5.setText(woman.txt_BBE23[1]);
                V_txtTop6.setText(woman.txt_BBE23[2]);
                V_txtOuter4.setText(woman.txt_BBE23[3]);
                V_txtOuter5.setText(woman.txt_BBE23[4]);
                V_txtOuter6.setText(woman.txt_BBE23[5]);
                V_txtBottom4.setText(woman.txt_BBE23[6]);
                V_txtBottom5.setText(woman.txt_BBE23[7]);
                V_txtBottom6.setText(woman.txt_BBE23[8]);
            }
        }else if(low_temp == 28){
            if(result.equals("BAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes4.setImageResource(woman.BAA28[0]);
                V_ITopclothes5.setImageResource(woman.BAA28[1]);
                V_ITopclothes6.setImageResource(woman.BAA28[2]);
                V_IOuterclothes4.setImageResource(woman.BAA28[3]);
                V_IOuterclothes5.setImageResource(woman.BAA28[4]);
                V_IOuterclothes6.setImageResource(woman.BAA28[5]);
                V_IBottomclothes4.setImageResource(woman.BAA28[6]);
                V_IBottomclothes5.setImageResource(woman.BAA28[7]);
                V_IBottomclothes6.setImageResource(woman.BAA28[8]);
                V_txtTop4.setText(woman.txt_BAA28[0]);
                V_txtTop5.setText(woman.txt_BAA28[1]);
                V_txtTop6.setText(woman.txt_BAA28[2]);
                V_txtOuter4.setText(woman.txt_BAA28[3]);
                V_txtOuter5.setText(woman.txt_BAA28[4]);
                V_txtOuter6.setText(woman.txt_BAA28[5]);
                V_txtBottom4.setText(woman.txt_BAA28[6]);
                V_txtBottom5.setText(woman.txt_BAA28[7]);
                V_txtBottom6.setText(woman.txt_BAA28[8]);

            }else if(result.equals("BAB")){
                // 더위많이탐 빈티지
                V_ITopclothes4.setImageResource(woman.BAB28[0]);
                V_ITopclothes5.setImageResource(woman.BAB28[1]);
                V_ITopclothes6.setImageResource(woman.BAB28[2]);
                V_IOuterclothes4.setImageResource(woman.BAB28[3]);
                V_IOuterclothes5.setImageResource(woman.BAB28[4]);
                V_IOuterclothes6.setImageResource(woman.BAB28[5]);
                V_IBottomclothes4.setImageResource(woman.BAB28[6]);
                V_IBottomclothes5.setImageResource(woman.BAB28[7]);
                V_IBottomclothes6.setImageResource(woman.BAB28[8]);
                V_txtTop4.setText(woman.txt_BAB28[0]);
                V_txtTop5.setText(woman.txt_BAB28[1]);
                V_txtTop6.setText(woman.txt_BAB28[2]);
                V_txtOuter4.setText(woman.txt_BAB28[3]);
                V_txtOuter5.setText(woman.txt_BAB28[4]);
                V_txtOuter6.setText(woman.txt_BAB28[5]);
                V_txtBottom4.setText(woman.txt_BAB28[6]);
                V_txtBottom5.setText(woman.txt_BAB28[7]);
                V_txtBottom6.setText(woman.txt_BAB28[8]);
            }else if(result.equals("BAC")){
                // 더위많이탐 스트릿
                V_ITopclothes4.setImageResource(woman.BAC28[0]);
                V_ITopclothes5.setImageResource(woman.BAC28[1]);
                V_ITopclothes6.setImageResource(woman.BAC28[2]);
                V_IOuterclothes4.setImageResource(woman.BAC28[3]);
                V_IOuterclothes5.setImageResource(woman.BAC28[4]);
                V_IOuterclothes6.setImageResource(woman.BAC28[5]);
                V_IBottomclothes4.setImageResource(woman.BAC28[6]);
                V_IBottomclothes5.setImageResource(woman.BAC28[7]);
                V_IBottomclothes6.setImageResource(woman.BAC28[8]);
                V_txtTop4.setText(woman.txt_BAC28[0]);
                V_txtTop5.setText(woman.txt_BAC28[1]);
                V_txtTop6.setText(woman.txt_BAC28[2]);
                V_txtOuter4.setText(woman.txt_BAC28[3]);
                V_txtOuter5.setText(woman.txt_BAC28[4]);
                V_txtOuter6.setText(woman.txt_BAC28[5]);
                V_txtBottom4.setText(woman.txt_BAC28[6]);
                V_txtBottom5.setText(woman.txt_BAC28[7]);
                V_txtBottom6.setText(woman.txt_BAC28[8]);
            }else if(result.equals("BAD")){
                // 더위많이탐 댄디
                V_ITopclothes4.setImageResource(woman.BAD28[0]);
                V_ITopclothes5.setImageResource(woman.BAD28[1]);
                V_ITopclothes6.setImageResource(woman.BAD28[2]);
                V_IOuterclothes4.setImageResource(woman.BAD28[3]);
                V_IOuterclothes5.setImageResource(woman.BAD28[4]);
                V_IOuterclothes6.setImageResource(woman.BAD28[5]);
                V_IBottomclothes4.setImageResource(woman.BAD28[6]);
                V_IBottomclothes5.setImageResource(woman.BAD28[7]);
                V_IBottomclothes6.setImageResource(woman.BAD28[8]);
                V_txtTop4.setText(woman.txt_BAD28[0]);
                V_txtTop5.setText(woman.txt_BAD28[1]);
                V_txtTop6.setText(woman.txt_BAD28[2]);
                V_txtOuter4.setText(woman.txt_BAD28[3]);
                V_txtOuter5.setText(woman.txt_BAD28[4]);
                V_txtOuter6.setText(woman.txt_BAD28[5]);
                V_txtBottom4.setText(woman.txt_BAD28[6]);
                V_txtBottom5.setText(woman.txt_BAD28[7]);
                V_txtBottom6.setText(woman.txt_BAD28[8]);

            }else if(result.equals("BAE")){
                // 더위많이탐 스포티
                V_ITopclothes4.setImageResource(woman.BAE28[0]);
                V_ITopclothes5.setImageResource(woman.BAE28[1]);
                V_ITopclothes6.setImageResource(woman.BAE28[2]);
                V_IOuterclothes4.setImageResource(woman.BAE28[3]);
                V_IOuterclothes5.setImageResource(woman.BAE28[4]);
                V_IOuterclothes6.setImageResource(woman.BAE28[5]);
                V_IBottomclothes4.setImageResource(woman.BAE28[6]);
                V_IBottomclothes5.setImageResource(woman.BAE28[7]);
                V_IBottomclothes6.setImageResource(woman.BAE28[8]);
                V_txtTop4.setText(woman.txt_BAE28[0]);
                V_txtTop5.setText(woman.txt_BAE28[1]);
                V_txtTop6.setText(woman.txt_BAE28[2]);
                V_txtOuter4.setText(woman.txt_BAE28[3]);
                V_txtOuter5.setText(woman.txt_BAE28[4]);
                V_txtOuter6.setText(woman.txt_BAE28[5]);
                V_txtBottom4.setText(woman.txt_BAE28[6]);
                V_txtBottom5.setText(woman.txt_BAE28[7]);
                V_txtBottom6.setText(woman.txt_BAE28[8]);

            }else if(result.equals("BBA")){
                // 더위적게탐 캐주얼
                V_ITopclothes4.setImageResource(woman.BBA28[0]);
                V_ITopclothes5.setImageResource(woman.BBA28[1]);
                V_ITopclothes6.setImageResource(woman.BBA28[2]);
                V_IOuterclothes4.setImageResource(woman.BBA28[3]);
                V_IOuterclothes5.setImageResource(woman.BBA28[4]);
                V_IOuterclothes6.setImageResource(woman.BBA28[5]);
                V_IBottomclothes4.setImageResource(woman.BBA28[6]);
                V_IBottomclothes5.setImageResource(woman.BBA28[7]);
                V_IBottomclothes6.setImageResource(woman.BBA28[8]);
                V_txtTop4.setText(woman.txt_BBA28[0]);
                V_txtTop5.setText(woman.txt_BBA28[1]);
                V_txtTop6.setText(woman.txt_BBA28[2]);
                V_txtOuter4.setText(woman.txt_BBA28[3]);
                V_txtOuter5.setText(woman.txt_BBA28[4]);
                V_txtOuter6.setText(woman.txt_BBA28[5]);
                V_txtBottom4.setText(woman.txt_BBA28[6]);
                V_txtBottom5.setText(woman.txt_BBA28[7]);
                V_txtBottom6.setText(woman.txt_BBA28[8]);

            }else if(result.equals("BBB")){
                // 더위적게탐 빈티지
                V_ITopclothes4.setImageResource(woman.BBB28[0]);
                V_ITopclothes5.setImageResource(woman.BBB28[1]);
                V_ITopclothes6.setImageResource(woman.BBB28[2]);
                V_IOuterclothes4.setImageResource(woman.BBB28[3]);
                V_IOuterclothes5.setImageResource(woman.BBB28[4]);
                V_IOuterclothes6.setImageResource(woman.BBB28[5]);
                V_IBottomclothes4.setImageResource(woman.BBB28[6]);
                V_IBottomclothes5.setImageResource(woman.BBB28[7]);
                V_IBottomclothes6.setImageResource(woman.BBB28[8]);
                V_txtTop4.setText(woman.txt_BBB28[0]);
                V_txtTop5.setText(woman.txt_BBB28[1]);
                V_txtTop6.setText(woman.txt_BBB28[2]);
                V_txtOuter4.setText(woman.txt_BBB28[3]);
                V_txtOuter5.setText(woman.txt_BBB28[4]);
                V_txtOuter6.setText(woman.txt_BBB28[5]);
                V_txtBottom4.setText(woman.txt_BBB28[6]);
                V_txtBottom5.setText(woman.txt_BBB28[7]);
                V_txtBottom6.setText(woman.txt_BBB28[8]);
            }else if(result.equals("BBC")){
                // 더위적게탐 스트릿
                V_ITopclothes4.setImageResource(woman.BBC28[0]);
                V_ITopclothes5.setImageResource(woman.BBC28[1]);
                V_ITopclothes6.setImageResource(woman.BBC28[2]);
                V_IOuterclothes4.setImageResource(woman.BBC28[3]);
                V_IOuterclothes5.setImageResource(woman.BBC28[4]);
                V_IOuterclothes6.setImageResource(woman.BBC28[5]);
                V_IBottomclothes4.setImageResource(woman.BBC28[6]);
                V_IBottomclothes5.setImageResource(woman.BBC28[7]);
                V_IBottomclothes6.setImageResource(woman.BBC28[8]);
                V_txtTop4.setText(woman.txt_BBC28[0]);
                V_txtTop5.setText(woman.txt_BBC28[1]);
                V_txtTop6.setText(woman.txt_BBC28[2]);
                V_txtOuter4.setText(woman.txt_BBC28[3]);
                V_txtOuter5.setText(woman.txt_BBC28[4]);
                V_txtOuter6.setText(woman.txt_BBC28[5]);
                V_txtBottom4.setText(woman.txt_BBC28[6]);
                V_txtBottom5.setText(woman.txt_BBC28[7]);
                V_txtBottom6.setText(woman.txt_BBC28[8]);
            }else if(result.equals("BBD")){
                // 더위적게탐 댄디
                V_ITopclothes4.setImageResource(woman.BBD28[0]);
                V_ITopclothes5.setImageResource(woman.BBD28[1]);
                V_ITopclothes6.setImageResource(woman.BBD28[2]);
                V_IOuterclothes4.setImageResource(woman.BBD28[3]);
                V_IOuterclothes5.setImageResource(woman.BBD28[4]);
                V_IOuterclothes6.setImageResource(woman.BBD28[5]);
                V_IBottomclothes4.setImageResource(woman.BBD28[6]);
                V_IBottomclothes5.setImageResource(woman.BBD28[7]);
                V_IBottomclothes6.setImageResource(woman.BBD28[8]);
                V_txtTop4.setText(woman.txt_BBD28[0]);
                V_txtTop5.setText(woman.txt_BBD28[1]);
                V_txtTop6.setText(woman.txt_BBD28[2]);
                V_txtOuter4.setText(woman.txt_BBD28[3]);
                V_txtOuter5.setText(woman.txt_BBD28[4]);
                V_txtOuter6.setText(woman.txt_BBD28[5]);
                V_txtBottom4.setText(woman.txt_BBD28[6]);
                V_txtBottom5.setText(woman.txt_BBD28[7]);
                V_txtBottom6.setText(woman.txt_BBD28[8]);

            }else{
                // BBE 더위적게탐 스포티
                V_ITopclothes4.setImageResource(woman.BBE28[0]);
                V_ITopclothes5.setImageResource(woman.BBE28[1]);
                V_ITopclothes6.setImageResource(woman.BBE28[2]);
                V_IOuterclothes4.setImageResource(woman.BBE28[3]);
                V_IOuterclothes5.setImageResource(woman.BBE28[4]);
                V_IOuterclothes6.setImageResource(woman.BBE28[5]);
                V_IBottomclothes4.setImageResource(woman.BBE28[6]);
                V_IBottomclothes5.setImageResource(woman.BBE28[7]);
                V_IBottomclothes6.setImageResource(woman.BBE28[8]);
                V_txtTop4.setText(woman.txt_BBE28[0]);
                V_txtTop5.setText(woman.txt_BBE28[1]);
                V_txtTop6.setText(woman.txt_BBE28[2]);
                V_txtOuter4.setText(woman.txt_BBE28[3]);
                V_txtOuter5.setText(woman.txt_BBE28[4]);
                V_txtOuter6.setText(woman.txt_BBE28[5]);
                V_txtBottom4.setText(woman.txt_BBE28[6]);
                V_txtBottom5.setText(woman.txt_BBE28[7]);
                V_txtBottom6.setText(woman.txt_BBE28[8]);
            }

        }
    }


    //*****************************************************************************************
    // 설문지에 따른 옷을 보여주기 위해 사용
    public void MatchingStyle(){
        Log.d("MatchingStyle", "MatchingStyle 들어옴");
        if(m_gender.equals("여자")){
            // 여자
            Log.d("여자","성공");
            if(m_heat.equals("더위 많이 타는 타입")){
                Log.d("더위 많이 타는 타입","성공");
                // 더위를 많이 타는 타입
                if(m_style.equals("캐주얼 타입")){
                    Log.d("응답하라", "1997 상의");
                    m_MATCHING_style = "BAA";
                }else if(m_style.equals("빈티지 타입")){
                    m_MATCHING_style = "BAB";
                }else if(m_style.equals("스트릿 타입")){
                    m_MATCHING_style = "BAC";
                }else if(m_style.equals("댄디 타입")){
                    m_MATCHING_style = "BAD";
                }else{
                    // 스프티 타입
                    m_MATCHING_style = "BAE";
                }

            }else{
                // 더위를 적게 타는 타입.
                if(m_style.equals("캐주얼 타입")){
                    m_MATCHING_style = "BBA";
                }else if(m_style.equals("빈티지 타입")){
                    m_MATCHING_style = "BBB";
                }else if(m_style.equals("스트릿 타입")){
                    m_MATCHING_style = "BBC";
                }else if(m_style.equals("댄디 타입")){
                    m_MATCHING_style = "BBD";
                }else{
                    // 스프티 타입
                    m_MATCHING_style = "BBE";
                }
            }
        }
    }

    //*********************************************************************************
    //m_Maximum_temperature m_Lowest_temperature
    // 조언 문구
    public void AdviceBox()
    {
        // 조언 문구
        String CAdvice = AdviceBoxDaily_cross()  + AdviceBoxRain()  + AdviceBoxWind() + AdviceBoxMaxTemp();
        V_advice.setText(CAdvice);
    }

    public String AdviceBoxDaily_cross()
    {
        int Daily_cross = m_Maximum_temperature - m_Lowest_temperature;
        if(Daily_cross >= 7)
        {
            return "오늘은 일교차가 커요!!\n";
        }else{
            return "오늘은 일교차가 크지 않아요!!\n";
        }
    }

    // 강수량
    public String AdviceBoxRain()
    {
        if(m_crain >= 0 && m_crain <= 50)
        {
            return "";
        }else{
            return "오늘은 비가 오니깐 우산은 필수!~\n";
        }
    }

    // 바람 세기
    public String AdviceBoxWind()
    {
        if(m_cwind >= 0.0 && m_cwind >= 1.0)
        {
            return "오늘은 바람이 하나도 안 불어요~!\n";
        }else if (m_cwind >= 1.1 && m_cwind >= 2.0)
        {
            return "오늘은 바람이 조금 불어요~!\n";
        }else {
            return "오늘은 바람이 엄청 불어요~!\n";
        }
    }

    // 최고 기온에 따른 조언 문구
    public String AdviceBoxMaxTemp()
    {
        if(m_Maximum_temperature >= 25) {
            return "금일 여름 중에서 많이 더워요~!\n";
        }else if (m_Maximum_temperature >= 15){
            return "오늘은 쌀쌀한 편이군요~\n";
        }else {
            return "오늘은 따뜻하게 입는게 좋겠군요\n";
        }
    }
}
