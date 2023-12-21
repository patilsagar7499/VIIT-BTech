#include <iostream> //To perform any input and output operations
#include <cstdlib> //library contains a superset of the traditional C functions, macros, and datatypes
#include <ctime>  //converts the time value pointed to by time to local time in the form of a character string

using namespace std; //So that we can use names for objects and variables from the standard library.

void merge(int A[], int l, int mid, int h) {
    int i,j,k;
    int B[h+1];
    i=l,j=mid+1,k=l;
    while (i<=mid&&j<=h)
    {
        if(A[i]<A[j])
        B[k++]=A[i++];
        else
        B[k++]=A[j++];
    }
    for(;i<=mid;i++)
    B[k++]=A[i];
    for(;j<=h;j++)
    B[k++]=A[j];
    for(i=l;i<=h;i++)
    A[i]=B[i];    
}

void mergeSort(int arr[], int l, int r) {
    if (l < r) {
        int m = l + (r - l) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }
}

void swap(int &a, int &b) {
    int temp = a;
    a = b;
    b = temp;
}

int partition(int arr[], int low, int high) {
    int pivot = arr[low]; 
    int i = low;

    for (int j = low + 1; j <= high; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(arr[i], arr[j]);
        }
    }
    swap(arr[low], arr[i]); 
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
    int size = 500;
    int arr[size], arr_merge[size];

    srand(static_cast<unsigned int>(time(nullptr))); //with its help we are getting different elements after every run
    for (int i = 0; i < size; ++i) {
        arr[i] = rand() % 1000; // Random values between 0 and 999
        arr_merge[i] = arr[i]; // Copying for MergeSort
    }

    cout << "Unsorted array:" << endl;
    for (int i = 0; i < size; ++i) {
        cout << arr[i] << " ";
    }
    cout << endl;

    // QuickSort
    clock_t startTime = clock();
    quickSort(arr, 0, size - 1);
    clock_t endTime = clock();
    double timeTakenQuickSort = double(endTime - startTime) / CLOCKS_PER_SEC;

    cout << "\nSorted array By Quick Sort:" << endl;
    for (int i = 0; i < size; ++i) {
        cout << arr[i] << " ";
    }
    cout << endl;
    cout << "QuickSort Time taken: " << timeTakenQuickSort << " seconds" << endl;

    // MergeSort
    startTime = clock();
    mergeSort(arr_merge, 0, size - 1);
    endTime = clock();
    double timeTakenMergeSort = double(endTime - startTime) / CLOCKS_PER_SEC;

    cout << "\nSorted array By Merge Sort:" << endl;
    for (int i = 0; i < size; ++i) {
        cout << arr_merge[i] << " ";
    }
    cout << endl;
    
    cout << "MergeSort Time taken: " << timeTakenMergeSort << " seconds" << endl;

    return 0;
}
