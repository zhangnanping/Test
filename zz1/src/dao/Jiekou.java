package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import entity.Kh;
import entity.Role;
import entity.User;

public interface Jiekou {
	/**
	 * 登陆验证
	 * @param user
	 * @return
	 */
	public User verifyUser(User user);
	
	/**
	 * 查询所有用户
	 */
	public List<User> selectAll(int qishi);
	
	/**
	 * 课后
	 */
	public List<Kh> select();
	
	/**
	 * 下拉列表查询角色名
	 * @return
	 */
	public List<Role> chaxun();
	
	/**
	 * 查询用户编码是否存在
	 */
	public User chaxunUser(String string);
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	
	/**
	 * 通过id查询用户
	 */
	public User chaxunById(int id);
	/**
	 * 修改用户
	 * 
	 */
	public int xiugai(User user);
	
	/**
	 * 模糊查询
	 */
	public List<User> moHu(Map<String, Object> map);
	/**
	 * 查询用户总数
	 */
	public int findCount();
	public int moHu1(Map<String, Object> map);
	public int shanChu(Integer[] ids);
}
