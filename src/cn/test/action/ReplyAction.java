package cn.test.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.test.model.Message;
import cn.test.model.Reply;
import cn.test.model.User;
import cn.test.service.ReplyService;

@Scope("prototype")
@Controller("replyAction")
public class ReplyAction {

	private HttpServletRequest request = ServletActionContext.getRequest();

	int pagesize = 10;

	@Autowired(required = false)
	@Qualifier("replyServiceImpl")
	ReplyService replyService;

	// �ظ��б�
	@Autowired(required = false)
	List<Reply> reply;

	public List<Reply> getReply() {
		return reply;
	}

	public void setReply(List<Reply> reply) {
		this.reply = reply;
	}

	// ǰ�˷��ص���תҳ�룬����ȥ���Ƿ�ҳ����
	@Autowired(required = false)
	public int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	// �ظ���Ϣ
	public String rm;

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	// ��ӻظ�
	public String add() throws Exception {

		int cpage = 1;
		Message m = (Message) ActionContext.getContext().getSession().get("m");
		User u = (User) ActionContext.getContext().getSession().get("u");
		System.out.println("111111111111111111111111111111111111111111111" + u.getId());
		replyService.addReply(u.getId(), m.getMessageid(), rm);
		reply = replyService.getReplys(m.getMessageid(), cpage, pagesize);
		
		
		if (cpage < 3)
			page = 3;
		else
			page = cpage;
		return "success";
		

	}

	public String delete() throws Exception {

		int cpage = 3;
		Message m = (Message) ActionContext.getContext().getSession().get("m");
		String replyid = request.getParameter("replyid").toString();
		replyService.deleteReply(replyid);
		reply = replyService.getReplys(m.getMessageid(), cpage, pagesize);
		
		if (cpage < 3)
			page = 3;
		else
			page = cpage;
		return "success";

	}

}
