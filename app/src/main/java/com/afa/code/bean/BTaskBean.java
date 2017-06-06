package com.afa.code.bean;

import android.databinding.ObservableArrayList;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by afa on 17/6/6.
 */

public class BTaskBean extends BaseBean {

    private String taskId;
    private String taskTitle;
    private int taskState;
    private long taskDate;

    public BTaskBean(String taskId, String taskTitle, int taskState, long taskDate, ObservableArrayList<BTaskItemBean> taskItems) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskState = taskState;
        this.taskDate = taskDate;
        this.taskItems = taskItems;
    }

    private ObservableArrayList<BTaskItemBean> taskItems = new ObservableArrayList<>();

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }


    public long getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(long taskDate) {
        this.taskDate = taskDate;
    }

    public int getTaskState() {
        return taskState;
    }

    public void setTaskState(int taskState) {
        this.taskState = taskState;
    }

    public ObservableArrayList<BTaskItemBean> getTaskItems() {
        return taskItems;
    }

    public void setTaskItems(ObservableArrayList<BTaskItemBean> taskItems) {
        this.taskItems = taskItems;
    }

    private String taskDateStr;

    public String getTaskDateStr() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date(taskDate));
    }
}
