package com.mkyong.common.form;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * information about ATMS
 * 
 * @author Sergey
 * 
 */

@Entity
@Table(name = "atms_info_ua")
public class Atms_Info_Ua implements Serializable {

	private static final long serialVersionUID = 111L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "ID_BANK")
	private Banks_Ua bank_ua;

	@Column(name = "AREA_EN")
	private String areaEn;

	@Column(name = "CITY_EN")
	private String cityEn;

	@Column(name = "AREA_RU")
	private String areaRu;

	@Column(name = "CITY_RU")
	private String cityRu;

	@Column(name = "CITY_AREA")
	private String city_area;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "WORK_TIME")
	private String work_time;

	@Column(name = "FACE_LOCATION")
	private String face_location;

	@Column(name = "MOD_DATE")
	private Date mod_data;

	@Enumerated(EnumType.STRING)
	@Column(name = "ADD_REMOVE", columnDefinition = "enum('0','1','2')")
	private String add_ramove;

	@OneToOne(mappedBy = "atms_info_ua", cascade = CascadeType.ALL)
	private Coordinates_Ua coordinates_ua;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 
	 * @return name area Ukraine English language
	 */
	public String getAreaEn() {
		return areaEn;
	}

	/**
	 * set new name area Ukraine English Language
	 * 
	 * @param areaEn
	 */
	public void setAreaEn(String areaEn) {
		this.areaEn = areaEn;
	}
       /**
        * 
        * @return name area Ukraine Russian language
        */
	public String getAreaRu() {
		return areaRu;
	}
    /**
     * set new  name area Ukraine Russian language
     * @param  areaRu  area
     */ 
	public void setAreaRu(String areaRu) {
		this.areaRu = areaRu;
	}

	/**
	 * @return the city_area
	 */
	public String getCity_area() {
		return city_area;
	}

	/**
	 * @param city_area
	 *            the city_area to set
	 */
	public void setCity_area(String city_area) {
		this.city_area = city_area;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the work_time
	 */
	public String getWork_time() {
		return work_time;
	}

	/**
	 * @param work_time
	 *            the work_time to set
	 */
	public void setWork_time(String work_time) {
		this.work_time = work_time;
	}

	/**
	 * @return the face_location
	 */
	public String getFace_location() {
		return face_location;
	}

	/**
	 * @param face_location
	 *            the face_location to set
	 */
	public void setFace_location(String face_location) {
		this.face_location = face_location;
	}

	/**
	 * @return the mod_data
	 */
	public Date getMod_data() {
		return mod_data;
	}

	/**
	 * @param mod_data
	 *            the mod_data to set
	 */
	public void setMod_data(Date mod_data) {
		this.mod_data = mod_data;
	}

	/**
	 * @return the add_ramove
	 */
	public String getAdd_ramove() {
		return add_ramove;
	}

	/**
	 * @param add_ramove
	 *            the add_ramove to set
	 */
	public void setAdd_ramove(String add_ramove) {
		this.add_ramove = add_ramove;
	}

	/**
	 * @return the bank_ua
	 */
	public Banks_Ua getBank_ua() {
		return bank_ua;
	}

	/**
	 * @param bank_ua
	 *            the bank_ua to set
	 */
	public void setBank_ua(Banks_Ua bank_ua) {
		this.bank_ua = bank_ua;
	}

	/**
	 * @return the coordinates_ua
	 */
	public Coordinates_Ua getCoordinates_ua() {
		return coordinates_ua;
	}

	/**
	 * @param coordinates_ua
	 *            the coordinates_ua to set
	 */
	public void setCoordinates_ua(Coordinates_Ua coordinates_ua) {
		this.coordinates_ua = coordinates_ua;
	}

	/**
	 * 
	 * @return city name English language
	 */
	public String getCityEn() {
		return cityEn;
	}

	/**
	 * set new name city English Language
	 * 
	 * @param cityEn
	 */
	public void setCityEn(String cityEn) {
		this.cityEn = cityEn;
	}

	/**
	 * 
	 * @return city name Russian language
	 */
	public String getCityRu() {
		return cityRu;
	}

	/**
	 * set new city name Russian language
	 * 
	 * @param cityRu
	 */
	public void setCityRu(String cityRu) {
		this.cityRu = cityRu;
	}

}
