package com.example.demo.services;

import java.util.List;

import com.example.demo.payload.mypayload;



public interface myservice {
	mypayload addusers(mypayload up);
	mypayload updateusers(mypayload up, int id);
	void deleteusers(int id);
	List<mypayload>  getallusers();
    mypayload getusersbyid (int id);	
}