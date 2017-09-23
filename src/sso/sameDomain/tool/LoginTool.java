package sso.sameDomain.tool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginTool {
	
	public static Boolean checkLogin(HttpServletResponse resp, HttpServletRequest req){
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String token = "";
		if(req.getCookies()!=null){
			for (Cookie c : req.getCookies()) {
				if(c.getName().equals("token")){
					token = c.getValue();
					break;
				}
			}
		}
		return token.equals("token")||(name!=null&&pwd!=null&&name.equals("tom")&&pwd.equals("tom"));
	}
	
	public static void addCookie(HttpServletResponse resp,HttpServletRequest req){
		
		Cookie cookie = new Cookie("token", "token");
//		cookie.setDomain(".t.com");//¸¸×ÓÓò¹²Ïícookie
		cookie.setPath("/");
		resp.addCookie(cookie);
	}
}
