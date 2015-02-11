package pl.tajchert.servicewear;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.wearable.Node;


public class Receiver extends BroadcastReceiver {
    public Context mContext;

    @Override
    public final void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            mContext = context;
            String event = extras.getString(ServiceWearConst.WEAR_EVENT_KEY);
            if (ServiceWearConst.ON_MESSAGE_RECEIVED_EVENT.equals(event)) {
                String path = extras.getString(ServiceWearConst.INTENT_MESSAGE_PATH);
                byte[] data = extras.getByteArray(ServiceWearConst.INTENT_MESSAGE_DATA);
                onMessageReceived(path, data);
            } else if (ServiceWearConst.ON_DATA_CHANGE_EVENT.equals(event)) {
                String uri = extras.getString(ServiceWearConst.INTENT_DATA_PATH);
                byte[] data = extras.getByteArray(ServiceWearConst.INTENT_DATA_DATA);
                onDataChanged(uri, data);
            }
        }
    }

    public void onDataChanged(String uri, byte[] data) {
    }

    public void onMessageReceived(String path, byte[] data) {
    }

    public void onPeerConnected(Node peer) {

    }

    public void onPeerDisconnected(Node peer) {

    }
}
