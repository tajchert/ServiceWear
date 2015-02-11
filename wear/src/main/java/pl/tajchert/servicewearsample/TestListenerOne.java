package pl.tajchert.servicewearsample;

import android.util.Log;
import android.widget.Toast;

import pl.tajchert.servicewear.WearServiceReceiver;


public class TestListenerOne extends WearServiceReceiver {
    private static final String TAG = TestListenerTwo.class.getSimpleName();

    @Override
    public void onMessageReceived(String path, byte[] data) {
        Log.d(TAG, "receiver ONE: " + path + ", " + new String(data));
        Toast.makeText(mContext, "First receiver!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPeerConnected(String peerName, String peerId) {
        Log.d(TAG, "connected peer: " + peerName);
        Toast.makeText(mContext, "Peer connected!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPeerDisconnected(String peerName, String peerId) {
        Log.d(TAG, "disconnected peer: " + peerName);
        Toast.makeText(mContext, "Peer disconnected!", Toast.LENGTH_SHORT).show();
    }
}
