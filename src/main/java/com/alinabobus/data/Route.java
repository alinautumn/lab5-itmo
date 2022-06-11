package com.alinabobus.data;

import com.alinabobus.utility.CollectionManager;

import java.time.LocalDate;
import java.util.Objects;

public class Route implements Comparable<Route> {
    private int id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле не может быть null
    private LocationDouble to; //Поле не может быть null
    private long distance; //Значение поля должно быть больше 1


    public Route(int id, String name, Coordinates coordinates, LocalDate dateTime, Integer distance, Location location, LocationDouble locationDouble){

    }

    public Route(String name, Coordinates coordinates, Location from, LocationDouble to, CollectionManager collectionManager) {
        this.id = collectionManager.getMaxId() + 1;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = java.time.LocalDate.now();
        this.from = from;
        this.to = to;
        this.distance = getDistance() + 2;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Location getFrom() {
        return from;
    }

    public LocationDouble getTo() {
        return to;
    }

    public long getDistance() {
        return distance;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, distance, creationDate, coordinates, to, from, distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Route that = (Route) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(coordinates, that.coordinates) && Objects.equals(creationDate, that.creationDate) && Objects.equals(to, that.to) && from == that.from && distance == that.distance;
    }

    @Override
    public String toString() {
        return "Route{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", coordinates=" + coordinates
                + ", creationDate=" + creationDate
                + ", from=" + from
                + ", to=" + to
                + ", distance=" + distance
                + '}';
    }

    @Override
    public int compareTo(Route o) {
        Integer oValue = o.getId();
        Integer thisValue = this.getId();


        if (oValue == null) {
            oValue = -1;
        }
        if (thisValue == null) {
            thisValue = -1;
        }

        if (oValue - thisValue != 0) {
            return thisValue - oValue;
        } else {
            return this.getId() - o.getId();
        }
    }
}
