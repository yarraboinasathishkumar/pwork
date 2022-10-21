/** 
soure : https://dart.dev/samples
*/ 
void main() {
    print('Hello World');


/*Even in type-safe Dart code, 
most variables don’t need explicit types, thanks to type inference:*/
var name = 'Voyager I';
var year = 1977;
var antennaDiameter = 3.7;
var flybyObjects = ['Jupiter', 'Saturn', 'Uranus', 'Neptunr'];
var image = {
    'tags' : ['saturn'],
    'url' : '//path/to/saturn.jpg'
};
/** continue here for more https://dart.dev/guides/language/language-tour#variables */

/**control flow statements */
if (year >= 2001) {
  print('21st century');
} else if (year >= 1901) {
  print('20th century');
}

for (final object in flybyObjects) {
  print(object);
}

for (int month = 1; month <= 12; month++) {
  print(month);
}

while (year < 2016) {
  year += 1;
}
}
/** continue more https://dart.dev/guides/language/language-tour#control-flow-statements */

/**Functions 
We recommend (https://dart.dev/guides/language/effective-dart/design#types) 
specifying the types of each function’s arguments and return value:
*/
int fibonacci(int n) {
  if (n == 0 || n == 1) return n;
  return fibonacci(n - 1) + fibonacci(n - 2);
}

var result = fibonacci(20);

/** A shorthand => (arrow) syntax is handy for functions that contain a single statement. 
This syntax is especially useful when passing anonymous functions as arguments:
 */
 flybyObjects.where((name) => name.contains('turn')).forEach(print);
 /**Besides showing an anonymous function (the argument to where()), 
 this code shows that you can use a function as an argument: 
 the top-level print() function is an argument to forEach(). 
 */
 /**Read more https://dart.dev/guides/language/language-tour#functions */
 /**Comments
 Dart comments usually start with //.
 */
 // This is a normal, one-line comment.

/// This is a documentation comment, used to document libraries,
/// classes, and their members. Tools like IDEs and dartdoc treat
/// doc comments specially.

/* Comments like these are also supported. */
/**Read more https://dart.dev/guides/language/language-tour#comments */

/**TODO: Continue from Imports section of https://dart.dev/samples */
/**Imports 
To access APIs defined in other libraries, use import.
*/
// Importing core libraries
import 'dart:math';

// Importing libraries from external packages
import 'package:test/test.dart';

// Importing files
import 'path/to/my_other_file.dart';
/**Read more https://dart.dev/guides/language/language-tour#libraries-and-visibility */

/**Classes 
Here’s an example of a class with three properties, two constructors, and a method. 
One of the properties can’t be set directly, so it’s defined using a getter method (instead of a variable).
*/
class Spacecraft {
  String name;
  DateTime? launchDate;

  // Read-only non-final property
  int? get launchYear => launchDate?.year;

  // Constructor, with syntactic sugar for assignment to members.
  Spacecraft(this.name, this.launchDate) {
    // Initialization code goes here.
  }

  // Named constructor that forwards to the default one.
  Spacecraft.unlaunched(String name) : this(name, null);

  // Method.
  void describe() {
    print('Spacecraft: $name');
    // Type promotion doesn't work on getters.
    var launchDate = this.launchDate;
    if (launchDate != null) {
      int years = DateTime.now().difference(launchDate).inDays ~/ 365;
      print('Launched: $launchYear ($years years ago)');
    } else {
      print('Unlaunched');
    }
  }
}
/**
You might use the Spacecraft class like this: */
var voyager = Spacecraft('Voyager I', DateTime(1977, 9, 5));
voyager.describe();

var voyager3 = Spacecraft.unlaunched('Voyager III');
voyager3.describe();
/**Read more https://dart.dev/guides/language/language-tour#classes */

/**Enums 
Enums are a way of enumerating a predefined set of values or instances in a way which ensures that there cannot be any other instances of that type.

Here is an example of a simple enum that defines a simple list of predefined planet types:
*/
enum PlanetType { terrestrial, gas, ice }
/**
Here is an example of an enhanced enum declaration of a class describing planets, with a defined set of constant instances, namely the planets of our own solar system.
 */
/// Enum that enumerates the different planets in our solar system
/// and some of their properties.
enum Planet {
  mercury(planetType: PlanetType.terrestrial, moons: 0, hasRings: false),
  venus(planetType: PlanetType.terrestrial, moons: 0, hasRings: false),
  // ···
  uranus(planetType: PlanetType.ice, moons: 27, hasRings: true),
  neptune(planetType: PlanetType.ice, moons: 14, hasRings: true);

  /// A constant generating constructor
  const Planet(
      {required this.planetType, required this.moons, required this.hasRings});

  /// All instance variables are final
  final PlanetType planetType;
  final int moons;
  final bool hasRings;

  /// Enhanced enums support getters and other methods
  bool get isGiant =>
      planetType == PlanetType.gas || planetType == PlanetType.ice;
}

/**You might use the Planet enum like this: */
final yourPlanet = Planet.earth;
if (!yourPlanet.isGiant) {
  print('Your planet is not a "giant planet".');
}

/**Read more https://dart.dev/guides/language/language-tour#enums */

/**Inheritance
Dart has single inheritance. */
class Orbiter extends Spacecraft {
  double altitude;

  Orbiter(super.name, DateTime super.launchDate, this.altitude);
}
/**Read more https://dart.dev/guides/language/language-tour#extending-a-class */

/**
Mixins
Mixins are a way of reusing code in multiple class hierarchies. The following is a mixin declaration: */
mixin Piloted {
  int astronauts = 1;

  void describeCrew() {
    print('Number of astronauts: $astronauts');
  }
}
/**To add a mixin’s capabilities to a class, just extend the class with the mixin. */
class PilotedCraft extends Spacecraft with Piloted {
  // ···
}
//PilotedCraft now has the astronauts field as well as the describeCrew() method.
/**Read more https://dart.dev/guides/language/language-tour#adding-features-to-a-class-mixins */

/**Interfaces and abstract classes
Dart has no interface keyword. Instead, all classes implicitly define an interface. Therefore, you can implement any class. */
class MockSpaceship implements Spacecraft {
  // ···
}

/**Read more https://dart.dev/guides/language/language-tour#implicit-interfaces */
/**You can create an abstract class to be extended (or implemented) by a concrete class. 
Abstract classes can contain abstract methods (with empty bodies). */
abstract class Describable {
  void describe();

  void describeWithEmphasis() {
    print('=========');
    describe();
    print('=========');
  }
}
/**Any class extending Describable has the describeWithEmphasis() method, which calls the extender’s implementation of describe(). */
/**Read more https://dart.dev/guides/language/language-tour#abstract-classes */

/**Async
Avoid callback hell and make your code much more readable by using async and await. */
const oneSecond = Duration(seconds: 1);
// ···
Future<void> printWithDelay(String message) async {
  await Future.delayed(oneSecond);
  print(message);
}
/**The method above is equivalent to: */
Future<void> printWithDelay(String message) {
  return Future.delayed(oneSecond).then((_) {
    print(message);
  });
}
/**As the next example shows, async and await help make asynchronous code easy to read. */
Future<void> createDescriptions(Iterable<String> objects) async {
  for (final object in objects) {
    try {
      var file = File('$object.txt');
      if (await file.exists()) {
        var modified = await file.lastModified();
        print(
            'File for $object already exists. It was modified on $modified.');
        continue;
      }
      await file.create();
      await file.writeAsString('Start describing $object in this file.');
    } on IOException catch (e) {
      print('Cannot create description for $object: $e');
    }
  }
}
/**You can also use async*, which gives you a nice, readable way to build streams. */
Stream<String> report(Spacecraft craft, Iterable<String> objects) async* {
  for (final object in objects) {
    await Future.delayed(oneSecond);
    yield '${craft.name} flies by $object';
  }
}

/** Read more https://dart.dev/guides/language/language-tour#asynchrony-support */

/**Exceptions
To raise an exception, use throw: */
if (astronauts == 0) {
  throw StateError('No astronauts.');
}
/**To catch an exception, use a try statement with on or catch (or both): */
try {
  for (final object in flybyObjects) {
    var description = await File('$object.txt').readAsString();
    print(description);
  }
} on IOException catch (e) {
  print('Could not describe object: $e');
} finally {
  flybyObjects.clear();
}
/**
Note that the code above is asynchronous; try works for both synchronous code and code in an async function. */
/**Read more https://dart.dev/guides/language/language-tour#exceptions */

/**Next steps: 
https://dart.dev/guides/language/language-tour
https://dart.dev/guides/libraries/library-tour
https://api.dart.dev/stable/2.18.3/index.html
 */
