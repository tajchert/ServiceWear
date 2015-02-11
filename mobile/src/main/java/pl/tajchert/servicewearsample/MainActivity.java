package pl.tajchert.servicewearsample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSend = (Button) findViewById(R.id.buttonSend);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Send String to Wear device, it will be catch in WearableListenerService of a ServiceWear lib,
                // and pass as a BroadcastReceiver to all listeners, that extends WearServiceReceiver (from lib),
                // also they need to be declared in Manifest file .
                new SendCommandToNode("pathTest", "Test message".getBytes(), MainActivity.this).start();
            }
        });
    }
}
