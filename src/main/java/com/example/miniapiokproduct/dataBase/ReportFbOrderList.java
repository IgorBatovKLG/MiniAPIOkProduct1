package com.example.miniapiokproduct.dataBase;

import com.example.miniapiokproduct.config.DBConnection;
import com.example.miniapiokproduct.models.ProductModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportFbOrderList {

    public ProductModel SelectProduct(int id) {
        Connection connection = DBConnection.connection;
        ProductModel productModel = null;
        try (PreparedStatement statement = connection.prepareStatement("select * from Products where id = " + id)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())  {
                productModel =  new ProductModel(
                                resultSet.getInt("id"),
                                resultSet.getInt("idShop"),
                                resultSet.getInt("idProduct"),
                                resultSet.getString("name"),
                                resultSet.getDouble("price"),
                                resultSet.getDouble("margin"),
                                resultSet.getInt("countImg"),
                                resultSet.getString("urlImg1"),
                                resultSet.getString("urlImg2"),
                                resultSet.getString("urlImg3"),
                                resultSet.getString("comment")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return productModel;
        }
        return productModel;
    }

    public void insertProduct(ProductModel productModel) {
        Connection connection = DBConnection.connection;
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO Products VALUES (?,?,?,?,?,?,?,?,?,?,?)")) {
            statement.setInt(2, productModel.getIdShop());
            statement.setInt(3, productModel.getIdProduct());
            statement.setString(4, productModel.getName());
            statement.setDouble(5, productModel.getPrice());
            statement.setDouble(6, productModel.getMargin());
            statement.setInt(7, productModel.getCountImg());
            statement.setString(8, productModel.getUrlImg1());
            statement.setString(9, productModel.getUrlImg2());
            statement.setString(10, productModel.getUrlImg3());
            statement.setString(11, productModel.getComment());


            statement.executeUpdate();
        } catch (SQLException e) {
            if (e.getMessage().contains("UNIQUE constraint failed")) {
            } else {
                e.printStackTrace();
            }
        }
    }

    public int selectCount(int id) {
        Connection connection = DBConnection.connection;
        int count = 0;
        try (PreparedStatement statement = connection.prepareStatement("select Count from Count where id =  " + id)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())  {
                count = resultSet.getInt("Count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return count;
        }
        return count;
    }


    public void updateCount(int count, int id) {
        Connection connection = DBConnection.connection;
        try (PreparedStatement statement = connection.prepareStatement("UPDATE Count SET Count = (?) WHERE id = (?)")) {
            statement.setInt(1, count);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +
                    " База занята");
        }
    }

}
