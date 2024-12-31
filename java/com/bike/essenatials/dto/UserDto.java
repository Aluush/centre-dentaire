package com.bike.essenatials.dto;

import java.io.Serializable;

public class UserDto implements Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6604653738582736876L;

	private long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String encryptPassword;
    private String emailVerification;
    private Boolean emailVerificationStatus = false;

}
