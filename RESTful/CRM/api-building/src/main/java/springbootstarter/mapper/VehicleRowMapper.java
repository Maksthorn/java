package springbootstarter.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springbootstart.entity.Vehicle;



public class VehicleRowMapper implements RowMapper<Vehicle>{

	@Override
	public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Vehicle vehicle = new Vehicle();

		vehicle.setVehicleID(rs.getString("vehicleID"));

		vehicle.setModel(rs.getString("Model"));

		vehicle.setYear(rs.getInt("Year"));
		
		vehicle.setBodyStyle(rs.getString("BodyStyle"));

		vehicle.setColor(rs.getString("Color"));

		vehicle.setInventoryDate(rs.getString("InventoryDate"));
		
		vehicle.setTrimeLevel(rs.getString("TrimeLevel"));
		
		return vehicle;
	}

}
