package com.ezen.booktving.repository;

import com.ezen.booktving.dto.MemberCommutationDto;
import com.ezen.booktving.entity.MemberCommutation;

public interface MemberCommutationRepositoryCustom {
	MemberCommutationDto getMemberCommutationInfo(String userId);
	
	MemberCommutation getMemberCommutationByUserId(String userId);
}
