package com.example.androidapp.create;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.androidapp.AlertsPage;
import com.example.androidapp.FloorPlan;
import com.example.androidapp.HubPage;
import com.example.androidapp.R;
import com.example.androidapp.SettingsPage;
import com.example.androidapp.control.DeviceSelection;

public class AddDevice extends AppCompatActivity {


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.homeMenu:
                Intent startHome = new Intent(getApplicationContext(), HubPage.class);
                startActivity(startHome);
                return true;

            case R.id.devicesMenu:
                return true;

            case R.id.controlDevice:
                Intent startControls = new Intent(getApplicationContext(), DeviceSelection.class);
                startActivity(startControls);
                return true;

            case R.id.addDeviceMenu:
                Intent startAdding = new Intent(getApplicationContext(), AddDevice.class);
                startActivity(startAdding);
                return true;

            case R.id.alertsMenu:
                Intent startAlerts = new Intent(getApplicationContext(), AlertsPage.class);
                startActivity(startAlerts);
                return true;

            case R.id.floorplanMenu:
                Intent startFloorPlan = new Intent(getApplicationContext(), FloorPlan.class);
                startActivity(startFloorPlan);
                return true;

            case R.id.settingsMenu:
                Intent startSettings = new Intent(getApplicationContext(), SettingsPage.class);
                startActivity(startSettings);
                return true;

            case R.id.logOutMenu:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device);

        Button addTvButton = (Button)findViewById(R.id.addTvButton);
        Button addLightButton = (Button)findViewById(R.id.addLightButton);
        Button addThermButton = (Button)findViewById(R.id.addThermButton);
        Button addFanButton = (Button)findViewById(R.id.addFanButton);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addTvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startTv = new Intent(getApplicationContext(), AddTv.class);
                startActivity(startTv);
            }
        });

        addLightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startLights = new Intent(getApplicationContext(), AddLight.class);
                startActivity(startLights);
            }
        });

        addThermButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startTherm = new Intent(getApplicationContext(), AddThermostat.class);
                startActivity(startTherm);
            }
        });

        addFanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startFan = new Intent(getApplicationContext(), AddFan.class);
                startActivity(startFan);
            }
        });


    }
}
