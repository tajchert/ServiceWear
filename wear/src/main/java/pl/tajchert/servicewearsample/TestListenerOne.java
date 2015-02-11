package pl.tajchert.servicewearsample;

import android.util.Log;
import android.widget.Toast;

import pl.tajchert.servicewear.Receiver;


public class TestListenerOne extends Receiver {
    private static final String TAG = TestListenerTwo.class.getSimpleName();

    @Override
    public void onMessageReceived(String path, byte[] data) {
        super.onMessageReceived(path, data);
        Log.d(TAG, "receiver ONE: " + path + ", " + new String(data));
        Toast.makeText(mContext, "First receiver!", Toast.LENGTH_SHORT).show();
    }
}
