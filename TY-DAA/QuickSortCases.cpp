#include <iostream>
#include <cstdlib>
#include <ctime>
#include <chrono>
#include <algorithm>

using namespace std;
using namespace std::chrono;

void swap(int &a, int &b) {
    int temp = a;
    a = b;
    b = temp;
}

int partition(int arr[], int low, int high) {
    int pivot = arr[low]; // Choosing the first element as pivot
    int i = low;

    for (int j = low + 1; j <= high; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(arr[i], arr[j]);
        }
    }
    swap(arr[low], arr[i]); // Placing the pivot element in its correct position
    return i;
}

void quickSort(int arr[], int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);

        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

int main() {
    const int bestCaseSize = 10000; // More than 500 for best case
    const int worstCaseSize = 10000; // More than 500 for worst case

    int arrBest[bestCaseSize];
    int arrWorst[worstCaseSize];

    // Generating best-case scenario (randomized array)
    srand(static_cast<unsigned int>(time(nullptr)));
    for (int i = 0; i < bestCaseSize; ++i) {
        arrBest[i] = rand()%1000;
    }

    // Generating worst-case scenario (already sorted array)
    for (int i = 0; i < worstCaseSize; ++i) {
        arrWorst[i] = i;
    }

    // Measuring time for best-case scenario
    auto startBest = high_resolution_clock::now();
    quickSort(arrBest, 0, bestCaseSize - 1);
    auto stopBest = high_resolution_clock::now();
    auto durationBest = duration_cast<microseconds>(stopBest - startBest);

    cout << "Time taken for best case : " << durationBest.count() << " microseconds" << endl;

    // Measuring time for worst-case scenario
    auto startWorst = high_resolution_clock::now();
    quickSort(arrWorst, 0, worstCaseSize - 1);
    auto stopWorst = high_resolution_clock::now();
    auto durationWorst = duration_cast<microseconds>(stopWorst - startWorst);

    cout << "Time taken for worst case ( sorted array): " << durationWorst.count() << " microseconds" << endl;

    return 0;
}
