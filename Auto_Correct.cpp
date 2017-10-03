//Kyle Skompinski kyleskom

#include <iostream>
#include <string>
#include <map>
#include <fstream>
#include <math.h>

std::string dict(std::string &,std::map<std::string, int>&);

int main(int argc, char* argv[]){
        std::map<std::string, int> m;
        if (argc < 2) {
                std::cout << "error" << std::endl;
                return -1;
        }

        std::ifstream in(argv[1]);
        std::string s;
        while(in >> s) {
                std::string y;
                in >> y;
                int x = std::stoi(y);
                m.insert(std::pair<std::string,int>(s,x));
        }
        in.close();

        while (std::cin >> s) {
                std::string print;
                print = dict(s,m);
                std::cout << print << std::endl;
        }
}

std::string dict(std::string &s,std::map<std::string, int> &m){
        std::string word;
        int frequency;
        auto search = m.find(s);
        std::map<std::string, int> m2;
        if (search != m.end()) {
                word = s;
                frequency = search->second;
                ++m[word];
                return word + " " + std::to_string(frequency);
        }else {
                int i = 0;
                int distance;
                for (std::map<std::string, int>::iterator lit = m.begin(); lit!=m.end(); ++lit) {
                        int count = 0;
                        distance = abs((lit->first.length() - s.length()));

                        if (lit->first.length() == s.length()) {
                                for (auto i = 0; i < s.length(); i++) {
                                        if ((lit->first)[i] != s.at(i)) {
                                                count++;
                                        }
                                        if (count == 2) {
                                                break;
                                        }
                                }
                                if (count < 2) {
                                        m2.insert(std::pair<std::string,int>(lit->first,lit->second));
                                }

                        }
                        else if (distance == 1) {
                                std::string longer;
                                std::string shorter;

                                if (s.length() > lit->first.length()) {
                                        longer = s;
                                        shorter = lit->first;
                                }
                                if(s.length() < lit->first.length()) {
                                        longer = lit->first;
                                        shorter = s;
                                }
                                int f = 0;
                                for (int g = 0; g < longer.length(); g++) {
                                        if (shorter[f] == longer[g]) {
                                                f++;
                                                if (f == shorter.length()) {
                                                        break;
                                                }
                                        }
                                        else {
                                                count++;
                                                if (count == 2) {
                                                        break;
                                                }
                                        }
                                }
                                if (count < 2) {
                                        m2.insert(std::pair<std::string,int>(lit->first,lit->second));
                                }
                        }
                }

                if (m2.empty()) {
                        m.insert(std::pair<std::string,int>(s,1));
                        return "-";
                }
        }

        std::map<std::string,int>::iterator it=m2.begin();
        std::string answer = it->first;
        int best = it->second;
        for (; it!=m2.end(); it++) {
                if (it->second > best) {
                        answer = it->first;
                        best = it->second;
                }
        }
        return answer + " " + std::to_string(best);
}
