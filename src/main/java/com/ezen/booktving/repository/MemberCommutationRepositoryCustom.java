package com.ezen.booktving.repository;

import com.ezen.booktving.dto.MemberCommutationDto;

public interface MemberCommutationRepositoryCustom {
	MemberCommutationDto getMemberCommutationInfo(String userId);
}
