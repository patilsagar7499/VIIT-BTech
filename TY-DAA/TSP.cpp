#include <iostream>
#include <vector>
#include <algorithm>
#include <ctime>
#include <cstdlib>

using namespace std;

const int SIZE = 4;

struct Chromosome {
    vector<int> path;
    int fitness;
};

void initializePopulation(vector<Chromosome>& population) {
    for (int i = 0; i < population.size(); ++i) {
        vector<int> path(SIZE);
        for (int j = 0; j < SIZE; ++j) {
            path[j] = j;
        }
        random_shuffle(path.begin() + 1, path.end()); // Shuffle excluding the starting city (assuming it's always the first)

        Chromosome individual{path, 0};
        population[i] = individual;
    }
}

int calculateDistance(int TSP[SIZE][SIZE], const vector<int>& path) {
    int distance = 0;
    for (int i = 0; i < SIZE - 1; ++i) {
        distance += TSP[path[i]][path[i + 1]];
    }
    distance += TSP[path.back()][path.front()]; // Return to the starting city
    return distance;
}

void calculateFitness(int TSP[SIZE][SIZE], vector<Chromosome>& population) {
    for (auto& individual : population) {
        individual.fitness = calculateDistance(TSP, individual.path);
    }
}

bool compareFitness(const Chromosome& a, const Chromosome& b) {
    return a.fitness < b.fitness;
}

void crossover(const Chromosome& parent1, const Chromosome& parent2, Chromosome& child) {
    int startPos = rand() % SIZE;
    int endPos = rand() % SIZE;

    if (startPos > endPos) {
        swap(startPos, endPos);
    }

    vector<int> childPath = parent1.path;
    for (int i = startPos; i <= endPos; ++i) {
        childPath[i] = parent2.path[i];
    }

    child = {childPath, 0};
}

void mutate(Chromosome& individual) {
    int pos1 = rand() % SIZE;
    int pos2 = rand() % SIZE;

    swap(individual.path[pos1], individual.path[pos2]);
}

int main() {
    srand(time(0));

    int TSP[SIZE][SIZE] = {
        {0, 10, 15, 20},
        {5, 0, 9, 10},
        {6, 13, 0, 12},
        {8, 8, 9, 0}
    };

    const int populationSize = 10;
    const int generations = 100;

    vector<Chromosome> population(populationSize);

    initializePopulation(population);

    for (int gen = 0; gen < generations; ++gen) {
        calculateFitness(TSP, population);
        sort(population.begin(), population.end(), compareFitness);

        Chromosome parent1 = population[0];
        Chromosome parent2 = population[1];

        Chromosome child;
        crossover(parent1, parent2, child);

        mutate(child);

        population[populationSize - 1] = child;
    }

    calculateFitness(TSP, population);
    sort(population.begin(), population.end(), compareFitness);

    cout << "Best Path: ";
    for (int city : population[0].path) {
        cout << city << " ";
    }

    cout << "\nTotal Distance: " << population[0].fitness << endl;

    return 0;
}