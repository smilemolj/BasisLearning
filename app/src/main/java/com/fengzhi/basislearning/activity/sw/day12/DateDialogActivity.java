package com.fengzhi.basislearning.activity.sw.day12;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.base.SlideBackBaseActivity;

import java.util.Calendar;

import butterknife.BindView;

public class DateDialogActivity extends SlideBackBaseActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.tv_birth)
    TextView tvBirth;
    @BindView(R.id.tv_time)
    TextView tvTime;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("DateDialogActivity");
    }

    public void onChooseDate_Click(View view) {
        //获取当前的日期对象
        Calendar calen = Calendar.getInstance();

        switch (view.getId()) {
            case R.id.btnChooseBirth:
                //日期对话框
                DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view1, year,
                                                                                monthOfYear,
                                                                                dayOfMonth) -> tvBirth.setText(year + ":" + (monthOfYear + 1) + ":" + dayOfMonth + ""), calen.get(Calendar.YEAR), calen.get(Calendar.MONTH), calen.get(Calendar.DAY_OF_MONTH));

                //显示日期对话框
                datePickerDialog.show();

                break;
            case R.id.btnChooseTime:
                //时间选择对话框
                TimePickerDialog timePickerDialog = new TimePickerDialog(this, (view12, hourOfDay
                        , minute) -> tvTime.setText(hourOfDay + ":" + minute),
                        calen.get(Calendar.HOUR_OF_DAY), calen.get(Calendar.MINUTE), false);

                //显示时间对话框
                timePickerDialog.show();
                break;
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.datedialog_layout;
    }

}
