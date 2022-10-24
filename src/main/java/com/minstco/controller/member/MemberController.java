package com.minstco.controller.member;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import com.minstco.service.MemberService;
import com.minstco.vo.LoginVO;
import com.minstco.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.Map;


@RequestMapping("/member/")
@Controller
public class MemberController  {

    ModelAndView modelAndView = new ModelAndView();

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "join",method = RequestMethod.GET)
    public ModelAndView memberWrite(){
        modelAndView.setViewName("member/join");
        return modelAndView;
    }

    //아이디 중복확인 요청
    @ResponseBody
    @RequestMapping(value = "idCheck" , method = RequestMethod.POST)
    public class UserController {

        @Autowired
        private MemberService memberService;

        public int idCheck(@RequestParam("id") String id){
            int cnt = memberService.idCheck(id);
            return cnt;
        }

    }


//    public String idCheck (@RequestBody Map<String,Object> map) throws Exception {
//        for(String key : map.keySet()) {
//            System.out.println("map value :: " + map.get(key)); //map.get("id")
//        }
//        JSONObject jsonobj = new JSONObject(map);
//        try{
//            boolean idchk = memberService.idCheck(map);
//            jsonobj.put("status","success");
//            if(idchk){
//                jsonobj.put("result","success");
//                jsonobj.put("message","사용 가능함 id 입니다.");
//            }else{
//                jsonobj.put("result","failed");
//                jsonobj.put("message","이미 존재하는 id 입니다.");
//            }
//        }catch (Exception e){
//            jsonobj.put("status","failed");
//            jsonobj.put("message",e.getMessage());
//        }
//
//        //jsonobj = memberService.idCheck(map);
//        return jsonobj.toString();
//    }

    @RequestMapping(value = "join",method = RequestMethod.POST)
    @ResponseBody
    public String memberJoin(MemberVO memberVO) throws Exception {

        System.out.println("controller : "+memberVO.getName());
        System.out.println("controller : "+memberVO.getPhoneNumber());
        boolean result =  memberService.joinCheck(memberVO);
        System.out.println(result+"****");

        try {
            memberService.joinCheck(memberVO);
            modelAndView.addObject("result","success");
            modelAndView.addObject("message","가입 축하드립니다.");
            modelAndView.addObject("data",memberVO.getName());
            modelAndView.setViewName("main");
        }catch (Exception e){
            modelAndView.addObject("result","failed");
            modelAndView.addObject("message","가입이 실패하셨습니다.");

        }

        return String.valueOf(result);
    }

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public ModelAndView loginWrite(){
        modelAndView.setViewName("member/login");
        return modelAndView;
    }

    @RequestMapping(value = "loginCheck", method = RequestMethod.POST)
    public ModelAndView loginCheck(@ModelAttribute MemberVO memberVO , HttpSession session){
        System.out.println(memberVO.getId());
        boolean result =memberService.loginCheck(memberVO,session);
        if (result == true) {
            modelAndView.setViewName("main");
            modelAndView.addObject("msg","success");
        }else{
            modelAndView.setViewName("member/login");
            modelAndView.addObject("msg","failed");
        }
        return modelAndView;
    }

    @RequestMapping(value = "loginTest",method = RequestMethod.POST)
    @ResponseBody
    public String loginInsert(LoginVO loginVO) throws Exception{
        return "id : "+loginVO.getId()+"\t"+"password : "+loginVO.getPassword();
    }




}
