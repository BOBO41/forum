package cn.test.action;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.persistence.criteria.CriteriaBuilder.In;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.test.model.User;
import cn.test.service.RegistService;
import cn.test.util.MD5Util;

@Scope("prototype")
@Controller("registAction")
public class RegisterAction {

	// ע������
	@Autowired(required = false)
	@Qualifier("passwordServiceImpl")
	RegistService registService;

	// ͷ��
	File image;

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	// �û�ע����Ϣ
	@Autowired(required = false)
	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// ����
	String pwd;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	// ע�ᣬ�����ж����ݿ��û��Ƿ����
	public String execute() throws Exception {
		if (registService.getUser(user) == null) {
			user.setLevel("user");
			user.setPassword(MD5Util.string2MD5(pwd));
			registService.addUser(user);

			InputStream is = new FileInputStream(image);
			if (is != null) {
				OutputStream os = new java.io.FileOutputStream(
						"D:/study/ReadyFoJavaee/Base1/WebContent/image/" + user.getId() + ".jpg");
				byte buffer[] = new byte[8192];
				int count = 0;
				while ((count = is.read(buffer)) > 0) {
					os.write(buffer, 0, count);
				}
				os.close();
				is.close();
			}
			return "success";
		} else
			return "fail";

	}

	// ��ת��ע��ҳ��
	public String regist() throws Exception {

		return "regist";

	}

}
