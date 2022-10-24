package com.minstco.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.minstco.vo.MemberVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberDAO {

    @Autowired
    private SqlSession sqlSession;

    private  static final String NAMESPACE = "com.mysite.mapper.UserMapper";

    public int idCheck(String id){
        int cnt = sqlSession.selectOne(NAMESPACE+".idCheck",id);
        return cnt;
    }


    public boolean joinCheck(MemberVO memberVO) throws Exception{
        boolean check = false;
        int result = sqlSession.selectOne("member.joinCheck",memberVO);
        System.out.println("result :: "+result);
        if(result>0){
            check= false;
        }else{
            check= true;
            sqlSession.insert("member.memberInsert",memberVO);
            System.out.println(memberVO.getId()+"!!!!");

        }
        System.out.println(check+"@@@@");
        return check;
    }


    public boolean loginCheck(MemberVO memberVO){
        String name= sqlSession.selectOne("member.loginCheck",memberVO);
        System.out.println(name);
        return (name == null) ? false : true;
    }

    public MemberVO viewMember(MemberVO memberVO){
        return sqlSession.selectOne("member.viewMember",memberVO);
    }
}
