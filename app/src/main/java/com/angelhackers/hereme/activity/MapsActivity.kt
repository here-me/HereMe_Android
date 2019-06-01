package com.angelhackers.hereme

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*
import kotlin.concurrent.thread


private const val PERMISSION_REQUEST = 10

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {


    //Google Maps Variable
    private var mMap: GoogleMap? = null


    //GPS Variable
    private var gpsInitialized = false
    lateinit var locationManager: LocationManager
    private var hasGps = false
    private var hasNetwork = false
    private var locationGps: Location? = null
    private var locationNetwork: Location? = null

    private var latitude : Double = 0.0
    private var longitude : Double = 0.0

    var tv_result : String = "";

    private var permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)

    private var mHandler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        //disableView()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkPermission(permissions)) {
                //enableView()
            } else {
                requestPermissions(permissions, PERMISSION_REQUEST)
            }
        } else {
            //enableView()
        }
        getLocation()

        /*

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)


        @SuppressLint("HandlerLeak")
        mHandler = object : Handler() {
            override fun handleMessage(msg: Message) {
                setMapMaker(latitude, longitude);
            }
        }

        thread(start = true) {
            while (true) {
                Thread.sleep(1000)
                mHandler?.sendEmptyMessage(0)
            }
        }*/
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        gpsInitialized = true
        getLocation()
    }



    private fun setMapMaker(x : Double , y : Double) {
        if(gpsInitialized){
            mMap!!.clear()
            Log.d("호출", "================")
            // Add a marker in Syd\ney and move the camera
            val pos = LatLng(x, y)
            mMap!!.addMarker(MarkerOptions().position(pos).title("Marker in Sydney"))
            mMap!!.moveCamera(CameraUpdateFactory.newLatLng(pos))
        }
    }

    @SuppressLint("MissingPermission")

    private fun getLocation() {
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        hasGps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        hasNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        if (hasGps || hasNetwork) {

            if (hasGps) {
                Log.d("CodeAndroidLocation", "hasGps")
                locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    5000,
                    0F,
                    object : LocationListener {
                        override fun onLocationChanged(location: Location?) {
                            if (location != null) {
                                locationGps = location
                                tv_result += "\nGPS "
                                tv_result += "\nLatitude : " + locationGps!!.latitude
                                tv_result +="\nLongitude : " + locationGps!!.longitude
                                latitude = locationNetwork!!.latitude
                                longitude = locationNetwork!!.longitude
                                Log.d("CodeAndroidLocation", " GPS Latitude : " + locationGps!!.latitude)
                                Log.d("CodeAndroidLocation", " GPS Longitude : " + locationGps!!.longitude)
                            }
                        }
                        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

                        }
                        override fun onProviderEnabled(provider: String?) {

                        }
                        override fun onProviderDisabled(provider: String?) {

                        }

                    })

                val localGpsLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                if (localGpsLocation != null)
                    locationGps = localGpsLocation
            }
            if (hasNetwork) {
                Log.d("CodeAndroidLocation", "hasGps")
                locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    5000,
                    0F,
                    object : LocationListener {
                        override fun onLocationChanged(location: Location?) {
                            if (location != null) {
                                locationNetwork = location
                                tv_result += "\nGPS "
                                tv_result += "\nLatitude : " + locationGps!!.latitude
                                tv_result +="\nLongitude : " + locationGps!!.longitude
                                latitude = locationNetwork!!.latitude
                                longitude = locationNetwork!!.longitude
                                Log.d("CodeAndroidLocation", " Network Latitude : " + locationNetwork!!.latitude)
                                Log.d("CodeAndroidLocation", " Network Longitude : " + locationNetwork!!.longitude)
                            }
                        }
                        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

                        }
                        override fun onProviderEnabled(provider: String?) {

                        }
                        override fun onProviderDisabled(provider: String?) {

                        }
                    })

                val localNetworkLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                if (localNetworkLocation != null)
                    locationNetwork = localNetworkLocation
            }

            if (locationGps != null && locationNetwork != null) {
                if (locationGps!!.accuracy > locationNetwork!!.accuracy) {
                    tv_result += "\nGPS "
                    tv_result += "\nLatitude : " + locationGps!!.latitude
                    tv_result +="\nLongitude : " + locationGps!!.longitude
                    latitude = locationNetwork!!.latitude
                    longitude = locationNetwork!!.longitude
                    Log.d("CodeAndroidLocation", " Network Latitude : " + locationNetwork!!.latitude)
                    Log.d("CodeAndroidLocation", " Network Longitude : " + locationNetwork!!.longitude)
                } else {
                    tv_result += "\nGPS "
                    tv_result += "\nLatitude : " + locationGps!!.latitude
                    tv_result +="\nLongitude : " + locationGps!!.longitude
                    latitude = locationNetwork!!.latitude
                    longitude = locationNetwork!!.longitude
                    Log.d("CodeAndroidLocation", " GPS Latitude : " + locationGps!!.latitude)
                    Log.d("CodeAndroidLocation", " GPS Longitude : " + locationGps!!.longitude)
                }
            }

        } else {
            startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
        }

        Log.d("Location",tv_result)
    }

    private fun checkPermission(permissionArray: Array<String>): Boolean {
        var allSuccess = true
        for (i in permissionArray.indices) {
            if (checkCallingOrSelfPermission(permissionArray[i]) == PackageManager.PERMISSION_DENIED)
                allSuccess = false
        }
        return allSuccess
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST) {
            var allSuccess = true
            for (i in permissions.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    allSuccess = false
                    val requestAgain =
                        Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && shouldShowRequestPermissionRationale(
                            permissions[i]
                        )
                    if (requestAgain) {
                        Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Go to settings and enable the permission", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            if (allSuccess){
                //enableView()
            }
        }
    }
}
