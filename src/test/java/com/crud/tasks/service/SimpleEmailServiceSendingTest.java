package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;


// class for sending email to mailtrap
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SimpleEmailServiceSendingTest {

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Test
    public void shouldSendEmail() {
        //Given
        Mail mail = Mail.builder()
                .mailTo("test@test.com")
                .subject("Test")
                .message("Test Message")
                .toCc("ccTest@ccTest.com")
                .build();


        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        mailMessage.setCc(mail.getToCc());

        //When
        //simpleEmailService.send(mail);

        //Then
    }

}

