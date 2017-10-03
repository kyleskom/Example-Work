// Author: Kyle Skompinski kyleskom

#include <fstream>
#include <iostream>
#include <string>
#include <vector>

void method(const std::string&,const int&);

int main(int argc, char *argv[]) {
        if (argc < 2) {
                std::cout << "error" << std::endl;
                return -1;
        }
        std::ifstream in(argv[1]);
        int param[2];
        std::string n;
        std::string k;
        in >> k;
        in >> n;
        std::string line;
        std::string input;

        // [0] = k || [1] = n
        param[0] = std::stoi(k);
        if (param[0] < 3 || param[0] > 10) {
                std::cout << "error" << std::endl;
                return -1;
        }
        param[1] = std::stoi(n);
        if (param[1] <= 1) {
                std::cout << "error" << std::endl;
                return -1;
        }

        for (int i = 0; i <= param[1]; i++) {
                getline(in,line);
                input += line;
        }

        in.close();

        method (input, param[0]);

        return 0;
}

void method(const std::string& in,const int& k){
        std::vector<int> v;
        v.reserve((in.size() / k));
        for (int i = 0; i < in.size() - k + 1; i++) {
                std::string substring;
                for (auto j = 0; j < k; j++) {
                        if (in[j+i] == 'A') {
                                substring += '1';
                        }
                        else if (in[j+i] == 'C') {
                                substring += '2';
                        }
                        else if (in[j+i] == 'G') {
                                substring += '3';
                        }
                        else if (in[j+i] == 'T') {
                                substring += '4';
                        }
                        else {
                                substring += in[j+i];
                        }
                }
                if (substring.find('N') == std::string::npos) {
                        int num = std::stoi(substring);
                        v.push_back(num);
                }
        }

        for (int i = 0; i < v.size(); i++) {
                int count = 1;
                int index = v[i];
                std::string convert = std::to_string(index);
                std::string out;
                for (int y = 0; y < convert.size(); y++) {
                        if (convert[y] == '1') {
                                out += 'A';
                        }
                        if (convert[y] == '2') {
                                out += 'C';
                        }
                        if (convert[y] == '3') {
                                out += 'G';
                        }
                        if (convert[y] == '4') {
                                out += 'T';
                        }
                }
                for (int j = i + 1; j < v.size(); j++) {
                        if (index == v[j]) {
                                count += 1;
                                v.erase(v.begin() + j);
                                j--;
                        }
                }
                std::cout << out << " " << count << std::endl;
        }
}
