package pl.tajchert.servicewearsample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String testMessage = "Test message";
        new SendCommandToNode("pathTest", testMessage.getBytes(), MainActivity.this).start();
    }
}
