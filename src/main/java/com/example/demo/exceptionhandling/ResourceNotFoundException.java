package com.example.demo.exceptionhandling;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ResourceNotFoundException extends RuntimeException {
	String ResourcName;
	String FieldName;
	int FieldValue;
	public ResourceNotFoundException(String ResourceName,String FieldName,int FieldValue) {
		super(String.format("% Not Found With %s :%s",ResourceName,FieldName,FieldName ));
		this.ResourcName=ResourceName;
		this.FieldName=FieldName;
		this.FieldValue=FieldValue;
	}

}
