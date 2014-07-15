#include <stdio.h>
/*
check pre increment(++w) and post (x++) operators 
---interaction with + operator

*/
void unary_plusplus()
{
  int x = 1;
  int w = 1;
  int y = 0;
  int z = 0;
  
  y = x+++x++;
  printf("\n y= %d x=%d",y,x);
  printf("\n z = ++w+++w; gives error: lvalue required as increment operand compiler error");
  printf("\n z = ++w+++w+w+++w++;gives compile error due to ambiguity of w++ or ++w");
  z = ++w + ++w + w+++w++;
  //z = (++w)+(++w)+(w++)+(w++);
  printf("\n z= %d w=%d",z,w);
}
int main()
{
  unary_plusplus();
}
