package pl.tajchert.servicewearsample;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.Wearable;

import java.util.concurrent.TimeUnit;

public class SendCommandToNode extends Thread {
    private byte[] objectArray;
    private Context context;
    private String path;


    public SendCommandToNode(String messagePath, byte[] objArray,Context ctx) {
        context = ctx;
        path = messagePath;
        if(objArray != null){
            objectArray = objArray;
        } else {
            objectArray = "".getBytes();
        }
    }

    public void run() {
        if ((objectArray.length / 1024) > 100) {
            throw new RuntimeException("Object is too big to push it via Google Play Services");
        }
        GoogleApiClient googleApiClient = SendWearManager.getInstance(context);
        googleApiClient.blockingConnect(200, TimeUnit.MILLISECONDS);
        NodeApi.GetConnectedNodesResult nodes = Wearable.NodeApi.getConnectedNodes(googleApiClient).await();
        for (Node node : nodes.getNodes()) {
            MessageApi.SendMessageResult result;
            result = Wearable.MessageApi.sendMessage(googleApiClient, node.getId(), path, objectArray).await();
            if (!result.getStatus().isSuccess()) {
                Log.v("TAG", "ERROR: failed to send Message via Google Play Services");
            }
        }
    }
}