/*
 * Lab2-1.cpp
 *
 *  Created on: Feb 8, 2013
 *      Author: uwrf
 */

#include <iostream>
#include <cmath>
#include <cstdlib>
using namespace std;

double toCelsius(const double f) {
	return (f-32)/1.8;
}

double toFahrenheit(const double c) {
	return (c*1.8)+32;
}

int main() {
	double celsius[10];
	double fahrenheit[10];

	for (int i = 0; i<10; i++) {
		celsius[i] = fahrenheit[i] = (i+1)*10;
	}

	cout << "This is the array of Celsius temperatures: ";
	for (int i = 0; i < 10; i++) {
		cout << celsius[i] << " ";
	}
	cout << endl << endl;

	cout << "This is the array of Fahrenheit temperatures: ";
	for (int i = 0; i < 10; i++) {
		cout << fahrenheit[i] << " ";
	}
	cout << endl << endl;

	double converted1[10];
	cout << "Converting the Celsius temperatures into Fahrenheit: ";
	for (int i = 0; i < 10; i++) {
		converted1[i] = toFahrenheit(celsius[i]);
		cout << converted1[i] << " ";
	}
	cout << endl << endl;

	double converted2[10];
	cout << "Converting the Fahrenheit temperatures into Celsius: ";
	for (int i = 0; i < 10; i++) {
		converted2[i] = toCelsius(fahrenheit[i]);
		cout << converted2[i] << " ";
	}
	cout << endl << endl;
}
