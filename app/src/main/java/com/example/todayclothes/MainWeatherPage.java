package com.example.todayclothes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.room.Room;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AppComponentFactory;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todayclothes.mylocation.GpsTracker;
import com.example.todayclothes.weatherdatabase.AppDatabase;
import com.example.todayclothes.weatherdatabase.NationWeatherTable;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

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

    ImageButton V_to_weatherPage;


    // 이미지 번호
    int a = R.drawable.sun;
    int b = R.drawable.cloudy;
    int c = R.drawable.cloud;
    int d = R.drawable.rainy;
    int e = R.drawable.snowy;


    // current Location
    private GpsTracker gpsTracker;

    private static final int GPS_ENABLE_REQUEST_CODE = 2001;
    private static final int PERMISSIONS_REQUEST_CODE = 100;
    String[] REQUIRED_PERMISSIONS  = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};

    // Weather API
    String m_time; // 현재 시간을 담기 위해 사용

    String m_data; // 날씨API데이터 전부 담음.

    String m_temp; // 날씨 형태에 따른 측정값을 바꾸기 위해 변수 값을 담아두는 용도

    String m_hour = ""; // 측정시간과 대조하여 필요한 값 얻기.

    static String m_MThour = ""; //측정시간을 담는 변수.

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


    // 현재위치의 x좌표
    int m_MyLocationX = 0;
    // 현재위치의 y좌표
    int m_MyLocationY = 0;

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


    // 요청 변수
    String WEATHER_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getUltraSrtNcst";
    String key = "iCKdg%2FFSCKfmWG%2BGZGuSq%2B2uRATW8O4ZGzIripft7t1PROAEUzQ%2BXXnJ0X6fzrajhHUqqrtVNFswK6auuT%2Flsw%3D%3D"; //라이선스 키
    String mpageNo = "1";
    String mnumbverOfRows = "225"; // 하루치! 거의 50개~!
    String mdataType = "XML";
    String mbase_data = ""; // 금일 날짜
    String mbase_time = "0500";
    String mNX = "93";
    String mNY = "91";

//*******************************************************

    private int m_count = 0;
    private Object NationWeatherTable;

    private String m_myLocationData; // 서울특별시 종로구

//    // 주소를 나눠서 저장
    private String m_location1; // 서울특별시
    private String m_location2; // 종로구



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_weather_page);

        V_myLocation = (TextView)findViewById(R.id.myLocation);
        V_temp = (TextView)findViewById(R.id.txt_temp); // 메인 현재 기온
        V_wind =(TextView)findViewById(R.id.txt_wind); // 바람세기
        V_rain =(TextView)findViewById(R.id.txt_rain); // 강수량
        V_SKY = (ImageView)findViewById(R.id.img_weather); // 날씨 그림
        V_oneNextHighTemp = (TextView) findViewById(R.id.txt_next_HighTemp); // 내일 최고 기온
        V_oneNextLowTemp = (TextView) findViewById(R.id.txt_next_LowTemp); // 내일 최저 기온
        V_twoNextHighTemp = (TextView) findViewById(R.id.txt_two_next_HighTemp); // 모레 최고 기온
        V_twoNextLowTemp = (TextView) findViewById(R.id.txt_two_next_LowTemp); // 모레 최저 기온
        V_time1 = (TextView) findViewById(R.id.Time1); // 시간별
        V_time2 = (TextView) findViewById(R.id.Time2); // 시간별
        V_time3 = (TextView) findViewById(R.id.Time3); // 시간별
        V_time4 = (TextView) findViewById(R.id.Time4); // 시간별
        V_time5 = (TextView) findViewById(R.id.Time5); // 시간별
        V_time6 = (TextView) findViewById(R.id.Time6); // 시간별
        V_time7 = (TextView) findViewById(R.id.Time7); // 시간별
        V_temp1 = (TextView) findViewById(R.id.Temp1); // 시간별
        V_temp2 = (TextView) findViewById(R.id.Temp2); // 시간별
        V_temp3 = (TextView) findViewById(R.id.Temp3); // 시간별
        V_temp4 = (TextView) findViewById(R.id.Temp4); // 시간별
        V_temp5 = (TextView) findViewById(R.id.Temp5); // 시간별
        V_temp6 = (TextView) findViewById(R.id.Temp6); // 시간별
        V_temp7 = (TextView) findViewById(R.id.Temp7); // 시간별
        V_temp8 = (TextView) findViewById(R.id.Temp8); // 시간별
        V_weatherI1 = (ImageView) findViewById(R.id.weatherI1); // 시간별
        V_weatherI2 = (ImageView) findViewById(R.id.weatherI2); // 시간별
        V_weatherI3 = (ImageView) findViewById(R.id.weatherI3); // 시간별
        V_weatherI4 = (ImageView) findViewById(R.id.weatherI4); // 시간별
        V_weatherI5 = (ImageView) findViewById(R.id.weatherI5); // 시간별
        V_weatherI6 = (ImageView) findViewById(R.id.weatherI6); // 시간별
        V_weatherI7 = (ImageView) findViewById(R.id.weatherI7); // 시간별
        V_weatherI8 = (ImageView) findViewById(R.id.weatherI8); // 시간별
        V_weatherNext = (ImageView) findViewById(R.id.nextweatherI); // 내일날씨
        V_weatherTwoNext = (ImageView) findViewById(R.id.TwonextweatherI); // 모레날씨
        V_to_weatherPage = (ImageButton) findViewById(R.id.btn_ToWeatherClothesPage); // 추천 옷차림 버튼

        if (!checkLocationServicesStatus()) {

            showDialogForLocationServiceSetting();
        }else {

            checkRunTimePermission();
        }

        gpsTracker = new GpsTracker(MainWeatherPage.this);

        double latitude = gpsTracker.getLatitude();
        double longitude = gpsTracker.getLongitude();

        // 사용할 부분 *****
        String address = getCurrentAddress(latitude, longitude);
        //Log.d("address=", String.valueOf(address)); // 출력 : 대한민국 경상북도 경산시 진량읍 문천리 산2-1
        String[] result = address.split(" "); // 띄워쓰기마다 토큰 저장
        String address_result = result[1] + " " + result[2] + " " + result[3]; // 결과 : 경상북도 경산시
        m_location1 = result[1];
        m_location2 = result[2];
        Log.d("나의 위치=",address_result);
        V_myLocation.setText(address_result);

        // ******************************* weather API 사용 ***************************

        // 금일 날짜 Data
        mbase_data = current_Time();
        Log.d("mbase_data", mbase_data);

        // 현재날짜 + 1
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DATE, 1);
        Calendar cal1 = new GregorianCalendar();
        cal1.add(Calendar.DATE, 2);

        //m_nextDay = String.valueOf(cal.get(Calendar.YEAR))+ "0" + String.valueOf(cal.get(Calendar.MONTH) + 1) + "0" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH)); // 금일 기준 다음날 저장.
        try {
            m_nextDay = AddDate(mbase_data,0, 0, 1);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        Log.d("m_nextDay =====", m_nextDay);

        //m_twonextDay = String.valueOf(cal1.get(Calendar.YEAR))+ "0" + String.valueOf(cal1.get(Calendar.MONTH) + 1) + "0" +String.valueOf(cal1.get(Calendar.DAY_OF_MONTH));
        try {
            m_twonextDay = AddDate(mbase_data,0, 0, 2);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        Log.d("m_twonextDay =====", m_twonextDay);

        // weather API
        startWeather();

        V_to_weatherPage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), WeatherClothesPage.class);
                intent.putExtra("cTemp",m_cTemperlist.get(0).toString()); // 현재기온
                intent.putExtra("CHighTemp",m_CHighTemp); // 금일 최고기온
                intent.putExtra("CLowTemp",m_CLowTemp); // 금일 최저기온
                startActivity(intent);
            }
        });

    }
    // 날짜 계산기.
    private static String AddDate(String strDate, int year, int month, int day) throws Exception {
        SimpleDateFormat dtFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance(); Date dt = dtFormat.parse(strDate);
        cal.setTime(dt); cal.add(Calendar.YEAR, year); cal.add(Calendar.MONTH, month);
        cal.add(Calendar.DATE, day); return dtFormat.format(cal.getTime());
    }


    //*************** current Location ***************
    /*
     * ActivityCompat.requestPermissions를 사용한 퍼미션 요청의 결과를 리턴받는 메소드입니다.
     */
    @Override
    public void onRequestPermissionsResult(int permsRequestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grandResults) {

        if ( permsRequestCode == PERMISSIONS_REQUEST_CODE && grandResults.length == REQUIRED_PERMISSIONS.length) {

            // 요청 코드가 PERMISSIONS_REQUEST_CODE 이고, 요청한 퍼미션 개수만큼 수신되었다면

            boolean check_result = true;


            // 모든 퍼미션을 허용했는지 체크합니다.

            for (int result : grandResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    check_result = false;
                    break;
                }
            }


            if ( check_result ) {

                //위치 값을 가져올 수 있음
                ;
            }
            else {
                // 거부한 퍼미션이 있다면 앱을 사용할 수 없는 이유를 설명해주고 앱을 종료합니다.2 가지 경우가 있습니다.

                if (ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[0])
                        || ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[1])) {

                    Toast.makeText(MainWeatherPage.this, "퍼미션이 거부되었습니다. 앱을 다시 실행하여 퍼미션을 허용해주세요.", Toast.LENGTH_LONG).show();
                    finish();


                }else {

                    Toast.makeText(MainWeatherPage.this, "퍼미션이 거부되었습니다. 설정(앱 정보)에서 퍼미션을 허용해야 합니다. ", Toast.LENGTH_LONG).show();

                }
            }

        }
    }

    void checkRunTimePermission(){

        //런타임 퍼미션 처리
        // 1. 위치 퍼미션을 가지고 있는지 체크합니다.
        int hasFineLocationPermission = ContextCompat.checkSelfPermission(MainWeatherPage.this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        int hasCoarseLocationPermission = ContextCompat.checkSelfPermission(MainWeatherPage.this,
                Manifest.permission.ACCESS_COARSE_LOCATION);


        if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED &&
                hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED) {

            // 2. 이미 퍼미션을 가지고 있다면
            // ( 안드로이드 6.0 이하 버전은 런타임 퍼미션이 필요없기 때문에 이미 허용된 걸로 인식합니다.)


            // 3.  위치 값을 가져올 수 있음



        } else {  //2. 퍼미션 요청을 허용한 적이 없다면 퍼미션 요청이 필요합니다. 2가지 경우(3-1, 4-1)가 있습니다.

            // 3-1. 사용자가 퍼미션 거부를 한 적이 있는 경우에는
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainWeatherPage.this, REQUIRED_PERMISSIONS[0])) {

                // 3-2. 요청을 진행하기 전에 사용자가에게 퍼미션이 필요한 이유를 설명해줄 필요가 있습니다.
                Toast.makeText(MainWeatherPage.this, "이 앱을 실행하려면 위치 접근 권한이 필요합니다.", Toast.LENGTH_LONG).show();
                // 3-3. 사용자게에 퍼미션 요청을 합니다. 요청 결과는 onRequestPermissionResult에서 수신됩니다.
                ActivityCompat.requestPermissions(MainWeatherPage.this, REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE);


            } else {
                // 4-1. 사용자가 퍼미션 거부를 한 적이 없는 경우에는 퍼미션 요청을 바로 합니다.
                // 요청 결과는 onRequestPermissionResult에서 수신됩니다.
                ActivityCompat.requestPermissions(MainWeatherPage.this, REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE);
            }

        }

    }


    public String getCurrentAddress( double latitude, double longitude) {

        //지오코더... GPS를 주소로 변환
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        List<Address> addresses;

        try {

            addresses = geocoder.getFromLocation(
                    latitude,
                    longitude,
                    7);
        } catch (IOException ioException) {
            //네트워크 문제
            Toast.makeText(this, "지오코더 서비스 사용불가", Toast.LENGTH_LONG).show();
            return "지오코더 서비스 사용불가";
        } catch (IllegalArgumentException illegalArgumentException) {
            Toast.makeText(this, "잘못된 GPS 좌표", Toast.LENGTH_LONG).show();
            return "잘못된 GPS 좌표";
        }

        if (addresses == null || addresses.size() == 0) {
            Toast.makeText(this, "주소 미발견", Toast.LENGTH_LONG).show();
            return "주소 미발견";

        }

        Address address = addresses.get(0);
        return address.getAddressLine(0).toString()+"\n";

    }


    //여기부터는 GPS 활성화를 위한 메소드들
    private void showDialogForLocationServiceSetting() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainWeatherPage.this);
        builder.setTitle("위치 서비스 비활성화");
        builder.setMessage("앱을 사용하기 위해서는 위치 서비스가 필요합니다.\n"
                + "위치 설정을 수정하실래요?");
        builder.setCancelable(true);
        builder.setPositiveButton("설정", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Intent callGPSSettingIntent
                        = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivityForResult(callGPSSettingIntent, GPS_ENABLE_REQUEST_CODE);
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case GPS_ENABLE_REQUEST_CODE:

                //사용자가 GPS 활성 시켰는지 검사
                if (checkLocationServicesStatus()) {
                    if (checkLocationServicesStatus()) {

                        Log.d("@@@", "onActivityResult : GPS 활성화 되있음");
                        checkRunTimePermission();
                        return;
                    }
                }

                break;
        }
    }

    public boolean checkLocationServicesStatus() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }


    //******************************************************
    // 날씨 API
    //Button 클릭시 자동으로 호출되는 callback method
    public void startWeather()
    {
        new Thread(new Runnable()
        {
            @Override
            public void run(){
                weatherAddressDatabese();
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
        Log.d("mbase_data", mbase_data);
        //StringBuilder urlBuilder = new StringBuilder(WEATHER_URL); /*URL*/
        //String queryUrl =  "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst?serviceKey=" + key + "&pageNo=1&numOfRows=10&dataType=XML&base_date=20210325&base_time=0500&nx=93&ny=91";
        String queryUrl =  "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst?serviceKey=" + key + "&pageNo=" + mpageNo + "&numOfRows=" + mnumbverOfRows + "&dataType=" + mdataType + "&base_date=" + mbase_data +"&base_time=" + mbase_time + "&nx=" + String.valueOf(m_MyLocationX) + "&ny=" + String.valueOf(m_MyLocationY);
        Log.d("queryUrl", queryUrl);
        try
        {
            URL url= new URL(queryUrl);//문자열로 된 요청 url을 URL 객체로 생성.

            InputStream is= url.openStream(); //url위치로 입력스트림 연결

            XmlPullParserFactory factory= XmlPullParserFactory.newInstance();
            XmlPullParser xpp= factory.newPullParser();
            xpp.setInput( new InputStreamReader(is, "UTF-8") ); //inputstream 으로부터 xml 입력받기

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
                            Log.d("xpp.getText()", m_MtDay);
                            buffer.append("\n");
                        }
                        else if(tag.equals("fcstTime")){
                            buffer.append("측정 시간 : ");
                            xpp.next();
                            //MTvalue(xpp.getText()); // 매번 측정값을 받는다.
                            m_MThour = xpp.getText();
                            Log.d("m_hour", m_hour);
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
                            Log.d("m_MT", m_MtDay);
                            Log.d("m_MT", m_nextDay);
                            // 금일 최저기온
                            if((m_MtDay.equals(mbase_data) && m_temp.equals("아침 최저기온") == true) || (m_MtDay.equals(m_nextDay) && m_temp.equals("아침 최저기온") == true))
                            {
                                m_CLowTemp = xpp.getText();
                                Log.d("m_CLowTemp", m_CLowTemp);
                            }
                            // 금일 최고기온
                            if((m_MtDay.equals(mbase_data) && m_temp.equals("낮 최고기온") == true))
                            {
                                m_CHighTemp = xpp.getText();
                                Log.d("m_CHighTemp", m_CHighTemp);
                            }
                            // 현재기준 다음날 최저기온을 변수에 담아둔다.
                            if((m_MtDay.equals(m_nextDay) && m_temp.equals("아침 최저기온") == true))
                            {
                                m_lowTemperlist.add(xpp.getText());
                                Log.d("!!m_lowTemperlist==", m_lowTemperlist.get(0).toString());
                            }
//                            // 현재기준 다음날 최고기온 변수에 담아둔다.
                            if((m_MtDay.equals(m_nextDay) && m_temp.equals("낮 최고기온") == true))
                            {
                                m_highTemperlist.add(xpp.getText());
                                Log.d("!!m_highTemperlist==", m_highTemperlist.get(0).toString());
                            }
                            if((m_MtDay.equals(m_twonextDay) && m_temp.equals("아침 최저기온") == true))
                            {
                                m_lowTemperlist.add(xpp.getText());
                                Log.d("!!m_lowTemperlist==", m_lowTemperlist.get(1).toString());
                            }
//                            // 현재기준 다음날 최고기온 변수에 담아둔다.
                            if((m_MtDay.equals(m_twonextDay) && m_temp.equals("낮 최고기온") == true))
                            {
                                m_highTemperlist.add(xpp.getText());
                                Log.d("!!m_highTemperlist==", m_highTemperlist.get(1).toString());
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
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer.append("파싱종료");
        Log.d("파싱===>", "파싱종료 ~~~");
        return  buffer.toString();

    }// getXmlData()

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
        Log.d("m_hour == ", m_hour);

        // m_hour이 2300 ~ 0200까지 이면 전날 Data사용해서 시간을 보여준다.
        if(m_hour.equals("0000") || m_hour.equals("0100") || m_hour.equals("0200") || m_hour.equals("0300"))
        {
            calBase = Calendar.getInstance(); // 현재시간 가져옴
            calBase.add(Calendar.DATE , -1);
            String beforeDate = new java.text.SimpleDateFormat("yyyyMMdd").format(calBase.getTime());
            Log.d("beforeDate == ", String.valueOf(beforeDate));
            return beforeDate;

            // 테스트중.... 23시 오류남.
//            String middleTime = m_time.substring(0, 10); // yyyy/MM/dd
//            String baseTime = middleTime.replace("/",""); // 필요한 부분 자르기.
//            Log.d("현재날짜===",baseTime);
//            return baseTime;
        }
        else
        {
            String middleTime = m_time.substring(0, 10); // yyyy/MM/dd
            String baseTime = middleTime.replace("/",""); // 필요한 부분 자르기.
            Log.d("현재날짜===",baseTime);
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

            case "2300":
            case "0000":
            case "0100":
                m_hour = "0000";
                break;
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
            default:
                m_hour = "2100";
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
        if(m_highTemperlist.get(0).toString().substring(1,2).equals(".")){
            String high1 = m_highTemperlist.get(0).toString().substring(0,1) + "°C";
            V_oneNextHighTemp.setText(high1);
        }else{
            String high1 = m_highTemperlist.get(0).toString().substring(0,2) + "°C";
            V_oneNextHighTemp.setText(high1);
        }

        if(m_lowTemperlist.get(0).toString().substring(1,2).equals(".")){
            String low1 = m_lowTemperlist.get(0).toString().substring(0,1) + "°C";
            V_oneNextLowTemp.setText(low1);
        }else{
            String low1 = m_lowTemperlist.get(0).toString().substring(0,2) + "°C";
            V_oneNextLowTemp.setText(low1);
        }

        if(m_highTemperlist.get(1).toString().substring(1,2).equals(".")){
            String high2 = m_highTemperlist.get(1).toString().substring(0,1) + "°C";
            V_twoNextHighTemp.setText(high2);
        }else{
            String high2 = m_highTemperlist.get(1).toString().substring(0,2) + "°C";
            V_twoNextHighTemp.setText(high2);
        }

        if(m_lowTemperlist.get(1).toString().substring(1,2).equals(".")){
            String low2 = m_lowTemperlist.get(1).toString().substring(0,1) + "°C";
            V_twoNextLowTemp.setText(low2);
        }else{
            String low2 = m_lowTemperlist.get(1).toString().substring(0,2) + "°C";
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

        for (int i =0; i< m_mt_Timelist1.size(); i++){
            Log.d("m_mt_Timelist", m_mt_Timelist1.get(i).toString());
        }
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
        //weatherImageCount += 2;
        V_weatherI2.setImageResource(timeWeatherImage(m_mt_RainList.get(1).toString()));
        //weatherImageCount += 2;
        V_weatherI3.setImageResource(timeWeatherImage(m_mt_RainList.get(2).toString()));
        //weatherImageCount += 2;
        V_weatherI4.setImageResource(timeWeatherImage(m_mt_RainList.get(3).toString()));
        V_weatherNext.setImageResource(timeWeatherImage(m_mt_RainList.get(3).toString())); // 내일 날씨 이미지
        //weatherImageCount += 2;
        V_weatherI5.setImageResource(timeWeatherImage(m_mt_RainList.get(4).toString()));
        //weatherImageCount += 2;
        V_weatherI6.setImageResource(timeWeatherImage(m_mt_RainList.get(5).toString()));
        //weatherImageCount += 2;
        V_weatherI7.setImageResource(timeWeatherImage(m_mt_RainList.get(6).toString()));
        //weatherImageCount += 2;
        V_weatherI8.setImageResource(timeWeatherImage(m_mt_RainList.get(7).toString()));
        V_weatherTwoNext.setImageResource(timeWeatherImage(m_mt_RainList.get(10).toString())); // 모레 날씨 이미지

        Log.d("weatherImageCount", String.valueOf(weatherImageCount));

        for (int i =0; i< m_mt_SKYList.size(); i++){
            Log.d("m_mt_SKYList", m_mt_SKYList.get(i).toString());
        }
        for (int i =0; i< m_mt_RainList.size(); i++){
            Log.d("m_mt_RainList", m_mt_RainList.get(i).toString());
        }

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
            Log.d("number", String.valueOf(number) + "if");
            switch (m_mt_SKYList.get(weatherImageCount).toString()){
                case "1":
                    return a;
                case "3":
                    return b;
                case "4":
                    return c;
            }
        }else{
            Log.d("number", String.valueOf(number) + "else");
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


    //******************************  주소록 DB **************************************

    // 주소 정보를 데이터 베이스 안에 넣는다. room 사용.
    private void weatherAddressDatabese()
    {
        //정의한 데이터베이스를 생성 .allowMainThreadQueries()는 메인 스레드에서 Room을 사용가능하게 해줌
        AppDatabase NationWeatherdb = Room.databaseBuilder(this, AppDatabase.class, "db")
                .allowMainThreadQueries()
                .build();

        /* NationWeatherTable input = new NationWeatherTable(1114062500, "seoul", "jongrogu", "dasandong", 60, 126);
        NationWeatherdb.nationWeatherDao().deleteall();
        NationWeatherdb.nationWeatherDao().insert(input);
        NationWeatherTable output = (NationWeatherTable) NationWeatherdb.nationWeatherDao().getall().get(0);
        Log.d("db_test", String.valueOf(output)); */

        //assets 폴더에서 파일 불러오기기
        AssetManager assetManager = getResources().getAssets();
        InputStream inputStream = null;

        try {
            inputStream = assetManager.open("NationWeatherDB.txt");
            //입력속도 향상을 위해 버퍼리더 사용
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            while (true) {
                String string = bufferedReader.readLine();  //한줄씩 읽어오기
                //Log.d("file_test", string); // 파일 로드 테스트하기 위한 코드
                m_count++;

                if (string == null) {
                    break;
                }

                String[] NationArray = string.split("\t"); //tab을 기준으로 자르기
                // Log.d("file_test",NationArray[1]);           //값 확인

                //테이블에 지역 데이터 저장하고 DB에 삽입
                NationWeatherTable input = new NationWeatherTable(
                        Long.parseLong(NationArray[0]),
                        NationArray[1],
                        NationArray[2],
                        NationArray[3],
                        Integer.parseInt(NationArray[4]),
                        Integer.parseInt(NationArray[5])
                );
                //NationWeatherdb.nationWeatherDao().insert(input);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Log.d("count_test", String.valueOf(count));

//        for (int i = 0; i < (m_count-1); i++ ){
//            NationWeatherTable output = NationWeatherdb.nationWeatherDao().getall().get(i);
//            //Log.d("db_test", String.valueOf(output));
//        }

//        // x,y 좌표 들고오기.
        for (int i = 0; i < (m_count-1); i++ ){
            NationWeatherTable location = NationWeatherdb.nationWeatherDao().get(m_location1).get(i);
            if(location.name2.equals(m_location2))
            {
                Log.d("db_name1", String.valueOf(location));
                Log.d("db_name1", (String.valueOf(location.x) + ":::" + String.valueOf(location.y)));
                m_MyLocationX = location.x;
                m_MyLocationY = location.y;
                break;
            }
        }
    }







}