package net.lingyanzhou.mybatis_spring_learning.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.lingyanzhou.mybatis_spring_learning.dto.InDto;

import org.springframework.jdbc.core.RowMapper;

public class InTableRowMapper implements RowMapper<InDto> {

	@Override
	public InDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		InDto inDto = new InDto();
		inDto.setItId(rs.getInt(1));
		inDto.setItData(rs.getString(2));
		return inDto;
	}

}
