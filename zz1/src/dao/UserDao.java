package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import entity.Kh;
import entity.Role;
import entity.User;
import util.MyBatisUtil;

public class UserDao implements Jiekou{
	/**
	 * 验证账号密码是否正确
	 */
	public User verifyUser(User user){
		System.out.println("----------------验证账户---------");
		SqlSession session = null;
		try{
			session = MyBatisUtil.createSqlSession();
			//第二种写法
			return  session.getMapper(Jiekou.class).verifyUser(user);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(session);
		}
		return null;
	}

	@Override
	public List<User> selectAll(int qishi) {
		// TODO Auto-generated method stub
		System.out.println("----------------查询所有账户---------");
		SqlSession session = null;
		try{
			session = MyBatisUtil.createSqlSession();
			//第二种写法
			return  session.getMapper(Jiekou.class).selectAll(qishi);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(session);
		}
		return null;
	}

	@Override
	public List<Kh> select() {
		// TODO Auto-generated method stub
		System.out.println("----------------课后---------");
		SqlSession session = null;
		try{
			session = MyBatisUtil.createSqlSession();
			//第二种写法
			return  session.getMapper(Jiekou.class).select();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(session);
		}
		return null;
	}

	@Override
	public List<Role> chaxun() {
		// TODO Auto-generated method stub
		System.out.println("----------------课后---------");
		SqlSession session = null;
		try{
			session = MyBatisUtil.createSqlSession();
			//第二种写法
			return  session.getMapper(Jiekou.class).chaxun();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(session);
		}
		return null;
	}

	@Override
	public User chaxunUser(String string) {
		// TODO Auto-generated method stub
		System.out.println("----------------课后---------");
		SqlSession session = null;
		try{
			session = MyBatisUtil.createSqlSession();
			//第二种写法
			return  session.getMapper(Jiekou.class).chaxunUser(string);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(session);
		}
		return null;
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		int i=0;
		SqlSession session = null;
		try{
			session = MyBatisUtil.createSqlSession();
			//第二种写法
			 i=session.getMapper(Jiekou.class).addUser(user);
			 session.commit();
		}catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			MyBatisUtil.closeSqlSession(session);
		}
		return i;
	}

	@Override
	public User chaxunById(int id) {
		// TODO Auto-generated method stub
		System.out.println("----------------查询账户BYid---------");
		SqlSession session = null;
		try{
			session = MyBatisUtil.createSqlSession();
			//第二种写法
			return  session.getMapper(Jiekou.class).chaxunById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(session);
		}
		return null;
	}

	@Override
	public int xiugai(User user) {
		// TODO Auto-generated method stub
		int i=0;
		SqlSession session = null;
		try{
			session = MyBatisUtil.createSqlSession();
			//第二种写法
			 i=session.getMapper(Jiekou.class).xiugai(user);
			 session.commit();
		}catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			MyBatisUtil.closeSqlSession(session);
		}
		return i;
	}
	public List<User> moHu(Map<String, Object> map){
		System.out.println("----------------模糊查询---------");
		SqlSession session = null;
		try{
			session = MyBatisUtil.createSqlSession();
			//第二种写法
			return  session.getMapper(Jiekou.class).moHu(map);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(session);
		}
		return null;
	}

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		System.out.println("----------------验证账户---------");
		SqlSession session = null;
		try{
			session = MyBatisUtil.createSqlSession();
			//第二种写法
			return  session.getMapper(Jiekou.class).findCount();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(session);
		}
		return 0;
	}

	@Override
	public int moHu1(Map<String, Object> map) {
		// TODO Auto-generated method stub
		System.out.println("----------------模糊计数---------");
		SqlSession session = null;
		try{
			session = MyBatisUtil.createSqlSession();
			//第二种写法
			return  session.getMapper(Jiekou.class).moHu1(map);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(session);
		}
		return 0;
	}

	@Override
	public int shanChu(Integer[] ids) {
		// TODO Auto-generated method stub
		System.out.println("----------------批量删除---------");
		SqlSession session = null;
		int i=0;
		try{
			session = MyBatisUtil.createSqlSession();
			//第二种写法
			i=session.getMapper(Jiekou.class).shanChu(ids);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(session);
		}
		return i;
	}

}
