package dsa231;
import java.util.*;

public class River {
	private String[][] grid = new String[10][10];
	private ArrayList<Animal> animals = new ArrayList<>();
	
	public River() {
		addAnimal();
		updateGrid();
	}
	
	public void updateGrid() {
		for ( int i = 0; i < 10; i++) {
			for (int k = 0; k < 10; k++) {
				grid[i][k] = ".";
			}
		}
		for (Animal animal : animals) {
			grid[animal.pos[0][0]][animal.pos[0][1]] = (animal instanceof Bears) ? "#":"*";
		}
		
		List<Animal> newAnimals = new ArrayList<>();
		
		for (int i = 0; i < animals.size(); i++) {
		    Animal animal = animals.get(i);
		    for (int k = i + 1; k < animals.size(); k++) {
		        Animal otherAnimal = animals.get(k);
		        if ((animal.pos[0][0] == otherAnimal.pos[0][0]) && (animal.pos[0][1] == otherAnimal.pos[0][1])) {
		            newAnimals.add((animal instanceof Bears) ? new Bears() : new Fish());
		            animal.movePos();
		        }
		    }
		}
		
		animals.addAll(newAnimals);
		
		for ( int i = 0; i < 10; i++) {
			for (int k = 0; k < 10; k++) {
				System.out.print(grid[i][k]);
			}
			System.out.println();
		}
		System.out.println("==========");
	}
	
	public void moveAnimals() {
		for (Animal animal : animals) {
			animal.movePos();
		}
		updateGrid();
	}
	
	public void addAnimal() {
		animals.add(new Bears());
		animals.add(new Fish());
	}

}
