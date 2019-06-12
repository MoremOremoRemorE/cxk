package cxk.cxk.controller;


import cxk.cxk.model.User;
import cxk.cxk.service.RandomCodeService;
import cxk.cxk.service.SendEmailService;
import cxk.cxk.service.UserService;
import cxk.cxk.util.randomcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private RandomCodeService randomCodeService;
    @Autowired
    private SendEmailService sendEmailService;

    @RequestMapping(value = "/loginuser", method = RequestMethod.GET)
    public ModelAndView userLogin(){
        ModelAndView mav= new ModelAndView("login/login1");
        return mav;
    }

    @RequestMapping(value = "/logincheck",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> checklogin1(HttpServletRequest req, HttpServletResponse resp, User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        String username = user.getUsername();
        String password = user.getPassword();
        User usercheck = userService.selectUserCountByName(username);
        if(usercheck==null){
            map.put("msg","zhuce");
        }else if(!usercheck.getPassword().equals(password)){
            map.put("msg","passworderr");
        }else{
            map.put("msg","success");
        }
        return map;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(){
        ModelAndView mav= new ModelAndView("login/register1");
        return mav;
    }
    @RequestMapping(value = "/registercheck", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addregister(User user) {
        Map<String,Object> map = new HashMap<String,Object>();
        String username =user.getUsername();
        String email = user.getEmail();
        String code = user.getCode();
        try {
            int count = userService.regiterByName(username);
            if(count > 0){
                map.put("msg","yzc");
            }else{
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = sdf.format(date);
                user.setRegistertime(time);
                user.setRoleid(2);//默认为普通员工
                String recode = randomCodeService.getrandomcode();
                sendEmailService.sendEmail(email,recode);
                if(!code.equals(recode)){
                    map.put("msg","codeerr");
                    return map;
                }
                userService.addUser(user);
                map.put("msg","success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //    System.out.println(username);
        //   System.out.println(password);
        //   System.out.println(map);
        return map;
    }
    @RequestMapping(value = "/codecheck", method = RequestMethod.POST)
    @ResponseBody
    public String codecheck(HttpServletRequest req, HttpServletResponse resp){
        String recode = randomCodeService.getrandomcode();
        return recode;
    }
}
