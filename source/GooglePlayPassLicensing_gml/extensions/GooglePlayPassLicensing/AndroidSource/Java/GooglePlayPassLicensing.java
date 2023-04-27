
package ${YYAndroidPackageName};

import com.yoyogames.runner.RunnerJNILib;

import android.app.Activity;
import android.util.Log;

import android.app.PendingIntent;
import android.content.IntentSender;
import com.google.licensingservicehelper.LicensingServiceCallback;
import com.google.licensingservicehelper.LicensingServiceHelper;

public class GooglePlayPassLicensing implements​ LicensingServiceCallback​
{

    private static final int EVENT_OTHER_SOCIAL = 70;
    Activity activity = RunnerActivity.CurrentActivity;

    private LicensingServiceHelper licensingServiceHelper;
	        
	public void GooglePlayPassLicensing_CheckLicense()
	{
		licensingServiceHelper = new LicensingServiceHelper(activity, RunnerActivity.BASE64_PUBLIC_KEY);
		licensingServiceHelper.checkLicense(this);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void allow(String payloadJson) 
	{
		int dsMapIndex = RunnerJNILib.jCreateDsMap(null, null, null);
		RunnerJNILib.DsMapAddString(dsMapIndex,"type","GooglePlayPassLicensing");
		RunnerJNILib.DsMapAddString(dsMapIndex,"event","LICENSED");
		RunnerJNILib.CreateAsynEventWithDSMap(dsMapIndex,EVENT_OTHER_SOCIAL);
		
		//DESTROY
		licensingServiceHelper.onDestroy();
	}
	
	@Override
	public void dontAllow(PendingIntent pendingIntent) 
	{
		int dsMapIndex = RunnerJNILib.jCreateDsMap(null, null, null);
		RunnerJNILib.DsMapAddString(dsMapIndex,"type","GooglePlayPassLicensing");
		RunnerJNILib.DsMapAddString(dsMapIndex,"event","NOT_LICENSED");

		try 
		{
			licensingServiceHelper.showPaywall(pendingIntent);
			RunnerJNILib.DsMapAddDouble(dsMapIndex,"value",1.0);
		} 
		catch (IntentSender.SendIntentException e) 
		{
			RunnerJNILib.DsMapAddDouble(dsMapIndex,"value",0.0);
		}
		
		RunnerJNILib.CreateAsynEventWithDSMap(dsMapIndex,EVENT_OTHER_SOCIAL);
		
		//DESTROY
		licensingServiceHelper.onDestroy();
	}
	
	@Override
	public void applicationError(String errorMessage) 
	{
		int dsMapIndex = RunnerJNILib.jCreateDsMap(null, null, null);
		RunnerJNILib.DsMapAddString( dsMapIndex, "type", "GooglePlayPassLicensing");
		RunnerJNILib.DsMapAddString( dsMapIndex, "event", "ERROR");
		RunnerJNILib.DsMapAddString( dsMapIndex, "value", errorMessage);
		RunnerJNILib.CreateAsynEventWithDSMap(dsMapIndex, EVENT_OTHER_SOCIAL);
		
		//DESTROY
		licensingServiceHelper.onDestroy();
	}
}

