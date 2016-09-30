package kr.co.c;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BuserInter {
	String showData(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
