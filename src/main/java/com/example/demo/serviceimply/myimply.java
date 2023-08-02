package com.example.demo.serviceimply;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.exceptionhandling.ResourceNotFoundException;
import com.example.demo.models.mymodels;
import com.example.demo.payload.mypayload;
import com.example.demo.repository.signuprepository;
import com.example.demo.services.myservice;

@Service

public class myimply implements myservice {
	@Autowired
	signuprepository repo;
	@Autowired
	ModelMapper modelmapper;

	@Override
	public mypayload addusers(mypayload up) {
		mymodels my = this.dto_mymodels(up);
		mymodels savesmymodels = (mymodels) this.repo.save(my);
		return this.mymodels_dto(savesmymodels);
	}

	@Override
	public mypayload updateusers(mypayload up, int id) {
	mymodels my=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("mymodels","id", id));
		my.setName(up.getName());
		my.setEmail(up.getEmail());
		my.setPassword(up.getPassword());
		mymodels my1=this.repo.save(my);
		mypayload myd=this.mymodels_dto(my1);
		return myd;
	}

	@Override
	public void deleteusers(int id) {
		mymodels my=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("mymodels","id",id));
		this.repo.delete(my);

	}

	@Override
	public List<mypayload> getallusers() {
		List<mymodels> my=(List<mymodels>) this.repo.findAll();
		List<mypayload> myd=my.stream().map(myp->this.mymodels_dto(myp)).collect(Collectors.toList());
		return myd;
	}

	@Override
	public mypayload getusersbyid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	 public mymodels dto_mymodels(mypayload up) {
		 mymodels u =this.modelmapper.map(up,mymodels.class); //modelmapper is used for two way data shifting
		 return u;
	 }
	 public mypayload mymodels_dto(mymodels userp) {
		 mypayload up =this.modelmapper.map(userp,mypayload.class);
		 return up;
	 }

	
}