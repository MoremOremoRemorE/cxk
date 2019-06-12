package cxk.cxk.controller;


import cxk.cxk.model.User;
import cxk.cxk.service.SendEmailService;
import cxk.cxk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.GeneralSecurityException;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SendEmailService sendEmailService;

    @RequestMapping(value = "/czmm", method = RequestMethod.GET)
    public ModelAndView  czmm(HttpServletRequest req, HttpServletResponse resp) throws GeneralSecurityException {
        String email = req.getParameter("email");
        String resusername = req.getParameter("username");
        ModelAndView mav = new ModelAndView("login/login1");
        User usercheck = userService.selectUserCountByName(resusername);
        int count = 0;
        if(usercheck!=null) {
            //重置用户密码
             count = userService.resuserpasswordByUserName(resusername);
        }
        int count1 = sendEmailService.sendEmaileditpassword(email);
        if(count1==1 && count>0){
            mav.addObject("resemail",1000);
        }else{
            mav.addObject("resemail",1001);
        }
        return mav;

    }
}
