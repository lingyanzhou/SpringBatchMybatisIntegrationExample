package net.lingyanzhou.mybatis_spring_learning.processor;

import lombok.Getter;
import lombok.Setter;
import net.lingyanzhou.mybatis_spring_learning.dto.InDto;
import net.lingyanzhou.mybatis_spring_learning.dto.InRelatedDto;
import net.lingyanzhou.mybatis_spring_learning.dto.OutDto;
import net.lingyanzhou.mybatis_spring_learning.mapper.InRelatedMapper;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class MergeInRelatedProcessor implements ItemProcessor<InDto, OutDto>{

	private InRelatedMapper inRelatedMapper;

	public MergeInRelatedProcessor(InRelatedMapper inRelatedMapper) {
		this.inRelatedMapper=inRelatedMapper;
	}

	@Override
	public OutDto process(InDto inDto) throws Exception {
		OutDto outDto = new OutDto();
		outDto.setOtId(inDto.getItId());
		outDto.setOtData(inDto.getItData());
		InRelatedDto relatedInfo = inRelatedMapper.selectById(inDto.getItIrtId());
		outDto.setOtData2(relatedInfo.getIrtData());
		return outDto;
	}

}

