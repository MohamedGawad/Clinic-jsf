package com.se.beans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "navBean")
@ApplicationScoped
public class NavigationBean implements Serializable {

	public String redirectToLogin() {
		return "/pages/login.xhtml?faces-redirect=true";
	}

	/**
	 * Go to login page.
	 * 
	 * @return Login page name.
	 */
	public String toLogin() {
		return "/pages/login.xhtml";
	}

	public String redirectToIndex() {
		return "/pages/success.xhtml?faces-redirect=true";
	}

	public String toIndex() {
		return "/index.xhtml";
	}


	public String redirectToFailed() {
		return "/pages/failure.xhtml?faces-redirect=true";
	}

	public String toFailed() {
		return "/pages/failure.xhtml";
	}

	public String redirectToSuccess() {
		return "/pages/success.xhtml?faces-redirect=true";
	}

	public String toSuccess() {
		return "/pages/success.xhtml";
	}
}
