package com.ym.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ym.entity.UFunction;
import com.ym.entity.UUserfunrelation;
import com.ym.entity.UUserinfo;
import com.ym.serviceImp.UserinfoServiceImp;
import com.ym.util.PrintWriterUtil;
import com.ym.util.SortFunUtil;

@Controller
@SessionAttributes({"userinfo","u_list","m_list","p_list","t_list"})
public class UserinfoController {

	@Autowired
	public UserinfoServiceImp userinfoServiceImp;
	
	//用户登录
	@RequestMapping("/UserLogin")
	public void UserLogin(HttpServletRequest request, HttpServletResponse response, ModelMap mp){
		if (request.getProtocol().compareTo("HTTP/1.0") == 0){    
		    response.setHeader("Pragma","no-cache");    
		}else if (request.getProtocol().compareTo("HTTP/1.1") == 0){    
		    response.setHeader("Cache-Control","no-cache");    
		}
		String userName = request.getParameter("UserName");
		String passWord = request.getParameter("PassWord");
		//String vCode = request.getParameter("vCode");
		//String validatecode = (String) request.getSession().getAttribute("key");
		//System.out.println(request.getSession().getAttribute("key"));
		//System.out.println("username:"+userName+"-password:"+passWord+"-vCode:"+vCode);
		//System.out.println(vCode.equals(validatecode));
		UUserinfo u = userinfoServiceImp.UserLogin(userName, passWord);
		Map<String, Object> map = new HashMap<String, Object>();
		//if(vCode.equals(validatecode)) {
			if(u == null){
				map.put("ErrorCode", 1);//用户名称或密码输入错误
			}else{
				if(u.getIsEnable() == 1){
					map.put("ErrorCode", 2);//用户被禁用
				}else if(u.getIsDelete() == 1){
					map.put("ErrorCode", 3);//用户被删除
				}else{
					map.put("ErrorCode", 0);//登陆成功
					mp.addAttribute("userinfo", u);
					List<UFunction> funlist = userinfoServiceImp.SelectFunByUserId(u.getId());//获取用户权限
					if(funlist.size() == 0){
						map.put("ErrorCode", 4);//此用户无权限
					}else{
						List<UFunction> u_list = new ArrayList<>();//用户管理
						List<UFunction> m_list = new ArrayList<>();//设备管理
						List<UFunction> p_list = new ArrayList<>();//模块管理
						List<UFunction> t_list = new ArrayList<>();//检测管理
						for(UFunction uf : funlist){
							if(uf.getFatherId() == 0){
								u_list.add(uf);
							}
							if(uf.getFatherId() == 1){
								m_list.add(uf);
							}
							if(uf.getFatherId() == 2){
								p_list.add(uf);
							}
							if(uf.getFatherId() == 3){
								t_list.add(uf);
							}
						}
						SortFunUtil.SortFun(u_list);
						SortFunUtil.SortFun(m_list);
						SortFunUtil.SortFun(p_list);
						SortFunUtil.SortFun(t_list);
						mp.addAttribute("u_list", u_list);
						mp.addAttribute("m_list", m_list);
						mp.addAttribute("p_list", p_list);
						mp.addAttribute("t_list", t_list);
					}
				}
			}
		/*}else {
			map.put("ErrorCode", 500);//验证码不正确
		}*/
		PrintWriterUtil.Out(response, map);
	}
	
	//根据userId查询用户权限
	@RequestMapping("/SelectFunByUserId")
	public void SelectFunByUserId(HttpServletRequest request, HttpServletResponse response, ModelMap mp){
		int userid = Integer.valueOf(request.getParameter("userid"));
		//System.out.println("funUserId:"+userid);
		Map<String, Object> map = new HashMap<>();
		List<UFunction> funlist = userinfoServiceImp.SelectFunByUserId(userid);
		map.put("ErrorCode", 0);
		map.put("funlist", funlist);
		PrintWriterUtil.Out(response, map);
	}
	
	//添加权限
	@RequestMapping("/AddUserFun")
	public void AddUserFun(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("userName");
		String chk = request.getParameter("chk");
		String d[]=chk.split(",");
		
//		System.out.println("username:"+username);
//		for(int i = 0; i < d.length; i++){
//			System.out.println("权限id:"+d[i]);
//		}
			
		UUserinfo u = userinfoServiceImp.SelectByUserName(username);
//		System.out.println("name:"+u.getUserName());
		Map<String, Object> map = new HashMap<>();
		if(u != null){
			List<UUserfunrelation> uflist = userinfoServiceImp.SelectUserFun(u.getId());
			for(UUserfunrelation uf : uflist){
				userinfoServiceImp.DeleteUserFun(uf.getId());
			}
			for(int i = 0; i < d.length; i++){
				if(!d[i].equals("")){
					UUserfunrelation userfun = new UUserfunrelation();
					userfun.setUserId(u.getId());
					userfun.setFunId(Integer.valueOf(d[i]));
					userinfoServiceImp.AddUserFun(userfun);
				}
			}
			map.put("ErrorCode", 0);//添加权限成功
		}else{
			map.put("ErrorCode", 1);//添加权限失败
		}
		PrintWriterUtil.Out(response, map);
	}
	
	//根据Id的查询用户
	@RequestMapping("/SelectByUserId")
	public UUserinfo SelectByUserId(int userId){
		UUserinfo u = userinfoServiceImp.SelectByUserId(userId);
		return u;
	}
	
	//分页查询
	@RequestMapping("/SelectByPage")
	public void SelectByPage(HttpServletRequest request, HttpServletResponse response){
		int pageIndex = Integer.valueOf(request.getParameter("page")); //(page - 1)*rows;
		int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
		int total = userinfoServiceImp.SelectAll().size();
		List<UUserinfo> listbypage = userinfoServiceImp.SelectByPage(pageIndex, pageSize);
		Map<String, Object> map = new HashMap<>();
		map.put("total", total);
		map.put("rows", listbypage);
		PrintWriterUtil.Out(response, map);
	}
		
	//条件查询
	@RequestMapping("/SelectByPageParm")
	public void SelectByPageParm(HttpServletRequest request, HttpServletResponse response, UUserinfo u){
		int pageIndex = Integer.valueOf(request.getParameter("page")); //(page - 1)*rows;
		int pageSize = Integer.valueOf(request.getParameter("rows")); //rows;
		//System.out.println("username-page-rows:"+username+"-"+pageIndex+"-"+pageSize);
		int total =  userinfoServiceImp.SelectByParm(u).size();
		List<UUserinfo> listbypageparm = userinfoServiceImp.SelectByPageParm(pageIndex, pageSize, u);
		Map<String, Object> map = new HashMap<>();
		map.put("total", total);
		map.put("rows", listbypageparm);
		PrintWriterUtil.Out(response, map);
	}
		
	//添加
	@RequestMapping("/Add")
	public void Add(HttpServletResponse response, UUserinfo u){
		//System.out.println("username:"+u.getUserName()+"-"+u.getPassWord()+"-"+u.getRealName()+"-"+u.getAreaName()+"-"+u.getPhone()+"-"+u.getEmail());
		UUserinfo uu = userinfoServiceImp.SelectByUserName(u.getUserName());
		Map<String, Object> map = new HashMap<>();
		if(uu == null){
			u.setIsEnable(0);
			u.setIsDelete(0);
			userinfoServiceImp.Add(u);
			map.put("ErrorCode", 0);//添加成功
		}else{
			map.put("ErrorCode", 1);//用户昵称已存在,添加失败
		}
		PrintWriterUtil.Out(response, map);
	}
		
	//更新
	@RequestMapping("/Update")
	public void Update(HttpServletRequest request, HttpServletResponse response, UUserinfo u){
		int userid = Integer.valueOf(request.getParameter("id"));
		UUserinfo uu = this.SelectByUserId(userid);
		//System.out.println("uid:"+userid+"-uuid:"+uu.getId());
		Map<String, Object> map = new HashMap<>();
		if(uu == null){
			map.put("ErrorCode", 2);//更新用户不存在,更新失败
		}else{
			uu.setId(userid);
			//uu.setUserName(u.getUserName());
			uu.setPassWord(u.getPassWord());
			uu.setRealName(u.getRealName());
			uu.setAreaName(u.getAreaName());
			uu.setPhone(u.getPhone());
			uu.setEmail(u.getEmail());
			userinfoServiceImp.Update(uu);
			map.put("ErrorCode", 3);//更新成功
		}
		PrintWriterUtil.Out(response, map);
	}
		
	//删除
	@RequestMapping("/Deletee")
	public void Deletee(HttpServletRequest request, HttpServletResponse response){
		int userid = Integer.valueOf(request.getParameter("id"));
		//System.out.println("userid:"+userid);
		UUserinfo u = new UUserinfo();
		u.setId(userid);
		userinfoServiceImp.Deletee(u);
		Map<String, Object> map = new HashMap<>();
		map.put("ErrorCode", 0);//删除成功
		PrintWriterUtil.Out(response, map);
	}
	
	//禁用
	@RequestMapping("/Disable")
	public void Disable(HttpServletRequest request, HttpServletResponse response){
		int userid = Integer.valueOf(request.getParameter("id"));
		UUserinfo uu = this.SelectByUserId(userid);
		Map<String, Object> map = new HashMap<>();
		if(uu == null){
			map.put("ErrorCode", 1);//更新用户不存在,禁用失败
		}else{
			uu.setId(userid);
			uu.setIsEnable(1);
			userinfoServiceImp.Update(uu);
			map.put("ErrorCode", 0);//禁用成功
		}
		PrintWriterUtil.Out(response, map);
	}
	
	//禁用
	@RequestMapping("/LiftBan")
	public void LiftBan(HttpServletRequest request, HttpServletResponse response){
		int userid = Integer.valueOf(request.getParameter("id"));
		UUserinfo uu = this.SelectByUserId(userid);
		Map<String, Object> map = new HashMap<>();
		if(uu == null){
			map.put("ErrorCode", 1);//解禁用户不存在,禁用失败
		}else{
			uu.setId(userid);
			uu.setIsEnable(0);
			userinfoServiceImp.Update(uu);
			map.put("ErrorCode", 0);//解禁成功
		}
		PrintWriterUtil.Out(response, map);
	}
}
