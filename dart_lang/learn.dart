/** 
soure : https://dart.dev/samples
*/ 
void main() {
    print('Hello World');
}

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