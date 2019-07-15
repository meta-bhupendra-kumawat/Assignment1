/* This a component class for Job Scheduler.
 * It consists of functions used for calculating Execution time, Turn Around time & Job Completion time.
 */
public class JobScheduler {
	// Prints the Jobs along with their Arrival time.
	/**
	 * @param jobArray
	 */
	public void printJobs(int jobArray[][]) {
		System.out.println("Job no. \t Arrival time \t\t Burst time ");
		for (int i = 0; i < jobArray.length; i++) {
			System.out.println((i + 1) + "\t\t " + jobArray[i][0] + " \t\t\t "
					+ jobArray[i][1]);
		}
	}

	/* Prints the jobs with their Execution Sequence with their corresponding
	 * Arrival, Burst, Completion, Waiting and Turn Around Time.
	 */
	/**
	 * @param jobArray
	 * @param compTime
	 * @param waitingTime
	 * @param turnAroundTime
	 */
	public void printJobDetails(int jobArray[][], int compTime[],
			int waitingTime[], int turnAroundTime[]) {
		System.out.println("\n\nSequence \t Arrival time \t\t Burst time \t\t "
				+ "Completion time \t\t Waiting time \t\t Turn around time ");
		for (int i = 0; i < jobArray.length; i++) {
			System.out.println((i + 1) + " \t\t " + jobArray[i][0] + " \t\t\t "
					+ jobArray[i][1] + " \t\t\t " + compTime[i] + " \t\t\t\t "
					+ waitingTime[i] + " \t\t\t " + turnAroundTime[i]);
		}
	}

	/* Calculating the Completion time for each job and returns an array of
	 * Completion Time.
	 */
	/**
	 * @param jobArray
	 * @return
	 */
	public int[] completionTime(int jobArray[][]) {
		int compTime[] = new int[jobArray.length];
		for (int i = 0; i < jobArray.length; i++) {
			if (i != 0 && compTime[i - 1] > jobArray[i][0]) {
				compTime[i] = compTime[i - 1] + jobArray[i][1];
			} else {
				compTime[i] = jobArray[i][0] + jobArray[i][1];
			}
		}
		return compTime;
	}

	/* Calculates the Waiting Time for each job and returns an array of Waiting
	 * Time.
	 */
	/**
	 * @param jobArray
	 * @param compTime
	 * @return
	 */
	public int[] waitingTime(int jobArray[][], int compTime[]) {
		int waitingTime[] = new int[jobArray.length];
		for (int i = 0; i < jobArray.length; i++) {
			if (i == 0 || jobArray[i][0] > compTime[i - 1]) {
				waitingTime[i] = 0;
			} else {
				waitingTime[i] = compTime[i - 1] - jobArray[i][0];
			}
		}
		return waitingTime;
	}

	/* Calculates the Waiting Time for each job and returns an array of Turn
	 * Around Time.
	 */
	/**
	 * @param jobArray
	 * @param compTime
	 * @return
	 */
	public int[] turnAroundTime(int jobArray[][], int compTime[]) {
		int turnAroundTime[] = new int[jobArray.length];
		for (int i = 0; i < jobArray.length; i++) {
			turnAroundTime[i] = compTime[i] - jobArray[i][0];
		}
		return turnAroundTime;
	}

	// Calculates and returns the Average Waiting Time.
	public double avgWaitingTime(int waitingTime[]) {
		double average = 0;
		for (int i : waitingTime) {
			average = average + i;
		}
		average = average / waitingTime.length;
		return average;
	}

	/* Sorts the jobs according to their Arrival Time in First Come First Serve
	 * (FCFS) basis.
	 */
	/**
	 * @param jobArray
	 */
	public void sortJobs(int jobArray[][]) {
		for (int i = 0; i < jobArray.length; i++) {
			for (int j = i; j < jobArray.length; j++) {
				if (jobArray[i][0] > jobArray[j][0]) {
					jobArray[i][0] = jobArray[i][0] + jobArray[j][0];
					jobArray[j][0] = jobArray[i][0] - jobArray[j][0];
					jobArray[i][0] = jobArray[i][0] - jobArray[j][0];

					jobArray[i][1] = jobArray[i][1] + jobArray[j][1];
					jobArray[j][1] = jobArray[i][1] - jobArray[j][1];
					jobArray[i][1] = jobArray[i][1] - jobArray[j][1];
				}
			}
		}
	}

	// Returns the Maximum waiting Time
	/**
	 * @param waitingTime
	 * @return
	 */
	public int maxWaitingtime(int waitingTime[]) {
		int maxTime = 0;
		for (int i = 0; i < waitingTime.length; i++) {
			if (waitingTime[i] > maxTime)
				maxTime = waitingTime[i];
		}
		return maxTime;
	}
}
