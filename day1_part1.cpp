// ADVENT OF CODE 2023 DAY 1 PART 1
// https://adventofcode.com/2023/day/1
  
#include <iostream> // std::cout and std::cin
#include <numeric> // std::accumulate
#include <vector> // std::vector
#include <algorithm> //std::find_if

using std::cout, std::cin, std::string, std::vector;

int main () {
  vector<int> calibrationValue; 
  std::freopen("day1-input.txt", "r", stdin); // set the input so that it reads ./day1-input.txt as the input (file omitted from repo), instead of the command prompt
   
  // for every line of ./day1-input.txt
  string s;
  while (cin >> s) {
    auto is_digit = [](unsigned char c) {return isdigit(c);}; // lambda unary function to use in std::find_if

    // find the first digit in the line
    string::iterator first = (std::find_if(
      s.begin(),
      s.end(),
      is_digit
    ));

    // find the last digit in the line
    string::reverse_iterator last = (std::find_if(
      s.rbegin(),
      s.rend(),
      is_digit
    ));
    
    int digit = ((*first - '0')*10) + (*last - '0'); // convert string::iterator to int, the '0' is used to offset the ascii value of the character
    calibrationValue.push_back(digit);
  }

  cout << std::accumulate(calibrationValue.begin(), calibrationValue.end(), 0) << std::endl; // sum every element of calibrationValue
  return 0;
}
