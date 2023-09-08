package com.levik.inter;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class HasMapTask {

    public static class User {
        private final int id;
        private final String name;
        private final int age;

        public User(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id && age == user.age && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return id;
        }
    }

    public static void main(String[] args) {
        HashMap<User, String> usersMap = new HashMap<>();

        User user1 = new User(1, "Levik", 18);
        User user2 = new User(2, "Ben", 20);

        usersMap.put(user1, "First");
        usersMap.put(user2, "Second");

        usersMap
                .forEach((key, value) -> System.out.println(key + " " + value));

        System.out.println("Try to get user1 " + usersMap.containsKey(user1));
        System.out.println("Try to get point2 " + usersMap.containsKey(user2));
    }


    public static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return new Random().nextInt();
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
