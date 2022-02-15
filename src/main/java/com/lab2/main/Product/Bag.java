package com.lab2.main.Product;

import java.util.Objects;

public class Bag extends Product {

    public enum Size { SMALL, MEDIUM, LARGE};

    private Size size;

    public Bag(int id, String name, float price, Size size) {
        super(id, name, price);
        this.size = size;
    }

    public Bag(Bag other)
    {
        super(other.getId(), other.getName(), other.getPrice());
        this.size = other.size;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bag bag = (Bag) o;
        return size == bag.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }

    @Override
    public String toString() {
        return "Bag{" +
                super.toString() +
                "size=" + size +
                '}';
    }
}
