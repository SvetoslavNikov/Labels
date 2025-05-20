package com.example.Test.TestingPatterns.CoffeeDecoratorTest;

//Exploring the decorator pattern
//that's just a simple example

//TODO: maybe i should add option in decorator
//      to get this obj in Coffee variable?
interface Coffee {
    String getDescription();
    double getCost();
}


class PlainCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Plain Coffee";
    }

    @Override
    public double getCost() {
        return 2.0;
    }
}


 abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

     CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }

     //TODO: maybe i should add option to get this obj in Coffee variable?:
/*
public static Coffee decorate(Coffee coffee) {
    return new MilkDecorator(coffee);
}

Might write it as non-static to
allow future use of instance-specific configuration or behavior

public Coffee decorate(Coffee coffee) {
    return new MilkDecorator(coffee);
}

public Coffee decorate() {
    return this; //returns the CoffeeDecorator
}
 */
}

 class MilkDecorator extends CoffeeDecorator {
     MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.5;
    }
}


class SugarDecorator extends CoffeeDecorator {
     SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.2;
    }
}


class Main {
     public static void main(String[] args) {
        
        Coffee coffee = new PlainCoffee();
        System.out.println("Description: " + coffee.getDescription());
        System.out.println("Cost: $" + coffee.getCost());

        
        Coffee milkCoffee = new MilkDecorator(new PlainCoffee());
        System.out.println("\nDescription: " + milkCoffee.getDescription());
        System.out.println("Cost: $" + milkCoffee.getCost());

        //manual nesting????????????????
        Coffee sugarMilkCoffee = new SugarDecorator(new MilkDecorator(new PlainCoffee()));
        System.out.println("\nDescription: " + sugarMilkCoffee.getDescription());
        System.out.println("Cost: $" + sugarMilkCoffee.getCost());

        //maybe with simple builder?
        Coffee sugarMilkCoffee2 = new CoffeeBuilder(new PlainCoffee())
                .withMilk()
                .withSugar()
//              .withCaramel()   // Builder changes needed!
                .build();
         System.out.println("\nDescription: " + sugarMilkCoffee2.getDescription());
         System.out.println("Cost: $" + sugarMilkCoffee2.getCost());
//
//         //or maybe generic builder?
//         Coffee sugarMilkCoffee3 = new CoffeeBuilderGeneric(new PlainCoffee())
//                 .add(MilkDecorator::new)
//                 .add(SugarDecorator::new)
////                .add(CaramelDecorator::new)   // no Builder changes needed!
//                 .build();


     }
}

//So to don't have to do this manual chaining we could make a builder

class CoffeeBuilder{
    Coffee coffee;

    public CoffeeBuilder(Coffee base){
        this.coffee = base;
    }

    CoffeeBuilder withMilk(){
        this.coffee = new MilkDecorator(coffee);
        return this;
    }

    CoffeeBuilder withSugar(){
        this.coffee = new SugarDecorator(coffee);
        return this;
    }
    Coffee build(){
        return coffee;
    }
}

//class CoffeeBuilderGeneric{
//    Coffee coffee;
//    public CoffeeBuilderGeneric(Coffee base){
//        this.coffee = base;
//    }
//
//    public CoffeeBuilderGeneric add(Function<Coffee, Coffee> decorator){
//        this.coffee = decorator.apply(coffee);
//        return this;
//    }
//
//    public Coffee build(){
//        return coffee;
//    }
//}






























