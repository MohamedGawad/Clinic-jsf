package com.se.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.se.mapping.TblSeUsers;
import com.se.util.DBUtils;

@ManagedBean(name = "myBean")
@ViewScoped
public class LoginBean implements Serializable
{
	private Session session;
	private TblSeUsers user = null;
	private String userName;
	private String passWord;
	private boolean rememberMe;
	private boolean loggedIn;

	@ManagedProperty(value = "#{userBean}")
	private UserBean userBean;

	@ManagedProperty(value = "#{navBean}")
	private NavigationBean navBean;

	public String logMeIn()
	{

		session = DBUtils.openSession();
		Criteria cr = session.createCriteria(TblSeUsers.class);
		cr.add(Restrictions.eq("userName", userName));
		cr.add(Restrictions.eq("password", passWord));
		List<TblSeUsers> users = (List<TblSeUsers>) cr.list();
		if(!users.isEmpty())
		{
			user = users.get(0);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.put("currentUser", user);
			loggedIn = true;
			DBUtils.closeSession(session);
			userBean.setUser(user);
			return navBean.redirectToIndex();
		}
		else
			return navBean.redirectToFailed();

	}

	public String logMeOut()
	{
		loggedIn = false;
		user = null;
		userBean.setUser(null);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.remove("currentUser");
		return navBean.redirectToIndex();
	}

	public void setNavBean(NavigationBean navBean)
	{
		this.navBean = navBean;
	}

	/**
	 * @param userBean
	 *            the userBean to set
	 */
	public void setUserBean(UserBean userBean)
	{
		this.userBean = userBean;
	}

	public TblSeUsers getUser()
	{
		return user;
	}

	public void setUser(TblSeUsers user)
	{
		this.user = user;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassWord()
	{
		return passWord;
	}

	public void setPassWord(String passWord)
	{
		this.passWord = passWord;
	}

	public boolean isRememberMe()
	{
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe)
	{
		this.rememberMe = rememberMe;
	}

	public boolean isLoggedIn()
	{
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn)
	{
		this.loggedIn = loggedIn;
	}

}
