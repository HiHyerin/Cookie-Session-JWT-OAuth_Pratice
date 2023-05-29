package com.hk.csj.vo;


import org.springframework.stereotype.Repository;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class UserVO {
	private int userNo;
	private String userId, userPw, userName, userAuth;
	private String appendDate, updateDate; 
}
