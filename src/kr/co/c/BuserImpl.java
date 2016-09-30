package kr.co.c;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.m.BuserDto;
import kr.co.m.BuserModel;

public class BuserImpl implements BuserInter{
	public static BuserImpl impl = new BuserImpl();
	
	public static BuserImpl Instance(){
		return impl;
	}
	
	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BuserModel model = BuserModel.Instance();
		ArrayList<BuserDto> list = model.getdataAll();
		request.setAttribute("data", list);
		return "buser";
	}
}
