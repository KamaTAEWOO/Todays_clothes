package com.example.todayclothes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.room.Room;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.todayclothes.mylocation.GpsTracker;
import com.example.todayclothes.weatherdatabase.AppDatabase;
import com.example.todayclothes.weatherdatabase.NationWeatherTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Object NationWeatherTable;
    private String m_myLocationData; // 서울특별시 종로구

    // 주소를 나눠서 저장
    static String address_result = ""; // 전체주소를 담음.
    String m_location1; // 경상북도
    String m_location2; // 경산시
    String m_location3; // 진량읍

    // current Location
    private GpsTracker gpsTracker;

    private static final int GPS_ENABLE_REQUEST_CODE = 2001;
    private static final int PERMISSIONS_REQUEST_CODE = 100;
    String[] REQUIRED_PERMISSIONS  = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};

    // 현재위치의 x좌표
    static int m_MyLocationX = 0;
    // 현재위치의 y좌표
    static int m_MyLocationY = 0;
    private int m_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);


        LocationStart(); // 현재위치를 가지고옴.
        weatherAddressDatabese(); // 주소록 -> 데이터베이스 안에 넣기.
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException interruptedException) {
//            interruptedException.printStackTrace();
//        }

        Handler hand = new Handler();

        hand.postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent i = new Intent(MainActivity.this, MainWeatherPage.class);
                startActivity(i);
                finish();
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException interruptedException) {
//                    interruptedException.printStackTrace();
//                }

            }
        }, 5000);
    }

    // 여기서부터 시작임.
    public void LocationStart(){
        // 현재 위치 가지고 오는 함수
        if (!checkLocationServicesStatus()) {

            showDialogForLocationServiceSetting();
        }else {
            checkRunTimePermission();
        }

        gpsTracker = new GpsTracker(MainActivity.this);

        double latitude = gpsTracker.getLatitude();
        double longitude = gpsTracker.getLongitude();

        String address = getCurrentAddress(latitude, longitude);
        try {
            Thread.sleep(3000);
            if(address.equals("주소 미발견")){
                LocationStart();
            }else{
                Log.d("address1=", address); // 주소가 뜸

                String[] result = address.split(" "); // 띄워쓰기마다 토큰 저장
                try {
                    address_result = result[1] + " " + result[2] + " " + result[3]; // 결과 :
                }catch (Exception e){
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
                Log.d("address2=", result[1]); // 주소가 뜸.
                Log.d("address3=", result[2]); // 주소가 뜸.
                m_location1 = result[1];
                //m_location1 = "대구광역시";
                m_location2 = result[2];
                //m_location2 = "도원동";
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
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
            }
            else {
                // 거부한 퍼미션이 있다면 앱을 사용할 수 없는 이유를 설명해주고 앱을 종료합니다.2 가지 경우가 있습니다.

                if (ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[0])
                        || ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[1])) {

                    Toast.makeText(MainActivity.this, "퍼미션이 거부되었습니다. 앱을 다시 실행하여 퍼미션을 허용해주세요.", Toast.LENGTH_LONG).show();
                    finish();

                }else {

                    Toast.makeText(MainActivity.this, "퍼미션이 거부되었습니다. 설정(앱 정보)에서 퍼미션을 허용해야 합니다. ", Toast.LENGTH_LONG).show();

                }
            }

        }
    }

    void checkRunTimePermission(){
        //런타임 퍼미션 처리
        // 1. 위치 퍼미션을 가지고 있는지 체크합니다.
        int hasFineLocationPermission = ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        int hasCoarseLocationPermission = ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_COARSE_LOCATION);

        if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED &&
                hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED) {

            // 2. 이미 퍼미션을 가지고 있다면
            // ( 안드로이드 6.0 이하 버전은 런타임 퍼미션이 필요없기 때문에 이미 허용된 걸로 인식합니다.)


            // 3.  위치 값을 가져올 수 있음

        } else {  //2. 퍼미션 요청을 허용한 적이 없다면 퍼미션 요청이 필요합니다. 2가지 경우(3-1, 4-1)가 있습니다.

            // 3-1. 사용자가 퍼미션 거부를 한 적이 있는 경우에는
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, REQUIRED_PERMISSIONS[0])) {
                // 3-2. 요청을 진행하기 전에 사용자가에게 퍼미션이 필요한 이유를 설명해줄 필요가 있습니다.
                Toast.makeText(MainActivity.this, "이 앱을 실행하려면 위치 접근 권한이 필요합니다.", Toast.LENGTH_LONG).show();
                // 3-3. 사용자게에 퍼미션 요청을 합니다. 요청 결과는 onRequestPermissionResult에서 수신됩니다.
                ActivityCompat.requestPermissions(MainActivity.this, REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE);

            } else {
                // 4-1. 사용자가 퍼미션 거부를 한 적이 없는 경우에는 퍼미션 요청을 바로 합니다.
                // 요청 결과는 onRequestPermissionResult에서 수신됩니다.
                ActivityCompat.requestPermissions(MainActivity.this, REQUIRED_PERMISSIONS,
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
        return address.getAddressLine(0) +"\n";
    }

    //여기부터는 GPS 활성화를 위한 메소드들
    private void showDialogForLocationServiceSetting() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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

    //******************************  주소록 DB **************************************
    // 주소 정보를 데이터 베이스 안에 넣는다. room 사용. 처음 한번만 실행
    public void weatherAddressDatabese()
    {
        Boolean DatabaseCheck = false;
        // 데이터베이스에 주소록 저장
        SharedPreferences sh2 = getSharedPreferences("MyDatabase", MODE_PRIVATE);
        DatabaseCheck=sh2.getBoolean("DatabaseCheck", false);
        Log.d("DatabaseCheck", String.valueOf(DatabaseCheck));

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
                com.example.todayclothes.weatherdatabase.NationWeatherTable input = new NationWeatherTable(
                        Long.parseLong(NationArray[0]),
                        NationArray[1],
                        NationArray[2],
                        NationArray[3],
                        Integer.parseInt(NationArray[4]),
                        Integer.parseInt(NationArray[5])
                );
                if(DatabaseCheck == false){
                    NationWeatherdb.nationWeatherDao().insert(input);
                    //Log.d("m_count", String.valueOf(m_count));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        SharedPreferences sh1 = getSharedPreferences("MyDatabase", MODE_PRIVATE);
        sh1.edit().putBoolean("DatabaseCheck", true).commit();

        weatherAddressDatabese1(); // 시발코드..

        Log.d("데이터베이스", "지나감1");
        Log.d("데이터베이스", m_location1);
        Log.d("데이터베이스", m_location2);

//        for (int i = 0; i < (m_count-1); i++ ){
//            NationWeatherTable output = NationWeatherdb.nationWeatherDao().getall().get(i);
//            Log.d("db_test", String.valueOf(output));
//        }

//        // x,y 좌표 들고오기.
        for (int i = 0; i < (m_count-1); i++ ){
            NationWeatherTable location = NationWeatherdb.nationWeatherDao().get(m_location1).get(i);
            Log.d("데이터베이스", "지나감11");
            if(location.name2.equals(m_location2)) {
                Log.d("db_name1", String.valueOf(location));
                Log.d("db_name1", (location.x + ":::" + location.y));
                m_MyLocationX = location.x;
                m_MyLocationY = location.y;
                Log.d("데이터베이스", "지나감2");
                break;
            }else if(location.name3.equals(m_location2)){
                Log.d("db_name1", String.valueOf(location));
                Log.d("db_name1", (location.x + ":::" + location.y));
                m_MyLocationX = location.x;
                m_MyLocationY = location.y;
                Log.d("데이터베이스", "지나감3");
                break;
            }
//            if(location.name2.equals(m_location2))
//            {
//                Log.d("db_name1", String.valueOf(location));
//                Log.d("db_name1", (String.valueOf(location.x) + ":::" + String.valueOf(location.y)));
//                m_MyLocationX = location.x;
//                m_MyLocationY = location.y;
//                break;
//            }else if(location.name3.equals(m_location3)){
//                Log.d("db_name1", String.valueOf(location));
//                Log.d("db_name1", (String.valueOf(location.x) + ":::" + String.valueOf(location.y)));
//                m_MyLocationX = location.x;
//                m_MyLocationY = location.y;
//                break;
//            }
        }
    }
    public void weatherAddressDatabese1()
    {
        //정의한 데이터베이스를 생성 .allowMainThreadQueries()는 메인 스레드에서 Room을 사용가능하게 해줌
        AppDatabase NationWeatherdb = Room.databaseBuilder(this, AppDatabase.class, "db")
                .allowMainThreadQueries()
                .build();

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
                com.example.todayclothes.weatherdatabase.NationWeatherTable input = new NationWeatherTable(
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
//        // x,y 좌표 들고오기.
        for (int i = 0; i < (m_count-1); i++ ){
            NationWeatherTable location = NationWeatherdb.nationWeatherDao().get(m_location1).get(i);
            Log.d("데이터베이스", "지나감11");
            if(location.name2.equals(m_location2)) {
                Log.d("db_name1", String.valueOf(location));
                Log.d("db_name1", (location.x + ":::" + location.y));
                m_MyLocationX = location.x;
                m_MyLocationY = location.y;
                Log.d("데이터베이스", "지나감2");
                break;
            }else if(location.name3.equals(m_location2)){
                Log.d("db_name1", String.valueOf(location));
                Log.d("db_name1", (location.x + ":::" + location.y));
                m_MyLocationX = location.x;
                m_MyLocationY = location.y;
                Log.d("데이터베이스", "지나감3");
                break;
            }

        }
    }

}