# TestRail API Java Client
--------------------------
A Java client library for [TestRail API](http://docs.gurock.com/testrail-api2/start).

## Quick Start
--------------

### Example Usage
```
// create a TestRail instance
TestRail testRail = TestRail.builder("https://some.testrail.net/", "username", "password").applicationName("playground").build();

// create a new project
Project project = testRail.projects().add(new Project().setName("Playground Project")).execute();

// add a new test suite
Suite suite = testRail.suites().add(project.getId(), new Suite().setName("Functional Tests")).execute();

// add a new section
Section section = testRail.sections().add(project.getId(), new Section().setSuiteId(suite.getId()).setName("Boundary Cases")).execute();

// add a test case
List<CaseField> customCaseFields = testRail.caseFields().list().execute();
Case testCase = testRail.cases().add(section.getId(), new Case().setTitle("Be able to play in playground"), customCaseFields).execute();

// add a new test run
Run run = testRail.runs().add(project.getId(), new Run().setSuiteId(suite.getId()).setName("Weekly Regression")).execute();

// add test result
List<ResultField> customResultFields = testRail.resultFields().list().execute();
testRail.results().addForCase(run.getId(), testCase.getId(), new Result().setStatusId(1), customResultFields).execute();

// close the run
testRail.runs().close(run.getId()).execute();

// complete the project - supports partial updates
testRail.projects().update(project.setCompleted(true)).execute();
```


### Custom Case And Result Fields
TestRail supports adding custom case and result fields. The request interfaces in ```TestRail.Cases``` and ```TestRail.Results``` requires a list of these fields in order to allow this library to map them to the correct Java types. Here's an example where we want to to know the separated test steps of a particular test case:
```
// fetch list of custom case field configured in TestRail
List<CaseField> customCaseFields = testRail.caseFields().list().execute();

// get test case
Case testCase = testRail.cases().get(1, customCaseFields).execute();

// assuming separated_steps is a custom TestRail Steps type case field
List<Field.Step> customSteps = testCase.getCustomField("separated_steps");

// work with typed customSteps
......
```

License
----------
This project is licensed under [MIT license](http://opensource.org/licenses/MIT).
