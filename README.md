# CS 1632 - Software Quality Assurance
Fall Semester 2016  
DUE 11 OCT 2016  

## Deliverable 2

For this assignment, you (not a group) will write code and unit tests for CitySim9003.

Requirements for this program are in the requirements.txt file in this directory.  Sample output is also provided for several runs of the program.  In case of ambiguity, please see the sample output as an example of what to display and how the system should work.  Note that the sample output shows specific routes for given seeds - you do NOT have to have your seeds create the routes.  They are purely for demonstration purposes.

All code and tests should be on GitHub or GitLab in a private repository accessible to me.

## Format
You should turn in a title page with:
* Your name
* The URL of your code and tests on GitHub or GitLab
* The title "CS 1632 - DELIVERABLE 2: Unit Testing CitySim9003"

ENSURE THAT THE ADAM (THE TA) AND I ARE ADDED AS A COLLABORATOR AND CAN CLONE YOUR REPOSITORY!  My username is laboon on both GitHub.  The TA's username is greenmanspirit.  You will lose an automatic 10 points if either I or the TA cannot access your repository.  If you are using GitLab instead of GitHub, please just add me as a collaborator (username is still laboon).

Add a short ( < 1 page ) description of issues you faced when writing this code and tests.  If any tests you wrote fail, they should be included here, along with why you think that they are failing.

After this, ON A SEPARATE PAGE, include a screen shot of the executed unit tests.    If a test doesn't pass, it should be included in the concerns section above.  Ideally, for a perfect grade, all tests should be green (passing).  However, if you have what you think is a valid test and it is not passing, I would prefer that you include a note (and perhaps comment out the tests) rather than just deleting it.  Knowing that a defect exists and reporting it is much better than having it discovered by the customer (me)!

There is no need to print out the code.  It should be on GitHub (or GitLab) BY THE BEGINNING OF CLASS.

At least three (3) unit tests should use test doubles and/or mocks.

At least three (3) unit tests should use stubbing of methods.

I expect unit tests for AT LEAST each public method that returns a value (excluding the main method), using a variety of assertions and looking at different failure modes and edge cases.  Keep in mind some of the things we learned when doing manual testing; you should be cognizant of equivalence classes, boundary values, etc. and focus on them.

The program should use appropriate object-oriented design.  Think of what objects could possibly exist to describe this world, and what methods they should have.  Do not attempt to do this entirely with static methods and variables, without classes, etc.  It is possible but will make testing more difficult!

If you are not familiar with seeds for random number generators, recall that in the absence of external input, a computer can only generate data deterministically.  This seed will act as our "external input".  Please review the Java Random API for more details to ensure that you are using seeds correctly - https://docs.oracle.com/javase/7/docs/api/java/util/Random.html.  You may use Random or a different random number generator if you prefer.  However, running the program twice with the same seed should always produce the same output.

Before each test, add some comments (two or three sentences, on average) explaining what the test is checking.  For example...

```java
	// Two LLs with different sizes should never be equal.
	// Create two linked lists, both of which have the same value in the initial node,
	// but one has several more nodes. 
	// They should not be equal to each other.
		@Test
		public void testNotEqualsDiffSizes() {
			LinkedList<Integer> ll11 = new LinkedList<Integer>();
			LinkedList<Integer> ll_3elems = new LinkedList<Integer>();

			ll11.addToFront(new Node<Integer>(new Integer(1)));
			ll_3elems.addToFront(new Node<Integer>(new Integer(3)));
			ll_3elems.addToFront(new Node<Integer>(new Integer(2)));
			ll_3elems.addToFront(new Node<Integer>(new Integer(1)));

			assertFalse(ll_3elems.equals(ll11));
		}
```

## Grading
I remind you that grammar and good code count as well as functionality.  By good code, I mean -

No commented-out code unless there's an EXPLICIT reason, e.g.
```java
// I couldn't get this assertion to work, but instead used a different assertion, below
// assertEquals(foo, 3);
assertTrue(foo == 3);
```

Properly indented code, e.g.
```java
public void doSomething() {
    doStuff();
}
```
NOT
```java
public
  void
                     doSomething()
{ doStuff(); }
```

Don't misspell words or use bad grammar, in comments or summaries.

For this project, you should endeavour to get a good sampling of different equivalence classes and success/failure cases.

## Grading Breakdown
* Summary and Testing Concerns- 10%
* Screenshot of executed unit tests - 10%
* Program Code - 40%
* Test Code - 40%

Please feel free to email me or come to office hours to discuss any problems you have. 
 
 ## CitySim9003 Requirements

FUN-CITY-LOCS. The program shall simulate a city with four locations: Hotel, Diner, Library, and Coffee.

FUN-OUTSIDE-CITY. A fifth location, Outside City, shall stand for a driver outside the city limits.

FUN-AVENUES. The city shall have two one-way avenues, Fourth Ave and Fifth Ave.  Fourth Ave shall connect, in order, Outside City -> Hotel -> Diner -> Outside City.  Fifth Ave shall connect, in order, Outside City -> Coffee -> Library -> Outside City.

FUN-STREETS. The city shall have two two-way streets, Bill St. and Phil St.  Bill St. shall connect Hotel and Library.  Phil St. shall connect Diner and Coffee.

FUN-FIVE-DRIVERS. Five drivers, numbered 1 through 5, shall traverse the city, one after the other.

FUN-COFFEE-COUNT. At the end of each drive, the simulation shall print out how many times that driver visited Coffee.  The format shall be "Driver `n` got `x` cup(s) of coffee.", where `n` is the driver number (1 through 5) and `x` is the number of times that the driver visited the Coffee location.  If a driver starts on the Coffee location, this counts as a time visiting the coffee shop.  This shall be the last line printed out for each iteration.

FUN-START-LOC. A driver may start in any of the four locations listed in FUN-CITY-LOCS.  Drivers may not start outside of the city.

FUN-ITERATION. At each iteration, a Driver will drive from the current Location to one of the possible Locations that can be reached from the original Location.  The decision shall be made pseudorandomly based on a seed passed in from the command line, as covered by FUN-ARGS.

FUN-END. The simulation shall end if a Driver encounters the Outside City Location.

FUN-ARGS. The system shall accept an integer seed from the command line for the pseudorandom number generator.  No other arguments shall be accepted.  If no arguments are provided,  more than one argument is provided, or the single argument is not an integer, the system shall inform the user and exit.

FUN-OTHER-CITIES. If a driver exits the city via Fourth Avenue (that is, goes to the Outside City location past the Diner), then the program shall display that the driver has gone to Philadelphia.  If a driver exits the city via Fifth Avenue (that is, goes to the Outside City location past the Library), then the program shall display that the driver has gone to Cleveland.

It may be easier to understand the map of the city visually.

```
City Map
	
                ---> [Hotel] ----> [Diner] ----> Fourth Ave. (to Philadelphia)
                      A  |          A  |
              Bill St.|  |          |  | Phil St.
                      |  V          |  V
 (to Cleveland) <--- [Library] <-- [Coffee] <--- Fifth Ave.
```	

#Grade Received: C
