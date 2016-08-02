package net.lingyanzhou.mybatis_spring_learning.tasklet;

import javax.sql.DataSource;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;

public class ExecuteSqlTasklet implements Tasklet {
	
	private String sql;
	
	private JdbcTemplate  jdbcTemplate;
	
	ExecuteSqlTasklet(DataSource dataSource, String sql) {
		this.sql = sql;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
			throws Exception {
		jdbcTemplate.update(sql);
		return RepeatStatus.FINISHED;
	} 

}
