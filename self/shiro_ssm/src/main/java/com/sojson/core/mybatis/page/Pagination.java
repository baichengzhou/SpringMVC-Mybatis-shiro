package com.sojson.core.mybatis.page;

import java.util.List;


@SuppressWarnings("serial")
public class Pagination<T> extends SimplePage implements java.io.Serializable,
		Paginable {

	public Pagination() {
	}

	public Pagination(int pageNo, int pageSize, int totalCount) {
		super(pageNo, pageSize, totalCount);
	}

	@SuppressWarnings("unchecked")
	public Pagination(int pageNo, int pageSize, int totalCount, List list) {
		super(pageNo, pageSize, totalCount);
		this.list = list;
	}

	public int getFirstResult() {
		return (pageNo - 1) * pageSize;
	}

	/**
	 * 当前页的数据
	 */
	private List<T> list;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	
	/**SOJSON SEO 翻页版本*/
	public String getWebPage(String page){
		StringBuffer pageHtml = new StringBuffer("<ul class='pagination'>");
		if(this.getPageNo()>1){
			if(this.getPageNo()>5){
				pageHtml.append("<li><a href='javascript:;' onclick='"+ page +"'>首页</a></li>");
			}
			pageHtml.append("<li><a href='"+ page +""+(this.getPageNo() -1) +"'>上一页</a></li>");
		}
		for (int i = (this.getPageNo()-2<=0?1:this.getPageNo()-2),no = 1; i <= this.getTotalPage()&& no <6 ; i++,no++) {
			if (this.getPageNo() == i) {
				pageHtml.append("<li class='active'><a href='javascript:void(0);' >"+i+"</a></li>");
			}else{
				pageHtml.append("<li><a href='"+ page +""+ i +"'>"+i+"</a></li>");
			}
		}
		if(this.getPageNo() < this.getTotalPage()){
			pageHtml.append("<li><a href='"+ page +""+(this.getPageNo()+1) +"'>下一页</a></li>");
		}
		pageHtml.append("</ul>");
		return pageHtml.toString();
	}
	
	
	
	
	
	/**
	 *
	 *
	 <ul>
					<li class="disabled">
						<a href="#">«</a>
					</li>
					<li class="active">
						<a href="#">1</a>
					</li>
					<li>
						<a href="#">2</a>
					</li>
					<li>
						<a href="#">3</a>
					</li>
					<li>
						<a href="#">4</a>
					</li>
					<li>
						<a href="#">»</a>
					</li>
				</ul>
	 * 
	 * 
	 */
	
	
	
	
	/**Ajxa翻页*/
	public String getSiAjaxPageHtml(){
		StringBuffer pageHtml = new StringBuffer("<ul class='pagination'>");
		if(this.getPageNo()>1){
			if(this.getPageNo()>5){
				pageHtml.append("<li><a href='javascript:;' onclick='goPageByAjax(1)'>首页</a></li>");
			}
			pageHtml.append("<li><a href='javascript:;'  onclick='goPageByAjax("+(this.getPageNo() - 1)+")'>上一页</a></li>");
		}
		for (int i = (this.getPageNo()-2<=0?1:this.getPageNo()-2),no = 1; i <= this.getTotalPage()&& no <6 ; i++,no++) {
			if (this.getPageNo() == i) {
				pageHtml.append("<li class='active'><a href='javascript:void(0);' >"+i+"</a></li>");
			}else{
				pageHtml.append("<li><a href='javascript:;' onclick='goPageByAjax("+i+")'>"+i+"</a></li>");
			}
		}
		if(this.getPageNo() < this.getTotalPage()){
			pageHtml.append("<li><a href='javascript:;'  onclick='goPageByAjax("+(this.getPageNo() + 1)+")'>下一页</a></li>");
		}
		pageHtml.append("</ul>");
		return pageHtml.toString();
	}
	
	/**普通翻页*/
	public String getPageHtml(){
		StringBuffer pageHtml = new StringBuffer("<ul class='pagination'>");
		if(this.getPageNo()>1){
			if(this.getPageNo()>5){
				pageHtml.append("<li><a href='javascript:;' onclick='_submitform(1)'>首页</a></li>");
			}
			pageHtml.append("<li><a href='javascript:;'  onclick='_submitform("+(this.getPageNo() - 1)+")'>上一页</a></li>");
		}
		for (int i = (this.getPageNo()-2<=0?1:this.getPageNo()-2),no = 1; i <= this.getTotalPage()&& no <6 ; i++,no++) {
			if (this.getPageNo() == i) {
				pageHtml.append("<li class='active'><a href='javascript:void(0);' >"+i+"</a></li>");
			}else{
				pageHtml.append("<li><a href='javascript:;' onclick='_submitform("+i+")'>"+i+"</a></li>");
			}
		}
		if(this.getPageNo() < this.getTotalPage()){
			pageHtml.append("<li><a href='javascript:;'  onclick='_submitform("+(this.getPageNo() + 1)+")'>下一页</a></li>");
		}
		pageHtml.append("</ul>");
		pageHtml.append("<script>");
		pageHtml.append("	function _submitform(pageNo){");
		pageHtml.append("		$(\"#formId\").append($(\"<input type='hidden' value='\" + pageNo +\"' name='pageNo'>\")).submit();");
		pageHtml.append("	}");
		pageHtml.append("</script>");
		
		return pageHtml.toString();
	}
	
	
	

	/**
	 * web前端分页
	 * 
	 * @param num
	 *            参数 int 用作显示几个数字按钮，默认3个。
	 * @return
	 */
	public String getWebPageHtml() {
		int num = 3;
		StringBuffer pageHtml = new StringBuffer();
		pageHtml.append("<script language=\"JavaScript\"> \n");
		pageHtml.append("function subPageForward(pageNo) { \n");
		pageHtml.append("if(pageNo==" + getPageNo() + ")return false; \n");
		pageHtml.append("document.getElementById('pageNo').value=pageNo; \n");
		pageHtml.append("document.forms[0].submit(); \n");
		pageHtml.append("} \n");
		pageHtml.append("function subPageSizeForward(pageSize) { \n");
		pageHtml
				.append("document.getElementById('pageSize').value=pageSize; \n");
		pageHtml.append("document.getElementById('pageNo').value=1; \n");
		pageHtml.append("document.forms[0].submit(); \n");
		// pageHtml.append(" $('form').is(\"visible\")[0][0].submit();// document.forms[0].submit(); \n");
		pageHtml.append("} \n");
		pageHtml.append("function checkExec(self,event){\n");

		pageHtml.append("if(self.value=='')return;");
		pageHtml.append("var _patrn=/^[1-9]{1,5}$/;\n");
		pageHtml.append("if (_patrn.exec(self.value)){\n");
		pageHtml.append("if(self.value>=" + getTotalPage() + "){\n");
		pageHtml.append("	document.getElementById('goPage').value ="
				+ getTotalPage() + "\n");
		pageHtml.append("	}else if(self.value>=" + getTotalPage() + "){\n");
		pageHtml.append("	document.getElementById('goPage').value ="
				+ getPageNo() + "\n");
		pageHtml.append("	}\n");
		pageHtml.append("}else{\n");
		pageHtml.append("	document.getElementById('goPage').value =\"\"\n");
		pageHtml.append("} \n");
		pageHtml.append("if(event.keyCode == 13 && document.getElementById('goPage').value>0){\n");
		pageHtml.append("subPageForward(document.getElementById('goPage').value);\n");
		pageHtml.append("} \n");
		pageHtml.append("} \n");
		pageHtml.append("</script> \n");
		pageHtml.append("<input type=\"hidden\" name=\"pageNo\" id=\"pageNo\" value=\""
						+ getPageNo() + "\" /> \n");
		pageHtml.append("<input type=\"hidden\" name=\"pageSize\" id=\"pageSize\" value=\""
						+ getPageSize() + "\" /> \n");
		pageHtml.append("<input type=\"hidden\" name=\"filterNo\" id=\"filterNo\" value=\""
						+ getFilterNo() + "\" /> \n");
		if (getPageNo() <= 1) {
			pageHtml.append("<a href=\"javascript:void(0);\" class=\"curr\">首页</a>\n");
			pageHtml.append("<a href=\"javascript:void(0);\">上一页</a>\n");
		} else {
			pageHtml
					.append("<a href=\"javascript:void(0);\" onclick=\"return subPageForward(1);\">首页</a>\n");
			pageHtml
					.append("<a href=\"javascript:void(0);\" onclick=\" return subPageForward("
							+ getPrePage() + ");\">上一页</a>\n");
		}
		if (getPageNo() > 2)
			if (getTotalPage() > num)
				pageHtml.append("<a href=\"javascript:void(0);\">...</a>");
		for (int i = 0; i < num; i++) {
			int var = getPageNo() == getTotalPage() ? getPageNo() + i - 2
					: getPageNo() == 1 ? getPageNo() + i : getPageNo() + i - 1;
			String cenClass = var == getPageNo() ? "curr" : "";
			String click = var == getPageNo() ? ""
					: "onclick=\"return subPageForward(" + (var) + ")\"";
			if (var < getTotalPage() + 1 && var > 0) {
				pageHtml.append("<a href=\"javascript:void(0);\" class=\""
						+ cenClass + "\" " + click + ">" + (var) + "</a>\n");
			}
		}
		if (getTotalPage() > num && getTotalPage() > (getPageNo() + 1))
			pageHtml.append("<a href=\"javascript:void(0);\">...</a>");
		if (getPageNo() >= getTotalPage()) {
			pageHtml.append("<a href=\"javascript:void(0);\">下一页</a>\n");
			pageHtml.append("<a href=\"javascript:void(0);\" class=\"curr\">尾页</a>\n");
		} else {
			pageHtml.append("<a href=\"javascript:void(0);\" onclick=\"return subPageForward("
							+ getNextPage() + "); \">下一页</a>\n");
			pageHtml.append("<a href=\"javascript:void(0);\" onclick=\"return subPageForward("
							+ getTotalPage() + "); \">尾页</a>\n");
		}
		pageHtml.append("<em class=\"fl\"><input class=\"xiao_inp mr5\" onfocus=\"this.select();\"  value=\""
						+ getPageNo()
						+ "\"  onkeyup=\"checkExec(this,event)\" id=\"goPage\"/>/"
						+ getTotalPage() + "页&nbsp;</em>\n");
		pageHtml.append("<a href=\"javascript:void(0);\" onclick=\"return subPageForward(document.getElementById('goPage').value);\" >Go</a>\n");
		return pageHtml.toString();
	}

	/**
	 * web前端ajax分页
	 * 
	 * @param num
	 *            参数 int 用作显示几个数字按钮，默认3个。
	 * @return
	 */
	public String getWebAjaxPageHtml() {
		int num = 3;
		StringBuffer pageHtml = new StringBuffer();
		pageHtml.append("<script language=\"JavaScript\"> \n");
		pageHtml.append("function subPageForward(pageNo) { \n");
		pageHtml.append("if(pageNo==" + getPageNo() + ")return false; \n");
		pageHtml.append("document.getElementById('pageNo').value=pageNo; \n");
		pageHtml.append(" ajaxFormSubmit() ; \n");
		pageHtml.append("} \n");
		pageHtml.append("function subPageSizeForward(pageSize) { \n");
		pageHtml.append("document.getElementById('pageSize').value=pageSize; \n");
		pageHtml.append("document.getElementById('pageNo').value=1; \n");
		pageHtml.append("	ajaxFormSubmit(); \n");
		pageHtml.append("} \n");
		pageHtml.append("function checkExec(self,event){\n");

		pageHtml.append("if(self.value=='')return;");
		pageHtml.append("var _patrn=/^[1-9]{1,5}$/;\n");
		pageHtml.append("if (_patrn.exec(self.value)){\n");
		pageHtml.append("if(self.value>=" + getTotalPage() + "){\n");
		pageHtml.append("	document.getElementById('goPage').value ="
				+ getTotalPage() + "\n");
		pageHtml.append("	}else if(self.value>=" + getTotalPage() + "){\n");
		pageHtml.append("	document.getElementById('goPage').value ="
				+ getPageNo() + "\n");
		pageHtml.append("	}\n");
		pageHtml.append("}else{\n");
		pageHtml.append("	document.getElementById('goPage').value =\"\"\n");
		pageHtml.append("} \n");
		pageHtml
				.append("if(event.keyCode == 13 && document.getElementById('goPage').value>0){\n");
		pageHtml
				.append("subPageForward(document.getElementById('goPage').value);\n");
		pageHtml.append("} \n");
		pageHtml.append("} \n");
		pageHtml.append("</script> \n");
		pageHtml.append("<input type=\"hidden\" name=\"pageNo\" id=\"pageNo\" value=\""
						+ getPageNo() + "\" /> \n");
		pageHtml.append("<input type=\"hidden\" name=\"pageSize\" id=\"pageSize\" value=\""
						+ getPageSize() + "\" /> \n");
		pageHtml.append("<input type=\"hidden\" name=\"filterNo\" id=\"filterNo\" value=\""
						+ getFilterNo() + "\" /> \n");
		if (getPageNo() <= 1) {
			pageHtml.append("<a href=\"javascript:void(0);\" class=\"curr\">首页</a>\n");
			pageHtml.append("<a href=\"javascript:void(0);\">上一页</a>\n");
		} else {
			pageHtml.append("<a href=\"javascript:void(0);\" onclick=\"return subPageForward(1);\">首页</a>\n");
			pageHtml.append("<a href=\"javascript:void(0);\" onclick=\" return subPageForward("
							+ getPrePage() + ");\">上一页</a>\n");
		}
		if (getPageNo() > 2)
			pageHtml.append("<a href=\"javascript:void(0);\">...</a>");
		for (int i = 0; i < num; i++) {
			int var = getPageNo() == getTotalPage() ? getPageNo() + i - 2
					: getPageNo() == 1 ? getPageNo() + i : getPageNo() + i - 1;
			String cenClass = var == getPageNo() ? "curr" : "";
			String click = var == getPageNo() ? ""
					: "onclick=\"return subPageForward(" + (var) + ")\"";
			if (var < getTotalPage() + 1 && var > 0) {
				pageHtml.append("<a href=\"javascript:void(0);\" class=\""
						+ cenClass + "\" " + click + ">" + (var) + "</a>\n");
			}
		}
		if (getTotalPage() > num && getTotalPage() > (getPageNo() + 1))
			pageHtml.append("<a href=\"javascript:void(0);\">...</a>");
		if (getPageNo() >= getTotalPage()) {
			pageHtml.append("<a href=\"javascript:void(0);\">下一页</a>\n");
			pageHtml
					.append("<a href=\"javascript:void(0);\" class=\"curr\">尾页</a>\n");
		} else {
			pageHtml.append("<a href=\"javascript:void(0);\" onclick=\"return subPageForward("
							+ getNextPage() + "); \">下一页</a>\n");
			pageHtml.append("<a href=\"javascript:void(0);\" onclick=\"return subPageForward("
							+ getTotalPage() + "); \">尾页</a>\n");
		}
		pageHtml.append("<em class=\"fl\"><input class=\"xiao_inp mr5\" onfocus=\"this.select();\"  value=\""
						+ getPageNo()
						+ "\"  onkeyup=\"checkExec(this,event)\" id=\"goPage\"/>/"
						+ getTotalPage() + "页&nbsp;</em>\n");
		pageHtml.append("<a href=\"javascript:void(0);\" onclick=\"return subPageForward(document.getElementById('goPage').value);\" >Go</a>\n");
		return pageHtml.toString();
	}

	/***
	 * 后台原始分页Ajax
	 * 
	 * @return
	 */
	public String getAjaxPageHtml() {
		StringBuffer PageHtml = new StringBuffer();
		PageHtml.append("<script language=\"JavaScript\"> \n");
		PageHtml.append("function subPageForward(pageNo) { \n");
		PageHtml.append("document.getElementById('pageNo').value=pageNo; \n");
		PageHtml.append(" ajaxFormSubmit() ;\n");
		PageHtml.append("} \n");
		PageHtml.append("function subPageSizeForward(pageSize) { \n");
		PageHtml.append("document.getElementById('pageSize').value=pageSize; \n");
		PageHtml.append("document.getElementById('pageNo').value=1; \n");
		PageHtml.append("document.forms[0].submit(); \n");
		PageHtml.append("} \n");
		PageHtml.append("</script> \n");
		PageHtml.append("<input type=\"hidden\" name=\"pageNo\" id=\"pageNo\" value=\""
						+ this.getPageNo() + "\" /> \n");
		PageHtml.append("<input type=\"hidden\" name=\"pageSize\" id=\"pageSize\" value=\""
						+ this.getPageSize() + "\" /> \n");
		PageHtml
				.append("<input type=\"hidden\" name=\"filterNo\" id=\"filterNo\" value=\""
						+ this.getFilterNo() + "\" /> \n");
		PageHtml.append("<input type=\"hidden\" name=\"totalCount\" id=\"totalCount\" value=\""
						+ this.getTotalCount() + "\" /> \n");
		PageHtml.append("<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
		PageHtml.append(" <tr><td>");
		if (this.getPageNo() <= 1) {
			PageHtml.append("<font>首页</font>&nbsp;&nbsp;</td>");
			PageHtml.append(" <td> <font>上页</font>&nbsp;&nbsp;</td>");
		} else {
			PageHtml.append("  <a  style='color:blue;' href=\"#\" onclick=\"subPageForward(1,event);");
			PageHtml.append("return false;\"><font>首页</font></a>&nbsp;&nbsp;</td>");
			PageHtml.append(" <td>");
			PageHtml.append(" <a  href=\"#\" onclick=\"subPageForward("
							+ this.getPrePage()
							+ ",event);return false;\" style='color:blue;'><font>上页</font></a>&nbsp;&nbsp;</td>");
		}
		if (this.getPageNo() >= this.getTotalPage()) {
			PageHtml.append(" <td>");
			PageHtml.append(" <font >下页 </font>&nbsp;&nbsp;</td>");
			PageHtml.append("<td><font>尾页</font>&nbsp;&nbsp;</td>");
		} else {
			PageHtml.append(" <td>");
			PageHtml.append(" <a  href=\"#\" onclick=\"subPageForward("
							+ this.getNextPage()
							+ ",event);return false;\" style='color:blue;'><font>下页</font></a>&nbsp;&nbsp;</td>");
			PageHtml.append("<td><a  href=\"#\" onclick=\"subPageForward("
							+ this.getTotalPage()
							+ ",event);return false;\" style='color:blue;'><font>尾页</font></a>&nbsp;&nbsp;</td>");
		}
		PageHtml.append("<td>" + this.getPageNo() + "/" + this.getTotalPage()
				+ "&nbsp;&nbsp;</td>");
		PageHtml.append("<td id='countNum'>记录总数：" + this.getTotalCount()
				+ "&nbsp;&nbsp;</td>");
		PageHtml.append("<td>第<select class='Select' onchange='subPageForward(this.value,event);'>");
		for (int i = 1; i < this.getTotalPage() + 1; i++) {
			if (i == this.getPageNo()) {
				PageHtml.append("<option value=" + i + " selected>" + i
						+ "</option>");
			} else {
				PageHtml.append("<option value=" + i + ">" + i + "</option>");
			}
		}
		PageHtml.append("</select>页</td></tr></table>");

		return PageHtml.toString();

	}
}
