package net.lingyanzhou.mybatis_spring_learning.statementsetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.lingyanzhou.mybatis_spring_learning.dto.OutDto;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

public class OutTableInsertStatementSetter implements ItemPreparedStatementSetter<OutDto>{

	@Override
	public void setValues(OutDto outDto, PreparedStatement stmt)
			throws SQLException {
		stmt.setInt(1, outDto.getOtId());
		stmt.setString(2, outDto.getOtData());
	}

}
