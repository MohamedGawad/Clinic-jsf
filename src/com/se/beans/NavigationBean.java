package com.se.beans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "navBean")
@ApplicationScoped
public class NavigationBean implements Serializable
{

	public String redirectToSignup()
	{
		return "/pages/signup.xhtml?faces-redirect=true";
	}

	public String toSignup()
	{
		return "/pages/signup.xhtml";
	}

	public String redirectToLogin()
	{
		return "/login.xhtml?faces-redirect=true";
	}

	/**
	 * Go to login page.
	 * 
	 * @return Login page name.
	 */
	public String toLogin()
	{
		return "/login.xhtml";
	}

	public String redirectToIndex()
	{
		return "/success.xhtml?faces-redirect=true";
	}

	public String toIndex()
	{
		return "/index.xhtml";
	}

	public String redirectToSubmit()
	{
		return "/pages/submit.xhtml?faces-redirect=true";
	}

	public String toSubmit()
	{
		return "/pages/submit.xhtml";
	}

	public String redirectToFailed()
	{
		return "/failure.xhtml?faces-redirect=true";
	}

	public String toFailed()
	{
		return "/pages/failure.xhtml";
	}

	public String redirectToSuccess()
	{
		return "/pages/success.xhtml?faces-redirect=true";
	}

	public String toSuccess()
	{
		return "/pages/success.xhtml";
	}
}
