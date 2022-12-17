package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.UserException;
import com.masai.model.CurrentUserSesson;
import com.masai.model.FIR;
import com.masai.model.LoginDao;
import com.masai.model.User;
import com.masai.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/masaifir")
public class UserController {
	
	@Autowired
	public UserService uservice;
	
	
	
	@PostMapping("/user/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws UserException{
		
		User ruser=uservice.registerUser(user);
		return new ResponseEntity<User>(ruser,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/user/login")
	public ResponseEntity<CurrentUserSesson> userLogin(@RequestBody LoginDao ldao) throws UserException{
		
		CurrentUserSesson loginuser=uservice.userLogin(ldao);
		return new ResponseEntity<CurrentUserSesson>(loginuser,HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/user/logout")
	public ResponseEntity<String> UserLogOut(@PathVariable String key) throws UserException{
		
		String result=uservice.UserLogout(key);
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
		
		
	}
	
	@PostMapping("/user/fir")
	public ResponseEntity<FIR> UserFir(@RequestBody FIR fir) throws UserException{
		
		FIR userFir=uservice.userFir(fir);
		return new ResponseEntity<FIR>(userFir,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/user/fir")
	public ResponseEntity<List<FIR>> firRecord() throws UserException{
		List<FIR> listoffir=uservice.listOfFir();
		return new ResponseEntity<List<FIR>>(listoffir,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/user/fir/{firid}")
	public ResponseEntity<String> DelateFir(@PathVariable Integer firid) throws UserException{
		
		String result=uservice.DelateFir(firid);
		return new ResponseEntity<String>(result,HttpStatus.OK);
		
	}
	

}
