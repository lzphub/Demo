package cn.dankal.demo.problem;

import cn.dankal.basic_lib.base.BasePresenter;
import cn.dankal.basic_lib.base.BaseView;

public interface ProbemContact {

    interface ProbemView extends BaseView{
        void getDataSuccess();
    }

    interface ProbemPresenter extends BasePresenter<ProbemView>{
        void getData();
    }
}
