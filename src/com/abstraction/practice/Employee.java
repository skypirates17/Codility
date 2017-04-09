package com.abstraction.practice;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Employee extends Person implements Externalizable, Serializable {

	transient float john = 9138983.834309F;
	
	strictfp void doCompute () {
		
	}
	
	public Employee(Map<Map<String, Object>, String> sample2) {
		super(sample2);
		// TODO Auto-generated constructor stub
	}

	private String empCode;

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }
    
    public static void main(String[] args) {
		//Person person = new Person();
		
	}

	@Override
	public void readExternal(ObjectInput arg0) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeExternal(ObjectOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}
}
