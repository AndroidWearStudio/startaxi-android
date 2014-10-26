package lt.andro.startaxi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.GridViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import lt.andro.startaxi.R;
import lt.andro.startaxi.views.CardAdapter;
import lt.andro.startaxi.views.CardItemView;

/**
 * @author Vilius Kraujutis
 * @since 2014-10-26 15:22
 */
public class WaitingForTaxiActivity extends BaseActivity {

    @InjectView(R.id.activity_destination_chooser_pager)
    GridViewPager pager;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_chooser);
        ButterKnife.inject(this);

        List<View> cards = new ArrayList<View>(2);
        cards.add(CardItemView.createCard(this, "On it's way", "Red Taxi", R.drawable.ic_launcher));

        pager.setAdapter(new CardAdapter(cards));
        cards.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WaitingForTaxiActivity.this, ProvidersActivity.class));
            }
        });
    }
}
