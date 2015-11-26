package nowCoder.algorithm.tools;

import java.util.Arrays;
import java.util.Comparator;

class Dog{
	int size;
	int weight;
 
	public Dog(int s, int w){
		size = s;
		weight = w; 
	}
}
 //策略模式，根据不同的排序方案，选择不同的比较器
class DogSizeComparator implements Comparator<Dog>{
 
	@Override
	public int compare(Dog o1, Dog o2) {
		return o1.size - o2.size;
	}
}
 
class DogWeightComparator implements Comparator<Dog>{
 
	@Override
	public int compare(Dog o1, Dog o2) {
		return o1.weight - o2.weight;
	}
}
 
public class ArraySort {
 
	public static void main(String[] args) {
		Dog d1 = new Dog(2, 50);
		Dog d2 = new Dog(1, 30);
		Dog d3 = new Dog(3, 40);
 
		Dog[] dogArray = {d1, d2, d3};
		printDogs(dogArray);
		//采用归并排序 n * log(n)
		Arrays.sort(dogArray, new DogSizeComparator());	
		printDogs(dogArray);
 
		Arrays.sort(dogArray, new DogWeightComparator());	
		printDogs(dogArray);
	}
 
	public static void printDogs(Dog[] dogs){
		for(Dog d: dogs)
			System.out.print("size="+d.size + " weight=" + d.weight + " ");
 
		System.out.println();
	}
}
/**
 * class Animal{
	int size;
}
 
class Dog extends Animal{
	public Dog(int s){
		size = s;
	}
}
 
class Cat extends Animal{
	public Cat(int s){
		size  = s;
	}
}
 
class AnimalSizeComparator implements Comparator<Animal>{
	 * Arrays.sort(T[], Comparator < ? super T > c)
	 * 只要是Animal的子类，都能使用同一个比较器
	@Override
	public int compare(Animal o1, Animal o2) {
		return o1.size - o2.size;
	}
	//in this way, all sub classes of Animal can use this comparator.
}
 

*/