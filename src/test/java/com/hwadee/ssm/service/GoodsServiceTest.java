package com.hwadee.ssm.service;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertTrue;

/* SpringJuint4ClassRunner是Spring-test提供的Spring测试用的整合类
 * Junit在测试初始化时自动加载applicationContext.xml初始化IOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class GoodsServiceTest {

	@BeforeClass
	public static void init(){
		System.out.println("正在导入Goods表数据");
	}

	@Before
	public void doBefore(){
		System.out.println("获取数据库Connection对象");
	}
	@After
	public void doAfter(){
		System.out.println("释放数据库Connection对象");
	}
    @Resource
    GoodsService goodsService = null;

   // @Test
    //@Transactional加上后，默认在测试用例执行成功后，为了测试数据不污染原始数据会自动回滚
    //@Rollback(false)用于关闭自动回滚
   // @Transactional
  // public void initGoods() throws Exception {
   //     goodsService.initGoods();
  //  }

    /**
     * 测试结果
     * 1. 绿色 √，表示测试通过
     * 2. 红色 ×，表示测试失败
     * 3. 橙色 ×，表示断言失败
     */
 //   @Test
  //  public void findById() {
   //     Goods goods = goodsService.findById(10000);
        //断言：org.junit.assertTrue("条件不成立时抛出的信息", 条件);
  //      assertTrue("未找到ID为10000的Goods对象", goods!=null);
   // }//
}