package com.ulan.gopermission;
 
import android.app.Activity;
import android.os.Bundle;
import android.os.Build;
import android.Manifest;
import android.content.pm.PackageManager;
import android.widget.Toast;

public class MainActivity extends Activity { 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		// Around here, let's check first if the android version is 6.0
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
			// If true, the code will be exist
		    // Now let's check for the permission if granted
			if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
				Toast.makeText(MainActivity.this, "Granted", 1).show();
			}else{
				// Request for permission to grant
				requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
			}
		}
    }
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		switch(requestCode){
			case 0:
				// Write External Storage permission request
				if(grantResults.length > 0 & grantResults[0] == PackageManager.PERMISSION_GRANTED){
					Toast.makeText(MainActivity.this, "Permission Granted", 1).show();
				}else{
					Toast.makeText(MainActivity.this, "Permission Denied", 1).show();
				}
			break;
		}
	}
} 
