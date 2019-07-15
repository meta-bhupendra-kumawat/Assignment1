import java.util.Scanner;

/* The Execution starts form here.
 * This is an Application Class for Job Scheduler.
 */
public class UseJobScheduler {

	public static void main(String[] args) {
		// JobScheduler object to use its instance methods.
		JobScheduler js = new JobScheduler();

		// Scanner class object for user input at runtime.
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter numbers of jobs:");
		int n = sc.nextInt(); // Variable to store number of jobs

		/* Array to store Job's Arrival time along with their correponding Burst
		 * Time.
		 */
		int job[][] = new int[n][2];

		/* Taking Job's Arrival Time and Burst time as input from user and
		 * storing it in job array.
		 */
		System.out.println("Enter jobs arrival time and burst time:");
		for (int i = 0; i < job.length; i++) {
			System.out.println("Enter Arrival time: ");
			job[i][0] = sc.nextInt();
			System.out.println("Enter Burst time: ");
			job[i][1] = sc.nextInt();
		}

		// Printing user input that is Job's Arrival Time and Burst Time.
		js.printJobs(job);

		// Sorting the Jobs (job array) on the basis of their Arrival Time.
		js.sortJobs(job);

		// Storing Completion time of job in array.
		int compTime[] = js.completionTime(job);  
		
		// Storing Waiting time of job in array
		int waitingTime[] = js.waitingTime(job, compTime);
		
		// Storing Turn Around time of job inarray
		int turnAroundTime[] = js.turnAroundTime(job, compTime);

		/* Printing jobs with their Arrival, Burst, Completion , Waiting & Turn
		 * Around Time.
		 */
		js.printJobDetails(job, compTime, waitingTime, turnAroundTime);
		
		// Average Waiting time.
		System.out.println("\nAverage Waiting time: "+ js.avgWaitingTime(waitingTime));
		
		// Maximum Waiting time.
		System.out.println("Max waiting time period: "+ js.maxWaitingtime(waitingTime));
		sc.close();
	}

}
