package com.codyy.lib.crash;

import android.support.annotation.NonNull;

/**
 * crash log 邮件发送
 * Created by lijian on 2016/12/27.
 */

public class CrashMail {
    /**
     * 发件人的邮箱的 SMTP 服务器地址
     */
    private String myEmailSMTPHost;
    /**
     * 邮件主题
     */
    private String myEmailTitle;
    /**
     * 邮件内容
     */
    private String myEmailContent;
    /**
     * 发件人邮箱地址
     */
    private String myEmailAccount;
    /**
     * 发件人邮箱名称
     */
    private String myEmailPersonal;
    /**
     * 发件人邮箱密码
     */
    private String myEmailPassword;
    /**
     * 收件人邮箱地址
     */
    private String receiveMailAccount;
    /**
     * 收件人邮箱名称
     */
    private String receiveMailPersonal;

    public CrashMail(@NonNull String myEmailSMTPHost, @NonNull String myEmailTitle, @NonNull String myEmailContent, @NonNull String myEmailAccount, @NonNull String myEmailPersonal, @NonNull String myEmailPassword, @NonNull String receiveMailAccount, @NonNull String receiveMailPersonal) {
        this.myEmailSMTPHost = myEmailSMTPHost;
        this.myEmailTitle = myEmailTitle;
        this.myEmailContent = myEmailContent;
        this.myEmailAccount = myEmailAccount;
        this.myEmailPersonal = myEmailPersonal;
        this.myEmailPassword = myEmailPassword;
        this.receiveMailAccount = receiveMailAccount;
        this.receiveMailPersonal = receiveMailPersonal;
    }

    public String getMyEmailSMTPHost() {
        return myEmailSMTPHost;
    }

    public String getMyEmailTitle() {
        return myEmailTitle;
    }

    public String getMyEmailContent() {
        return myEmailContent;
    }

    public String getMyEmailAccount() {
        return myEmailAccount;
    }

    public String getMyEmailPersonal() {
        return myEmailPersonal;
    }

    public String getMyEmailPassword() {
        return myEmailPassword;
    }

    public String getReceiveMailAccount() {
        return receiveMailAccount;
    }

    public String getReceiveMailPersonal() {
        return receiveMailPersonal;
    }
}
