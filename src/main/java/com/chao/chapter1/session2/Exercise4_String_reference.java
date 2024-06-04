package com.chao.chapter1.session2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise4_String_reference {
    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;  // reference to the "hello"
        string1 = "world";         // change reference to "world"
        StdOut.println(string1);
        StdOut.println(string2);
    }
}
/*
Output:
    world
    hello

Here's why:
In Java, `String` is an immutable class,
which means once a `String` object is created,
it cannot be changed.
When you assign `string1` to `string2`,
`string2` is pointing to the same `String` object in memory that `string1` is pointing to.

However, when you do `string1 = "world";`,
you're not changing the `String` object that `string1` was originally pointing to.
Instead, you're creating a new `String` object with the value "world" and making `string1` point to this new object.
The original `String` object with the value "hello" is not changed, and `string2` is still pointing to it.

That's why `string1` prints "world" and `string2` prints "hello".
The assignment `string1 = "world";` does not affect `string2` because `String` objects are immutable in Java.


Page 34:
The data type String is a Java data type, but it is not a primitive type.
We consider String now because it is a fundamental data type that almost every Java program uses.


Page 67:
A reference is a mechanism for accessing an object.
Java nomenclature makes clear the distinction from primitive types
(where variables are associated with values)
by using the term reference types for non-primitive types.

Page 71:
For primitive types, this policy is what we expect (the two variables are independent),
but each time that we use a reference type as a method argument we create an alias,

Page 80:
Java’s String is an important and useful ADT!!!!!

Page 105:
String objects are immutable because we generally do not want String values to change,
and Java arrays are mutable because we generally do want array values to change.
(Java’s StringBuilder class is mutable)


The distinction between mutable and immutable types, and between primitive and reference types,
is fundamental to understanding how variables work in Java and many other programming languages.

String is not a primitive type, but it's also not a typical reference type because it's immutable!!!!!
*/

/**
 * In Java, there are two main categories of data types: primitive types and reference types.
 *
 * 1. **Primitive types**:
 *      These are the basic types of data in Java.
 *      They include `byte`, `short`, `int`, `long`, `float`, `double`, `char`, and `boolean`.
 *      Variables of a primitive type directly contain values.
 *
 * 2. **Reference types**:
 *      These are types that refer to objects.
 *      They include classes, interfaces, arrays, and enums.
 *      Variables of a reference type store the address of the object they refer to.
 *
 * There's also a special type called `void`, which is used to indicate that a method does not return any value.
 *
 * In addition, starting from Java 10,
 * there's a new kind of type inference with the introduction of the `var` keyword.
 * When you declare a variable with `var`,
 * the Java compiler infers the type of the variable from the type of the initializer expression.
 *
 * ```java
 * var list = new ArrayList<String>();  // The compiler infers that list is of type ArrayList<String>
 * ```
 *
 * Note that `var` is not a new type. It's a keyword that tells the compiler to infer the type of the variable.
 */
