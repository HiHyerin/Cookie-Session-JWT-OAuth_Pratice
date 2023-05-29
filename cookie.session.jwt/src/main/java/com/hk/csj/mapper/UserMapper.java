package com.hk.csj.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hk.csj.vo.UserVO;
@Mapper
// 유저 정보를 db에 저장하기 위한 Mapper인터페이스 구현
public interface UserMapper {
	void saveUser(UserVO userVo);

	UserVO loginUser(UserVO userVo);
//	String loginUser(String userId);

}
