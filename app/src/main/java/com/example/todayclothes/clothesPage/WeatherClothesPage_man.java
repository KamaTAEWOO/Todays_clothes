/*
*
- 남 -> 더위많이탐 ->  캐쥬얼 AAA
- 남  더위많이탐 빈티지  AAB
- 남  더위많이탐. 스트릿 AAC
- 남  더위많이탐. 댄디 AAD
- 남  더위많이탐. 스프티 AAE

- 남 -> 더위 적게탐 ->  캐쥬얼 ABA
- 남  더위 적게탐  빈티지 ABB
- 남  더위 적게탐 . 스트릿 ABC
- 남  더위 적게탐 . 댄디 ABD
- 남  더위 적게탐 . 스프티 ABE

- 여 -> 더위많이탐 ->  캐쥬얼  BAA
- 여  더위많이탐 빈티지  BAB
- 여  더위많이탐. 스트릿  BAC
- 여  더위많이탐. 댄디  BAD
- 여  더위많이탐. 스프티  BAE

- 여 -> 더위 적게탐 ->  캐쥬얼 BBA
- 여  더위 적게탐  빈티지 BBB
- 여  더위 적게탐 . 스트릿 BBC
- 여  더위 적게탐 . 댄디 BBD
- 여  더위 적게탐 . 스프티 BBE
* */

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

public class WeatherClothesPage_man extends AppCompatActivity{
    TextView V_CTemp;
    TextView V_CHTemp;
    TextView V_CLTemp;
    ImageButton V_IweatherPage;
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
        setContentView(R.layout.activity_weather_clothes_page);

        V_CTemp = (TextView) findViewById(R.id.CTemp);
        V_CHTemp = (TextView) findViewById(R.id.CHTemp);
        V_CLTemp = (TextView) findViewById(R.id.CLTemp);
        V_IweatherPage = (ImageButton) findViewById(R.id.btn_weatherMainPage);

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

        String man_cTemp = intent.getExtras().getString("cTemp"); // 현재온도
        // 현재 기온
        V_CTemp.setText( man_cTemp + "°C");

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

        // 버튼
        V_IweatherPage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), MainWeatherPage.class);
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
        ClothesArray_man man = new ClothesArray_man();

        // temp => 현재 온도값의 범위, result => 사용자가 설문지 조사한 결과
        // 최고기온과 결과값
        if(max_temp == 4){
            if(result.equals("AAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes1.setImageResource(man.AAA4[0]);
                V_ITopclothes2.setImageResource(man.AAA4[1]);
                V_ITopclothes3.setImageResource(man.AAA4[2]);
                V_IOuterclothes1.setImageResource(man.AAA4[3]);
                V_IOuterclothes2.setImageResource(man.AAA4[4]);
                V_IOuterclothes3.setImageResource(man.AAA4[5]);
                V_IBottomclothes1.setImageResource(man.AAA4[6]);
                V_IBottomclothes2.setImageResource(man.AAA4[7]);
                V_IBottomclothes3.setImageResource(man.AAA4[8]);
                V_txtTop1.setText(man.txt_AAA4[0]);
                V_txtTop2.setText(man.txt_AAA4[1]);
                V_txtTop3.setText(man.txt_AAA4[2]);
                V_txtOuter1.setText(man.txt_AAA4[3]);
                V_txtOuter2.setText(man.txt_AAA4[4]);
                V_txtOuter3.setText(man.txt_AAA4[5]);
                V_txtBottom1.setText(man.txt_AAA4[6]);
                V_txtBottom2.setText(man.txt_AAA4[7]);
                V_txtBottom3.setText(man.txt_AAA4[8]);

            }else if(result.equals("AAB")){
                // 더위많이탐 빈티지
                V_ITopclothes1.setImageResource(man.AAB4[0]);
                V_ITopclothes2.setImageResource(man.AAB4[1]);
                V_ITopclothes3.setImageResource(man.AAB4[2]);
                V_IOuterclothes1.setImageResource(man.AAB4[3]);
                V_IOuterclothes2.setImageResource(man.AAB4[4]);
                V_IOuterclothes3.setImageResource(man.AAB4[5]);
                V_IBottomclothes1.setImageResource(man.AAB4[6]);
                V_IBottomclothes2.setImageResource(man.AAB4[7]);
                V_IBottomclothes3.setImageResource(man.AAB4[8]);
                V_txtTop1.setText(man.txt_AAB4[0]);
                V_txtTop2.setText(man.txt_AAB4[1]);
                V_txtTop3.setText(man.txt_AAB4[2]);
                V_txtOuter1.setText(man.txt_AAB4[3]);
                V_txtOuter2.setText(man.txt_AAB4[4]);
                V_txtOuter3.setText(man.txt_AAB4[5]);
                V_txtBottom1.setText(man.txt_AAB4[6]);
                V_txtBottom2.setText(man.txt_AAB4[7]);
                V_txtBottom3.setText(man.txt_AAB4[8]);
            }else if(result.equals("AAC")){
                // 더위많이탐 스트릿
                V_ITopclothes1.setImageResource(man.AAC4[0]);
                V_ITopclothes2.setImageResource(man.AAC4[1]);
                V_ITopclothes3.setImageResource(man.AAC4[2]);
                V_IOuterclothes1.setImageResource(man.AAC4[3]);
                V_IOuterclothes2.setImageResource(man.AAC4[4]);
                V_IOuterclothes3.setImageResource(man.AAC4[5]);
                V_IBottomclothes1.setImageResource(man.AAC4[6]);
                V_IBottomclothes2.setImageResource(man.AAC4[7]);
                V_IBottomclothes3.setImageResource(man.AAC4[8]);
                V_txtTop1.setText(man.txt_AAC4[0]);
                V_txtTop2.setText(man.txt_AAC4[1]);
                V_txtTop3.setText(man.txt_AAC4[2]);
                V_txtOuter1.setText(man.txt_AAC4[3]);
                V_txtOuter2.setText(man.txt_AAC4[4]);
                V_txtOuter3.setText(man.txt_AAC4[5]);
                V_txtBottom1.setText(man.txt_AAC4[6]);
                V_txtBottom2.setText(man.txt_AAC4[7]);
                V_txtBottom3.setText(man.txt_AAC4[8]);
            }else if(result.equals("AAD")){
                // 더위많이탐 댄디
                V_ITopclothes1.setImageResource(man.AAD4[0]);
                V_ITopclothes2.setImageResource(man.AAD4[1]);
                V_ITopclothes3.setImageResource(man.AAD4[2]);
                V_IOuterclothes1.setImageResource(man.AAD4[3]);
                V_IOuterclothes2.setImageResource(man.AAD4[4]);
                V_IOuterclothes3.setImageResource(man.AAD4[5]);
                V_IBottomclothes1.setImageResource(man.AAD4[6]);
                V_IBottomclothes2.setImageResource(man.AAD4[7]);
                V_IBottomclothes3.setImageResource(man.AAD4[8]);
                V_txtTop1.setText(man.txt_AAD4[0]);
                V_txtTop2.setText(man.txt_AAD4[1]);
                V_txtTop3.setText(man.txt_AAD4[2]);
                V_txtOuter1.setText(man.txt_AAD4[3]);
                V_txtOuter2.setText(man.txt_AAD4[4]);
                V_txtOuter3.setText(man.txt_AAD4[5]);
                V_txtBottom1.setText(man.txt_AAD4[6]);
                V_txtBottom2.setText(man.txt_AAD4[7]);
                V_txtBottom3.setText(man.txt_AAD4[8]);

            }else if(result.equals("AAE")){
                // 더위많이탐 스포티
                V_ITopclothes1.setImageResource(man.AAE4[0]);
                V_ITopclothes2.setImageResource(man.AAE4[1]);
                V_ITopclothes3.setImageResource(man.AAE4[2]);
                V_IOuterclothes1.setImageResource(man.AAE4[3]);
                V_IOuterclothes2.setImageResource(man.AAE4[4]);
                V_IOuterclothes3.setImageResource(man.AAE4[5]);
                V_IBottomclothes1.setImageResource(man.AAE4[6]);
                V_IBottomclothes2.setImageResource(man.AAE4[7]);
                V_IBottomclothes3.setImageResource(man.AAE4[8]);
                V_txtTop1.setText(man.txt_AAE4[0]);
                V_txtTop2.setText(man.txt_AAE4[1]);
                V_txtTop3.setText(man.txt_AAE4[2]);
                V_txtOuter1.setText(man.txt_AAE4[3]);
                V_txtOuter2.setText(man.txt_AAE4[4]);
                V_txtOuter3.setText(man.txt_AAE4[5]);
                V_txtBottom1.setText(man.txt_AAE4[6]);
                V_txtBottom2.setText(man.txt_AAE4[7]);
                V_txtBottom3.setText(man.txt_AAE4[8]);

            }else if(result.equals("ABA")){
                // 더위적게탐 캐주얼
                V_ITopclothes1.setImageResource(man.ABA4[0]);
                V_ITopclothes2.setImageResource(man.ABA4[1]);
                V_ITopclothes3.setImageResource(man.ABA4[2]);
                V_IOuterclothes1.setImageResource(man.ABA4[3]);
                V_IOuterclothes2.setImageResource(man.ABA4[4]);
                V_IOuterclothes3.setImageResource(man.ABA4[5]);
                V_IBottomclothes1.setImageResource(man.ABA4[6]);
                V_IBottomclothes2.setImageResource(man.ABA4[7]);
                V_IBottomclothes3.setImageResource(man.ABA4[8]);
                V_txtTop1.setText(man.txt_ABA4[0]);
                V_txtTop2.setText(man.txt_ABA4[1]);
                V_txtTop3.setText(man.txt_ABA4[2]);
                V_txtOuter1.setText(man.txt_ABA4[3]);
                V_txtOuter2.setText(man.txt_ABA4[4]);
                V_txtOuter3.setText(man.txt_ABA4[5]);
                V_txtBottom1.setText(man.txt_ABA4[6]);
                V_txtBottom2.setText(man.txt_ABA4[7]);
                V_txtBottom3.setText(man.txt_ABA4[8]);

            }else if(result.equals("ABB")){
                // 더위적게탐 빈티지
                V_ITopclothes1.setImageResource(man.ABB4[0]);
                V_ITopclothes2.setImageResource(man.ABB4[1]);
                V_ITopclothes3.setImageResource(man.ABB4[2]);
                V_IOuterclothes1.setImageResource(man.ABB4[3]);
                V_IOuterclothes2.setImageResource(man.ABB4[4]);
                V_IOuterclothes3.setImageResource(man.ABB4[5]);
                V_IBottomclothes1.setImageResource(man.ABB4[6]);
                V_IBottomclothes2.setImageResource(man.ABB4[7]);
                V_IBottomclothes3.setImageResource(man.ABB4[8]);
                V_txtTop1.setText(man.txt_ABB4[0]);
                V_txtTop2.setText(man.txt_ABB4[1]);
                V_txtTop3.setText(man.txt_ABB4[2]);
                V_txtOuter1.setText(man.txt_ABB4[3]);
                V_txtOuter2.setText(man.txt_ABB4[4]);
                V_txtOuter3.setText(man.txt_ABB4[5]);
                V_txtBottom1.setText(man.txt_ABB4[6]);
                V_txtBottom2.setText(man.txt_ABB4[7]);
                V_txtBottom3.setText(man.txt_ABB4[8]);
            }else if(result.equals("ABC")){
                // 더위적게탐 스트릿
                V_ITopclothes1.setImageResource(man.ABC4[0]);
                V_ITopclothes2.setImageResource(man.ABC4[1]);
                V_ITopclothes3.setImageResource(man.ABC4[2]);
                V_IOuterclothes1.setImageResource(man.ABC4[3]);
                V_IOuterclothes2.setImageResource(man.ABC4[4]);
                V_IOuterclothes3.setImageResource(man.ABC4[5]);
                V_IBottomclothes1.setImageResource(man.ABC4[6]);
                V_IBottomclothes2.setImageResource(man.ABC4[7]);
                V_IBottomclothes3.setImageResource(man.ABC4[8]);
                V_txtTop1.setText(man.txt_ABC4[0]);
                V_txtTop2.setText(man.txt_ABC4[1]);
                V_txtTop3.setText(man.txt_ABC4[2]);
                V_txtOuter1.setText(man.txt_ABC4[3]);
                V_txtOuter2.setText(man.txt_ABC4[4]);
                V_txtOuter3.setText(man.txt_ABC4[5]);
                V_txtBottom1.setText(man.txt_ABC4[6]);
                V_txtBottom2.setText(man.txt_ABC4[7]);
                V_txtBottom3.setText(man.txt_ABC4[8]);
            }else if(result.equals("ABD")){
                // 더위적게탐 댄디
                V_ITopclothes1.setImageResource(man.ABD4[0]);
                V_ITopclothes2.setImageResource(man.ABD4[1]);
                V_ITopclothes3.setImageResource(man.ABD4[2]);
                V_IOuterclothes1.setImageResource(man.ABD4[3]);
                V_IOuterclothes2.setImageResource(man.ABD4[4]);
                V_IOuterclothes3.setImageResource(man.ABD4[5]);
                V_IBottomclothes1.setImageResource(man.ABD4[6]);
                V_IBottomclothes2.setImageResource(man.ABD4[7]);
                V_IBottomclothes3.setImageResource(man.ABD4[8]);
                V_txtTop1.setText(man.txt_ABD4[0]);
                V_txtTop2.setText(man.txt_ABD4[1]);
                V_txtTop3.setText(man.txt_ABD4[2]);
                V_txtOuter1.setText(man.txt_ABD4[3]);
                V_txtOuter2.setText(man.txt_ABD4[4]);
                V_txtOuter3.setText(man.txt_ABD4[5]);
                V_txtBottom1.setText(man.txt_ABD4[6]);
                V_txtBottom2.setText(man.txt_ABD4[7]);
                V_txtBottom3.setText(man.txt_ABD4[8]);

            }else{
                // ABE 더위적게탐 스포티
                V_ITopclothes1.setImageResource(man.ABE4[0]);
                V_ITopclothes2.setImageResource(man.ABE4[1]);
                V_ITopclothes3.setImageResource(man.ABE4[2]);
                V_IOuterclothes1.setImageResource(man.ABE4[3]);
                V_IOuterclothes2.setImageResource(man.ABE4[4]);
                V_IOuterclothes3.setImageResource(man.ABE4[5]);
                V_IBottomclothes1.setImageResource(man.ABE4[6]);
                V_IBottomclothes2.setImageResource(man.ABE4[7]);
                V_IBottomclothes3.setImageResource(man.ABE4[8]);
                V_txtTop1.setText(man.txt_ABE4[0]);
                V_txtTop2.setText(man.txt_ABE4[1]);
                V_txtTop3.setText(man.txt_ABE4[2]);
                V_txtOuter1.setText(man.txt_ABE4[3]);
                V_txtOuter2.setText(man.txt_ABE4[4]);
                V_txtOuter3.setText(man.txt_ABE4[5]);
                V_txtBottom1.setText(man.txt_ABE4[6]);
                V_txtBottom2.setText(man.txt_ABE4[7]);
                V_txtBottom3.setText(man.txt_ABE4[8]);
            }
        }else if(max_temp == 5){
            if(result.equals("AAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes1.setImageResource(man.AAA5[0]);
                V_ITopclothes2.setImageResource(man.AAA5[1]);
                V_ITopclothes3.setImageResource(man.AAA5[2]);
                V_IOuterclothes1.setImageResource(man.AAA5[3]);
                V_IOuterclothes2.setImageResource(man.AAA5[4]);
                V_IOuterclothes3.setImageResource(man.AAA5[5]);
                V_IBottomclothes1.setImageResource(man.AAA5[6]);
                V_IBottomclothes2.setImageResource(man.AAA5[7]);
                V_IBottomclothes3.setImageResource(man.AAA5[8]);
                V_txtTop1.setText(man.txt_AAA5[0]);
                V_txtTop2.setText(man.txt_AAA5[1]);
                V_txtTop3.setText(man.txt_AAA5[2]);
                V_txtOuter1.setText(man.txt_AAA5[3]);
                V_txtOuter2.setText(man.txt_AAA5[4]);
                V_txtOuter3.setText(man.txt_AAA5[5]);
                V_txtBottom1.setText(man.txt_AAA5[6]);
                V_txtBottom2.setText(man.txt_AAA5[7]);
                V_txtBottom3.setText(man.txt_AAA5[8]);

            }else if(result.equals("AAB")){
                // 더위많이탐 빈티지
                V_ITopclothes1.setImageResource(man.AAB5[0]);
                V_ITopclothes2.setImageResource(man.AAB5[1]);
                V_ITopclothes3.setImageResource(man.AAB5[2]);
                V_IOuterclothes1.setImageResource(man.AAB5[3]);
                V_IOuterclothes2.setImageResource(man.AAB5[4]);
                V_IOuterclothes3.setImageResource(man.AAB5[5]);
                V_IBottomclothes1.setImageResource(man.AAB5[6]);
                V_IBottomclothes2.setImageResource(man.AAB5[7]);
                V_IBottomclothes3.setImageResource(man.AAB5[8]);
                V_txtTop1.setText(man.txt_AAB5[0]);
                V_txtTop2.setText(man.txt_AAB5[1]);
                V_txtTop3.setText(man.txt_AAB5[2]);
                V_txtOuter1.setText(man.txt_AAB5[3]);
                V_txtOuter2.setText(man.txt_AAB5[4]);
                V_txtOuter3.setText(man.txt_AAB5[5]);
                V_txtBottom1.setText(man.txt_AAB5[6]);
                V_txtBottom2.setText(man.txt_AAB5[7]);
                V_txtBottom3.setText(man.txt_AAB5[8]);
            }else if(result.equals("AAC")){
                // 더위많이탐 스트릿
                V_ITopclothes1.setImageResource(man.AAC5[0]);
                V_ITopclothes2.setImageResource(man.AAC5[1]);
                V_ITopclothes3.setImageResource(man.AAC5[2]);
                V_IOuterclothes1.setImageResource(man.AAC5[3]);
                V_IOuterclothes2.setImageResource(man.AAC5[4]);
                V_IOuterclothes3.setImageResource(man.AAC5[5]);
                V_IBottomclothes1.setImageResource(man.AAC5[6]);
                V_IBottomclothes2.setImageResource(man.AAC5[7]);
                V_IBottomclothes3.setImageResource(man.AAC5[8]);
                V_txtTop1.setText(man.txt_AAC5[0]);
                V_txtTop2.setText(man.txt_AAC5[1]);
                V_txtTop3.setText(man.txt_AAC5[2]);
                V_txtOuter1.setText(man.txt_AAC5[3]);
                V_txtOuter2.setText(man.txt_AAC5[4]);
                V_txtOuter3.setText(man.txt_AAC5[5]);
                V_txtBottom1.setText(man.txt_AAC5[6]);
                V_txtBottom2.setText(man.txt_AAC5[7]);
                V_txtBottom3.setText(man.txt_AAC5[8]);
            }else if(result.equals("AAD")){
                // 더위많이탐 댄디
                V_ITopclothes1.setImageResource(man.AAD5[0]);
                V_ITopclothes2.setImageResource(man.AAD5[1]);
                V_ITopclothes3.setImageResource(man.AAD5[2]);
                V_IOuterclothes1.setImageResource(man.AAD5[3]);
                V_IOuterclothes2.setImageResource(man.AAD5[4]);
                V_IOuterclothes3.setImageResource(man.AAD5[5]);
                V_IBottomclothes1.setImageResource(man.AAD5[6]);
                V_IBottomclothes2.setImageResource(man.AAD5[7]);
                V_IBottomclothes3.setImageResource(man.AAD5[8]);
                V_txtTop1.setText(man.txt_AAD5[0]);
                V_txtTop2.setText(man.txt_AAD5[1]);
                V_txtTop3.setText(man.txt_AAD5[2]);
                V_txtOuter1.setText(man.txt_AAD5[3]);
                V_txtOuter2.setText(man.txt_AAD5[4]);
                V_txtOuter3.setText(man.txt_AAD5[5]);
                V_txtBottom1.setText(man.txt_AAD5[6]);
                V_txtBottom2.setText(man.txt_AAD5[7]);
                V_txtBottom3.setText(man.txt_AAD5[8]);

            }else if(result.equals("AAE")){
                // 더위많이탐 스포티
                V_ITopclothes1.setImageResource(man.AAE5[0]);
                V_ITopclothes2.setImageResource(man.AAE5[1]);
                V_ITopclothes3.setImageResource(man.AAE5[2]);
                V_IOuterclothes1.setImageResource(man.AAE5[3]);
                V_IOuterclothes2.setImageResource(man.AAE5[4]);
                V_IOuterclothes3.setImageResource(man.AAE5[5]);
                V_IBottomclothes1.setImageResource(man.AAE5[6]);
                V_IBottomclothes2.setImageResource(man.AAE5[7]);
                V_IBottomclothes3.setImageResource(man.AAE5[8]);
                V_txtTop1.setText(man.txt_AAE5[0]);
                V_txtTop2.setText(man.txt_AAE5[1]);
                V_txtTop3.setText(man.txt_AAE5[2]);
                V_txtOuter1.setText(man.txt_AAE5[3]);
                V_txtOuter2.setText(man.txt_AAE5[4]);
                V_txtOuter3.setText(man.txt_AAE5[5]);
                V_txtBottom1.setText(man.txt_AAE5[6]);
                V_txtBottom2.setText(man.txt_AAE5[7]);
                V_txtBottom3.setText(man.txt_AAE5[8]);

            }else if(result.equals("ABA")){
                // 더위적게탐 캐주얼
                V_ITopclothes1.setImageResource(man.ABA5[0]);
                V_ITopclothes2.setImageResource(man.ABA5[1]);
                V_ITopclothes3.setImageResource(man.ABA5[2]);
                V_IOuterclothes1.setImageResource(man.ABA5[3]);
                V_IOuterclothes2.setImageResource(man.ABA5[4]);
                V_IOuterclothes3.setImageResource(man.ABA5[5]);
                V_IBottomclothes1.setImageResource(man.ABA5[6]);
                V_IBottomclothes2.setImageResource(man.ABA5[7]);
                V_IBottomclothes3.setImageResource(man.ABA5[8]);
                V_txtTop1.setText(man.txt_ABA5[0]);
                V_txtTop2.setText(man.txt_ABA5[1]);
                V_txtTop3.setText(man.txt_ABA5[2]);
                V_txtOuter1.setText(man.txt_ABA5[3]);
                V_txtOuter2.setText(man.txt_ABA5[4]);
                V_txtOuter3.setText(man.txt_ABA5[5]);
                V_txtBottom1.setText(man.txt_ABA5[6]);
                V_txtBottom2.setText(man.txt_ABA5[7]);
                V_txtBottom3.setText(man.txt_ABA5[8]);

            }else if(result.equals("ABB")){
                // 더위적게탐 빈티지
                V_ITopclothes1.setImageResource(man.ABB5[0]);
                V_ITopclothes2.setImageResource(man.ABB5[1]);
                V_ITopclothes3.setImageResource(man.ABB5[2]);
                V_IOuterclothes1.setImageResource(man.ABB5[3]);
                V_IOuterclothes2.setImageResource(man.ABB5[4]);
                V_IOuterclothes3.setImageResource(man.ABB5[5]);
                V_IBottomclothes1.setImageResource(man.ABB5[6]);
                V_IBottomclothes2.setImageResource(man.ABB5[7]);
                V_IBottomclothes3.setImageResource(man.ABB5[8]);
                V_txtTop1.setText(man.txt_ABB5[0]);
                V_txtTop2.setText(man.txt_ABB5[1]);
                V_txtTop3.setText(man.txt_ABB5[2]);
                V_txtOuter1.setText(man.txt_ABB5[3]);
                V_txtOuter2.setText(man.txt_ABB5[4]);
                V_txtOuter3.setText(man.txt_ABB5[5]);
                V_txtBottom1.setText(man.txt_ABB5[6]);
                V_txtBottom2.setText(man.txt_ABB5[7]);
                V_txtBottom3.setText(man.txt_ABB5[8]);
            }else if(result.equals("ABC")){
                // 더위적게탐 스트릿
                V_ITopclothes1.setImageResource(man.ABC5[0]);
                V_ITopclothes2.setImageResource(man.ABC5[1]);
                V_ITopclothes3.setImageResource(man.ABC5[2]);
                V_IOuterclothes1.setImageResource(man.ABC5[3]);
                V_IOuterclothes2.setImageResource(man.ABC5[4]);
                V_IOuterclothes3.setImageResource(man.ABC5[5]);
                V_IBottomclothes1.setImageResource(man.ABC5[6]);
                V_IBottomclothes2.setImageResource(man.ABC5[7]);
                V_IBottomclothes3.setImageResource(man.ABC5[8]);
                V_txtTop1.setText(man.txt_ABC5[0]);
                V_txtTop2.setText(man.txt_ABC5[1]);
                V_txtTop3.setText(man.txt_ABC5[2]);
                V_txtOuter1.setText(man.txt_ABC5[3]);
                V_txtOuter2.setText(man.txt_ABC5[4]);
                V_txtOuter3.setText(man.txt_ABC5[5]);
                V_txtBottom1.setText(man.txt_ABC5[6]);
                V_txtBottom2.setText(man.txt_ABC5[7]);
                V_txtBottom3.setText(man.txt_ABC5[8]);
            }else if(result.equals("ABD")){
                // 더위적게탐 댄디
                V_ITopclothes1.setImageResource(man.ABD5[0]);
                V_ITopclothes2.setImageResource(man.ABD5[1]);
                V_ITopclothes3.setImageResource(man.ABD5[2]);
                V_IOuterclothes1.setImageResource(man.ABD5[3]);
                V_IOuterclothes2.setImageResource(man.ABD5[4]);
                V_IOuterclothes3.setImageResource(man.ABD5[5]);
                V_IBottomclothes1.setImageResource(man.ABD5[6]);
                V_IBottomclothes2.setImageResource(man.ABD5[7]);
                V_IBottomclothes3.setImageResource(man.ABD5[8]);
                V_txtTop1.setText(man.txt_ABD5[0]);
                V_txtTop2.setText(man.txt_ABD5[1]);
                V_txtTop3.setText(man.txt_ABD5[2]);
                V_txtOuter1.setText(man.txt_ABD5[3]);
                V_txtOuter2.setText(man.txt_ABD5[4]);
                V_txtOuter3.setText(man.txt_ABD5[5]);
                V_txtBottom1.setText(man.txt_ABD5[6]);
                V_txtBottom2.setText(man.txt_ABD5[7]);
                V_txtBottom3.setText(man.txt_ABD5[8]);

            }else{
                // ABE 더위적게탐 스포티
                V_ITopclothes1.setImageResource(man.ABE5[0]);
                V_ITopclothes2.setImageResource(man.ABE5[1]);
                V_ITopclothes3.setImageResource(man.ABE5[2]);
                V_IOuterclothes1.setImageResource(man.ABE5[3]);
                V_IOuterclothes2.setImageResource(man.ABE5[4]);
                V_IOuterclothes3.setImageResource(man.ABE5[5]);
                V_IBottomclothes1.setImageResource(man.ABE5[6]);
                V_IBottomclothes2.setImageResource(man.ABE5[7]);
                V_IBottomclothes3.setImageResource(man.ABE5[8]);
                V_txtTop1.setText(man.txt_ABE5[0]);
                V_txtTop2.setText(man.txt_ABE5[1]);
                V_txtTop3.setText(man.txt_ABE5[2]);
                V_txtOuter1.setText(man.txt_ABE5[3]);
                V_txtOuter2.setText(man.txt_ABE5[4]);
                V_txtOuter3.setText(man.txt_ABE5[5]);
                V_txtBottom1.setText(man.txt_ABE5[6]);
                V_txtBottom2.setText(man.txt_ABE5[7]);
                V_txtBottom3.setText(man.txt_ABE5[8]);
            }
        }else if(max_temp == 9){
            if(result.equals("AAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes1.setImageResource(man.AAA9[0]);
                V_ITopclothes2.setImageResource(man.AAA9[1]);
                V_ITopclothes3.setImageResource(man.AAA9[2]);
                V_IOuterclothes1.setImageResource(man.AAA9[3]);
                V_IOuterclothes2.setImageResource(man.AAA9[4]);
                V_IOuterclothes3.setImageResource(man.AAA9[5]);
                V_IBottomclothes1.setImageResource(man.AAA9[6]);
                V_IBottomclothes2.setImageResource(man.AAA9[7]);
                V_IBottomclothes3.setImageResource(man.AAA9[8]);
                V_txtTop1.setText(man.txt_AAA9[0]);
                V_txtTop2.setText(man.txt_AAA9[1]);
                V_txtTop3.setText(man.txt_AAA9[2]);
                V_txtOuter1.setText(man.txt_AAA9[3]);
                V_txtOuter2.setText(man.txt_AAA9[4]);
                V_txtOuter3.setText(man.txt_AAA9[5]);
                V_txtBottom1.setText(man.txt_AAA9[6]);
                V_txtBottom2.setText(man.txt_AAA9[7]);
                V_txtBottom3.setText(man.txt_AAA9[8]);

            }else if(result.equals("AAB")){
                // 더위많이탐 빈티지
                V_ITopclothes1.setImageResource(man.AAB9[0]);
                V_ITopclothes2.setImageResource(man.AAB9[1]);
                V_ITopclothes3.setImageResource(man.AAB9[2]);
                V_IOuterclothes1.setImageResource(man.AAB9[3]);
                V_IOuterclothes2.setImageResource(man.AAB9[4]);
                V_IOuterclothes3.setImageResource(man.AAB9[5]);
                V_IBottomclothes1.setImageResource(man.AAB9[6]);
                V_IBottomclothes2.setImageResource(man.AAB9[7]);
                V_IBottomclothes3.setImageResource(man.AAB9[8]);
                V_txtTop1.setText(man.txt_AAB9[0]);
                V_txtTop2.setText(man.txt_AAB9[1]);
                V_txtTop3.setText(man.txt_AAB9[2]);
                V_txtOuter1.setText(man.txt_AAB9[3]);
                V_txtOuter2.setText(man.txt_AAB9[4]);
                V_txtOuter3.setText(man.txt_AAB9[5]);
                V_txtBottom1.setText(man.txt_AAB9[6]);
                V_txtBottom2.setText(man.txt_AAB9[7]);
                V_txtBottom3.setText(man.txt_AAB9[8]);
            }else if(result.equals("AAC")){
                // 더위많이탐 스트릿
                V_ITopclothes1.setImageResource(man.AAC9[0]);
                V_ITopclothes2.setImageResource(man.AAC9[1]);
                V_ITopclothes3.setImageResource(man.AAC9[2]);
                V_IOuterclothes1.setImageResource(man.AAC9[3]);
                V_IOuterclothes2.setImageResource(man.AAC9[4]);
                V_IOuterclothes3.setImageResource(man.AAC9[5]);
                V_IBottomclothes1.setImageResource(man.AAC9[6]);
                V_IBottomclothes2.setImageResource(man.AAC9[7]);
                V_IBottomclothes3.setImageResource(man.AAC9[8]);
                V_txtTop1.setText(man.txt_AAC9[0]);
                V_txtTop2.setText(man.txt_AAC9[1]);
                V_txtTop3.setText(man.txt_AAC9[2]);
                V_txtOuter1.setText(man.txt_AAC9[3]);
                V_txtOuter2.setText(man.txt_AAC9[4]);
                V_txtOuter3.setText(man.txt_AAC9[5]);
                V_txtBottom1.setText(man.txt_AAC9[6]);
                V_txtBottom2.setText(man.txt_AAC9[7]);
                V_txtBottom3.setText(man.txt_AAC9[8]);
            }else if(result.equals("AAD")){
                // 더위많이탐 댄디
                V_ITopclothes1.setImageResource(man.AAD9[0]);
                V_ITopclothes2.setImageResource(man.AAD9[1]);
                V_ITopclothes3.setImageResource(man.AAD9[2]);
                V_IOuterclothes1.setImageResource(man.AAD9[3]);
                V_IOuterclothes2.setImageResource(man.AAD9[4]);
                V_IOuterclothes3.setImageResource(man.AAD9[5]);
                V_IBottomclothes1.setImageResource(man.AAD9[6]);
                V_IBottomclothes2.setImageResource(man.AAD9[7]);
                V_IBottomclothes3.setImageResource(man.AAD9[8]);
                V_txtTop1.setText(man.txt_AAD9[0]);
                V_txtTop2.setText(man.txt_AAD9[1]);
                V_txtTop3.setText(man.txt_AAD9[2]);
                V_txtOuter1.setText(man.txt_AAD9[3]);
                V_txtOuter2.setText(man.txt_AAD9[4]);
                V_txtOuter3.setText(man.txt_AAD9[5]);
                V_txtBottom1.setText(man.txt_AAD9[6]);
                V_txtBottom2.setText(man.txt_AAD9[7]);
                V_txtBottom3.setText(man.txt_AAD9[8]);

            }else if(result.equals("AAE")){
                // 더위많이탐 스포티
                V_ITopclothes1.setImageResource(man.AAE9[0]);
                V_ITopclothes2.setImageResource(man.AAE9[1]);
                V_ITopclothes3.setImageResource(man.AAE9[2]);
                V_IOuterclothes1.setImageResource(man.AAE9[3]);
                V_IOuterclothes2.setImageResource(man.AAE9[4]);
                V_IOuterclothes3.setImageResource(man.AAE9[5]);
                V_IBottomclothes1.setImageResource(man.AAE9[6]);
                V_IBottomclothes2.setImageResource(man.AAE9[7]);
                V_IBottomclothes3.setImageResource(man.AAE9[8]);
                V_txtTop1.setText(man.txt_AAE9[0]);
                V_txtTop2.setText(man.txt_AAE9[1]);
                V_txtTop3.setText(man.txt_AAE9[2]);
                V_txtOuter1.setText(man.txt_AAE9[3]);
                V_txtOuter2.setText(man.txt_AAE9[4]);
                V_txtOuter3.setText(man.txt_AAE9[5]);
                V_txtBottom1.setText(man.txt_AAE9[6]);
                V_txtBottom2.setText(man.txt_AAE9[7]);
                V_txtBottom3.setText(man.txt_AAE9[8]);

            }else if(result.equals("ABA")){
                // 더위적게탐 캐주얼
                V_ITopclothes1.setImageResource(man.ABA9[0]);
                V_ITopclothes2.setImageResource(man.ABA9[1]);
                V_ITopclothes3.setImageResource(man.ABA9[2]);
                V_IOuterclothes1.setImageResource(man.ABA9[3]);
                V_IOuterclothes2.setImageResource(man.ABA9[4]);
                V_IOuterclothes3.setImageResource(man.ABA9[5]);
                V_IBottomclothes1.setImageResource(man.ABA9[6]);
                V_IBottomclothes2.setImageResource(man.ABA9[7]);
                V_IBottomclothes3.setImageResource(man.ABA9[8]);
                V_txtTop1.setText(man.txt_ABA9[0]);
                V_txtTop2.setText(man.txt_ABA9[1]);
                V_txtTop3.setText(man.txt_ABA9[2]);
                V_txtOuter1.setText(man.txt_ABA9[3]);
                V_txtOuter2.setText(man.txt_ABA9[4]);
                V_txtOuter3.setText(man.txt_ABA9[5]);
                V_txtBottom1.setText(man.txt_ABA9[6]);
                V_txtBottom2.setText(man.txt_ABA9[7]);
                V_txtBottom3.setText(man.txt_ABA9[8]);

            }else if(result.equals("ABB")){
                // 더위적게탐 빈티지
                V_ITopclothes1.setImageResource(man.ABB9[0]);
                V_ITopclothes2.setImageResource(man.ABB9[1]);
                V_ITopclothes3.setImageResource(man.ABB9[2]);
                V_IOuterclothes1.setImageResource(man.ABB9[3]);
                V_IOuterclothes2.setImageResource(man.ABB9[4]);
                V_IOuterclothes3.setImageResource(man.ABB9[5]);
                V_IBottomclothes1.setImageResource(man.ABB9[6]);
                V_IBottomclothes2.setImageResource(man.ABB9[7]);
                V_IBottomclothes3.setImageResource(man.ABB9[8]);
                V_txtTop1.setText(man.txt_ABB9[0]);
                V_txtTop2.setText(man.txt_ABB9[1]);
                V_txtTop3.setText(man.txt_ABB9[2]);
                V_txtOuter1.setText(man.txt_ABB9[3]);
                V_txtOuter2.setText(man.txt_ABB9[4]);
                V_txtOuter3.setText(man.txt_ABB9[5]);
                V_txtBottom1.setText(man.txt_ABB9[6]);
                V_txtBottom2.setText(man.txt_ABB9[7]);
                V_txtBottom3.setText(man.txt_ABB9[8]);
            }else if(result.equals("ABC")){
                // 더위적게탐 스트릿
                V_ITopclothes1.setImageResource(man.ABC9[0]);
                V_ITopclothes2.setImageResource(man.ABC9[1]);
                V_ITopclothes3.setImageResource(man.ABC9[2]);
                V_IOuterclothes1.setImageResource(man.ABC9[3]);
                V_IOuterclothes2.setImageResource(man.ABC9[4]);
                V_IOuterclothes3.setImageResource(man.ABC9[5]);
                V_IBottomclothes1.setImageResource(man.ABC9[6]);
                V_IBottomclothes2.setImageResource(man.ABC9[7]);
                V_IBottomclothes3.setImageResource(man.ABC9[8]);
                V_txtTop1.setText(man.txt_ABC9[0]);
                V_txtTop2.setText(man.txt_ABC9[1]);
                V_txtTop3.setText(man.txt_ABC9[2]);
                V_txtOuter1.setText(man.txt_ABC9[3]);
                V_txtOuter2.setText(man.txt_ABC9[4]);
                V_txtOuter3.setText(man.txt_ABC9[5]);
                V_txtBottom1.setText(man.txt_ABC9[6]);
                V_txtBottom2.setText(man.txt_ABC9[7]);
                V_txtBottom3.setText(man.txt_ABC9[8]);
            }else if(result.equals("ABD")){
                // 더위적게탐 댄디
                V_ITopclothes1.setImageResource(man.ABD9[0]);
                V_ITopclothes2.setImageResource(man.ABD9[1]);
                V_ITopclothes3.setImageResource(man.ABD9[2]);
                V_IOuterclothes1.setImageResource(man.ABD9[3]);
                V_IOuterclothes2.setImageResource(man.ABD9[4]);
                V_IOuterclothes3.setImageResource(man.ABD9[5]);
                V_IBottomclothes1.setImageResource(man.ABD9[6]);
                V_IBottomclothes2.setImageResource(man.ABD9[7]);
                V_IBottomclothes3.setImageResource(man.ABD9[8]);
                V_txtTop1.setText(man.txt_ABD9[0]);
                V_txtTop2.setText(man.txt_ABD9[1]);
                V_txtTop3.setText(man.txt_ABD9[2]);
                V_txtOuter1.setText(man.txt_ABD9[3]);
                V_txtOuter2.setText(man.txt_ABD9[4]);
                V_txtOuter3.setText(man.txt_ABD9[5]);
                V_txtBottom1.setText(man.txt_ABD9[6]);
                V_txtBottom2.setText(man.txt_ABD9[7]);
                V_txtBottom3.setText(man.txt_ABD9[8]);

            }else{
                // ABE 더위적게탐 스포티
                V_ITopclothes1.setImageResource(man.ABE9[0]);
                V_ITopclothes2.setImageResource(man.ABE9[1]);
                V_ITopclothes3.setImageResource(man.ABE9[2]);
                V_IOuterclothes1.setImageResource(man.ABE9[3]);
                V_IOuterclothes2.setImageResource(man.ABE9[4]);
                V_IOuterclothes3.setImageResource(man.ABE9[5]);
                V_IBottomclothes1.setImageResource(man.ABE9[6]);
                V_IBottomclothes2.setImageResource(man.ABE9[7]);
                V_IBottomclothes3.setImageResource(man.ABE9[8]);
                V_txtTop1.setText(man.txt_ABE9[0]);
                V_txtTop2.setText(man.txt_ABE9[1]);
                V_txtTop3.setText(man.txt_ABE9[2]);
                V_txtOuter1.setText(man.txt_ABE9[3]);
                V_txtOuter2.setText(man.txt_ABE9[4]);
                V_txtOuter3.setText(man.txt_ABE9[5]);
                V_txtBottom1.setText(man.txt_ABE9[6]);
                V_txtBottom2.setText(man.txt_ABE9[7]);
                V_txtBottom3.setText(man.txt_ABE9[8]);
            }

        }else if(max_temp == 12){
            if(result.equals("AAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes1.setImageResource(man.AAA4[0]);
                V_ITopclothes2.setImageResource(man.AAA4[1]);
                V_ITopclothes3.setImageResource(man.AAA4[2]);
                V_IOuterclothes1.setImageResource(man.AAA4[3]);
                V_IOuterclothes2.setImageResource(man.AAA4[4]);
                V_IOuterclothes3.setImageResource(man.AAA4[5]);
                V_IBottomclothes1.setImageResource(man.AAA4[6]);
                V_IBottomclothes2.setImageResource(man.AAA4[7]);
                V_IBottomclothes3.setImageResource(man.AAA4[8]);
                V_txtTop1.setText(man.txt_AAA4[0]);
                V_txtTop2.setText(man.txt_AAA4[1]);
                V_txtTop3.setText(man.txt_AAA4[2]);
                V_txtOuter1.setText(man.txt_AAA4[3]);
                V_txtOuter2.setText(man.txt_AAA4[4]);
                V_txtOuter3.setText(man.txt_AAA4[5]);
                V_txtBottom1.setText(man.txt_AAA4[6]);
                V_txtBottom2.setText(man.txt_AAA4[7]);
                V_txtBottom3.setText(man.txt_AAA4[8]);

            }else if(result.equals("AAB")){
                // 더위많이탐 빈티지
                V_ITopclothes1.setImageResource(man.AAB12[0]);
                V_ITopclothes2.setImageResource(man.AAB12[1]);
                V_ITopclothes3.setImageResource(man.AAB12[2]);
                V_IOuterclothes1.setImageResource(man.AAB12[3]);
                V_IOuterclothes2.setImageResource(man.AAB12[4]);
                V_IOuterclothes3.setImageResource(man.AAB12[5]);
                V_IBottomclothes1.setImageResource(man.AAB12[6]);
                V_IBottomclothes2.setImageResource(man.AAB12[7]);
                V_IBottomclothes3.setImageResource(man.AAB12[8]);
                V_txtTop1.setText(man.txt_AAB12[0]);
                V_txtTop2.setText(man.txt_AAB12[1]);
                V_txtTop3.setText(man.txt_AAB12[2]);
                V_txtOuter1.setText(man.txt_AAB12[3]);
                V_txtOuter2.setText(man.txt_AAB12[4]);
                V_txtOuter3.setText(man.txt_AAB12[5]);
                V_txtBottom1.setText(man.txt_AAB12[6]);
                V_txtBottom2.setText(man.txt_AAB12[7]);
                V_txtBottom3.setText(man.txt_AAB12[8]);
            }else if(result.equals("AAC")){
                // 더위많이탐 스트릿
                V_ITopclothes1.setImageResource(man.AAC12[0]);
                V_ITopclothes2.setImageResource(man.AAC12[1]);
                V_ITopclothes3.setImageResource(man.AAC12[2]);
                V_IOuterclothes1.setImageResource(man.AAC12[3]);
                V_IOuterclothes2.setImageResource(man.AAC12[4]);
                V_IOuterclothes3.setImageResource(man.AAC12[5]);
                V_IBottomclothes1.setImageResource(man.AAC12[6]);
                V_IBottomclothes2.setImageResource(man.AAC12[7]);
                V_IBottomclothes3.setImageResource(man.AAC12[8]);
                V_txtTop1.setText(man.txt_AAC12[0]);
                V_txtTop2.setText(man.txt_AAC12[1]);
                V_txtTop3.setText(man.txt_AAC12[2]);
                V_txtOuter1.setText(man.txt_AAC12[3]);
                V_txtOuter2.setText(man.txt_AAC12[4]);
                V_txtOuter3.setText(man.txt_AAC12[5]);
                V_txtBottom1.setText(man.txt_AAC12[6]);
                V_txtBottom2.setText(man.txt_AAC12[7]);
                V_txtBottom3.setText(man.txt_AAC12[8]);
            }else if(result.equals("AAD")){
                // 더위많이탐 댄디
                V_ITopclothes1.setImageResource(man.AAD12[0]);
                V_ITopclothes2.setImageResource(man.AAD12[1]);
                V_ITopclothes3.setImageResource(man.AAD12[2]);
                V_IOuterclothes1.setImageResource(man.AAD12[3]);
                V_IOuterclothes2.setImageResource(man.AAD12[4]);
                V_IOuterclothes3.setImageResource(man.AAD12[5]);
                V_IBottomclothes1.setImageResource(man.AAD12[6]);
                V_IBottomclothes2.setImageResource(man.AAD12[7]);
                V_IBottomclothes3.setImageResource(man.AAD12[8]);
                V_txtTop1.setText(man.txt_AAD12[0]);
                V_txtTop2.setText(man.txt_AAD12[1]);
                V_txtTop3.setText(man.txt_AAD12[2]);
                V_txtOuter1.setText(man.txt_AAD12[3]);
                V_txtOuter2.setText(man.txt_AAD12[4]);
                V_txtOuter3.setText(man.txt_AAD12[5]);
                V_txtBottom1.setText(man.txt_AAD12[6]);
                V_txtBottom2.setText(man.txt_AAD12[7]);
                V_txtBottom3.setText(man.txt_AAD12[8]);

            }else if(result.equals("AAE")){
                // 더위많이탐 스포티
                V_ITopclothes1.setImageResource(man.AAE12[0]);
                V_ITopclothes2.setImageResource(man.AAE12[1]);
                V_ITopclothes3.setImageResource(man.AAE12[2]);
                V_IOuterclothes1.setImageResource(man.AAE12[3]);
                V_IOuterclothes2.setImageResource(man.AAE12[4]);
                V_IOuterclothes3.setImageResource(man.AAE12[5]);
                V_IBottomclothes1.setImageResource(man.AAE12[6]);
                V_IBottomclothes2.setImageResource(man.AAE12[7]);
                V_IBottomclothes3.setImageResource(man.AAE12[8]);
                V_txtTop1.setText(man.txt_AAE12[0]);
                V_txtTop2.setText(man.txt_AAE12[1]);
                V_txtTop3.setText(man.txt_AAE12[2]);
                V_txtOuter1.setText(man.txt_AAE12[3]);
                V_txtOuter2.setText(man.txt_AAE12[4]);
                V_txtOuter3.setText(man.txt_AAE12[5]);
                V_txtBottom1.setText(man.txt_AAE12[6]);
                V_txtBottom2.setText(man.txt_AAE12[7]);
                V_txtBottom3.setText(man.txt_AAE12[8]);

            }else if(result.equals("ABA")){
                // 더위적게탐 캐주얼
                V_ITopclothes1.setImageResource(man.ABA12[0]);
                V_ITopclothes2.setImageResource(man.ABA12[1]);
                V_ITopclothes3.setImageResource(man.ABA12[2]);
                V_IOuterclothes1.setImageResource(man.ABA12[3]);
                V_IOuterclothes2.setImageResource(man.ABA12[4]);
                V_IOuterclothes3.setImageResource(man.ABA12[5]);
                V_IBottomclothes1.setImageResource(man.ABA12[6]);
                V_IBottomclothes2.setImageResource(man.ABA12[7]);
                V_IBottomclothes3.setImageResource(man.ABA12[8]);
                V_txtTop1.setText(man.txt_ABA12[0]);
                V_txtTop2.setText(man.txt_ABA12[1]);
                V_txtTop3.setText(man.txt_ABA12[2]);
                V_txtOuter1.setText(man.txt_ABA12[3]);
                V_txtOuter2.setText(man.txt_ABA12[4]);
                V_txtOuter3.setText(man.txt_ABA12[5]);
                V_txtBottom1.setText(man.txt_ABA12[6]);
                V_txtBottom2.setText(man.txt_ABA12[7]);
                V_txtBottom3.setText(man.txt_ABA12[8]);

            }else if(result.equals("ABB")){
                // 더위적게탐 빈티지
                V_ITopclothes1.setImageResource(man.ABB12[0]);
                V_ITopclothes2.setImageResource(man.ABB12[1]);
                V_ITopclothes3.setImageResource(man.ABB12[2]);
                V_IOuterclothes1.setImageResource(man.ABB12[3]);
                V_IOuterclothes2.setImageResource(man.ABB12[4]);
                V_IOuterclothes3.setImageResource(man.ABB12[5]);
                V_IBottomclothes1.setImageResource(man.ABB12[6]);
                V_IBottomclothes2.setImageResource(man.ABB12[7]);
                V_IBottomclothes3.setImageResource(man.ABB12[8]);
                V_txtTop1.setText(man.txt_ABB12[0]);
                V_txtTop2.setText(man.txt_ABB12[1]);
                V_txtTop3.setText(man.txt_ABB12[2]);
                V_txtOuter1.setText(man.txt_ABB12[3]);
                V_txtOuter2.setText(man.txt_ABB12[4]);
                V_txtOuter3.setText(man.txt_ABB12[5]);
                V_txtBottom1.setText(man.txt_ABB12[6]);
                V_txtBottom2.setText(man.txt_ABB12[7]);
                V_txtBottom3.setText(man.txt_ABB12[8]);
            }else if(result.equals("ABC")){
                // 더위적게탐 스트릿
                V_ITopclothes1.setImageResource(man.ABC12[0]);
                V_ITopclothes2.setImageResource(man.ABC12[1]);
                V_ITopclothes3.setImageResource(man.ABC12[2]);
                V_IOuterclothes1.setImageResource(man.ABC12[3]);
                V_IOuterclothes2.setImageResource(man.ABC12[4]);
                V_IOuterclothes3.setImageResource(man.ABC12[5]);
                V_IBottomclothes1.setImageResource(man.ABC12[6]);
                V_IBottomclothes2.setImageResource(man.ABC12[7]);
                V_IBottomclothes3.setImageResource(man.ABC12[8]);
                V_txtTop1.setText(man.txt_ABC12[0]);
                V_txtTop2.setText(man.txt_ABC12[1]);
                V_txtTop3.setText(man.txt_ABC12[2]);
                V_txtOuter1.setText(man.txt_ABC12[3]);
                V_txtOuter2.setText(man.txt_ABC12[4]);
                V_txtOuter3.setText(man.txt_ABC12[5]);
                V_txtBottom1.setText(man.txt_ABC12[6]);
                V_txtBottom2.setText(man.txt_ABC12[7]);
                V_txtBottom3.setText(man.txt_ABC12[8]);
            }else if(result.equals("ABD")){
                // 더위적게탐 댄디
                V_ITopclothes1.setImageResource(man.ABD12[0]);
                V_ITopclothes2.setImageResource(man.ABD12[1]);
                V_ITopclothes3.setImageResource(man.ABD12[2]);
                V_IOuterclothes1.setImageResource(man.ABD12[3]);
                V_IOuterclothes2.setImageResource(man.ABD12[4]);
                V_IOuterclothes3.setImageResource(man.ABD12[5]);
                V_IBottomclothes1.setImageResource(man.ABD12[6]);
                V_IBottomclothes2.setImageResource(man.ABD12[7]);
                V_IBottomclothes3.setImageResource(man.ABD12[8]);
                V_txtTop1.setText(man.txt_ABD12[0]);
                V_txtTop2.setText(man.txt_ABD12[1]);
                V_txtTop3.setText(man.txt_ABD12[2]);
                V_txtOuter1.setText(man.txt_ABD12[3]);
                V_txtOuter2.setText(man.txt_ABD12[4]);
                V_txtOuter3.setText(man.txt_ABD12[5]);
                V_txtBottom1.setText(man.txt_ABD12[6]);
                V_txtBottom2.setText(man.txt_ABD12[7]);
                V_txtBottom3.setText(man.txt_ABD12[8]);

            }else{
                // ABE 더위적게탐 스포티
                V_ITopclothes1.setImageResource(man.ABE12[0]);
                V_ITopclothes2.setImageResource(man.ABE12[1]);
                V_ITopclothes3.setImageResource(man.ABE12[2]);
                V_IOuterclothes1.setImageResource(man.ABE12[3]);
                V_IOuterclothes2.setImageResource(man.ABE12[4]);
                V_IOuterclothes3.setImageResource(man.ABE12[5]);
                V_IBottomclothes1.setImageResource(man.ABE12[6]);
                V_IBottomclothes2.setImageResource(man.ABE12[7]);
                V_IBottomclothes3.setImageResource(man.ABE12[8]);
                V_txtTop1.setText(man.txt_ABE12[0]);
                V_txtTop2.setText(man.txt_ABE12[1]);
                V_txtTop3.setText(man.txt_ABE12[2]);
                V_txtOuter1.setText(man.txt_ABE12[3]);
                V_txtOuter2.setText(man.txt_ABE12[4]);
                V_txtOuter3.setText(man.txt_ABE12[5]);
                V_txtBottom1.setText(man.txt_ABE12[6]);
                V_txtBottom2.setText(man.txt_ABE12[7]);
                V_txtBottom3.setText(man.txt_ABE12[8]);
            }

        }else if(max_temp == 17){
            if(result.equals("AAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes1.setImageResource(man.AAA17[0]);
                V_ITopclothes2.setImageResource(man.AAA17[1]);
                V_ITopclothes3.setImageResource(man.AAA17[2]);
                V_IOuterclothes1.setImageResource(man.AAA17[3]);
                V_IOuterclothes2.setImageResource(man.AAA17[4]);
                V_IOuterclothes3.setImageResource(man.AAA17[5]);
                V_IBottomclothes1.setImageResource(man.AAA17[6]);
                V_IBottomclothes2.setImageResource(man.AAA17[7]);
                V_IBottomclothes3.setImageResource(man.AAA17[8]);
                V_txtTop1.setText(man.txt_AAA17[0]);
                V_txtTop2.setText(man.txt_AAA17[1]);
                V_txtTop3.setText(man.txt_AAA17[2]);
                V_txtOuter1.setText(man.txt_AAA17[3]);
                V_txtOuter2.setText(man.txt_AAA17[4]);
                V_txtOuter3.setText(man.txt_AAA17[5]);
                V_txtBottom1.setText(man.txt_AAA17[6]);
                V_txtBottom2.setText(man.txt_AAA17[7]);
                V_txtBottom3.setText(man.txt_AAA17[8]);

            }else if(result.equals("AAB")){
                // 더위많이탐 빈티지
                V_ITopclothes1.setImageResource(man.AAB17[0]);
                V_ITopclothes2.setImageResource(man.AAB17[1]);
                V_ITopclothes3.setImageResource(man.AAB17[2]);
                V_IOuterclothes1.setImageResource(man.AAB17[3]);
                V_IOuterclothes2.setImageResource(man.AAB17[4]);
                V_IOuterclothes3.setImageResource(man.AAB17[5]);
                V_IBottomclothes1.setImageResource(man.AAB17[6]);
                V_IBottomclothes2.setImageResource(man.AAB17[7]);
                V_IBottomclothes3.setImageResource(man.AAB17[8]);
                V_txtTop1.setText(man.txt_AAB17[0]);
                V_txtTop2.setText(man.txt_AAB17[1]);
                V_txtTop3.setText(man.txt_AAB17[2]);
                V_txtOuter1.setText(man.txt_AAB17[3]);
                V_txtOuter2.setText(man.txt_AAB17[4]);
                V_txtOuter3.setText(man.txt_AAB17[5]);
                V_txtBottom1.setText(man.txt_AAB17[6]);
                V_txtBottom2.setText(man.txt_AAB17[7]);
                V_txtBottom3.setText(man.txt_AAB17[8]);
            }else if(result.equals("AAC")){
                // 더위많이탐 스트릿
                V_ITopclothes1.setImageResource(man.AAC17[0]);
                V_ITopclothes2.setImageResource(man.AAC17[1]);
                V_ITopclothes3.setImageResource(man.AAC17[2]);
                V_IOuterclothes1.setImageResource(man.AAC17[3]);
                V_IOuterclothes2.setImageResource(man.AAC17[4]);
                V_IOuterclothes3.setImageResource(man.AAC17[5]);
                V_IBottomclothes1.setImageResource(man.AAC17[6]);
                V_IBottomclothes2.setImageResource(man.AAC17[7]);
                V_IBottomclothes3.setImageResource(man.AAC17[8]);
                V_txtTop1.setText(man.txt_AAC17[0]);
                V_txtTop2.setText(man.txt_AAC17[1]);
                V_txtTop3.setText(man.txt_AAC17[2]);
                V_txtOuter1.setText(man.txt_AAC17[3]);
                V_txtOuter2.setText(man.txt_AAC17[4]);
                V_txtOuter3.setText(man.txt_AAC17[5]);
                V_txtBottom1.setText(man.txt_AAC17[6]);
                V_txtBottom2.setText(man.txt_AAC17[7]);
                V_txtBottom3.setText(man.txt_AAC17[8]);
            }else if(result.equals("AAD")){
                // 더위많이탐 댄디
                V_ITopclothes1.setImageResource(man.AAD17[0]);
                V_ITopclothes2.setImageResource(man.AAD17[1]);
                V_ITopclothes3.setImageResource(man.AAD17[2]);
                V_IOuterclothes1.setImageResource(man.AAD17[3]);
                V_IOuterclothes2.setImageResource(man.AAD17[4]);
                V_IOuterclothes3.setImageResource(man.AAD17[5]);
                V_IBottomclothes1.setImageResource(man.AAD17[6]);
                V_IBottomclothes2.setImageResource(man.AAD17[7]);
                V_IBottomclothes3.setImageResource(man.AAD17[8]);
                V_txtTop1.setText(man.txt_AAD17[0]);
                V_txtTop2.setText(man.txt_AAD17[1]);
                V_txtTop3.setText(man.txt_AAD17[2]);
                V_txtOuter1.setText(man.txt_AAD17[3]);
                V_txtOuter2.setText(man.txt_AAD17[4]);
                V_txtOuter3.setText(man.txt_AAD17[5]);
                V_txtBottom1.setText(man.txt_AAD17[6]);
                V_txtBottom2.setText(man.txt_AAD17[7]);
                V_txtBottom3.setText(man.txt_AAD17[8]);

            }else if(result.equals("AAE")){
                // 더위많이탐 스포티
                V_ITopclothes1.setImageResource(man.AAE17[0]);
                V_ITopclothes2.setImageResource(man.AAE17[1]);
                V_ITopclothes3.setImageResource(man.AAE17[2]);
                V_IOuterclothes1.setImageResource(man.AAE17[3]);
                V_IOuterclothes2.setImageResource(man.AAE17[4]);
                V_IOuterclothes3.setImageResource(man.AAE17[5]);
                V_IBottomclothes1.setImageResource(man.AAE17[6]);
                V_IBottomclothes2.setImageResource(man.AAE17[7]);
                V_IBottomclothes3.setImageResource(man.AAE17[8]);
                V_txtTop1.setText(man.txt_AAE17[0]);
                V_txtTop2.setText(man.txt_AAE17[1]);
                V_txtTop3.setText(man.txt_AAE17[2]);
                V_txtOuter1.setText(man.txt_AAE17[3]);
                V_txtOuter2.setText(man.txt_AAE17[4]);
                V_txtOuter3.setText(man.txt_AAE17[5]);
                V_txtBottom1.setText(man.txt_AAE17[6]);
                V_txtBottom2.setText(man.txt_AAE17[7]);
                V_txtBottom3.setText(man.txt_AAE17[8]);

            }else if(result.equals("ABA")){
                // 더위적게탐 캐주얼
                V_ITopclothes1.setImageResource(man.ABA17[0]);
                V_ITopclothes2.setImageResource(man.ABA17[1]);
                V_ITopclothes3.setImageResource(man.ABA17[2]);
                V_IOuterclothes1.setImageResource(man.ABA17[3]);
                V_IOuterclothes2.setImageResource(man.ABA17[4]);
                V_IOuterclothes3.setImageResource(man.ABA17[5]);
                V_IBottomclothes1.setImageResource(man.ABA17[6]);
                V_IBottomclothes2.setImageResource(man.ABA17[7]);
                V_IBottomclothes3.setImageResource(man.ABA17[8]);
                V_txtTop1.setText(man.txt_ABA17[0]);
                V_txtTop2.setText(man.txt_ABA17[1]);
                V_txtTop3.setText(man.txt_ABA17[2]);
                V_txtOuter1.setText(man.txt_ABA17[3]);
                V_txtOuter2.setText(man.txt_ABA17[4]);
                V_txtOuter3.setText(man.txt_ABA17[5]);
                V_txtBottom1.setText(man.txt_ABA17[6]);
                V_txtBottom2.setText(man.txt_ABA17[7]);
                V_txtBottom3.setText(man.txt_ABA17[8]);

            }else if(result.equals("ABB")){
                // 더위적게탐 빈티지
                V_ITopclothes1.setImageResource(man.ABB17[0]);
                V_ITopclothes2.setImageResource(man.ABB17[1]);
                V_ITopclothes3.setImageResource(man.ABB17[2]);
                V_IOuterclothes1.setImageResource(man.ABB17[3]);
                V_IOuterclothes2.setImageResource(man.ABB17[4]);
                V_IOuterclothes3.setImageResource(man.ABB17[5]);
                V_IBottomclothes1.setImageResource(man.ABB17[6]);
                V_IBottomclothes2.setImageResource(man.ABB17[7]);
                V_IBottomclothes3.setImageResource(man.ABB17[8]);
                V_txtTop1.setText(man.txt_ABB17[0]);
                V_txtTop2.setText(man.txt_ABB17[1]);
                V_txtTop3.setText(man.txt_ABB17[2]);
                V_txtOuter1.setText(man.txt_ABB17[3]);
                V_txtOuter2.setText(man.txt_ABB17[4]);
                V_txtOuter3.setText(man.txt_ABB17[5]);
                V_txtBottom1.setText(man.txt_ABB17[6]);
                V_txtBottom2.setText(man.txt_ABB17[7]);
                V_txtBottom3.setText(man.txt_ABB17[8]);
            }else if(result.equals("ABC")){
                // 더위적게탐 스트릿
                V_ITopclothes1.setImageResource(man.ABC17[0]);
                V_ITopclothes2.setImageResource(man.ABC17[1]);
                V_ITopclothes3.setImageResource(man.ABC17[2]);
                V_IOuterclothes1.setImageResource(man.ABC17[3]);
                V_IOuterclothes2.setImageResource(man.ABC17[4]);
                V_IOuterclothes3.setImageResource(man.ABC17[5]);
                V_IBottomclothes1.setImageResource(man.ABC17[6]);
                V_IBottomclothes2.setImageResource(man.ABC17[7]);
                V_IBottomclothes3.setImageResource(man.ABC17[8]);
                V_txtTop1.setText(man.txt_ABC17[0]);
                V_txtTop2.setText(man.txt_ABC17[1]);
                V_txtTop3.setText(man.txt_ABC17[2]);
                V_txtOuter1.setText(man.txt_ABC17[3]);
                V_txtOuter2.setText(man.txt_ABC17[4]);
                V_txtOuter3.setText(man.txt_ABC17[5]);
                V_txtBottom1.setText(man.txt_ABC17[6]);
                V_txtBottom2.setText(man.txt_ABC17[7]);
                V_txtBottom3.setText(man.txt_ABC17[8]);
            }else if(result.equals("ABD")){
                // 더위적게탐 댄디
                V_ITopclothes1.setImageResource(man.ABD17[0]);
                V_ITopclothes2.setImageResource(man.ABD17[1]);
                V_ITopclothes3.setImageResource(man.ABD17[2]);
                V_IOuterclothes1.setImageResource(man.ABD17[3]);
                V_IOuterclothes2.setImageResource(man.ABD17[4]);
                V_IOuterclothes3.setImageResource(man.ABD17[5]);
                V_IBottomclothes1.setImageResource(man.ABD17[6]);
                V_IBottomclothes2.setImageResource(man.ABD17[7]);
                V_IBottomclothes3.setImageResource(man.ABD17[8]);
                V_txtTop1.setText(man.txt_ABD17[0]);
                V_txtTop2.setText(man.txt_ABD17[1]);
                V_txtTop3.setText(man.txt_ABD17[2]);
                V_txtOuter1.setText(man.txt_ABD17[3]);
                V_txtOuter2.setText(man.txt_ABD17[4]);
                V_txtOuter3.setText(man.txt_ABD17[5]);
                V_txtBottom1.setText(man.txt_ABD17[6]);
                V_txtBottom2.setText(man.txt_ABD17[7]);
                V_txtBottom3.setText(man.txt_ABD17[8]);

            }else{
                // ABE 더위적게탐 스포티
                V_ITopclothes1.setImageResource(man.ABE17[0]);
                V_ITopclothes2.setImageResource(man.ABE17[1]);
                V_ITopclothes3.setImageResource(man.ABE17[2]);
                V_IOuterclothes1.setImageResource(man.ABE17[3]);
                V_IOuterclothes2.setImageResource(man.ABE17[4]);
                V_IOuterclothes3.setImageResource(man.ABE17[5]);
                V_IBottomclothes1.setImageResource(man.ABE17[6]);
                V_IBottomclothes2.setImageResource(man.ABE17[7]);
                V_IBottomclothes3.setImageResource(man.ABE17[8]);
                V_txtTop1.setText(man.txt_ABE17[0]);
                V_txtTop2.setText(man.txt_ABE17[1]);
                V_txtTop3.setText(man.txt_ABE17[2]);
                V_txtOuter1.setText(man.txt_ABE17[3]);
                V_txtOuter2.setText(man.txt_ABE17[4]);
                V_txtOuter3.setText(man.txt_ABE17[5]);
                V_txtBottom1.setText(man.txt_ABE17[6]);
                V_txtBottom2.setText(man.txt_ABE17[7]);
                V_txtBottom3.setText(man.txt_ABE17[8]);
            }

        }else if(max_temp == 20){
            if(result.equals("AAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes1.setImageResource(man.AAA20[0]);
                V_ITopclothes2.setImageResource(man.AAA20[1]);
                V_ITopclothes3.setImageResource(man.AAA20[2]);
                V_IOuterclothes1.setImageResource(man.AAA20[3]);
                V_IOuterclothes2.setImageResource(man.AAA20[4]);
                V_IOuterclothes3.setImageResource(man.AAA20[5]);
                V_IBottomclothes1.setImageResource(man.AAA20[6]);
                V_IBottomclothes2.setImageResource(man.AAA20[7]);
                V_IBottomclothes3.setImageResource(man.AAA20[8]);
                V_txtTop1.setText(man.txt_AAA20[0]);
                V_txtTop2.setText(man.txt_AAA20[1]);
                V_txtTop3.setText(man.txt_AAA20[2]);
                V_txtOuter1.setText(man.txt_AAA20[3]);
                V_txtOuter2.setText(man.txt_AAA20[4]);
                V_txtOuter3.setText(man.txt_AAA20[5]);
                V_txtBottom1.setText(man.txt_AAA20[6]);
                V_txtBottom2.setText(man.txt_AAA20[7]);
                V_txtBottom3.setText(man.txt_AAA20[8]);

            }else if(result.equals("AAB")){
                // 더위많이탐 빈티지
                V_ITopclothes1.setImageResource(man.AAB20[0]);
                V_ITopclothes2.setImageResource(man.AAB20[1]);
                V_ITopclothes3.setImageResource(man.AAB20[2]);
                V_IOuterclothes1.setImageResource(man.AAB20[3]);
                V_IOuterclothes2.setImageResource(man.AAB20[4]);
                V_IOuterclothes3.setImageResource(man.AAB20[5]);
                V_IBottomclothes1.setImageResource(man.AAB20[6]);
                V_IBottomclothes2.setImageResource(man.AAB20[7]);
                V_IBottomclothes3.setImageResource(man.AAB20[8]);
                V_txtTop1.setText(man.txt_AAB20[0]);
                V_txtTop2.setText(man.txt_AAB20[1]);
                V_txtTop3.setText(man.txt_AAB20[2]);
                V_txtOuter1.setText(man.txt_AAB20[3]);
                V_txtOuter2.setText(man.txt_AAB20[4]);
                V_txtOuter3.setText(man.txt_AAB20[5]);
                V_txtBottom1.setText(man.txt_AAB20[6]);
                V_txtBottom2.setText(man.txt_AAB20[7]);
                V_txtBottom3.setText(man.txt_AAB20[8]);
            }else if(result.equals("AAC")){
                // 더위많이탐 스트릿
                V_ITopclothes1.setImageResource(man.AAC20[0]);
                V_ITopclothes2.setImageResource(man.AAC20[1]);
                V_ITopclothes3.setImageResource(man.AAC20[2]);
                V_IOuterclothes1.setImageResource(man.AAC20[3]);
                V_IOuterclothes2.setImageResource(man.AAC20[4]);
                V_IOuterclothes3.setImageResource(man.AAC20[5]);
                V_IBottomclothes1.setImageResource(man.AAC20[6]);
                V_IBottomclothes2.setImageResource(man.AAC20[7]);
                V_IBottomclothes3.setImageResource(man.AAC20[8]);
                V_txtTop1.setText(man.txt_AAC20[0]);
                V_txtTop2.setText(man.txt_AAC20[1]);
                V_txtTop3.setText(man.txt_AAC20[2]);
                V_txtOuter1.setText(man.txt_AAC20[3]);
                V_txtOuter2.setText(man.txt_AAC20[4]);
                V_txtOuter3.setText(man.txt_AAC20[5]);
                V_txtBottom1.setText(man.txt_AAC20[6]);
                V_txtBottom2.setText(man.txt_AAC20[7]);
                V_txtBottom3.setText(man.txt_AAC20[8]);
            }else if(result.equals("AAD")){
                // 더위많이탐 댄디
                V_ITopclothes1.setImageResource(man.AAD20[0]);
                V_ITopclothes2.setImageResource(man.AAD20[1]);
                V_ITopclothes3.setImageResource(man.AAD20[2]);
                V_IOuterclothes1.setImageResource(man.AAD20[3]);
                V_IOuterclothes2.setImageResource(man.AAD20[4]);
                V_IOuterclothes3.setImageResource(man.AAD20[5]);
                V_IBottomclothes1.setImageResource(man.AAD20[6]);
                V_IBottomclothes2.setImageResource(man.AAD20[7]);
                V_IBottomclothes3.setImageResource(man.AAD20[8]);
                V_txtTop1.setText(man.txt_AAD20[0]);
                V_txtTop2.setText(man.txt_AAD20[1]);
                V_txtTop3.setText(man.txt_AAD20[2]);
                V_txtOuter1.setText(man.txt_AAD20[3]);
                V_txtOuter2.setText(man.txt_AAD20[4]);
                V_txtOuter3.setText(man.txt_AAD20[5]);
                V_txtBottom1.setText(man.txt_AAD20[6]);
                V_txtBottom2.setText(man.txt_AAD20[7]);
                V_txtBottom3.setText(man.txt_AAD20[8]);

            }else if(result.equals("AAE")){
                // 더위많이탐 스포티
                V_ITopclothes1.setImageResource(man.AAE20[0]);
                V_ITopclothes2.setImageResource(man.AAE20[1]);
                V_ITopclothes3.setImageResource(man.AAE20[2]);
                V_IOuterclothes1.setImageResource(man.AAE20[3]);
                V_IOuterclothes2.setImageResource(man.AAE20[4]);
                V_IOuterclothes3.setImageResource(man.AAE20[5]);
                V_IBottomclothes1.setImageResource(man.AAE20[6]);
                V_IBottomclothes2.setImageResource(man.AAE20[7]);
                V_IBottomclothes3.setImageResource(man.AAE20[8]);
                V_txtTop1.setText(man.txt_AAE20[0]);
                V_txtTop2.setText(man.txt_AAE20[1]);
                V_txtTop3.setText(man.txt_AAE20[2]);
                V_txtOuter1.setText(man.txt_AAE20[3]);
                V_txtOuter2.setText(man.txt_AAE20[4]);
                V_txtOuter3.setText(man.txt_AAE20[5]);
                V_txtBottom1.setText(man.txt_AAE20[6]);
                V_txtBottom2.setText(man.txt_AAE20[7]);
                V_txtBottom3.setText(man.txt_AAE20[8]);

            }else if(result.equals("ABA")){
                // 더위적게탐 캐주얼
                V_ITopclothes1.setImageResource(man.ABA20[0]);
                V_ITopclothes2.setImageResource(man.ABA20[1]);
                V_ITopclothes3.setImageResource(man.ABA20[2]);
                V_IOuterclothes1.setImageResource(man.ABA20[3]);
                V_IOuterclothes2.setImageResource(man.ABA20[4]);
                V_IOuterclothes3.setImageResource(man.ABA20[5]);
                V_IBottomclothes1.setImageResource(man.ABA20[6]);
                V_IBottomclothes2.setImageResource(man.ABA20[7]);
                V_IBottomclothes3.setImageResource(man.ABA20[8]);
                V_txtTop1.setText(man.txt_ABA20[0]);
                V_txtTop2.setText(man.txt_ABA20[1]);
                V_txtTop3.setText(man.txt_ABA20[2]);
                V_txtOuter1.setText(man.txt_ABA20[3]);
                V_txtOuter2.setText(man.txt_ABA20[4]);
                V_txtOuter3.setText(man.txt_ABA20[5]);
                V_txtBottom1.setText(man.txt_ABA20[6]);
                V_txtBottom2.setText(man.txt_ABA20[7]);
                V_txtBottom3.setText(man.txt_ABA20[8]);

            }else if(result.equals("ABB")){
                // 더위적게탐 빈티지
                V_ITopclothes1.setImageResource(man.ABB20[0]);
                V_ITopclothes2.setImageResource(man.ABB20[1]);
                V_ITopclothes3.setImageResource(man.ABB20[2]);
                V_IOuterclothes1.setImageResource(man.ABB20[3]);
                V_IOuterclothes2.setImageResource(man.ABB20[4]);
                V_IOuterclothes3.setImageResource(man.ABB20[5]);
                V_IBottomclothes1.setImageResource(man.ABB20[6]);
                V_IBottomclothes2.setImageResource(man.ABB20[7]);
                V_IBottomclothes3.setImageResource(man.ABB20[8]);
                V_txtTop1.setText(man.txt_ABB20[0]);
                V_txtTop2.setText(man.txt_ABB20[1]);
                V_txtTop3.setText(man.txt_ABB20[2]);
                V_txtOuter1.setText(man.txt_ABB20[3]);
                V_txtOuter2.setText(man.txt_ABB20[4]);
                V_txtOuter3.setText(man.txt_ABB20[5]);
                V_txtBottom1.setText(man.txt_ABB20[6]);
                V_txtBottom2.setText(man.txt_ABB20[7]);
                V_txtBottom3.setText(man.txt_ABB20[8]);
            }else if(result.equals("ABC")){
                // 더위적게탐 스트릿
                V_ITopclothes1.setImageResource(man.ABC20[0]);
                V_ITopclothes2.setImageResource(man.ABC20[1]);
                V_ITopclothes3.setImageResource(man.ABC20[2]);
                V_IOuterclothes1.setImageResource(man.ABC20[3]);
                V_IOuterclothes2.setImageResource(man.ABC20[4]);
                V_IOuterclothes3.setImageResource(man.ABC20[5]);
                V_IBottomclothes1.setImageResource(man.ABC20[6]);
                V_IBottomclothes2.setImageResource(man.ABC20[7]);
                V_IBottomclothes3.setImageResource(man.ABC20[8]);
                V_txtTop1.setText(man.txt_ABC20[0]);
                V_txtTop2.setText(man.txt_ABC20[1]);
                V_txtTop3.setText(man.txt_ABC20[2]);
                V_txtOuter1.setText(man.txt_ABC20[3]);
                V_txtOuter2.setText(man.txt_ABC20[4]);
                V_txtOuter3.setText(man.txt_ABC20[5]);
                V_txtBottom1.setText(man.txt_ABC20[6]);
                V_txtBottom2.setText(man.txt_ABC20[7]);
                V_txtBottom3.setText(man.txt_ABC20[8]);
            }else if(result.equals("ABD")){
                // 더위적게탐 댄디
                V_ITopclothes1.setImageResource(man.ABD20[0]);
                V_ITopclothes2.setImageResource(man.ABD20[1]);
                V_ITopclothes3.setImageResource(man.ABD20[2]);
                V_IOuterclothes1.setImageResource(man.ABD20[3]);
                V_IOuterclothes2.setImageResource(man.ABD20[4]);
                V_IOuterclothes3.setImageResource(man.ABD20[5]);
                V_IBottomclothes1.setImageResource(man.ABD20[6]);
                V_IBottomclothes2.setImageResource(man.ABD20[7]);
                V_IBottomclothes3.setImageResource(man.ABD20[8]);
                V_txtTop1.setText(man.txt_ABD20[0]);
                V_txtTop2.setText(man.txt_ABD20[1]);
                V_txtTop3.setText(man.txt_ABD20[2]);
                V_txtOuter1.setText(man.txt_ABD20[3]);
                V_txtOuter2.setText(man.txt_ABD20[4]);
                V_txtOuter3.setText(man.txt_ABD20[5]);
                V_txtBottom1.setText(man.txt_ABD20[6]);
                V_txtBottom2.setText(man.txt_ABD20[7]);
                V_txtBottom3.setText(man.txt_ABD20[8]);

            }else{
                // ABE 더위적게탐 스포티
                V_ITopclothes1.setImageResource(man.ABE20[0]);
                V_ITopclothes2.setImageResource(man.ABE20[1]);
                V_ITopclothes3.setImageResource(man.ABE20[2]);
                V_IOuterclothes1.setImageResource(man.ABE20[3]);
                V_IOuterclothes2.setImageResource(man.ABE20[4]);
                V_IOuterclothes3.setImageResource(man.ABE20[5]);
                V_IBottomclothes1.setImageResource(man.ABE20[6]);
                V_IBottomclothes2.setImageResource(man.ABE20[7]);
                V_IBottomclothes3.setImageResource(man.ABE20[8]);
                V_txtTop1.setText(man.txt_ABE20[0]);
                V_txtTop2.setText(man.txt_ABE20[1]);
                V_txtTop3.setText(man.txt_ABE20[2]);
                V_txtOuter1.setText(man.txt_ABE20[3]);
                V_txtOuter2.setText(man.txt_ABE20[4]);
                V_txtOuter3.setText(man.txt_ABE20[5]);
                V_txtBottom1.setText(man.txt_ABE20[6]);
                V_txtBottom2.setText(man.txt_ABE20[7]);
                V_txtBottom3.setText(man.txt_ABE20[8]);
            }

        }else if(max_temp == 23){
            if(result.equals("AAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes1.setImageResource(man.AAA23[0]);
                V_ITopclothes2.setImageResource(man.AAA23[1]);
                V_ITopclothes3.setImageResource(man.AAA23[2]);
                V_IOuterclothes1.setImageResource(man.AAA23[3]);
                V_IOuterclothes2.setImageResource(man.AAA23[4]);
                V_IOuterclothes3.setImageResource(man.AAA23[5]);
                V_IBottomclothes1.setImageResource(man.AAA23[6]);
                V_IBottomclothes2.setImageResource(man.AAA23[7]);
                V_IBottomclothes3.setImageResource(man.AAA23[8]);
                V_txtTop1.setText(man.txt_AAA23[0]);
                V_txtTop2.setText(man.txt_AAA23[1]);
                V_txtTop3.setText(man.txt_AAA23[2]);
                V_txtOuter1.setText(man.txt_AAA23[3]);
                V_txtOuter2.setText(man.txt_AAA23[4]);
                V_txtOuter3.setText(man.txt_AAA23[5]);
                V_txtBottom1.setText(man.txt_AAA23[6]);
                V_txtBottom2.setText(man.txt_AAA23[7]);
                V_txtBottom3.setText(man.txt_AAA23[8]);

            }else if(result.equals("AAB")){
                // 더위많이탐 빈티지
                V_ITopclothes1.setImageResource(man.AAB23[0]);
                V_ITopclothes2.setImageResource(man.AAB23[1]);
                V_ITopclothes3.setImageResource(man.AAB23[2]);
                V_IOuterclothes1.setImageResource(man.AAB23[3]);
                V_IOuterclothes2.setImageResource(man.AAB23[4]);
                V_IOuterclothes3.setImageResource(man.AAB23[5]);
                V_IBottomclothes1.setImageResource(man.AAB23[6]);
                V_IBottomclothes2.setImageResource(man.AAB23[7]);
                V_IBottomclothes3.setImageResource(man.AAB23[8]);
                V_txtTop1.setText(man.txt_AAB23[0]);
                V_txtTop2.setText(man.txt_AAB23[1]);
                V_txtTop3.setText(man.txt_AAB23[2]);
                V_txtOuter1.setText(man.txt_AAB23[3]);
                V_txtOuter2.setText(man.txt_AAB23[4]);
                V_txtOuter3.setText(man.txt_AAB23[5]);
                V_txtBottom1.setText(man.txt_AAB23[6]);
                V_txtBottom2.setText(man.txt_AAB23[7]);
                V_txtBottom3.setText(man.txt_AAB23[8]);
            }else if(result.equals("AAC")){
                // 더위많이탐 스트릿
                V_ITopclothes1.setImageResource(man.AAC23[0]);
                V_ITopclothes2.setImageResource(man.AAC23[1]);
                V_ITopclothes3.setImageResource(man.AAC23[2]);
                V_IOuterclothes1.setImageResource(man.AAC23[3]);
                V_IOuterclothes2.setImageResource(man.AAC23[4]);
                V_IOuterclothes3.setImageResource(man.AAC23[5]);
                V_IBottomclothes1.setImageResource(man.AAC23[6]);
                V_IBottomclothes2.setImageResource(man.AAC23[7]);
                V_IBottomclothes3.setImageResource(man.AAC23[8]);
                V_txtTop1.setText(man.txt_AAC23[0]);
                V_txtTop2.setText(man.txt_AAC23[1]);
                V_txtTop3.setText(man.txt_AAC23[2]);
                V_txtOuter1.setText(man.txt_AAC23[3]);
                V_txtOuter2.setText(man.txt_AAC23[4]);
                V_txtOuter3.setText(man.txt_AAC23[5]);
                V_txtBottom1.setText(man.txt_AAC23[6]);
                V_txtBottom2.setText(man.txt_AAC23[7]);
                V_txtBottom3.setText(man.txt_AAC23[8]);
            }else if(result.equals("AAD")){
                // 더위많이탐 댄디
                V_ITopclothes1.setImageResource(man.AAD23[0]);
                V_ITopclothes2.setImageResource(man.AAD23[1]);
                V_ITopclothes3.setImageResource(man.AAD23[2]);
                V_IOuterclothes1.setImageResource(man.AAD23[3]);
                V_IOuterclothes2.setImageResource(man.AAD23[4]);
                V_IOuterclothes3.setImageResource(man.AAD23[5]);
                V_IBottomclothes1.setImageResource(man.AAD23[6]);
                V_IBottomclothes2.setImageResource(man.AAD23[7]);
                V_IBottomclothes3.setImageResource(man.AAD23[8]);
                V_txtTop1.setText(man.txt_AAD23[0]);
                V_txtTop2.setText(man.txt_AAD23[1]);
                V_txtTop3.setText(man.txt_AAD23[2]);
                V_txtOuter1.setText(man.txt_AAD23[3]);
                V_txtOuter2.setText(man.txt_AAD23[4]);
                V_txtOuter3.setText(man.txt_AAD23[5]);
                V_txtBottom1.setText(man.txt_AAD23[6]);
                V_txtBottom2.setText(man.txt_AAD23[7]);
                V_txtBottom3.setText(man.txt_AAD23[8]);

            }else if(result.equals("AAE")){
                // 더위많이탐 스포티
                V_ITopclothes1.setImageResource(man.AAE23[0]);
                V_ITopclothes2.setImageResource(man.AAE23[1]);
                V_ITopclothes3.setImageResource(man.AAE23[2]);
                V_IOuterclothes1.setImageResource(man.AAE23[3]);
                V_IOuterclothes2.setImageResource(man.AAE23[4]);
                V_IOuterclothes3.setImageResource(man.AAE23[5]);
                V_IBottomclothes1.setImageResource(man.AAE23[6]);
                V_IBottomclothes2.setImageResource(man.AAE23[7]);
                V_IBottomclothes3.setImageResource(man.AAE23[8]);
                V_txtTop1.setText(man.txt_AAE23[0]);
                V_txtTop2.setText(man.txt_AAE23[1]);
                V_txtTop3.setText(man.txt_AAE23[2]);
                V_txtOuter1.setText(man.txt_AAE23[3]);
                V_txtOuter2.setText(man.txt_AAE23[4]);
                V_txtOuter3.setText(man.txt_AAE23[5]);
                V_txtBottom1.setText(man.txt_AAE23[6]);
                V_txtBottom2.setText(man.txt_AAE23[7]);
                V_txtBottom3.setText(man.txt_AAE23[8]);

            }else if(result.equals("ABA")){
                // 더위적게탐 캐주얼
                V_ITopclothes1.setImageResource(man.ABA23[0]);
                V_ITopclothes2.setImageResource(man.ABA23[1]);
                V_ITopclothes3.setImageResource(man.ABA23[2]);
                V_IOuterclothes1.setImageResource(man.ABA23[3]);
                V_IOuterclothes2.setImageResource(man.ABA23[4]);
                V_IOuterclothes3.setImageResource(man.ABA23[5]);
                V_IBottomclothes1.setImageResource(man.ABA23[6]);
                V_IBottomclothes2.setImageResource(man.ABA23[7]);
                V_IBottomclothes3.setImageResource(man.ABA23[8]);
                V_txtTop1.setText(man.txt_ABA23[0]);
                V_txtTop2.setText(man.txt_ABA23[1]);
                V_txtTop3.setText(man.txt_ABA23[2]);
                V_txtOuter1.setText(man.txt_ABA23[3]);
                V_txtOuter2.setText(man.txt_ABA23[4]);
                V_txtOuter3.setText(man.txt_ABA23[5]);
                V_txtBottom1.setText(man.txt_ABA23[6]);
                V_txtBottom2.setText(man.txt_ABA23[7]);
                V_txtBottom3.setText(man.txt_ABA23[8]);

            }else if(result.equals("ABB")){
                // 더위적게탐 빈티지
                V_ITopclothes1.setImageResource(man.ABB23[0]);
                V_ITopclothes2.setImageResource(man.ABB23[1]);
                V_ITopclothes3.setImageResource(man.ABB23[2]);
                V_IOuterclothes1.setImageResource(man.ABB23[3]);
                V_IOuterclothes2.setImageResource(man.ABB23[4]);
                V_IOuterclothes3.setImageResource(man.ABB23[5]);
                V_IBottomclothes1.setImageResource(man.ABB23[6]);
                V_IBottomclothes2.setImageResource(man.ABB23[7]);
                V_IBottomclothes3.setImageResource(man.ABB23[8]);
                V_txtTop1.setText(man.txt_ABB23[0]);
                V_txtTop2.setText(man.txt_ABB23[1]);
                V_txtTop3.setText(man.txt_ABB23[2]);
                V_txtOuter1.setText(man.txt_ABB23[3]);
                V_txtOuter2.setText(man.txt_ABB23[4]);
                V_txtOuter3.setText(man.txt_ABB23[5]);
                V_txtBottom1.setText(man.txt_ABB23[6]);
                V_txtBottom2.setText(man.txt_ABB23[7]);
                V_txtBottom3.setText(man.txt_ABB23[8]);
            }else if(result.equals("ABC")){
                // 더위적게탐 스트릿
                V_ITopclothes1.setImageResource(man.ABC23[0]);
                V_ITopclothes2.setImageResource(man.ABC23[1]);
                V_ITopclothes3.setImageResource(man.ABC23[2]);
                V_IOuterclothes1.setImageResource(man.ABC23[3]);
                V_IOuterclothes2.setImageResource(man.ABC23[4]);
                V_IOuterclothes3.setImageResource(man.ABC23[5]);
                V_IBottomclothes1.setImageResource(man.ABC23[6]);
                V_IBottomclothes2.setImageResource(man.ABC23[7]);
                V_IBottomclothes3.setImageResource(man.ABC23[8]);
                V_txtTop1.setText(man.txt_ABC23[0]);
                V_txtTop2.setText(man.txt_ABC23[1]);
                V_txtTop3.setText(man.txt_ABC23[2]);
                V_txtOuter1.setText(man.txt_ABC23[3]);
                V_txtOuter2.setText(man.txt_ABC23[4]);
                V_txtOuter3.setText(man.txt_ABC23[5]);
                V_txtBottom1.setText(man.txt_ABC23[6]);
                V_txtBottom2.setText(man.txt_ABC23[7]);
                V_txtBottom3.setText(man.txt_ABC23[8]);
            }else if(result.equals("ABD")){
                // 더위적게탐 댄디
                V_ITopclothes1.setImageResource(man.ABD23[0]);
                V_ITopclothes2.setImageResource(man.ABD23[1]);
                V_ITopclothes3.setImageResource(man.ABD23[2]);
                V_IOuterclothes1.setImageResource(man.ABD23[3]);
                V_IOuterclothes2.setImageResource(man.ABD23[4]);
                V_IOuterclothes3.setImageResource(man.ABD23[5]);
                V_IBottomclothes1.setImageResource(man.ABD23[6]);
                V_IBottomclothes2.setImageResource(man.ABD23[7]);
                V_IBottomclothes3.setImageResource(man.ABD23[8]);
                V_txtTop1.setText(man.txt_ABD23[0]);
                V_txtTop2.setText(man.txt_ABD23[1]);
                V_txtTop3.setText(man.txt_ABD23[2]);
                V_txtOuter1.setText(man.txt_ABD23[3]);
                V_txtOuter2.setText(man.txt_ABD23[4]);
                V_txtOuter3.setText(man.txt_ABD23[5]);
                V_txtBottom1.setText(man.txt_ABD23[6]);
                V_txtBottom2.setText(man.txt_ABD23[7]);
                V_txtBottom3.setText(man.txt_ABD23[8]);

            }else{
                // ABE 더위적게탐 스포티
                V_ITopclothes1.setImageResource(man.ABE23[0]);
                V_ITopclothes2.setImageResource(man.ABE23[1]);
                V_ITopclothes3.setImageResource(man.ABE23[2]);
                V_IOuterclothes1.setImageResource(man.ABE23[3]);
                V_IOuterclothes2.setImageResource(man.ABE23[4]);
                V_IOuterclothes3.setImageResource(man.ABE23[5]);
                V_IBottomclothes1.setImageResource(man.ABE23[6]);
                V_IBottomclothes2.setImageResource(man.ABE23[7]);
                V_IBottomclothes3.setImageResource(man.ABE23[8]);
                V_txtTop1.setText(man.txt_ABE23[0]);
                V_txtTop2.setText(man.txt_ABE23[1]);
                V_txtTop3.setText(man.txt_ABE23[2]);
                V_txtOuter1.setText(man.txt_ABE23[3]);
                V_txtOuter2.setText(man.txt_ABE23[4]);
                V_txtOuter3.setText(man.txt_ABE23[5]);
                V_txtBottom1.setText(man.txt_ABE23[6]);
                V_txtBottom2.setText(man.txt_ABE23[7]);
                V_txtBottom3.setText(man.txt_ABE23[8]);
            }

        }else if(max_temp == 28){
            if(result.equals("AAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes1.setImageResource(man.AAA28[0]);
                V_ITopclothes2.setImageResource(man.AAA28[1]);
                V_ITopclothes3.setImageResource(man.AAA28[2]);
                V_IOuterclothes1.setImageResource(man.AAA28[3]);
                V_IOuterclothes2.setImageResource(man.AAA28[4]);
                V_IOuterclothes3.setImageResource(man.AAA28[5]);
                V_IBottomclothes1.setImageResource(man.AAA28[6]);
                V_IBottomclothes2.setImageResource(man.AAA28[7]);
                V_IBottomclothes3.setImageResource(man.AAA28[8]);
                V_txtTop1.setText(man.txt_AAA28[0]);
                V_txtTop2.setText(man.txt_AAA28[1]);
                V_txtTop3.setText(man.txt_AAA28[2]);
                V_txtOuter1.setText(man.txt_AAA28[3]);
                V_txtOuter2.setText(man.txt_AAA28[4]);
                V_txtOuter3.setText(man.txt_AAA28[5]);
                V_txtBottom1.setText(man.txt_AAA28[6]);
                V_txtBottom2.setText(man.txt_AAA28[7]);
                V_txtBottom3.setText(man.txt_AAA28[8]);

            }else if(result.equals("AAB")){
                // 더위많이탐 빈티지
                V_ITopclothes1.setImageResource(man.AAB28[0]);
                V_ITopclothes2.setImageResource(man.AAB28[1]);
                V_ITopclothes3.setImageResource(man.AAB28[2]);
                V_IOuterclothes1.setImageResource(man.AAB28[3]);
                V_IOuterclothes2.setImageResource(man.AAB28[4]);
                V_IOuterclothes3.setImageResource(man.AAB28[5]);
                V_IBottomclothes1.setImageResource(man.AAB28[6]);
                V_IBottomclothes2.setImageResource(man.AAB28[7]);
                V_IBottomclothes3.setImageResource(man.AAB28[8]);
                V_txtTop1.setText(man.txt_AAB28[0]);
                V_txtTop2.setText(man.txt_AAB28[1]);
                V_txtTop3.setText(man.txt_AAB28[2]);
                V_txtOuter1.setText(man.txt_AAB28[3]);
                V_txtOuter2.setText(man.txt_AAB28[4]);
                V_txtOuter3.setText(man.txt_AAB28[5]);
                V_txtBottom1.setText(man.txt_AAB28[6]);
                V_txtBottom2.setText(man.txt_AAB28[7]);
                V_txtBottom3.setText(man.txt_AAB28[8]);
            }else if(result.equals("AAC")){
                // 더위많이탐 스트릿
                V_ITopclothes1.setImageResource(man.AAC28[0]);
                V_ITopclothes2.setImageResource(man.AAC28[1]);
                V_ITopclothes3.setImageResource(man.AAC28[2]);
                V_IOuterclothes1.setImageResource(man.AAC28[3]);
                V_IOuterclothes2.setImageResource(man.AAC28[4]);
                V_IOuterclothes3.setImageResource(man.AAC28[5]);
                V_IBottomclothes1.setImageResource(man.AAC28[6]);
                V_IBottomclothes2.setImageResource(man.AAC28[7]);
                V_IBottomclothes3.setImageResource(man.AAC28[8]);
                V_txtTop1.setText(man.txt_AAC28[0]);
                V_txtTop2.setText(man.txt_AAC28[1]);
                V_txtTop3.setText(man.txt_AAC28[2]);
                V_txtOuter1.setText(man.txt_AAC28[3]);
                V_txtOuter2.setText(man.txt_AAC28[4]);
                V_txtOuter3.setText(man.txt_AAC28[5]);
                V_txtBottom1.setText(man.txt_AAC28[6]);
                V_txtBottom2.setText(man.txt_AAC28[7]);
                V_txtBottom3.setText(man.txt_AAC28[8]);
            }else if(result.equals("AAD")){
                // 더위많이탐 댄디
                V_ITopclothes1.setImageResource(man.AAD28[0]);
                V_ITopclothes2.setImageResource(man.AAD28[1]);
                V_ITopclothes3.setImageResource(man.AAD28[2]);
                V_IOuterclothes1.setImageResource(man.AAD28[3]);
                V_IOuterclothes2.setImageResource(man.AAD28[4]);
                V_IOuterclothes3.setImageResource(man.AAD28[5]);
                V_IBottomclothes1.setImageResource(man.AAD28[6]);
                V_IBottomclothes2.setImageResource(man.AAD28[7]);
                V_IBottomclothes3.setImageResource(man.AAD28[8]);
                V_txtTop1.setText(man.txt_AAD28[0]);
                V_txtTop2.setText(man.txt_AAD28[1]);
                V_txtTop3.setText(man.txt_AAD28[2]);
                V_txtOuter1.setText(man.txt_AAD28[3]);
                V_txtOuter2.setText(man.txt_AAD28[4]);
                V_txtOuter3.setText(man.txt_AAD28[5]);
                V_txtBottom1.setText(man.txt_AAD28[6]);
                V_txtBottom2.setText(man.txt_AAD28[7]);
                V_txtBottom3.setText(man.txt_AAD28[8]);

            }else if(result.equals("AAE")){
                // 더위많이탐 스포티
                V_ITopclothes1.setImageResource(man.AAE28[0]);
                V_ITopclothes2.setImageResource(man.AAE28[1]);
                V_ITopclothes3.setImageResource(man.AAE28[2]);
                V_IOuterclothes1.setImageResource(man.AAE28[3]);
                V_IOuterclothes2.setImageResource(man.AAE28[4]);
                V_IOuterclothes3.setImageResource(man.AAE28[5]);
                V_IBottomclothes1.setImageResource(man.AAE28[6]);
                V_IBottomclothes2.setImageResource(man.AAE28[7]);
                V_IBottomclothes3.setImageResource(man.AAE28[8]);
                V_txtTop1.setText(man.txt_AAE28[0]);
                V_txtTop2.setText(man.txt_AAE28[1]);
                V_txtTop3.setText(man.txt_AAE28[2]);
                V_txtOuter1.setText(man.txt_AAE28[3]);
                V_txtOuter2.setText(man.txt_AAE28[4]);
                V_txtOuter3.setText(man.txt_AAE28[5]);
                V_txtBottom1.setText(man.txt_AAE28[6]);
                V_txtBottom2.setText(man.txt_AAE28[7]);
                V_txtBottom3.setText(man.txt_AAE28[8]);

            }else if(result.equals("ABA")){
                // 더위적게탐 캐주얼
                V_ITopclothes1.setImageResource(man.ABA28[0]);
                V_ITopclothes2.setImageResource(man.ABA28[1]);
                V_ITopclothes3.setImageResource(man.ABA28[2]);
                V_IOuterclothes1.setImageResource(man.ABA28[3]);
                V_IOuterclothes2.setImageResource(man.ABA28[4]);
                V_IOuterclothes3.setImageResource(man.ABA28[5]);
                V_IBottomclothes1.setImageResource(man.ABA28[6]);
                V_IBottomclothes2.setImageResource(man.ABA28[7]);
                V_IBottomclothes3.setImageResource(man.ABA28[8]);
                V_txtTop1.setText(man.txt_ABA28[0]);
                V_txtTop2.setText(man.txt_ABA28[1]);
                V_txtTop3.setText(man.txt_ABA28[2]);
                V_txtOuter1.setText(man.txt_ABA28[3]);
                V_txtOuter2.setText(man.txt_ABA28[4]);
                V_txtOuter3.setText(man.txt_ABA28[5]);
                V_txtBottom1.setText(man.txt_ABA28[6]);
                V_txtBottom2.setText(man.txt_ABA28[7]);
                V_txtBottom3.setText(man.txt_ABA28[8]);

            }else if(result.equals("ABB")){
                // 더위적게탐 빈티지
                V_ITopclothes1.setImageResource(man.ABB28[0]);
                V_ITopclothes2.setImageResource(man.ABB28[1]);
                V_ITopclothes3.setImageResource(man.ABB28[2]);
                V_IOuterclothes1.setImageResource(man.ABB28[3]);
                V_IOuterclothes2.setImageResource(man.ABB28[4]);
                V_IOuterclothes3.setImageResource(man.ABB28[5]);
                V_IBottomclothes1.setImageResource(man.ABB28[6]);
                V_IBottomclothes2.setImageResource(man.ABB28[7]);
                V_IBottomclothes3.setImageResource(man.ABB28[8]);
                V_txtTop1.setText(man.txt_ABB28[0]);
                V_txtTop2.setText(man.txt_ABB28[1]);
                V_txtTop3.setText(man.txt_ABB28[2]);
                V_txtOuter1.setText(man.txt_ABB28[3]);
                V_txtOuter2.setText(man.txt_ABB28[4]);
                V_txtOuter3.setText(man.txt_ABB28[5]);
                V_txtBottom1.setText(man.txt_ABB28[6]);
                V_txtBottom2.setText(man.txt_ABB28[7]);
                V_txtBottom3.setText(man.txt_ABB28[8]);
            }else if(result.equals("ABC")){
                // 더위적게탐 스트릿
                V_ITopclothes1.setImageResource(man.ABC28[0]);
                V_ITopclothes2.setImageResource(man.ABC28[1]);
                V_ITopclothes3.setImageResource(man.ABC28[2]);
                V_IOuterclothes1.setImageResource(man.ABC28[3]);
                V_IOuterclothes2.setImageResource(man.ABC28[4]);
                V_IOuterclothes3.setImageResource(man.ABC28[5]);
                V_IBottomclothes1.setImageResource(man.ABC28[6]);
                V_IBottomclothes2.setImageResource(man.ABC28[7]);
                V_IBottomclothes3.setImageResource(man.ABC28[8]);
                V_txtTop1.setText(man.txt_ABC28[0]);
                V_txtTop2.setText(man.txt_ABC28[1]);
                V_txtTop3.setText(man.txt_ABC28[2]);
                V_txtOuter1.setText(man.txt_ABC28[3]);
                V_txtOuter2.setText(man.txt_ABC28[4]);
                V_txtOuter3.setText(man.txt_ABC28[5]);
                V_txtBottom1.setText(man.txt_ABC28[6]);
                V_txtBottom2.setText(man.txt_ABC28[7]);
                V_txtBottom3.setText(man.txt_ABC28[8]);
            }else if(result.equals("ABD")){
                // 더위적게탐 댄디
                V_ITopclothes1.setImageResource(man.ABD28[0]);
                V_ITopclothes2.setImageResource(man.ABD28[1]);
                V_ITopclothes3.setImageResource(man.ABD28[2]);
                V_IOuterclothes1.setImageResource(man.ABD28[3]);
                V_IOuterclothes2.setImageResource(man.ABD28[4]);
                V_IOuterclothes3.setImageResource(man.ABD28[5]);
                V_IBottomclothes1.setImageResource(man.ABD28[6]);
                V_IBottomclothes2.setImageResource(man.ABD28[7]);
                V_IBottomclothes3.setImageResource(man.ABD28[8]);
                V_txtTop1.setText(man.txt_ABD28[0]);
                V_txtTop2.setText(man.txt_ABD28[1]);
                V_txtTop3.setText(man.txt_ABD28[2]);
                V_txtOuter1.setText(man.txt_ABD28[3]);
                V_txtOuter2.setText(man.txt_ABD28[4]);
                V_txtOuter3.setText(man.txt_ABD28[5]);
                V_txtBottom1.setText(man.txt_ABD28[6]);
                V_txtBottom2.setText(man.txt_ABD28[7]);
                V_txtBottom3.setText(man.txt_ABD28[8]);

            }else{
                // ABE 더위적게탐 스포티
                V_ITopclothes1.setImageResource(man.ABE28[0]);
                V_ITopclothes2.setImageResource(man.ABE28[1]);
                V_ITopclothes3.setImageResource(man.ABE28[2]);
                V_IOuterclothes1.setImageResource(man.ABE28[3]);
                V_IOuterclothes2.setImageResource(man.ABE28[4]);
                V_IOuterclothes3.setImageResource(man.ABE28[5]);
                V_IBottomclothes1.setImageResource(man.ABE28[6]);
                V_IBottomclothes2.setImageResource(man.ABE28[7]);
                V_IBottomclothes3.setImageResource(man.ABE28[8]);
                V_txtTop1.setText(man.txt_ABE28[0]);
                V_txtTop2.setText(man.txt_ABE28[1]);
                V_txtTop3.setText(man.txt_ABE28[2]);
                V_txtOuter1.setText(man.txt_ABE28[3]);
                V_txtOuter2.setText(man.txt_ABE28[4]);
                V_txtOuter3.setText(man.txt_ABE28[5]);
                V_txtBottom1.setText(man.txt_ABE28[6]);
                V_txtBottom2.setText(man.txt_ABE28[7]);
                V_txtBottom3.setText(man.txt_ABE28[8]);
            }

        }
    }

    // 옷을 보여주는 함수.(최저온도)
    public void clothesShowLow(int low_temp, String result){
        ClothesArray_man man = new ClothesArray_man();

        // temp => 현재 온도값의 범위, result => 사용자가 설문지 조사한 결과
        // 최저기온과 결과값
        if(low_temp == 4){
            if(result.equals("AAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes4.setImageResource(man.AAA4[0]);
                V_ITopclothes5.setImageResource(man.AAA4[1]);
                V_ITopclothes6.setImageResource(man.AAA4[2]);
                V_IOuterclothes4.setImageResource(man.AAA4[3]);
                V_IOuterclothes5.setImageResource(man.AAA4[4]);
                V_IOuterclothes6.setImageResource(man.AAA4[5]);
                V_IBottomclothes4.setImageResource(man.AAA4[6]);
                V_IBottomclothes5.setImageResource(man.AAA4[7]);
                V_IBottomclothes6.setImageResource(man.AAA4[8]);
                V_txtTop4.setText(man.txt_AAA4[0]);
                V_txtTop5.setText(man.txt_AAA4[1]);
                V_txtTop6.setText(man.txt_AAA4[2]);
                V_txtOuter4.setText(man.txt_AAA4[3]);
                V_txtOuter5.setText(man.txt_AAA4[4]);
                V_txtOuter6.setText(man.txt_AAA4[5]);
                V_txtBottom4.setText(man.txt_AAA4[6]);
                V_txtBottom5.setText(man.txt_AAA4[7]);
                V_txtBottom6.setText(man.txt_AAA4[8]);

            }else if(result.equals("AAB")){
                // 더위많이탐 빈티지
                V_ITopclothes4.setImageResource(man.AAB4[0]);
                V_ITopclothes5.setImageResource(man.AAB4[1]);
                V_ITopclothes6.setImageResource(man.AAB4[2]);
                V_IOuterclothes4.setImageResource(man.AAB4[3]);
                V_IOuterclothes5.setImageResource(man.AAB4[4]);
                V_IOuterclothes6.setImageResource(man.AAB4[5]);
                V_IBottomclothes4.setImageResource(man.AAB4[6]);
                V_IBottomclothes5.setImageResource(man.AAB4[7]);
                V_IBottomclothes6.setImageResource(man.AAB4[8]);
                V_txtTop4.setText(man.txt_AAB4[0]);
                V_txtTop5.setText(man.txt_AAB4[1]);
                V_txtTop6.setText(man.txt_AAB4[2]);
                V_txtOuter4.setText(man.txt_AAB4[3]);
                V_txtOuter5.setText(man.txt_AAB4[4]);
                V_txtOuter6.setText(man.txt_AAB4[5]);
                V_txtBottom4.setText(man.txt_AAB4[6]);
                V_txtBottom5.setText(man.txt_AAB4[7]);
                V_txtBottom6.setText(man.txt_AAB4[8]);
            }else if(result.equals("AAC")){
                // 더위많이탐 스트릿
                V_ITopclothes4.setImageResource(man.AAC4[0]);
                V_ITopclothes5.setImageResource(man.AAC4[1]);
                V_ITopclothes6.setImageResource(man.AAC4[2]);
                V_IOuterclothes4.setImageResource(man.AAC4[3]);
                V_IOuterclothes5.setImageResource(man.AAC4[4]);
                V_IOuterclothes6.setImageResource(man.AAC4[5]);
                V_IBottomclothes4.setImageResource(man.AAC4[6]);
                V_IBottomclothes5.setImageResource(man.AAC4[7]);
                V_IBottomclothes6.setImageResource(man.AAC4[8]);
                V_txtTop4.setText(man.txt_AAC4[0]);
                V_txtTop5.setText(man.txt_AAC4[1]);
                V_txtTop6.setText(man.txt_AAC4[2]);
                V_txtOuter4.setText(man.txt_AAC4[3]);
                V_txtOuter5.setText(man.txt_AAC4[4]);
                V_txtOuter6.setText(man.txt_AAC4[5]);
                V_txtBottom4.setText(man.txt_AAC4[6]);
                V_txtBottom5.setText(man.txt_AAC4[7]);
                V_txtBottom6.setText(man.txt_AAC4[8]);
            }else if(result.equals("AAD")){
                // 더위많이탐 댄디
                V_ITopclothes4.setImageResource(man.AAD4[0]);
                V_ITopclothes5.setImageResource(man.AAD4[1]);
                V_ITopclothes6.setImageResource(man.AAD4[2]);
                V_IOuterclothes4.setImageResource(man.AAD4[3]);
                V_IOuterclothes5.setImageResource(man.AAD4[4]);
                V_IOuterclothes6.setImageResource(man.AAD4[5]);
                V_IBottomclothes4.setImageResource(man.AAD4[6]);
                V_IBottomclothes5.setImageResource(man.AAD4[7]);
                V_IBottomclothes6.setImageResource(man.AAD4[8]);
                V_txtTop4.setText(man.txt_AAD4[0]);
                V_txtTop5.setText(man.txt_AAD4[1]);
                V_txtTop6.setText(man.txt_AAD4[2]);
                V_txtOuter4.setText(man.txt_AAD4[3]);
                V_txtOuter5.setText(man.txt_AAD4[4]);
                V_txtOuter6.setText(man.txt_AAD4[5]);
                V_txtBottom4.setText(man.txt_AAD4[6]);
                V_txtBottom5.setText(man.txt_AAD4[7]);
                V_txtBottom6.setText(man.txt_AAD4[8]);

            }else if(result.equals("AAE")){
                // 더위많이탐 스포티
                V_ITopclothes4.setImageResource(man.AAE4[0]);
                V_ITopclothes5.setImageResource(man.AAE4[1]);
                V_ITopclothes6.setImageResource(man.AAE4[2]);
                V_IOuterclothes4.setImageResource(man.AAE4[3]);
                V_IOuterclothes5.setImageResource(man.AAE4[4]);
                V_IOuterclothes6.setImageResource(man.AAE4[5]);
                V_IBottomclothes4.setImageResource(man.AAE4[6]);
                V_IBottomclothes5.setImageResource(man.AAE4[7]);
                V_IBottomclothes6.setImageResource(man.AAE4[8]);
                V_txtTop4.setText(man.txt_AAE4[0]);
                V_txtTop5.setText(man.txt_AAE4[1]);
                V_txtTop6.setText(man.txt_AAE4[2]);
                V_txtOuter4.setText(man.txt_AAE4[3]);
                V_txtOuter5.setText(man.txt_AAE4[4]);
                V_txtOuter6.setText(man.txt_AAE4[5]);
                V_txtBottom4.setText(man.txt_AAE4[6]);
                V_txtBottom5.setText(man.txt_AAE4[7]);
                V_txtBottom6.setText(man.txt_AAE4[8]);

            }else if(result.equals("ABA")){
                // 더위적게탐 캐주얼
                V_ITopclothes4.setImageResource(man.ABA4[0]);
                V_ITopclothes5.setImageResource(man.ABA4[1]);
                V_ITopclothes6.setImageResource(man.ABA4[2]);
                V_IOuterclothes4.setImageResource(man.ABA4[3]);
                V_IOuterclothes5.setImageResource(man.ABA4[4]);
                V_IOuterclothes6.setImageResource(man.ABA4[5]);
                V_IBottomclothes4.setImageResource(man.ABA4[6]);
                V_IBottomclothes5.setImageResource(man.ABA4[7]);
                V_IBottomclothes6.setImageResource(man.ABA4[8]);
                V_txtTop4.setText(man.txt_ABA4[0]);
                V_txtTop5.setText(man.txt_ABA4[1]);
                V_txtTop6.setText(man.txt_ABA4[2]);
                V_txtOuter4.setText(man.txt_ABA4[3]);
                V_txtOuter5.setText(man.txt_ABA4[4]);
                V_txtOuter6.setText(man.txt_ABA4[5]);
                V_txtBottom4.setText(man.txt_ABA4[6]);
                V_txtBottom5.setText(man.txt_ABA4[7]);
                V_txtBottom6.setText(man.txt_ABA4[8]);

            }else if(result.equals("ABB")){
                // 더위적게탐 빈티지
                V_ITopclothes4.setImageResource(man.ABB4[0]);
                V_ITopclothes5.setImageResource(man.ABB4[1]);
                V_ITopclothes6.setImageResource(man.ABB4[2]);
                V_IOuterclothes4.setImageResource(man.ABB4[3]);
                V_IOuterclothes5.setImageResource(man.ABB4[4]);
                V_IOuterclothes6.setImageResource(man.ABB4[5]);
                V_IBottomclothes4.setImageResource(man.ABB4[6]);
                V_IBottomclothes5.setImageResource(man.ABB4[7]);
                V_IBottomclothes6.setImageResource(man.ABB4[8]);
                V_txtTop4.setText(man.txt_ABB4[0]);
                V_txtTop5.setText(man.txt_ABB4[1]);
                V_txtTop6.setText(man.txt_ABB4[2]);
                V_txtOuter4.setText(man.txt_ABB4[3]);
                V_txtOuter5.setText(man.txt_ABB4[4]);
                V_txtOuter6.setText(man.txt_ABB4[5]);
                V_txtBottom4.setText(man.txt_ABB4[6]);
                V_txtBottom5.setText(man.txt_ABB4[7]);
                V_txtBottom6.setText(man.txt_ABB4[8]);
            }else if(result.equals("ABC")){
                // 더위적게탐 스트릿
                V_ITopclothes4.setImageResource(man.ABC4[0]);
                V_ITopclothes5.setImageResource(man.ABC4[1]);
                V_ITopclothes6.setImageResource(man.ABC4[2]);
                V_IOuterclothes4.setImageResource(man.ABC4[3]);
                V_IOuterclothes5.setImageResource(man.ABC4[4]);
                V_IOuterclothes6.setImageResource(man.ABC4[5]);
                V_IBottomclothes4.setImageResource(man.ABC4[6]);
                V_IBottomclothes5.setImageResource(man.ABC4[7]);
                V_IBottomclothes6.setImageResource(man.ABC4[8]);
                V_txtTop4.setText(man.txt_ABC4[0]);
                V_txtTop5.setText(man.txt_ABC4[1]);
                V_txtTop6.setText(man.txt_ABC4[2]);
                V_txtOuter4.setText(man.txt_ABC4[3]);
                V_txtOuter5.setText(man.txt_ABC4[4]);
                V_txtOuter6.setText(man.txt_ABC4[5]);
                V_txtBottom4.setText(man.txt_ABC4[6]);
                V_txtBottom5.setText(man.txt_ABC4[7]);
                V_txtBottom6.setText(man.txt_ABC4[8]);
            }else if(result.equals("ABD")){
                // 더위적게탐 댄디
                V_ITopclothes4.setImageResource(man.ABD4[0]);
                V_ITopclothes5.setImageResource(man.ABD4[1]);
                V_ITopclothes6.setImageResource(man.ABD4[2]);
                V_IOuterclothes4.setImageResource(man.ABD4[3]);
                V_IOuterclothes5.setImageResource(man.ABD4[4]);
                V_IOuterclothes6.setImageResource(man.ABD4[5]);
                V_IBottomclothes4.setImageResource(man.ABD4[6]);
                V_IBottomclothes5.setImageResource(man.ABD4[7]);
                V_IBottomclothes6.setImageResource(man.ABD4[8]);
                V_txtTop4.setText(man.txt_ABD4[0]);
                V_txtTop5.setText(man.txt_ABD4[1]);
                V_txtTop6.setText(man.txt_ABD4[2]);
                V_txtOuter4.setText(man.txt_ABD4[3]);
                V_txtOuter5.setText(man.txt_ABD4[4]);
                V_txtOuter6.setText(man.txt_ABD4[5]);
                V_txtBottom4.setText(man.txt_ABD4[6]);
                V_txtBottom5.setText(man.txt_ABD4[7]);
                V_txtBottom6.setText(man.txt_ABD4[8]);

            }else{
                // ABE 더위적게탐 스포티
                V_ITopclothes4.setImageResource(man.ABE4[0]);
                V_ITopclothes5.setImageResource(man.ABE4[1]);
                V_ITopclothes6.setImageResource(man.ABE4[2]);
                V_IOuterclothes4.setImageResource(man.ABE4[3]);
                V_IOuterclothes5.setImageResource(man.ABE4[4]);
                V_IOuterclothes6.setImageResource(man.ABE4[5]);
                V_IBottomclothes4.setImageResource(man.ABE4[6]);
                V_IBottomclothes5.setImageResource(man.ABE4[7]);
                V_IBottomclothes6.setImageResource(man.ABE4[8]);
                V_txtTop4.setText(man.txt_ABE4[0]);
                V_txtTop5.setText(man.txt_ABE4[1]);
                V_txtTop6.setText(man.txt_ABE4[2]);
                V_txtOuter4.setText(man.txt_ABE4[3]);
                V_txtOuter5.setText(man.txt_ABE4[4]);
                V_txtOuter6.setText(man.txt_ABE4[5]);
                V_txtBottom4.setText(man.txt_ABE4[6]);
                V_txtBottom5.setText(man.txt_ABE4[7]);
                V_txtBottom6.setText(man.txt_ABE4[8]);
            }
        }else if(low_temp == 5){
            if(result.equals("AAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes4.setImageResource(man.AAA5[0]);
                V_ITopclothes5.setImageResource(man.AAA5[1]);
                V_ITopclothes6.setImageResource(man.AAA5[2]);
                V_IOuterclothes4.setImageResource(man.AAA5[3]);
                V_IOuterclothes5.setImageResource(man.AAA5[4]);
                V_IOuterclothes6.setImageResource(man.AAA5[5]);
                V_IBottomclothes4.setImageResource(man.AAA5[6]);
                V_IBottomclothes5.setImageResource(man.AAA5[7]);
                V_IBottomclothes6.setImageResource(man.AAA5[8]);
                V_txtTop4.setText(man.txt_AAA5[0]);
                V_txtTop5.setText(man.txt_AAA5[1]);
                V_txtTop6.setText(man.txt_AAA5[2]);
                V_txtOuter4.setText(man.txt_AAA5[3]);
                V_txtOuter5.setText(man.txt_AAA5[4]);
                V_txtOuter6.setText(man.txt_AAA5[5]);
                V_txtBottom4.setText(man.txt_AAA5[6]);
                V_txtBottom5.setText(man.txt_AAA5[7]);
                V_txtBottom6.setText(man.txt_AAA5[8]);

            }else if(result.equals("AAB")){
                // 더위많이탐 빈티지
                V_ITopclothes4.setImageResource(man.AAB5[0]);
                V_ITopclothes5.setImageResource(man.AAB5[1]);
                V_ITopclothes6.setImageResource(man.AAB5[2]);
                V_IOuterclothes4.setImageResource(man.AAB5[3]);
                V_IOuterclothes5.setImageResource(man.AAB5[4]);
                V_IOuterclothes6.setImageResource(man.AAB5[5]);
                V_IBottomclothes4.setImageResource(man.AAB5[6]);
                V_IBottomclothes5.setImageResource(man.AAB5[7]);
                V_IBottomclothes6.setImageResource(man.AAB5[8]);
                V_txtTop4.setText(man.txt_AAB5[0]);
                V_txtTop5.setText(man.txt_AAB5[1]);
                V_txtTop6.setText(man.txt_AAB5[2]);
                V_txtOuter4.setText(man.txt_AAB5[3]);
                V_txtOuter5.setText(man.txt_AAB5[4]);
                V_txtOuter6.setText(man.txt_AAB5[5]);
                V_txtBottom4.setText(man.txt_AAB5[6]);
                V_txtBottom5.setText(man.txt_AAB5[7]);
                V_txtBottom6.setText(man.txt_AAB5[8]);
            }else if(result.equals("AAC")){
                // 더위많이탐 스트릿
                V_ITopclothes4.setImageResource(man.AAC5[0]);
                V_ITopclothes5.setImageResource(man.AAC5[1]);
                V_ITopclothes6.setImageResource(man.AAC5[2]);
                V_IOuterclothes4.setImageResource(man.AAC5[3]);
                V_IOuterclothes5.setImageResource(man.AAC5[4]);
                V_IOuterclothes6.setImageResource(man.AAC5[5]);
                V_IBottomclothes4.setImageResource(man.AAC5[6]);
                V_IBottomclothes5.setImageResource(man.AAC5[7]);
                V_IBottomclothes6.setImageResource(man.AAC5[8]);
                V_txtTop4.setText(man.txt_AAC5[0]);
                V_txtTop5.setText(man.txt_AAC5[1]);
                V_txtTop6.setText(man.txt_AAC5[2]);
                V_txtOuter4.setText(man.txt_AAC5[3]);
                V_txtOuter5.setText(man.txt_AAC5[4]);
                V_txtOuter6.setText(man.txt_AAC5[5]);
                V_txtBottom4.setText(man.txt_AAC5[6]);
                V_txtBottom5.setText(man.txt_AAC5[7]);
                V_txtBottom6.setText(man.txt_AAC5[8]);
            }else if(result.equals("AAD")){
                // 더위많이탐 댄디
                V_ITopclothes4.setImageResource(man.AAD5[0]);
                V_ITopclothes5.setImageResource(man.AAD5[1]);
                V_ITopclothes6.setImageResource(man.AAD5[2]);
                V_IOuterclothes4.setImageResource(man.AAD5[3]);
                V_IOuterclothes5.setImageResource(man.AAD5[4]);
                V_IOuterclothes6.setImageResource(man.AAD5[5]);
                V_IBottomclothes4.setImageResource(man.AAD5[6]);
                V_IBottomclothes5.setImageResource(man.AAD5[7]);
                V_IBottomclothes6.setImageResource(man.AAD5[8]);
                V_txtTop4.setText(man.txt_AAD5[0]);
                V_txtTop5.setText(man.txt_AAD5[1]);
                V_txtTop6.setText(man.txt_AAD5[2]);
                V_txtOuter4.setText(man.txt_AAD5[3]);
                V_txtOuter5.setText(man.txt_AAD5[4]);
                V_txtOuter6.setText(man.txt_AAD5[5]);
                V_txtBottom4.setText(man.txt_AAD5[6]);
                V_txtBottom5.setText(man.txt_AAD5[7]);
                V_txtBottom6.setText(man.txt_AAD5[8]);

            }else if(result.equals("AAE")){
                // 더위많이탐 스포티
                V_ITopclothes4.setImageResource(man.AAE5[0]);
                V_ITopclothes5.setImageResource(man.AAE5[1]);
                V_ITopclothes6.setImageResource(man.AAE5[2]);
                V_IOuterclothes4.setImageResource(man.AAE5[3]);
                V_IOuterclothes5.setImageResource(man.AAE5[4]);
                V_IOuterclothes6.setImageResource(man.AAE5[5]);
                V_IBottomclothes4.setImageResource(man.AAE5[6]);
                V_IBottomclothes5.setImageResource(man.AAE5[7]);
                V_IBottomclothes6.setImageResource(man.AAE5[8]);
                V_txtTop4.setText(man.txt_AAE5[0]);
                V_txtTop5.setText(man.txt_AAE5[1]);
                V_txtTop6.setText(man.txt_AAE5[2]);
                V_txtOuter4.setText(man.txt_AAE5[3]);
                V_txtOuter5.setText(man.txt_AAE5[4]);
                V_txtOuter6.setText(man.txt_AAE5[5]);
                V_txtBottom4.setText(man.txt_AAE5[6]);
                V_txtBottom5.setText(man.txt_AAE5[7]);
                V_txtBottom6.setText(man.txt_AAE5[8]);

            }else if(result.equals("ABA")){
                // 더위적게탐 캐주얼
                V_ITopclothes4.setImageResource(man.ABA5[0]);
                V_ITopclothes5.setImageResource(man.ABA5[1]);
                V_ITopclothes6.setImageResource(man.ABA5[2]);
                V_IOuterclothes4.setImageResource(man.ABA5[3]);
                V_IOuterclothes5.setImageResource(man.ABA5[4]);
                V_IOuterclothes6.setImageResource(man.ABA5[5]);
                V_IBottomclothes4.setImageResource(man.ABA5[6]);
                V_IBottomclothes5.setImageResource(man.ABA5[7]);
                V_IBottomclothes6.setImageResource(man.ABA5[8]);
                V_txtTop4.setText(man.txt_ABA5[0]);
                V_txtTop5.setText(man.txt_ABA5[1]);
                V_txtTop6.setText(man.txt_ABA5[2]);
                V_txtOuter4.setText(man.txt_ABA5[3]);
                V_txtOuter5.setText(man.txt_ABA5[4]);
                V_txtOuter6.setText(man.txt_ABA5[5]);
                V_txtBottom4.setText(man.txt_ABA5[6]);
                V_txtBottom5.setText(man.txt_ABA5[7]);
                V_txtBottom6.setText(man.txt_ABA5[8]);

            }else if(result.equals("ABB")){
                // 더위적게탐 빈티지
                V_ITopclothes4.setImageResource(man.ABB5[0]);
                V_ITopclothes5.setImageResource(man.ABB5[1]);
                V_ITopclothes6.setImageResource(man.ABB5[2]);
                V_IOuterclothes4.setImageResource(man.ABB5[3]);
                V_IOuterclothes5.setImageResource(man.ABB5[4]);
                V_IOuterclothes6.setImageResource(man.ABB5[5]);
                V_IBottomclothes4.setImageResource(man.ABB5[6]);
                V_IBottomclothes5.setImageResource(man.ABB5[7]);
                V_IBottomclothes6.setImageResource(man.ABB5[8]);
                V_txtTop4.setText(man.txt_ABB5[0]);
                V_txtTop5.setText(man.txt_ABB5[1]);
                V_txtTop6.setText(man.txt_ABB5[2]);
                V_txtOuter4.setText(man.txt_ABB5[3]);
                V_txtOuter5.setText(man.txt_ABB5[4]);
                V_txtOuter6.setText(man.txt_ABB5[5]);
                V_txtBottom4.setText(man.txt_ABB5[6]);
                V_txtBottom5.setText(man.txt_ABB5[7]);
                V_txtBottom6.setText(man.txt_ABB5[8]);
            }else if(result.equals("ABC")){
                // 더위적게탐 스트릿
                V_ITopclothes4.setImageResource(man.ABC5[0]);
                V_ITopclothes5.setImageResource(man.ABC5[1]);
                V_ITopclothes6.setImageResource(man.ABC5[2]);
                V_IOuterclothes4.setImageResource(man.ABC5[3]);
                V_IOuterclothes5.setImageResource(man.ABC5[4]);
                V_IOuterclothes6.setImageResource(man.ABC5[5]);
                V_IBottomclothes4.setImageResource(man.ABC5[6]);
                V_IBottomclothes5.setImageResource(man.ABC5[7]);
                V_IBottomclothes6.setImageResource(man.ABC5[8]);
                V_txtTop4.setText(man.txt_ABC5[0]);
                V_txtTop5.setText(man.txt_ABC5[1]);
                V_txtTop6.setText(man.txt_ABC5[2]);
                V_txtOuter4.setText(man.txt_ABC5[3]);
                V_txtOuter5.setText(man.txt_ABC5[4]);
                V_txtOuter6.setText(man.txt_ABC5[5]);
                V_txtBottom4.setText(man.txt_ABC5[6]);
                V_txtBottom5.setText(man.txt_ABC5[7]);
                V_txtBottom6.setText(man.txt_ABC5[8]);
            }else if(result.equals("ABD")){
                // 더위적게탐 댄디
                V_ITopclothes4.setImageResource(man.ABD5[0]);
                V_ITopclothes5.setImageResource(man.ABD5[1]);
                V_ITopclothes6.setImageResource(man.ABD5[2]);
                V_IOuterclothes4.setImageResource(man.ABD5[3]);
                V_IOuterclothes5.setImageResource(man.ABD5[4]);
                V_IOuterclothes6.setImageResource(man.ABD5[5]);
                V_IBottomclothes4.setImageResource(man.ABD5[6]);
                V_IBottomclothes5.setImageResource(man.ABD5[7]);
                V_IBottomclothes6.setImageResource(man.ABD5[8]);
                V_txtTop4.setText(man.txt_ABD5[0]);
                V_txtTop5.setText(man.txt_ABD5[1]);
                V_txtTop6.setText(man.txt_ABD5[2]);
                V_txtOuter4.setText(man.txt_ABD5[3]);
                V_txtOuter5.setText(man.txt_ABD5[4]);
                V_txtOuter6.setText(man.txt_ABD5[5]);
                V_txtBottom4.setText(man.txt_ABD5[6]);
                V_txtBottom5.setText(man.txt_ABD5[7]);
                V_txtBottom6.setText(man.txt_ABD5[8]);

            }else{
                // ABE 더위적게탐 스포티
                V_ITopclothes4.setImageResource(man.ABE5[0]);
                V_ITopclothes5.setImageResource(man.ABE5[1]);
                V_ITopclothes6.setImageResource(man.ABE5[2]);
                V_IOuterclothes4.setImageResource(man.ABE5[3]);
                V_IOuterclothes5.setImageResource(man.ABE5[4]);
                V_IOuterclothes6.setImageResource(man.ABE5[5]);
                V_IBottomclothes4.setImageResource(man.ABE5[6]);
                V_IBottomclothes5.setImageResource(man.ABE5[7]);
                V_IBottomclothes6.setImageResource(man.ABE5[8]);
                V_txtTop4.setText(man.txt_ABE5[0]);
                V_txtTop5.setText(man.txt_ABE5[1]);
                V_txtTop6.setText(man.txt_ABE5[2]);
                V_txtOuter4.setText(man.txt_ABE5[3]);
                V_txtOuter5.setText(man.txt_ABE5[4]);
                V_txtOuter6.setText(man.txt_ABE5[5]);
                V_txtBottom4.setText(man.txt_ABE5[6]);
                V_txtBottom5.setText(man.txt_ABE5[7]);
                V_txtBottom6.setText(man.txt_ABE5[8]);
            }
        }else if(low_temp == 9){
            if(result.equals("AAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes4.setImageResource(man.AAA9[0]);
                V_ITopclothes5.setImageResource(man.AAA9[1]);
                V_ITopclothes6.setImageResource(man.AAA9[2]);
                V_IOuterclothes4.setImageResource(man.AAA9[3]);
                V_IOuterclothes5.setImageResource(man.AAA9[4]);
                V_IOuterclothes6.setImageResource(man.AAA9[5]);
                V_IBottomclothes4.setImageResource(man.AAA9[6]);
                V_IBottomclothes5.setImageResource(man.AAA9[7]);
                V_IBottomclothes6.setImageResource(man.AAA9[8]);
                V_txtTop4.setText(man.txt_AAA9[0]);
                V_txtTop5.setText(man.txt_AAA9[1]);
                V_txtTop6.setText(man.txt_AAA9[2]);
                V_txtOuter4.setText(man.txt_AAA9[3]);
                V_txtOuter5.setText(man.txt_AAA9[4]);
                V_txtOuter6.setText(man.txt_AAA9[5]);
                V_txtBottom4.setText(man.txt_AAA9[6]);
                V_txtBottom5.setText(man.txt_AAA9[7]);
                V_txtBottom6.setText(man.txt_AAA9[8]);

            }else if(result.equals("AAB")){
                // 더위많이탐 빈티지
                V_ITopclothes4.setImageResource(man.AAB9[0]);
                V_ITopclothes5.setImageResource(man.AAB9[1]);
                V_ITopclothes6.setImageResource(man.AAB9[2]);
                V_IOuterclothes4.setImageResource(man.AAB9[3]);
                V_IOuterclothes5.setImageResource(man.AAB9[4]);
                V_IOuterclothes6.setImageResource(man.AAB9[5]);
                V_IBottomclothes4.setImageResource(man.AAB9[6]);
                V_IBottomclothes5.setImageResource(man.AAB9[7]);
                V_IBottomclothes6.setImageResource(man.AAB9[8]);
                V_txtTop4.setText(man.txt_AAB9[0]);
                V_txtTop5.setText(man.txt_AAB9[1]);
                V_txtTop6.setText(man.txt_AAB9[2]);
                V_txtOuter4.setText(man.txt_AAB9[3]);
                V_txtOuter5.setText(man.txt_AAB9[4]);
                V_txtOuter6.setText(man.txt_AAB9[5]);
                V_txtBottom4.setText(man.txt_AAB9[6]);
                V_txtBottom5.setText(man.txt_AAB9[7]);
                V_txtBottom6.setText(man.txt_AAB9[8]);
            }else if(result.equals("AAC")){
                // 더위많이탐 스트릿
                V_ITopclothes4.setImageResource(man.AAC9[0]);
                V_ITopclothes5.setImageResource(man.AAC9[1]);
                V_ITopclothes6.setImageResource(man.AAC9[2]);
                V_IOuterclothes4.setImageResource(man.AAC9[3]);
                V_IOuterclothes5.setImageResource(man.AAC9[4]);
                V_IOuterclothes6.setImageResource(man.AAC9[5]);
                V_IBottomclothes4.setImageResource(man.AAC9[6]);
                V_IBottomclothes5.setImageResource(man.AAC9[7]);
                V_IBottomclothes6.setImageResource(man.AAC9[8]);
                V_txtTop4.setText(man.txt_AAC9[0]);
                V_txtTop5.setText(man.txt_AAC9[1]);
                V_txtTop6.setText(man.txt_AAC9[2]);
                V_txtOuter4.setText(man.txt_AAC9[3]);
                V_txtOuter5.setText(man.txt_AAC9[4]);
                V_txtOuter6.setText(man.txt_AAC9[5]);
                V_txtBottom4.setText(man.txt_AAC9[6]);
                V_txtBottom5.setText(man.txt_AAC9[7]);
                V_txtBottom6.setText(man.txt_AAC9[8]);
            }else if(result.equals("AAD")){
                // 더위많이탐 댄디
                V_ITopclothes4.setImageResource(man.AAD9[0]);
                V_ITopclothes5.setImageResource(man.AAD9[1]);
                V_ITopclothes6.setImageResource(man.AAD9[2]);
                V_IOuterclothes4.setImageResource(man.AAD9[3]);
                V_IOuterclothes5.setImageResource(man.AAD9[4]);
                V_IOuterclothes6.setImageResource(man.AAD9[5]);
                V_IBottomclothes4.setImageResource(man.AAD9[6]);
                V_IBottomclothes5.setImageResource(man.AAD9[7]);
                V_IBottomclothes6.setImageResource(man.AAD9[8]);
                V_txtTop4.setText(man.txt_AAD9[0]);
                V_txtTop5.setText(man.txt_AAD9[1]);
                V_txtTop6.setText(man.txt_AAD9[2]);
                V_txtOuter4.setText(man.txt_AAD9[3]);
                V_txtOuter5.setText(man.txt_AAD9[4]);
                V_txtOuter6.setText(man.txt_AAD9[5]);
                V_txtBottom4.setText(man.txt_AAD9[6]);
                V_txtBottom5.setText(man.txt_AAD9[7]);
                V_txtBottom6.setText(man.txt_AAD9[8]);

            }else if(result.equals("AAE")){
                // 더위많이탐 스포티
                V_ITopclothes4.setImageResource(man.AAE9[0]);
                V_ITopclothes5.setImageResource(man.AAE9[1]);
                V_ITopclothes6.setImageResource(man.AAE9[2]);
                V_IOuterclothes4.setImageResource(man.AAE9[3]);
                V_IOuterclothes5.setImageResource(man.AAE9[4]);
                V_IOuterclothes6.setImageResource(man.AAE9[5]);
                V_IBottomclothes4.setImageResource(man.AAE9[6]);
                V_IBottomclothes5.setImageResource(man.AAE9[7]);
                V_IBottomclothes6.setImageResource(man.AAE9[8]);
                V_txtTop4.setText(man.txt_AAE9[0]);
                V_txtTop5.setText(man.txt_AAE9[1]);
                V_txtTop6.setText(man.txt_AAE9[2]);
                V_txtOuter4.setText(man.txt_AAE9[3]);
                V_txtOuter5.setText(man.txt_AAE9[4]);
                V_txtOuter6.setText(man.txt_AAE9[5]);
                V_txtBottom4.setText(man.txt_AAE9[6]);
                V_txtBottom5.setText(man.txt_AAE9[7]);
                V_txtBottom6.setText(man.txt_AAE9[8]);

            }else if(result.equals("ABA")){
                // 더위적게탐 캐주얼
                V_ITopclothes4.setImageResource(man.ABA9[0]);
                V_ITopclothes5.setImageResource(man.ABA9[1]);
                V_ITopclothes6.setImageResource(man.ABA9[2]);
                V_IOuterclothes4.setImageResource(man.ABA9[3]);
                V_IOuterclothes5.setImageResource(man.ABA9[4]);
                V_IOuterclothes6.setImageResource(man.ABA9[5]);
                V_IBottomclothes4.setImageResource(man.ABA9[6]);
                V_IBottomclothes5.setImageResource(man.ABA9[7]);
                V_IBottomclothes6.setImageResource(man.ABA9[8]);
                V_txtTop4.setText(man.txt_ABA9[0]);
                V_txtTop5.setText(man.txt_ABA9[1]);
                V_txtTop6.setText(man.txt_ABA9[2]);
                V_txtOuter4.setText(man.txt_ABA9[3]);
                V_txtOuter5.setText(man.txt_ABA9[4]);
                V_txtOuter6.setText(man.txt_ABA9[5]);
                V_txtBottom4.setText(man.txt_ABA9[6]);
                V_txtBottom5.setText(man.txt_ABA9[7]);
                V_txtBottom6.setText(man.txt_ABA9[8]);

            }else if(result.equals("ABB")){
                // 더위적게탐 빈티지
                V_ITopclothes4.setImageResource(man.ABB9[0]);
                V_ITopclothes5.setImageResource(man.ABB9[1]);
                V_ITopclothes6.setImageResource(man.ABB9[2]);
                V_IOuterclothes4.setImageResource(man.ABB9[3]);
                V_IOuterclothes5.setImageResource(man.ABB9[4]);
                V_IOuterclothes6.setImageResource(man.ABB9[5]);
                V_IBottomclothes4.setImageResource(man.ABB9[6]);
                V_IBottomclothes5.setImageResource(man.ABB9[7]);
                V_IBottomclothes6.setImageResource(man.ABB9[8]);
                V_txtTop4.setText(man.txt_ABB9[0]);
                V_txtTop5.setText(man.txt_ABB9[1]);
                V_txtTop6.setText(man.txt_ABB9[2]);
                V_txtOuter4.setText(man.txt_ABB9[3]);
                V_txtOuter5.setText(man.txt_ABB9[4]);
                V_txtOuter6.setText(man.txt_ABB9[5]);
                V_txtBottom4.setText(man.txt_ABB9[6]);
                V_txtBottom5.setText(man.txt_ABB9[7]);
                V_txtBottom6.setText(man.txt_ABB9[8]);
            }else if(result.equals("ABC")){
                // 더위적게탐 스트릿
                V_ITopclothes4.setImageResource(man.ABC9[0]);
                V_ITopclothes5.setImageResource(man.ABC9[1]);
                V_ITopclothes6.setImageResource(man.ABC9[2]);
                V_IOuterclothes4.setImageResource(man.ABC9[3]);
                V_IOuterclothes5.setImageResource(man.ABC9[4]);
                V_IOuterclothes6.setImageResource(man.ABC9[5]);
                V_IBottomclothes4.setImageResource(man.ABC9[6]);
                V_IBottomclothes5.setImageResource(man.ABC9[7]);
                V_IBottomclothes6.setImageResource(man.ABC9[8]);
                V_txtTop4.setText(man.txt_ABC9[0]);
                V_txtTop5.setText(man.txt_ABC9[1]);
                V_txtTop6.setText(man.txt_ABC9[2]);
                V_txtOuter4.setText(man.txt_ABC9[3]);
                V_txtOuter5.setText(man.txt_ABC9[4]);
                V_txtOuter6.setText(man.txt_ABC9[5]);
                V_txtBottom4.setText(man.txt_ABC9[6]);
                V_txtBottom5.setText(man.txt_ABC9[7]);
                V_txtBottom6.setText(man.txt_ABC9[8]);
            }else if(result.equals("ABD")){
                // 더위적게탐 댄디
                V_ITopclothes4.setImageResource(man.ABD9[0]);
                V_ITopclothes5.setImageResource(man.ABD9[1]);
                V_ITopclothes6.setImageResource(man.ABD9[2]);
                V_IOuterclothes4.setImageResource(man.ABD9[3]);
                V_IOuterclothes5.setImageResource(man.ABD9[4]);
                V_IOuterclothes6.setImageResource(man.ABD9[5]);
                V_IBottomclothes4.setImageResource(man.ABD9[6]);
                V_IBottomclothes5.setImageResource(man.ABD9[7]);
                V_IBottomclothes6.setImageResource(man.ABD9[8]);
                V_txtTop4.setText(man.txt_ABD9[0]);
                V_txtTop5.setText(man.txt_ABD9[1]);
                V_txtTop6.setText(man.txt_ABD9[2]);
                V_txtOuter4.setText(man.txt_ABD9[3]);
                V_txtOuter5.setText(man.txt_ABD9[4]);
                V_txtOuter6.setText(man.txt_ABD9[5]);
                V_txtBottom4.setText(man.txt_ABD9[6]);
                V_txtBottom5.setText(man.txt_ABD9[7]);
                V_txtBottom6.setText(man.txt_ABD9[8]);

            }else{
                // ABE 더위적게탐 스포티
                V_ITopclothes4.setImageResource(man.ABE9[0]);
                V_ITopclothes5.setImageResource(man.ABE9[1]);
                V_ITopclothes6.setImageResource(man.ABE9[2]);
                V_IOuterclothes4.setImageResource(man.ABE9[3]);
                V_IOuterclothes5.setImageResource(man.ABE9[4]);
                V_IOuterclothes6.setImageResource(man.ABE9[5]);
                V_IBottomclothes4.setImageResource(man.ABE9[6]);
                V_IBottomclothes5.setImageResource(man.ABE9[7]);
                V_IBottomclothes6.setImageResource(man.ABE9[8]);
                V_txtTop4.setText(man.txt_ABE9[0]);
                V_txtTop5.setText(man.txt_ABE9[1]);
                V_txtTop6.setText(man.txt_ABE9[2]);
                V_txtOuter4.setText(man.txt_ABE9[3]);
                V_txtOuter5.setText(man.txt_ABE9[4]);
                V_txtOuter6.setText(man.txt_ABE9[5]);
                V_txtBottom4.setText(man.txt_ABE9[6]);
                V_txtBottom5.setText(man.txt_ABE9[7]);
                V_txtBottom6.setText(man.txt_ABE9[8]);
            }
        }else if(low_temp == 12){
            if(result.equals("AAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes4.setImageResource(man.AAA12[0]);
                V_ITopclothes5.setImageResource(man.AAA12[1]);
                V_ITopclothes6.setImageResource(man.AAA12[2]);
                V_IOuterclothes4.setImageResource(man.AAA12[3]);
                V_IOuterclothes5.setImageResource(man.AAA12[4]);
                V_IOuterclothes6.setImageResource(man.AAA12[5]);
                V_IBottomclothes4.setImageResource(man.AAA12[6]);
                V_IBottomclothes5.setImageResource(man.AAA12[7]);
                V_IBottomclothes6.setImageResource(man.AAA12[8]);
                V_txtTop4.setText(man.txt_AAA12[0]);
                V_txtTop5.setText(man.txt_AAA12[1]);
                V_txtTop6.setText(man.txt_AAA12[2]);
                V_txtOuter4.setText(man.txt_AAA12[3]);
                V_txtOuter5.setText(man.txt_AAA12[4]);
                V_txtOuter6.setText(man.txt_AAA12[5]);
                V_txtBottom4.setText(man.txt_AAA12[6]);
                V_txtBottom5.setText(man.txt_AAA12[7]);
                V_txtBottom6.setText(man.txt_AAA12[8]);

            }else if(result.equals("AAB")){
                // 더위많이탐 빈티지
                V_ITopclothes4.setImageResource(man.AAB12[0]);
                V_ITopclothes5.setImageResource(man.AAB12[1]);
                V_ITopclothes6.setImageResource(man.AAB12[2]);
                V_IOuterclothes4.setImageResource(man.AAB12[3]);
                V_IOuterclothes5.setImageResource(man.AAB12[4]);
                V_IOuterclothes6.setImageResource(man.AAB12[5]);
                V_IBottomclothes4.setImageResource(man.AAB12[6]);
                V_IBottomclothes5.setImageResource(man.AAB12[7]);
                V_IBottomclothes6.setImageResource(man.AAB12[8]);
                V_txtTop4.setText(man.txt_AAB12[0]);
                V_txtTop5.setText(man.txt_AAB12[1]);
                V_txtTop6.setText(man.txt_AAB12[2]);
                V_txtOuter4.setText(man.txt_AAB12[3]);
                V_txtOuter5.setText(man.txt_AAB12[4]);
                V_txtOuter6.setText(man.txt_AAB12[5]);
                V_txtBottom4.setText(man.txt_AAB12[6]);
                V_txtBottom5.setText(man.txt_AAB12[7]);
                V_txtBottom6.setText(man.txt_AAB12[8]);
            }else if(result.equals("AAC")){
                // 더위많이탐 스트릿
                V_ITopclothes4.setImageResource(man.AAC12[0]);
                V_ITopclothes5.setImageResource(man.AAC12[1]);
                V_ITopclothes6.setImageResource(man.AAC12[2]);
                V_IOuterclothes4.setImageResource(man.AAC12[3]);
                V_IOuterclothes5.setImageResource(man.AAC12[4]);
                V_IOuterclothes6.setImageResource(man.AAC12[5]);
                V_IBottomclothes4.setImageResource(man.AAC12[6]);
                V_IBottomclothes5.setImageResource(man.AAC12[7]);
                V_IBottomclothes6.setImageResource(man.AAC12[8]);
                V_txtTop4.setText(man.txt_AAC12[0]);
                V_txtTop5.setText(man.txt_AAC12[1]);
                V_txtTop6.setText(man.txt_AAC12[2]);
                V_txtOuter4.setText(man.txt_AAC12[3]);
                V_txtOuter5.setText(man.txt_AAC12[4]);
                V_txtOuter6.setText(man.txt_AAC12[5]);
                V_txtBottom4.setText(man.txt_AAC12[6]);
                V_txtBottom5.setText(man.txt_AAC12[7]);
                V_txtBottom6.setText(man.txt_AAC12[8]);
            }else if(result.equals("AAD")){
                // 더위많이탐 댄디
                V_ITopclothes4.setImageResource(man.AAD12[0]);
                V_ITopclothes5.setImageResource(man.AAD12[1]);
                V_ITopclothes6.setImageResource(man.AAD12[2]);
                V_IOuterclothes4.setImageResource(man.AAD12[3]);
                V_IOuterclothes5.setImageResource(man.AAD12[4]);
                V_IOuterclothes6.setImageResource(man.AAD12[5]);
                V_IBottomclothes4.setImageResource(man.AAD12[6]);
                V_IBottomclothes5.setImageResource(man.AAD12[7]);
                V_IBottomclothes6.setImageResource(man.AAD12[8]);
                V_txtTop4.setText(man.txt_AAD12[0]);
                V_txtTop5.setText(man.txt_AAD12[1]);
                V_txtTop6.setText(man.txt_AAD12[2]);
                V_txtOuter4.setText(man.txt_AAD12[3]);
                V_txtOuter5.setText(man.txt_AAD12[4]);
                V_txtOuter6.setText(man.txt_AAD12[5]);
                V_txtBottom4.setText(man.txt_AAD12[6]);
                V_txtBottom5.setText(man.txt_AAD12[7]);
                V_txtBottom6.setText(man.txt_AAD12[8]);

            }else if(result.equals("AAE")){
                // 더위많이탐 스포티
                V_ITopclothes4.setImageResource(man.AAE12[0]);
                V_ITopclothes5.setImageResource(man.AAE12[1]);
                V_ITopclothes6.setImageResource(man.AAE12[2]);
                V_IOuterclothes4.setImageResource(man.AAE12[3]);
                V_IOuterclothes5.setImageResource(man.AAE12[4]);
                V_IOuterclothes6.setImageResource(man.AAE12[5]);
                V_IBottomclothes4.setImageResource(man.AAE12[6]);
                V_IBottomclothes5.setImageResource(man.AAE12[7]);
                V_IBottomclothes6.setImageResource(man.AAE12[8]);
                V_txtTop4.setText(man.txt_AAE12[0]);
                V_txtTop5.setText(man.txt_AAE12[1]);
                V_txtTop6.setText(man.txt_AAE12[2]);
                V_txtOuter4.setText(man.txt_AAE12[3]);
                V_txtOuter5.setText(man.txt_AAE12[4]);
                V_txtOuter6.setText(man.txt_AAE12[5]);
                V_txtBottom4.setText(man.txt_AAE12[6]);
                V_txtBottom5.setText(man.txt_AAE12[7]);
                V_txtBottom6.setText(man.txt_AAE12[8]);

            }else if(result.equals("ABA")){
                // 더위적게탐 캐주얼
                V_ITopclothes4.setImageResource(man.ABA12[0]);
                V_ITopclothes5.setImageResource(man.ABA12[1]);
                V_ITopclothes6.setImageResource(man.ABA12[2]);
                V_IOuterclothes4.setImageResource(man.ABA12[3]);
                V_IOuterclothes5.setImageResource(man.ABA12[4]);
                V_IOuterclothes6.setImageResource(man.ABA12[5]);
                V_IBottomclothes4.setImageResource(man.ABA12[6]);
                V_IBottomclothes5.setImageResource(man.ABA12[7]);
                V_IBottomclothes6.setImageResource(man.ABA12[8]);
                V_txtTop4.setText(man.txt_ABA12[0]);
                V_txtTop5.setText(man.txt_ABA12[1]);
                V_txtTop6.setText(man.txt_ABA12[2]);
                V_txtOuter4.setText(man.txt_ABA12[3]);
                V_txtOuter5.setText(man.txt_ABA12[4]);
                V_txtOuter6.setText(man.txt_ABA12[5]);
                V_txtBottom4.setText(man.txt_ABA12[6]);
                V_txtBottom5.setText(man.txt_ABA12[7]);
                V_txtBottom6.setText(man.txt_ABA12[8]);

            }else if(result.equals("ABB")){
                // 더위적게탐 빈티지
                V_ITopclothes4.setImageResource(man.ABB12[0]);
                V_ITopclothes5.setImageResource(man.ABB12[1]);
                V_ITopclothes6.setImageResource(man.ABB12[2]);
                V_IOuterclothes4.setImageResource(man.ABB12[3]);
                V_IOuterclothes5.setImageResource(man.ABB12[4]);
                V_IOuterclothes6.setImageResource(man.ABB12[5]);
                V_IBottomclothes4.setImageResource(man.ABB12[6]);
                V_IBottomclothes5.setImageResource(man.ABB12[7]);
                V_IBottomclothes6.setImageResource(man.ABB12[8]);
                V_txtTop4.setText(man.txt_ABB12[0]);
                V_txtTop5.setText(man.txt_ABB12[1]);
                V_txtTop6.setText(man.txt_ABB12[2]);
                V_txtOuter4.setText(man.txt_ABB12[3]);
                V_txtOuter5.setText(man.txt_ABB12[4]);
                V_txtOuter6.setText(man.txt_ABB12[5]);
                V_txtBottom4.setText(man.txt_ABB12[6]);
                V_txtBottom5.setText(man.txt_ABB12[7]);
                V_txtBottom6.setText(man.txt_ABB12[8]);
            }else if(result.equals("ABC")){
                // 더위적게탐 스트릿
                V_ITopclothes4.setImageResource(man.ABC12[0]);
                V_ITopclothes5.setImageResource(man.ABC12[1]);
                V_ITopclothes6.setImageResource(man.ABC12[2]);
                V_IOuterclothes4.setImageResource(man.ABC12[3]);
                V_IOuterclothes5.setImageResource(man.ABC12[4]);
                V_IOuterclothes6.setImageResource(man.ABC12[5]);
                V_IBottomclothes4.setImageResource(man.ABC12[6]);
                V_IBottomclothes5.setImageResource(man.ABC12[7]);
                V_IBottomclothes6.setImageResource(man.ABC12[8]);
                V_txtTop4.setText(man.txt_ABC12[0]);
                V_txtTop5.setText(man.txt_ABC12[1]);
                V_txtTop6.setText(man.txt_ABC12[2]);
                V_txtOuter4.setText(man.txt_ABC12[3]);
                V_txtOuter5.setText(man.txt_ABC12[4]);
                V_txtOuter6.setText(man.txt_ABC12[5]);
                V_txtBottom4.setText(man.txt_ABC12[6]);
                V_txtBottom5.setText(man.txt_ABC12[7]);
                V_txtBottom6.setText(man.txt_ABC12[8]);
            }else if(result.equals("ABD")){
                // 더위적게탐 댄디
                V_ITopclothes4.setImageResource(man.ABD12[0]);
                V_ITopclothes5.setImageResource(man.ABD12[1]);
                V_ITopclothes6.setImageResource(man.ABD12[2]);
                V_IOuterclothes4.setImageResource(man.ABD12[3]);
                V_IOuterclothes5.setImageResource(man.ABD12[4]);
                V_IOuterclothes6.setImageResource(man.ABD12[5]);
                V_IBottomclothes4.setImageResource(man.ABD12[6]);
                V_IBottomclothes5.setImageResource(man.ABD12[7]);
                V_IBottomclothes6.setImageResource(man.ABD12[8]);
                V_txtTop4.setText(man.txt_ABD12[0]);
                V_txtTop5.setText(man.txt_ABD12[1]);
                V_txtTop6.setText(man.txt_ABD12[2]);
                V_txtOuter4.setText(man.txt_ABD12[3]);
                V_txtOuter5.setText(man.txt_ABD12[4]);
                V_txtOuter6.setText(man.txt_ABD12[5]);
                V_txtBottom4.setText(man.txt_ABD12[6]);
                V_txtBottom5.setText(man.txt_ABD12[7]);
                V_txtBottom6.setText(man.txt_ABD12[8]);

            }else{
                // ABE 더위적게탐 스포티
                V_ITopclothes4.setImageResource(man.ABE12[0]);
                V_ITopclothes5.setImageResource(man.ABE12[1]);
                V_ITopclothes6.setImageResource(man.ABE12[2]);
                V_IOuterclothes4.setImageResource(man.ABE12[3]);
                V_IOuterclothes5.setImageResource(man.ABE12[4]);
                V_IOuterclothes6.setImageResource(man.ABE12[5]);
                V_IBottomclothes4.setImageResource(man.ABE12[6]);
                V_IBottomclothes5.setImageResource(man.ABE12[7]);
                V_IBottomclothes6.setImageResource(man.ABE12[8]);
                V_txtTop4.setText(man.txt_ABE12[0]);
                V_txtTop5.setText(man.txt_ABE12[1]);
                V_txtTop6.setText(man.txt_ABE12[2]);
                V_txtOuter4.setText(man.txt_ABE12[3]);
                V_txtOuter5.setText(man.txt_ABE12[4]);
                V_txtOuter6.setText(man.txt_ABE12[5]);
                V_txtBottom4.setText(man.txt_ABE12[6]);
                V_txtBottom5.setText(man.txt_ABE12[7]);
                V_txtBottom6.setText(man.txt_ABE12[8]);
            }
        }else if(low_temp == 17){
            if(result.equals("AAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes4.setImageResource(man.AAA17[0]);
                V_ITopclothes5.setImageResource(man.AAA17[1]);
                V_ITopclothes6.setImageResource(man.AAA17[2]);
                V_IOuterclothes4.setImageResource(man.AAA17[3]);
                V_IOuterclothes5.setImageResource(man.AAA17[4]);
                V_IOuterclothes6.setImageResource(man.AAA17[5]);
                V_IBottomclothes4.setImageResource(man.AAA17[6]);
                V_IBottomclothes5.setImageResource(man.AAA17[7]);
                V_IBottomclothes6.setImageResource(man.AAA17[8]);
                V_txtTop4.setText(man.txt_AAA17[0]);
                V_txtTop5.setText(man.txt_AAA17[1]);
                V_txtTop6.setText(man.txt_AAA17[2]);
                V_txtOuter4.setText(man.txt_AAA17[3]);
                V_txtOuter5.setText(man.txt_AAA17[4]);
                V_txtOuter6.setText(man.txt_AAA17[5]);
                V_txtBottom4.setText(man.txt_AAA17[6]);
                V_txtBottom5.setText(man.txt_AAA17[7]);
                V_txtBottom6.setText(man.txt_AAA17[8]);

            }else if(result.equals("AAB")){
                // 더위많이탐 빈티지
                V_ITopclothes4.setImageResource(man.AAB17[0]);
                V_ITopclothes5.setImageResource(man.AAB17[1]);
                V_ITopclothes6.setImageResource(man.AAB17[2]);
                V_IOuterclothes4.setImageResource(man.AAB17[3]);
                V_IOuterclothes5.setImageResource(man.AAB17[4]);
                V_IOuterclothes6.setImageResource(man.AAB17[5]);
                V_IBottomclothes4.setImageResource(man.AAB17[6]);
                V_IBottomclothes5.setImageResource(man.AAB17[7]);
                V_IBottomclothes6.setImageResource(man.AAB17[8]);
                V_txtTop4.setText(man.txt_AAB17[0]);
                V_txtTop5.setText(man.txt_AAB17[1]);
                V_txtTop6.setText(man.txt_AAB17[2]);
                V_txtOuter4.setText(man.txt_AAB17[3]);
                V_txtOuter5.setText(man.txt_AAB17[4]);
                V_txtOuter6.setText(man.txt_AAB17[5]);
                V_txtBottom4.setText(man.txt_AAB17[6]);
                V_txtBottom5.setText(man.txt_AAB17[7]);
                V_txtBottom6.setText(man.txt_AAB17[8]);
            }else if(result.equals("AAC")){
                // 더위많이탐 스트릿
                V_ITopclothes4.setImageResource(man.AAC17[0]);
                V_ITopclothes5.setImageResource(man.AAC17[1]);
                V_ITopclothes6.setImageResource(man.AAC17[2]);
                V_IOuterclothes4.setImageResource(man.AAC17[3]);
                V_IOuterclothes5.setImageResource(man.AAC17[4]);
                V_IOuterclothes6.setImageResource(man.AAC17[5]);
                V_IBottomclothes4.setImageResource(man.AAC17[6]);
                V_IBottomclothes5.setImageResource(man.AAC17[7]);
                V_IBottomclothes6.setImageResource(man.AAC17[8]);
                V_txtTop4.setText(man.txt_AAC17[0]);
                V_txtTop5.setText(man.txt_AAC17[1]);
                V_txtTop6.setText(man.txt_AAC17[2]);
                V_txtOuter4.setText(man.txt_AAC17[3]);
                V_txtOuter5.setText(man.txt_AAC17[4]);
                V_txtOuter6.setText(man.txt_AAC17[5]);
                V_txtBottom4.setText(man.txt_AAC17[6]);
                V_txtBottom5.setText(man.txt_AAC17[7]);
                V_txtBottom6.setText(man.txt_AAC17[8]);
            }else if(result.equals("AAD")){
                // 더위많이탐 댄디
                V_ITopclothes4.setImageResource(man.AAD17[0]);
                V_ITopclothes5.setImageResource(man.AAD17[1]);
                V_ITopclothes6.setImageResource(man.AAD17[2]);
                V_IOuterclothes4.setImageResource(man.AAD17[3]);
                V_IOuterclothes5.setImageResource(man.AAD17[4]);
                V_IOuterclothes6.setImageResource(man.AAD17[5]);
                V_IBottomclothes4.setImageResource(man.AAD17[6]);
                V_IBottomclothes5.setImageResource(man.AAD17[7]);
                V_IBottomclothes6.setImageResource(man.AAD17[8]);
                V_txtTop4.setText(man.txt_AAD17[0]);
                V_txtTop5.setText(man.txt_AAD17[1]);
                V_txtTop6.setText(man.txt_AAD17[2]);
                V_txtOuter4.setText(man.txt_AAD17[3]);
                V_txtOuter5.setText(man.txt_AAD17[4]);
                V_txtOuter6.setText(man.txt_AAD17[5]);
                V_txtBottom4.setText(man.txt_AAD17[6]);
                V_txtBottom5.setText(man.txt_AAD17[7]);
                V_txtBottom6.setText(man.txt_AAD17[8]);

            }else if(result.equals("AAE")){
                // 더위많이탐 스포티
                V_ITopclothes4.setImageResource(man.AAE17[0]);
                V_ITopclothes5.setImageResource(man.AAE17[1]);
                V_ITopclothes6.setImageResource(man.AAE17[2]);
                V_IOuterclothes4.setImageResource(man.AAE17[3]);
                V_IOuterclothes5.setImageResource(man.AAE17[4]);
                V_IOuterclothes6.setImageResource(man.AAE17[5]);
                V_IBottomclothes4.setImageResource(man.AAE17[6]);
                V_IBottomclothes5.setImageResource(man.AAE17[7]);
                V_IBottomclothes6.setImageResource(man.AAE17[8]);
                V_txtTop4.setText(man.txt_AAE17[0]);
                V_txtTop5.setText(man.txt_AAE17[1]);
                V_txtTop6.setText(man.txt_AAE17[2]);
                V_txtOuter4.setText(man.txt_AAE17[3]);
                V_txtOuter5.setText(man.txt_AAE17[4]);
                V_txtOuter6.setText(man.txt_AAE17[5]);
                V_txtBottom4.setText(man.txt_AAE17[6]);
                V_txtBottom5.setText(man.txt_AAE17[7]);
                V_txtBottom6.setText(man.txt_AAE17[8]);

            }else if(result.equals("ABA")){
                // 더위적게탐 캐주얼
                V_ITopclothes4.setImageResource(man.ABA17[0]);
                V_ITopclothes5.setImageResource(man.ABA17[1]);
                V_ITopclothes6.setImageResource(man.ABA17[2]);
                V_IOuterclothes4.setImageResource(man.ABA17[3]);
                V_IOuterclothes5.setImageResource(man.ABA17[4]);
                V_IOuterclothes6.setImageResource(man.ABA17[5]);
                V_IBottomclothes4.setImageResource(man.ABA17[6]);
                V_IBottomclothes5.setImageResource(man.ABA17[7]);
                V_IBottomclothes6.setImageResource(man.ABA17[8]);
                V_txtTop4.setText(man.txt_ABA17[0]);
                V_txtTop5.setText(man.txt_ABA17[1]);
                V_txtTop6.setText(man.txt_ABA17[2]);
                V_txtOuter4.setText(man.txt_ABA17[3]);
                V_txtOuter5.setText(man.txt_ABA17[4]);
                V_txtOuter6.setText(man.txt_ABA17[5]);
                V_txtBottom4.setText(man.txt_ABA17[6]);
                V_txtBottom5.setText(man.txt_ABA17[7]);
                V_txtBottom6.setText(man.txt_ABA17[8]);

            }else if(result.equals("ABB")){
                // 더위적게탐 빈티지
                V_ITopclothes4.setImageResource(man.ABB17[0]);
                V_ITopclothes5.setImageResource(man.ABB17[1]);
                V_ITopclothes6.setImageResource(man.ABB17[2]);
                V_IOuterclothes4.setImageResource(man.ABB17[3]);
                V_IOuterclothes5.setImageResource(man.ABB17[4]);
                V_IOuterclothes6.setImageResource(man.ABB17[5]);
                V_IBottomclothes4.setImageResource(man.ABB17[6]);
                V_IBottomclothes5.setImageResource(man.ABB17[7]);
                V_IBottomclothes6.setImageResource(man.ABB17[8]);
                V_txtTop4.setText(man.txt_ABB17[0]);
                V_txtTop5.setText(man.txt_ABB17[1]);
                V_txtTop6.setText(man.txt_ABB17[2]);
                V_txtOuter4.setText(man.txt_ABB17[3]);
                V_txtOuter5.setText(man.txt_ABB17[4]);
                V_txtOuter6.setText(man.txt_ABB17[5]);
                V_txtBottom4.setText(man.txt_ABB17[6]);
                V_txtBottom5.setText(man.txt_ABB17[7]);
                V_txtBottom6.setText(man.txt_ABB17[8]);
            }else if(result.equals("ABC")){
                // 더위적게탐 스트릿
                V_ITopclothes4.setImageResource(man.ABC17[0]);
                V_ITopclothes5.setImageResource(man.ABC17[1]);
                V_ITopclothes6.setImageResource(man.ABC17[2]);
                V_IOuterclothes4.setImageResource(man.ABC17[3]);
                V_IOuterclothes5.setImageResource(man.ABC17[4]);
                V_IOuterclothes6.setImageResource(man.ABC17[5]);
                V_IBottomclothes4.setImageResource(man.ABC17[6]);
                V_IBottomclothes5.setImageResource(man.ABC17[7]);
                V_IBottomclothes6.setImageResource(man.ABC17[8]);
                V_txtTop4.setText(man.txt_ABC17[0]);
                V_txtTop5.setText(man.txt_ABC17[1]);
                V_txtTop6.setText(man.txt_ABC17[2]);
                V_txtOuter4.setText(man.txt_ABC17[3]);
                V_txtOuter5.setText(man.txt_ABC17[4]);
                V_txtOuter6.setText(man.txt_ABC17[5]);
                V_txtBottom4.setText(man.txt_ABC17[6]);
                V_txtBottom5.setText(man.txt_ABC17[7]);
                V_txtBottom6.setText(man.txt_ABC17[8]);
            }else if(result.equals("ABD")){
                // 더위적게탐 댄디
                V_ITopclothes4.setImageResource(man.ABD17[0]);
                V_ITopclothes5.setImageResource(man.ABD17[1]);
                V_ITopclothes6.setImageResource(man.ABD17[2]);
                V_IOuterclothes4.setImageResource(man.ABD17[3]);
                V_IOuterclothes5.setImageResource(man.ABD17[4]);
                V_IOuterclothes6.setImageResource(man.ABD17[5]);
                V_IBottomclothes4.setImageResource(man.ABD17[6]);
                V_IBottomclothes5.setImageResource(man.ABD17[7]);
                V_IBottomclothes6.setImageResource(man.ABD17[8]);
                V_txtTop4.setText(man.txt_ABD17[0]);
                V_txtTop5.setText(man.txt_ABD17[1]);
                V_txtTop6.setText(man.txt_ABD17[2]);
                V_txtOuter4.setText(man.txt_ABD17[3]);
                V_txtOuter5.setText(man.txt_ABD17[4]);
                V_txtOuter6.setText(man.txt_ABD17[5]);
                V_txtBottom4.setText(man.txt_ABD17[6]);
                V_txtBottom5.setText(man.txt_ABD17[7]);
                V_txtBottom6.setText(man.txt_ABD17[8]);

            }else{
                // ABE 더위적게탐 스포티
                V_ITopclothes4.setImageResource(man.ABE17[0]);
                V_ITopclothes5.setImageResource(man.ABE17[1]);
                V_ITopclothes6.setImageResource(man.ABE17[2]);
                V_IOuterclothes4.setImageResource(man.ABE17[3]);
                V_IOuterclothes5.setImageResource(man.ABE17[4]);
                V_IOuterclothes6.setImageResource(man.ABE17[5]);
                V_IBottomclothes4.setImageResource(man.ABE17[6]);
                V_IBottomclothes5.setImageResource(man.ABE17[7]);
                V_IBottomclothes6.setImageResource(man.ABE17[8]);
                V_txtTop4.setText(man.txt_ABE17[0]);
                V_txtTop5.setText(man.txt_ABE17[1]);
                V_txtTop6.setText(man.txt_ABE17[2]);
                V_txtOuter4.setText(man.txt_ABE17[3]);
                V_txtOuter5.setText(man.txt_ABE17[4]);
                V_txtOuter6.setText(man.txt_ABE17[5]);
                V_txtBottom4.setText(man.txt_ABE17[6]);
                V_txtBottom5.setText(man.txt_ABE17[7]);
                V_txtBottom6.setText(man.txt_ABE17[8]);
            }
        }else if(low_temp == 20){
            if(result.equals("AAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes4.setImageResource(man.AAA20[0]);
                V_ITopclothes5.setImageResource(man.AAA20[1]);
                V_ITopclothes6.setImageResource(man.AAA20[2]);
                V_IOuterclothes4.setImageResource(man.AAA20[3]);
                V_IOuterclothes5.setImageResource(man.AAA20[4]);
                V_IOuterclothes6.setImageResource(man.AAA20[5]);
                V_IBottomclothes4.setImageResource(man.AAA20[6]);
                V_IBottomclothes5.setImageResource(man.AAA20[7]);
                V_IBottomclothes6.setImageResource(man.AAA20[8]);
                V_txtTop4.setText(man.txt_AAA20[0]);
                V_txtTop5.setText(man.txt_AAA20[1]);
                V_txtTop6.setText(man.txt_AAA20[2]);
                V_txtOuter4.setText(man.txt_AAA20[3]);
                V_txtOuter5.setText(man.txt_AAA20[4]);
                V_txtOuter6.setText(man.txt_AAA20[5]);
                V_txtBottom4.setText(man.txt_AAA20[6]);
                V_txtBottom5.setText(man.txt_AAA20[7]);
                V_txtBottom6.setText(man.txt_AAA20[8]);

            }else if(result.equals("AAB")){
                // 더위많이탐 빈티지
                V_ITopclothes4.setImageResource(man.AAB20[0]);
                V_ITopclothes5.setImageResource(man.AAB20[1]);
                V_ITopclothes6.setImageResource(man.AAB20[2]);
                V_IOuterclothes4.setImageResource(man.AAB20[3]);
                V_IOuterclothes5.setImageResource(man.AAB20[4]);
                V_IOuterclothes6.setImageResource(man.AAB20[5]);
                V_IBottomclothes4.setImageResource(man.AAB20[6]);
                V_IBottomclothes5.setImageResource(man.AAB20[7]);
                V_IBottomclothes6.setImageResource(man.AAB20[8]);
                V_txtTop4.setText(man.txt_AAB20[0]);
                V_txtTop5.setText(man.txt_AAB20[1]);
                V_txtTop6.setText(man.txt_AAB20[2]);
                V_txtOuter4.setText(man.txt_AAB20[3]);
                V_txtOuter5.setText(man.txt_AAB20[4]);
                V_txtOuter6.setText(man.txt_AAB20[5]);
                V_txtBottom4.setText(man.txt_AAB20[6]);
                V_txtBottom5.setText(man.txt_AAB20[7]);
                V_txtBottom6.setText(man.txt_AAB20[8]);
            }else if(result.equals("AAC")){
                // 더위많이탐 스트릿
                V_ITopclothes4.setImageResource(man.AAC20[0]);
                V_ITopclothes5.setImageResource(man.AAC20[1]);
                V_ITopclothes6.setImageResource(man.AAC20[2]);
                V_IOuterclothes4.setImageResource(man.AAC20[3]);
                V_IOuterclothes5.setImageResource(man.AAC20[4]);
                V_IOuterclothes6.setImageResource(man.AAC20[5]);
                V_IBottomclothes4.setImageResource(man.AAC20[6]);
                V_IBottomclothes5.setImageResource(man.AAC20[7]);
                V_IBottomclothes6.setImageResource(man.AAC20[8]);
                V_txtTop4.setText(man.txt_AAC20[0]);
                V_txtTop5.setText(man.txt_AAC20[1]);
                V_txtTop6.setText(man.txt_AAC20[2]);
                V_txtOuter4.setText(man.txt_AAC20[3]);
                V_txtOuter5.setText(man.txt_AAC20[4]);
                V_txtOuter6.setText(man.txt_AAC20[5]);
                V_txtBottom4.setText(man.txt_AAC20[6]);
                V_txtBottom5.setText(man.txt_AAC20[7]);
                V_txtBottom6.setText(man.txt_AAC20[8]);
            }else if(result.equals("AAD")){
                // 더위많이탐 댄디
                V_ITopclothes4.setImageResource(man.AAD20[0]);
                V_ITopclothes5.setImageResource(man.AAD20[1]);
                V_ITopclothes6.setImageResource(man.AAD20[2]);
                V_IOuterclothes4.setImageResource(man.AAD20[3]);
                V_IOuterclothes5.setImageResource(man.AAD20[4]);
                V_IOuterclothes6.setImageResource(man.AAD20[5]);
                V_IBottomclothes4.setImageResource(man.AAD20[6]);
                V_IBottomclothes5.setImageResource(man.AAD20[7]);
                V_IBottomclothes6.setImageResource(man.AAD20[8]);
                V_txtTop4.setText(man.txt_AAD20[0]);
                V_txtTop5.setText(man.txt_AAD20[1]);
                V_txtTop6.setText(man.txt_AAD20[2]);
                V_txtOuter4.setText(man.txt_AAD20[3]);
                V_txtOuter5.setText(man.txt_AAD20[4]);
                V_txtOuter6.setText(man.txt_AAD20[5]);
                V_txtBottom4.setText(man.txt_AAD20[6]);
                V_txtBottom5.setText(man.txt_AAD20[7]);
                V_txtBottom6.setText(man.txt_AAD20[8]);

            }else if(result.equals("AAE")){
                // 더위많이탐 스포티
                V_ITopclothes4.setImageResource(man.AAE20[0]);
                V_ITopclothes5.setImageResource(man.AAE20[1]);
                V_ITopclothes6.setImageResource(man.AAE20[2]);
                V_IOuterclothes4.setImageResource(man.AAE20[3]);
                V_IOuterclothes5.setImageResource(man.AAE20[4]);
                V_IOuterclothes6.setImageResource(man.AAE20[5]);
                V_IBottomclothes4.setImageResource(man.AAE20[6]);
                V_IBottomclothes5.setImageResource(man.AAE20[7]);
                V_IBottomclothes6.setImageResource(man.AAE20[8]);
                V_txtTop4.setText(man.txt_AAE20[0]);
                V_txtTop5.setText(man.txt_AAE20[1]);
                V_txtTop6.setText(man.txt_AAE20[2]);
                V_txtOuter4.setText(man.txt_AAE20[3]);
                V_txtOuter5.setText(man.txt_AAE20[4]);
                V_txtOuter6.setText(man.txt_AAE20[5]);
                V_txtBottom4.setText(man.txt_AAE20[6]);
                V_txtBottom5.setText(man.txt_AAE20[7]);
                V_txtBottom6.setText(man.txt_AAE20[8]);

            }else if(result.equals("ABA")){
                // 더위적게탐 캐주얼
                V_ITopclothes4.setImageResource(man.ABA20[0]);
                V_ITopclothes5.setImageResource(man.ABA20[1]);
                V_ITopclothes6.setImageResource(man.ABA20[2]);
                V_IOuterclothes4.setImageResource(man.ABA20[3]);
                V_IOuterclothes5.setImageResource(man.ABA20[4]);
                V_IOuterclothes6.setImageResource(man.ABA20[5]);
                V_IBottomclothes4.setImageResource(man.ABA20[6]);
                V_IBottomclothes5.setImageResource(man.ABA20[7]);
                V_IBottomclothes6.setImageResource(man.ABA20[8]);
                V_txtTop4.setText(man.txt_ABA20[0]);
                V_txtTop5.setText(man.txt_ABA20[1]);
                V_txtTop6.setText(man.txt_ABA20[2]);
                V_txtOuter4.setText(man.txt_ABA20[3]);
                V_txtOuter5.setText(man.txt_ABA20[4]);
                V_txtOuter6.setText(man.txt_ABA20[5]);
                V_txtBottom4.setText(man.txt_ABA20[6]);
                V_txtBottom5.setText(man.txt_ABA20[7]);
                V_txtBottom6.setText(man.txt_ABA20[8]);

            }else if(result.equals("ABB")){
                // 더위적게탐 빈티지
                V_ITopclothes4.setImageResource(man.ABB20[0]);
                V_ITopclothes5.setImageResource(man.ABB20[1]);
                V_ITopclothes6.setImageResource(man.ABB20[2]);
                V_IOuterclothes4.setImageResource(man.ABB20[3]);
                V_IOuterclothes5.setImageResource(man.ABB20[4]);
                V_IOuterclothes6.setImageResource(man.ABB20[5]);
                V_IBottomclothes4.setImageResource(man.ABB20[6]);
                V_IBottomclothes5.setImageResource(man.ABB20[7]);
                V_IBottomclothes6.setImageResource(man.ABB20[8]);
                V_txtTop4.setText(man.txt_ABB20[0]);
                V_txtTop5.setText(man.txt_ABB20[1]);
                V_txtTop6.setText(man.txt_ABB20[2]);
                V_txtOuter4.setText(man.txt_ABB20[3]);
                V_txtOuter5.setText(man.txt_ABB20[4]);
                V_txtOuter6.setText(man.txt_ABB20[5]);
                V_txtBottom4.setText(man.txt_ABB20[6]);
                V_txtBottom5.setText(man.txt_ABB20[7]);
                V_txtBottom6.setText(man.txt_ABB20[8]);
            }else if(result.equals("ABC")){
                // 더위적게탐 스트릿
                V_ITopclothes4.setImageResource(man.ABC20[0]);
                V_ITopclothes5.setImageResource(man.ABC20[1]);
                V_ITopclothes6.setImageResource(man.ABC20[2]);
                V_IOuterclothes4.setImageResource(man.ABC20[3]);
                V_IOuterclothes5.setImageResource(man.ABC20[4]);
                V_IOuterclothes6.setImageResource(man.ABC20[5]);
                V_IBottomclothes4.setImageResource(man.ABC20[6]);
                V_IBottomclothes5.setImageResource(man.ABC20[7]);
                V_IBottomclothes6.setImageResource(man.ABC20[8]);
                V_txtTop4.setText(man.txt_ABC20[0]);
                V_txtTop5.setText(man.txt_ABC20[1]);
                V_txtTop6.setText(man.txt_ABC20[2]);
                V_txtOuter4.setText(man.txt_ABC20[3]);
                V_txtOuter5.setText(man.txt_ABC20[4]);
                V_txtOuter6.setText(man.txt_ABC20[5]);
                V_txtBottom4.setText(man.txt_ABC20[6]);
                V_txtBottom5.setText(man.txt_ABC20[7]);
                V_txtBottom6.setText(man.txt_ABC20[8]);
            }else if(result.equals("ABD")){
                // 더위적게탐 댄디
                V_ITopclothes4.setImageResource(man.ABD20[0]);
                V_ITopclothes5.setImageResource(man.ABD20[1]);
                V_ITopclothes6.setImageResource(man.ABD20[2]);
                V_IOuterclothes4.setImageResource(man.ABD20[3]);
                V_IOuterclothes5.setImageResource(man.ABD20[4]);
                V_IOuterclothes6.setImageResource(man.ABD20[5]);
                V_IBottomclothes4.setImageResource(man.ABD20[6]);
                V_IBottomclothes5.setImageResource(man.ABD20[7]);
                V_IBottomclothes6.setImageResource(man.ABD20[8]);
                V_txtTop4.setText(man.txt_ABD20[0]);
                V_txtTop5.setText(man.txt_ABD20[1]);
                V_txtTop6.setText(man.txt_ABD20[2]);
                V_txtOuter4.setText(man.txt_ABD20[3]);
                V_txtOuter5.setText(man.txt_ABD20[4]);
                V_txtOuter6.setText(man.txt_ABD20[5]);
                V_txtBottom4.setText(man.txt_ABD20[6]);
                V_txtBottom5.setText(man.txt_ABD20[7]);
                V_txtBottom6.setText(man.txt_ABD20[8]);

            }else{
                // ABE 더위적게탐 스포티
                V_ITopclothes4.setImageResource(man.ABE20[0]);
                V_ITopclothes5.setImageResource(man.ABE20[1]);
                V_ITopclothes6.setImageResource(man.ABE20[2]);
                V_IOuterclothes4.setImageResource(man.ABE20[3]);
                V_IOuterclothes5.setImageResource(man.ABE20[4]);
                V_IOuterclothes6.setImageResource(man.ABE20[5]);
                V_IBottomclothes4.setImageResource(man.ABE20[6]);
                V_IBottomclothes5.setImageResource(man.ABE20[7]);
                V_IBottomclothes6.setImageResource(man.ABE20[8]);
                V_txtTop4.setText(man.txt_ABE20[0]);
                V_txtTop5.setText(man.txt_ABE20[1]);
                V_txtTop6.setText(man.txt_ABE20[2]);
                V_txtOuter4.setText(man.txt_ABE20[3]);
                V_txtOuter5.setText(man.txt_ABE20[4]);
                V_txtOuter6.setText(man.txt_ABE20[5]);
                V_txtBottom4.setText(man.txt_ABE20[6]);
                V_txtBottom5.setText(man.txt_ABE20[7]);
                V_txtBottom6.setText(man.txt_ABE20[8]);
            }
        }else if(low_temp == 23){
            if(result.equals("AAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes4.setImageResource(man.AAA23[0]);
                V_ITopclothes5.setImageResource(man.AAA23[1]);
                V_ITopclothes6.setImageResource(man.AAA23[2]);
                V_IOuterclothes4.setImageResource(man.AAA23[3]);
                V_IOuterclothes5.setImageResource(man.AAA23[4]);
                V_IOuterclothes6.setImageResource(man.AAA23[5]);
                V_IBottomclothes4.setImageResource(man.AAA23[6]);
                V_IBottomclothes5.setImageResource(man.AAA23[7]);
                V_IBottomclothes6.setImageResource(man.AAA23[8]);
                V_txtTop4.setText(man.txt_AAA23[0]);
                V_txtTop5.setText(man.txt_AAA23[1]);
                V_txtTop6.setText(man.txt_AAA23[2]);
                V_txtOuter4.setText(man.txt_AAA23[3]);
                V_txtOuter5.setText(man.txt_AAA23[4]);
                V_txtOuter6.setText(man.txt_AAA23[5]);
                V_txtBottom4.setText(man.txt_AAA23[6]);
                V_txtBottom5.setText(man.txt_AAA23[7]);
                V_txtBottom6.setText(man.txt_AAA23[8]);

            }else if(result.equals("AAB")){
                // 더위많이탐 빈티지
                V_ITopclothes4.setImageResource(man.AAB23[0]);
                V_ITopclothes5.setImageResource(man.AAB23[1]);
                V_ITopclothes6.setImageResource(man.AAB23[2]);
                V_IOuterclothes4.setImageResource(man.AAB23[3]);
                V_IOuterclothes5.setImageResource(man.AAB23[4]);
                V_IOuterclothes6.setImageResource(man.AAB23[5]);
                V_IBottomclothes4.setImageResource(man.AAB23[6]);
                V_IBottomclothes5.setImageResource(man.AAB23[7]);
                V_IBottomclothes6.setImageResource(man.AAB23[8]);
                V_txtTop4.setText(man.txt_AAB23[0]);
                V_txtTop5.setText(man.txt_AAB23[1]);
                V_txtTop6.setText(man.txt_AAB23[2]);
                V_txtOuter4.setText(man.txt_AAB23[3]);
                V_txtOuter5.setText(man.txt_AAB23[4]);
                V_txtOuter6.setText(man.txt_AAB23[5]);
                V_txtBottom4.setText(man.txt_AAB23[6]);
                V_txtBottom5.setText(man.txt_AAB23[7]);
                V_txtBottom6.setText(man.txt_AAB23[8]);
            }else if(result.equals("AAC")){
                // 더위많이탐 스트릿
                V_ITopclothes4.setImageResource(man.AAC23[0]);
                V_ITopclothes5.setImageResource(man.AAC23[1]);
                V_ITopclothes6.setImageResource(man.AAC23[2]);
                V_IOuterclothes4.setImageResource(man.AAC23[3]);
                V_IOuterclothes5.setImageResource(man.AAC23[4]);
                V_IOuterclothes6.setImageResource(man.AAC23[5]);
                V_IBottomclothes4.setImageResource(man.AAC23[6]);
                V_IBottomclothes5.setImageResource(man.AAC23[7]);
                V_IBottomclothes6.setImageResource(man.AAC23[8]);
                V_txtTop4.setText(man.txt_AAC23[0]);
                V_txtTop5.setText(man.txt_AAC23[1]);
                V_txtTop6.setText(man.txt_AAC23[2]);
                V_txtOuter4.setText(man.txt_AAC23[3]);
                V_txtOuter5.setText(man.txt_AAC23[4]);
                V_txtOuter6.setText(man.txt_AAC23[5]);
                V_txtBottom4.setText(man.txt_AAC23[6]);
                V_txtBottom5.setText(man.txt_AAC23[7]);
                V_txtBottom6.setText(man.txt_AAC23[8]);
            }else if(result.equals("AAD")){
                // 더위많이탐 댄디
                V_ITopclothes4.setImageResource(man.AAD23[0]);
                V_ITopclothes5.setImageResource(man.AAD23[1]);
                V_ITopclothes6.setImageResource(man.AAD23[2]);
                V_IOuterclothes4.setImageResource(man.AAD23[3]);
                V_IOuterclothes5.setImageResource(man.AAD23[4]);
                V_IOuterclothes6.setImageResource(man.AAD23[5]);
                V_IBottomclothes4.setImageResource(man.AAD23[6]);
                V_IBottomclothes5.setImageResource(man.AAD23[7]);
                V_IBottomclothes6.setImageResource(man.AAD23[8]);
                V_txtTop4.setText(man.txt_AAD23[0]);
                V_txtTop5.setText(man.txt_AAD23[1]);
                V_txtTop6.setText(man.txt_AAD23[2]);
                V_txtOuter4.setText(man.txt_AAD23[3]);
                V_txtOuter5.setText(man.txt_AAD23[4]);
                V_txtOuter6.setText(man.txt_AAD23[5]);
                V_txtBottom4.setText(man.txt_AAD23[6]);
                V_txtBottom5.setText(man.txt_AAD23[7]);
                V_txtBottom6.setText(man.txt_AAD23[8]);

            }else if(result.equals("AAE")){
                // 더위많이탐 스포티
                V_ITopclothes4.setImageResource(man.AAE23[0]);
                V_ITopclothes5.setImageResource(man.AAE23[1]);
                V_ITopclothes6.setImageResource(man.AAE23[2]);
                V_IOuterclothes4.setImageResource(man.AAE23[3]);
                V_IOuterclothes5.setImageResource(man.AAE23[4]);
                V_IOuterclothes6.setImageResource(man.AAE23[5]);
                V_IBottomclothes4.setImageResource(man.AAE23[6]);
                V_IBottomclothes5.setImageResource(man.AAE23[7]);
                V_IBottomclothes6.setImageResource(man.AAE23[8]);
                V_txtTop4.setText(man.txt_AAE23[0]);
                V_txtTop5.setText(man.txt_AAE23[1]);
                V_txtTop6.setText(man.txt_AAE23[2]);
                V_txtOuter4.setText(man.txt_AAE23[3]);
                V_txtOuter5.setText(man.txt_AAE23[4]);
                V_txtOuter6.setText(man.txt_AAE23[5]);
                V_txtBottom4.setText(man.txt_AAE23[6]);
                V_txtBottom5.setText(man.txt_AAE23[7]);
                V_txtBottom6.setText(man.txt_AAE23[8]);

            }else if(result.equals("ABA")){
                // 더위적게탐 캐주얼
                V_ITopclothes4.setImageResource(man.ABA23[0]);
                V_ITopclothes5.setImageResource(man.ABA23[1]);
                V_ITopclothes6.setImageResource(man.ABA23[2]);
                V_IOuterclothes4.setImageResource(man.ABA23[3]);
                V_IOuterclothes5.setImageResource(man.ABA23[4]);
                V_IOuterclothes6.setImageResource(man.ABA23[5]);
                V_IBottomclothes4.setImageResource(man.ABA23[6]);
                V_IBottomclothes5.setImageResource(man.ABA23[7]);
                V_IBottomclothes6.setImageResource(man.ABA23[8]);
                V_txtTop4.setText(man.txt_ABA23[0]);
                V_txtTop5.setText(man.txt_ABA23[1]);
                V_txtTop6.setText(man.txt_ABA23[2]);
                V_txtOuter4.setText(man.txt_ABA23[3]);
                V_txtOuter5.setText(man.txt_ABA23[4]);
                V_txtOuter6.setText(man.txt_ABA23[5]);
                V_txtBottom4.setText(man.txt_ABA23[6]);
                V_txtBottom5.setText(man.txt_ABA23[7]);
                V_txtBottom6.setText(man.txt_ABA23[8]);

            }else if(result.equals("ABB")){
                // 더위적게탐 빈티지
                V_ITopclothes4.setImageResource(man.ABB23[0]);
                V_ITopclothes5.setImageResource(man.ABB23[1]);
                V_ITopclothes6.setImageResource(man.ABB23[2]);
                V_IOuterclothes4.setImageResource(man.ABB23[3]);
                V_IOuterclothes5.setImageResource(man.ABB23[4]);
                V_IOuterclothes6.setImageResource(man.ABB23[5]);
                V_IBottomclothes4.setImageResource(man.ABB23[6]);
                V_IBottomclothes5.setImageResource(man.ABB23[7]);
                V_IBottomclothes6.setImageResource(man.ABB23[8]);
                V_txtTop4.setText(man.txt_ABB23[0]);
                V_txtTop5.setText(man.txt_ABB23[1]);
                V_txtTop6.setText(man.txt_ABB23[2]);
                V_txtOuter4.setText(man.txt_ABB23[3]);
                V_txtOuter5.setText(man.txt_ABB23[4]);
                V_txtOuter6.setText(man.txt_ABB23[5]);
                V_txtBottom4.setText(man.txt_ABB23[6]);
                V_txtBottom5.setText(man.txt_ABB23[7]);
                V_txtBottom6.setText(man.txt_ABB23[8]);
            }else if(result.equals("ABC")){
                // 더위적게탐 스트릿
                V_ITopclothes4.setImageResource(man.ABC23[0]);
                V_ITopclothes5.setImageResource(man.ABC23[1]);
                V_ITopclothes6.setImageResource(man.ABC23[2]);
                V_IOuterclothes4.setImageResource(man.ABC23[3]);
                V_IOuterclothes5.setImageResource(man.ABC23[4]);
                V_IOuterclothes6.setImageResource(man.ABC23[5]);
                V_IBottomclothes4.setImageResource(man.ABC23[6]);
                V_IBottomclothes5.setImageResource(man.ABC23[7]);
                V_IBottomclothes6.setImageResource(man.ABC23[8]);
                V_txtTop4.setText(man.txt_ABC23[0]);
                V_txtTop5.setText(man.txt_ABC23[1]);
                V_txtTop6.setText(man.txt_ABC23[2]);
                V_txtOuter4.setText(man.txt_ABC23[3]);
                V_txtOuter5.setText(man.txt_ABC23[4]);
                V_txtOuter6.setText(man.txt_ABC23[5]);
                V_txtBottom4.setText(man.txt_ABC23[6]);
                V_txtBottom5.setText(man.txt_ABC23[7]);
                V_txtBottom6.setText(man.txt_ABC23[8]);
            }else if(result.equals("ABD")){
                // 더위적게탐 댄디
                V_ITopclothes4.setImageResource(man.ABD23[0]);
                V_ITopclothes5.setImageResource(man.ABD23[1]);
                V_ITopclothes6.setImageResource(man.ABD23[2]);
                V_IOuterclothes4.setImageResource(man.ABD23[3]);
                V_IOuterclothes5.setImageResource(man.ABD23[4]);
                V_IOuterclothes6.setImageResource(man.ABD23[5]);
                V_IBottomclothes4.setImageResource(man.ABD23[6]);
                V_IBottomclothes5.setImageResource(man.ABD23[7]);
                V_IBottomclothes6.setImageResource(man.ABD23[8]);
                V_txtTop4.setText(man.txt_ABD23[0]);
                V_txtTop5.setText(man.txt_ABD23[1]);
                V_txtTop6.setText(man.txt_ABD23[2]);
                V_txtOuter4.setText(man.txt_ABD23[3]);
                V_txtOuter5.setText(man.txt_ABD23[4]);
                V_txtOuter6.setText(man.txt_ABD23[5]);
                V_txtBottom4.setText(man.txt_ABD23[6]);
                V_txtBottom5.setText(man.txt_ABD23[7]);
                V_txtBottom6.setText(man.txt_ABD23[8]);

            }else{
                // ABE 더위적게탐 스포티
                V_ITopclothes4.setImageResource(man.ABE23[0]);
                V_ITopclothes5.setImageResource(man.ABE23[1]);
                V_ITopclothes6.setImageResource(man.ABE23[2]);
                V_IOuterclothes4.setImageResource(man.ABE23[3]);
                V_IOuterclothes5.setImageResource(man.ABE23[4]);
                V_IOuterclothes6.setImageResource(man.ABE23[5]);
                V_IBottomclothes4.setImageResource(man.ABE23[6]);
                V_IBottomclothes5.setImageResource(man.ABE23[7]);
                V_IBottomclothes6.setImageResource(man.ABE23[8]);
                V_txtTop4.setText(man.txt_ABE23[0]);
                V_txtTop5.setText(man.txt_ABE23[1]);
                V_txtTop6.setText(man.txt_ABE23[2]);
                V_txtOuter4.setText(man.txt_ABE23[3]);
                V_txtOuter5.setText(man.txt_ABE23[4]);
                V_txtOuter6.setText(man.txt_ABE23[5]);
                V_txtBottom4.setText(man.txt_ABE23[6]);
                V_txtBottom5.setText(man.txt_ABE23[7]);
                V_txtBottom6.setText(man.txt_ABE23[8]);
            }
        }else if(low_temp == 28){
            if(result.equals("AAA")){
                // 더위많이탐 캐주얼
                V_ITopclothes4.setImageResource(man.AAA28[0]);
                V_ITopclothes5.setImageResource(man.AAA28[1]);
                V_ITopclothes6.setImageResource(man.AAA28[2]);
                V_IOuterclothes4.setImageResource(man.AAA28[3]);
                V_IOuterclothes5.setImageResource(man.AAA28[4]);
                V_IOuterclothes6.setImageResource(man.AAA28[5]);
                V_IBottomclothes4.setImageResource(man.AAA28[6]);
                V_IBottomclothes5.setImageResource(man.AAA28[7]);
                V_IBottomclothes6.setImageResource(man.AAA28[8]);
                V_txtTop4.setText(man.txt_AAA28[0]);
                V_txtTop5.setText(man.txt_AAA28[1]);
                V_txtTop6.setText(man.txt_AAA28[2]);
                V_txtOuter4.setText(man.txt_AAA28[3]);
                V_txtOuter5.setText(man.txt_AAA28[4]);
                V_txtOuter6.setText(man.txt_AAA28[5]);
                V_txtBottom4.setText(man.txt_AAA28[6]);
                V_txtBottom5.setText(man.txt_AAA28[7]);
                V_txtBottom6.setText(man.txt_AAA28[8]);

            }else if(result.equals("AAB")){
                // 더위많이탐 빈티지
                V_ITopclothes4.setImageResource(man.AAB28[0]);
                V_ITopclothes5.setImageResource(man.AAB28[1]);
                V_ITopclothes6.setImageResource(man.AAB28[2]);
                V_IOuterclothes4.setImageResource(man.AAB28[3]);
                V_IOuterclothes5.setImageResource(man.AAB28[4]);
                V_IOuterclothes6.setImageResource(man.AAB28[5]);
                V_IBottomclothes4.setImageResource(man.AAB28[6]);
                V_IBottomclothes5.setImageResource(man.AAB28[7]);
                V_IBottomclothes6.setImageResource(man.AAB28[8]);
                V_txtTop4.setText(man.txt_AAB28[0]);
                V_txtTop5.setText(man.txt_AAB28[1]);
                V_txtTop6.setText(man.txt_AAB28[2]);
                V_txtOuter4.setText(man.txt_AAB28[3]);
                V_txtOuter5.setText(man.txt_AAB28[4]);
                V_txtOuter6.setText(man.txt_AAB28[5]);
                V_txtBottom4.setText(man.txt_AAB28[6]);
                V_txtBottom5.setText(man.txt_AAB28[7]);
                V_txtBottom6.setText(man.txt_AAB28[8]);
            }else if(result.equals("AAC")){
                // 더위많이탐 스트릿
                V_ITopclothes4.setImageResource(man.AAC28[0]);
                V_ITopclothes5.setImageResource(man.AAC28[1]);
                V_ITopclothes6.setImageResource(man.AAC28[2]);
                V_IOuterclothes4.setImageResource(man.AAC28[3]);
                V_IOuterclothes5.setImageResource(man.AAC28[4]);
                V_IOuterclothes6.setImageResource(man.AAC28[5]);
                V_IBottomclothes4.setImageResource(man.AAC28[6]);
                V_IBottomclothes5.setImageResource(man.AAC28[7]);
                V_IBottomclothes6.setImageResource(man.AAC28[8]);
                V_txtTop4.setText(man.txt_AAC28[0]);
                V_txtTop5.setText(man.txt_AAC28[1]);
                V_txtTop6.setText(man.txt_AAC28[2]);
                V_txtOuter4.setText(man.txt_AAC28[3]);
                V_txtOuter5.setText(man.txt_AAC28[4]);
                V_txtOuter6.setText(man.txt_AAC28[5]);
                V_txtBottom4.setText(man.txt_AAC28[6]);
                V_txtBottom5.setText(man.txt_AAC28[7]);
                V_txtBottom6.setText(man.txt_AAC28[8]);
            }else if(result.equals("AAD")){
                // 더위많이탐 댄디
                V_ITopclothes4.setImageResource(man.AAD28[0]);
                V_ITopclothes5.setImageResource(man.AAD28[1]);
                V_ITopclothes6.setImageResource(man.AAD28[2]);
                V_IOuterclothes4.setImageResource(man.AAD28[3]);
                V_IOuterclothes5.setImageResource(man.AAD28[4]);
                V_IOuterclothes6.setImageResource(man.AAD28[5]);
                V_IBottomclothes4.setImageResource(man.AAD28[6]);
                V_IBottomclothes5.setImageResource(man.AAD28[7]);
                V_IBottomclothes6.setImageResource(man.AAD28[8]);
                V_txtTop4.setText(man.txt_AAD28[0]);
                V_txtTop5.setText(man.txt_AAD28[1]);
                V_txtTop6.setText(man.txt_AAD28[2]);
                V_txtOuter4.setText(man.txt_AAD28[3]);
                V_txtOuter5.setText(man.txt_AAD28[4]);
                V_txtOuter6.setText(man.txt_AAD28[5]);
                V_txtBottom4.setText(man.txt_AAD28[6]);
                V_txtBottom5.setText(man.txt_AAD28[7]);
                V_txtBottom6.setText(man.txt_AAD28[8]);

            }else if(result.equals("AAE")){
                // 더위많이탐 스포티
                V_ITopclothes4.setImageResource(man.AAE28[0]);
                V_ITopclothes5.setImageResource(man.AAE28[1]);
                V_ITopclothes6.setImageResource(man.AAE28[2]);
                V_IOuterclothes4.setImageResource(man.AAE28[3]);
                V_IOuterclothes5.setImageResource(man.AAE28[4]);
                V_IOuterclothes6.setImageResource(man.AAE28[5]);
                V_IBottomclothes4.setImageResource(man.AAE28[6]);
                V_IBottomclothes5.setImageResource(man.AAE28[7]);
                V_IBottomclothes6.setImageResource(man.AAE28[8]);
                V_txtTop4.setText(man.txt_AAE28[0]);
                V_txtTop5.setText(man.txt_AAE28[1]);
                V_txtTop6.setText(man.txt_AAE28[2]);
                V_txtOuter4.setText(man.txt_AAE28[3]);
                V_txtOuter5.setText(man.txt_AAE28[4]);
                V_txtOuter6.setText(man.txt_AAE28[5]);
                V_txtBottom4.setText(man.txt_AAE28[6]);
                V_txtBottom5.setText(man.txt_AAE28[7]);
                V_txtBottom6.setText(man.txt_AAE28[8]);

            }else if(result.equals("ABA")){
                // 더위적게탐 캐주얼
                V_ITopclothes4.setImageResource(man.ABA28[0]);
                V_ITopclothes5.setImageResource(man.ABA28[1]);
                V_ITopclothes6.setImageResource(man.ABA28[2]);
                V_IOuterclothes4.setImageResource(man.ABA28[3]);
                V_IOuterclothes5.setImageResource(man.ABA28[4]);
                V_IOuterclothes6.setImageResource(man.ABA28[5]);
                V_IBottomclothes4.setImageResource(man.ABA28[6]);
                V_IBottomclothes5.setImageResource(man.ABA28[7]);
                V_IBottomclothes6.setImageResource(man.ABA28[8]);
                V_txtTop4.setText(man.txt_ABA28[0]);
                V_txtTop5.setText(man.txt_ABA28[1]);
                V_txtTop6.setText(man.txt_ABA28[2]);
                V_txtOuter4.setText(man.txt_ABA28[3]);
                V_txtOuter5.setText(man.txt_ABA28[4]);
                V_txtOuter6.setText(man.txt_ABA28[5]);
                V_txtBottom4.setText(man.txt_ABA28[6]);
                V_txtBottom5.setText(man.txt_ABA28[7]);
                V_txtBottom6.setText(man.txt_ABA28[8]);

            }else if(result.equals("ABB")){
                // 더위적게탐 빈티지
                V_ITopclothes4.setImageResource(man.ABB28[0]);
                V_ITopclothes5.setImageResource(man.ABB28[1]);
                V_ITopclothes6.setImageResource(man.ABB28[2]);
                V_IOuterclothes4.setImageResource(man.ABB28[3]);
                V_IOuterclothes5.setImageResource(man.ABB28[4]);
                V_IOuterclothes6.setImageResource(man.ABB28[5]);
                V_IBottomclothes4.setImageResource(man.ABB28[6]);
                V_IBottomclothes5.setImageResource(man.ABB28[7]);
                V_IBottomclothes6.setImageResource(man.ABB28[8]);
                V_txtTop4.setText(man.txt_ABB28[0]);
                V_txtTop5.setText(man.txt_ABB28[1]);
                V_txtTop6.setText(man.txt_ABB28[2]);
                V_txtOuter4.setText(man.txt_ABB28[3]);
                V_txtOuter5.setText(man.txt_ABB28[4]);
                V_txtOuter6.setText(man.txt_ABB28[5]);
                V_txtBottom4.setText(man.txt_ABB28[6]);
                V_txtBottom5.setText(man.txt_ABB28[7]);
                V_txtBottom6.setText(man.txt_ABB28[8]);
            }else if(result.equals("ABC")){
                // 더위적게탐 스트릿
                V_ITopclothes4.setImageResource(man.ABC28[0]);
                V_ITopclothes5.setImageResource(man.ABC28[1]);
                V_ITopclothes6.setImageResource(man.ABC28[2]);
                V_IOuterclothes4.setImageResource(man.ABC28[3]);
                V_IOuterclothes5.setImageResource(man.ABC28[4]);
                V_IOuterclothes6.setImageResource(man.ABC28[5]);
                V_IBottomclothes4.setImageResource(man.ABC28[6]);
                V_IBottomclothes5.setImageResource(man.ABC28[7]);
                V_IBottomclothes6.setImageResource(man.ABC28[8]);
                V_txtTop4.setText(man.txt_ABC28[0]);
                V_txtTop5.setText(man.txt_ABC28[1]);
                V_txtTop6.setText(man.txt_ABC28[2]);
                V_txtOuter4.setText(man.txt_ABC28[3]);
                V_txtOuter5.setText(man.txt_ABC28[4]);
                V_txtOuter6.setText(man.txt_ABC28[5]);
                V_txtBottom4.setText(man.txt_ABC28[6]);
                V_txtBottom5.setText(man.txt_ABC28[7]);
                V_txtBottom6.setText(man.txt_ABC28[8]);
            }else if(result.equals("ABD")){
                // 더위적게탐 댄디
                V_ITopclothes4.setImageResource(man.ABD28[0]);
                V_ITopclothes5.setImageResource(man.ABD28[1]);
                V_ITopclothes6.setImageResource(man.ABD28[2]);
                V_IOuterclothes4.setImageResource(man.ABD28[3]);
                V_IOuterclothes5.setImageResource(man.ABD28[4]);
                V_IOuterclothes6.setImageResource(man.ABD28[5]);
                V_IBottomclothes4.setImageResource(man.ABD28[6]);
                V_IBottomclothes5.setImageResource(man.ABD28[7]);
                V_IBottomclothes6.setImageResource(man.ABD28[8]);
                V_txtTop4.setText(man.txt_ABD28[0]);
                V_txtTop5.setText(man.txt_ABD28[1]);
                V_txtTop6.setText(man.txt_ABD28[2]);
                V_txtOuter4.setText(man.txt_ABD28[3]);
                V_txtOuter5.setText(man.txt_ABD28[4]);
                V_txtOuter6.setText(man.txt_ABD28[5]);
                V_txtBottom4.setText(man.txt_ABD28[6]);
                V_txtBottom5.setText(man.txt_ABD28[7]);
                V_txtBottom6.setText(man.txt_ABD28[8]);

            }else{
                // ABE 더위적게탐 스포티
                V_ITopclothes4.setImageResource(man.ABE28[0]);
                V_ITopclothes5.setImageResource(man.ABE28[1]);
                V_ITopclothes6.setImageResource(man.ABE28[2]);
                V_IOuterclothes4.setImageResource(man.ABE28[3]);
                V_IOuterclothes5.setImageResource(man.ABE28[4]);
                V_IOuterclothes6.setImageResource(man.ABE28[5]);
                V_IBottomclothes4.setImageResource(man.ABE28[6]);
                V_IBottomclothes5.setImageResource(man.ABE28[7]);
                V_IBottomclothes6.setImageResource(man.ABE28[8]);
                V_txtTop4.setText(man.txt_ABE28[0]);
                V_txtTop5.setText(man.txt_ABE28[1]);
                V_txtTop6.setText(man.txt_ABE28[2]);
                V_txtOuter4.setText(man.txt_ABE28[3]);
                V_txtOuter5.setText(man.txt_ABE28[4]);
                V_txtOuter6.setText(man.txt_ABE28[5]);
                V_txtBottom4.setText(man.txt_ABE28[6]);
                V_txtBottom5.setText(man.txt_ABE28[7]);
                V_txtBottom6.setText(man.txt_ABE28[8]);
            }

        }
    }


    //*****************************************************************************************
    // 설문지에 따른 옷을 보여주기 위해 사용
    public void MatchingStyle(){
        Log.d("MatchingStyle", "MatchingStyle 들어옴");
        if(m_gender.equals("남자")){
            // 남자
            Log.d("남자","성공");
            if(m_heat.equals("더위 많이 타는 타입")){
                Log.d("더위 많이 타는 타입","성공");
                // 더위를 많이 타는 타입
                if(m_style.equals("캐주얼 타입")){
                    Log.d("응답하라", "1997 상의");
                    m_MATCHING_style = "AAA";
                }else if(m_style.equals("빈티지 타입")){
                    m_MATCHING_style = "AAB";
                }else if(m_style.equals("스트릿 타입")){
                    m_MATCHING_style = "AAC";
                }else if(m_style.equals("댄디 타입")){
                    m_MATCHING_style = "AAD";
                }else{
                    // 스프티 타입
                    m_MATCHING_style = "AAE";
                }

            }else{
                // 더위를 적게 타는 타입.
                if(m_style.equals("캐주얼 타입")){
                    m_MATCHING_style = "ABA";
                }else if(m_style.equals("빈티지 타입")){
                    m_MATCHING_style = "ABB";
                }else if(m_style.equals("스트릿 타입")){
                    m_MATCHING_style = "ABC";
                }else if(m_style.equals("댄디 타입")){
                    m_MATCHING_style = "ABD";
                }else{
                    // 스프티 타입
                    m_MATCHING_style = "ABE";
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















