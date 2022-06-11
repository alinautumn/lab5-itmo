package com.alinabobus.utility;


import com.alinabobus.data.Route;

import java.time.LocalDate;
import java.util.TreeSet;

import static java.lang.Integer.MIN_VALUE;

public class CollectionManager {
    private TreeSet<Route> mainData = new TreeSet<>();
    private TreeSet<Integer> idSet = new TreeSet<>();
    private final LocalDate creationDate = LocalDate.now();

    public void initialiseData(TreeSet<Route> treeSet) {
        this.mainData = treeSet;
    }


    public LocalDate getCreationDate() {
        return creationDate;
    }

    public TreeSet<Route> getMainData() {
        return mainData;
    }

    public int getMaxId() {
        int maxId = 0;
        for (Route route : mainData) {
            if (route.getId() > maxId) {
                maxId = route.getId();
            }
        }
        return maxId;
    }

    public double getAverage() {
        double avDist = 0;
        for (Route route : mainData) {
            avDist = avDist + route.getDistance();
        }
        avDist = avDist / mainData.size();
        return avDist;
    }

    public boolean addIfMin(Route route) {
        if (mainData.isEmpty() || route.compareTo(getMinDistance()) > 1) {
            mainData.add(route);
            idSet.add(route.getId());
            return true;
        }
        return false;
    }

    public Route getMinDistance() {
        long minDist = 2;
        Route minDistRoute = null;
        for (Route route: mainData) {
            if (route.getDistance() < minDist) {
                minDist = route.getDistance();
                minDistRoute = route;
            }
        }
        return minDistRoute;
    }

    public boolean addIfMax(Route route) {
        if (mainData.isEmpty() || route.compareTo(getMaxDistance()) > 1) {
            mainData.add(route);
            idSet.add(route.getId());
            return true;
        }
        return false;
    }

    private Route getMaxDistance() {
        long maxDist = MIN_VALUE;
        Route maxDistRoute = null;
        for (Route route: mainData) {
            if (route.getDistance() > maxDist) {
                maxDist = route.getDistance();
                maxDistRoute = route;
            }
        }
        return maxDistRoute;
    }

    public boolean removeById(int intArg) {
        if (mainData.removeIf(x -> x.getId() == intArg)) {
            return true;
        }
        return false;
    }
}
