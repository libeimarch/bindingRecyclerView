package com.afa.code.bean;

/**
 * Created by afa on 17/6/6.
 */

public class BTaskItemBean extends BaseBean {

    private String taskItemId;
    private String taskItemTitle;
    private String taskItemContent;

    public BTaskItemBean(String taskItemId, String taskItemTitle, String taskItemContent) {
        this.taskItemId = taskItemId;
        this.taskItemTitle = taskItemTitle;
        this.taskItemContent = taskItemContent;
    }

    public String getTaskItemId() {
        return taskItemId;
    }

    public void setTaskItemId(String taskItemId) {
        this.taskItemId = taskItemId;
    }

    public String getTaskItemTitle() {
        return taskItemTitle;
    }

    public void setTaskItemTitle(String taskItemTitle) {
        this.taskItemTitle = taskItemTitle;
    }

    public String getTaskItemContent() {
        return taskItemContent;
    }

    public void setTaskItemContent(String taskItemContent) {
        this.taskItemContent = taskItemContent;
    }
}
