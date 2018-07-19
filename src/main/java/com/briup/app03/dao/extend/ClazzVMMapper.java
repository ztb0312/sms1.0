package com.briup.app03.dao.extend;

import java.util.List;

import com.briup.app03.vm.ClazzVM;

public interface ClazzVMMapper {
	
	

		List<ClazzVM> findAllClazzVM();
		ClazzVM findVMById(long id);
		void save(ClazzVM clazzVM);
		void upate(ClazzVM clazzVM);
		void delete(long id);
	
	

}
