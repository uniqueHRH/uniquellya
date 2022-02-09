package com.unique.app.main.service.impl;

import com.unique.app.user.dao.MemberDAO;
import com.unique.app.user.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.unique.app.main.service.MemberService;

@Service
@RequiredArgsConstructor
public class MemberServiceIml implements MemberService {
    private MemberDAO memberDao;

    public MemberDTO findLoginInfo(MemberDTO dto) {
        return memberDao.findLoginInfo(dto);
    }
}
