package lt.andro.startaxi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.GridViewPager;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.InjectView;
import lt.andro.startaxi.R;
import lt.andro.startaxi.views.CardAdapter;
import lt.andro.startaxi.views.CardItemView;

import java.util.ArrayList;
import java.util.List;

public class DestinationChooserActivity extends BaseActivity {
    @InjectView(R.id.activity_destination_chooser_pager)
    GridViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_chooser);
        ButterKnife.inject(this);

        List<View> cards = new ArrayList<View>(2);
        cards.add(CardItemView.createCard(this, "Home", "~2 km", R.drawable.home));
        cards.add(CardItemView.createCard(this, "Work", "~10 km", R.drawable.work));

        pager.setAdapter(new CardAdapter(cards));
        cards.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DestinationChooserActivity.this, ProvidersActivity.class));
            }
        });
    }
}
