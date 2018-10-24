package cn.dankal.demo.problem;

import cn.dankal.basic_lib.base.BasePresenter;
import cn.dankal.basic_lib.base.BaseView;
import cn.dankal.demo.bean.ProblemBean;

public interface ProbemContact {

    interface ProbemView extends BaseView{
        void getDataSuccess(ProblemBean problemBean);
    }

    interface ProbemPresenter extends BasePresenter<ProbemView>{
        void getData();
    }
}
