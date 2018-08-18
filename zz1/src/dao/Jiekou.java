package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import entity.Kh;
import entity.Role;
import entity.User;

public interface Jiekou {
	/**
	 * ��½��֤
	 * @param user
	 * @return
	 */
	public User verifyUser(User user);
	
	/**
	 * ��ѯ�����û�
	 */
	public List<User> selectAll(int qishi);
	
	/**
	 * �κ�
	 */
	public List<Kh> select();
	
	/**
	 * �����б��ѯ��ɫ��
	 * @return
	 */
	public List<Role> chaxun();
	
	/**
	 * ��ѯ�û������Ƿ����
	 */
	public User chaxunUser(String string);
	
	/**
	 * ����û�
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	
	/**
	 * ͨ��id��ѯ�û�
	 */
	public User chaxunById(int id);
	/**
	 * �޸��û�
	 * 
	 */
	public int xiugai(User user);
	
	/**
	 * ģ����ѯ
	 */
	public List<User> moHu(Map<String, Object> map);
	/**
	 * ��ѯ�û�����
	 */
	public int findCount();
	public int moHu1(Map<String, Object> map);
	public int shanChu(Integer[] ids);
}
