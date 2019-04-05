package com.xmut.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.activity.R;
import com.xmut.hotel.Massage;

import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private List<Massage> massageList;

    static class ViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout leftLayout;
        private LinearLayout rightLayout;
        private TextView leftMsg;
        private TextView rightMsg;

        public ViewHolder(View view) {
            super(view);
            leftLayout = view.findViewById(R.id.left_layout);
            rightLayout = view.findViewById(R.id.right_layout);
            leftMsg = view.findViewById(R.id.left_msg);
            rightMsg = view.findViewById(R.id.right_msg);
        }
    }

    public MsgAdapter(List<Massage> list){
        massageList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Massage massage = massageList.get(position);
        if(massage.getType() == Massage.TYPE_RECEIVED){
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(massage.getContent());
        }else if(massage.getType() == Massage.TYPE_SENT){
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightMsg.setText(massage.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return massageList.size();
    }
}
