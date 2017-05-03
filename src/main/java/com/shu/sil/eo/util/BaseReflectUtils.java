package com.shu.sil.eo.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BaseReflectUtils {

	/**
	 * Get the full name of the object class name
	 * */
	public static String getClassTypeName(Object entityObject) throws Exception {
		Class targetClass = entityObject.getClass();
		String classType = targetClass.getName();
		return classType;
	}

	/**
	 * Asynchronous call to get the reflection method
	 * */
	@SuppressWarnings("unchecked")
	public static Object invokeGetMethod(Object owner, Field tempField,
			Object[] args) throws Exception {
		String methodName = "get"
				+ tempField.getName().substring(0, 1).toUpperCase()
				+ tempField.getName().substring(1);
		Method method = null;
		try {
			method = owner.getClass().getMethod(methodName);
		} catch (SecurityException e) {
		} catch (NoSuchMethodException e) {
			throw e;
		}
		return method.invoke(owner);
	}

	public static void ivokeSetMethod(Object owner, Field tempField,
			Map<String, String> map) throws NoSuchMethodException,
			ParseException, IllegalAccessException, InvocationTargetException {
		String methodName = "set"
				+ tempField.getName().substring(0, 1).toUpperCase()
				+ tempField.getName().substring(1);
		Method method = null;
		try {
			method = owner.getClass()
					.getMethod(methodName, tempField.getType());
		} catch (SecurityException e) {
		} catch (NoSuchMethodException e) {
			throw e;
		}

		Object value = null;
		String valueStr = map.get(tempField.getName());

		// if (tempField.getType().getName().equals("int")) {
		// value = Integer.getInteger(valueStr);
		// }
		if (tempField.getType().getName().equals("java.lang.Long")) {
			value = Long.valueOf(valueStr);
		}
		if (tempField.getType().getName().equals("java.util.Date")) {
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			java.util.Date date = null;
			try {
				date = format.parse(valueStr);
			} catch (ParseException e) {
				e.printStackTrace();
				throw e;
			}
			value = date;
		}
		if (tempField.getType().getName().equals("java.lang.String")) {
			value = valueStr;
		}
		if (value != null && !value.toString().equals("")) {
			method.invoke(owner, value);
		}
	}

	public static void ivokeSetMethod(Object owner, Field tempField, String map)
			throws NoSuchMethodException, ParseException,
			IllegalAccessException, InvocationTargetException {
		String methodName = "set"
				+ tempField.getName().substring(0, 1).toUpperCase()
				+ tempField.getName().substring(1);
		Method method = null;
		try {
			method = owner.getClass()
					.getMethod(methodName, tempField.getType());
		} catch (SecurityException e) {
		} catch (NoSuchMethodException e) {
			throw e;
		}

		Object value = null;
		String valueStr = map;

		// if (tempField.getType().getName().equals("int")) {
		// value = Integer.getInteger(valueStr);
		// }
		if (tempField.getType().getName().equals("java.lang.Long")) {
			value = Long.valueOf(valueStr);
		}
		if (tempField.getType().getName().equals("java.lang.Integer")) {
			value = Integer.valueOf(valueStr);
		}
		if (tempField.getType().getName().equals("java.util.Date")) {
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			java.util.Date date = null;
			try {
				date = format.parse(valueStr);
			} catch (ParseException e) {
				e.printStackTrace();
				throw e;
			}
			value = date;
		}
		if (tempField.getType().getName().equals("java.lang.String")) {
			value = valueStr;
		}
		if (value != null && !value.toString().equals("")) {
			method.invoke(owner, value);
		}
	}
	public static void ivokeSetMethod(Object owner, Field tempField, Object  obj)
			throws NoSuchMethodException, ParseException,
			IllegalAccessException, InvocationTargetException {
		String methodName = "set"
				+ tempField.getName().substring(0, 1).toUpperCase()
				+ tempField.getName().substring(1);
		Method method = null;
		try {
			method = owner.getClass()
					.getMethod(methodName, tempField.getType());
		} catch (SecurityException e) {
		} catch (NoSuchMethodException e) {
			throw e;
		}
		
		if (obj != null && !obj.toString().equals("")) {
			method.invoke(owner, obj);
		}
	}
	public static void ivokeSetMethod(Object owner, Field tempField, List list)
			throws NoSuchMethodException, ParseException,
			IllegalAccessException, InvocationTargetException {
		String methodName = "set"
				+ tempField.getName().substring(0, 1).toUpperCase()
				+ tempField.getName().substring(1);
		Method method = null;
		try {
			method = owner.getClass()
					.getMethod(methodName, tempField.getType());
		} catch (SecurityException e) {
		} catch (NoSuchMethodException e) {
			throw e;
		}

		method.invoke(owner, list);
	}

	/**
	 * getAllFieldFromClass include superclass
	 * */
	public static Field[] getAllFieldFromClass(Class targetClass) {
		Field fieldSuperclassArray[] = targetClass.getSuperclass()
				.getDeclaredFields();
		Field fieldArray[] = targetClass.getDeclaredFields();

		Field fieldAllArray[] = new Field[fieldSuperclassArray.length
				+ fieldArray.length];

		System.arraycopy(fieldSuperclassArray, 0, fieldAllArray, 0,
				fieldSuperclassArray.length);

		System.arraycopy(fieldArray, 0, fieldAllArray,
				fieldSuperclassArray.length, fieldArray.length);
		return fieldAllArray;

	}

	public static String getSimpleName(String className) {
		String simpleName = "erro";
		try {
			Class classTemp = Class.forName(className);
			simpleName = classTemp.getSimpleName();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return simpleName;
	}

}
