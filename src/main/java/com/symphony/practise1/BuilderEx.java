package com.symphony.practise1;

public class BuilderEx {

    private final String name;
    private final int age;

    public BuilderEx(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static class Builder {
        String name;
        int age;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public BuilderEx build() {
            return new BuilderEx(this.name, this.age);
        }
    }
}
