### **Structural Patterns**

#### 1. **Adapter**

```
Client --> Target
             ^
             |
         Adapter --> Adaptee
```

#### 2. **Bridge**

```
       Abstraction
            |
        RefinedAbstraction
            |
         has-a
            v
         Implementor
            |
        ConcreteImplementor
```

#### 3. **Composite**

```
           Component
          /        \
      Leaf       Composite
                    |
             contains Components
```

#### 4. **Decorator**

```
        Client
           |
         Component
           ^
     +-----------+
     |Decorator A|---> Component
     +-----------+
```

#### 5. **Facade**

```
        Client
           |
         Facade
        /      \
  Subsystem1  Subsystem2
```

#### 6. **Flyweight**

```
        Client
           |
         uses
           |
       FlyweightFactory
           |
         Flyweight
           ^
        Shared + Unique state
```

#### 7. **Proxy**

```
        Client
           |
          Proxy
           |
       RealSubject
```

---

### **Behavioral Patterns**

#### 1. **Chain of Responsibility**

```
Client --> Handler1 --> Handler2 --> Handler3 --> null
```

#### 2. **Command**

```
Client --> Command --> Receiver
           |
        Invoker
```

#### 3. **Interpreter**

```
Client --> Context
           |
       AbstractExpression
         /         \
 Terminal      NonTerminal
```

#### 4. **Iterator**

```
Client --> Iterator <--> Collection (Aggregate)
```

#### 5. **Mediator**

```
Component1 -->|
Component2 -->|--> Mediator <-- Component3
```

#### 6. **Memento**

```
Originator --> Memento
    ^              |
    |           Caretaker
```

#### 7. **Observer**

```
Subject --> [Observer1, Observer2, Observer3]
```

#### 8. **State**

```
Context --> StateA
           StateB
           StateC
```

#### 9. **Strategy**

```
Context --> StrategyA
           StrategyB
```

#### 10. **Template Method**

```
AbstractClass
     |
ConcreteClass (implements steps)
```

#### 11. **Visitor**

```
ElementA --->|
ElementB --->|--> Visitor
```
