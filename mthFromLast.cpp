#include <iostream>
#include <iterator>
#include <sstream>
#include <list>
#include <cstring>
#include <vector>

using namespace std;

void setVector(list<int>& v, int m) {
    string line;
    getline(std::cin, line);
    istringstream in(line, istringstream::in);
    int n;
    int ithFromBack = -1;
    int listLength = 0;
    list<int>::iterator mthItr;
    while (in >> n) {
        v.push_back(n); 
        listLength++;

        if ( listLength == m ) {
        	// Begin list iterator as mth from Last.
            mthItr = v.begin();
        } else if (listLength > m) {
            ++mthItr;
        }
             
    }
    if ( listLength > m) {
        cout << *mthItr << endl;;
    } else {
    	cout << "NIL" << endl;
    }
}

void printVector(list<int>& v) {
  for (list<int>::iterator it = v.begin(); it != v.end(); ++it)
    cout << ' ' << *it;
}

int main()
{
  list<int> iVec;
  int m;
  std::string line;
  std::getline(std::cin, line);  // read a line from std::cin into line
  std::cout << "Your Line Was (" << line << ")\n";

  istringstream in(line, istringstream::in);
  in >> m;
    cout << "Mth Value from last " << m << endl;

  setVector(iVec, m);

//  printVector(iVec);
  return 0;
}
