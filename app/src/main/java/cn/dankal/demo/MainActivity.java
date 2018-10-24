package cn.dankal.demo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ExpandableListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.dankal.basic_lib.base.BaseActivity;
import cn.dankal.basic_lib.util.TitleBarUtils;
import cn.dankal.demo.adapter.MainExpListViewAdapter;
import cn.dankal.demo.adapter.MainRecyclerViewAdapter;
import cn.dankal.demo.bean.ProblemBean;
import cn.dankal.demo.problem.ProbemContact;
import cn.dankal.demo.problem.ProblemPresnter;

public class MainActivity extends BaseActivity implements ProbemContact.ProbemView {

    @BindView(R.id.problem_explistview)
    ExpandableListView problemExplistview;
    @BindView(R.id.problem_recyclerview)
    RecyclerView problemRecyclerview;
    @BindView(R.id.view_top)
    View viewTop;
    private ProblemPresnter probemPresenter = ProblemPresnter.getProblemPresnter();
    private MainRecyclerViewAdapter mainRecyclerViewAdapter;

    @Override
    protected int contentViewLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initComponents() {
        probemPresenter.attachView(this);
        setStatusBarAndToolBar(true, true, 0);
        ViewGroup.LayoutParams layoutParams= (ViewGroup.LayoutParams) viewTop.getLayoutParams();
        layoutParams.height= TitleBarUtils.getStatusBarHeight(this);
        viewTop.setLayoutParams(layoutParams);
        probemPresenter.getData();
    }



    //数据填充显示
    @Override
    public void getDataSuccess(ProblemBean problemBean) {
        if(problemBean!=null){
            problemBean.setTitle("问题分类");
            problemExplistview.setAdapter(new MainExpListViewAdapter(problemBean, this));
            problemRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            mainRecyclerViewAdapter = new MainRecyclerViewAdapter(problemBean.getQuestions().get(0), this);
            problemRecyclerview.setAdapter(mainRecyclerViewAdapter);
            //默认展开
            problemExplistview.expandGroup(0);

            problemExplistview.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                    mainRecyclerViewAdapter.setData(problemBean.getQuestions().get(i1));
                    //点击关闭
                    problemExplistview.collapseGroup(0);
                    return false;
                }
            });
        }
    }
}
