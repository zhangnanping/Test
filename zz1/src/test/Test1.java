package test;

import java.io.InputStream;
import java.sql.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import dao.Jiekou;
import dao.UserDao;
import entity.Kh;

public class Test1 {
	Logger logger=Logger.getLogger("Test1");
	Jiekou j=new UserDao();
//	@Test
//	public void test() {
//		String resource="mybatis-config.xml";
//		SqlSession sqlsession=null;
//		try {
//			InputStream is=Resources.getResourceAsStream(resource);
//			SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
//			int count=0;
//			sqlsession=factory.openSession();
//			count=sqlsession.selectOne("dao.UserDao.count");
//			//logger.debug("count--->"+count);
//			System.out.println(count);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			sqlsession.close();
//		}
//	}
	@Test
	public void test1(){
		try {
			List<Kh> list=j.select();
			for (Kh kh : list) {
				System.out.println(kh.getType()+"\t"+kh.getMoney()+"\t"+kh.getDay());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	@Test
	public void test2(){
		java.util.Date ate=new java.util.Date();
		System.out.println(ate);
		Date date=new Date(ate.getTime());
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String str_date1 = formatter.format(date); //将日期时间格式化 
	}
	

}
