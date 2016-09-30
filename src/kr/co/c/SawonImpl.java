package kr.co.c;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.m.BuserDto;
import kr.co.m.BuserModel;
import kr.co.m.SawonModel;


public class SawonImpl implements SawonInter{
public static SawonImpl impl = new SawonImpl();
	
	public static SawonImpl Instance(){
		return impl;
	}
	
	@Override
		public String showData(HttpServletRequest request, HttpServletResponse response, String buser) throws Exception {
		SawonModel model = SawonModel.Instance();
		ArrayList<kr.co.m.SawonDto> list = model.getdataAll(buser);
		request.setAttribute("data", list);
		return "sawon";
		}
}
