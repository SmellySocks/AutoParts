package pl.hyla.labone.bdd;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pl.hyla.labone.domain.autoPart;
import pl.hyla.labone.repository.AutoPartRepoImpl;

import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;

public class PartBddSteps {
    private autoPart autoPart;
    private AutoPartRepoImpl service;

    @Given ("a part")
    public void autoPartSetup() throws SQLException{
        autoPart = new autoPart();
        service = new AutoPartRepoImpl();
    }
    @When("set arguments like name: $a, price: $b")
    public void createNewPart(String a, Integer b){
        autoPart.setPartName(a);
        autoPart.setPrice(b);
    }
    @When("add it to arrayList")
    public void addToArrayList() {
        service.addAutoPart(autoPart);
    }
    @Then("adding should return $name for AutoPart object with code $code")
    public void shouldAdd(String name, String code) throws SQLException {
        autoPart autoPart = service.getByName(name);
        assertEquals(code, autoPart.getPartName());
    }
    @Then("destroy item with code $code")
    public void destroy(String code) throws SQLException{
        autoPart p1 = service.getByName(code);
        service.deleteAutoPart(p1);
    }
}
