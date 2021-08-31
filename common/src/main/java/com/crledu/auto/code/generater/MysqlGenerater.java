package com.crledu.auto.code.generater;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;

import java.util.Scanner;

/**
 * @Author: Trevor
 * @Date: 2020/6/28 15:46
 * @Description:
 */
public class MysqlGenerater {

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        //代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //全局配置
        GlobalConfig gc=new GlobalConfig();

        gc.setOutputDir("E:\\rpc\\crledu-web-base\\src\\main\\java");
        gc.setFileOverride(true);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setIdType(IdType.AUTO);
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);
        //配置datasourceconfig
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl("jdbc:mysql://47.92.125.1:13306/crledu_web_base?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=true&useTimezone=true&serverTimezone=GMT%2B8");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("djservice");
        dataSourceConfig.setPassword("Fxsw@2018");
        mpg.setDataSource(dataSourceConfig);

        //策略配置
        StrategyConfig sc = new StrategyConfig();


        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.crledu");
        pc.setEntity("entity");
        pc.setController("api");
        pc.setService("service");
        pc.setServiceImpl("serviceImpl");
        pc.setMapper("mapper");
        pc.setXml("mapper");
        mpg.setPackageInfo(pc);
        mpg.execute();
    }
}
