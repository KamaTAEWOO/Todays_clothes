package com.example.todayclothes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WeatherClothesPage extends AppCompatActivity{

    TextView V_CTemp;
    TextView V_CHTemp;
    TextView V_CLTemp;
    ImageButton V_IweatherPage;
    ImageView V_ITopclothes1;
    ImageView V_ITopclothes2;
    ImageView V_IOuterclothes1;
    ImageView V_IOuterclothes2;
    ImageView V_IBottomclothes1;
    ImageView V_IBottomclothes2;
    TextView V_txtTop1;
    TextView V_txtTop2;
    TextView V_txtOuter1;
    TextView V_txtOuter2;
    TextView V_txtBottom1;
    TextView V_txtBottom2;


    // 이미지 번호
    int a = R.drawable.cardigan1_1600; // 가디건
    int b = R.drawable.longsleeve_1600; // 긴팔
    int c = R.drawable.jacket_1600; // 자켓
    int d = R.drawable.cottonpants_1600; //면바지
    int e = R.drawable.tranchcoat_1600; // 트랜치 코트
    int f = R.drawable.short_1600; // 반바지
    int g = R.drawable.sleeve_1600; // 반팔
    int h = R.drawable.slacks_1600; // 슬랙스
    int i = R.drawable.bulejeans_1600; // 청바지
    int j = R.drawable.my_1600; // 마이
    int k = R.drawable.hoodshurt_1600; // 후드티
    int l = R.drawable.longsleeveshirt1600; // 긴팔 셔츠
    int m = R.drawable.thickjacket_1600; // 두꺼운 자켓
    int n = R.drawable.padding_1600; // 패딩
    int z = R.drawable.xxx_50; // 없을때

    int m_Maximum_temperature = 0; // 최대 온도
    int m_Lowest_temperature = 0; // 최저 온도
    String high = "";
    String Low = "";

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
        V_IOuterclothes1 = (ImageView) findViewById(R.id.img_Outerclothes1);
        V_IOuterclothes2 = (ImageView) findViewById(R.id.img_Outerclothes2);
        V_IBottomclothes1 = (ImageView) findViewById(R.id.img_Bottomclothes1);
        V_IBottomclothes2 = (ImageView) findViewById(R.id.img_Bottomclothes2);
        V_txtTop1  = (TextView) findViewById(R.id.txt_top1);
        V_txtTop2 = (TextView) findViewById(R.id.txt_top2);
        V_txtOuter1  = (TextView) findViewById(R.id.txt_outer1);
        V_txtOuter2 = (TextView) findViewById(R.id.txt_outer2);
        V_txtBottom1  = (TextView) findViewById(R.id.txt_bottom1);
        V_txtBottom2 = (TextView) findViewById(R.id.txt_bottom2);

        Intent intent = getIntent(); /*데이터 수신*/

        // 현재 기온
        V_CTemp.setText(intent.getExtras().getString("cTemp") + "°C");

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


        // Temp String to int
        m_Maximum_temperature = Integer.parseInt(high);
        m_Lowest_temperature = Integer.parseInt(Low);
        Log.d("m_Maximum_temperature", String.valueOf(m_Maximum_temperature));
        Log.d("m_Lowest_temperature", String.valueOf(m_Lowest_temperature));

        // 날씨별 옷차림
        TempClothesShow();

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

    //m_Maximum_temperature m_Lowest_temperature
    // 최고기온과 최저기온에 따른 옷차림.
    public void TempClothesShow()
    {
        // 최고기온
        if(m_Maximum_temperature <= 4) {
            Log.d("TempClothesShow", "4");
            V_ITopclothes1.setImageResource(g);
            V_IOuterclothes1.setImageResource(a);
            V_IBottomclothes1.setImageResource(h);
            V_txtTop1.setText("얇은 가디건");
            V_txtOuter1.setText("긴팔");
            V_txtBottom1.setText("슬랙스");
        }else if (m_Maximum_temperature >= 5 && m_Maximum_temperature <= 8){
            Log.d("TempClothesShow", "5");
            V_ITopclothes1.setImageResource(g);
            V_IOuterclothes1.setImageResource(a);
            V_IBottomclothes1.setImageResource(h);
            V_txtTop1.setText("얇은 가디건");
            V_txtOuter1.setText("긴팔");
            V_txtBottom1.setText("슬랙스");
        }else if (m_Maximum_temperature >= 9 && m_Maximum_temperature <= 11){
            Log.d("TempClothesShow", "9");
            V_ITopclothes1.setImageResource(g);
            V_IOuterclothes1.setImageResource(a);
            V_IBottomclothes1.setImageResource(h);
            V_txtTop1.setText("얇은 가디건");
            V_txtOuter1.setText("긴팔");
            V_txtBottom1.setText("슬랙스");
        }else if (m_Maximum_temperature >= 12 && m_Maximum_temperature <= 16){
            Log.d("TempClothesShow", "12");
            V_ITopclothes1.setImageResource(g);
            V_IOuterclothes1.setImageResource(a);
            V_IBottomclothes1.setImageResource(h);
            V_txtTop1.setText("얇은 가디건");
            V_txtOuter1.setText("긴팔");
            V_txtBottom1.setText("슬랙스");
        }else if (m_Maximum_temperature >= 17 && m_Maximum_temperature <= 19){
            Log.d("TempClothesShow", "17");
            V_ITopclothes1.setImageResource(g);
            V_IOuterclothes1.setImageResource(a);
            V_IBottomclothes1.setImageResource(h);
            V_txtTop1.setText("얇은 가디건");
            V_txtOuter1.setText("긴팔");
            V_txtBottom1.setText("슬랙스");
        }else if (m_Maximum_temperature >= 20 && m_Maximum_temperature <= 22){
            Log.d("TempClothesShow", "20");
            V_ITopclothes1.setImageResource(g);
            V_IOuterclothes1.setImageResource(a);
            V_IBottomclothes1.setImageResource(h);
            V_txtTop1.setText("얇은 가디건");
            V_txtOuter1.setText("긴팔");
            V_txtBottom1.setText("슬랙스");
        }else if (m_Maximum_temperature >= 23 && m_Maximum_temperature <= 27){
            Log.d("TempClothesShow", "23");
            V_ITopclothes1.setImageResource(g);
            V_IOuterclothes1.setImageResource(a);
            V_IBottomclothes1.setImageResource(h);
            V_txtTop1.setText("얇은 가디건");
            V_txtOuter1.setText("긴팔");
            V_txtBottom1.setText("슬랙스");
        }else {
            Log.d("TempClothesShow", "28");
            V_ITopclothes1.setImageResource(g);
            V_IOuterclothes1.setImageResource(a);
            V_IBottomclothes1.setImageResource(h);
            V_txtTop1.setText("얇은 가디건");
            V_txtOuter1.setText("긴팔");
            V_txtBottom1.setText("슬랙스");
        }

        // 최저기온
        if(m_Lowest_temperature <= 4) {
            Log.d("TempClothesShow", "4");
            V_ITopclothes2.setImageResource(b);
            V_IOuterclothes2.setImageResource(c);
            V_IBottomclothes2.setImageResource(i);
            V_txtTop2.setText("두꺼운 자켓");
            V_txtOuter2.setText("반판");
            V_txtBottom2.setText("청바지");
        }else if (m_Lowest_temperature >= 5 && m_Lowest_temperature <= 8){
            Log.d("TempClothesShow", "5");
            V_ITopclothes2.setImageResource(b);
            V_IOuterclothes2.setImageResource(c);
            V_IBottomclothes2.setImageResource(i);
            V_txtTop2.setText("두꺼운 자켓");
            V_txtOuter2.setText("반판");
            V_txtBottom2.setText("청바지");
        }else if (m_Lowest_temperature >= 9 && m_Lowest_temperature <= 11){
            Log.d("TempClothesShow", "9");
            V_ITopclothes2.setImageResource(b);
            V_IOuterclothes2.setImageResource(c);
            V_IBottomclothes2.setImageResource(i);
            V_txtTop2.setText("두꺼운 자켓");
            V_txtOuter2.setText("반판");
            V_txtBottom2.setText("청바지");
        }else if (m_Lowest_temperature >= 12 && m_Lowest_temperature <= 16){
            Log.d("TempClothesShow", "12");
            V_ITopclothes2.setImageResource(b);
            V_IOuterclothes2.setImageResource(c);
            V_IBottomclothes2.setImageResource(i);
            V_txtTop2.setText("두꺼운 자켓");
            V_txtOuter2.setText("반판");
            V_txtBottom2.setText("청바지");
        }else if (m_Lowest_temperature >= 17 && m_Lowest_temperature <= 19){
            Log.d("TempClothesShow", "17");
            V_ITopclothes2.setImageResource(b);
            V_IOuterclothes2.setImageResource(c);
            V_IBottomclothes2.setImageResource(i);
            V_txtTop2.setText("두꺼운 자켓");
            V_txtOuter2.setText("반판");
            V_txtBottom2.setText("청바지");
        }else if (m_Lowest_temperature >= 20 && m_Lowest_temperature <= 22){
            Log.d("TempClothesShow", "20");
            V_ITopclothes2.setImageResource(b);
            V_IOuterclothes2.setImageResource(c);
            V_IBottomclothes2.setImageResource(i);
            V_txtTop2.setText("두꺼운 자켓");
            V_txtOuter2.setText("반판");
            V_txtBottom2.setText("청바지");
        }else if (m_Lowest_temperature >= 23 && m_Lowest_temperature <= 27){
            Log.d("TempClothesShow", "23");
            V_ITopclothes2.setImageResource(b);
            V_IOuterclothes2.setImageResource(c);
            V_IBottomclothes2.setImageResource(i);
            V_txtTop2.setText("두꺼운 자켓");
            V_txtOuter2.setText("반판");
            V_txtBottom2.setText("청바지");
        }else {
            Log.d("TempClothesShow", "28");
            V_ITopclothes2.setImageResource(b);
            V_IOuterclothes2.setImageResource(c);
            V_IBottomclothes2.setImageResource(i);
            V_txtTop2.setText("두꺼운 자켓");
            V_txtOuter2.setText("반판");
            V_txtBottom2.setText("청바지");
        }
    }
}















