package com.se.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.se.mapping.TblSeUsers;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable
{
	private TblSeUsers user;

	public UserBean()
	{
	}

	@PostConstruct
	public void init()
	{
	}

	public TblSeUsers getUser()
	{
		return user;
	}

	public void setUser(TblSeUsers user)
	{
		this.user = user;
	}

}
