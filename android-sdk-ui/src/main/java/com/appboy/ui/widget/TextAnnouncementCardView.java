package com.appboy.ui.widget;

import android.content.Context;
import android.widget.TextView;

import com.appboy.models.cards.TextAnnouncementCard;
import com.appboy.ui.R;
import com.braze.ui.actions.IAction;
import com.appboy.ui.feed.view.BaseFeedCardView;
import com.braze.support.BrazeLogger;

public class TextAnnouncementCardView extends BaseFeedCardView<TextAnnouncementCard> {
  private static final String TAG = BrazeLogger.getBrazeLogTag(TextAnnouncementCardView.class);
  private final TextView mTitle;
  private final TextView mDescription;
  private final TextView mDomain;
  private IAction mCardAction;

  public TextAnnouncementCardView(Context context) {
    this(context, null);
  }

  @SuppressWarnings("deprecation") // getDrawable() until Build.VERSION_CODES.LOLLIPOP
  public TextAnnouncementCardView(final Context context, TextAnnouncementCard card) {
    super(context);
    mTitle = findViewById(R.id.com_appboy_text_announcement_card_title);
    mDescription = findViewById(R.id.com_appboy_text_announcement_card_description);
    mDomain = findViewById(R.id.com_appboy_text_announcement_card_domain);

    if (card != null) {
      setCard(card);
    }

    setBackground(getResources().getDrawable(R.drawable.com_appboy_card_background));
  }

  @Override
  protected int getLayoutResource() {
    return R.layout.com_appboy_text_announcement_card;
  }

  @Override
  public void onSetCard(final TextAnnouncementCard card) {
    mTitle.setText(card.getTitle());
    mDescription.setText(card.getDescription());
    setOptionalTextView(mDomain, card.getDomain());
    mCardAction = getUriActionForCard(card);

    setOnClickListener(view -> handleCardClick(mContext, card, mCardAction, TAG));
  }
}
