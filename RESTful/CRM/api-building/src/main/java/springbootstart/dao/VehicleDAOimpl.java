package springbootstart.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import springbootstart.entity.Vehicle;
import springbootstarter.mapper.VehicleRowMapper;


public class VehicleDAOimpl implements VehicleDAO{
	
	public VehicleDAOimpl(NamedParameterJdbcTemplate template) {  

        this.template = template;  

	}  
	
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Vehicle> findAll() {
		return template.query("select * from Vehicles", new VehicleRowMapper());
		
	}

	@Override
	public void insertVehicle(Vehicle vehicle) {
		 final String sql = "insert into Vehicles(VehicleID, Make , Model, Year, BodyStyle, Color, InventoryDate, TrimeLevel) values(:VehicleID,:Make,:Model,:Year,:BodyStyle,:Color,:InventoryDate, :TrimeLevel)";

	        KeyHolder holder = new GeneratedKeyHolder();

	        SqlParameterSource param = new MapSqlParameterSource()

			.addValue("VehicleID", vehicle.getVehicleID())
		
			.addValue("Make", vehicle.getMake())
		
			.addValue("Model", vehicle.getModel())
		
			.addValue("Year", vehicle.getYear())
			
			.addValue("BodyStyle", vehicle.getBodyStyle())
			
			.addValue("Color", vehicle.getColor())
			
			.addValue("InventoryDate", vehicle.getInventoryDate())
			
			.addValue("TrimeLevel", vehicle.getTrimeLevel());

	        template.update(sql,param, holder);
		
	}

	@Override
	public void updateVehicle(Vehicle vehicle) {
		 final String sql = "update Vehicles set VehicleID= :VehicleID, Make= :Make, Model= :Model, Year= :Year, BodyStyle= :BodyStyle, Color= :Color, InventoryDate= :InventoryDate,TrimeLevel= :TrimeLevel";

	        KeyHolder holder = new GeneratedKeyHolder();

	        SqlParameterSource param = new MapSqlParameterSource()

			.addValue("VehicleID", vehicle.getVehicleID())
		
			.addValue("Make", vehicle.getMake())
		
			.addValue("Model", vehicle.getModel())
		
			.addValue("Year", vehicle.getYear())
			
			.addValue("BodyStyle", vehicle.getBodyStyle())
			
			.addValue("Color", vehicle.getColor())
			
			.addValue("InventoryDate", vehicle.getInventoryDate())
			
			.addValue("TrimeLevel", vehicle.getTrimeLevel());

	        template.update(sql,param, holder);
		
	}

	@Override
	public void executeUpdateVehicle(Vehicle vehicle) {
		 final String sql = "update Vehicles set VehicleID= :VehicleID, Make= :Make, Model= :Model, Year= :Year, BodyStyle= :BodyStyle, Color= :Color, InventoryDate= :InventoryDate,TrimeLevel= :TrimeLevel";

		 	Map<String,Object> map = new HashMap<String,Object>();

		 	map.put("VehicleID", vehicle.getVehicleID());
		
		 	map.put("Make", vehicle.getMake());
		
		 	map.put("Model", vehicle.getModel());
		
		 	map.put("Year", vehicle.getYear());
			
		 	map.put("BodyStyle", vehicle.getBodyStyle());
			
		 	map.put("Color", vehicle.getColor());
			
		 	map.put("InventoryDate", vehicle.getInventoryDate());
			
		 	map.put("TrimeLevel", vehicle.getTrimeLevel());
		 	
		 	
		 	 template.execute(sql,map,new PreparedStatementCallback<Object>() {  

		 	    @Override  

		 	    public Object doInPreparedStatement(PreparedStatement ps)  

		 	            throws SQLException, DataAccessException {  

		 	        return ps.executeUpdate();  

		 	    }  

		 	});  

	}

	@Override
	public void deleteVehicle(Vehicle vehicle) {
		 final String sql = "delete from Vehicles where VehicleID=:VehicleID";

		 Map<String,Object> map = new HashMap<String,Object>();  

		 map.put("VehicleID", vehicle.getVehicleID());

		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  

		    @Override  

		    public Object doInPreparedStatement(PreparedStatement ps)  

		            throws SQLException, DataAccessException {  

		        return ps.executeUpdate();  

		    }  

		});  
		
	}

}
