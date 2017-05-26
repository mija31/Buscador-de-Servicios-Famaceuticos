package wil.rutascbba.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import wil.rutascbba.R;
import wil.rutascbba.activities.MainActivity;

import static wil.rutascbba.R.*;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Bundle bundle;
    String titulo;
    Toolbar toolbar;
    List<Integer> tipos_map = new ArrayList<>();
    FloatingActionButton btn_tipo_maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(id.map);
        mapFragment.getMapAsync(this);

        //recuperamos el bundle
        bundle = getIntent().getExtras();
        titulo = bundle.getString("titulo");
        setTitle(titulo);

        toolbar = (Toolbar) findViewById(id.toolbar_maps);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cargarTiposMaps();

        FloatingActionButton btn_ida = (FloatingActionButton) findViewById(id.btn_ida);
        btn_ida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        FloatingActionButton btn_vuelta = (FloatingActionButton) findViewById(id.btn_vuelta);
        btn_vuelta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        btn_tipo_maps = (FloatingActionButton) findViewById(id.btn_tipo_maps);
        btn_tipo_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int actual = mMap.getMapType();
                if (actual == tipos_map.get(0)) {
                    mMap.setMapType(tipos_map.get(1));
                    btn_tipo_maps.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), drawable.satellite));
                }
                if (actual == tipos_map.get(1)) {
                    mMap.setMapType(tipos_map.get(0));
                    btn_tipo_maps.setImageDrawable(ContextCompat.getDrawable(getBaseContext(), drawable.image_filter_hdr));
                }
            }
        });
    }

    private void cargarTiposMaps() {
        tipos_map.add(GoogleMap.MAP_TYPE_NORMAL);
        tipos_map.add(GoogleMap.MAP_TYPE_SATELLITE);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng cbba = new LatLng(-17.408453,-66.164702);
        mMap.addMarker(new MarkerOptions().position(cbba).title("Cochabamba"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cbba,10));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

       switch (item.getItemId()){
           case android.R.id.home:
               Intent intent = new Intent(this,MainActivity.class);
               intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
               startActivity(intent);
               finish();
               break;
           case R.id.des:
               Intent i = new Intent(this,DescripcionActivity.class);
               i.putExtra("titulo",toolbar.getTitle());
               startActivity(i);
               break;
           default:
               break;
       }
        return super.onOptionsItemSelected(item);
    }
}
