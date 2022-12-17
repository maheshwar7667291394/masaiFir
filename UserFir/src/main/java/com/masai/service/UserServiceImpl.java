package com.masai.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.UserException;
import com.masai.model.CurrentUserSesson;
import com.masai.model.FIR;
import com.masai.model.LoginDao;
import com.masai.model.User;
import com.masai.repo.CurrentUserSessonDao;
import com.masai.repo.FIRDao;
import com.masai.repo.UserDao;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserDao udao;
	
	@Autowired
	public CurrentUserSessonDao cdao;
	
	@Autowired
	public FIRDao fdao;

	@Override
	public User registerUser(User user) throws UserException {
		User rUser =udao.findBymobile(user.getMobile());
		if(rUser!=null) {
			throw new UserException("User Already register by this number");
		}
	
		return udao.save(user);
	}

	@Override
	public CurrentUserSesson userLogin(LoginDao loginuser) throws UserException {
		
		User rUser=udao.findBymobile(loginuser.getMobile());
		if(rUser==null) {
			throw new UserException("plese register first ");
		}
		
		Optional<CurrentUserSesson> cuser=cdao.findById(loginuser.getMobile());
		if(cuser.isPresent()) {
			throw new  UserException("user already logedin by this email");
		}
		
		
		if(rUser.getPassword().equals(loginuser.getPassword())) {
			String key=RandomString.make(6);
			CurrentUserSesson currentuser=new CurrentUserSesson(loginuser.getMobile(), key, loginuser.getPassword());
			return cdao.save(currentuser);
		}
		
		
		
		throw new UserException("Enter valid password");
	}

	@Override
	public String UserLogout(String key) throws UserException {
		
		CurrentUserSesson cuser=cdao.findByuuid(key);
		if(cuser==null) {
			throw new UserException("plese Enter valid uuid");
		}
		
		cdao.delete(cuser);
		return "User logout sussufull";
	}

	@Override
	public FIR userFir(FIR fir) throws UserException {
		
		User fuser=fir.getUserDetailsUser();
		fuser.setFirdetails(fir);
		udao.save(fuser);
		return (fir);
		
	
	}

	@Override
	public List<FIR> listOfFir() throws UserException {
		List<FIR> firlist=fdao.findAll();
		if(firlist.size()==0) {
			throw new UserException("no any fir record found");
		}
		return firlist;
	}

	@Override
	public String DelateFir(Integer firid) throws UserException {
		 Optional<FIR> delateFir=fdao.findById(firid);
		 if(delateFir.isEmpty()) {
			 throw new UserException("USer not foud by given id");
		 }
		 
		 FIR dfir=delateFir.get();
		 

		 LocalDateTime ldt=dfir.getTimeStamp();
		 LocalDateTime ldtn=LocalDateTime.now();
		 long diff=ldtn.getHour()-ldt.getHour();
		 if(diff>24) {
			 throw new UserException("you can not delate the fir now");
		 }
		 
		 
		 fdao.deleteById(firid);
		return "fir delation sucussfull";
	}
	
	

}
