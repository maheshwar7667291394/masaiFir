package com.masai.service;

import java.util.List;

import com.masai.exception.UserException;
import com.masai.model.CurrentUserSesson;
import com.masai.model.FIR;
import com.masai.model.LoginDao;
import com.masai.model.User;

public interface UserService {
	public User registerUser(User user)throws UserException;
	public CurrentUserSesson userLogin(LoginDao loginuser)throws UserException;
	public String UserLogout(String key)throws UserException;
	
	public FIR userFir(FIR fir)throws UserException;
	
	public List<FIR> listOfFir()throws UserException;
	
	public String DelateFir(Integer firid)throws UserException;

}
