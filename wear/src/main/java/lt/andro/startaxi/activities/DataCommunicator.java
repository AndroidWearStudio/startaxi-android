package lt.andro.startaxi.activities;

import android.util.Log;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.Wearable;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author Vilius Kraujutis
 * @since 2014-10-26 13:48
 */
public class DataCommunicator {
    private static final String TAG = DataCommunicator.class.getCanonicalName();
    private final BaseActivity activity;
    Node node; // the connected device to send the message to
    GoogleApiClient mGoogleApiClient;

    public DataCommunicator(BaseActivity activity) {
        this.activity = activity;
        mGoogleApiClient = new GoogleApiClient.Builder(activity)
                .addApi(Wearable.API)
                .build();
    }

    public void sendMessage(String message) {
        Log.d(TAG, "Sending message:" + message);
        Collection<String> nodes = getNodes();
        for (String node : nodes) {
            sendMessage(node, message);
        }
    }

    public void sendMessage(String node, String message) {
        MessageApi.SendMessageResult result = Wearable.MessageApi.sendMessage(mGoogleApiClient, node, message, null).await();
        if (!result.getStatus().isSuccess()) {
            Log.e(TAG, "ERROR: failed to send Message: " + result.getStatus());
        } else {
            Log.e(TAG, "INFO: success to send Message: " + result.getStatus());
        }
    }

    private Collection<String> getNodes() {
        HashSet<String> results = new HashSet<String>();
        NodeApi.GetConnectedNodesResult nodes =
                Wearable.NodeApi.getConnectedNodes(mGoogleApiClient).await();
        for (Node node : nodes.getNodes()) {
            results.add(node.getId());
        }
        return results;
    }

}
