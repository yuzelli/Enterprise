package com.example.yuzelli.enterprise.View.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class UpdataView extends Activity {
    ListView lvItem;
    TextView tvBack;
    DatabaseAdapter adpter;
    Project project;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata_view);
        lvItem = (ListView) this.findViewById(R.id.lv_item);
        tvBack = (TextView) this.findViewById(R.id.tv_back);
        adpter = new DatabaseAdapter(this);
        project = (Project) getIntent().getSerializableExtra("project");
        updataProject();
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (list.get(0).isFlag()){
                    project.setSecurityone("1");
                }else {
                    project.setSecurityone("0");
                }
                if (list.get(1).isFlag()){
                    project.setSecuritytwo("1");
                }else {
                    project.setSecuritytwo("0");
                }
                if (list.get(2).isFlag()){
                    project.setSecuritythree("1");
                }else {
                    project.setSecuritythree("0");
                }
                if (list.get(3).isFlag()){
                    project.setSecurityfour("1");
                }else {
                    project.setSecurityfour("0");
                }
                if (list.get(4).isFlag()){
                    project.setSecurityfive("1");
                }else {
                    project.setSecurityfive("0");
                }
                if (list.get(5).isFlag()){
                    project.setSecuritysix("1");
                }else {
                    project.setSecuritysix("0");
                }if (list.get(6).isFlag()){
                    project.setSecurityseven("1");
                }else {
                    project.setSecurityseven("0");
                }
                if (list.get(7).isFlag()){
                    project.setSecurityeight("1");
                }else {
                    project.setSecurityeight("0");
                }
                if (list.get(8).isFlag()){
                    project.setSecuritynine("1");
                }else {
                    project.setSecuritynine("0");
                }
                adpter.update(project);
                showDialogTitlt();
            }
        });
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
    private void showDialogTitlt() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);// 构建
        builder.setTitle("提示框");
        builder.setMessage("更新数据成功@");
        // 添加确定按钮 listener事件是继承与DialogInerface的
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                // 完成业务逻辑代码
                updataProject();
            }
        });
        // 添加取消按钮
        builder.setNegativeButton("取消",null);
        builder.show();
    }
    private List<Item> list;

    private void updataProject() {
        list = new ArrayList<>();
        if (project.getSecurityone().equals("1")){
            list.add(new Item("安全生产责任制落实", true));
        }else {
            list.add(new Item("安全生产责任制落实", false));
        }
        if (project.getSecuritytwo().equals("1")){
            list.add(new Item("落实安全生产法律法规", true));
        }else {
            list.add(new Item("落实安全生产法律法规", false));
        }
        if (project.getSecuritythree().equals("1")){
            list.add(new Item("隐患排查整改", true));
        }else {
            list.add(new Item("隐患排查整改", false));
        }
        if (project.getSecurityfour().equals("1")){
            list.add(new Item("应急管理", true));
        }else {
            list.add(new Item("应急管理", false));
        }
        if (project.getSecurityfive().equals("1")){
            list.add(new Item("基础工作", true));
        }else {
            list.add(new Item("基础工作", false));
        }
        if (project.getSecuritysix().equals("1")){
            list.add(new Item("重大危险源监控", true));
        }else {
            list.add(new Item("重大危险源监控", false));
        }

        if (project.getSecurityseven().equals("1")){
            list.add(new Item("安全宣传培训", true));
        }else {
            list.add(new Item("安全宣传培训", false));
        }

        if (project.getSecurityeight().equals("1")){
            list.add(new Item("安全标志", true));
        }else {
            list.add(new Item("安全标志", false));
        }

        if (project.getSecuritynine().equals("1")){
            list.add(new Item("记录", true));
        }else {
            list.add(new Item("记录", false));
        }


        lvItem.setAdapter(new CommonAdapter<Item>(this, list, R.layout.cell_item) {
            @Override
            public void convert(ViewHolder helper, final Item item) {
                helper.setText(R.id.tv_name, item.getTitle());
                RadioButton radioButton = helper.getView(R.id.radioButton);
                radioButton.setChecked(item.isFlag());
                radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        item.setFlag(isChecked);
                    }
                });

            }
        });
        setListViewHeightBasedOnChildren(lvItem);
    }

    public static void actionStart(Context context, Project project) {
        Intent intent = new Intent(context, UpdataView.class);
        intent.putExtra("project", project);
        context.startActivity(intent);

    }
}
