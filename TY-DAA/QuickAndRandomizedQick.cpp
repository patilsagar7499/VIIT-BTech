#include <iostream>
#include <cstdlib>
#include <ctime>
#include <chrono>

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

int randomizedPartition(int arr[], int low, int high) {
    srand(time(nullptr));
    int random = low + rand() % (high - low + 1);
    swap(arr[random], arr[low]);
    return partition(arr, low, high);
}

void randomizedQuickSort(int arr[], int low, int high) {
    if (low < high) {
        int pi = randomizedPartition(arr, low, high);

        randomizedQuickSort(arr, low, pi - 1);
        randomizedQuickSort(arr, pi + 1, high);
    }
}

int main() {
    const int size = 500;
    int arr[size], arr_quick[size], arr_randomized[size];

    srand(static_cast<unsigned int>(time(nullptr)));
    for (int i = 0; i < size; ++i) {
        arr[i] = rand() % 1000; // Random values between 0 and 999
        arr_quick[i] = arr[i]; // Copying for QuickSort
        arr_randomized[i] = arr[i]; // Copying for Randomized QuickSort
    }

    // QuickSort with first element as pivot
    auto startQuick = high_resolution_clock::now();
    quickSort(arr_quick, 0, size - 1);
    auto stopQuick = high_resolution_clock::now();
    auto durationQuick = duration_cast<microseconds>(stopQuick - startQuick);

    cout << "Time taken by QuickSort with first element as pivot: " << durationQuick.count() << " microseconds" << endl;

    // Randomized QuickSort
    auto startRandomized = high_resolution_clock::now();
    randomizedQuickSort(arr_randomized, 0, size - 1);
    auto stopRandomized = high_resolution_clock::now();
    auto durationRandomized = duration_cast<microseconds>(stopRandomized - startRandomized);

    cout << "Time taken by Randomized QuickSort: " << durationRandomized.count() << " microseconds" << endl;

    return 0;
}
