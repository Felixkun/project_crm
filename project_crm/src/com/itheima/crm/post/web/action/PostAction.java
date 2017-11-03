package com.itheima.crm.post.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itheima.crm.base.BaseAction;
import com.itheima.crm.post.daomain.CrmPost;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class PostAction extends BaseAction<CrmPost> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public String findAllWithDepartment() throws IOException{
		
		
		//1.��ѯ
		List<CrmPost> allPost = this.getPostService().findAll(this.getModel().getDepartment());
		
		JsonConfig config  = new JsonConfig();
		
		config.setExcludes(new String[]{"department","staffSet"});
		
		
		String jsonData = JSONArray.fromObject(allPost, config).toString();
		
		
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(jsonData);
		return "none";
	}
	

}
