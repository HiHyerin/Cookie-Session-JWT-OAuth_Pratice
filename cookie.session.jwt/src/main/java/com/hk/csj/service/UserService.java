package com.hk.csj.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.undo.UndoManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.csj.mapper.UserMapper;
import com.hk.csj.vo.UserVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
// Lombok으로 스프링에서 DI(의존성 주입)의 방법 중에 생성자 주입을 임의의 코드없이 
// 자동으로 설정해주는 어노테이션이다.
public class UserService {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
	Date time = new Date();
	String localTime = format.format(time);
	
	
	private final UserMapper userMapper; // @RequiredArgsConstructor는 final, static만 생성자 주입해주는거라 UserMapper은 따로 autowired 해줘야함.
	
	@Transactional
	public void joinUser(UserVO userVo) {
		userVo.setAppendDate(localTime);
		userVo.setUpdateDate(localTime);
		userVo.setUserAuth("USER");
		userMapper.saveUser(userVo);
	}
	
	@Transactional
	public UserVO loginUser(UserVO userVO) {
		userMapper.loginUser(userVO);
		return userVO;
	}
	
	
}
