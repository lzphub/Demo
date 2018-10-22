package cn.dankal.demo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import cn.dankal.demo.R;
import cn.dankal.demo.bean.ExpandBean;
import cn.dankal.demo.bean.ProblemBean;

public class MainExpListViewAdapter extends BaseExpandableListAdapter {

    private ExpandBean expandBean;
    private Context context;

    public MainExpListViewAdapter(ExpandBean expandBean, Context context) {
        this.expandBean = expandBean;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return 1;
    }

    @Override
    public int getChildrenCount(int i) {
        return expandBean.getQuestions().size();
    }

    @Override
    public Object getGroup(int i) {
        return expandBean.getTitle();
    }

    @Override
    public Object getChild(int i, int i1) {
        Log.d("aaaa",expandBean.getQuestions().get(i).getType());
        return expandBean.getQuestions().get(i).getType();
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        GroupViewHolder groupViewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.main_explistview_group_item, viewGroup, false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.group_text = (TextView) view.findViewById(R.id.group_text);
            groupViewHolder.group_image=view.findViewById(R.id.group_image);
            view.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) view.getTag();
        }
        groupViewHolder.group_text.setText(expandBean.getTitle());
        if(b){
            groupViewHolder.group_image.setImageResource(R.drawable.jt_up);
        }else{
            groupViewHolder.group_image.setImageResource(R.drawable.jt_bottom);
        }

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildViewHolder childViewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.main_explistview_child_item, viewGroup, false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.child_text = (TextView) view.findViewById(R.id.child_text);
            view.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) view.getTag();
        }
        childViewHolder.child_text.setText(expandBean.getQuestions().get(i1).getType());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    static class GroupViewHolder {
        TextView group_text;
        ImageView group_image;
    }
    static class ChildViewHolder {
        TextView child_text;
    }
}
