package controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MemberController  {




    @RequestMapping(value = "/member/join",method = RequestMethod.GET)
public ModelAndView memberWrite(){
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("member/join");
        System.out.println("@@@@");
    return modelAndView;
}
@RequestMapping(value = "/member/joinTest",method = RequestMethod.GET)
public ModelAndView memberInsert(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/member/joinTest");
    return modelAndView;
}

}