#include <stdio.h>

int doSum(int a, int b)
{
    return a+b;
}

void* getSumPtr()
{
    void* sumPtr = (void*) &doSum;
    printf("The pointer to doSum is: %p\n", sumPtr);
    return sumPtr;
}
