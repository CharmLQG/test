package com.charming.hello.test;

import java.util.Objects;

public class TestHash {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestHash(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestHash testHash = (TestHash) o;
        return Objects.equals(name, testHash.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
