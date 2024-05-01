package dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import entities.Beverage;

@Dao
public interface BeverageDao {
    @Insert
    void insertBeverage(Beverage beverage);

    @Update
    void updateBeverage(Beverage beverage);

    @Delete
    void deleteBeverage(Beverage beverage);


    @Query("Select * from beverage")
    List<Beverage> getAllBeverages();
}
