package cn.dankal.basic_lib.util;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class DisplayCutout {
    private Activity activity;

    public DisplayCutout(Activity activity) {
        this.activity = activity;
    }

    public void openFullScreenModel(){
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        activity.getWindow().setAttributes(lp);
        View decorView = activity.getWindow().getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        int flags = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        systemUiVisibility |= flags;
        activity.getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility);
    }
}
