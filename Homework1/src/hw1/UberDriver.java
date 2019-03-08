package hw1;



public class UberDriver {

	private double credits;
	//counter for amount of uber credits
	private int tmiles;
	//total miles of trip
	private int tminutes;
	//total minutes of trip
	private int passengers;
	//counter for number of passengers
	private double profit;
	//profit acumulated for uber driver
	private double mileRate;
	//allows givenPerMileRate to be private for methods
	private double minRate;
	//allows givenPerMinuteRate to be private for methods
	public static final int MAX_PASSENGERS = 4;
	//Maximum number of passengers allowed in the vehicle at one time.
	 
	public static final double OPERATING_COST = 0.5;
	//Cost to operate the vehicle per mile.
	
	/**
	 * Constructs an UberDriver with the given per-mile rate and per-minute rate.
	 * Sets the given's for rates for method use
	 * @param givenPerMileRate
	 * @param givenPerMinuteRate
	 */
	public UberDriver(double givenPerMileRate, double givenPerMinuteRate) {
		mileRate = givenPerMileRate;
		minRate = givenPerMinuteRate;
	}

	/**
	 * Returns the total miles driven since this UberDriver was constructed.
	 * @return
	 */
	public int getTotalMiles() {

		return tmiles;
	}

	/**
	 * Returns the total minutes driven since this UberDriver was constructed.
	 * @return
	 */
	public int getTotalMinutes() {

		return tminutes;
	}

	
	/**
	 * Drives the vehicle for the given number of miles over the given number of minutes.
	 * Takes inputed miles and minutes and adds it to the total variables
	 * Multiples miles and minutes to its rate sums the two and multiplies to the number of passengers then adds the value to the credit
	 * Profit is calculated by taking the operating cost and multiplies the value with total miles and subtracting from credits
	 * 
	 * @param miles
	 * @param minutes
	 */
	public void drive(int miles, int minutes) {

		tmiles = tmiles + miles;
		tminutes = tminutes + minutes;
		credits += passengers*((mileRate*miles) + (minRate*minutes));
		profit = credits - (OPERATING_COST * tmiles);

	}
	/**
	 * sets drive method to 0 miles while keeping minutes
	 * @param minutes
	 */
	public void waitAround(int minutes) {
		drive(0, minutes);

	}
	/**
	 * total miles is added to miles
	 * Average speed is tested for value under 0
	 * average speed is multiplied by 60 and divided by miles set to equal double x
	 * double x is rounded and set to equal int m
	 * int m is added to total minutes
	 * number of passengers is multiplied to the sum of the multiples of (mile rate and number of miles) and (minute rate and int m)
	 * @param miles
	 * @param averageSpeed
	 */
	public void driveAtSpeed(int miles, double averageSpeed) {
		double x;
		tmiles = tmiles + miles;
		if (averageSpeed < 0){	

		}
		else {
			x = (miles / averageSpeed)*60;
			int m = (int) Math.round(x);
			tminutes = tminutes + m;
			credits += passengers*((mileRate*miles) + (minRate*m));
		}

	}

	
	/**
	 * returns passengers
	 * @return
	 */
	public int getPassengerCount() {
		
		return passengers;
	}

	/**
	 * checks if passengers exceeds its max of 4
	 * adds 1 to passenger count
	 */
	public void pickUp() {

		if (passengers >= MAX_PASSENGERS) {

		}
		else {
			passengers++;
		}
	}

	/**
	 * checks if passengers = 0 if not passengers is subtracted by 1
	 */
	public void dropOff() {

		if (passengers == 0) {	

		}
		else {

			passengers--;
		}
	}

	
	/**
	 * if total miles exceeds 10  while total minutes less than 5. credits is added by 5.
	 * @return
	 */
	public double getTotalCredits() {

		if(tmiles >= 10 && tminutes <= 5) {

			credits = credits + 5;
			return credits;
		}
		return credits;
	}

	/**
	 * returns profit
	 * @return
	 */
	public double getProfit() {

		return profit;
	}

	
	/**
	 * profit per hour is calculated by profit divided by total minutes  and converted hours and return as pph
	 * @return
	 */
	public double getAverageProfitPerHour() {
		
		double pph = (profit/tminutes) * 60;

		return pph;

	}

}