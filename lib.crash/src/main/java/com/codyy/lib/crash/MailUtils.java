package com.codyy.lib.crash;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by lijian on 16-12-22.
 */

public class MailUtils {

    public static void main(String[] args) throws Exception {
        CrashMail crashMail = new CrashMail("mail.codyy.cn", "运营平台2.2.0crashlog", "log", "android@codyy.com", "运营平台2.2.0", "android", "lijian@codyy.com", "李健");
        sendMail(crashMail);
    }

    public static void sendMail(CrashMail crashMail) throws Exception {
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.host", crashMail.getMyEmailSMTPHost());        // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 请求认证，参数名称与具体实现有关

        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log

        // 3. 创建一封邮件
        MimeMessage message = createMimeMessage(session, crashMail);

        // 4. 根据 Session 获取邮件传输对象
        Transport transport = session.getTransport();

        // 5. 使用 邮箱账号 和 密码 连接邮件服务器
        //    这里认证的邮箱必须与 message 中的发件人邮箱一致，否则报错
        transport.connect(crashMail.getMyEmailAccount(), crashMail.getMyEmailPassword());

        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(message, message.getAllRecipients());

        // 7. 关闭连接
        transport.close();
    }

    /**
     * 创建一封只包含文本的简单邮件
     *
     * @param session 和服务器交互的会话
     * @return MimeMessage
     * @throws Exception
     */
    private static MimeMessage createMimeMessage(Session session, CrashMail crashMail) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人
        message.setFrom(new InternetAddress(crashMail.getMyEmailAccount(), crashMail.getMyEmailPersonal(), "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(crashMail.getReceiveMailAccount(), crashMail.getReceiveMailPersonal(), "UTF-8"));

        // 4. Subject: 邮件主题
        message.setSubject(crashMail.getMyEmailTitle(), "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）
//        message.setContent(log, "text/html;charset=UTF-8");
        message.setContent(crashMail.getMyEmailContent(), "text/plain;charset=UTF-8");

        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();

        return message;
    }
}
