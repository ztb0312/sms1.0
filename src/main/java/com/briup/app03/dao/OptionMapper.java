package com.briup.app03.dao;

import java.util.List;
import com.briup.app03.bean.Option;

public interface OptionMapper {
	List<Option> findAll();

	List<Option> findByQuestionId(long id);

	Option findById(long id);

	void save(Option Option);

	void update(Option Option);

	void delete(long id);

}
