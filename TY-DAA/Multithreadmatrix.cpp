#include <iostream>
#include <vector>
#include <thread>
#include <chrono>
#include <random>
using namespace std;

const int size = 3;
vector<vector<int>> A(size, vector<int>(size));
vector<vector<int>> B(size, vector<int>(size));
vector<vector<int>> C(size, vector<int>(size));
vector<vector<int>> D(size, vector<int>(size));

void normalMulti() {
    for (int i = 0; i < size; ++i) {
        for (int j = 0; j < size; ++j) {
            for (int k = 0; k < size; ++k) {
                D[i][j] += A[i][k] * B[k][j];
            }
        }
    }
}

void print(const vector<vector<int>>& arr) {
    for (int i = 0; i < size; ++i) {
        for (int j = 0; j < size; ++j) {
            cout << arr[i][j] << " ";
        }
        cout << endl;
    }
}

void multiplyRow(int row) {
    for (int i = 0; i < size; ++i) {
        for (int j = 0; j < size; ++j) {
            C[row][i] += A[row][j] * B[j][i];
        }
    }
}

void createAndStart(vector<thread>& threads) {
    for (int i = 0; i < size; ++i) {
        threads.emplace_back(multiplyRow, i);
    }
}

void join(vector<thread>& threads) {
    for (auto& th : threads) {
        th.join();
    }
}

int main() {
    random_device rd;
    mt19937 gen(rd());
    uniform_int_distribution<> dis(1, 10);

    for (int i = 0; i < size; ++i) {
        for (int j = 0; j < size; ++j) {
            A[i][j] = dis(gen);
            B[i][j] = dis(gen);
        }
    }

    cout << "Matrix A:" << endl;
    print(A);
    cout << "Matrix B:" << endl;
    print(B);

    vector<thread> threads;
    auto start = chrono::steady_clock::now();
    createAndStart(threads);
    join(threads);
    auto end = chrono::steady_clock::now();

    cout << "Multiplied by Threads:" << endl;
    print(C);
    cout << "Time for multithreaded multiplication: "
              << chrono::duration_cast<chrono::nanoseconds>(end - start).count()
              << "ns" << endl;

    cout << "Normal multiplication is:" << endl;
    auto normalTimeStart = chrono::steady_clock::now();
    normalMulti();
    auto normalTimeEnd = chrono::steady_clock::now();
    print(D);
    cout << "Time required for normal multiplication: "
              << chrono::duration_cast<chrono::nanoseconds>(normalTimeEnd - normalTimeStart).count()
              << "ns" << endl;

    return 0;
}
