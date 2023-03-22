import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import daos.CityDao;
import daos.LanguageDao;
import entities.City;
import entities.Language;



public class App 
{
    public static void main(String[] args) throws Exception 
    {
        System.out.println("Hello, World!");

        List<Language> languageList;
        List<City> cityList;


        String url = "jdbc:mysql://localhost:3306/world";
        String user = "root";
        String password = "MUSaz*1318";

        try (Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement =  connection.createStatement();){

            //CityDao
            CityDao cityDao = new CityDao(connection);
            cityList = cityDao.findAll();


            //LanguageDao
            LanguageDao languageDao = new LanguageDao(connection);
            languageList = languageDao.findAll();

            System.out.println("Cities printes:");
            for(City city: cityList)
            {
                System.out.println(city);
            }
            

            System.out.println("Languages printes:");
            for(Language language:languageList)
            {
                System.out.println(language);
            }
            
            //Insert 
            City insertCity1 = new City();
            insertCity1.setCountryCode("CAN");
            insertCity1.setDistrict("Ontario");
            insertCity1.setName("Kingston");
            insertCity1.setPopulation(118000);

            cityDao.insert(insertCity1);

            //Using findById and then executing the update
            City updateCity = new City();
            updateCity = cityDao.findById(4075);
            updateCity.setPopulation(10000);
            Boolean success = cityDao.update(updateCity);
            //update
           

            //delete
            Boolean succeeded = cityDao.delete(4080);
            

            //ResultSet resultSet = statement.executeQuery("SELECT * FROM Country");
        
        //while(resultSet.next())
        //{
         //   System.out.println(resultSet.getString(2)) ;
           // System.out.println(resultSet.getString("name"));

        //}

        //resultSet.close();
       // }
       // catch(SQLException ex)
       // {
        //    System.err.println("Exception:" + ex.getMessage());
       // }
        
    }
    catch(Exception ex){
        System.out.println("Exception" + ex.getMessage());
    }
}
}