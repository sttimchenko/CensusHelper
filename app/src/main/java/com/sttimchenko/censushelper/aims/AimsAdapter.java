package com.sttimchenko.censushelper.aims;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sttimchenko.censushelper.R;
import com.sttimchenko.censushelper.model.Aim;

import java.util.List;

public class AimsAdapter extends RecyclerView.Adapter<AimsAdapter.ViewHolder> implements View.OnClickListener {

    private List<Aim> aims;
    private OnItemClickListener listener;
    private Context context;

    public AimsAdapter(List<Aim> aims, OnItemClickListener listener, Context context) {
        this.aims = aims;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.aim_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Aim aim = aims.get(position);

        holder.container.setTag(position);
        holder.container.setOnClickListener(this);

        holder.tvInfo.setText(aim.getStreetName() + " " + aim.getBuildingNumber());

        boolean isPublicHouse = !aim.getFlatsNumbers().isEmpty();

        if (isPublicHouse){
            holder.tvType.setText(context.getString(R.string.public_house));
            holder.tvCount.setVisibility(View.VISIBLE);
            holder.tvCount.setText(aim.getFlatsNumbers().size() + " квартир");
        } else {
            holder.tvType.setText(context.getString(R.string.private_house));
            holder.tvCount.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return aims.size();
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        listener.onItemClick(v, (Integer) v.getTag());
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvInfo;
        private TextView tvType;
        private TextView tvCount;
        private View container;

        public ViewHolder(View itemView) {
            super(itemView);

            container = itemView;
            tvInfo = (TextView) itemView.findViewById(R.id.tv_info);
            tvType = (TextView) itemView.findViewById(R.id.tv_type);
            tvCount = (TextView) itemView.findViewById(R.id.tv_count);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View v, int position);
    }
}
