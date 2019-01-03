package com.bm.plugins;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * This class echoes a string called from JavaScript.
 */
public class StrictDate extends CordovaPlugin {
	
	Boolean isAutomaticDateTimeEnabled;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("isAutomaticDateTimeEnabled")) {
            this.isAutomaticDateTimeEnabled(callbackContext);
            return true;
        }
        return false;
    }

    private void isAutomaticDateTimeEnabled(CallbackContext callbackContext) {
        String message = "blue";
		
		Context context = this.cordova.getActivity().getApplicationContext();
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            isAutomaticDateTimeEnabled =  Settings.Global.getInt(context.getContentResolver(), Settings.Global.AUTO_TIME, 0) == 1;
        } else {
            isAutomaticDateTimeEnabled = android.provider.Settings.System.getInt(context.getContentResolver(), android.provider.Settings.System.AUTO_TIME, 0) == 1;
        }
		
		message = isAutomaticDateTimeEnabled?"true":"false";
		
		if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
