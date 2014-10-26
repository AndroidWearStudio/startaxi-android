package lt.andro.startaxi.views;

import android.support.wearable.view.GridPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author Andrius Semionovas
 * @since 2014-10-26
 */
public class CardAdapter extends GridPagerAdapter {

    public List<View> cards;

    public CardAdapter(List<View> cards) {
        this.cards = cards;
    }

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount(int i) {
        return cards.size();
    }

    @Override
    protected Object instantiateItem(ViewGroup viewGroup, int row, int column) {
        View card = cards.get(column);

        viewGroup.addView(card);

        return card;
    }

    @Override
    protected void destroyItem(ViewGroup viewGroup, int row, int column, Object o) {
        viewGroup.removeView((View) o);
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }
}
