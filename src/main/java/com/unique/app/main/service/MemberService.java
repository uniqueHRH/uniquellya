package com.unique.app.main.service;

import com.unique.app.user.dto.MemberDTO;

public interface MemberService {
    public MemberDTO findLoginInfo(MemberDTO dto);
}
