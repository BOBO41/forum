package cn.test.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.test.model.Message;
import cn.test.model.Reply;
import cn.test.model.User;
import cn.test.service.*;

@Scope("prototype")
@Controller("messageAction")
public class MessageAction extends ActionSupport {

	private HttpServletRequest request = ServletActionContext.getRequest();

	// ÿҳ�б��С
	int pagesize = 10;

	// ��������
	@Autowired(required = false)
	@Qualifier("messageServiceImpl")
	MessageService messageService;

	// �ظ�����
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

	// �����б�
	@Autowired(required = false)
	List<Message> message;

	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
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

	// ���±���
	String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// ��������
	String article;

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	// ����ͼƬ
	File images;

	public File getImages() {
		return images;
	}

	public void setImages(File images) {
		this.images = images;
	}

	// ����ҳ����ÿҳ����
	public String messagepage() throws Exception {
		int cpage = 1;
		int pagecount = messageService.getPageCount(pagesize) + 1;
		if (Integer.valueOf(request.getParameter("page").toString()) == -1) {
			cpage = pagecount;
		} else
			cpage = Integer.valueOf(request.getParameter("page").toString());

		message = messageService.getMessages(cpage, pagesize);
		if (cpage < 3)
			page = 3;
		else if (cpage > (pagecount - 2)&&pagecount>=5)
			page = pagecount - 2;
		else
			page = cpage;
		return "success";

	}

	// �ظ�ҳ����ÿҳ����
	public String replypage() throws Exception {

		int cpage = 1;
		String messageid = request.getParameter("messageid").toString();
		int pagecount = replyService.getPageCount(messageid, pagesize) + 1;

		if (Integer.valueOf(request.getParameter("page").toString()) == -1) {
			cpage = pagecount;
		} else
			cpage = Integer.valueOf(request.getParameter("page").toString());

		Message m = messageService.getMessage(messageid);
		reply = replyService.getReplys(messageid, cpage, pagesize);
		ActionContext.getContext().getSession().put("m", m);

		if (cpage < 3)
			page = 3;
		else if (cpage > (pagecount - 2)&&pagecount>=5)
			page = pagecount - 2;
		else
			page = cpage;
		return "success";

	}

	public String delete() throws Exception {
		int cpage = 1;
		String messageid = request.getParameter("messageid").toString();
		messageService.deleteMessage(messageid);
		message = messageService.getMessages(cpage, pagesize);

		if (cpage < 3)
			page = 3;

		else
			page = cpage;
		return "success";

	}

	public String add() throws Exception {

		return "success";

	}

	public String addcheck() throws Exception {
		int cpage = 1;

		User u = (User) ActionContext.getContext().getSession().get("u");
		article = java.net.URLDecoder.decode(article, "utf-8");
		title = java.net.URLDecoder.decode(title, "utf-8");
		messageService.addMessage(title, article, u.getId());
		//System.out.println("222222222222222222" + article);
		/*
		 * String messageid = "test"; for(int i=0;i<images.size();i++){
		 * InputStream is = new FileInputStream(images); OutputStream os = new
		 * java.io.FileOutputStream(
		 * "D:/study/ReadyFoJavaee/Base1/WebContent/image/" + messageid +
		 * ".jpg"); byte buffer[] = new byte[8192]; int count = 0; while ((count
		 * = is.read(buffer)) > 0) { os.write(buffer, 0, count); } os.close();
		 * is.close(); }
		 */
		message = messageService.getMessages(cpage, pagesize);

		if (cpage < 3)
			page = 3;

		else
			page = cpage;
		return "success";

	}
}
