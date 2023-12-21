#include <iostream>
#include <vector>
#include <random>
#include <ctime>

const int size = 4;

struct Chromosome {
    std::vector<int> path;
};

void mutate(Chromosome& chromosome) {
    int pos1 = std::rand() % (size - 1) + 1;
    int pos2 = std::rand() % (size - 1) + 1;

    std::swap(chromosome.path[pos1], chromosome.path[pos2]);
}

int main() {
    std::srand(static_cast<unsigned int>(std::time(nullptr)));

    // Given input matrix
    std::vector<std::vector<int>> inputMatrix = {
        {0, 10, 15, 20},
        {5, 0, 9, 10},
        {6, 13, 0, 12},
        {8, 8, 9, 0}
    };

    // Chromosome initialization with a path representing cities
    Chromosome chromosome;
    chromosome.path = {0, 1, 2, 3}; // Assuming starting city is 0

    std::cout << "Original Path: ";
    for (int city : chromosome.path) {
        std::cout << city << " ";
    }
    std::cout << std::endl;

    mutate(chromosome); // Perform mutation

    std::cout << "Mutated Path: ";
    for (int city : chromosome.path) {
        std::cout << city << " ";
    }
    std::cout << std::endl;

    return 0;
}
