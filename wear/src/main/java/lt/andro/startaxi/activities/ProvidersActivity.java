package lt.andro.startaxi.activities;

import android.os.Bundle;

import java.util.List;

import lt.andro.both.api.entity.Estimate;
import lt.andro.both.api.entity.PossibleJourneys;

/**
 * @author Andrius Semionovas
 * @since 2014-10-26
 */
public class ProvidersActivity extends BaseActivity {
    public final static String EXTRA_DESTINATION = "destination";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadProviders("Home");
    }

    private void loadProviders(String address) {
        //here need to convert address to possible journeys

        loadProviders(new PossibleJourneys());
    }

    private void loadProviders(PossibleJourneys possibleJourneys) {
        //load estimations and pass to next method
    }

    private void loadedEstimates(List<Estimate> estimates) {
//
    }
}
