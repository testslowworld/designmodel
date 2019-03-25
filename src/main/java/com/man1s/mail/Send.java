package com.man1s.mail;

/**
 * Title:Send
 * Description:
 * Company:北京华宇元典信息服务有限公司
 *
 * @author:wangjiyu
 * @version:1.0
 * @date:2019/1/18 16:57
 */
public class Send {
    public static void main(String[] args) {
        String mail = "woloveni11278@163.com"; //发送对象的邮箱
        String title = "我有一句话跟你说";
        String content = "<div>你不在学校吗？</div><br/><hr/><div>记得28号来学校</div>";
        content =
                "<a href=\"javascript:;\" class=\"page_link\" index=\"0\" case_mark=\"authoritative_case\" _id=\"B11C2E4BC13FE866A09BA011F4165E30\" title=\"指导案例45号：北京百度网讯科技有限公司诉青岛奥商网络技术有限公司等不正当竞争纠纷案\">指导案例45号：北京<span class=\"highlight_words\">百度</span>网讯科技有限公司诉青岛奥商网络技术有限公司等不正当竞争纠纷案</a>";
        MailInfo info = new MailInfo();
        info.setToAddress(mail);
        info.setSubject(title);
        info.setContent(content);
        try {
            //            MailSendUtil.sendTextMail(info);
            MailSendUtil.sendHtmlMail(info);
        } catch (Exception e) {
            System.out.print("'" + title + "'的邮件发送失败！");
            e.printStackTrace();
        }
    }
}
