package com.company.controller;

import com.company.domain.PersonDomain;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


public class DemoTest {
    private Logger logger = Logger.getLogger(DemoTest.class.toString());
    private SqlSessionFactory sqlsessionFactory;

    @Before
    public void init() {
        try {
            String resource = "mybaits-config.xml";
            InputStream is = Resources.getResourceAsStream(resource);
            sqlsessionFactory = new SqlSessionFactoryBuilder().build(is);
            is.close();
            logger.info("主配置文件读取成功: mybaits-config.xml");
        } catch (IOException e) {
            logger.info("初始化配置文件报错：mybaits-config.xml");
            e.printStackTrace();
        }
    }

    @Test
    public void selectByPK() {
        SqlSession sqlSession = sqlsessionFactory.openSession();

        PersonDomain personDomain = new PersonDomain();
        personDomain.setPersonNo(1);

        List<PersonDomain> selectOne = sqlSession.selectList("selectByPersonNo", personDomain);
        logger.info("查询一条记录：开始");
        System.out.println(selectOne);
        logger.info("查询一条记录：结束");

        sqlSession.close();
    }

    @Test
    public void select() {
        SqlSession sqlSession = sqlsessionFactory.openSession();

        List<PersonDomain> selectAll = sqlSession.selectList("select");
        logger.info("查询所有记录：开始");
        for (PersonDomain p : selectAll
        ) {
            System.out.println(p);
        }
        logger.info("查询所有记录：结束");

        sqlSession.close();
    }

    @Test
    public void insert(){
        SqlSession sqlSession = sqlsessionFactory.openSession();

        PersonDomain personDomain = new PersonDomain();
        personDomain.setPersonNo(2);
        personDomain.setName("小悠悠");
        personDomain.setSex("女");
        personDomain.setBirthday(new Date());

        int insertPersonByPersonNo = sqlSession.insert("insert", personDomain);

        System.out.println("插入了 " + insertPersonByPersonNo + " 条记录");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void update(){
        SqlSession sqlSession = sqlsessionFactory.openSession();

        PersonDomain personDomain = new PersonDomain();
        personDomain.setPersonNo(1);
        personDomain.setName("小游子");
        personDomain.setSex("女");

        int updatePersonByPersonNo = sqlSession.update("update", personDomain);
        System.out.println("更新了 " + updatePersonByPersonNo + " 条记录");

        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void delete(){
        SqlSession sqlSession = sqlsessionFactory.openSession();

        PersonDomain personDomain = new PersonDomain();
        personDomain.setPersonNo(2);

        int deletePersonByPersonNo = sqlSession.delete("delete", personDomain);

        System.out.println("删除了 " + deletePersonByPersonNo + " 条记录");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void procedure(){
        SqlSession sqlSession = sqlsessionFactory.openSession();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("v_name", "SMITH");

        sqlSession.selectOne("getSalSumByEname", map);

        System.out.println(map.get("v_sal"));
        sqlSession.close();
    }
}
