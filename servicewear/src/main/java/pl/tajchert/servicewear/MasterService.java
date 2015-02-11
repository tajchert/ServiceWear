package pl.tajchert.servicewear;

import android.content.Intent;
import android.net.Uri;

import com.google.android.gms.common.data.FreezableUtils;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.WearableListenerService;

import java.util.List;

public class MasterService extends WearableListenerService {
    @Override
    public void onDataChanged(DataEventBuffer dataEvents) {
        super.onDataChanged(dataEvents);
        final List<DataEvent> events = FreezableUtils.freezeIterable(dataEvents);
        for (DataEvent event : events) {
            Intent intent = new Intent();
            intent.setAction("pl.tajchert.servicewear.wearservice");
            intent.putExtra(ServiceWearConst.WEAR_EVENT_KEY, ServiceWearConst.ON_DATA_CHANGE_EVENT);
            intent.putExtra(ServiceWearConst.INTENT_DATA_PATH, event.getDataItem().getUri().toString());
            intent.putExtra(ServiceWearConst.INTENT_DATA_DATA, event.getDataItem().getData());
            sendBroadcast(intent);
        }
    }

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        super.onMessageReceived(messageEvent);
        Intent intent = new Intent();
        intent.setAction("pl.tajchert.servicewear.wearservice");
        intent.putExtra(ServiceWearConst.WEAR_EVENT_KEY, ServiceWearConst.ON_MESSAGE_RECEIVED_EVENT);
        intent.putExtra(ServiceWearConst.INTENT_MESSAGE_PATH, messageEvent.getPath());
        intent.putExtra(ServiceWearConst.INTENT_MESSAGE_DATA, messageEvent.getData());
        sendBroadcast(intent);
    }

    @Override
    public void onPeerConnected(Node peer) {
        super.onPeerConnected(peer);
        Intent intent = new Intent();
        intent.setAction("pl.tajchert.servicewear.wearservice");
        intent.putExtra(ServiceWearConst.WEAR_EVENT_KEY, ServiceWearConst.ON_PEER_CONNECTED_EVENT);
        intent.putExtra(ServiceWearConst.INTENT_PEER_NAME, peer.getDisplayName());
        intent.putExtra(ServiceWearConst.INTENT_PEER_ID, peer.getId());
        sendBroadcast(intent);
    }

    @Override
    public void onPeerDisconnected(Node peer) {
        super.onPeerDisconnected(peer);
        Intent intent = new Intent();
        intent.setAction("pl.tajchert.servicewear.wearservice");
        intent.putExtra(ServiceWearConst.WEAR_EVENT_KEY, ServiceWearConst.ON_PEER_DISCONNECTED_EVENT);
        intent.putExtra(ServiceWearConst.INTENT_PEER_NAME, peer.getDisplayName());
        intent.putExtra(ServiceWearConst.INTENT_PEER_ID, peer.getId());
        sendBroadcast(intent);
    }
}
