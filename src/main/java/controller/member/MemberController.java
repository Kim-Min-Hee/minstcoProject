package controller.member;

import controller.vo.LoginVO;
import controller.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@RequestMapping("/member/")
@Controller
public class MemberController  {

    @RequestMapping(value = "join",method = RequestMethod.GET)
public ModelAndView memberWrite(){
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("member/join");
    return modelAndView;
}

@RequestMapping(value = "joinTest",method = RequestMethod.POST)
@ResponseBody
public String memberInsert(MemberVO memberVO) throws Exception{
       return "id ="+ memberVO.getId()+"\t"+"password = "+ memberVO.getPassword()+"\t"+"name = "+ memberVO.getName()+"\t"+"phoneNumber = "+ memberVO.getPhoneNumber();
}

@RequestMapping(value = "login",method = RequestMethod.GET)
public ModelAndView loginWrite(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("member/login");
        return modelAndView;
}

    @RequestMapping(value = "loginTest",method = RequestMethod.POST)
    @ResponseBody
    public String loginInsert(LoginVO loginVO) throws Exception{
        return "id : "+loginVO.getId()+"\t"+"password : "+loginVO.getPassword();
    }



}
