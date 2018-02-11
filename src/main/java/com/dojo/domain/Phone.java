package com.dojo.domain;

public class Phone {

    private PhoneBrand brand;
    private PhoneType type;
    private float cost;
    private int version;
    private int rate;

    public static class Builder {
        // Required parameters
        private PhoneBrand brand;
        private PhoneType type;
        private float cost;

        // Optional parameters - initialized to default values
        private int version = 1;
        private int rate = 1;

        public Builder(PhoneBrand brand, PhoneType type, float cost) {
            this.brand = brand;
            this.type = type;
            this.cost = cost;
        }

        public Builder version(int val) {
            version = val;
            return this;
        }

        public Builder rate(int val) {
            rate = val;
            return this;
        }

        public Phone build() {
            return new Phone(this);
        }
    }

    private Phone(Builder builder) {
        this.brand = builder.brand;
        this.type = builder.type;
        this.cost = builder.cost;
        this.version = builder.version;
        this.rate = builder.rate;
    }


    public PhoneBrand getBrand() {
        return brand;
    }

    public PhoneType getType() {
        return type;
    }

    public float getCost() {
        return cost;
    }

    public int getVersion() {
        return version;
    }

    public int getRate() {
        return rate;
    }
}
