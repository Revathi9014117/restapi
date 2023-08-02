package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptionhandling.apiresponse;
import com.example.demo.models.mymodels;
import com.example.demo.payload.mypayload;
import com.example.demo.services.myservice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")

public class mycontroller {
	@Autowired

	myservice service;
	@PostMapping("/insert")
	public ResponseEntity< mypayload > addusers(@Valid @RequestBody mypayload up){
	mypayload revathi=this.service.addusers(up);
	return new ResponseEntity<>(revathi,HttpStatus.CREATED);
	}
	@PutMapping("update/{id}")
	public ResponseEntity<mypayload> updateusers(@Valid @PathVariable int id,@RequestBody mypayload myd){
		mypayload model=this.service.updateusers(myd, id);
		return ResponseEntity.ok(model);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<apiresponse>deleteusers(@Valid @PathVariable int id){
		this.service.deleteusers(id);
		return new ResponseEntity<apiresponse>(new apiresponse("id deleted succesfully",true),HttpStatus.OK);
	}
	@GetMapping("getall")
	public ResponseEntity<List<mypayload>> getall(){
		return ResponseEntity.ok(this.service.getallusers());
	}
	
	
	}