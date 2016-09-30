package kr.co.c;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SawonInter {
	String showData(HttpServletRequest request, HttpServletResponse response , String buser) throws Exception;
}
