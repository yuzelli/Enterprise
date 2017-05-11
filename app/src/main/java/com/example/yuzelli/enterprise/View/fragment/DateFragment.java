package com.example.yuzelli.enterprise.View.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.yuzelli.enterprise.R;
import com.example.yuzelli.enterprise.View.activity.UpdataView;
import com.example.yuzelli.enterprise.bean.Project;
import com.example.yuzelli.enterprise.db.DatabaseAdapter;
import com.example.yuzelli.enterprise.utils.CommonAdapter;
import com.example.yuzelli.enterprise.utils.DateUtils;
import com.example.yuzelli.enterprise.utils.ViewHolder;
import com.google.gson.internal.bind.DateTypeAdapter;

import java.util.List;

/**
 * Created by 51644 on 2017/5/9.
 */

public class DateFragment extends Fragment {
    private View dateFragmentView;
    private ListView lv_date;
    DatabaseAdapter adpter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dateFragmentView = inflater.inflate(R.layout.fragment_date, null);
        adpter = new DatabaseAdapter(getActivity());
        lv_date = (ListView) dateFragmentView.findViewById(R.id.lv_date);

        return dateFragmentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateView();
    }
    private Context context;

    private void updateView() {
        final List<Project> list = adpter.findAll();
        lv_date.setAdapter(new CommonAdapter<Project>(getActivity(),list, R.layout.cell_list_item) {
            @Override
            public void convert(ViewHolder helper, Project item) {
                Long time = Long.valueOf(item.getTime()).longValue();
                helper.setText(R.id.tv_time, DateUtils.CurrentTime2(time));
                LinearLayout ll_item = helper.getView(R.id.ll_item);
                if (item.getSecurityone().equals("1")){
                    ImageView image = new ImageView(getActivity());
                    image.setImageResource(R.drawable.ic_duigou);
                    ll_item.addView(image);
                }else {
                    ImageView image = new ImageView(getActivity());
                    image.setImageResource(R.drawable.ic_bacha);
                    ll_item.addView(image);
                }
                if (item.getSecuritytwo().equals("1")){
                    ImageView image = new ImageView(getActivity());
                    image.setImageResource(R.drawable.ic_duigou);
                    ll_item.addView(image);
                }else {
                    ImageView image = new ImageView(getActivity());
                    image.setImageResource(R.drawable.ic_bacha);
                    ll_item.addView(image);
                }
                if (item.getSecuritythree().equals("1")){
                    ImageView image = new ImageView(getActivity());
                    image.setImageResource(R.drawable.ic_duigou);
                    ll_item.addView(image);
                }else {
                    ImageView image = new ImageView(getActivity());
                    image.setImageResource(R.drawable.ic_bacha);
                    ll_item.addView(image);
                }
                if (item.getSecurityfour().equals("1")){
                    ImageView image = new ImageView(getActivity());
                    image.setImageResource(R.drawable.ic_duigou);
                    ll_item.addView(image);
                }else {
                    ImageView image = new ImageView(getActivity());
                    image.setImageResource(R.drawable.ic_bacha);
                    ll_item.addView(image);
                }
                if (item.getSecurityfive().equals("1")){
                    ImageView image = new ImageView(getActivity());
                    image.setImageResource(R.drawable.ic_duigou);
                    ll_item.addView(image);
                }else {
                    ImageView image = new ImageView(getActivity());
                    image.setImageResource(R.drawable.ic_bacha);
                    ll_item.addView(image);
                }
                if (item.getSecuritysix().equals("1")){
                    ImageView image = new ImageView(getActivity());
                    image.setImageResource(R.drawable.ic_duigou);
                    ll_item.addView(image);
                }else {
                    ImageView image = new ImageView(getActivity());
                    image.setImageResource(R.drawable.ic_bacha);
                    ll_item.addView(image);
                }
                if (item.getSecurityseven().equals("1")){
                    ImageView image = new ImageView(getActivity());
                    image.setImageResource(R.drawable.ic_duigou);
                    ll_item.addView(image);
                }else {
                    ImageView image = new ImageView(getActivity());
                    image.setImageResource(R.drawable.ic_bacha);
                    ll_item.addView(image);
                }
                if (item.getSecurityeight().equals("1")){
                    ImageView image = new ImageView(getActivity());
                    image.setImageResource(R.drawable.ic_duigou);
                    ll_item.addView(image);
                }else {
                    ImageView image = new ImageView(getActivity());
                    image.setImageResource(R.drawable.ic_bacha);
                    ll_item.addView(image);
                }
                if (item.getSecuritynine().equals("1")){
                    ImageView image = new ImageView(getActivity());
                    image.setImageResource(R.drawable.ic_duigou);
                    ll_item.addView(image);
                }else {
                    ImageView image = new ImageView(getActivity());
                    image.setImageResource(R.drawable.ic_bacha);
                    ll_item.addView(image);
                }
            }
        });
        lv_date.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UpdataView.actionStart(getActivity(),list.get(position));
            }
        });
        lv_date.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showDialogTitlt(list.get(position));
                return true;
            }
        });
    }
    private void showDialogTitlt(final Project p) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());// 构建
        builder.setTitle("提示框");
        builder.setMessage("确定删除么");
        // 添加确定按钮 listener事件是继承与DialogInerface的
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                // 完成业务逻辑代码
                adpter.remove(p.getId());
                Toast.makeText(getActivity(),"删除id："+p.getId()+"的检测纪录",Toast.LENGTH_SHORT).show();
               updateView();
            }
        });
        // 添加取消按钮
        builder.setNegativeButton("取消",null);
        builder.show();
    }
}
