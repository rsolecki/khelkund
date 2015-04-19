package com.appacitive.khelkund.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.appacitive.khelkund.R;
import com.appacitive.khelkund.infra.BusProvider;
import com.appacitive.khelkund.infra.KhelkundApplication;
import com.appacitive.khelkund.model.Player;
import com.appacitive.khelkund.infra.TeamHelper;
import com.appacitive.khelkund.model.events.pick5.Pick5PlayerChosenEventBase;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sathley on 4/10/2015.
 */
public class Pick5PlayerAdapter extends BaseAdapter {

    private final List<Player> mPlayers;
    private final Context mContext;
    private final Pick5PlayerChosenEventBase mEvent;

    public Pick5PlayerAdapter(Context context, List<Player> players, Pick5PlayerChosenEventBase event)
    {
        mPlayers = players;
        mEvent = event;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mPlayers.size();
    }

    @Override
    public Player getItem(int i) {
        return mPlayers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_pick5_player_card, viewGroup, false);
        }

        final Player player = getItem(i);

        ImageView photo =  (ImageView) view.findViewById(R.id.iv_player_photo);
        TextView name = (TextView) view.findViewById(R.id.tv_card_name);
        CardView cardView = (CardView) view.findViewById(R.id.card_view_filled);

        cardView.setCardBackgroundColor(KhelkundApplication.getAppContext().getResources().getColor(TeamHelper.getTeamColor(player.getShortTeamName())));
        Picasso.with(mContext).load(player.getImageUrl()).fit().centerInside().placeholder(R.drawable.demo).into(photo);
        name.setText(player.getDisplayName());

        cardView.setOnClickListener(null);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEvent.player = player;
                BusProvider.getInstance().post(mEvent);
            }
        });
        return view;
    }
}
