package cn.test.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.test.model.Message;
import cn.test.model.User;
import cn.test.service.*;
import cn.test.util.MD5Util;

@Scope("prototype")
@Controller("loginAction")
public class LoginAction extends ActionSupport {

	// private HttpServletRequest request = ServletActionContext.getRequest();

	// ��½����
	@Autowired(required = false)
	@Qualifier("loginServiceImpl")
	LoginService loginService;

	// �û�����֤�����session
	@Autowired(required = false)
	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// �����б�
	@Autowired(required = false)
	List<Message> message;

	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}

	// ��ʼҳ�飬���ص���3��Ϊ��ǰ���Ű棨ҳ��̶���5ҳ��
	@Autowired(required = false)
	public int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	// ��½У��
	public String execute() throws Exception {

		this.user.setPassword(MD5Util.string2MD5(this.user.getPassword()));
		user = loginService.loginCheck(this.user);
		if (user != null) {
			if (user.getLevel().equals("admin")) {

				ActionContext.getContext().getSession().put("u", this.user);
				message = loginService.getMessages(1, 10);
				page = 3;

				return "admin";
			} else if (user.getLevel().equals("user"))
				return "user";
			else
				return "WrongPassword";
		} else
			return "WrongPassword";

	}

	// ���ص�½����
	public String returnLogin() throws Exception {

		ActionContext.getContext().getSession().put("u", null);
		return "return";

	}

	public String out() throws Exception {

		// request.getSession().invalidate();
		return "out";

	}
}
