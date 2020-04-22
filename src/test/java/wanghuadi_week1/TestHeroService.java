package wanghuadi_week1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wanghuadi.beans.Hero;
import com.wanghuadi.service.HeroServiceImpl;

public class TestHeroService {
	
	@Test
	public void testList(){
		//1.创建容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		HeroServiceImpl bean = ac.getBean("heroServiceImpl",HeroServiceImpl.class);
		Map<String, Object> map = new HashMap<>();
		map.put("cid", 1);
		map.put("isHave", 0);
		map.put("startPrice", 500);
		map.put("endPrice", 6000);
		List<Hero> list = bean.queryAll(map );
		for (Hero hero : list) {
			System.out.println(hero);
		}
		
	}
	
}
