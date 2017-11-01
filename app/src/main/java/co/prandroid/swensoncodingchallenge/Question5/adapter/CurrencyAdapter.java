package co.prandroid.swensoncodingchallenge.Question5.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import co.prandroid.swensoncodingchallenge.Question5.model.Currency;
import co.prandroid.swensoncodingchallenge.Question5.model.CurrencyExchange;
import co.prandroid.swensoncodingchallenge.R;

/**
 * Created by dharmakshetri on 10/17/17.
 */

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder> {
    private final OnItemClickListener listener;
    private List<Currency> data;
    private Context context;

    public CurrencyAdapter(Context context, CurrencyExchange currencyExchange, OnItemClickListener listener) {
        this.data = currencyExchange.getCurrencyList();
        this.listener = listener;
        this.context = context;
    }


    @Override
    public CurrencyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.currentyitems, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(CurrencyAdapter.ViewHolder holder, int position) {
        holder.click(data.get(position), listener);
            holder.tvCurrencySymbol.setText(data.get(position).getName());
            holder.tvConvertedAmount.setText(Double.toString(data.get(position).getRate()));

        String images = "";

        Glide.with(context)
                .load(images)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .skipMemoryCache(true)
                .into(holder.icon);
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public interface OnItemClickListener {
        void onClick(Currency Item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCurrencySymbol, tvConvertedAmount;
        ImageView icon;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCurrencySymbol = (TextView) itemView.findViewById(R.id.tvCurrencySymbol);
            tvConvertedAmount = (TextView) itemView.findViewById(R.id.tvConvertedAmount);
            icon = (ImageView) itemView.findViewById(R.id.image);

        }


        public void click(final Currency currency, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(currency);

                }
            });
        }
    }


}
