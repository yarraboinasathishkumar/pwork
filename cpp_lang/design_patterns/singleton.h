#ifndef SINGLETON_H_
#define SINGLETON_H_
#include <iostream>
class Singleton 
{
  private: 
    int data;
    Singleton();
  public:
    static Singleton *singleton_ptr;
    static Singleton* createSingleton();
    void display(); 
}; 
//Singleton* Singleton::singleton_ptr = NULL;
extern void test_singleton();
#endif
