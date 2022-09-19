
package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class LearnHooks {

	@Before
	public void beforeScenario(Scenario sc) {
		System.out.println("Test case name from hooks "+sc.getName());
	}
	
	@After
	public void afterScenario(Scenario sc) {
		System.out.println("Test case status from hooks "+sc.getStatus());	
	}
}
