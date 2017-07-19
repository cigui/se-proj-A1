package utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/* 使用SMTP传输邮件 */
public class EmailUtil {

	/* 必要参数：主机，用户名，密码 */
	private static String host;
	private static String userName;
	private static String pwd;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		EmailUtil.host = host;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		EmailUtil.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		EmailUtil.pwd = pwd;
	}

	public static void sendMail(String dest, String title, String content) throws AddressException, MessagingException {
		Properties props = new Properties(); // 加载一个配置文件
		// 使用smtp：简单邮件传输协议
		props.put("mail.smtp.host", host);// 存储发送邮件服务器的信息
		props.put("mail.smtp.auth", "true");// 同时通过验证
		Session session = Session.getInstance(props);// 根据属性新建一个邮件会话
		// session.setDebug(true); //有他会打印一些调试信息。
		MimeMessage message = new MimeMessage(session);// 由邮件会话新建一个消息对象
		message.setFrom(new InternetAddress(userName));// 设置发件人的地址
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(dest));// 设置收件人,并设置其接收类型为TO
		message.setSubject(title);// 设置标题
		// 设置信件内容
		// message.setText(mailContent); //发送 纯文本 邮件 
		message.setContent(content, "text/html;charset=utf-8"); // 发送HTML邮件，内容样式比较丰富
		message.setSentDate(new Date());// 设置发信时间
		message.saveChanges();// 存储邮件信息
		// 发送邮件
		Transport transport = session.getTransport("smtp");
		transport.connect(userName, pwd);
		transport.sendMessage(message, message.getAllRecipients());// 发送邮件,其中第二个参数是所有已设好的收件人地址
		transport.close();
	}
	
	/*public static void main(String[] args) {
		try {
			EmailUtil test = new EmailUtil();
			test.setHost("smtp.163.com");
			test.setUserName("summerProj@163.com");
			test.setPwd("seprojA1");
			test.sendMail("583537119@qq.com","TEST","TEST");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
