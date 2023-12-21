#include <iostream>
#include <mutex>
#include <thread>

using namespace std;

int main()
{
    const int no_of_philosophers = 5;

    struct Chopsticks
    {
    public:
        Chopsticks() {;}
        mutex mu;
    };

    auto eat = [](Chopsticks& left_chopsticks, Chopsticks& right_chopsticks, int philosopher_number) {

        unique_lock<mutex> llock(left_chopsticks.mu);
        unique_lock<mutex> rlock(right_chopsticks.mu);

        cout << "Philosopher " << philosopher_number << " is eating" << endl;

        chrono::milliseconds timeout(1500);
        this_thread::sleep_for(timeout);

        cout << "Philosopher " << philosopher_number << " has finished eating" << endl;
    };

    // create chopsticks
    Chopsticks chp[no_of_philosophers];

    // create philosophers
    thread philosopher[no_of_philosophers];

    // Philosophers Start reading
    cout << "Philosopher " << (0 + 1) << " is reading.." << endl;
    philosopher[0] = thread(eat, ref(chp[0]), ref(chp[no_of_philosophers - 1]), (0 + 1));

    for (int i = 1; i < no_of_philosophers; ++i) {
        cout << "Philosopher " << (i + 1) << " is reading.." << endl;
        philosopher[i] = thread(eat, ref(chp[i]), ref(chp[i - 1]), (i + 1));
    }

    for (auto& ph : philosopher) {
        ph.join();
    }

    return 0;
}