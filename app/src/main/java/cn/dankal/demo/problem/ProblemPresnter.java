package cn.dankal.demo.problem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.alibaba.fastjson.JSON;

import cn.dankal.basic_lib.base.BaseApi;
import cn.dankal.basic_lib.base.PreHandlerDialogSubscriber;
import cn.dankal.basic_lib.exception.ExceptionHandle;
import cn.dankal.basic_lib.pojo.LoginResponse;
import cn.dankal.demo.bean.ProblemBean;
import cn.dankal.demo.user.UserService;
import cn.dankal.manager.UserManager;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProblemPresnter implements ProbemContact.ProbemPresenter{

    private ProbemContact.ProbemView probemView;
    private ProblemBean problemBean2=ProblemBean.getProblemBean();

    @Override
    public void getData() {
        BaseApi.getRetrofit().create(UserService.class)
                .getProblem()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .onErrorResumeNext(t -> {
                    return Observable.error(ExceptionHandle.handleException(t));
                })
                .subscribe(new PreHandlerDialogSubscriber<ProblemBean>(probemView) {
                    @Override
                    public void onNext(ProblemBean problemBean) {
                        problemBean2=problemBean;
                        probemView.getDataSuccess();
                    }
                });

    }

    @Override
    public void attachView(@NonNull ProbemContact.ProbemView view) {
        probemView=view;;
    }

    @Override
    public void detachView() {
        probemView=null;
    }

    public ProblemBean getProblemBean2(){
        return problemBean2;
    }

    //获取状态栏高度
    public int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height","dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        Log.d("hwj","**getStatusBarHeight**" + result);
        return result;
    }
}
