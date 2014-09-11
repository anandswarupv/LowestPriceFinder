package com.xebia.tdd.training.hotelreservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xebia.tdd.training.hotelreservation.model.Address;
import com.xebia.tdd.training.hotelreservation.model.Hotel;
import com.xebia.tdd.training.hotelreservation.model.Rates;
import com.xebia.tdd.training.hotelreservation.utils.ConnectionManager;

@Component
public class HotelDao {

    private final RatesDao ratesDao;

    private final AddressDao addressDao;

    private final ConnectionManager connectionManager;

    @Autowired
    public HotelDao(ConnectionManager connectionManager, RatesDao ratesDao, AddressDao addressDao) {
        this.connectionManager = connectionManager;
        this.ratesDao = ratesDao;
        this.addressDao = addressDao;
    }

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
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int rating = resultSet.getInt("rating");
                    Address address = addressDao.getAddressForHotelId(id);
                    Rates rates = ratesDao.getRatesforHotelId(id);
                    hotel = new Hotel((Long) id, name, address, rating, rates);
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

    public List<Hotel> getHotels() {
        List<Hotel> hotels = new ArrayList<Hotel>();
        Connection connection = connectionManager.getConnection();
        if (connection != null) {
            Statement statement;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(GET_ALL_HOTELS);
                while (resultSet.next()) {
                    long id = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    int rating = resultSet.getInt("rating");
                    Address address = addressDao.getAddressForHotelId(id);
                    Rates rates = ratesDao.getRatesforHotelId(id);
                    Hotel hotel = new Hotel((Long) id, name, address, rating, rates);
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
