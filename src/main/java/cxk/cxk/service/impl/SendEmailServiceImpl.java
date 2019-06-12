package cxk.cxk.service.impl;

import cxk.cxk.service.SendEmailService;
import cxk.cxk.util.SendEmail;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;

@Service
public class SendEmailServiceImpl implements SendEmailService {

    @Override
    public void sendEmail(String email,String recode) throws GeneralSecurityException {
        SendEmail.senfEmail(email,recode);
    }

    @Override
    public int sendEmaileditpassword(String email) throws GeneralSecurityException {
        return SendEmail.sendEmaileditpassword(email);
    }
}
