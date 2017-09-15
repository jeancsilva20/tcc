package com.example.jeanc.gpsbolado;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnOn;
    private EditText edLatitude, edLongitude, edStatus;
    private TextView txStatus, txLatitude, txLongitude;
    private LocationManager lmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edLatitude = (EditText) findViewById(R.id.edtlatitude);
        edLongitude = (EditText) findViewById(R.id.edtLongitude);
        btnOn = (Button) findViewById(R.id.btnOn);
        edStatus = (EditText) findViewById(R.id.edtStatus);

        findViewById(R.id.btnOn).setOnClickListener(OnclickGps());


    }

    public void updateView(Location loc){
        Double latitude = loc.getLatitude();
        Double longitude = loc.getLongitude();

        edLatitude.setText(latitude.toString());
        edLongitude.setText(longitude.toString());
    }

    public void startGps(){

        lmManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        LocationListener lListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                updateView(location);
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {
                switch (i){
                    case LocationProvider.OUT_OF_SERVICE:
                        edStatus.setText("fora de Serviço");
                        break;
                    case LocationProvider.TEMPORARILY_UNAVAILABLE:
                        edStatus.setText("Indisponivel");
                        break;
                    case LocationProvider.AVAILABLE:
                        edStatus.setText("Disponivel");
                        break;
                    default:
                }
            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };
        lmManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,lListener);
    }

    private View.OnClickListener OnclickGps() {
        return new View.OnClickListener(){
            @Override
            public void onClick (View v){
                startGps();
            }
        };
    }
}
