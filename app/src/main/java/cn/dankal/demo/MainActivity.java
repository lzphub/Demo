package cn.dankal.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.dankal.basic_lib.base.BaseActivity;
import cn.dankal.demo.adapter.MainExpListViewAdapter;
import cn.dankal.demo.adapter.MainRecyclerViewAdapter;
import cn.dankal.demo.bean.ExpandBean;
import cn.dankal.demo.bean.ProblemBean;
import cn.dankal.demo.problem.ProbemContact;
import cn.dankal.demo.problem.ProblemPresnter;
import cn.dankal.demo.user.LoginActivity;
import io.reactivex.disposables.Disposable;

public class MainActivity extends BaseActivity implements ProbemContact.ProbemView {

    @BindView(R.id.problem_explistview)
    ExpandableListView problemExplistview;
    @BindView(R.id.problem_recyclerview)
    RecyclerView problemRecyclerview;
    private ProblemPresnter probemPresenter = new ProblemPresnter();
    private ProblemBean problemBean = ProblemBean.getProblemBean();
    private ExpandBean expandBean = ExpandBean.getExpandBean();


    @Override
    protected int contentViewLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initComponents() {
        probemPresenter.attachView(this);
        setStatusBarAndToolBar(true, true, 0);
        probemPresenter.getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        problemRecyclerview.setLayoutManager(linearLayoutManager);
    }

    //数据填充显示
    @Override
    public void getDataSuccess() {
        problemBean = probemPresenter.getProblemBean2();
        expandBean.setQuestions(problemBean.getQuestions());
        problemExplistview.setAdapter(new MainExpListViewAdapter(expandBean, this));
        int groupCount = problemExplistview.getCount();
        for (int i = 0; i < groupCount; i++) {
            //默认展开
            problemExplistview.expandGroup(i);
        }
        ;
        MainRecyclerViewAdapter mainRecyclerViewAdapter = new MainRecyclerViewAdapter(this);
        problemRecyclerview.setAdapter(mainRecyclerViewAdapter);
        mainRecyclerViewAdapter.setData(problemBean.getQuestions().get(0));
        problemExplistview.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                mainRecyclerViewAdapter.setData(problemBean.getQuestions().get(i1));
                for (int n = 0; n < groupCount; n++) {
                    //点击关闭
                    problemExplistview.collapseGroup(n);
                }
                ;
                return false;
            }
        });
    }
}
