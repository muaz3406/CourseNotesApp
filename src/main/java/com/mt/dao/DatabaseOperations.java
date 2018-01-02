package com.mt.dao;

import com.mt.session.HibernateUtil;
import com.mt.ModelBean.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class DatabaseOperations {

	private static Transaction transObj;
	private static Session sessionObj = HibernateUtil.getSessionFactory().openSession();

	// Method To Add New Student Details In Database
	public void addStudentInDb(Student studentObj) {
		try {
			transObj = sessionObj.beginTransaction();
			sessionObj.save(studentObj);
			// System.out.println("Student Record With Id: " + studentObj.getId() + " Is
			// Successfully Created In Database");

			// XHTML Response Text
			// FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("createdStudentId",
			// studentObj.getId());
		} catch (Exception exceptionObj) {
			exceptionObj.printStackTrace();
		} finally {
			transObj.commit();
		}
	}
}
