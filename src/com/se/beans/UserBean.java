package com.se.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.se.mapping.Users;


@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable
{
	private Users user;

	public UserBean()
	{
	}

	@PostConstruct
	public void init()
	{
	}

	public Users getUser()
	{
		return user;
	}

	public void setUser(Users user)
	{
		this.user = user;
	}

}
