#include <iostream>
#include "singleton.h"
using namespace std;
Singleton* Singleton::singleton_ptr = NULL;
Singleton::Singleton()
{
  data = 1;
}

Singleton* Singleton::createSingleton()
{

  if (singleton_ptr == NULL)
  {
    cout<<"singleton object created"<<endl;
    singleton_ptr = new Singleton();
    cout<<"singleton object created with ptr:"<<singleton_ptr<<endl;
  }
  return singleton_ptr;
}

void Singleton::display()
{

  cout<<"data is "<<data<<endl;
}

void test_singleton()
{
  Singleton *s_ptr = Singleton::createSingleton();
  s_ptr->display();
  cout<<"Singleton *t_ptr = new Singleton;"<<"gives compiler error"<<endl
        <<"-------COMPILER ERROR AS FOLLOWS--------"<<endl
        <<"error: ‘Singleton::Singleton()’ is private"<<endl<<"error: within this context"
        <<endl<<"-------COMPILER ERROR ENDS HERE---------"<<endl;

}
