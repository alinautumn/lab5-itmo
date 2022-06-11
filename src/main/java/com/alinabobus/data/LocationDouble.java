package com.alinabobus.data;

import java.util.Objects;

public class LocationDouble {
    private double x;
    private Integer y; //Поле не может быть null
    private String name; //Строка не может быть пустой, Поле не может быть null

    public  LocationDouble(double x, Integer y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x, y, name);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LocationDouble locationDouble = (LocationDouble) o;
        return Double.compare(locationDouble.x, x) == 0 && y == locationDouble.y && Objects.equals(name, locationDouble.name);
    }

    @Override
    public String toString(){
        return "LocationDouble{"
                + "x=" + x
                + ", y=" + y
                + ", name='" + name + '\''
                + '}';
    }
}
