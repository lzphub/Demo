package cn.dankal.demo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.dankal.demo.R;
import cn.dankal.demo.bean.ProblemBean;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MyViewHodle> {

    private ProblemBean.QuestionsBeanX questionsBean;
    private Context context;

    public MainRecyclerViewAdapter(Context context) {
        this.context = context;
    }
    public void setData(ProblemBean.QuestionsBeanX questionsBean){
        this.questionsBean=questionsBean;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyViewHodle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.main_explistview_child_item,parent,false);
        MyViewHodle myViewHodle=new MyViewHodle(view);
        return myViewHodle;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHodle holder, int position) {
        holder.text.setText(questionsBean.getQuestions().get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return questionsBean.getQuestions().size();
    }

    class MyViewHodle extends RecyclerView.ViewHolder {
        TextView text;

        public MyViewHodle(View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.child_text);
        }
    }

}
