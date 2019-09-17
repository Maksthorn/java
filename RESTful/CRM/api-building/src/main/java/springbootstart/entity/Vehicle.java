package springbootstart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import java.sql.Date;

@Entity
@Table(name = "Vehicles")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String vehicleID;
	@Column(name="make")
	private String Make;
	@Column(name="model")
	private String Model;
	@Column(name="year")
	private int Year;
	@Column(name="body_style")
	private String BodyStyle;
	@Column(name="color")
	private String Color;
	@Column(name="inventory_date")
	private String InventoryDate;
	@Column(name="trime_level")
	private String TrimeLevel;
	
	
	
	
	public Vehicle(String vehicleID, String make, String model, int year, String bodyStyle, String color,
			String inventoryDate, String trimeLevel) {
		super();
		this.vehicleID = vehicleID;
		Make = make;
		Model = model;
		Year = year;
		BodyStyle = bodyStyle;
		Color = color;
		InventoryDate = inventoryDate;
		TrimeLevel = trimeLevel;
	}




	public Vehicle() {}

    
	
	
	public String getVehicleID() {
		return vehicleID;
	}




	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}




	public String getMake() {
		return Make;
	}




	public void setMake(String make) {
		Make = make;
	}




	public String getModel() {
		return Model;
	}




	public void setModel(String model) {
		Model = model;
	}




	public int getYear() {
		return Year;
	}




	public void setYear(int year) {
		Year = year;
	}




	public String getBodyStyle() {
		return BodyStyle;
	}




	public void setBodyStyle(String bodyStyle) {
		BodyStyle = bodyStyle;
	}




	public String getColor() {
		return Color;
	}




	public void setColor(String color) {
		Color = color;
	}




	public String getInventoryDate() {
		return InventoryDate;
	}




	public void setInventoryDate(String inventoryDate) {
		InventoryDate = inventoryDate;
	}




	public String getTrimeLevel() {
		return TrimeLevel;
	}




	public void setTrimeLevel(String trimeLevel) {
		TrimeLevel = trimeLevel;
	}




	@Override
	public String toString() {
		return "Vehicle [vehicleID=" + vehicleID + ", Make=" + Make + ", Model=" + Model + ", Year=" + Year
				+ ", BodyStyle=" + BodyStyle + ", Color=" + Color + ", InventoryDate=" + InventoryDate + ", TrimeLevel="
				+ TrimeLevel + "]";
	}
	
	

	
	
	
}
