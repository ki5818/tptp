package com.tptp.util;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServletResponse;

public class Alert {
	   public static void alertMiss(HttpServletResponse response) throws IOException {
		      response.setContentType("text/html; charset=UTF-8");
		      PrintWriter out = response.getWriter();

		      out.println("<script language='javascript'>");
		      out.println("alert('비밀번호가 틀렸습니다.')");
		      out.println("</script>");

		      out.flush();
		   }
}
