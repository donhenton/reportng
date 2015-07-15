#How to use ReportNG
 

Using the maven pom file here, issue this command:

```mvn clean install -Pbuild```

To use the reporting plug-in, set the "listeners" attribute of the "testng"
element in your Ant build file.  This attribute takes a comma-separated list of
reporter class names.  The class names for the ReportNG reporters are:

  ```org.uncommons.reportng.HTMLReporter```
  ```org.uncommons.reportng.JUnitXMLReporter```

You may also want to disable the default TestNG reporters by setting the
"useDefaultListeners" attribute to "false".

Your Ant task will probably look something like this:

  ```
  <testng classpathref="test-path"
          outputdir="${test-results.dir}"
          haltonfailure="true"
          useDefaultListeners="false"
          listeners="org.uncommons.reportng.HTMLReporter">
    <xmlfileset dir="." includes="testng.xml"/>
    <sysproperty key="org.uncommons.reportng.title" value="My Test Report"/>
  </testng>
  ```


If you are not using Ant to run TestNG (i.e. you are using Maven, the command
line or an IDE plug-in), please refer to the TestNG documentation
<http://testng.org/doc/documentation-main.html#running-testng> to find out how
to register custom listeners/reporters.


### Supported System Properties
---

The following optional system properties can be set (via nested "<sysproperty>"
elements within the "<testng>" element) in order to customise the report
output:

*  **org.uncommons.reportng.coverage-report**
      A relative or absolute URL that links to a test coverage report.

*  **org.uncommons.reportng.escape-output**
      Used to turn off escaping for log output in the reports (not
      recommended).  The default is for output to be escaped, since this
      prevents characters such as '<' and '&' from causing mark-up problems.
      If escaping is turned off then log text is included as raw HTML/XML,
      which allows for the insertion of hyperlinks and other nasty hacks.

*  **org.uncommons.reportng.failures-only**
      Defaults to "false".  If set to "true" the HTML report will exclude tests
      that completed without failures.

*  **org.uncommons.reportng.frames**
      Defaults to "true".  If set to "false" generates the HTML report without
      using a frameset.  No navigation page is generated and the overview page
      becomes the index page.

*  **org.uncommons.reportng.locale**
      Over-rides the default locale for localised messages in generated
      reports.  If not specified, the JVM default locale is used.  If there are
      no translations available for the selected locale the default English
      messages are used instead.  This property should be set to an ISO
      language code (e.g. "en" or "fr") or to an ISO language code and an ISO
      country code separated by an underscore (e.g. "en_US" or "fr_CA").

*  **org.uncommons.reportng.show-expected-exceptions**
      Set to "true" or "false" to specify whether the stack-traces of expected
      exceptions should be included in the output for passed test cases.  The
      default is "false" because the presence of stack-traces for successful
      tests may be confusing.

*  **org.uncommons.reportng.stylesheet**
      The path to a custom CSS file that over-rides some or all of the default
      styles used by the HTMLReporter.  This allows the appearance of reports
      to be customised.  See the default stylesheet for the classes and
      selectors that can be styled.  For an example, see this version of the
      sample report, which uses the bundled hudsonesque.css file to customise
      the report's appearance.

*  **org.uncommons.reportng.title**
      Used to over-ride the report title.

*  **org.uncommons.reportng.velocity-log**
      Since version 1.1.3, ReportNG will no longer generate a Velocity log file
      by default.  If you want a log file you should set this property to
      "true".

*  **org.uncommons.reportng.xml-dialect**
      Controls the XML generated by JUnitXMLReporter.  If set to "testng" (the
      default) then skipped tests appear as "skipped" in the XML.  This is
      suitable for use with tools such as Hudson that understand the TestNG
      dialect of the XML format. Other tools, such as Ant's junitreport task,
      do not have a notion of skipped tests.  For these tools the dialect can
      be set to "junit" and skipped tests will be marked as failures.
