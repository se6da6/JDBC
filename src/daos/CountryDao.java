package daos;

import java.util.List;

import entities.Country;

public class CountryDao implements Dao<Country,String> {
    public List<Country> findAll()
    {
        return null;
    }


    public void insert(Country country)
    {

    }
    
    public Boolean update()
    {
        Boolean success = true;
        return success;
    }

    public Country findById()
    {
        
        return null;
    }

    public Boolean delete()
    {
        return false;
    
}
