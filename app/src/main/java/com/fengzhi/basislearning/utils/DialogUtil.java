package com.fengzhi.basislearning.utils;

import android.content.Context;

import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.widget.NormalDialog;

/**
 * <pre>
 *    author  :
 *    email   :
 *    time    : 2018/1/23.
 *    desc    : Dialog工具类
 *    version : 1.0
 * </pre>
 */

public class DialogUtil {

    private static NormalDialog dialog = null;


    public static DialogUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        public static final DialogUtil INSTANCE = new DialogUtil();
    }

    public void showDialog(Context context, String content, final DialogListener listener) {

        dialog = new NormalDialog(context);
        dialog.content(content)
                .show();
        dialog.setOnBtnClickL(() -> dialog.dismiss(), () -> {
            listener.positiveButton();
            dialog.dismiss();
        });

    }

    public interface DialogListener {
        void positiveButton();
    }
}
