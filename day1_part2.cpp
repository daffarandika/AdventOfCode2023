// ADVENT OF CODE 2023 DAY 1 PART 2
// https://adventofcode.com/2023/day/1

#include <iostream>
#include <unordered_map>

using std::unordered_map, std::cout, std::cin, std::string;

int main () {
  std::freopen("./day1-input.txt", "r", stdin); // set the input so that it accepts ./day1-input.txt as the input (file omitted from repo), instead of the command prompt
   
  unordered_map<string, int> numbers; // map to store the value of each number and it's pronounciation
  numbers["one"] = 1;
  numbers["two"] = 2;
  numbers["three"] = 3;
  numbers["four"] = 4;
  numbers["five"] = 5;
  numbers["six"] = 6;
  numbers["seven"] = 7;
  numbers["eight"] = 8;
  numbers["nine"] = 9;

  string curr = ""; // current word that will be compared to the pronounciation of the numbers

  int sum = 0; // sum of each calibration value
  // for each line on ./day1-input.txt 
  string s;
  while (cin >> s) {
    int number = 0; // number that will be accumulated
    // for each character in line
    for (auto c: s) {
      curr.append({c});

      // check if character is number, if so store the value as second digit of the number
      if (isdigit(c)) {
        number = (c - '0') * 10;
        goto foundfirstnumber;
      }


      // compare current word with pronounciation of each number in map
      for (auto pair: numbers) {
        if (curr.find(pair.first) != string::npos) {
          number = pair.second*10; goto foundfirstnumber; }
      }
    }

    foundfirstnumber: // label
    curr = "";

    // iterate through string, backwards
    for (string::reverse_iterator it = s.rbegin(); it != s.rend(); it++){
      curr.insert(0, {*it}); // insert to front because we are iterating backwards
    
      // check if character is number, if so store the value as first digit of the number
      if (isdigit(*it)) {
        number += (*it - '0');
        goto foundsecondnumber;
      }
    
      // compare current word with pronounciation of each number in map
      for (auto pair: numbers) {
        if (curr.find(pair.first) != string::npos) {
          number += pair.second;
          goto foundsecondnumber;
        }
      }
    }

    foundsecondnumber: // label
    curr = "";
    sum += number;
  }

  cout << sum << std::endl;
  return 0;

}
