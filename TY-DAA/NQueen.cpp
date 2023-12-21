#include <iostream>
#include <vector>
#include <chrono>
#include<ctime>
using namespace std;
using namespace std::chrono;

bool isSafe(int row, int col, vector<int>& board) {
    for (int i = 0; i < row; ++i) {
        if (board[i] == col || abs(row - i) == abs(col - board[i])) {
            return false;
        }
    }
    return true;
}

void solveNQueens(int n, int row, vector<int>& board, int& totalSolutions) {
    if (row == n) {
        totalSolutions++;
        return;
    }

    for (int col = 0; col < n; ++col) {
        if (isSafe(row, col, board)) {
            board[row] = col;
            solveNQueens(n, row + 1, board, totalSolutions);
        }
    }
}

int main() {
    vector<int> board;

    for (int n = 4; n <= 8; ++n) {
        board.assign(n, -1);
        int totalSolutions = 0;

        clock_t start = clock();
        solveNQueens(n, 0, board, totalSolutions);
        clock_t stop = clock();
        double duration = double(stop - start);

        cout << "Time taken for " << n << " Queens: " << duration << "seconds" << endl;
        cout << "Total solutions for " << n << " Queens: " << totalSolutions << endl;
    }

    return 0;
}
