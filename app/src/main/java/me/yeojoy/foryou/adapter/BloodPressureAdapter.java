package me.yeojoy.foryou.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import me.yeojoy.foryou.R;
import me.yeojoy.foryou.config.Consts;
import me.yeojoy.foryou.model.BloodPressure;

/**
 * Created by yeojoy on 15. 7. 7..
 */
public class BloodPressureAdapter extends RecyclerView.Adapter<BloodPressureAdapter.ItemViewHolder>
        implements Consts {

    private static final String TAG = BloodPressureAdapter.class.getSimpleName();

    private Context mContext;
    private List<BloodPressure> mBloodPressureList;

    public BloodPressureAdapter(Context context, List<BloodPressure> list) {
        mContext = context;
        if (list != null)
            mBloodPressureList = list;
        else
            mBloodPressureList = new ArrayList<>();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.row_blood_pressure, parent, false);
        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        BloodPressure bp = mBloodPressureList.get(position);

        if (bp == null) return;

        holder.tvDate.setText(new SimpleDateFormat(DATE_FORMAT).format(bp.getRegisteredDate()));
        holder.tvTime.setText(new SimpleDateFormat(TIME_FORMAT).format(bp.getRegisteredDate()));
        holder.tvMax.setText(String.valueOf(bp.getBloodPressureMax()));
        holder.tvMin.setText(String.valueOf(bp.getBloodPressureMin()));
        holder.tvPulse.setText(String.valueOf(bp.getBloodPulse()));
    }

    @Override
    public int getItemCount() {
        return mBloodPressureList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public final TextView tvDate, tvTime, tvMax, tvMin, tvPulse;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            tvMax = (TextView) itemView.findViewById(R.id.tv_blood_pressure_max);
            tvMin = (TextView) itemView.findViewById(R.id.tv_blood_pressure_min);
            tvPulse = (TextView) itemView.findViewById(R.id.tv_blood_pulse);
        }
    }

    public void setBloodPressureList(List<BloodPressure> list) {
        mBloodPressureList.clear();
        mBloodPressureList.addAll(list);

        notifyDataSetChanged();
    }
}