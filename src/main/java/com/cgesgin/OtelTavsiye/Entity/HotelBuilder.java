package com.cgesgin.OtelTavsiye.Entity;

public class HotelBuilder {

    private int id;
    private String name;
    private int starRating;
    private boolean iscarPark;
    private boolean isVentilation;
    private boolean isWifi;
    private boolean isAward;

    private String email;

    public static HotelBuilder builder(String name,int starRating){

        HotelBuilder hotelBuilder=new HotelBuilder();
        hotelBuilder.name=name;
        hotelBuilder.starRating=starRating;

        return hotelBuilder;
    }
    public Hotel build(){

        Hotel hotel= new Hotel();

        hotel.setName(this.name);
        hotel.setStarRating(this.starRating);
        hotel.setAward(this.isAward);
        hotel.setVentilation(this.isVentilation);
        hotel.setIscarPark(this.iscarPark);
        hotel.setWifi(this.isWifi);
        hotel.setEmail(this.email);

        return hotel;
    }

    public HotelBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public HotelBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public HotelBuilder setStarRating(int starRating) {
        this.starRating = starRating;
        return this;
    }

    public HotelBuilder setIscarPark(boolean iscarPark) {
        this.iscarPark = iscarPark;
        return this;
    }

    public HotelBuilder setVentilation(boolean ventilation) {
        isVentilation = ventilation;
        return this;
    }

    public HotelBuilder setWifi(boolean wifi) {
        isWifi = wifi;
        return this;
    }

    public HotelBuilder setAward(boolean award) {
        isAward = award;
        return this;
    }

    public HotelBuilder setEmail(String email) {
        this.email = email;
        return this;
    }
}
