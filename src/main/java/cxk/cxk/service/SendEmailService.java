package cxk.cxk.service;

import java.security.GeneralSecurityException;

public interface SendEmailService {

    public void sendEmail(String email, String recode) throws GeneralSecurityException;
    public int sendEmaileditpassword( String email) throws GeneralSecurityException;

}
