package pl.tajchert.servicewearsample;

import android.util.Log;
import android.widget.Toast;

import pl.tajchert.servicewear.Receiver;


public class TestListenerTwo extends Receiver {
    private static final String TAG = TestListenerTwo.class.getSimpleName();

    @Override
    public void onMessageReceived(String path, byte[] data) {
        super.onMessageReceived(path, data);
        Log.d(TAG, "receiver TWO: " + path + ", " + new String(data));
        Toast.makeText(mContext, "Second receiver!", Toast.LENGTH_SHORT).show();
    }
}
