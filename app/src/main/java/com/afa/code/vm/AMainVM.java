package com.afa.code.vm;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.databinding.ObservableArrayList;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.afa.code.BR;
import com.afa.code.R;
import com.afa.code.bean.BTaskBean;
import com.afa.code.bean.BTaskItemBean;
import com.afa.code.listener.OnTaskExecuteListener;
import com.afa.code.listener.OnTaskExpandableListener;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;

import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * Created by afa on 17/6/6.
 */

public class AMainVM {


    private OnTaskExecuteListener listener = new OnTaskExecuteListener() {
        @Override
        public void onExecute(BTaskBean taskBean) {
            Toast.makeText(mContext, "onExecute:" + taskBean.getTaskTitle(), Toast.LENGTH_LONG).show();
        }
    };

    /***
     * recycleView dataSource
     */
    public final ObservableArrayList<BTaskBean> taskBeen = new ObservableArrayList<>();
    /***
     * recyclerView layout_item
     */
    public final ItemBinding<BTaskBean> taskBinding = ItemBinding.<BTaskBean>of(BR.task, R.layout.layout_item_task).bindExtra(BR.listener, listener);

    /***
     * task layout_item
     */
    private OnTaskExpandableListener expandableListener = new OnTaskExpandableListener() {
        @Override
        public void onItemClick(ImageView image, ExpandableLinearLayout layout) {
            onExpansionToggled(image, !layout.isExpanded());
            layout.toggle();
        }
    };
    public final ItemBinding<BTaskItemBean> taskItemBinding = ItemBinding.<BTaskItemBean>of(BR.taskItem, R.layout.layout_item_task_item).bindExtra(BR.expandableListener, expandableListener);

    private Context mContext;

    public AMainVM(Context context) {
        mContext = context;
        taskBinding.bindExtra(BR.taskItemBinding, taskItemBinding);
    }


    public void getData() {
        //test data
        ObservableArrayList<BTaskItemBean> taskItemBeen = new ObservableArrayList<>();
        taskItemBeen.add(new BTaskItemBean("0", "taskItemTitle", "test content!\ntest content!test content!"));
        taskItemBeen.add(new BTaskItemBean("1", "taskItemTitle2", "test2 content!\ntest2 content!test2 content!!"));
        BTaskBean task1 = new BTaskBean("1", "task title accept", 0, System.currentTimeMillis(), taskItemBeen);
        BTaskBean task2 = new BTaskBean("2", "task title continue", 1, System.currentTimeMillis(), taskItemBeen);
        taskBeen.add(task1);
        taskBeen.add(task2);

    }

    public void onExpansionToggled(ImageView imageView, boolean expanded) {
        float start, target;
        if (expanded) {
            start = 0f;
            target = 180f;
        } else {
            start = 180f;
            target = 0f;
        }
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, View.ROTATION, start, target);
        objectAnimator.setDuration(300);
        objectAnimator.start();
    }


}
