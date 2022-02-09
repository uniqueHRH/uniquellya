package com.unique.app.user.dao;

import com.unique.app.user.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {
    public MemberDTO findLoginInfo(MemberDTO dto);
}
