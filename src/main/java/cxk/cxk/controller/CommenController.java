package cxk.cxk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/commen")
public class CommenController {

    @RequestMapping(value = "/yinsizhengce", method = RequestMethod.GET)
    public ModelAndView userLogin(){
        ModelAndView mav= new ModelAndView("commen/yinsizhengce");
        return mav;
    }
}
