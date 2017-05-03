package com.shu.sil.eo.label.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Controller;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;

@Controller("mjolnirAction")
public class MjolnirAction extends ActionSupport {
	Gson gsonTemp = new GsonBuilder().disableHtmlEscaping().create();

	private static final long serialVersionUID = 1L;
	private Object allProductTypeInfoObj;
	private String allProductTypeInfoStr;
	private String productTypeInfoStr;
	private String editModelStr;
	private String oidListStr;
	private String textshowStr;
	private String docFilename;

	public void setTextshowStr(String textshowStr) {
		this.textshowStr = textshowStr;
	}

	public void setDocFilename(String docFilename) {
		this.docFilename = docFilename;
	}

	public String saveTextshow() {

		System.out.println("已经得到" + this.textshowStr);
		String filename=ServletActionContext
		.getServletContext().getRealPath("ProductTypeInfoImg")
		+ "/"+docFilename;
		boolean result=false;
		try {
		 result=this.create(filename, this.textshowStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

	// 将文本串转换成XML文档并存盘
	public boolean create(String filename, String text) throws Exception {
		// 使用DocumentHelper类将文本串转换为XML文档
		Document document = DocumentHelper.parseText(text.trim());

		// 将创建的XML文档存盘
		try {
			XMLWriter output = null;
			// 创建一个格式化对象
			OutputFormat format = OutputFormat.createPrettyPrint();
			// 使用TAB缩进
			format.setIndent("\t");
			// 创建一个XMLWriter对象
			System.out.println(filename);
			output = new XMLWriter(new FileOutputStream(new File(filename)),
					format);
			// 将XML文档输出
			output.write(document);
			output.close();
			return true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Object getAllProductTypeInfoObj() {
		return allProductTypeInfoObj;
	}

	public void setAllProductTypeInfoObj(Object allProductTypeInfoObj) {
		this.allProductTypeInfoObj = allProductTypeInfoObj;
	}

	public String getAllProductTypeInfoStr() {
		return allProductTypeInfoStr;
	}

	public void setAllProductTypeInfoStr(String allProductTypeInfoStr) {
		this.allProductTypeInfoStr = allProductTypeInfoStr;
	}

	public String getProductTypeInfoStr() {
		return productTypeInfoStr;
	}

	public void setProductTypeInfoStr(String productTypeInfoStr) {
		this.productTypeInfoStr = productTypeInfoStr;
	}

	public String getEditModelStr() {
		return editModelStr;
	}

	public void setEditModelStr(String editModelStr) {
		this.editModelStr = editModelStr;
	}

	public String getOidListStr() {
		return oidListStr;
	}

	public void setOidListStr(String oidListStr) {
		this.oidListStr = oidListStr;
	}

	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	private File upload;
	private String uploadContentType;
	private String uploadFileName; // fileName 前面必須和uplaod一致,不然找不到文件

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	// 上传文件的文件名

	private static final int BUFFER_SIZE = 16 * 1024;

	public String upLoadProductTypeInfoImg() throws Exception {

		System.out.println("我已经调用了");
		// Boolean test = false;
		// if (test) {
		if (!StringUtils.isEmpty(productTypeInfoStr)
				&& !StringUtils.isEmpty(editModelStr)) {
			System.out.println("uploadFileName = " + this.uploadFileName);
			System.out.println("productTypeInfoStr = "
					+ this.productTypeInfoStr);
			System.out.println("editmodel = " + this.editModelStr);
			// ProductTypeInfo productTypeInfo = gsonTemp.fromJson(
			// this.productTypeInfoStr, new TypeToken<ProductTypeInfo>() {
			// }.getType());
			// 保存文件
			String productTypeInfoImgUrl = null;
			if (this.upload != null) {
				String productTypeInfoImgPath = ServletActionContext
						.getServletContext().getRealPath("ProductTypeInfoImg")
						+ "/" + this.uploadFileName;
				productTypeInfoImgUrl = "ProductTypeInfoImg" + "/"
						+ this.uploadFileName;
				File toFile = new File(productTypeInfoImgPath);
				writeFile(this.upload, toFile);
				// productTypeInfo.setProductTypeImage(productTypeInfoImgUrl);
			}
			// 保存到数据库

			// if (this.editModelStr.equals("create")) {
			// productTypeInfo.setOid(null);
			// if (productTypeInfo.getParentOid() == 0L) {
			// productTypeInfo.setParentOid(1L);
			// }
			// productTypeInfoService.createProductTypeInfo(productTypeInfo);
			// } else {
			// productTypeInfoService.updateProductTypeInfo(productTypeInfo);
			// }

			// 返回

			ServletActionContext.getResponse().setContentType(
					"text/html; charset=utf-8");
			ServletActionContext
					.getResponse()
					.getWriter()
					.print("{success:true,path:'" + productTypeInfoImgUrl
							+ "'}");
			return NONE;
		} else {
			ServletActionContext.getResponse().setContentType(
					"text/html; charset=utf-8");
			ServletActionContext.getResponse().getWriter()
					.print("{success:true,message:\"error\"}");

			return NONE;
		}

	}

	private static void writeFile(File src, File dst) {

		System.out.println(" == 文件寫入 == ");
		try {
			InputStream in = null;
			OutputStream out = null;
			try {

				in = new BufferedInputStream(new FileInputStream(src),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("写入成功！");
	}

	private String filePath;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String download() {
		String path = filePath;
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			// path是指欲下载的文件的路径。
			File file = new File(path);
			// 取得文件名。
			String filename = file.getName();
			// 取得文件的后缀名。
			String ext = filename.substring(filename.lastIndexOf(".") + 1)
					.toUpperCase();

			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
			// 设置response的Header
			String filenameString = new String(filename.getBytes("gbk"),
					"iso-8859-1");
			response.addHeader("Content-Disposition", "attachment;filename="
					+ filenameString);
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(
					response.getOutputStream());
			response.setContentType("application/octet-stream");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
