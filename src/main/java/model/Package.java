package model;

import lombok.Getter;

@Getter
public class Package implements LockerItem {

    private final String id;
    private final Size size;

    public Size getSize() {
        return size;
    }

    public Package(String id, Size size) {
        this.id = id;
        this.size = size;
    }
}
