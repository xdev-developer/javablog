package com.javablog.ui.admin.validators;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.javablog.core.entity.Section;
import com.javablog.core.storage.SectionDAO;

public class SectionValidator implements Validator{

	private Logger logger = Logger.getLogger(SectionValidator.class);

	private SectionDAO sectionsDAO;

	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class clazz) {
		return clazz.equals(Section.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required", "Section name required");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "url", "required", "Section url required");

		Section section = (Section)target;
		if(section.getId() == -1){
			try {
				if(sectionsDAO.get(section.getName()) != null){
					errors.rejectValue("name", "already.exists");
				}
			} catch (SQLException e) {
				logger.error(e, e);
			}
		}
	}

	public void setSectionsDAO(SectionDAO sectionsDAO) {
		this.sectionsDAO = sectionsDAO;
	}
}
