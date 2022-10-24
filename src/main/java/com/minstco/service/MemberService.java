package com.minstco.service;

import org.springframework.stereotype.Service;
import com.minstco.vo.MemberVO;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Service
public interface MemberService {


    public boolean joinCheck (MemberVO memberVO) throws Exception;

    public boolean loginCheck(MemberVO memberVO, HttpSession session);

    public MemberVO viewMember(MemberVO memberVO);

    public int idCheck(String id);


}
