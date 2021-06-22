package com.example.todayclothes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todayclothes.clothesPage.WeatherClothesPage_man;
import com.example.todayclothes.clothesPage.WeatherClothesPage_woman;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class MainWeatherPage extends AppCompatActivity {

    // 메인화면
    TextView V_myLocation;
    TextView V_temp;
    TextView V_wind;
    TextView V_rain;
    ImageView V_SKY;

    // 내일 모레 (최저, 최고)
    TextView V_oneNextHighTemp;
    TextView V_oneNextLowTemp;
    TextView V_twoNextHighTemp;
    TextView V_twoNextLowTemp;

    //시간별 날씨 정보
    TextView V_time1;
    TextView V_time2;
    TextView V_time3;
    TextView V_time4;
    TextView V_time5;
    TextView V_time6;
    TextView V_time7;

    TextView V_temp1;
    TextView V_temp2;
    TextView V_temp3;
    TextView V_temp4;
    TextView V_temp5;
    TextView V_temp6;
    TextView V_temp7;
    TextView V_temp8;

    ImageView V_weatherI1;
    ImageView V_weatherI2;
    ImageView V_weatherI3;
    ImageView V_weatherI4;
    ImageView V_weatherI5;
    ImageView V_weatherI6;
    ImageView V_weatherI7;
    ImageView V_weatherI8;

    ImageView V_weatherNext;
    ImageView V_weatherTwoNext;

    ImageButton V_to_weatherClothesPage; //추천 화면
    ImageButton V_to_myCodyPage; // 마이코디
    ImageButton V_to_ClothesPage; // 옷장

    // 환경설정을 위해 사용함.
    ImageButton V_Setting;

    // 설문조사 페이지
    Dialog dialog;
    RadioGroup radioGroup, radioGroup1, radioGroup2;
    Button next_btn, cancel_btn;

    // 프로그래스 바
    ProgressDialog progressDialog;

    // 다이얼로그 설문조사 답을 담는 변수
    String gender = ""; // 성별
    String heat = ""; // 더위
    String style = ""; // 스타일

    // 이미지 번호
    int a = R.drawable.sun;
    int b = R.drawable.cloudy;
    int c = R.drawable.cloud;
    int d = R.drawable.rainy;
    int e = R.drawable.snowy;


    // Weather API
    String m_time; // 현재 시간을 담기 위해 사용

    String m_data; // 날씨API데이터 전부 담음.

    String m_temp; // 날씨 형태에 따른 측정값을 바꾸기 위해 변수 값을 담아두는 용도

    String m_hour = ""; // 측정시간과 대조하여 필요한 값 얻기.

    String m_MThour = ""; //측정시간을 담는 변수.

    List m_cTemperlist = new ArrayList(); // 현재 시간 기온 저장 리스트.

    List m_cRainlist = new ArrayList(); // 현재 시간 강수형태 저장 리스트.

    List m_cSkylist = new ArrayList(); // 현재 시간 하늘 정보 저장 리스트.

    List m_cWindlist = new ArrayList(); // 현재 시간 풍속 저장 리스트.

    List m_rainNumList = new ArrayList(); // 강수량 저장 리스트

    String m_MtDay = "";

    String m_nextDay = ""; // 금일 기준 다음 날짜 담는 변수

    String m_twonextDay = ""; // 금일 기준 모레 날짜 담는 변수

    List m_highTemperlist = new ArrayList();

    List m_lowTemperlist = new ArrayList();

    // 측정 시간을 담는 리스트
    List m_mt_Timelist = new ArrayList();

    List m_mt_Templist = new ArrayList();

    List m_mt_SKYList = new ArrayList(); // 하늘형태

    List m_mt_RainList = new ArrayList(); // 강수형태

    boolean open = false;

    int weatherImageCount = 0;

    // 금일 날짜 최고기온와 최저기온
    String m_CHighTemp = "";
    String m_CLowTemp = "";
    public String m_gender = "";
    boolean surveyCheck = false;


    // 요청 변수
    //String WEATHER_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getUltraSrtNcst";
    String key = "iCKdg%2FFSCKfmWG%2BGZGuSq%2B2uRATW8O4ZGzIripft7t1PROAEUzQ%2BXXnJ0X6fzrajhHUqqrtVNFswK6auuT%2Flsw%3D%3D"; //라이선스 키
    String mpageNo = "1";
    String mnumbverOfRows = "225"; // 하루치! 거의 50개~!
    String mdataType = "XML";
    String mbase_data = ""; // 금일 날짜
    String mbase_time = "0500";
    //String mNX = "93";
    //String mNY = "91";

//*******************************************************

    Boolean progressCheck;
    Boolean m_SettingCheck = false;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_weather_page);

        // shared preferences로 프로그래스바 한번 돌렸으면 안돌려도됨
        SharedPreferences sh1 = getSharedPreferences("MyProgressBar", MODE_PRIVATE);
        progressCheck=sh1.getBoolean("progressCheck", false);

        V_myLocation = findViewById(R.id.myLocation);
        V_temp = findViewById(R.id.txt_temp); // 메인 현재 기온
        V_wind = findViewById(R.id.txt_wind); // 바람세기
        V_rain = findViewById(R.id.txt_rain); // 강수량
        V_SKY = findViewById(R.id.img_weather); // 날씨 그림
        V_oneNextHighTemp = findViewById(R.id.txt_next_HighTemp); // 내일 최고 기온
        V_oneNextLowTemp = findViewById(R.id.txt_next_LowTemp); // 내일 최저 기온
        V_twoNextHighTemp = findViewById(R.id.txt_two_next_HighTemp); // 모레 최고 기온
        V_twoNextLowTemp = findViewById(R.id.txt_two_next_LowTemp); // 모레 최저 기온
        V_time1 = findViewById(R.id.Time1); // 시간별
        V_time2 = findViewById(R.id.Time2); // 시간별
        V_time3 = findViewById(R.id.Time3); // 시간별
        V_time4 = findViewById(R.id.Time4); // 시간별
        V_time5 = findViewById(R.id.Time5); // 시간별
        V_time6 = findViewById(R.id.Time6); // 시간별
        V_time7 = findViewById(R.id.Time7); // 시간별
        V_temp1 = findViewById(R.id.Temp1); // 시간별
        V_temp2 = findViewById(R.id.Temp2); // 시간별
        V_temp3 = findViewById(R.id.Temp3); // 시간별
        V_temp4 = findViewById(R.id.Temp4); // 시간별
        V_temp5 = findViewById(R.id.Temp5); // 시간별
        V_temp6 = findViewById(R.id.Temp6); // 시간별
        V_temp7 = findViewById(R.id.Temp7); // 시간별
        V_temp8 = findViewById(R.id.Temp8); // 시간별
        V_weatherI1 = findViewById(R.id.weatherI1); // 시간별
        V_weatherI2 = findViewById(R.id.weatherI2); // 시간별
        V_weatherI3 = findViewById(R.id.weatherI3); // 시간별
        V_weatherI4 = findViewById(R.id.weatherI4); // 시간별
        V_weatherI5 = findViewById(R.id.weatherI5); // 시간별
        V_weatherI6 = findViewById(R.id.weatherI6); // 시간별
        V_weatherI7 = findViewById(R.id.weatherI7); // 시간별
        V_weatherI8 = findViewById(R.id.weatherI8); // 시간별
        V_weatherNext = findViewById(R.id.nextweatherI); // 내일날씨
        V_weatherTwoNext = findViewById(R.id.TwonextweatherI); // 모레날씨
        V_to_weatherClothesPage = findViewById(R.id.btn_ToWeatherClothesPage); // 추천 옷차림 버튼
        V_to_myCodyPage = findViewById(R.id.btn_ToMyCodyPage); // 나의 코디 페이지 이동
        V_to_ClothesPage = findViewById(R.id.btn_ToClothsPage); // 옷장 페이지 이동
        V_Setting = findViewById(R.id.IB_Setting);

        // 환경 설정 버튼
        registerForContextMenu(V_Setting);

        // 설문조사 페이지
        dialog = new Dialog(MainWeatherPage.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        dialog.setContentView(R.layout.survey);             // xml 레이아웃 파일과 연결

        //****************************** 처음 한번만 실행 *******************************************
        // 처음 한번만 프로그래스바를 돌려서 주소록 -> 데이터베이스
        // 시작부터 프로그래스바 돌리기.
        if(progressCheck == false){
            progressDialog = new ProgressDialog(MainWeatherPage.this);
            progressDialog.setTitle("잠시만 기다려주세요."); // Setting Title
            progressDialog.setMessage("주소 받는 중..."); // Setting Message
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
            progressDialog.show(); // Display Progress Dialog
            progressDialog.setCancelable(false);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        // 프로그래스바 처음 앱실행시 한번만 돌리기
                        Thread.sleep(10000); // 10초
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    SharedPreferences sh1 = getSharedPreferences("MyProgressBar", MODE_PRIVATE);
                    sh1.edit().putBoolean("progressCheck", true).commit(); // 버튼을 누르면 true 저장
                    progressDialog.dismiss();
                }
            }).start();
        }
        //************************************************************************************

        // 처음에 현재 나의 위치를 가지고 올 때
        Log.d("나의 위치=",MainActivity.address_result);
        V_myLocation.setText(MainActivity.address_result);

        // ******************************* weather API 사용 ***************************

        // 금일 날짜 Data
        mbase_data = current_Time();
        Log.d("mbase_data", mbase_data);

        // 현재날짜 + 1
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DATE, 1);
        Calendar cal1 = new GregorianCalendar();
        cal1.add(Calendar.DATE, 2);

        try {
            m_nextDay = AddDate(mbase_data,0, 0, 1);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        //Log.d("m_nextDay =====", m_nextDay);

        try {
            m_twonextDay = AddDate(mbase_data,0, 0, 2);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        //Log.d("m_twonextDay =====", m_twonextDay);

        Log.d("Location =====", String.valueOf(MainActivity.m_MyLocationX));
        Log.d("Location =====", String.valueOf(MainActivity.m_MyLocationY));
        // weather API
        // 처음 실행후에는 데이터베이스 주소록이 완료후에만 바로 실행.
        startWeather();


        // shared preferences로 설문지를 다시 켰을때 true and false
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        surveyCheck = sh.getBoolean("surveyCheck", false);
        m_gender = sh.getString("gender", "없음"); // 성별 저장


        // navigation bar
        V_to_weatherClothesPage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Log.d("gender", m_gender);
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
                else{
                    showDialog01(); // 아래 showDialog01() 함수 호출
                }
            }
        });

        //나의 옷장로 이동
        V_to_ClothesPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyClosetTop.class);
                startActivity(intent);
            }
        });

        //나의 코디로 이동
        V_to_myCodyPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyCodyPage.class);
                startActivity(intent);
            }
        });
    } // end onCreate

    // 날짜 계산기.
    private static String AddDate(String strDate, int year, int month, int day) throws Exception {
        SimpleDateFormat dtFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance(); Date dt = dtFormat.parse(strDate);
        cal.setTime(dt); cal.add(Calendar.YEAR, year); cal.add(Calendar.MONTH, month);
        cal.add(Calendar.DATE, day);
        return dtFormat.format(cal.getTime());
    }

    // 환경설정 메뉴바 이용
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();

        if (v == V_Setting) {

            menuInflater.inflate(R.menu.setting_menu, menu);
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.set_survey:
                Log.d("설문지","성공");
                Log.d("servey", "servey1");
                // 환경설정에서 설문지를 바꾸었다면
                m_SettingCheck = true;
                showDialog01(); // 아래 showDialog01() 함수 호출
                return true;
        }
        return false;
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.setting_menu, menu);
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.set_survey:
//                Log.d("설문지","성공");
//                break;
//        }
//        return true;
//    }
    //******************************************************
    // 날씨 API
    public void startWeather()
    {
        new Thread(new Runnable()
        {
            @Override
            public void run(){
                m_data = getXmlData();
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Log.d("data==>", m_data); // 날씨정보들이 담겨져 있는 (String)data
                        //Log.d("현재 기온 리스트", m_cTemperlist.get(0)+ " " + m_cTemperlist.get(1));
                        V_temp.setText(m_cTemperlist.get(0).toString() + "°C"); // 현재온도 보여주기.
                        V_wind.setText(m_cWindlist.get(0).toString() + "m/s"); // 현재 바람 풍속
                        V_rain.setText(m_rainNumList.get(0).toString() + "%"); // 현재 강수량
                        weatherImage();// 날씨 이미지 변경
                        nextWeatherData(); // 다음날, 모레 기온 (최고, 최저)
                        TimeTemp(); // 시간별 온도 및 시간.
                    }
                });
            }
        }).start();
    }

    // 이제부터 json 파일 분석 갑니다.
    String getXmlData()
    {
        StringBuffer buffer = new StringBuffer(); // 출력될 값들을 한번에 보여주기 위해 사용.
        //Log.d("mbase_data", mbase_data);
        //String queryUrl =  "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst?serviceKey=" + key + "&pageNo=1&numOfRows=2550&dataType=XML&base_date=20210525&base_time=0500&nx=91&ny=90";
        String queryUrl =  "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst?serviceKey=" + key + "&pageNo=" + mpageNo + "&numOfRows=" + mnumbverOfRows + "&dataType=" + mdataType + "&base_date=" + mbase_data +"&base_time=" + mbase_time + "&nx=" + MainActivity.m_MyLocationX + "&ny=" + MainActivity.m_MyLocationY;
        Log.d("queryUrl", queryUrl);
        try
        {
            URL url= new URL(queryUrl);//문자열로 된 요청 url을 URL 객체로 생성.

            InputStream is= url.openStream(); //url위치로 입력스트림 연결

            XmlPullParserFactory factory= XmlPullParserFactory.newInstance();
            XmlPullParser xpp= factory.newPullParser();
            xpp.setInput( new InputStreamReader(is, StandardCharsets.UTF_8) ); //inputstream 으로부터 xml 입력받기

            String tag;

            xpp.next();
            int eventType= xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT)
            {
                switch (eventType)
                {
                        case XmlPullParser.START_DOCUMENT:
                           buffer.append("파싱시작...\n\n");
                           //Log.d("파싱===>", "파싱시작 ~~~");
                           break;

                    case  XmlPullParser.START_TAG:
                        tag= xpp.getName();
                        //Log.d("파싱===tag>", String.valueOf(tag));

                        if (tag.equals("item"));
                        else if(tag.equals("baseDate")){
                            buffer.append("금일 날짜 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("baseTime")){
                            buffer.append("기본 시간 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("category")){
                            buffer.append("날씨 형태 : ");
                            xpp.next();
                            buffer.append(weatherShape(xpp.getText()));
                            m_temp = weatherShape(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("fcstDate")){
                            buffer.append("측정 날짜 : ");
                            xpp.next();
                            // 만약 원하는 측정날짜가 xpp.getText()에 있다면 m_day에 담아라.
                            buffer.append(xpp.getText());
                            m_MtDay = xpp.getText();
                            //Log.d("m_MtDay", m_MtDay);
                            buffer.append("\n");
                        }
                        else if(tag.equals("fcstTime")){
                            buffer.append("측정 시간 : ");
                            xpp.next();
                            //MTvalue(xpp.getText()); // 매번 측정값을 받는다.
                            m_MThour = xpp.getText();
                            //Log.d("m_hour", m_hour);
                            if(m_hour.equals(m_MThour)){
                                open = true;
                            }
                            if(open == true){
                                m_mt_Timelist.add(xpp.getText()); // 시간별 기온을 보여주기 위해.
                            }
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("fcstValue")){
                            buffer.append("측정 값 : ");
                            xpp.next();
                            if (m_temp.equals("강수형태"))
                            {
                                buffer.append(Precipitation(xpp.getText()));
                                if(open == true){
                                    m_mt_RainList.add(xpp.getText()); // 시간별 강수형태을 보여주기 위해.
                                }
                            }
                            else if (m_temp.equals("하늘상태"))
                            {
                                buffer.append(SKYState(xpp.getText()));
                                if(open == true){
                                    m_mt_SKYList.add(xpp.getText()); // 시간별 하늘상태을 보여주기 위해.
                                }
                            }
                            else if (m_temp.equals("3시간 기온"))
                            {
                                buffer.append(xpp.getText() + "°C");
                                if(open == true){
                                    m_mt_Templist.add(xpp.getText()); // 시간별 기온을 보여주기 위해.
                                }
                            }
                            else if (m_temp.equals("풍속"))
                            {
                                buffer.append(xpp.getText() + "m/s");
                            }
                            else {
                                buffer.append(xpp.getText());
                            }
                            // 현재 시간에 따른 현재 기온 출력.
                            if((m_temp.equals("3시간 기온") && m_MThour.equals(m_hour) == true))
                            {
                                m_cTemperlist.add(xpp.getText());
                            }
                            // 강수형태
                            if((m_temp.equals("강수형태") && m_MThour.equals(m_hour) == true))
                            {
                                m_cRainlist.add(xpp.getText());
                            }
                            // 하늘상태
                            if((m_temp.equals("하늘상태") && m_MThour.equals(m_hour) == true))
                            {
                                m_cSkylist.add(xpp.getText());
                            }
                            if((m_temp.equals("강수확률") && m_MThour.equals(m_hour) == true))
                            {
                                m_rainNumList.add(xpp.getText());
                            }
                            //풍력
                            if((m_temp.equals("풍속") && m_MThour.equals(m_hour) == true))
                            {
                                m_cWindlist.add(xpp.getText());
                            }
                            //Log.d("m_MT", m_MtDay);
                            //Log.d("m_MT", m_nextDay);
                            // 금일 최저기온
                            if((m_MtDay.equals(mbase_data) && m_temp.equals("아침 최저기온") == true) || (m_MtDay.equals(m_nextDay) && m_temp.equals("아침 최저기온") == true))
                            {
                                m_CLowTemp = xpp.getText();
                                //Log.d("m_CLowTemp", m_CLowTemp);
                            }
                            // 금일 최고기온
                            if((m_MtDay.equals(mbase_data) && m_temp.equals("낮 최고기온") == true))
                            {
                                m_CHighTemp = xpp.getText();
                                //Log.d("m_CHighTemp", m_CHighTemp);
                            }
                            // 현재기준 다음날 최저기온을 변수에 담아둔다.
                            if((m_MtDay.equals(m_nextDay) && m_temp.equals("아침 최저기온") == true))
                            {
                                m_lowTemperlist.add(xpp.getText());
                                //Log.d("!!m_lowTemperlist==", m_lowTemperlist.get(0).toString());
                            }
//                            // 현재기준 다음날 최고기온 변수에 담아둔다.
                            if((m_MtDay.equals(m_nextDay) && m_temp.equals("낮 최고기온") == true))
                            {
                                m_highTemperlist.add(xpp.getText());
                                //Log.d("!!m_highTemperlist==", m_highTemperlist.get(0).toString());
                            }
                            if(m_temp.equals("아침 최저기온") == true)
                            {
                                m_lowTemperlist.add(xpp.getText());
                                //Log.d("!!m_lowTemperlist==", m_lowTemperlist.get(1).toString());
                            }
//                            // 현재기준 다음날 최고기온 변수에 담아둔다.
                            if(m_temp.equals("낮 최고기온") == true)
                            {
                                m_highTemperlist.add(xpp.getText());
                                //Log.d("!!m_highTemperlist==", m_highTemperlist.get(1).toString());
                            }

                            //buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("nx")){
                            buffer.append("격자X : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("ny")){
                            buffer.append("격자Y : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        break;

                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag= xpp.getName();

                        if(tag.equals("item")) buffer.append("\n");
                        break;
                }
                eventType =  xpp.next();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            Toast.makeText(MainWeatherPage.this, "데이터 & 와이파이를 연결해 주세요.", Toast.LENGTH_LONG).show();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
            Toast.makeText(MainWeatherPage.this, "데이터 & 와이파이를 연결해 주세요.", Toast.LENGTH_LONG).show();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Toast.makeText(MainWeatherPage.this, "데이터 & 와이파이를 연결해 주세요.", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(MainWeatherPage.this, "데이터 & 와이파이를 연결해 주세요.", Toast.LENGTH_LONG).show();
        }
        buffer.append("파싱종료");
        //Log.d("파싱===>", buffer.toString());

        return  buffer.toString();

    }// end getXmlData()

    // 날씨 형태에 따른 분석
    private  static String weatherShape (String shape)
    {
        switch (shape)
        {
            case "POP" :
                return "강수확률";
            case "R06" :
                return "6시간 강수량";
            case  "REH" :
                return "습도";
            case "S06" :
                return "6시간 신적설 범주(1mm)";
            case "SKY" :
                return "하늘상태";
            case "T3H" :
                return "3시간 기온";
            case "TMN" :
                return "아침 최저기온";
            case "TMX" :
                return "낮 최고기온";
            case "UUU" :
                return "풍속 (동서성분)";
            case "VVV" :
                return "풍속(남북성분)";
            case "PTY" :
                return "강수형태";
            case "WAV" :
                return "파고";
            case "VEC" :
                return "풍향";
            case "WSD" :
                return "풍속";
        }
        return shape;
    }

    // 하늘 상태
    private static String SKYState(String shape)
    {
        switch (shape)
        {
            case "1" :
                return "맑음";
            case "3" :
                return "구름맑음";
            case "4" :
                return "흐림";
        }
        return shape;
    }

    // 강수 형태
    private static String Precipitation(String shape)
    {
        Log.d("shape", shape);
        switch (shape)
        {
            case "0" :
                return "없음";
            case "1" :
                return "비";
            case "2" :
                return "비/눈";
            case "3" :
                return "눈";
            case "4" :
                return "소나기";
            case "5" :
                return "빗방물";
            case "6" :
                return "진눈개비";
            case "7" :
                return "눈날림";
        }
        return shape;
    }

    // 현재시간.
    public String current_Time()
    {
        m_time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
        measurement_Time(m_time); // 현재 시간을 보내준다.  햔재 시간을 찾기위해.
        Calendar calBase = null;
        Date today = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String toDay = date.format(today);
        //Log.d("m_hour == ", m_hour);

        // m_hour이 2300 ~ 0200까지 이면 전날 Data사용해서 시간을 보여준다.
//        if(m_hour.equals("0000") || m_hour.equals("0100") || m_hour.equals("0200") || m_hour.equals("0300"))
//        {
//            calBase = Calendar.getInstance(); // 현재시간 가져옴
//            calBase.add(Calendar.DATE , -1);
//            String beforeDate = new java.text.SimpleDateFormat("yyyyMMdd").format(calBase.getTime());
//            Log.d("beforeDate == ", String.valueOf(beforeDate));
//            return beforeDate;
//
//            // 테스트중.... 23시 오류남.
////            String middleTime = m_time.substring(0, 10); // yyyy/MM/dd
////            String baseTime = middleTime.replace("/",""); // 필요한 부분 자르기.
////            Log.d("현재날짜===",baseTime);
////            return baseTime;
//        }
        if(m_hour.equals("0000") || m_hour.equals("0300"))
        {
            calBase = Calendar.getInstance(); // 현재시간 가져옴
            calBase.add(Calendar.DATE , -1);
            String beforeDate = new java.text.SimpleDateFormat("yyyyMMdd").format(calBase.getTime());
            //Log.d("beforeDate == ", String.valueOf(beforeDate));
            return beforeDate;
        }
        else
        {
            String middleTime = m_time.substring(0, 10); // yyyy/MM/dd
            String baseTime = middleTime.replace("/",""); // 필요한 부분 자르기.
            //Log.d("현재날짜===",baseTime);
            return baseTime;
        }
    }

    // 현재시간에 따른 측정시간 값
    public String measurement_Time (String timedata)
    {
        String hh = timedata.substring(11,13); // 시간만 들고옴.
        hh = hh + "00";

        // 현재 시간에 따라 데이터 시간 설정(3시간 마다 업데이트) //
        switch(hh) {
            case "0200":
            case "0300":
            case "0400":
                m_hour = "0300";
                break;
            case "0500":
            case "0600":
            case "0700":
                m_hour = "0600";
                break;
            case "0800":
            case "0900":
            case "1000":
                m_hour = "0900";
                break;
            case "1100":
            case "1200":
            case "1300":
                m_hour = "1200";
                break;
            case "1400":
            case "1500":
            case "1600":
                m_hour = "1500";
                break;
            case "1700":
            case "1800":
            case "1900":
                m_hour = "1800";
                break;
            case "2000":
            case "2100":
            case "2200":
            case "2300":
                m_hour = "2100";
                break;
            default:
                m_hour = "0000";
        }
        Log.d("시간==", m_hour);
        return m_hour;
    }

    // 날씨 그림을 변경하기 위한 메소드
    public void weatherImage()
    {
        Log.d("weatherImage", m_cRainlist.get(0).toString());
        if(m_cRainlist.get(0).toString().equals("0")){
            switch (m_cSkylist.get(0).toString()){
                case "1":
                    V_SKY.setImageResource(R.drawable.sun);
                    V_weatherI1.setImageResource(R.drawable.sun);
                    break;
                case "3":
                    V_SKY.setImageResource(R.drawable.cloudy);
                    V_weatherI1.setImageResource(R.drawable.cloudy);
                    break;
                case "4":
                    V_SKY.setImageResource(R.drawable.cloud);
                    V_weatherI1.setImageResource(R.drawable.cloud);
                    break;
            }
        }else{
            switch (m_cRainlist.get(0).toString()){
                case "1":
                case "2":
                case "4":
                case "5":
                    V_SKY.setImageResource(R.drawable.rainy);
                    V_weatherI1.setImageResource(R.drawable.rainy);
                    break;
                case "3":
                case "6":
                case "7":
                    V_SKY.setImageResource(R.drawable.snowy);
                    V_weatherI1.setImageResource(R.drawable.snowy);
                    break;
            }
        }
    }


    // 현재날짜 + 1일, 햔재날짜 + 2일 최고 기온, 최저 기온
    public void nextWeatherData()
    {
        Log.d("nextWeatherData()", "들어옴");
        // String 자르기...
        if(m_highTemperlist.get(2).toString().startsWith(".", 1)){
            String high1 = m_highTemperlist.get(2).toString().substring(0,1) + "°C";
            V_oneNextHighTemp.setText(high1);
        }else{
            String high1 = m_highTemperlist.get(1).toString().substring(0,2) + "°C";
            V_oneNextHighTemp.setText(high1);
        }

        if(m_lowTemperlist.get(1).toString().startsWith(".", 1)){
            String low1 = m_lowTemperlist.get(1).toString().substring(0,1) + "°C";
            V_oneNextLowTemp.setText(low1);
        }else{
            String low1 = m_lowTemperlist.get(1).toString().substring(0,2) + "°C";
            V_oneNextLowTemp.setText(low1);
        }

        if(m_highTemperlist.get(3).toString().startsWith(".", 1)){
            String high2 = m_highTemperlist.get(3).toString().substring(0,1) + "°C";
            V_twoNextHighTemp.setText(high2);
        }else{
            String high2 = m_highTemperlist.get(3).toString().substring(0,2) + "°C";
            V_twoNextHighTemp.setText(high2);
        }

        if(m_lowTemperlist.get(2).toString().startsWith(".", 1)){
            String low2 = m_lowTemperlist.get(2).toString().substring(0,1) + "°C";
            V_twoNextLowTemp.setText(low2);
        }else{
            String low2 = m_lowTemperlist.get(2).toString().substring(0,2) + "°C";
            V_twoNextLowTemp.setText(low2);
        }
    }

    // 시간별로 데이터 넣기.
    public void TimeTemp()
    {
        List m_mt_Timelist1 = new ArrayList();

        for(Object data : m_mt_Timelist){
            if(!m_mt_Timelist1.contains(data))
                m_mt_Timelist1.add(data);
        }

//        for (int i =0; i< m_mt_Timelist1.size(); i++){
//            Log.d("m_mt_Timelist", m_mt_Timelist1.get(i).toString());
//        }
//        for (int i =0; i< m_mt_Templist.size(); i++){
//            Log.d("m_mt_Templist", m_mt_Templist.get(i).toString());
//        }
        // 시간 넣기
        V_time1.setText(m_mt_Timelist1.get(1).toString());
        V_time2.setText(m_mt_Timelist1.get(2).toString());
        V_time3.setText(m_mt_Timelist1.get(3).toString());
        V_time4.setText(m_mt_Timelist1.get(4).toString());
        V_time5.setText(m_mt_Timelist1.get(5).toString());
        V_time6.setText(m_mt_Timelist1.get(6).toString());
        V_time7.setText(m_mt_Timelist1.get(7).toString());
        // 온도 넣기
        V_temp1.setText(m_mt_Templist.get(0).toString()+ "°C");
        V_temp2.setText(m_mt_Templist.get(1).toString()+ "°C");
        V_temp3.setText(m_mt_Templist.get(2).toString()+ "°C");
        V_temp4.setText(m_mt_Templist.get(3).toString()+ "°C");
        V_temp5.setText(m_mt_Templist.get(4).toString()+ "°C");
        V_temp6.setText(m_mt_Templist.get(5).toString()+ "°C");
        V_temp7.setText(m_mt_Templist.get(6).toString()+ "°C");
        V_temp8.setText(m_mt_Templist.get(7).toString()+ "°C");
        // 날씨 이미지
        V_weatherI2.setImageResource(timeWeatherImage(m_mt_RainList.get(1).toString()));
        V_weatherI3.setImageResource(timeWeatherImage(m_mt_RainList.get(2).toString()));
        V_weatherI4.setImageResource(timeWeatherImage(m_mt_RainList.get(3).toString()));
        V_weatherNext.setImageResource(timeWeatherImage(m_mt_RainList.get(3).toString())); // 내일 날씨 이미지
        V_weatherI5.setImageResource(timeWeatherImage(m_mt_RainList.get(4).toString()));
        V_weatherI6.setImageResource(timeWeatherImage(m_mt_RainList.get(5).toString()));
        V_weatherI7.setImageResource(timeWeatherImage(m_mt_RainList.get(6).toString()));
        V_weatherI8.setImageResource(timeWeatherImage(m_mt_RainList.get(7).toString()));
        V_weatherTwoNext.setImageResource(timeWeatherImage(m_mt_RainList.get(10).toString())); // 모레 날씨 이미지

        //Log.d("weatherImageCount", String.valueOf(weatherImageCount));

//        for (int i =0; i< m_mt_SKYList.size(); i++){
//            Log.d("m_mt_SKYList", m_mt_SKYList.get(i).toString());
//        }
//        for (int i =0; i< m_mt_RainList.size(); i++){
//            Log.d("m_mt_RainList", m_mt_RainList.get(i).toString());
//        }
//*********
    }

    //날씨 그림 리턴
    public int timeWeatherImage(String num){
        int number = Integer.parseInt(num);
        //Log.d("number", String.valueOf(number));
        weatherImageCount++;
        //String rainList = m_mt_RainList.get(number).toString();
        //og.d("rainList", rainList + "+++" + m_mt_RainList);
        if(number == 0){
            //Log.d("number", String.valueOf(number) + "if");
            switch (m_mt_SKYList.get(weatherImageCount).toString()){
                case "1":
                    return a;
                case "3":
                    return b;
                case "4":
                    return c;
            }
        }else{
            Log.d("number", number + "else");
            switch (m_mt_RainList.get(number).toString()){
                case "0":
                case "1":
                case "2":
                case "4":
                case "5":
                    return d;
                case "3":
                case "6":
                case "7":
                    return e;
            }
        }
        return 0;
    }

    // 설문조사를 위한 함수. 다이얼 로그 사용
    // dialog01을 디자인하는 함수
    public void showDialog01(){
        createDialog();

        //라디오 그룹 설정
        radioGroup = dialog.findViewById(R.id.rGroup);
        radioGroup1 = dialog.findViewById(R.id.rGroup1);
        radioGroup2 = dialog.findViewById(R.id.rGroup2);

        //버튼
        next_btn = dialog.findViewById(R.id.btn_next); // 저장버튼
        cancel_btn = dialog.findViewById(R.id.btn_cancel); // 취소버튼

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 설문지를 한번만 보여주기 위해서
                SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                Boolean statusLocked = sh.edit().putBoolean("surveyCheck", true).commit(); // 버튼을 누르면 true 저장
                sh.edit().putString("gender", gender).commit(); // 성별 저장
                sh.edit().putString("heat", heat).commit(); // 더위 저장
                sh.edit().putString("style", style).commit(); // 스타일 저장
                Log.d("statusLocked", String.valueOf(statusLocked)); // 결과값
                Intent intent1 = new Intent(getApplicationContext(), MainWeatherPage.class);
                startActivity(intent1);//액티비티 띄우기
                // 환경설정에서 설문지를 바꿀 경우
                if(m_SettingCheck == true){
                    Log.d("servey", "servey2");
                    m_SettingCheck = false;
                    dialog.dismiss();
                } else if(gender.equals("남자")) {
                    Intent intent = new Intent(getApplicationContext(), WeatherClothesPage_man.class);
                    intent.putExtra("cTemp",m_cTemperlist.get(0).toString()); // 현재기온
                    intent.putExtra("CHighTemp",m_CHighTemp); // 금일 최고기온
                    intent.putExtra("CLowTemp",m_CLowTemp); // 금일 최저기온
                    intent.putExtra("Crain", m_rainNumList.get(0).toString()); // 금일 강수량
                    intent.putExtra("Cwind", m_cWindlist.get(0).toString()); // 금일 바람세기
                    startActivity(intent);//액티비티 띄우기
                }else{
                    Intent intent = new Intent(getApplicationContext(), WeatherClothesPage_woman.class);
                    intent.putExtra("cTemp",m_cTemperlist.get(0).toString()); // 현재기온
                    intent.putExtra("CHighTemp",m_CHighTemp); // 금일 최고기온
                    intent.putExtra("CLowTemp",m_CLowTemp); // 금일 최저기온
                    intent.putExtra("Crain", m_rainNumList.get(0).toString()); // 금일 강수량
                    intent.putExtra("Cwind", m_cWindlist.get(0).toString()); // 금일 바람세기
                    startActivity(intent);//액티비티 띄우기
                }

            }
        });

        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        // 성별 그룹
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_man:
                        gender = "남자";
                        break;
                    case R.id.rb_woman:
                        gender = "여자";
                }
            }
        });
        // 더위 그룹
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_very:
                        heat = "더위 많이 타는 타입";
                        break;
                    case R.id.rb_little:
                        heat = "더위 적게 타는 타입";
                }
            }
        });
        // 옷 스타일 그룹
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_casual:
                        style = "캐주얼 타입";
                        break;
                    case R.id.rb_vintage:
                        style = "빈티지 타입";
                        break;
                    case R.id.rb_street:
                        style = "스프릿 타입";
                        break;
                    case R.id.rb_dandy:
                        style = "댄디 타입";
                        break;
                    case R.id.rb_sporty:
                        style = "스포티 타입";
                }
            }
        });
    }

    // 다이얼로그 화면 크기 조정
    private void createDialog() {
        final View innerView = getLayoutInflater().inflate(R.layout.survey, null);
        dialog = new Dialog(this);
        dialog.setTitle("Title");
        dialog.setContentView(innerView);
        dialog.setCancelable(true);

        // Dialog 사이즈 조절 하기
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.width = RadioGroup.LayoutParams.MATCH_PARENT;
        params.height = RadioGroup.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setAttributes(params);
        dialog.show();
    }
}