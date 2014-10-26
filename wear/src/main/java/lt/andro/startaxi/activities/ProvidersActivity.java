package lt.andro.startaxi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.GridViewPager;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.InjectView;
import lt.andro.both.api.entity.Estimate;
import lt.andro.both.api.entity.PossibleJourneys;
import lt.andro.startaxi.R;
import lt.andro.startaxi.views.CardAdapter;
import lt.andro.startaxi.views.CardItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrius Semionovas
 * @since 2014-10-26
 */
public class ProvidersActivity extends BaseActivity {
    @InjectView(R.id.activity_destination_chooser_pager)
    GridViewPager pager;

    public final static String EXTRA_DESTINATION = "destination";
    private DataCommunicator dataCommunicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_chooser);
        ButterKnife.inject(this);

        List<View> cards = new ArrayList<View>(2);
        cards.add(CardItemView.createCard(this, "Blue taxi", "Arrives in 15 min", R.drawable.taxi));
        cards.add(CardItemView.createCard(this, "Red taxi", "Arrives in 10 min", R.drawable.taxi));

        pager.setAdapter(new CardAdapter(cards));
        cards.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProvidersActivity.this, WaitingForTaxiActivity.class));
            }
        });
    }

    private void loadProviders(String address) {
        //here need to convert address to possible journeys
        loadProviders(new PossibleJourneys());
    }

    private void loadProviders(PossibleJourneys possibleJourneys) {
        //load estimations and pass to next method
        dataCommunicator.sendMessage("Home");
    }

    private void loadedEstimates(List<Estimate> estimates) {
    }
}
