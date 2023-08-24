package com.keysoft.pigfarm.common.util;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.docx4j.XmlUtils;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.Text;
import org.docx4j.wml.Tr;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
public class Docx4jUtils {
	public static final String SUB_TABLE 				= "SUB_TABLE";
	public static final String SUB_TABLE_DETECT_FIELD 	= "SUB_TABLE_DETECT_FIELD";
	
	/**
	 * Loading the document with docx4j.
	 * 
	 * @param templatePath
	 * @return
	 * @throws Docx4JException
	 * @throws FileNotFoundException
	 */
	public static WordprocessingMLPackage getTemplate(String templatePath) throws Docx4JException, FileNotFoundException {
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(templatePath);
		WordprocessingMLPackage template = WordprocessingMLPackage.load(inputStream);
		return template;
	}

	/**
	 * Getting all elements in the documents (tables, rows...)
	 * 
	 * @param obj
	 * @param element
	 * @return
	 */
	public static List<Object> getAllElementFromObject(Object obj, Class<?> element) {
		List<Object> result = new ArrayList<Object>();
		if (obj instanceof JAXBElement) {
			obj = ((JAXBElement<?>) obj).getValue();
		}

		if (obj.getClass().equals(element)) {
			result.add(obj);
		} else if (obj instanceof ContentAccessor) {
			List<?> children = ((ContentAccessor) obj).getContent();
			for (Object child : children) {
				result.addAll(getAllElementFromObject(child, element));
			}

		}
		return result;
	}

	/**
	 * 
	 * @param placeholders
	 * @param textToAdd
	 * @param template
	 * @throws Docx4JException
	 * @throws JAXBException
	 */
	public static void replaceTable(List<Map<String, String>> textToAdd, Tbl tempTable) throws Docx4JException, JAXBException {
		List<Object> rows = getAllElementFromObject(tempTable, Tr.class);
		if(rows.size() >= 1){	
			Tr templateRow = (Tr) rows.get(2);
//			if (rows.size() >= 4) {
//				templateRow = (Tr) rows.get(rows.size() - 1);
//			}
			
			for (Map<String, String> replacements : textToAdd) {
				addRowToTable(tempTable, templateRow, replacements);
			}
			
			tempTable.getContent().remove(templateRow);
		}
	}
	
	/**
	 * 
	 * @param placeholders
	 * @param textToAdd
	 * @param template
	 * @throws Docx4JException
	 * @throws JAXBException
	 */
	public static void replaceTableWeigh(List<Map<String, String>> textToAdd, Tbl tempTable) throws Docx4JException, JAXBException {
		List<Object> rows = getAllElementFromObject(tempTable, Tr.class);
		if(rows.size() >= 1){	
			Tr templateRow = (Tr) rows.get(1);
//			if (rows.size() >= 4) {
//				templateRow = (Tr) rows.get(rows.size() - 1);
//			}
			
			for (Map<String, String> replacements : textToAdd) {
				addRowToTable(tempTable, templateRow, replacements);
			}
			
			tempTable.getContent().remove(templateRow);
		}
	}

	/**
	 * 
	 * @param reviewtable
	 * @param templateRow
	 * @param replacements
	 */
	public static void addRowToTable(Tbl reviewtable, Tr templateRow, Map<String, String> replacements) {
		Tr workingRow = (Tr) XmlUtils.deepCopy(templateRow);
		List<?> textElements = getAllElementFromObject(workingRow, Text.class);
		for (Object object : textElements) {
			Text text = (Text) object;
			//System.out.println("text.getValue(): " + text.getValue());
			String replacementValue = (String) replacements.get(text.getValue());
			//System.out.println("replacementValue: " + replacementValue);
			if (replacementValue != null) {
				text.setValue(replacementValue);
			//} else {
			//	text.setValue("");
			}
		}
 
		reviewtable.getContent().add(workingRow);
	}
	
	public static void replaceComplexTable(List<Map<String, Object>> textToAdd, Tbl tempTable) throws Docx4JException, JAXBException {
		List<Object> rows = getAllElementFromObject(tempTable, Tr.class);
		if(rows.size() >= 1){	
			Tr templateRow = (Tr) rows.get(0);
			if (rows.size() >= 2) {
				templateRow = (Tr) rows.get(rows.size() - 1);
			}
			
			for (Map<String, Object> replacements : textToAdd) {
				addRowToComplexTable(tempTable, templateRow, replacements);
			}
			
			tempTable.getContent().remove(templateRow);
		}
	}

	@SuppressWarnings("unchecked")
	public static void addRowToComplexTable(Tbl reviewtable, Tr templateRow, Map<String, Object> replacements) throws Docx4JException, JAXBException {
		Tr workingRow = (Tr) XmlUtils.deepCopy(templateRow);
		List<?> textElements = getAllElementFromObject(workingRow, Text.class);
		for (Object object : textElements) {
			Text text = (Text) object;
			//System.out.println("text.getValue(): " + text.getValue());
			String replacementValue = (String) replacements.get(text.getValue());
			//System.out.println("replacementValue: " + replacementValue);
			if (replacementValue != null) {
				text.setValue(replacementValue);
			//} else {
			//	text.setValue("");
			}
		}

		List<Map<String, String>> mainProductList = (List<Map<String, String>>)replacements.get(SUB_TABLE);
		String detectField = (String)replacements.get(SUB_TABLE_DETECT_FIELD);
		List<Object> childTables = Docx4jUtils.getAllElementFromObject(workingRow, Tbl.class);
		//System.out.println("SIZE-CHILD-TABLE: " + childTables.size());
		for (Iterator<Object> iterator = childTables.iterator(); iterator.hasNext();) {
			Object tbl = iterator.next();
			
			List<?> textEles = Docx4jUtils.getAllElementFromObject(tbl, Text.class);					
			for(Object text: textEles) {
				Text textElement = (Text) text;						
				if(textElement.getValue() != null) {
					//System.out.println("CHILD-TEXT-VALUE: " + textElement.getValue());
					//System.out.println("CHECKED-TEXT: " + detectField);
					if(textElement.getValue().equals(detectField)) {
						//System.out.println("PROCESS REPLACE");
						//System.out.println("MAIN-PRODUCTS: " + mainProductList);
						Docx4jUtils.replaceTable(mainProductList, (Tbl) tbl);
					}
				}
			}
		}
		
		
 
		reviewtable.getContent().add(workingRow);
	}
}
