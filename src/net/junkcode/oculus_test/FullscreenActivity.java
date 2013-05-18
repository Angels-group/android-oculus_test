package net.junkcode.oculus_test;

import java.util.HashMap;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class FullscreenActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                 WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        
		setContentView(R.layout.activity_fullscreen);
		
		
		/** get usb **/
		USBmanager usb = new USBmanager(this);
		
		/** setup scene **/
		MyGLSurfaceView glSurfaceView_left = (MyGLSurfaceView)findViewById(R.id.surfaceviewclass_1);
		MyGLSurfaceView glSurfaceView_right = (MyGLSurfaceView)findViewById(R.id.surfaceviewclass_2);
        		
		Cube cube = new Cube();
		AndroidRotationSensor sens = new AndroidRotationSensor(this);
		
		glSurfaceView_left.setRenderer(new MyOpenGLRenderer(cube,sens,true));
		glSurfaceView_right.setRenderer(new MyOpenGLRenderer(cube,sens,false));
		
		
	}


}
