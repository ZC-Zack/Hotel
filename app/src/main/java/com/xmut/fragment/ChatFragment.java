package com.xmut.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.activity.R;
import com.xmut.adapter.MsgAdapter;
import com.xmut.hotel.Massage;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment {
    private View view;
    private List<Massage> massageList;
    private EditText editText;
    private Button send;
    private RecyclerView recyclerView;
    private MsgAdapter adapter;
    private LinearLayoutManager manager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle bundle){
        view = inflater.inflate(R.layout.chat_layout, group, false);
        initMsg();
        initView();
        return  view;
    }

    private void initView(){

        editText = view.findViewWithTag(R.id.input_text);
        send = view.findViewById(R.id.send_btn);
        recyclerView = view.findViewById(R.id.chat_recycle);
        manager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(manager);
        adapter = new MsgAdapter(massageList);
        recyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = editText.getText().toString();
                if(!"".equals(content)){
                    Massage massage = new Massage();
                    massage.setContent(content);
                    massage.setType(Massage.TYPE_SENT);
                    massageList.add(massage);
                    adapter.notifyItemInserted(massageList.size() - 1);
                    recyclerView.scrollToPosition(massageList.size() - 1);
                    editText.setText("");
                }
            }
        });
    }

    private void initMsg(){
        massageList = new ArrayList<>();
        Massage massage1 = new Massage();
        massage1.setType(Massage.TYPE_SENT);
        massage1.setContent("测试");
        Massage massage2 = new Massage();
        massage2.setType(Massage.TYPE_RECEIVED);
        massage2.setContent("测试");

        massageList.add(massage1);
        massageList.add(massage1);
        massageList.add(massage1);
        massageList.add(massage2);
        massageList.add(massage2);
        massageList.add(massage2);
    }
}
