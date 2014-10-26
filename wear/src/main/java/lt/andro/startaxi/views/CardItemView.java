package lt.andro.startaxi.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.wearable.view.CircledImageView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import lt.andro.startaxi.R;

/**
 * @author Andrius Semionovas
 * @since 2014-10-25
 */
public class CardItemView extends LinearLayout {

    @InjectView(R.id.view_card_item_button)
    CircledImageView button;
    @InjectView(R.id.view_card_item_description)
    TextView description;
    @InjectView(R.id.view_card_item_title)
    TextView title;

    public CardItemView(Context context) {
        this(context, null);
    }

    public CardItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CardItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setOrientation(VERTICAL);

        LayoutInflater.from(context).inflate(R.layout.view_card_item, this);

        ButterKnife.inject(this);

        if (attrs != null) {
            TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CardItemView, 0, 0);

            setTitle(ta.getText(R.styleable.CardItemView_title));
            setDescription(ta.getText(R.styleable.CardItemView_description));
            setImage(ta.getResourceId(R.styleable.CardItemView_src, 0));
        }
    }

    public void setTitle(CharSequence title) {
        this.title.setText(title);
    }

    public void setDescription(CharSequence description) {
        this.description.setText(description);
    }

    public void setImage(int resId) {
        button.setImageResource(resId);
    }

    public void setOnButtonClickListener(OnClickListener l) {
        button.setOnClickListener(l);
    }

    public static CardItemView createCard(Context context, CharSequence title, CharSequence description, int image) {
        CardItemView cardItemView = new CardItemView(context);

        cardItemView.setTitle(title);
        cardItemView.setDescription(description);
        cardItemView.setImage(image);

        return cardItemView;
    }
}
