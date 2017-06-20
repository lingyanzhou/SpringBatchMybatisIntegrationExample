# SpringBatchMybatisIntegrationExample
Illustrate some simple configuration to setup a Spring/SringBatch with Mybatis Integration.

The juice is here: ('src/main/resources/spring/batch/config/context.xml')[src/main/resources/spring/batch/config/context.xml],
and ('src/main/resources/spring/batch/jobs/job.xml')[src/main/resources/spring/batch/jobs/job.xml]

* In spring batch context files, define a mapper configurer. The mapper configurer can then scan through the specified package for mappers.
```xml
<!--Scan mappers automatically (method 1): -->
  <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
    <property name="basePackage" value="net.lingyanzhou.mybatis_spring_learning.mapper" />
    <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory" />
</bean>
```
* Write Mybatis mapper interface, mapper xml as usual.
* When using the mappers in `job.xml`, you are actually using a single query in the mapper, like this:

```xml
  <bean id="reader-mybatis-cursor" class="org.mybatis.spring.batch.MyBatisCursorItemReader">
    <property name="sqlSessionFactory" ref="batchSqlSessionFactory" />
    <property name="queryId" value="net.lingyanzhou.mybatis_spring_learning.mapper.InTableBatchMapper.getData" />
  </bean> 


  <bean id="writer-mybatis" class="org.mybatis.spring.batch.MyBatisBatchItemWriter">
    <property name="sqlSessionFactory" ref="batchSqlSessionFactory" />
    <property name="statementId" value="net.lingyanzhou.mybatis_spring_learning.mapper.OutTableBatchMapper.insertInTable" />
</bean>
```
