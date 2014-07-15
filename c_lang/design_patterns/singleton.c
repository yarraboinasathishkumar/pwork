#include <stdio.h>
#include <stdlib.h>
#include <singleton.h>

static singleton_ptr sobj = NULL;

singleton_ptr createSingleton()
{
  if (sobj == NULL)
  { 
    sobj = (singleton_ptr) malloc(sizeof(singleton));
    sobj->data = 0;
    sobj->data1 = 0;
  }
  return sobj;
} 
int test_singleton()
{
  printf("sobj data is :%d\n", createSingleton()->data); 
}
