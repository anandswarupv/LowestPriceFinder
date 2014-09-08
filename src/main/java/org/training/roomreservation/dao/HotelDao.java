package org.training.roomreservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.training.roomreservation.model.Address;
import org.training.roomreservation.model.Hotel;
import org.training.roomreservation.model.Rates;
import org.training.roomreservation.utils.ConnectionManager;

@Component
public class HotelDao {
	
	@Autowired
	RatesDao ratesDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	ConnectionManager connectionManager;
	
	private static final String GET_ALL_HOTELS = "select * from hotel";
	private static final String GET_HOTEL = "select * from hotel where id = ?";
	
	public Hotel getHotel(Long id) {
		Hotel hotel = null;
        Connection connection = connectionManager.getConnection();
        if (connection != null) {
            try {
                PreparedStatement prepareStatement = connection.prepareStatement(GET_HOTEL);
                prepareStatement.setLong(1, id);
                ResultSet resultSet = prepareStatement.executeQuery();
                while(resultSet.next()) {
                	String name = resultSet.getString("name");
                	int rating = resultSet.getInt("rating");
                	Address address = addressDao.getAddressForHotelId(id);
                	Rates rates = ratesDao.getRatesforHotelId(id);
                	hotel = new Hotel((Long)id, name, address, rating, rates);
                }
                connection.commit();
                resultSet.close();
                prepareStatement.close();
            } catch (SQLException e) {               
                e.printStackTrace();
                return null;
            }            
        } else {
        	System.out.println("No Database Connection");        
        }
        return hotel;	
	}
	
	public List<Hotel> getAllHotels() {
		List<Hotel> hotels = new ArrayList<Hotel>();
        Connection connection = connectionManager.getConnection();
        if (connection != null) {
            Statement statement;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(GET_ALL_HOTELS);
                while(resultSet.next()) {
                	long id = resultSet.getLong("id");
                	String name = resultSet.getString("name");
                	int rating = resultSet.getInt("rating");
                	Address address = addressDao.getAddressForHotelId(id);
                	Rates rates = ratesDao.getRatesforHotelId(id);
                	Hotel hotel = new Hotel((Long)id, name, address, rating, rates);
                	hotels.add(hotel);
                }
                connection.commit();
                resultSet.close();
                statement.close();
            } catch (SQLException e) {               
                e.printStackTrace();
                return null;
            }            
        } else {
        	System.out.println("No Database Connection");        
        }
        return hotels;
    }

}
