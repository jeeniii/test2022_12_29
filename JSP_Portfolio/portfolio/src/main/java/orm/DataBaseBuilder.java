package orm;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataBaseBuilder {
	private static SqlSessionFactory factory;
	
	static {
		try {
			factory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("orm/MybatisConfig.xml"));
		} catch (Exception e) {
			System.out.println("mybatis error");
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getFactory() {
		return factory;
	}

}
