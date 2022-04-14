package java8_assessments_DateTimeAPI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Tablet {
	String tablet_name;
	String manufacturer;
	LocalDate manufacture_date ;
	LocalDate expiry_date;
	
	public Tablet(String tablet_name, String manufacturer, LocalDate manufacture_date, LocalDate expiry_date) {
		this.tablet_name = tablet_name;
		this.manufacturer = manufacturer;
		this.manufacture_date = manufacture_date;
		this.expiry_date = expiry_date;
	}

	@Override
	public String toString() {
		return "Tablet [tablet_name=" + tablet_name + ", manufacturer=" + manufacturer + ", manufacture_date="
				+ manufacture_date + ", expiry_date=" + expiry_date + "]";
	}

	public String getTablet_name() {
		return tablet_name;
	}

	public void setTablet_name(String tablet_name) {
		this.tablet_name = tablet_name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public LocalDate getManufacture_date() {
		return manufacture_date;
	}

	public void setManufacture_date(LocalDate manufacture_date) {
		this.manufacture_date = manufacture_date;
	}

	public LocalDate getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(LocalDate expiry_date) {
		this.expiry_date = expiry_date;
	}

}
