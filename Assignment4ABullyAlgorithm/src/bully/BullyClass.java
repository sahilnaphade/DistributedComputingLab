package bully;

import java.util.ArrayList;
import java.util.Scanner;

public class BullyClass {
	private int noOfProcess;
	private ArrayList<Boolean> state = new ArrayList<Boolean>();
	private int leader;

	public BullyClass(int noOfProcess) {
		this.noOfProcess = noOfProcess;
		for(int i=0;i<noOfProcess;i++) {
			state.add(true);
		}
		System.out.println("\nCreated " + noOfProcess + " process");
	}

	public void up(int processId) {

		if(state.get(processId-1)) {
			System.out.println("\nProcess " + processId + " is already active");		
		}
		else {
			int highestActiveProcess = processId-1 ;
			state.set(processId-1,true);
			System.out.println("\nProcess " + processId + " held election");
			
			for(int i = processId;i<noOfProcess;i++) {
				System.out.println("Election msg sent from " + processId + " to process " + (i+1));
			}

			System.out.println("\n");

			for(int i=processId;i<noOfProcess;i++) {
				if(state.get(i)) {
					System.out.println("Alive msg sent from process " + (i+1) + " to process " + processId);
					highestActiveProcess = i;
				}
			}

			leader = highestActiveProcess + 1;

			System.out.println("\nElected Leader : Prcess " + leader);
			
		}

	}
	
	public void down(int processId) {
		state.set(processId-1,false);
		System.out.println("\nProcess " + processId + " went down");
		if(leader == processId) {
			holdElection();
		}
	}

	public void holdElection() {

		Scanner sc = new Scanner(System.in);
		int processId;

		while(true) {

			System.out.println("\nCoordination Process : ");
			processId = sc.nextInt();

			if(state.get(processId-1)) {
				break;
			}

			System.out.println("\nProcess " + processId + " is down...Select another process to hold election");
		}

		System.out.println("Process " + processId + " held election");

		int highestActiveProcess = processId-1 ;
			
		for(int i = processId;i<noOfProcess;i++) {
			System.out.println("Election msg sent from " + processId + " to process " + (i+1));
		}

		System.out.println("\n");

		for(int i=processId;i<noOfProcess;i++) {
			if(state.get(i)) {
				System.out.println("Alive msg sent from process " + (i+1) + " to process " + processId);
				highestActiveProcess = i;
			}
		}
		for(int i = processId; i < noOfProcess; i++) {
			if(!state.get(i)) {
				System.out.println("Process " + (i+1) + " is down!");
			}
		}
		leader = highestActiveProcess + 1;

		System.out.println("\nElected Leader : Process " + leader);
		sc.close();
	}
}
