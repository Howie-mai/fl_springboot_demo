package com.zhku.mh.common.thread;

import com.zhku.mh.entities.DTO.EmployeeDTO;
import com.zhku.mh.entities.Employee;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * ClassName：
 * Time：2019/11/7 14:20
 * Description：
 * Author： mh
 */
public class EMailRunnable implements Runnable {
    private EmployeeDTO employeeDTO;
    private JavaMailSender mailSender;
    private TemplateEngine templateEngine;
    private String emailAddress;

    public EMailRunnable(EmployeeDTO employeeDTO, JavaMailSender mailSender, TemplateEngine templateEngine, String emailAddress) {
        this.employeeDTO = employeeDTO;
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
        this.emailAddress = emailAddress;
    }

    @Override
    public void run() {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(employeeDTO.getEmail());
            helper.setFrom(emailAddress);
            helper.setSubject("vHr 通知：");
            Context context = new Context();
            context.setVariable("name", employeeDTO.getName());
            context.setVariable("workID", employeeDTO.getWorkid());
            context.setVariable("contractTerm", employeeDTO.getContractterm());
            context.setVariable("beginContract", employeeDTO.getBegincontract());
            context.setVariable("endContract", employeeDTO.getEndcontract());
            context.setVariable("departmentName", employeeDTO.getDepartmentName());
            context.setVariable("posName", employeeDTO.getPositionName());
            String mail = templateEngine.process("email.html",context);
            helper.setText(mail,true);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("发送失败");
            e.printStackTrace();
        }
    }
}
