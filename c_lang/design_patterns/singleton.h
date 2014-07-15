#ifndef __SINGLETON__
#define __SINGLETON__

typedef struct singleton
{
  int data;
  int data1;
  int data2;
}singleton;

typedef singleton* singleton_ptr;

extern singleton_ptr createSingleton();

#endif
