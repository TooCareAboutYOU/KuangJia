package com.kuangjia.main.model;

import java.io.Serializable;

/**
 * Created by zhangshuai on 2016-07-08.
 */
public class ErrorMessage implements Serializable {

    private String errorCode = "0";
    private String errorMessage = "";
    private int voteCount;
    private int voteId;

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", voteCount=" + voteCount +
                ", voteId=" + voteId +
                '}';
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }


}
