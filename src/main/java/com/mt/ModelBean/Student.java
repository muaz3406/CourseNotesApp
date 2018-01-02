package com.mt.ModelBean;

import com.mt.ModelBean;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ManagedBean(name = "d")
@RequestScoped
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STUDENT_ID")
	private long id;

	@Column
	private String isim;
	@Column
	private String soyisim;
	@Column
	private String bolum;
	@Column
	private String esposta;
	@Column
	private String cinsiyet;
	@Column
	private String parola;
	@Column
	private String donem_seviyesi;
	@Column
	private static Map<String, Object> cinsiyetler = new LinkedHashMap<String, Object>();
	@Column
	private static Map<String, Object> bolumler = new LinkedHashMap<String, Object>();
	@Column
	private static Map<String, Object> donemler = new LinkedHashMap<String, Object>();

	public static DatabaseOperations dbObj;
	// *************************CONSTURCTOR***************************************************

	public Student() {
	}

	public Student(long id) {
		this.id = id;
	}

	public Student(long id, String isim, String soyisim, String bolum, String esposta, String cinsiyet, String parola,
			String donem_seviyesi) {
		this.id = id;
		this.isim = isim;
		this.soyisim = soyisim;
		this.bolum = bolum;
		this.esposta = esposta;
		this.cinsiyet = cinsiyet;
		this.parola = parola;
		this.donem_seviyesi = donem_seviyesi;
	}

	// *********************************AD-SOYAY-E_POSTA**************************************
	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyisim() {
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public String getEsposta() {
		return esposta;
	}

	public void setEsposta(String esposta) {
		this.esposta = esposta;
	}

	// *****************************DONEMLER*******************************************
	static {
		donemler.put("1", "1");
		donemler.put("2", "2");
		donemler.put("3", "3");
		donemler.put("4", "4");
	}

	public static Map<String, Object> getDonemler() {
		return donemler;
	}

	// *********************************DONEM_SEVIYESI***********************
	public void setDonem_seviyesi(String donem_seviyesi) {
		this.donem_seviyesi = donem_seviyesi;
	}

	public String getDonem_seviyesi() {

		return donem_seviyesi;

	}

	// *******************************BOLUMLER********************************************
	static {
		bolumler.put("EEE", "EEE");
		bolumler.put("CSE", "CSE");
		bolumler.put("BIOE", "BIOE");
		bolumler.put("MSE", "MSE");
		bolumler.put("ENVE", "ENVE");
	}

	public static Map<String, Object> getBolumler() {
		return bolumler;
	}

	// *****************************BOLUM***********************************************

	public String getBolum() {
		return bolum;
	}

	public void setBolum(String bolum) {
		this.bolum = bolum;
	}

	// ****************************************CINSIYETLER*******************************************

	static {
		cinsiyetler.put("Erkek", "Erkek");
		cinsiyetler.put("Bayan", "Bayan");
	}

	public static Map<String, Object> getCinsiyetler() {
		return cinsiyetler;
	}

	public static void setCinsiyetler(Map<String, Object> cinsiyetler) {
		Student.cinsiyetler = cinsiyetler;
	}

	// ***************************************************CINSIYET***************************
	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	// **************************************************PAROLA***********************************************
	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	// ************************************************SAVE
	// METHOD*************************************
	public void saveStudentRecord() {
		System.out.println("Calling saveStudentRecord() Method To Save Student Record");
		dbObj = new DatabaseOperations();
		dbObj.addStudentInDb(this);
	}

}
