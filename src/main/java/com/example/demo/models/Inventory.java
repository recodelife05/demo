package com.example.demo.models;

public class Inventory {

    private static final int LOW_STOCK  = 5;
    public Inventory(Integer id,Integer quantity,String name){
        Id = id;
        Quantity = quantity;
        Status = GetAvailabityStatus(quantity);
        Name = name;
    }
    public Integer Id;
    public Integer Quantity;
    public String Name;
    public StockLevel Status;
    StockLevel GetAvailabityStatus(Integer quantity){
         if(this.Quantity == 0){
             return StockLevel.OutOfStock;
         }else if(this.Quantity <= LOW_STOCK){
             return StockLevel.Low;
         }else {
             return StockLevel.Available;
         }
    };

    public static Inventory ToEntity(Integer quantity,String name){
        return  new Inventory(0,quantity,name);
    }
}
