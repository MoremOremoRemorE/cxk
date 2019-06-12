package cxk.cxk.util;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class SendEmail {
    public static void senfEmail(String email, String recode) throws GeneralSecurityException {
        // 收件人电子邮箱
        String to = email;

        // 发件人电子邮箱
        String from = "3492321742@qq.com";

        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com";  //QQ 邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("3492321742@qq.com", "qdktgketbuxodcba"); //发件人邮件用户名、密码
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom (new InternetAddress(from, "这里是需要的昵称", "UTF-8"));
        //    message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("邮箱验证码");

            // 设置消息体
            //网页内容
                message.setContent("<html lang='zh-CN'><head ><meta charset='utf-8'>"
                                + "</head><body>(*^▽^*)用户邮箱注册码" + recode + "(*^▽^*)</body></html>",
                        "text/html;charset=utf-8");
            //纯文本
            //     message.setText("用户"+username+"注册成功");
            // 发送消息
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static int sendEmaileditpassword(String email) throws GeneralSecurityException {
        // 收件人电子邮箱
        String to = email;

        // 发件人电子邮箱
        String from = "3492321742@qq.com";

        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com";  //QQ 邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("3492321742@qq.com", "qdktgketbuxodcba"); //发件人邮件用户名、密码
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
         //   message.setFrom (new InternetAddress (from, "这里是需要的昵称", "UTF-8"));
             message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("邮箱验证");

            // 设置消息体
            //网页内容
            message.setContent("<html lang='zh-CN'><head ><meta charset='utf-8'>"
                            + "</head><body>(*^▽^*)重置密码成功(*^▽^*)</body></html>",
                    "text/html;charset=utf-8");
            //纯文本
            //     message.setText("用户"+username+"注册成功");
            // 发送消息
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return 1;
    }
}

