package bully;

import java.util.Scanner;

public class BullyAlgorithm {

	public static void main(String[] args) {
		System.out.println("Enter no of processes : ");

		Scanner sc = new Scanner(System.in);
		int noOfProcess = sc.nextInt();


		BullyClass bully = new BullyClass(noOfProcess);


		while(true) {
			System.out.println("\nEnter choice : \n1) Up process \n2) Down process \n3) Hold election \n4) Exit\nChoice : ");

			int choice = sc.nextInt();

			if(choice == 4) 
				break;

			switch(choice) {

				case 1 : 
					System.out.println("Process Id : ");
					int temp = sc.nextInt();
					bully.up(temp);
					break;

				case 2 : 
					System.out.println("Process Id : ");
					int temp1 = sc.nextInt();
					bully.down(temp1);
					break;

				case 3 : 
					bully.holdElection();
			}

		}
		sc.close();
	}

}
