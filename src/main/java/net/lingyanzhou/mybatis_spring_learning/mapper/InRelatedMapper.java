package net.lingyanzhou.mybatis_spring_learning.mapper;

import java.util.List;

import net.lingyanzhou.mybatis_spring_learning.dto.InRelatedDto;

public interface InRelatedMapper {
	InRelatedDto selectById(int id);
}
