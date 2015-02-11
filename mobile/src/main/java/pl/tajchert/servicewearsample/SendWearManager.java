package pl.tajchert.servicewearsample;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.Wearable;

public class SendWearManager {
    private static GoogleApiClient mGoogleApiClient;

    public static GoogleApiClient getInstance (Context context) {
        if(mGoogleApiClient == null) {
            if(context == null) {
                return null;
            }
            mGoogleApiClient = new GoogleApiClient.Builder(context)
                    .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                        @Override
                        public void onConnected(Bundle connectionHint) {
                            Log.d("TAG", "onConnected");
                            // Now you can use the Data Layer API
                        }
                        @Override
                        public void onConnectionSuspended ( int cause){
                            Log.d("TAG", "onConnectionSuspended");
                        }
                    }).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
                        @Override
                        public void onConnectionFailed(ConnectionResult result) {
                            Log.d("TAG", "onConnectionFailed");
                        }
                    }).addApi(Wearable.API).build();
        }
        return mGoogleApiClient;
    }
}