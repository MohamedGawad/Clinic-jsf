package com.se.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.se.mapping.Users;
import com.se.util.DBUtils;

@ManagedBean(name = "myBean")
@SessionScoped
public class LoginBean implements Serializable
{
	private Session session;
	private Users user = null;
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
		Criteria cr = session.createCriteria(Users.class);
		cr.add(Restrictions.eq("username", userName));
		cr.add(Restrictions.eq("password", passWord));
		List<Users> users = (List<Users>) cr.list();
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
		{
			FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
	        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	        FacesContext.getCurrentInstance().addMessage(null, msg);
			return navBean.redirectToFailed();
		}

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

	public Users getUser()
	{
		return user;
	}

	public void setUser(Users user)
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
