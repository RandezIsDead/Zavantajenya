package com.mr_trying.companion.Activities.SecondaryActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;

import com.mr_trying.companion.R;

import org.osmdroid.api.IMapController;
import org.osmdroid.bonuspack.routing.MapQuestRoadManager;
import org.osmdroid.bonuspack.routing.Road;
import org.osmdroid.bonuspack.routing.RoadManager;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.Polyline;

import java.util.ArrayList;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        MapView map = (MapView) findViewById(R.id.map);

        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);
        map.setUseDataConnection(true);
        map.setTileSource(TileSourceFactory.OpenTopo  );

        GeoPoint startPoint = new GeoPoint(48.13, -1.63);
        GeoPoint endPoint = new GeoPoint(48.4, -1.9);

        IMapController mapController = map.getController();
        mapController.setZoom(9);
        mapController.setCenter(startPoint);
        Marker startMarker = new Marker(map);
        Marker endMarker = new Marker(map);
        startMarker.setPosition(startPoint);
        endMarker.setPosition(endPoint);
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(startMarker);
        startMarker.setTitle("Start point");
        map.getOverlays().add(endMarker);
        endMarker.setTitle("End point");
        RoadManager roadManager = new MapQuestRoadManager("qV9E0u8zPSKV4UBzRTNKwjqZjfKp3nBK");
        roadManager.addRequestOption("RAIL_STATION=1");

        ArrayList<GeoPoint> waypoints = new ArrayList<>();
        waypoints.add(startPoint);

        waypoints.add(endPoint);
        Road road = roadManager.getRoad(waypoints);
        Polyline roadOverlay = RoadManager.buildRoadOverlay(road);
        map.getOverlays().add(roadOverlay);
        map.invalidate();
    }
}