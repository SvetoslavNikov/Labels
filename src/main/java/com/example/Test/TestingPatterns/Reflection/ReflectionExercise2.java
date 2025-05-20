package com.example.Test.TestingPatterns.Reflection;

class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}
public class ReflectionExercise2 {
    public static void main(String[] args){


        Animal dog = new Dog();
        Animal cat = new Cat();

        //no reflection
        System.out.println("Dog instance of Dog no reflection: " + (dog instanceof Dog));
        //reflection
        System.out.println("Dog.class.isInstance(dog): " + Dog.class.isInstance(dog));
        System.out.println("Cat.class.isInstance(dog): " + Cat.class.isInstance(dog));

        //subclass
        //Can a Dog be assigned to an Animal variable?
        System.out.println("Animal.class.isAssignableFrom(Dog.class): "
                + Animal.class.isAssignableFrom(Dog.class));
        //Can a Animal be assigned to a Dog variable? NOPE
        System.out.println("Dog.class.isAssignableFrom(Animal.class): "
                + Dog.class.isAssignableFrom(Animal.class));


    }
}
