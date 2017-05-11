package com.example.yuzelli.enterprise.View.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.yuzelli.enterprise.R;
import com.example.yuzelli.enterprise.bean.Item;
import com.example.yuzelli.enterprise.bean.Project;
import com.example.yuzelli.enterprise.db.DatabaseAdapter;
import com.example.yuzelli.enterprise.utils.CommonAdapter;
import com.example.yuzelli.enterprise.utils.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 51644 on 2017/5/9.
 */

public class ProjectFragment extends Fragment {

    ListView lvItem;
    TextView tvBack;
    private View projectFragmentView;

    DatabaseAdapter adpter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        projectFragmentView = inflater.inflate(R.layout.fragment_project, null);
        lvItem = (ListView) projectFragmentView.findViewById(R.id.lv_item);
        tvBack = (TextView) projectFragmentView.findViewById(R.id.tv_back);
        adpter = new DatabaseAdapter(getActivity());
        return projectFragmentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        initView();
    }
  private   List<Item> list;
    private void initView() {
        list = new ArrayList<>();
        list.add(new Item("安全生产责任制落实", false));
        list.add(new Item("落实安全生产法律法规", false));
        list.add(new Item("隐患排查整改", false));
        list.add(new Item("应急管理", false));
        list.add(new Item("基础工作", false));
        list.add(new Item("重大危险源监控", false));
        list.add(new Item("安全宣传培训", false));
        list.add(new Item("安全标志", false));
        list.add(new Item("记录", false));
        lvItem.setAdapter(new CommonAdapter<Item>(getActivity(), list, R.layout.cell_item) {
            @Override
            public void convert(ViewHolder helper, final Item item) {
                helper.setText(R.id.tv_name, item.getTitle());
                RadioButton radioButton = helper.getView(R.id.radioButton);
                radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        item.setFlag(isChecked);
                    }
                });

            }
        });
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Project proj = new Project();
              Long time =   System.currentTimeMillis();
                proj.setTime(time+"");
                if (list.get(0).isFlag()){
                    proj.setSecurityone("1");
                }else {
                    proj.setSecurityone("0");
                }
                if (list.get(1).isFlag()){
                    proj.setSecuritytwo("1");
                }else {
                    proj.setSecuritytwo("0");
                }
                if (list.get(2).isFlag()){
                    proj.setSecuritythree("1");
                }else {
                    proj.setSecuritythree("0");
                }
                if (list.get(3).isFlag()){
                    proj.setSecurityfour("1");
                }else {
                    proj.setSecurityfour("0");
                }
                if (list.get(4).isFlag()){
                    proj.setSecurityfive("1");
                }else {
                    proj.setSecurityfive("0");
                }
                if (list.get(5).isFlag()){
                    proj.setSecuritysix("1");
                }else {
                    proj.setSecuritysix("0");
                }if (list.get(6).isFlag()){
                    proj.setSecurityseven("1");
                }else {
                    proj.setSecurityseven("0");
                }
                if (list.get(7).isFlag()){
                    proj.setSecurityeight("1");
                }else {
                    proj.setSecurityeight("0");
                }
                if (list.get(8).isFlag()){
                    proj.setSecuritynine("1");
                }else {
                    proj.setSecuritynine("0");
                }
                adpter.create(proj);
                showDialogTitlt();
            }
        });

        setListViewHeightBasedOnChildren(lvItem);
    }

    private void showDialogTitlt() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());// 构建
        builder.setTitle("提示框");
        builder.setMessage("插入数据库成功！");
        // 添加确定按钮 listener事件是继承与DialogInerface的
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                // 完成业务逻辑代码
                initView();
            }
        });
        // 添加取消按钮
        builder.setNegativeButton("取消",null);
        builder.show();
    }
    /**
     * 计算listView的高度
     *
     * @param listView
     */
    public void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
