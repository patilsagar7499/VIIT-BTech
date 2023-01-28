#include <iostream>
#include <cstring>
using namespace std;
bool compare(string s,string s1) 
{
    for(int i=0;s[i] != '\0'&& s1[i] != '0';i++)
    {
        if(s[i] != s1[i])
        {
            return false;
        }
        
    }
    return true;
}
int main()
{
    //length
    string s1 = "My name is Sagar";
    int length = 0;
    for(int i=0;s1[i] != '\0';i++)
    {
       length++; 
    }
    cout<<"Length of string is : "<<length<<endl;
    
    //Copy
    string name = "Sagar";
    string sname = "Patil";
    for(int i=0;sname[i] != '\0';i++)
    {
        name[i] = sname[i];
    }
    cout<<"Copied string is : "<<name<<endl;
    
    //Concatenate
    string one ="Hello",two = "Hello";
    for(int i=0;two[i] != '\0';i++){
        one+=two[i];
    }
    cout<<"Concatenated string is : "<<one<<endl;
    //Compare
    string college = "VIIT", sub = "FDS ";
    if(compare(college,sub))
    {
        cout<<"Strings are same"<<endl;
    }
    else{
        cout<<"Strings are not same"<<endl;
    }
    //Reverse
    string to_copy = "Sagar Patil";
    int length2 = 0;
    for(int i=0;to_copy[i] != '\0';i++)
    {
        length2++;
    }
    string result;
    for(int j=length2-1;j>=0;j--)
    {
        result += to_copy[j];
    }
    cout<<"Reversed string is : "<<result<<endl;
    return 0;
}


