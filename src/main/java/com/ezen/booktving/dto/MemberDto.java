package com.ezen.booktving.dto;

import com.ezen.booktving.constant.Role;
import com.ezen.booktving.entity.Member;
import lombok.Data;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;

@Data
public class MemberDto {

    private Long id;

    private String userId;
    
    private String password;
    
    private String memberName;
    
    private String email;
    
    private String tel;
    
    private LocalDate birth;
    
    private String address;
    
    private Role role;
    
    private static ModelMapper modelMapper = new ModelMapper();
    
    public Member createMember(){
        return modelMapper.map(this, Member.class);
    }

    public static MemberDto of(Member member){
        return modelMapper.map(member,MemberDto.class);
    }



}