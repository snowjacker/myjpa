package myjpa.util;

import org.springframework.beans.propertyeditors.PropertiesEditor;

import com.mysql.jdbc.StringUtils;

public class IntegerEditer extends PropertiesEditor {
	@Override
	public String getAsText() {
		return getValue().toString();
	}

	@Override
	public void setAsText(String text) {
		if (StringUtils.isNullOrEmpty(text)) {
			text = "0";
		} else {
			setValue(Integer.parseInt(text));
		}
	}
}
