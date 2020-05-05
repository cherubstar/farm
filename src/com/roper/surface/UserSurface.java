package com.roper.surface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;

import com.roper.api.UserService;
import com.roper.entity.DataTableReturnObject;
import com.roper.entity.Regist;
import com.roper.entity.Role;
import com.roper.entity.User;
import com.roper.utils.CRUDDataUtil;
import com.roper.utils.HibernateUtil;
import com.roper.utils.UnicodeUtil;

@Service("userService")
public class UserSurface<T> implements UserService<T> {

	private Class<T> classType;
	private String userName;
	
	public UserSurface(){};
	
	public UserSurface(Class<T> classType) {
		super();
		this.classType = classType;
	}
	
	public UserSurface(Class<T> classType, String userName) {
		super();
		this.classType = classType;
		this.userName = userName;
	}
	
	@Override
	public T queryByUserName() {
		
		userName = UnicodeUtil.toUnicode(userName);
		T t = new CRUDDataUtil<T>(classType,userName).queryByUserName();
		return t;
	}
	
	@Override
	public T queryByUserName(String userName) {
		
		userName = UnicodeUtil.toUnicode(userName);
		T t = new CRUDDataUtil<T>(classType,userName).queryByUserName();
		return t;
	}

	/**
	 * 查找权限等及，返回权限等级
	 */
	@Override
	public Role findRoles(String permission) {

		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(Role.class);
		Criterion criterion = Restrictions.eq("id", Integer.valueOf(permission));
		criteria.add(criterion);
		List<Role> list = criteria.list();
		Role role = new Role();
		for (Role r : list) {
			if(r != null){
				role = r;
			}
		}
		HibernateUtil.closeResource(session);
		return role;
	}

	@Override
	public DataTableReturnObject findAllUser() {

		String todayInfo = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = (SQLQuery) session.createSQLQuery(
				"select * from t_user").setResultTransformer(
				Transformers.ALIAS_TO_ENTITY_MAP);

		query.addScalar("ID", org.hibernate.Hibernate.STRING);
		query.addScalar("USERNAME", org.hibernate.Hibernate.STRING);
		query.addScalar("PASSWORD", org.hibernate.Hibernate.STRING);
		query.addScalar("NAME", org.hibernate.Hibernate.STRING);
		query.addScalar("PERMISSION", org.hibernate.Hibernate.STRING);
		query.addScalar("DEPARTMENT", org.hibernate.Hibernate.STRING);

		List list = query.list();
		session.close();

		Map map = null;
		JSONObject jsonObject = null;
		List jsonList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			map = (Map) list.get(i);
			if ((String) map.get("USERNAME") != null) {
				map.put("USERNAME", UnicodeUtil.decodeUnicode((String) map
						.get("USERNAME")));
			}
			;
			if ((String) map.get("PASSWORD") != null) {
				map.put("PASSWORD", UnicodeUtil.decodeUnicode((String) map
						.get("PASSWORD")));
			}
			if ((String) map.get("NAME") != null) {
				map.put("NAME", UnicodeUtil.decodeUnicode((String) map
						.get("NAME")));
			}
			if ((String) map.get("PERMISSION") != null) {
				map.put("PERMISSION", UnicodeUtil.decodeUnicode((String) map
						.get("PERMISSION")));
			}
			if ((String) map.get("DEPARTMENT") != null) {
				map.put("DEPARTMENT", UnicodeUtil.decodeUnicode((String) map
						.get("DEPARTMENT")));

			}
			jsonObject = JSONObject.fromObject(map);
			jsonList.add(jsonObject);
		}

		JSONArray json = JSONArray.fromObject(jsonList);
		System.out.println(json.toString());
		todayInfo = json.toString();

		DataTableReturnObject obj = new DataTableReturnObject();
		obj.setDraw(1);
		obj.setRecordsFiltered(list.size());
		obj.setRecordsTota(list.size());
		obj.setData(todayInfo);
		return obj;
	}
	
	@Override
	public DataTableReturnObject findAllRegiser() {
		String todayInfo = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = (SQLQuery) session.createSQLQuery(
				"select * from t_regist").setResultTransformer(
				Transformers.ALIAS_TO_ENTITY_MAP);

		query.addScalar("NAME", org.hibernate.Hibernate.STRING);
		query.addScalar("DEPARTMENT", org.hibernate.Hibernate.STRING);
		query.addScalar("PERMISSION", org.hibernate.Hibernate.STRING);
		query.addScalar("USERNAME", org.hibernate.Hibernate.STRING);
		query.addScalar("PASSWORD", org.hibernate.Hibernate.STRING);

		List list = query.list();
		HibernateUtil.closeResource(session);

		Map map = null;
		Map cnMap = new HashMap();
		JSONObject jsonObject = null;
		List jsonList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {

			map = (Map) list.get(i);

			System.out
					.println("--------------------------------------------------------------");
			System.out.println("未改之前 :　" + map);
			System.out
					.println("--------------------------------------------------------------");
			String NAME = UnicodeUtil.decodeUnicode(String.valueOf(map
					.get("NAME")));
			String DEPARTMENT = UnicodeUtil.decodeUnicode(String.valueOf(map
					.get("DEPARTMENT")));
			String PERMISSION = UnicodeUtil.decodeUnicode(String.valueOf(map
					.get("PERMISSION")));
			String USERNAME = UnicodeUtil.decodeUnicode(String.valueOf(map
					.get("USERNAME")));
			String PASSWORD = UnicodeUtil.decodeUnicode(String.valueOf(map
					.get("PASSWORD")));

			cnMap.put("NAME", NAME);
			cnMap.put("DEPARTMENT", DEPARTMENT);
			cnMap.put("PERMISSION", PERMISSION);
			cnMap.put("USERNAME", USERNAME);
			cnMap.put("PASSWORD", PASSWORD);

			jsonObject = JSONObject.fromObject(cnMap);
			jsonList.add(jsonObject);

		}

		JSONArray json = JSONArray.fromObject(jsonList);
		System.out.println(json.toString());
		todayInfo = json.toString();

		DataTableReturnObject obj = new DataTableReturnObject();
		obj.setDraw(1);
		obj.setRecordsFiltered(list.size());
		obj.setRecordsTota(list.size());
		obj.setData(todayInfo);
		return obj;
	}

	@Override
	public void regist(String userName, String password, String permission,
			String department, String name) {

		/*if(permission == null || permission == "0"){
			permission = "user";
		}*/
		permission = "user";
		Regist regist = new Regist();
		regist.setUsername(UnicodeUtil.toUnicode(userName));
		regist.setPassword(UnicodeUtil.toUnicode(password));
		
		//获取用户权限
//		Role role = findRoles(permission);
//		System.out.println(role.getRoleName());
//		regist.setPermission(UnicodeUtil.toUnicode(role.getRoleName()));
		
		regist.setPermission(UnicodeUtil.toUnicode(permission));
		regist.setDepartment(UnicodeUtil.toUnicode(department));
		regist.setName(UnicodeUtil.toUnicode(name));
		
		CRUDDataUtil.save(regist);
	}
	
	@Override
	public void addUser(String userName) {
		
		//通过用户名查询个人信息
		userName = UnicodeUtil.toUnicode(userName);
		Regist regist = new CRUDDataUtil<Regist>(Regist.class, userName).queryByUserName();
		
		//实例化一个新用户
		User user = new User();
		user.setId((int) (1 + Math.random() * (10000 - 1 + 1)));
		user.setUsername(regist.getUsername());
		user.setPassword(regist.getPassword());
		user.setPermission(regist.getPermission());
		user.setDepartment(regist.getDepartment());
		user.setName(regist.getName());

		CRUDDataUtil.save(user);
		CRUDDataUtil.delete(regist);
	}
	
	/**
	 * 拒绝添加注册用户
	 */
	@Override
	public void refuse(String userName) {
		System.out.println("删除的用户: " +userName);
		userName = UnicodeUtil.toUnicode(userName);
		System.out.println("转换成unicode的用户: " +userName);
		new CRUDDataUtil<Regist>(Regist.class).deleteByUserName(userName);
	}

	/**
	 * 删除已存在的用户
	 */
	@Override
	public void delete(Integer id) {
		new CRUDDataUtil<User>(User.class).deleteByUserId(id);
	}
}
